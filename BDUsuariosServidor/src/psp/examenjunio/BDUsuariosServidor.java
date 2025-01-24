package psp.examenjunio;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class BDUsuariosServidor {

    public static final int PORT = 5566;

    // Lotes de productos a subaasta
    static ArrayList <Usuario> basededatos = new ArrayList() {
        {
            // Artículos sin pujas
            add(new Usuario(1, "Jose"));
            add(new Usuario(2, "Simón"));
            add(new Usuario(3, "Ana"));
            add(new Usuario(4, "Fran"));
        }
    };

    public static void main(String[] args) {
        // Establece el puerto en el que escucha peticiones
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        //System.out.println("Escuchando: " + socketServidor);

        
        
        
        Socket socketCliente = null;
        int i = 1;
        
        while (true) 
        {
            try 
            {
                // TO-DO: Añadir código para hacer el servidor multihilo
                // TO-DO: Pasar la estructura basededatos a los hilos en el constructor
                socketCliente = socketServidor.accept();
                System.out.println("Connexión acceptada: " + socketCliente);

                new Worker("Worker" + i, socketCliente).start();
                i++;
            } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                socketServidor.close();
            } catch (IOException e) {
                // No es necesario indicar ningún mensaje. 
                // En este caso, si no se puede cerrar el objeto, el 
                // recolector de basura se encargará de liberar el recurso.
            }
        }
                
    }
}
}
