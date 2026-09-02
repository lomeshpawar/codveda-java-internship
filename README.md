# Codveda Java Internship Projects

A professional collection of Java projects completed during the **Codveda Java Internship**, progressing from core programming fundamentals to OOP, database integration, and multithreaded networking.

## 📌 Project Overview

| Level | Project | Key Concepts |
|---|---|---|
| Level 1 | [Basic Calculator](Level-1/Basic-Calculator/) | Java fundamentals, input handling, arithmetic operations |
| Level 1 | [Number Guessing Game](Level-1/Number-Guessing-Game/) | Random numbers, loops, conditions, validation |
| Level 2 | [Employee Management System](Level-2/Employee-Management-System/) | OOP, collections, CRUD operations |
| Level 2 | [Banking Application](Level-2/Banking-Application/) | OOP, encapsulation, transactions, validation |
| Level 3 | [Library Management JDBC](Level-3/Library-Management-JDBC/) | JDBC, MySQL, SQL, transactions |
| Level 3 | [Multithreaded Chat](Level-3/Multithreaded-Chat/) | Socket programming, client-server architecture, multithreading |

## 🛠️ Technology Stack

- **Java / JDK 17+**
- **MySQL 8+** for the JDBC project
- **JDBC** for database connectivity
- **Java Socket Programming** for networking
- **Git & GitHub** for version control

## 🗂️ Repository Structure

```text
codveda-java-internship/
├── Level-1/
│   ├── Basic-Calculator/
│   │   ├── src/
│   │   ├── screenshots/
│   │   └── README.md
│   └── Number-Guessing-Game/
│       ├── src/
│       ├── screenshots/
│       └── README.md
├── Level-2/
│   ├── Employee-Management-System/
│   └── Banking-Application/
├── Level-3/
│   ├── Library-Management-JDBC/
│   └── Multithreaded-Chat/
├── .gitignore
├── LICENSE
└── README.md
```

## 🚀 Getting Started

```bash
git clone https://github.com/lomeshpawar/codveda-java-internship.git
cd codveda-java-internship
```

Choose a project, open its `src` directory, compile with JDK 17+, and run its main class. Each project has its own README with project-specific details.

Example:

```bash
cd Level-1/Basic-Calculator/src
javac BasicCalculator.java
java BasicCalculator
```

## 🗃️ Level 3 — JDBC Configuration

The Library Management System requires a MySQL database named `library_db`.

Set the following environment variables before running:

```text
LIBRARY_DB_URL=jdbc:mysql://localhost:3306/library_db
LIBRARY_DB_USER=root
LIBRARY_DB_PASSWORD=your_mysql_password
```

The application creates its required tables automatically. **Never commit database passwords, API keys, or other secrets to GitHub.**

## 📸 Screenshots

Each project includes a `screenshots/` directory containing representative terminal output from successful execution/testing.

## 🎯 Learning Progression

1. Core Java and console input/output
2. Control flow, validation, and randomization
3. Object-oriented programming and collections
4. CRUD-style application logic
5. JDBC, SQL, and database transactions
6. Client-server networking and multithreading

## 👨‍💻 Author

**Lomesh Pawar**  
GitHub: [@lomeshpawar](https://github.com/lomeshpawar)

## 📄 License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

---

*Completed as part of the Codveda Java Internship.*
