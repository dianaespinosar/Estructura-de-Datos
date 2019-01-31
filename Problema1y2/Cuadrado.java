package estructuradiana;

public class Cuadrado {
    private double lado;
    
    public Cuadrado(){
        
    }
    
    public Cuadrado(double lado){
        this.lado = lado;
        
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Lado: " + lado;
    }
    
    public double Area() {
        return lado * lado;
    }
    
    public double Perimetro() {
        return 4 * lado;
    }
      
}
