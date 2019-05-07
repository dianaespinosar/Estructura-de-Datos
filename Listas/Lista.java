package Listas;

import EstructurasEnlazadas.IteradorEE;
import EstructurasEnlazadas.Nodo;
import java.util.Iterator;
import pilaUso.EmptyCollectionException;

public abstract class Lista<T> implements ListaADT<T> {

    protected Nodo<T> primero;
    protected Nodo<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    public Iterator<T> iterador() {
        return new IteradorEE(primero);
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public T quitaPrimero() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Nodo<T> ap = primero;
        primero.getSig();
        if (primero == null) {
            ultimo = null;
        } else {
            ap.setSig(null);
        }
        return ap.getDato();

    }

    public T quitaUltimo() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        Nodo<T> actual = primero;
        Nodo<T> ant = null;
        while (actual.getSig() != null) {
            ant = actual;
            actual = actual.getSig();
        }
        if (ant != null) {
            ant.setSig(null);
        } else {
            primero = null;
        }
        return actual.getDato();
    }

    public T quita(T dato) {
        if (!isEmpty()) {
            if (primero.getDato().equals(dato)) {
                return quitaPrimero();
            } else {
                Nodo<T> act, ant;
                ant = primero;
                act = primero.getSig();
                while (act != null && !act.getDato().equals(dato)) {
                    ant = act;
                    act = act.getSig();
                }
                if (act == null) {
                    throw new EmptyCollectionException();
                } else {
                    T resul = act.getDato();
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    return resul;
                }
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        return toString(res, primero);
    }

    private String toString(StringBuilder res, Nodo<T> ap) {
        if (ap == null) {
            return res.toString();
        } else {
            res.append(ap.getDato()).append("\n");
            return toString(res, ap.getSig());
        }
    }

    @Override
    public boolean contiene(T dato) {
        boolean res;
        Nodo<T> ap = primero;
        while (ap != null && !ap.getDato().equals(dato)) {
            ap = ap.getSig();
        }
        res = ap != null;
        return res;
    }

    public int calcularTamaño() {
        int cant = 0;
        if (isEmpty()) {
            return cant;
        } else {
            Nodo<T> ant = primero;
            cant++;
            Nodo<T> act = primero.getSig();
            while (act != null) {
                ant = act;
                act = act.getSig();
                cant++;
            }
            return cant;
        }
    }

    public T obtienePrimero() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return primero.getDato();
    }

    public T obtieneUltimo() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        Nodo<T> actual = primero;
        while (actual.getSig() != null) {
            actual = actual.getSig();
        }

        return actual.getDato();
    }
}
