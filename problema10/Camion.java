package problema10;

import java.io.Serializable;

public abstract class Camion implements Serializable {
    private String marca;
    private String numMotor;
    private String placas;
    private double costoCamion;
    
    public Camion(){
        
    }
    
    public  Camion (String marca, String numMotor, String placas) {
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
        
    }
    
    public  Camion (String marca, String numMotor, String placas, double costoCamion) {
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
        this.costoCamion = costoCamion;
        
    }
    
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Marca: " + marca + "\nNúmero de motor: " + numMotor);
        res.append("\nPlacas : " + placas);
        
        
        return res.toString();
    }

    
    public boolean equals(Object obj) {
        Camion a = (Camion)obj;
        
        return placas.equals(a.placas);
    }

    public String getMarca() {
        return marca;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public String getPlacas() {
        return placas;
    }

    public double getCostoCamion() {
        return costoCamion;
    }
    
    
}
