package com.game.src.net.packets;

import com.game.src.net.GameClient;
import com.game.src.net.GameServer;

public class Packet00Login extends Packet{
	
	private String username;

	public Packet00Login(byte[] data) {
		super(00);
		this.username = readData(data);
	
	}
	public Packet00Login(String username) {
		super(00);
		this.username = username;
	
	}

	@Override
	public void writeData(GameClient client) {
		// TODO Auto-generated method stub
		client.sendData(getData());
		
	}

	@Override
	public void writeData(GameServer server) {
		// TODO Auto-generated method stub
		server.sendDataToAllClients(getData());
		
	}
	@Override
	public byte[] getData() {
		// TODO Auto-generated method stub
		return ("00" + this.username).getBytes();
	}
	
	public String getUsername() {
		return username;
		
	}
	
	

}
