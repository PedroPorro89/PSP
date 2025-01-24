package psp.examenjunio;

import java.net.*;
import java.io.*;

public class BDUsuariosCliente {

    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        String userName = "";
        int userCode = 0;

        // Creamos un socket en el lado cliente, enlazado con un
        // servidor que est� en la misma m�quina que el cliente
        // y que escucha en el puerto 5566
        try {
            socketCliente = new Socket("localhost", 5566);
            // Obtenemos el canal de entrada
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            // Obtenemos el canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexi�n");
            System.exit(-1);
        }
        // Utilizamos un BufferedReader para la lectura del teclado
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        try {
            // TO-DO: Completa en el método todo el código del examen
            // Método para implementar el protocolo Cliente-Servidor
            protocolo();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Libera recursos
        salida.close();
        entrada.close();
        stdIn.close();
        socketCliente.close();
    }

    
    public static void protocolo() throws IOException {

        // TO-DO: Añade aquí todo el código para gestionar el protocolo
        // de la actividad con el Servidor
    }
}