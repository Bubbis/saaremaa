package saaremaa;

import java.net.Socket;

public class Connection {
	Socket MyClient;
	
	public void createSocket(int PortNumber){
		try{
		MyClient = new Socket("Pc-Name", PortNumber);
		return;
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
