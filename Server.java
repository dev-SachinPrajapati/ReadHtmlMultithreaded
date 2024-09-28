package ReadHtmlFile;

import java.io.BufferedReader; // Import for reading files
import java.io.FileReader;     // Import for reading files
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

	// Method to return a Consumer that reads an HTML file and sends it to the client
	public Consumer<Socket> getConsumer() {
		return (clientSocket) -> {
			try (PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true)) {
				// Open the HTML file
				BufferedReader reader = new BufferedReader(new FileReader("index.html"));
				String line;

				// Read each line of the HTML file and send it to the client
				while ((line = reader.readLine()) != null) {
					toSocket.println(line); // Send each line of HTML to the client
				}

				reader.close(); // Close the file reader after sending the content
			} catch (IOException e) {
				e.printStackTrace(); // Print any error if the file reading fails
			}
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int port = 8010; // Port on which the server will listen
		Server server = new Server();

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server is listening on port " + port);

			while (true) {
				Socket clientSocket = serverSocket.accept(); // Wait for a client connection

				// Create a new thread for each client connection to handle it independently
				Thread thread = new Thread(() -> server.getConsumer().accept(clientSocket));
				thread.start(); // Start the thread
			}
		} catch (IOException e) {
			e.printStackTrace(); // Handle any I/O exception
		}

	}

}
