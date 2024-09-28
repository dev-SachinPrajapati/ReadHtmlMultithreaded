package ReadHtmlFile;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	 // Method to return a Runnable for creating threads that communicate with the server
    public Runnable getRunnable() throws IOException {
        return new Runnable() {
            @Override
            public void run() {
                int port = 8010; // Server port number
                try {
                    InetAddress address = InetAddress.getByName("localhost"); // Get the address of localhost
                    Socket socket = new Socket(address, port); // Connect to the server

                    try {
                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        toSocket.println("GET / HTTP/1.1"); // Send a simple HTTP GET request

                        String line;
                        System.out.println("Response from Server:"); // Print the response
                        // Read and print each line from the server response
                        while ((line = fromSocket.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle any I/O exceptions
                    }
                } catch (IOException e) {
                    e.printStackTrace(); // Handle any connection errors
                }
            }
        };
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Client client = new Client();

		// Create and start 100 threads to simulate multiple clients connecting to the server
		for (int i = 0; i < 100; i++) {
			try {
				Thread thread = new Thread(client.getRunnable());
				thread.start(); // Start each thread
			} catch (Exception e) {
				return;
			}
		}
	}

}
