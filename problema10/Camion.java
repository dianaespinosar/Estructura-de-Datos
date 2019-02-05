package problema10;

public abstract class Camion {
    private String marca;
    private String numMotor;
    private String placas;
    
    public Camion(){
        
    }
    
    public  Camion (String marca, String numMotor, String placas) {
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
        
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
    
    
    
}
