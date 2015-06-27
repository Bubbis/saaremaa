package saaremaaTest;

import saaremaa.Connection;

public class ConnectionTest {

	public static void runTests(){
		Connection connection = new Connection();
		connection.createListeningSocket(123);
		System.out.println(connection.getPortNumber());
	}
	
	
	
}
