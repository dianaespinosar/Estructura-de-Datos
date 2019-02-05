package problema8;

import estructuradiana.ManejadorArregloGenerico;

public class problema9 {
    
    private FigGeometrica[] figuras;
    private int tF;
    private final int MAX_FIGURAS = 10;
    
    public problema9(){
        figuras = new FigGeometrica[MAX_FIGURAS];
        tF = 0;
    }
    
    public boolean alta(double lado1, double lado2, double lado3) {
        boolean resp = false;
        if(figuras.length > tF ) {
            resp = true;
            figuras[tF] = new Triangulo(lado1, lado2, lado3);
            tF++;
        }
        
        return resp;
    }
     public boolean alta(double lado1, double lado2) {
        boolean resp = false;
        if(figuras.length > tF ) {
            resp = true;
            tF++;
            if(lado1 == lado2)
                figuras[tF] = new Cuadrado(lado1);
            else 
                figuras[tF] = new Rectangulo(lado1, lado2);
            
        }
        
        return resp;
    }
     
     public boolean alta(double radio) {
        boolean resp = false;
        if(figuras.length > tF ) {
            resp = true;
            figuras[tF] = new Circulo(radio);
            tF++;
        }
        
        return resp;
    }
    
     public double calArea(){
        double total = 0;
        for (int i = 0; i < tF; i++)
            total += figuras[i].calculaArea();
        return total;
    }
    
    public String encCirculoMayor() {
        double max = -1;
        double temp;
        int pos = -1;
        String res;
        for (int i = 0; i < tF; i++){
            if(figuras[i]instanceof Circulo ){
                temp = ((Circulo)figuras[i]).getRadio();
                if(max < temp){
                    max = temp;
                    pos = i;
                }
            }   
            
        }
        
        if (max > 0 ) {
            res = figuras[pos].toString();
        }
            
        else
            res = null;
        
        return res;
    } 
    
    public int cuentaFigura(String nom) {
        int count = 0;
        for(int i = 0; i < tF; i++){
            if(figuras[i].getClass().getSimpleName().equals(nom))
                count++;
        }
        
        return count;
    }
    
    public int bajaEquilateros(){
        int count = 0;
        int i = 0;
        while (i < tF){
            if(figuras[i]instanceof Triangulo && 
                ((Triangulo)figuras[i]).tipo().equals("equilátero")) {
                ManejadorArregloGenerico.recorreIzq(figuras, tF, i);
                figuras[tF - 1] = null;
                tF--;
                count++;
            }
            
            else
                i++;
        }
        
        return count;
    }
    
    
    public static void main(String[] args) {
    
        
        
    }
    
}
