package saaremaaTest;

import saaremaa.ServerConnection;

public class ConnectionTest {

	public static void runTests(){
		ServerConnection connection = new ServerConnection();
		connection.createListeningSocket(123);
		System.out.println(connection.getPortNumber());
	}
	
	
	
}
