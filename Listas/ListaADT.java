package Listas;

import java.util.Iterator;

public interface ListaADT<T> extends Iterable <T> {

    public Iterator<T> iterador();
    public boolean isEmpty();
    public T quitaPrimero();
    public T quitaUltimo();
    public T quita(T dato);
    public String toString();
    public boolean contiene(T dato);
    public int calcularTamaño();
    public T obtienePrimero();
    public T obtieneUltimo();
    
}
