package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Administrator extends Thread{

	private static final int PORT_SERVER = 3090;
	private static final String IP_SERVER = "localhost";
	private Socket socket;
	private boolean clientUp;
	private DataInputStream input;
	private DataOutputStream ouput;
	
	public Administrator() throws UnknownHostException, IOException {
		socket = new Socket(IP_SERVER, PORT_SERVER);
		input = new DataInputStream(socket.getInputStream());//recibe datos
		ouput = new DataOutputStream(socket.getOutputStream());//envia datos
		clientUp = true;
		start();
	}
	
	public void sendConcert(String concert) {
		try {
			ouput.writeUTF(concert);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (clientUp) {
			try {
				if (input.available() > 0) {
					String message = input.readUTF();
					System.out.println("el mensaje es " + message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}