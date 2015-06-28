package saaremaa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * mihin tätä tarvii jos ClientConnection:issa on sekä input että output?
 * eiks vastaanottaminen onnistu sieltäki iah hyvin?
 */
public class ServerConnection {
	ServerSocket MyServer;
	Socket ClientSocket;
	//File myFile = new File("testi.txt")
	//K�ytet��n vastaaottamaan dataa
	DataInputStream input;
	DataOutputStream output;
	int recivedNumber;
	
	
	//Luo socketin ja yhteyden jalkeen kutsuu kuuntelija metodia
	public void createListeningSocket(int PortNumber){
		try{
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
				if (recivedNumber == 0) {
					closeConnection();
				}
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void startListening(){
		while (true){
			try {
				recivedNumber = input.readInt();
			}
			catch (IOException e) {
				System.out.println(e);
			}
			if(recivedNumber==0){
				closeConnection();
			}
			System.out.println(recivedNumber);
		}
	}
	
	public int getPortNumber(){
		return MyServer.getLocalPort();
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
			System.out.println("Connection closed");
		}
		catch (IOException e){
			System.out.println(e);
		}
	}

}
