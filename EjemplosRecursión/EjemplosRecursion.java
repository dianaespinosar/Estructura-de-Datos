package EjemplosRecursion;

public class EjemplosRecursion {
    
    public static long calFactorial(int n){
        if (n == 1 || n == 0)
            return 1;
        else
            return calFactorial(n - 1) * n;
        
    }
    
    public static int calFibonacci(int n){
        if(n == 0 || n == 1)
            return n;
        
        else 
            return calFibonacci(n - 2) + calFibonacci(n - 1);
               
    }
    
    public static int sumaArre(int[] array, int tA){
        
        return sumaArre(array, tA - 1, 0);
    }
    //te sirve cuando necesitas más información
    private static int sumaArre(int[] array, int tA, int ind){
        if (tA == ind)
            return 0;
        else
            return sumaArre(array, tA - 1, ind + 1) + array[ind];
    }
        //te sirve cuando ocupas más información

    //Es buena, ya que no usa memoria o tiempo extra
    public static void impArreDI(int []arre, int tot){
        if(tot > 0){
            System.out.println(arre[tot - 1] +" ");
            impArreDI(arre, tot - 1);
        }
    }
    
    public static void imArreID(int [] arre, int tot){
        impArreDI(reverse(arre, tot), tot);
    }
    
    public static int [] reverse(int[] arre, int tot){
        int[] arr = new int [tot];
        for (int i = 0; i < tot; i++)
            arr[i] = arre[tot - 1 - i];
        return arr;
    }
    
    public static void impArreID(int[] arre, int tot){
        if(tot > 0){
            impArreID(arre, tot - 1);
            System.out.println(arre[tot - 1] +" ");
            
        }
    }
    
    public static <T> void impArreglo(T[] arre, int tot){
       impArreglo(arre, tot, 0);
   }
   
    public static <T> void impArreglo(T[] arre, int tot, int ind){
        if (ind < tot){
            System.out.print(arre[ind] + " ");
            impArreglo(arre, tot, ind+1);
        }
    }
    
    
    
    
    public static void main(String[] args) {
        /*System.out.println(calFibonacci(6));
        int[] arre = {1,2, 6, 8, 9};
        imArreID(arre, arre.length);
        impArreID(arre,arre.length);*/
        Arreglogenerico a = new Arreglogenerico();
        a.alta(4.5);
        a.alta(1.09);
        a.alta(9.12);
        a.alta(5.8);
        a.alta(2.4);
        a.imprime();
     }
        
}
