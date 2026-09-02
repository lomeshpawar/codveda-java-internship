# Library Management System - JDBC

## Requirements
- JDK 17+
- MySQL 8+
- MySQL Connector/J

## 1. Create database
Run in MySQL:
```sql
CREATE DATABASE library_db;
```

## 2. Configure credentials
Open `src/DBConnection.java` and change:
```java
private static final String USER = "root";
private static final String PASSWORD = "root";
```

## 3. Add MySQL JDBC driver
Download MySQL Connector/J and place the `.jar` in this project folder.

### Windows PowerShell example
Assuming the driver is `mysql-connector-j-9.x.x.jar`:
```powershell
javac -cp ".;mysql-connector-j-9.x.x.jar" src/*.java
java -cp ".;src;mysql-connector-j-9.x.x.jar" LibraryManagementJDBC
```

## Features
- Add books
- View books
- Add members
- Issue books
- Return books
- View issue history
- Prepared statements
- Transactions
- Foreign-key relationships
