/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.actividades;

import java.util.Random;


public class U3A30_Camarero extends Thread
{
    private U3A30_Plato plato;
    private int tiempo_espera_min, tiempo_espera_max, n_platos;

    public U3A30_Camarero(U3A30_Plato plato, int tiempo_espera_min, int tiempo_espera_max, int n_platos) 
    {
        
        this.plato = plato;
        this.tiempo_espera_min = tiempo_espera_min;
        this.tiempo_espera_max = tiempo_espera_max;
        this.n_platos = n_platos;
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
                plato.Sirve();
                
            }
        } catch (Exception e) {
        }
    }
}
