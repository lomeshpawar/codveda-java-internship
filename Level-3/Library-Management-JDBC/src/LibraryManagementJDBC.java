import java.sql.*;
import java.util.Scanner;

public class LibraryManagementJDBC {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createTables();

        while (true) {
            System.out.println("\n=== Library Management System (JDBC) ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Issued Books");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> viewBooks();
                    case 3 -> addMember();
                    case 4 -> issueBook();
                    case 5 -> returnBook();
                    case 6 -> viewIssuedBooks();
                    case 7 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void createTables() {
        String books = "CREATE TABLE IF NOT EXISTS books (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "title VARCHAR(150) NOT NULL," +
                "author VARCHAR(100) NOT NULL," +
                "available BOOLEAN DEFAULT TRUE)";

        String members = "CREATE TABLE IF NOT EXISTS members (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(150) UNIQUE NOT NULL)";

        String issues = "CREATE TABLE IF NOT EXISTS issues (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "book_id INT NOT NULL," +
                "member_id INT NOT NULL," +
                "issue_date DATE NOT NULL," +
                "return_date DATE," +
                "FOREIGN KEY (book_id) REFERENCES books(id)," +
                "FOREIGN KEY (member_id) REFERENCES members(id))";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(books);
            st.executeUpdate(members);
            st.executeUpdate(issues);
            System.out.println("Database ready.");
        } catch (SQLException e) {
            System.out.println("Could not initialize database: " + e.getMessage());
        }
    }

    private static void addBook() throws SQLException {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();

        String sql = "INSERT INTO books(title, author) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();
            System.out.println("Book added.");
        }
    }

    private static void viewBooks() throws SQLException {
        String sql = "SELECT id, title, author, available FROM books ORDER BY id";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available") ? "Available" : "Issued");
            }
        }
    }

    private static void addMember() throws SQLException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO members(name, email) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("Member added.");
        }
    }

    private static void issueBook() throws SQLException {
        System.out.print("Book ID: ");
        int bookId = readInt();
        System.out.print("Member ID: ");
        int memberId = readInt();

        String check = "SELECT available FROM books WHERE id = ?";
        String insert = "INSERT INTO issues(book_id, member_id, issue_date) VALUES (?, ?, CURRENT_DATE)";
        String update = "UPDATE books SET available = FALSE WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(check)) {
                ps.setInt(1, bookId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next() || !rs.getBoolean("available")) {
                        System.out.println("Book not available.");
                        con.rollback();
                        return;
                    }
                }
            }

            try (PreparedStatement ps = con.prepareStatement(insert)) {
                ps.setInt(1, bookId);
                ps.setInt(2, memberId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(update)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            con.commit();
            System.out.println("Book issued.");
        }
    }

    private static void returnBook() throws SQLException {
        System.out.print("Book ID: ");
        int bookId = readInt();

        String findIssue = "SELECT id FROM issues WHERE book_id = ? AND return_date IS NULL ORDER BY id DESC LIMIT 1";
        String returnSql = "UPDATE issues SET return_date = CURRENT_DATE WHERE id = ?";
        String bookSql = "UPDATE books SET available = TRUE WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            Integer issueId = null;

            try (PreparedStatement ps = con.prepareStatement(findIssue)) {
                ps.setInt(1, bookId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) issueId = rs.getInt("id");
                }
            }

            if (issueId == null) {
                System.out.println("No active issue found for this book.");
                con.rollback();
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(returnSql)) {
                ps.setInt(1, issueId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(bookSql)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            con.commit();
            System.out.println("Book returned.");
        }
    }

    private static void viewIssuedBooks() throws SQLException {
        String sql = "SELECT i.id, b.title, m.name, i.issue_date, i.return_date " +
                "FROM issues i JOIN books b ON i.book_id=b.id " +
                "JOIN members m ON i.member_id=m.id ORDER BY i.id";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("Issue %d | Book: %s | Member: %s | Issued: %s | Returned: %s%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("name"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date"));
            }
        }
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }
}
