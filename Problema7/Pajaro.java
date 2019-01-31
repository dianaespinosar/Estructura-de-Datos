package problema7;

public class Pajaro implements ObjVolador{
    private static int serie = 100;
    private int clave;
    private String especie;
    private String habitat;
    
    public Pajaro(){
        clave = serie;
        serie ++;
    }
    
    public Pajaro(int clave) {
        this.clave = clave;
    }
    
    public Pajaro(String especie, String habitat){
        this();
        this.especie = especie;
        this.habitat = habitat;
    }

    @Override
    public boolean equals(Object obj) {
        Pajaro a = (Pajaro)obj;
        return clave == a.clave;
    
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append("Clave:" + clave).append("Especie: " + especie);
       res.append("Hábitat: " + habitat);
       return res.toString();
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    
        
    @Override
    public void despegar(double v0, double angulo) {
        
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
