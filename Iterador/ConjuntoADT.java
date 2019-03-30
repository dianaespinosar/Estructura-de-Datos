package IteradorArreglo;

import java.util.Iterator;

public interface ConjuntoADT <T> extends Iterable<T> {
    public Iterator<T> iterator();
    public boolean agrega(T elem);
    public T quita(T elem);
    public boolean contiene(T elem);
    public int getCardinalidad();
    public boolean isEmpty();
    public ConjuntoADT<T> union (ConjuntoADT <T> otro);   
    public ConjuntoADT<T> interseccion (ConjuntoADT <T> otro);
    public ConjuntoADT<T> diferencia (ConjuntoADT <T> otro);
    public String toString();
}
