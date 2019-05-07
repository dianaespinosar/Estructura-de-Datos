package Listas;

public interface ListaOrdADT <T extends Comparable<T>> extends ListaADT {
    public boolean agrega(T dato);
    
}
