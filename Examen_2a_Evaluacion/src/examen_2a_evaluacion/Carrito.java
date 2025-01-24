/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_2a_evaluacion;

import java.util.ArrayList;


public class Carrito 
{
    ArrayList<Integer> ids;
    ArrayList<Integer> cantidad;
    
    public void sumar(Integer id, Integer cantidad)
    {
        int posicion = ids.indexOf(id);
        if(posicion > -1) 
        {
            this.cantidad.add(posicion, this.cantidad.get(posicion) + cantidad);
        }
        ids.add(id);
        this.cantidad.add(cantidad);
    }
    
    
    public Carrito(){}

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
