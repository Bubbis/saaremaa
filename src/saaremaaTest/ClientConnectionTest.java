package saaremaaTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import saaremaa.ClientConnection;

public class ClientConnectionTest {

	
	public static void runTests() throws UnknownHostException, IOException{
		ClientConnection connection = new ClientConnection();
		connection.connectTo(InetAddress.getByName("192.168.1.100"),1030);
		Scanner reader = new Scanner(System.in);
		int a;
		while (true){
			a = reader.nextInt();
			if (a==0){
				connection.sendInt(a);
				break;
			}
			else{
				connection.sendInt(a);
			}
		}
		connection.closeConnection();
	}
	
	
	
	
}
