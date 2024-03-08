package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Servidor {

    //Inicializamos el puerto
    private final int puerto = 2027;

    //Numero maximo de conexiones
    private final int noConexiones = 3;

    //Creamos una lista de sockets para guardar el socket de cada jugador
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();

    public static int id = 0;

    //Funcion para que el servidor empiece a recibir conexiones de clientes
    public void escuchar() {
        try{
            //Creamos el socket servidor
            ServerSocket servidor = new ServerSocket(puerto, noConexiones);
            //Ciclo infinito para estar esuchando por nuevos jugadores
            System.out.println("Esperando jugadores....");
            while (true) {
                //Cuando un jugador se conecte guardamos el socket en nuestra lista
                Socket cliente =servidor.accept();
                //Se agrega el socket a la lista
                usuarios.add(cliente);
                //Instanciamos el hilo que estara atendiendo al cliente y lo ponemos a escuchar 
                Runnable run = new HiloServidor(cliente, usuarios, id);
                Thread hilo = new Thread(run);
                hilo.start();
                id++;
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Funcion main para correr el servidor
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.escuchar();
    }

}
