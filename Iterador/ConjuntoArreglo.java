package IteradorArreglo;

import java.util.Iterator;

public class ConjuntoArreglo <T> implements ConjuntoADT<T> {

    private T[] conjunto;
    private int cardinalidad;
    private final int MAX = 20;
    
    public ConjuntoArreglo(){
        conjunto = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoArreglo(int max){
        conjunto = (T[]) new Object[max];
        cardinalidad = 0;
    }
    
    public Iterator<T> iterator() {
        return new IteradorArreglo(conjunto, cardinalidad);
    }

    public boolean agrega(T elem) {
        boolean res = false;
        if(!contiene(elem)){
            if(cardinalidad == conjunto.length)
                expande();
            conjunto[cardinalidad] = elem;
            cardinalidad++;
            res = true;
        }
        
        return res;
        
    }
    
    private void expande(){
        T[] nuevo = (T[]) new Object[conjunto.length * 2];
        for(int i = 0; i < cardinalidad; i++)
            nuevo[i] = conjunto[i];
        conjunto = nuevo;
    } 
    

    public T quita(T elem) {
        T res = null;
        int pos = buscaPos(elem);
        if(pos >= 0){
            res = conjunto[pos];
            conjunto[pos] = conjunto[cardinalidad - 1];
            conjunto[cardinalidad - 1] = null;
            cardinalidad--;
        }
        
        return res;
    }
    
    private int buscaPos(T elem){
        int i = 0;
        while (i < cardinalidad && !conjunto[i].equals(elem))
            i++;
        
        if(i == cardinalidad)
            i = -1;
        return i;
    }

    public boolean contiene(T elem) {
        /*int i = 0;
        while (i < cardinalidad && !conjunto[i].equals(elem))
            i++;
        return i < cardinalidad;
        */
        Iterator <T> it= iterator();
        boolean band = false;
        while(it.hasNext() && !band)
            band = it.next().equals(elem);
        return band;
        
        /*
            return contiene(elem, iterator());
        
        private boolean contiene(T elem, Iterator <T> it){
        if(!it.hasNext())
            return false;
        else
            if(it.next().equals(elem))  //el it.next() mueve la posición
                return true;
            else
                return contiene(elem, it);
        */
    }

    
    public int getCardinalidad() {
        return cardinalidad;
    }

    public boolean isEmpty() {
        return cardinalidad == 0;
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
       
       if(otro == null)
           throw new NullPointerException();
       
       int max = cardinalidad + otro.getCardinalidad();
       ConjuntoArreglo <T> res = new ConjuntoArreglo(max);
       
       for(int i = 0; i < cardinalidad; i++)
           res.conjunto[i] = conjunto[i];
       Iterator<T> it = otro.iterator();
       while(it.hasNext())
         res.agrega(it.next());
      
       return res;
       
   }
   
   public ConjuntoADT interseccion(ConjuntoADT otro){
       T aux;
       int max = Math.min(cardinalidad, otro.getCardinalidad());
       Iterator<T> it = otro.iterator();
       ConjuntoArreglo <T> res = new ConjuntoArreglo(max);
       if(otro == null)
           throw new NullPointerException();
       
       while(it.hasNext()){
           aux = it.next();
           if(contiene(aux))
               res.agrega(aux);
       }
       return res;
       
   }
   
   public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
        T aux;
        if(otro == null)
            throw new NullPointerException();

        ConjuntoArreglo <T> res = new ConjuntoArreglo(cardinalidad);

        for(int i = 0; i < cardinalidad; i++)
            res.agrega(conjunto[i]);
        Iterator<T> it = otro.iterator();
        while(it.hasNext()){
            aux = it.next();
            res.quita(aux);
        }

           return res;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
            for(int i = 0; i < cardinalidad; i++){
                res.append(conjunto[i]).append("  ");
            }  
        return res.toString();

    }
    
   
}
