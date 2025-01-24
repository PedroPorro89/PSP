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
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Client {
 
    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        
        // Creamos un socket en el lado cliente, enlazado con un
        // servidor que está en la misma máquina que el cliente
        // y que escucha en el puerto 4444
        
        
        try {          
            socketCliente = new Socket(args[0], Integer.parseInt(args[1]));
            // Obtenemos el canal de entrada
            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));
            // Obtenemos el canal de salida
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexión");
            e.printStackTrace();
            System.exit(-1);
        }
        Scanner Teclado = new Scanner(System.in);

        String linea;

        // El programa cliente no analiza los mensajes enviados por el
        // usario, simplemente los reenvía al servidor hasta que este
        // se despide con "Adios"
        try {
            while (true) {
                // Leo la entrada del usuario
                linea = Teclado.nextLine();
                // La envia al servidor por el OutputStream
                salida.println(linea);
                // Recibe la respuesta del servidor por el InputStream
                linea = entrada.readLine();
                // Envía a la salida estándar la respuesta del servidor
                System.out.println("Respuesta servidor: " + linea);
                // Si es "Adios" es que finaliza la comunicación
                if (linea.equals("END OF TRANSMISSION")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Libera recursos
        salida.close();
        entrada.close();
        Teclado.close();
        socketCliente.close();
    }
}
