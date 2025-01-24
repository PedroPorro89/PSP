/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_2a_evaluacion;

//ArrayList productos

public class Producto
{
    int id;
    String nombre;
    float precio;
    int stock;

    public Producto(int id, String nombre, float precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto: " + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + '}';
    }

}

/*
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto(1, "Manzanas", 1.99f, 50);
        Producto p2 = new Producto(2, "Peras", 2.49f, 30);
        Producto p3 = new Producto(3, "Plátanos", 1.59f, 40);
        Producto p4 = new Producto(4, "Naranjas", 2.99f, 25);
        Producto p5 = new Producto(5, "Sandía", 4.99f, 10);
        Producto p6 = new Producto(6, "Fresas", 3.49f, 20);
        Producto p7 = new Producto(7, "Kiwi", 2.89f, 35);
        Producto p8 = new Producto(8, "Melocotones", 3.99f, 15);
        Producto p9 = new Producto(9, "Cerezas", 5.99f, 12);
        Producto p10 = new Producto(10, "Uvas", 4.49f, 18);

        // Mostramos los productos en consola
        Producto[] productos = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}*/

//Producto jamon = new Producto()