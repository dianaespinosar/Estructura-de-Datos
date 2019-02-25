package problema8;

public class Triangulo implements FigGeometrica{
    private double l1,l2,l3;
    
    public Triangulo() {
    }
    
    
    public Triangulo(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }
  
    public double getL1() {
        return l1;
    }
    public double getL2() {
        return l2;
    }
    public double getL3() {
        return l3;
    }
    
   
    public double calculaArea(){
        double s = calculaPerim()/2;
        double area = Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));
        return area;
    }
    
    public double calculaPerim(){
        return l1 + l2 + l3;
    }
    
    public void imprime(){
        System.out.println("Área: " + calculaArea());
        System.out.println("Perímetro: " + calculaPerim() + "\n");
    }
    
    public String toString() {
        return "Triangulo{" + "Lado 1 = " + l1 + ", Lado 2 = " + l2 + ", Lado 3 = " + l3 + '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean ans = false;
       if(obj != null && obj instanceof Triangulo){
           Triangulo t = (Triangulo)obj;
           ans = l1 == t.l1 && l2 == t.l2 && l3 == t.l3;
       }
       return ans;
    }
    
    
    public String tipo (){
       String tipo;
        if(l1 == l2  ) {
            if(l2 == l3){
                tipo =  "equilátero";
            }
            else
                tipo = "isósceles";
       
        }
        
        else
            tipo = "escaleno";
        
        return tipo ;
    }
    
}
