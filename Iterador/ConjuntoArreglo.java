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







Código intento con conjuntos


public static ConjuntoArreglo posiblesNumeros(int[][] sudoku, int iBase, int jBase){
        
        ConjuntoArreglo res = new ConjuntoArreglo(9);
        
        if(sudoku[iBase][jBase] == 0){
            for(int k = 1; k < 10; k++){
            res.agrega(k);
            }

            int i = (iBase + 1) % 9;
            int j = (jBase + 1) % 9;
            int m1 = iBase / 3;
            int m2 = jBase / 3;
            int r1 = iBase % 3;
            int r2 = iBase % 3;
            int a = 3 * m1 + ((r1 + 1) % 3);
            int b = 3 * m2 + ((r2 + 1) % 3);
            int c = 3 * m1 + ((r1 + 2) % 3);
            int d = 3 * m2 + ((r2 + 2) % 3);

            while (i != iBase){
                res.quita(sudoku[i][jBase]);
                i = (i + 1) % 9;
            }

            while(j != jBase ){
                res.quita(sudoku[iBase][j] );
                j = (j + 1) % 9;
            }
        
            res.quita(sudoku[a][b]);
            res.quita(sudoku[a][d]);
            res.quita(sudoku[c][b]);
            res.quita(sudoku[c][d]);
       
        }
        else
            res.agrega(sudoku[iBase][jBase]);
        return res;
    }


public static boolean pasaMatriz(int[][] sudoku){
        Iterator it = null;
        if(sudoku != null)
            return pasaMatriz(sudoku, 0, 0, it);
        else
            return false;
    }
    
    
    private static boolean pasaMatriz(int[][]sudoku, int i, int j, Iterator it){
        //System.out.println("i = " + i + "\n");
        ConjuntoArreglo res = new ConjuntoArreglo();
        if(i <9){
            //System.out.println("j = " + j + "\n");
            if(j < 9){
                //System.out.println(" sudoku[i][j] = " + sudoku[i][j] + "\n");
                if(sudoku[i][j] == 0){
                    res = posiblesNumeros(sudoku, i, j);
                    it = res.iterator();
                    if(it.hasNext()){
                        sudoku[i][j] = (int) it.next();
                        if(!pasaMatriz(sudoku, i, j + 1, it)){
                            sudoku[i][j] = 0;
                            return pasaMatriz(sudoku, i, j,it);
                        }
                    }
                    else
                        return false;
                }
                else
                    return pasaMatriz(sudoku, i, j + 1, it);
                
                
            }
            
            else{
                
                return pasaMatriz(sudoku, i + 1, 0, it);
            }
                
        }
        return true;
        
    }








