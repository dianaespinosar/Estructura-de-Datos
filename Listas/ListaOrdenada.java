package Listas;

import EstructurasEnlazadas.Nodo;
import java.util.Iterator;
import static javafx.scene.input.KeyCode.T;

public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> implements ListaOrdADT<T> {

    @Override
    public boolean agrega(T dato) { //Inserta ordenada sin repetidos
        boolean res = false;
        if (dato != null) {

            if (isEmpty()) {
                primero = new Nodo(dato);
                ultimo = primero;
                res = true;
            } else if (dato.compareTo(primero.getDato()) < 0) { //dato nuevo pequeño
                Nodo<T> nuevo = new Nodo(dato);
                nuevo.setSig(primero);
                primero = nuevo;
                res = true;
            } else if (dato.compareTo(ultimo.getDato()) > 0) { // dato nuevo último
                Nodo<T> nuevo = new Nodo(dato);
                ultimo.setSig(nuevo);
                ultimo = nuevo;
                res = true;
            } else {
                Nodo<T> ant = primero;
                Nodo<T> act = primero.getSig();
                while (act != null && act.getDato().compareTo(dato) < 0) {
                    ant = act;
                    act = act.getSig();
                }
                if (act != null && !act.getDato().equals(dato)) {
                    Nodo<T> nuevo = new Nodo(dato);
                    nuevo.setSig(act);
                    ant.setSig(nuevo);
                    res = true;
                }
            }

        }
        return res;

    }

    private Nodo<T> busca(T dato) {
        Nodo<T> ant = primero;
        Nodo<T> act = primero.getSig();
        while (act != null && act.getDato().compareTo(dato) < 0) {
            ant = act;
            act = act.getSig();
        }
        return ant;

    }

    public boolean contiene(T dato) {
        boolean res = false;
        if (!isEmpty()) {
            Nodo<T> pos = busca(dato);
            if (pos.getDato().equals(dato)) {
                res = true;
            } else if (pos.getSig() != null && pos.getSig().getDato().equals(dato)) {
                res = true;
            }
        }
        return res;

    }
    
    public T quita(T dato){
        T res = null;
        if(dato != null && !isEmpty()){
            if(primero.getDato().equals(dato)){
                res = primero.getDato();
                Nodo <T> temp = primero;
                primero = primero.getSig();
                if(primero == null)
                    ultimo = null;
                else
                    temp.setSig(null);
                
            }
            
        }
        else{
            Nodo<T> pos = busca(dato);
            
            if(pos.getSig() != null){
                if(pos.getSig().getDato().equals(dato)){
                    res = pos.getSig().getDato();
                    if(pos.getSig() == ultimo){
                        pos.setSig(null);
                        ultimo = pos;
                    }
                    else{
                        Nodo<T> temp = pos.getSig();
                        pos.setSig(temp.getSig());
                        temp.setSig(null);
                    }
                }
                
                   
                
            }
        }
        return res;
    }


}
