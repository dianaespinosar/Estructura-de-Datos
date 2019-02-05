package problema8;

public abstract class Cuadrilatero implements FigGeometrica{
    
    private double lado1, lado2;
    
    
    public Cuadrilatero(double lado1, double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double calculaArea() {
        return  lado1 * lado2;
    }

    @Override
    public double calculaPerim() {
        
        return 2 * (lado1 + lado2);
    }

    @Override
    public void imprime() {
         System.out.println("Área: "+calculaArea());
        System.out.println("Perímetro: "+calculaPerim()+"\n");
        
    }   
     
    public String toString() {
       return "Lado 1 = " + lado1 + "\nLado 2 = " + lado2;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean ans = false;
       if(obj != null && obj instanceof Triangulo){
           Cuadrilatero t = (Cuadrilatero)obj;
           ans = lado1 == t.lado1 && lado2 == t.lado2;
       }
       return ans;
    }
}