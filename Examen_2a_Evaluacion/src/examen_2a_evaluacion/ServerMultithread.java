/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_2a_evaluacion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class ServerMultithread {
    
    

        /*
        for (Producto i : productos) 
        {
            System.out.println(i);
        }
        */
    
    
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> Clientes;
        
        Producto p1 = new Producto(1, "Manzanas", 1.99f, 50);
        Producto p2 = new Producto(2, "Peras", 2.49f, 30);
        Producto p3 = new Producto(3, "Plátanos", 1.59f, 40);
        Producto p4 = new Producto(4, "Naranjas", 2.99f, 25);
        Producto p5 = new Producto(5, "Sandía", 4.99f, 10);
        Producto p6 = new Producto(6, "Fresas", 3.49f, 20);
        Producto p7 = new Producto(7, "Kiwi", 2.89f, 35);
        Producto p8 = new Producto(8, "Melocotones", 3.99f, 15);
        Producto p9 = new Producto(9, "Cerezas", 5.99f, 12);
        Producto p10 = new Producto(10, "Uvas", 4.49f, 18);

        // Mostramos los productos en consola
        Producto[] productos = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
        
        
        int port = Integer.parseInt(args[1]);
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + port);
            e.printStackTrace();
            System.exit(-1);
        }
        Socket socketCliente = null;
        int i = 1;
        
        while (true) {
            try {
                // Se bloquea hasta que recibe alguna petición de un cliente
                // abriendo un socket para el cliente
                socketCliente = socketServidor.accept();
                System.out.println("Connexión acceptada: " + socketCliente);

                new Worker("Worker" + i, socketCliente, productos).start();
                i++;
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }

        //socketServidor.close();
    }

}
