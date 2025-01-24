
package psp.actividades;

import java.util.ArrayList;
import java.util.Arrays;


public class U3A30_Restaurante 
{
    static final int N_PLATOS = 8;
    static final int TIEMPO_ESPERA_MIN_COCINERO = 2;
    static final int TIEMPO_ESPERA_MAX_COCINERO = 4;
    static final int TIEMPO_ESPERA_MIN_CAMARERO = 1;
    static final int TIEMPO_ESPERA_MAX_CAMARERO = 3;
    
    
            
    public static void main(String[] args) 
    {
        U3A30_Plato plato = new U3A30_Plato();
        
        U3A30_Cocinero cocinero =  new U3A30_Cocinero(
        plato, N_PLATOS, TIEMPO_ESPERA_MIN_COCINERO, TIEMPO_ESPERA_MAX_COCINERO);
        U3A30_Camarero camarero = new U3A30_Camarero(plato, TIEMPO_ESPERA_MIN_CAMARERO, TIEMPO_ESPERA_MAX_CAMARERO, N_PLATOS);
        
        cocinero.start();
        camarero.start();
        
    

        
        
        
    }
}
