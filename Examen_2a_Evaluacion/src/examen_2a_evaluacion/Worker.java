/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_2a_evaluacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Worker extends Thread {

    private Socket socketCliente;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;
    private Producto[] productos;

    public Worker(String name, Socket socketCliente, Producto[] productos) {
        super(name);
        this.socketCliente = socketCliente;
        this.productos = productos;
    }

    @Override
    public void run() {
        try {
            // Establece canal de entrada
            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socketCliente.getOutputStream())), true);
            
            protocolo();
            
            salida.close();
            entrada.close();
            socketCliente.close();
        } catch (IOException ex) {
            System.err.println("Error en la creación de los canales de E/S del socket");            
        }
    }

    private void protocolo() throws IOException {
        String nombre = null;
        Carrito carrito = new Carrito();
        // Hace eco de lo que le proporciona el cliente, hasta que recibe "Adios"
        while (true) {
            // Recibe la solicitud del cliente por el InputStream
            String comando = entrada.readLine();
            
            if (comando == "PRODUCTOS")
            {
                for (Producto i : productos) {
                    System.out.println(i.id + i.getNombre());
                }
            }
            try {
                
            
            if (comando == "ANYADIR") 
            {
                int codigo = Integer.parseInt(entrada.readLine());
                int cantidad = Integer.parseInt(entrada.readLine());
                
                for (int i = 0; i < productos.length; i++) {
                    if(productos[i].id==codigo)
                    {
                        int stock = productos[i].getStock()-cantidad;
                        if (stock<0) 
                        {
                            throw new Exception();
                        }
                        else
                        {
                            productos[i].setStock(stock);
                        }
                    }
                }
                carrito.sumar(codigo, cantidad);
                
            }
            } catch (Exception e) {
                System.err.println("Stock insuficiente");
            }
            
            if (comando == "ANYADIR") 
            {
                int codigo = Integer.parseInt(entrada.readLine());
                int cantidad = Integer.parseInt(entrada.readLine());
                carrito.sumar(codigo, cantidad);
            }
            
            
            
            
            
            
            
            
            
            
            
            
            if(nombre == null)
                nombre = comando + "> ";
            // Envía a la salida estándar el mensaje del cliente
            System.out.println(nombre + comando);
            // Le envía la respuesta al cliente por el OutputStream                
            salida.println(comando);
            // Si es "Adios" es que finaliza la comunicación
            if (comando.equals("END OF TRANSMISSION")) {
                break;
            }
        }
    }
}
