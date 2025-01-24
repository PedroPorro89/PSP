/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.u3;

import java.util.Random;

/**
 *
 * @author alumno
 */
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

    public Cuenta getC() {
        return c;
    }

    public void setC(Cuenta c) {
        this.c = c;
    }

    public int getN_reintegros() {
        return n_reintegros;
    }

    public void setN_reintegros(int n_reintegros) {
        this.n_reintegros = n_reintegros;
    }

    public int getReintegro_min() {
        return reintegro_min;
    }

    public void setReintegro_min(int reintegro_min) {
        this.reintegro_min = reintegro_min;
    }

    public int getReintegro_max() {
        return reintegro_max;
    }

    public void setReintegro_max(int reintegro_max) {
        this.reintegro_max = reintegro_max;
    }

    public int getTotalReintegros() {
        return totalReintegros;
    }

    public void setTotalReintegros(int totalReintegros) {
        this.totalReintegros = totalReintegros;
    }

    
    
 
    
    
}
