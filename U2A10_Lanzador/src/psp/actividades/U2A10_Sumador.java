/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.actividades;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class U2A10_Sumador {
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca un par de numeros");
        
        int numero1 = teclado.nextInt();
        System.out.println("Introduzca otro número");
        int numero2 = teclado.nextInt();
        int resultado = numero1 + numero2;
        System.out.println("La suma de los numeros anteriores es: "+ resultado);
    }
}
