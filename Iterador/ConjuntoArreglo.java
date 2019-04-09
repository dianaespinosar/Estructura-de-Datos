package ptscticar;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import static javafx.scene.input.KeyCode.T;

public class Ptscticar {

    public static String imprimeZigZag(int[][] sudoku, int tRen, int tCol){
        StringBuilder res = new StringBuilder();
        if(sudoku != null)
            return imprimeZigZag(sudoku, res, tRen, tCol, 0, 0);
        res.append("Es igual a null");
        return res.toString();
    }
    private static String imprimeZigZag(int[][] sudoku, StringBuilder res,int tRen,int tCol, int i, int j){
        //par es de derecha a izquierda
        //impar es de izquierda a derecha
        if(j == tCol || j == -1){
            res.append("\n");
            i++;
            if(i % 2 == 0)
                j = 0;
            else
                j = tCol - 1;
        }
        if(i < tRen){
            res.append(sudoku[i][j] + "  ");
            if(i % 2 == 0){
                return imprimeZigZag(sudoku, res, tRen, tCol, i, j + 1);
            }
            else{
                return imprimeZigZag(sudoku, res, tRen, tCol, i, j - 1);
            }
        }
        
        return res.toString();
    }
    
    public static String imprimeEspiral(int[][] sudoku, int tRen, int tCol){
        StringBuilder res = new StringBuilder();
        if(sudoku != null)
            return imprimeEspiral(sudoku, res, tRen, tCol, 0, 0, 0,0,'d');
        
        res.append("Es igual a null");
        return res.toString();
    }
    private static String imprimeEspiral(int[][] sudoku, StringBuilder res,int tRen,int tCol, int minRen, int minCol, int i, int j, char dir){
        //el char me va a ir diciendo la dirección que voy a tomar.
        if(minCol != tCol && minRen != tRen){
            res.append(sudoku[i][j] + "  ");
            switch (dir) {
            case 'd':
                if(j == tCol - 1){
                    res.append("\n");
                    return imprimeEspiral(sudoku, res, tRen, tCol, minRen + 1, minCol, i + 1, j, 's');
                }
                else
                    return imprimeEspiral(sudoku, res, tRen, tCol, minRen, minCol, i, j + 1, 'd');
                
            case 's':
                if(i == tRen - 1){
                    res.append("\n");
                    return imprimeEspiral(sudoku, res, tRen, tCol - 1, minRen, minCol, i, j - 1, 'a');
                }
                else
                    return imprimeEspiral(sudoku, res, tRen, tCol, minRen, minCol, i + 1, j, 's');
                
            case 'a':
                if(j == minCol){
                    res.append("\n");
                    return imprimeEspiral(sudoku, res, tRen - 1, tCol, minRen, minCol, i - 1, j, 'w');
                }
                else
                    return imprimeEspiral(sudoku, res, tRen, tCol, minRen, minCol, i, j - 1, 'a');
                
            case 'w':
                if(i == minRen){
                    res.append("\n");
                    return imprimeEspiral(sudoku, res, tRen, tCol, minRen, minCol + 1, i, j + 1, 'd');
                }
                else
                    return imprimeEspiral(sudoku, res, tRen, tCol, minRen, minCol, i - 1, j, 'w');
            default:
                break;
            }
        }
        
        
        
        
        
        return res.toString();
    }
    
    public static  boolean analizaDeportivos(ConjuntoArreglo cA, int n){
        if(cA != null ){
            Iterator it = cA.iterator();
            return analizaDeportivos(it, n, 0, false);
        }
        else 
            return false;
    }
    
     private static  boolean analizaDeportivos(Iterator it, int n, int cuenta, boolean res){
         Auto aux;
         if(!res && cuenta < n && it.hasNext()){
             aux = (Auto) it.next();
             if(aux.getMarca().equalsIgnoreCase("Audi") && aux.getPrecio() > 215000)
                 return analizaDeportivos(it, n, cuenta + 1, n == cuenta + 1);
             else
                 return analizaDeportivos(it, n, cuenta, res);
         }
         return res;
     }
     
     public static <T> boolean noHayVeinosIguales(ColaA a){
        ColaA aux = new ColaA();
        T num;
        boolean res;
        if(a != null && !a.estaVacia()){
            num = (T) a.quita();
            aux.agrega(num);
            res = noHayVecinosIguales(a, aux, true, num);
            cola(aux, a);
            cola(a, aux);
            return res;
        }
        else
            return true;
    }
     
     private static void cola(ColaADT a, ColaADT aux){
         if(!aux.estaVacia()){
             a.agrega(aux.quita());
             cola(a, aux);
         }
     }
     private static <T> boolean noHayVecinosIguales(ColaA a, ColaA aux, boolean res, T num){
         T auxi;
         if(res && !a.estaVacia()){
             auxi = (T) a.quita();
             aux.agrega(auxi);
             return noHayVecinosIguales(a, aux, auxi != num, auxi);
         }
         return res;
     }
     
     public static <T> boolean cambiaPosicionDe(ColaADT<T> cola, T dato, int n){
         ColaADT<T> auxi = (ColaADT) new ColaA();
         boolean res;
          if(cola != null){
              res = cambiaPosicionDe(cola, auxi, dato, n, 1, n == 1, -1, false);
              cola(cola, auxi);
              return res;
          }
          else
               throw new NullPointerException();
     }
    
    private static <T> boolean cambiaPosicionDe(ColaADT<T> cola, ColaADT<T> auxi, T dato, int n, int posActual, boolean res, int posDato, boolean ans){
        T aux;
        if(!cola.estaVacia() && !res){
            aux = cola.quita();
            System.out.println("res es false y el número de mi posición es " + aux);
            System.out.println("Posición actual es " + posActual);
            if(aux.equals(dato)){
                posDato = posActual;
                aux = cola.quita();
            }
            
            auxi.agrega(aux);
            
            
            return cambiaPosicionDe(cola, auxi, dato, n, posActual + 1, posActual  + 1 == n, posDato, ans);
        }
        if(res){
            System.out.println("Res es true");
            auxi.agrega(dato);
            ans = true;
            res = false;
            return cambiaPosicionDe(cola, auxi, dato, n, posActual, res, posDato, ans);
        }
        if(posActual == -1)
            ans = false;
        return ans;
        
    }
    
    public static <T> boolean esSubConjuntoDe(ConjuntoADT<T> uno, ConjuntoADT<T> dos){
        
        if(uno != null && dos != null){
            
            Iterator it = ((ConjuntoArreglo)uno).iterator();
            
            return esSubConjuntoDe(uno, (ConjuntoArreglo)dos, true);
        }
        else
               throw new NullPointerException();
    }
    
    public static <T> boolean esSubConjuntoDe(Iterator it, ConjuntoArreglo<T> dos, boolean res){
        if(res && it.hasNext()){
            if(!dos.contiene((T) it.next())){
                res = false;
            }
            return esSubConjuntoDe(it, dos, res);
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        /*int [][] sudoku = { {1, 5, 0, 6, 0, 3, 0, 2, 9},
                            {9, 0, 0, 7, 4, 0, 3, 7, 8},
                            {3, 4, 0, 0, 0, 8, 0, 0, 0},
                            {5, 1, 0, 0, 8, 0, 9, 0, 0},
                            {0, 0, 2, 0, -5, 0, 6, 1, 0},
                            {0, 0, 0, 3, 0, 0, 2, 0, 0},
                            {7, 3, 5, 8, 0, 0, 0, 0, 6},
                            {0, 8, 0, 0, 0, 0, 0, 4, 0},
                            {0, 6, 9, 0, 0, 0, 8, 0, 0}};

        //System.out.println(imprimeEspiral(sudoku, 3, 3));
        
        Auto a = new Auto( "BMW", 'r', 2016, 123456);
        Auto b = new Auto("Audi", 'a', 2017, 234567);
        Auto c = new Auto("Nissan", 'n', 2017, 200000);
        Auto d = new Auto("Audi", 'g', 2805, 199999);
        Auto e = new Auto("Nissan", 'b', 2013, 234000);
        Auto f = new Auto("Audi", 'n', 2019, 300123);
        System.out.println("va bien");
        ConjuntoArreglo<Auto> cA = new ConjuntoArreglo();
        System.out.println("va bien");
                
        cA.agrega(a);
        cA.agrega(b);
        cA.agrega(c);
        cA.agrega(d);
        cA.agrega(e);
        cA.agrega(f);
        System.out.println(analizaDeportivos(cA, 2));
        
        /*
        ColaA a = new ColaA();
        a.agrega('a');
        a.agrega('b');
        a.agrega('c');
        a.agrega('d');
        a.agrega('e');
        a.agrega('a');
        a.agrega('f');
        a.agrega('t');
        a.agrega('e');
        a.agrega('a');
        a.agrega('c');
        a.agrega('d');
        System.out.println(a.imprime());
        System.out.println(noHayVeinosIguales(a));
        System.out.println(a.imprime());
        ColaADT b;
        b = (ColaADT) new ColaA();
        b.agrega('a');
        b.agrega('b');
        b.agrega('c');
        b.agrega('d');
        b.agrega('e');
        b.agrega('f');
        b.agrega('g');
        b.agrega('h');
        b.agrega('i');
        b.agrega('j');
        b.agrega('k');
        System.out.println(cambiaPosicionDe(b, 'd', 3));       
        System.out.println(b.imprime());
        */
        ConjutoArreglo uno = new ConjuntoArreglo();
    }
    
    
    
}
