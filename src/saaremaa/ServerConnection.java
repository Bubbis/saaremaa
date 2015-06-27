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
	
	
	
	public void createListeningSocket(int PortNumber){
		try{
			portNumber = PortNumber;
			MyServer = new ServerSocket(PortNumber);
			ClientSocket = MyServer.accept();
			input = new DataInputStream(ClientSocket.getInputStream());
			output = new DataOutputStream(ClientSocket.getOutputStream());
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

}
