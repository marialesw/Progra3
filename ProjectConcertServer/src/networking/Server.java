package networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Server extends Thread { 

	private static final int PORT = 3090;
	private ServerSocket server;
	private ArrayList<Connection> connections;
	private boolean serverOn;

	public Server() throws IOException {
		connections = new ArrayList<>();
		server = new ServerSocket(PORT);
		serverOn = true;
		start();
		Logger.getGlobal().info("Server listen on port" + PORT);
	}

	@Override
	public void run() {
		while (serverOn) {
			Socket socket;
			try {
				socket = server.accept();
				connections.add(new Connection(socket));
				Logger.getGlobal().info("New connection -> " + socket.getInetAddress().getHostAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}