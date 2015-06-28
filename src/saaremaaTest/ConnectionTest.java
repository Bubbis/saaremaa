package saaremaaTest;

import saaremaa.ServerConnection;

public class ConnectionTest {

	public static void runTests(){
		ServerConnection connection = new ServerConnection();
		//Suositellaan k‰ytt‰m‰‰n yli 1023 porttinumeroa
		connection.createListeningSocket(1030);
	}
	
	
	
}
