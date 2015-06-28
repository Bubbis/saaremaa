package saaremaaTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import saaremaa.ClientConnection;

public class ClientConnectionTest {

	
	public static void runTests() throws UnknownHostException, IOException{
		ClientConnection connection = new ClientConnection();
		connection.connectTo(InetAddress.getByName("0.0.0.0"),1030);
		connection.sendInt(123);
		connection.closeConnection();
	}
	
	
	
	
}
