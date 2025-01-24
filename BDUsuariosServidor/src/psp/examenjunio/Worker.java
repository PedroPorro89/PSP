

package psp.examenjunio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;





public class Worker extends Thread
{
    private Socket socketCliente;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;

    
    
    
    public Worker(String name, Socket socketCliente) 
    {
        super(name);
        this.socketCliente = socketCliente;
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
    
    public void protocolo() throws IOException 
    {
       String codigo;
       String nombre;
       //String nombre = null;
        // Hace eco de lo que le proporciona el cliente, hasta que recibe "Adios"
        while (true) {
            // Recibe la solicitud del cliente por el InputStream
            String str = entrada.readLine();
            
            if(nombre == null)
                nombre = str + "> ";
            // Envía a la salida estándar el mensaje del cliente
            System.out.println(nombre + str);
            // Le envía la respuesta al cliente por el OutputStream                
            salida.println(str);
            // Si es "Adios" es que finaliza la comunicación
            if (str.equals("END OF TRANSMISSION")) {
                break;
            }
        }
        
    
     
        // TO-DO: Añade aquí todo el código para gestionar el protocolo
        // de la actividad con el Servidor
    }
}
