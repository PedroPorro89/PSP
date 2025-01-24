/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.actividades;

import java.util.Random;

/**
 *
 * @author alumno
 */
public class U3A30_Carta 
{
    public static String elegirComida() 
    {
        Random generador = new Random();
        int plato = generador.nextInt(1, 6 + 1);
        return switch (plato) {
            case 1 -> "Fabada"; 
            case 2 -> "Lentajas";
            case 3 -> "Mandarina";
            case 4 -> "Patatas Fritas";
            case 5 -> "Ensalada Murciana";
            case 6 -> "Ñoquis";
            default -> "Esa no es una opción valida";
        };
    }         
}
