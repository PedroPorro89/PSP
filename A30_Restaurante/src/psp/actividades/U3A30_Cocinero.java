
package psp.actividades;

import java.util.Random;


public class U3A30_Cocinero extends Thread
{
    
    private U3A30_Plato plato;
    
    private int n_platos, tiempo_espera_min, tiempo_espera_max;

    public U3A30_Cocinero(U3A30_Plato plato, int n_platos, int tiempo_espera_min, int tiempo_espera_max) 
    {
        this.n_platos = n_platos;
        this.tiempo_espera_min = tiempo_espera_min;
        this.tiempo_espera_max = tiempo_espera_max;
    }
    
    @Override
    public void run()
    {
        Random generador = new Random();
        try {
            for (int i = 0; i < n_platos; i++) 
            {
                int tiempo_espera = generador.nextInt(tiempo_espera_min, tiempo_espera_max + 1);
                Thread.sleep(tiempo_espera);
                plato.setPlato(U3A30_Carta.elegirComida());
                plato.Prepara();
            }
        } catch (Exception e) {
        }
    }
}
    
/*
public class Empleado extends Thread
{   
    private Cuenta c;
    private int n_reintegros, reintegro_min, reintegro_max, totalReintegros;


    public Empleado(Cuenta c, String nombre,int n_reintegros, int reintegro_min, int reintegro_max) 
    {
        super(nombre);
        this.c = c;
        this.totalReintegros = 0;
        this.n_reintegros = n_reintegros;
        this.reintegro_min = reintegro_min;
        this.reintegro_max = reintegro_max;
    }
    @Override
    public void run()
    {
        Random generador = new Random();
        for (int i = 0; i < 10; i++) 
        {
            int cantidad;
            
           cantidad = generador.nextInt(reintegro_min, reintegro_max + 1);
           c.sacarDinero(cantidad);
        }
        
    }
*/
    

