package problema10;

public class DeVolteo extends Camion {
    private double capacidadTon;

    public DeVolteo() {
    }

    public DeVolteo(String marca, String numMotor, String placas, double capacidadTon) {
        super(marca, numMotor, placas);
        this.capacidadTon = capacidadTon;
    }
    
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(super.toString());
        res.append("\nCapacidad de toneladas: " + capacidadTon);
        return res.toString();
    }

    public double getCapacidadTon() {
        return capacidadTon;
    }

    public void setCapacidadTon(double capacidadTon) {
        this.capacidadTon = capacidadTon;
    }
    
    
    
}
