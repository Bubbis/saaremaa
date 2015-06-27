package saaremaa;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection {
	ServerSocket MyClient;
	
	int portNumber;
	
	
	public void createListeningSocket(int PortNumber){
		try{
			portNumber = PortNumber;
			MyClient = new ServerSocket(PortNumber);
			return;
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public int getPortNumber(){
		return portNumber;
	}

}
