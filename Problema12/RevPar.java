package problema12;

import pilaUso.EmptyCollectionException;
import pilaUso.PilaA;

public class RevPar {
    private String oper;
    
    public RevPar(String oper) {
        this.oper = oper;
    }
    
    public boolean revisaParentesis(){
        boolean res = true;
        PilaA<Character> pila = new PilaA();
        int i = 0;
        while(i < oper.length() && res){
            if(oper.charAt(i) == '(')
                pila.push(oper.charAt(i));
            
            else if(oper.charAt(i) == ')') {
                try{
                    pila.pop();
                } catch(EmptyCollectionException e){
                    System.out.println("Error ')'");
                    res = false;
                    
                }
            }   
            
            i++;
        }
        if(res)
            res= pila.isEmpty();
        
        return res;
    }
    
    public static void main(String[] args) {
        String oper1 = "2*3+(3*4)";
        String oper2 = "(2*3+(3*4)";
        String oper3 = "(2*3)+(3*4)";
        String oper4 = "2*(3+(3*4)))";
        String oper5 = "(2*(3+(3*4)))";
        
        RevPar opera1 = new RevPar(oper1);
        RevPar opera2 = new RevPar(oper2);
        RevPar opera3 = new RevPar(oper3);
        RevPar opera4 = new RevPar(oper4);
        RevPar opera5 = new RevPar(oper5);
        
        System.out.println(opera1.revisaParentesis());
        System.out.println(opera2.revisaParentesis());
        System.out.println(opera3.revisaParentesis());
        System.out.println(opera4.revisaParentesis());
        System.out.println(opera5.revisaParentesis());
        
        
        
    }
}
        



                    
