package ColasUso;

import IteradorArreglo.ConjuntoArreglo;
import java.util.Iterator;
import static javafx.scene.input.KeyCode.T;
import pilaUso.EmptyCollectionException;
import pilaUso.PilaA;

public class Ejetcicios {

    public static <T> void invierte(ColaA<T> cola){
        if(cola != null){
            PilaA<T> aux = new PilaA();
            while(!cola.isEmpty())
                aux.push(cola.quita());
        
             while(!aux.isEmpty())
                cola.agrega((T) aux.pop());
    
        }
    }
    
    public static <T> void  invierteR(ColaA<T> cola){
       if(!cola.isEmpty()){
           T aux= cola.quita();
           invierteR(cola);
           cola.agrega(aux); 
       }
   }
   
    
    public static void quitaRepetidos(ColaA cola){
        ConjuntoArreglo conjunto = new ConjuntoArreglo();
        while(!cola.isEmpty())
            conjunto.agrega(cola.quita());
        Iterator it = conjunto.iterator();
        while(it.hasNext()){
            cola.agrega(it.next());
        }
    
    }
    
    public static <T> void quitaOcurrencias(ColaA<T> cola, String ocurrencia){
        ColaA<T> aux = new ColaA();
        T ele;
        while(!cola.isEmpty()){
            ele = cola.quita();
            if(!ele.getClass().getSimpleName().equalsIgnoreCase(ocurrencia))
                aux.agrega(ele);
       
        }
        while(!aux.isEmpty())
            cola.agrega(aux.quita());
        
    }
    
    public static void main(String[] args) {
        ColaA a = new ColaA(4);
        a.agrega(12);
        a.agrega(12);
        a.agrega(35);
        a.agrega(22);
        a.quita();
        a.agrega(22);
        System.out.println(a.toString());
        System.out.println(a.boHayVecinosIguales());
        System.out.println(a.toString());
    }
    
}
