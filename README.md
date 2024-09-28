
```markdown
# Multithreaded HTML Server in Java

## Description

This project demonstrates a simple multithreaded server-client architecture in Java. The server reads and serves an HTML file (`index.html`) to multiple clients simultaneously. Each client sends an HTTP-like GET request to the server, which responds by sending the content of the HTML file. The server handles multiple clients concurrently using multithreading.

## How It Works

### Server (`Server.java`)
- The server listens on a specific port (`8010` in this example).
- When a client connects, the server creates a new thread to handle the request.
- The server reads the content of an HTML file (`index.html`) and sends it to the connected client.
- This allows the server to handle multiple client requests concurrently without blocking.

### Client (`Client.java`)
- The client creates 100 threads, each representing a separate connection to the server.
- Each thread sends an HTTP-like `GET` request to the server.
- The client receives and prints the server's response, which is the content of the `index.html` file.

### HTML File (`index.html`)
- A simple HTML file with a welcoming message.
- This file is read by the server and sent as a response to connected clients.

## Concepts Used

### Multithreading
- **Server**: The server uses a thread-per-client model. For each client connection, a new thread is spawned to handle the request. This allows the server to manage multiple clients concurrently.
- **Client**: The client also uses multiple threads to simulate multiple simultaneous connections to the server.

### Sockets
- The server uses a `ServerSocket` to listen for incoming client connections. Once a connection is established, a `Socket` object is created for communication with the client.
- The client uses a `Socket` to connect to the server and communicate over the network.

### I/O Streams
- The server reads the HTML file using `BufferedReader` and sends the content to the client through a `PrintWriter`.
- The client reads the server's response using `BufferedReader` and sends requests using `PrintWriter`.

## Running the Project

### Prerequisites
- Java Development Kit (JDK) installed on your system.

### Steps

1. **Compile the Java files:**
   ```bash
   javac ReadHtmlFile/Server.java ReadHtmlFile/Client.java
   ```

2. **Run the Server:**
   ```bash
   java ReadHtmlFile.Server
   ```
   The server will start listening on port `8010`.

3. **Run the Client:**
   ```bash
   java ReadHtmlFile.Client
   ```
   The client will create 100 threads, each connecting to the server and printing the server's response.

4. **Output:**
   - The client console will display the content of the `index.html` file for each thread, showing the server's response.

## File Structure
```
.
├── ReadHtmlFile/
│   ├── Server.java
│   ├── Client.java
├── index.html
└── README.md
```

- `ReadHtmlFile/Server.java`: Contains the server code.
- `ReadHtmlFile/Client.java`: Contains the client code.
- `index.html`: HTML file served by the server.
- `README.md`: Project documentation.

## Troubleshooting

1. **Port Already in Use Error:**
   - If you get an error that the port `8010` is already in use, change the port number in both `Server.java` and `Client.java` to a free port.

2. **File Not Found Error:**
   - Ensure the `index.html` file is in the correct directory and the path is correctly specified in `Server.java`.

3. **Connection Refused Error:**
   - Make sure the server is running before starting the client.

## Conclusion

This project demonstrates the basics of a multithreaded server-client architecture in Java using sockets. It showcases how to handle multiple client connections concurrently and serve static content efficiently.
```

This `README.md` file should provide a clear and detailed guide for understanding and running your Java multithreaded server-client project.
