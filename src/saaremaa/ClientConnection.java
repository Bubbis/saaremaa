package saaremaa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientConnection {
	Socket socket;
	DataInputStream input;
	DataOutputStream output;
	
	
	public void connectTo(InetAddress address,int portNumber) throws IOException{
		socket = new Socket(address,portNumber);
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void sendInt(int number) throws IOException{
		output.writeInt(number);
	}
	
	
	public void closeConnection(){
		try{
			output.close();
			input.close();
			socket.close();
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
	
	
	
	
}
