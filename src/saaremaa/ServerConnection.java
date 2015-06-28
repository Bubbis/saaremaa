package saaremaa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * mihin tätä tarvii jos ClientConnection:issa on sekä input että output?
 * eiks vastaanottaminen onnistu sieltäki iah hyvin?
 */
public class ServerConnection {
	//TODO Viestien vastaanottaminen jnee..
	ServerSocket MyServer;
	Socket ClientSocket;
	//K�ytet��n vastaaottamaan dataa
	DataInputStream input;
	DataOutputStream output;
	int portNumber;
	int recivedNumber;
	
	
	
	public void createListeningSocket(int PortNumber){
		try{
			portNumber = PortNumber;
			MyServer = new ServerSocket(PortNumber);
			System.out.println(MyServer.getInetAddress());
			System.out.println(MyServer.getLocalPort());
			ClientSocket = MyServer.accept();
			input = new DataInputStream(ClientSocket.getInputStream());
			output = new DataOutputStream(ClientSocket.getOutputStream());
			System.out.println("Client connected");
			while (true){
				recivedNumber = input.readInt();
				System.out.println(recivedNumber);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public int getPortNumber(){
		return portNumber;
	}
	
	public void sendNumber(int number) throws IOException{
		output.writeInt(number);
	}
	
	public void closeConnection(){
		try{
			output.close();
			input.close();
			ClientSocket.close();
			MyServer.close();
		}
		catch (IOException e){
			System.out.println(e);
		}
	}

}
