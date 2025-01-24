
package psp.actividades;


public class U3A30_Plato 
{
    public U3A30_Plato() {}
    
    private String plato;
    public synchronized void Prepara()
    {
        while(plato == null)
        {
        try { 
            wait();
        } catch (Exception e) {}
        }
        System.out.println("Cocinero ha preparado un plato de (" + plato + ")");
        notifyAll();
    }
    public synchronized void Sirve()
    {
        while(plato == null)
        {
            try {
            System.out.println("Camarero no puede servir el plato de (" + plato + ")");
            wait();
        } catch (Exception e) {}
        }
        System.out.println("Camarero ha servido un plato de (" + plato + ")");
        plato=null;
        notifyAll();
    }

    public U3A30_Plato(String plato) {
        this.plato = plato;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }
    
}
