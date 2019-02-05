package problema10;

public class DePasajeros extends Camion{
    private int totalPasaj;
    
    
    public DePasajeros(){
        
    }
    
    public DePasajeros(String marca, String numMotor, String placas, int totalPasaj){
        super(marca, numMotor, placas);
        this.totalPasaj = totalPasaj;
    }

   
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(super.toString());
        res.append("\nTotal de pasajeros: " + totalPasaj);
        return res.toString();
    }

    public int getTotalPasaj() {
        return totalPasaj;
    }

    public void setTotalPasaj(int totalPasaj) {
        this.totalPasaj = totalPasaj;
    }
    
    
}
