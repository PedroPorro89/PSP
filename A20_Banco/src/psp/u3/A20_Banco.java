/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.u3;

import com.sun.jdi.connect.Connector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class A20_Banco 
{
    static final int SALDO_INICIAL = 2000;
    static final int REINTEGRO_MIN = 50;
    static final int REINTEGRGO_MAX = 200;
    static final int N_REINTEGROS = 10;
    static final int N_HILOS = 2;
    

    
    public static void main(String[] args)
    {
        ArrayList<String> nombreEmpleado = new ArrayList<>(Arrays.asList("Luis","Manuel"));
        
        ArrayList<Empleado> listaEmpleados = new ArrayList();
        
        Cuenta c = new Cuenta(SALDO_INICIAL);
        for (String nombre: nombreEmpleado)
        {
            Empleado e =  new Empleado(c, "nombre", N_REINTEGROS, REINTEGRO_MIN, REINTEGRGO_MAX);
            e.start();
            listaEmpleados.add(e);
        }
        
        for (Empleado e: listaEmpleados)
        {
            try 
            {
                e.join();
            } catch (InterruptedException x){
                System.err.println("error loco loco");
            }
        }
        for (Empleado e: listaEmpleados)
        {
            System.out.println("El hilo" + e.getName() + "" );
        }
        
        
        
        /*
        Empleado luis = new Empleado(c, "Luis", N_REINTEGROS, REINTEGRO_MIN, REINTEGRGO_MAX);
        Empleado manuel = new Empleado(c, "Manuel", N_REINTEGROS, REINTEGRO_MIN, REINTEGRGO_MAX);
        */

               
    }
    
}
