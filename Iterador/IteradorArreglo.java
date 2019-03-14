package IteradorArreglo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorArreglo <T> implements Iterator <T> {
    private T[] coleccion;
    private int total;
    private int actual;
    
    public IteradorArreglo(T[] arre, int tot){
        coleccion = arre;
        total = tot;
        actual = 0;
    }

    
    public boolean hasNext() {
        return actual < total;
    }

    public T next() {
        if(hasNext()){
            T res = coleccion[actual];
            actual++;
            return res;
        }
        else
            throw new NoSuchElementException();
    }

    
    public void remove() {
        throw new UnsupportedOperationException("Método no implementado");
    }
    
    
    
}
