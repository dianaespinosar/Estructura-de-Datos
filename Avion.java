package problema7;

public class Avion implements ObjVolador {
    
    private static int serie = 100;
    private int clave;
    private int pasajeros;
    private int numVuelo;
    
    public Avion(){
        clave = serie;
        serie ++;
    }
    
    public Avion(int clave){
        this.clave = clave;
    }
    
    public Avion(int pasajeros, int numVuelo) {
        this();
        this.pasajeros = pasajeros;
        this.numVuelo = numVuelo;
    } 

    @Override
    public boolean equals(Object obj) {
        Avion a = (Avion)obj;
        return clave == a.clave;
    }
    
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append("Clave:" + clave).append("Número de vuelo: " + numVuelo);
       res.append("Número de pasajeros: " + pasajeros);
       return res.toString();
    }
    
    
    

    @Override
    public void despegar(double v0, double angulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aterrizar(double vF, double angulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seDeplaza(double disX, double disY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
