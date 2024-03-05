package com.game.src.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.game.src.main.Game;
import com.game.src.main.PlayerMP;
import com.game.src.net.packets.Packet;
import com.game.src.net.packets.Packet.PacketTypes;
import com.game.src.net.packets.Packet00Login;

public class GameServer extends Thread {

	private DatagramSocket socket;
	private Game game;
	private List<PlayerMP> connectedPlayers = new ArrayList<PlayerMP>();
	
	public GameServer(Game game) {
		this.game = game;
		
		try {
			this.socket = new DatagramSocket(1331);
			
		}catch (SocketException e) {
				e.printStackTrace();
		
			
		}
	}
	
	public void run() {
		
		while (true) {
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
			String message = new String(packet.getData());
			System.out.println("Client > ["+packet.getAddress().getHostAddress()+":"+packet.getPort()+"]> " + message);
			if(message.trim().equalsIgnoreCase("ping")) {
				System.out.println("Returning pong");
				sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
				
			}
		
			
			
		}
		
	}
	
	private void parsePacket(byte[] data, InetAddress address, int port) {
	    String message = new String(data).trim();
	    PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
	    Packet packet = null;

	    if (type == PacketTypes.INVALID) {
	        // Caso INVALID
	    } else if (type == PacketTypes.LOGIN) {
	    	packet = new Packet00Login(data);
	    	System.out.println("["+address.getHostAddress()+ ":"+ port + "]"+ (((Packet00Login) packet).getUsername()));
	    	PlayerMP player = new PlayerMP(0, 0, game, address, port);
	    	this.addConnection(player, (Packet00Login) packet);
	    	
	    	
	    } else if (type == PacketTypes.DISCONNECT) {
	        // Caso DISCONNECT
	    }
	}

		
		
	

	private void addConnection(PlayerMP player, Packet00Login packet) {
	    boolean alreadyConnected = false;
	    for (PlayerMP p : this.connectedPlayers) {
	        if (p.getUsername().equalsIgnoreCase(packet.getUsername())) {
	            if (p.ipAddress == null) {
	                p.ipAddress = player.ipAddress;
	            }
	            if (p.port == -1) {
	                p.port = player.port;
	            }
	            alreadyConnected = true;
	        } else {
	            sendData(packet.getData(), p.ipAddress, p.port);
	            packet = new Packet00Login(p.getUsername());
	            sendData(packet.getData(), player.ipAddress, player.port);
	        }
	    }
	    if (!alreadyConnected) {
	        this.connectedPlayers.add(player);
	    }
	}


	public void sendData(byte[] data, InetAddress ipAddress, int port) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 1331);
		try {
			this.socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendDataToAllClients(byte[] data) {
		for(PlayerMP p : connectedPlayers) {
			sendData(data, p.ipAddress, p.port);
		}
		
		
	}

}
