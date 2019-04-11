package EstructurasEnlazadas;

import pilaUso.EmptyCollectionException;

public class EstructuraEnlazada <T> {
    private Nodo<T> primero;
    
    public EstructuraEnlazada(){
        primero = null;
    }

    public boolean isEmpty(){
        return primero == null;   
    }
    
    public void agregaInicio(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSig(primero);
        primero = nuevo;
    }
    
    public void agregaFinal(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        if(isEmpty())
            primero = nuevo;
        else{
            Nodo<T> aux;
            aux = primero;
            while(aux.getSig() != null)
                aux = aux.getSig();
            aux.setSig(nuevo);
        }  
    }
    
    public String toString(){
        StringBuilder res = new StringBuilder();
        return toString(res, primero);
    }
    private String toString(StringBuilder res, Nodo<T> ap){
        if(ap == null)
            return res.toString();
        else{
            res.append(ap.getDato() + "  ");
            return toString(res, ap.getSig());
        }
    }
    
    public boolean buscaDato(T dato){
        boolean res;
        Nodo<T> ap = primero;
        while(ap != null && !ap.getDato().equals(dato)){
            ap = ap.getSig();
        }
        res = ap != null;
        return res;
    }
    
    public T quitaPrimero(){
        if(isEmpty())
            throw new EmptyCollectionException();
        T res = primero.getDato();
        Nodo<T> ap = primero;
        primero = primero.getSig();
        ap.setSig(null);
        return res;
    }
    
    public T quitaUltimo(){
        if(isEmpty())
            throw new EmptyCollectionException();
        Nodo<T> actual = primero;
        Nodo<T> ant = null;
        while(actual.getSig() != null){
            ant = actual;
            actual = actual.getSig();
        }
        if(ant != null)
            ant.setSig(null);
        else
            primero = null;
        return actual.getDato();
    }
    
    public static void main(String[] args){
        EstructuraEnlazada<String> nom = new EstructuraEnlazada();
        if(nom.isEmpty())
            System.out.println("está vacía");
        else
            System.out.println("No está vacía");
        nom.agregaInicio("Diana");
        nom.agregaInicio("Elisa");
        nom.agregaFinal("Nora");
        System.out.println("Contenido: " + nom.toString());
        nom.agregaFinal("Edgar");
        System.out.println("Contenido: " + nom.toString());
        if(!nom.isEmpty())
            System.out.println("Quita: " + nom.quitaPrimero());
        if(!nom.isEmpty())
            System.out.println("Quita: " + nom.quitaUltimo());
        if(nom.buscaDato("Diana"))
            System.out.println("diana si esta aqui");
        if(nom.buscaDato("Diaa"))
            System.out.println("diaa si esta aqui");
        else
            System.out.println("no esta Diaa");
    }
}
