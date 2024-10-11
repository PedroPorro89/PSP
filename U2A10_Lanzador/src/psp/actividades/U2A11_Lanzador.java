/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.actividades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author alumno
 */
public class U2A11_Lanzador {
       
    public static void main(String[] args)
    {
        try {
            // Preparamos el entrono de ejecución del proceso
            // Como no sabemos el contenido del comando, forzamos su conversión
            // a una lista para que no haya problemas con su ejecución
            //--Para que el hijo cambie la salida y la entrada por consola
            //String[] numeros = new String[] {"1","2"};
            //                
            // REVISAR ESTA LINEA
            //       ||
            //       \/
            String comando = "java psp.actividades.U2A11_Sumador2";
            ProcessBuilder constructor = new ProcessBuilder(comando.split("\\s"));
            constructor.directory(new File("build/classes"));
            
            Process procesoHijo = constructor.start(); 
            //Comprobamos que esta vivo
            boolean vivo = procesoHijo.isAlive();
            if(vivo)
                System.out.println("Hijo vivo");
            else
                System.out.println("Hijo muerto");
            
            
            PrintWriter toProcess = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        procesoHijo.getOutputStream()/*, "UTF-8"*/)), true);
            int[] primerPar = new int[] {5,5} ;
            int[] segundoPar = new int[] {9,2} ;
            int[] tercerPar = new int[] {9};
            int cuartoPar = 4;
            
            toProcess.println("4");
            toProcess.println("9");
            
            
            int valorSalida = procesoHijo.waitFor();

            vivo = procesoHijo.isAlive();
            if(vivo)
                System.out.println("Hijo vivo");
            else
                System.out.println("Hijo muerto");
            
            String lineaError;
            // Recogemos la SALIDA ERROR ESTÁNDAR del proceso hijo
            // El encoding CP850 se usa para leer bien los mensajes de la consola
            BufferedReader brError = new BufferedReader(new InputStreamReader(procesoHijo.getErrorStream()));
            while ((lineaError = brError.readLine())!=null) {
                System.out.println("stderr(hijo)> " + lineaError);
            }
            
            BufferedReader processOutput = 
                new BufferedReader(new InputStreamReader(procesoHijo.getInputStream(), "UTF-8"));

            String linea;    
            while ((linea = processOutput.readLine()) != null) {
                System.out.println("Hijo> " + linea);        
            }            
            //processOutput.close(); 
            if (valorSalida == 0) {
                System.out.println("El comando " + constructor.command().toString() + " ha finalizado bien");
            } else {
                System.out.println("El comando " + constructor.command().toString() + " ha finalizado con errores");
            }
        } catch (InterruptedException | IOException ex) 
        {
            System.err.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    
    } 
}
