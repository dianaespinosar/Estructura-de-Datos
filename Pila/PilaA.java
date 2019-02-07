package pilaUso;


public class PilaA <T>  implements PilaADT <T>{
    private T[] pila;
    private int tope;
    private final int MAX = 20;
    
    public PilaA() {
       pila = (T[]) new Object[MAX];
       tope = -1;
    }

    public PilaA(int max){
       pila = (T[]) new Object[max];
       tope = -1;
    }

     @Override
    public boolean isEmpty() {
        return tope == -1;
    }
    
    @Override
    public void push(T dato) {
        if(tope + 1 == pila.length) 
            expande();
        tope++;
        pila[tope] = dato;
    }

    @Override
    public T pop() {
       if(isEmpty())
           throw new EmptyCollectionException();
       else {
           T res;
           res = pila[tope];
           pila[tope] = null;
           tope--;
           return res;
       }
    }
    
    
    @Override
    public T peek() {
        if(isEmpty())
           throw new EmptyCollectionException();
        
        return pila[tope];
    }

   
    
    private void expande(){
        T[] nuevo = (T[]) new Object[pila.length * 2];
        for(int i = 0; i <= tope; i++)
            nuevo[i] = pila[i];
        pila = nuevo;
    }
    
    
}
