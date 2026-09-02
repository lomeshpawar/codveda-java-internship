# Multithreaded Chat Application

A console-based client/server chat application using Java sockets and threads.

## Concepts
- TCP sockets
- Client/server architecture
- Multithreading
- ConcurrentHashMap
- BufferedReader / PrintWriter
- Thread-safe client collection

## Run

### Terminal 1 - Server
```bash
javac src/*.java
java -cp src ChatServer
```

### Terminal 2 - Client 1
```bash
java -cp src ChatClient
```

### Terminal 3 - Client 2
```bash
java -cp src ChatClient
```

Enter different usernames and exchange messages.

Type `/quit` to leave.

For a real deployment, add authentication, encryption, message persistence, validation, and proper logging.
