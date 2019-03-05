package EjemplosRecursion;

import static java.time.Instant.MAX;

public class Arreglogenerico <T extends Comparable <T>>{
   private int total;
   private T[] arreglo;
   private int MAX = 20;

   public Arreglogenerico() {
       total = 0;
       arreglo = (T[]) new Comparable[MAX];
   }
   
   public Arreglogenerico(int max) {
       total = 0;
       arreglo = (T[]) new Comparable[max];
   }
   
    public int alta(T dato) {
        if (total < arreglo.length) {
            int pos = buscaBin(dato);
            if(pos < 0) {
                    pos = (pos * -1) - 1;
                    recorreDer(pos);
                    arreglo[pos] = dato;
                    total++;
            }
        }

        return total;
    }
    
    public void altaDes(T dato) {
       if (total < arreglo.length) {
           arreglo[total] = dato;
           total++;
       }
   }
    
    public int buscaBin (T dato){
        return buscaBin(dato, 0, total - 1);
    }
    
    public int buscaBin(T dato, int min, int max){
        if(min > max)
            return (min + 1) * -1;
        
        else if(dato.compareTo(arreglo[(min + max)/2]) > 0)
            return buscaBin(dato, (min + max)/2 + 1, max );
        
        else if (dato.compareTo(arreglo[(min + max)/2]) < 0)
            return buscaBin(dato, min, (min + max)/2 - 1);
        else 
            return (min + max)/2;
    }
    
    public void recorreDer(int pos){
        for (int i = total; i > pos; i-- )
            arreglo[i] = arreglo[i - 1];
    }
    
    public int buscaSecuancial(T dato) {
       return buscaSecuencial(dato, total - 1); 
    }
    private int buscaSecuencial(T dato, int pos){
        if(pos == -1 || arreglo[pos].equals(dato)){
            return pos;
        }
        else
            return buscaSecuencial(dato, pos - 1);
    }
    
    public void imprime(){
        for(int i =0; i < total; i++){
            System.out.println(arreglo[i].toString());
        }
    }
    
    public String toString(){
        return toString(0, new StringBuilder());
    }
    
    private String toString (int ind, StringBuilder res){
        if(ind == total)
            return res.toString();
        
        else{
            res.append(arreglo[ind] + " ");
            return toString(ind + 1, res);
        }
    }
    
    
    public int maxEl() throws Exception{
        if(total == 0)
            throw new Exception();
        else
            return maxEl(0,0);
    }
   
    private int maxEl(int i, int mayor){
        if (i == total)
            return mayor;
        else{
            if (arreglo[mayor].compareTo(arreglo[i]) < 0)
                mayor = i;
            return maxEl(i + 1, mayor);
        }
    }
    
    
}
