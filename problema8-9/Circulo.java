package problema8;

public class Circulo implements FigGeometrica {
    private double radio;    
    
  public Circulo() { 
  }
  Circulo(double radio) {
    this.radio= radio;
  }
  
  public double getRadio() {
    return radio;
  }

  public double calculaArea() {
    return Math.PI * Math.pow(radio,2);
  }
  
  public double calculaPerim() {
    return (Math.PI * 2 * radio);
  }
  
  public void imprime() {
    System.out.println("Área= " + calculaArea() + ", Perímetro= " +
            calculaPerim() + '\n');
  }

  public String toString() {
    return "Radio = " + radio;
  }
}
