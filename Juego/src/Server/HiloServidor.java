package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.LinkedList;


public class HiloServidor implements Runnable {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private boolean conectado = true;
    

    //id del jugador
    private int ID;

    //Lista de los usuarios conectados al servidor
    private LinkedList<Socket> usuarios = new LinkedList<>();
    
    //Constructor que recibe el socket que atendera el hilo y la lista de los jugadores
    public HiloServidor(Socket soc, LinkedList users, int id) {
        socket = soc;
        usuarios = users;
        ID = id;
    }

    
    public void run() {
        try{
            //Iniciamos los canales de comunicacion y mandamos el turno a cada jugador
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String msg = "" + ID;
            out.writeUTF(msg);
            //Ciclo infinito que estara escuchando por los movimientos de cada jugador
            while (true) {
                String recibidos = in.readUTF();

                for (Socket usuario : usuarios) {
                    out = new DataOutputStream(usuario.getOutputStream());
                    out.writeUTF(recibidos);
                }
                
            }
        } catch (Exception e){

        }
    }

}
