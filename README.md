# Codveda Java Internship Projects

[![Java CI](https://github.com/lomeshpawar/codveda-java-internship/actions/workflows/level3-test.yml/badge.svg)](https://github.com/lomeshpawar/codveda-java-internship/actions/workflows/level3-test.yml)

A structured collection of **Java internship projects completed for Codveda**, progressing from programming fundamentals to object-oriented programming, database integration, networking, and multithreading.

## Project Portfolio

| Level | Project | Main Concepts |
|---|---|---|
| 1 | [Basic Calculator](Level-1/Basic-Calculator/) | Input handling, operators, `switch`, validation |
| 1 | [Number Guessing Game](Level-1/Number-Guessing-Game/) | Randomization, loops, conditions, validation |
| 2 | [Employee Management System](Level-2/Employee-Management-System/) | OOP, encapsulation, collections, CRUD |
| 2 | [Banking Application](Level-2/Banking-Application/) | OOP, encapsulation, transactions, validation |
| 3 | [Library Management JDBC](Level-3/Library-Management-JDBC/) | JDBC, MySQL, SQL, prepared statements, transactions |
| 3 | [Multithreaded Chat](Level-3/Multithreaded-Chat/) | TCP sockets, client-server architecture, multithreading |

## Technology Stack

- **Java / JDK 17+**
- **MySQL 8+** — Library Management System
- **JDBC / MySQL Connector/J** — database connectivity
- **Java Socket API** — client-server communication
- **Git & GitHub** — version control and CI

## Repository Structure

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
│   ├── Banking-Application/
│   │   ├── src/
│   │   ├── screenshots/
│   │   └── README.md
│   └── Employee-Management-System/
│       ├── src/
│       ├── screenshots/
│       └── README.md
├── Level-3/
│   ├── Library-Management-JDBC/
│   │   ├── src/
│   │   ├── screenshots/
│   │   └── README.md
│   └── Multithreaded-Chat/
│       ├── src/
│       ├── screenshots/
│       └── README.md
├── .github/workflows/level3-test.yml
├── .gitignore
├── LICENSE
└── README.md
```

## Getting Started

Clone the repository and enter the project directory:

```bash
git clone https://github.com/lomeshpawar/codveda-java-internship.git
cd codveda-java-internship
```

Each project is self-contained and includes its own README with compilation and execution instructions.

### Example — Basic Calculator

```bash
cd Level-1/Basic-Calculator
javac src/BasicCalculator.java
java -cp src BasicCalculator
```

### Level 3 — Library Management JDBC

Create the database in MySQL:

```sql
CREATE DATABASE library_db;
```

Set the database configuration through environment variables rather than storing credentials in source code:

```text
LIBRARY_DB_URL=jdbc:mysql://localhost:3306/library_db
LIBRARY_DB_USER=root
LIBRARY_DB_PASSWORD=your_mysql_password
```

See the [Library Management JDBC README](Level-3/Library-Management-JDBC/) for the complete Connector/J setup and run commands.

## Continuous Integration

The repository includes a GitHub Actions workflow that automatically:

- Compiles all six Java projects with JDK 17
- Tests calculator arithmetic and validation
- Tests the banking and employee applications
- Starts MySQL 8.4 and tests the JDBC application
- Runs a two-client socket test for the multithreaded chat
- Verifies that project documentation is present

The CI workflow is intentionally read-only and does not modify the repository during a test run.

## Screenshots & Execution Evidence

Each project contains a `screenshots/` directory with representative execution evidence. Level 3 also has automated CI coverage for database and networking functionality.

## Learning Progression

1. **Core Java** — console I/O and arithmetic
2. **Control Flow** — conditions, loops, randomization, validation
3. **Object-Oriented Programming** — classes, objects, encapsulation
4. **Application Logic** — CRUD operations and collections
5. **Database Programming** — JDBC, SQL, prepared statements, transactions
6. **Networking** — TCP sockets, client/server architecture, concurrency

## Author

**Lomesh Pawar**  
GitHub: [@lomeshpawar](https://github.com/lomeshpawar)

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

---

*Completed as part of the Codveda Java Internship.*
