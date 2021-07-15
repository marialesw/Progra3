package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection implements Runnable{

	private String id;
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean isConnect;

	public Connection(Socket socket) throws IOException {
		this.socket = socket;
		id = socket.getInetAddress().getHostAddress();
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
		isConnect = true;
	}

	public void send(String message) {
		try {
			output.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	@Override
	public void run() {
		while (isConnect) {
			try {
				String concert = input.readUTF();
				System.out.println(concert);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}