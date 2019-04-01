package IteradorArreglo;

import java.util.Iterator;

public class PruebaConjunto {
    public static void main(String[] args) {
        double suma = 0;
        ConjuntoADT <String> conj1 = (ConjuntoADT <String>) new ConjuntoArreglo();
        ConjuntoADT <Double> conj2 = (ConjuntoADT <Double>) new ConjuntoArreglo();
        ConjuntoADT <String> conj3 = (ConjuntoADT <String>) new ConjuntoArreglo();
        conj1.agrega("azul");
        conj1.agrega("rojo");
        conj1.agrega("verde");
        conj1.agrega("rosa");
        if(conj1.agrega("verde"))
            System.out.println("Alta exitosa");
        else
            System.out.println("Error");
        
        conj2.agrega(10.5);
        conj2.agrega(20.3);
        conj2.agrega(240.9);
        conj2.agrega(86.37);
        if(conj2.agrega(240.6))
            System.out.println("Alta exitosa");
        else
            System.out.println("Error");
        Iterator<Double> it = conj2.iterator();
        while(it.hasNext())
            suma += it.next();
        System.out.println(suma);
        
        conj3.agrega("azul");
        conj3.agrega("amarillo");
        conj3.agrega("verde");
        conj3.agrega("rosa");
        conj3.agrega("violeta");
        System.out.println(conj1.union(conj3).toString());
        System.out.println(conj1.interseccion(conj3).toString());
        System.out.println(conj3.diferencia(conj1).toString()); 
    }
}
