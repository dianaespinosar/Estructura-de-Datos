package ptscticar;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
    
    public static  boolean analizaDeportivos(ConjuntoADT<Auto> cA, int n){
        if(cA != null ){
            Iterator it = cA.iterator();
            return analizaDeportivos(it, n, 0, false);
        }
        else 
            return false;
    }
    
     private static  boolean analizaDeportivos(Iterator it, int n, int cuenta, boolean res){
         if(!res && cuenta < n){
             if()
         }
         return res;
     }
    
    public static void main(String[] args) {
        int [][] sudoku = { {1, 5, 0, 6, 0, 3, 0, 2, 9},
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
        Auto d = new Auto("Audi", 'g', 2015, 199999);
        Auto e = new Auto("Nissan", 'b', 2013, 234000);
        Auto f = new Auto("Audi", 'n', 2019, 300123);
        ConjuntoADT<Auto> cA = (ConjuntoADT<Auto>) new ConjuntoArreglo();
        cA.agrega(a);
        cA.agrega(b);
        cA.agrega(c);
        cA.agrega(d);
        cA.agrega(e);
        cA.agrega(f);
        
            
        
        
    }
    
    
    
}
