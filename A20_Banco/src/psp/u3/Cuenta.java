/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.u3;

/**
 *
 * @author alumno
 */
public class Cuenta 
{
    final int SALDO_INICIAL = 2000;
    final int REINTEGRO_MIN = 50;
    final int REINTEGRGO_MAX = 200;
    final int N_REINTEGROS = 10;
    final int N_HILOS = 2;
    private int saldo; //= SALDO_INICIAL;

    public Cuenta(int saldo)
    {
        this.saldo = saldo;
    }
    public synchronized void sacarDinero(int cantidad)
    {
        if (saldo<cantidad) 
        {
            System.out.println("Te pasaste manin");
            
        }
        else{
            saldo -= cantidad;
            System.out.println("psp.u3.Cuenta.sacarDinero()");
        }
    }
    
            
}

