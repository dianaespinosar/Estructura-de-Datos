package estructuradiana;

public class Rectangulo {
    private double base;
    private double altura;
    
    public Rectangulo(){
        
    }
    
    public Rectangulo(double base, double altura) {
        this.altura = altura;
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBase(double base) {
        this.base = base;
    }
    
     public double Area() {
        return base * altura;
    }
     
    public double Perimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Base: " + base).append("\nAltura: " + altura);
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
