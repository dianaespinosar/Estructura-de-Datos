
package problema10;

public class Escolar  extends DePasajeros{
    boolean lugarProyecto;
    
    public Escolar(){
        
    }

    public Escolar(String marca, String numMotor, String placas, 
        double costoCamion, int totalPasaj, boolean lugarProyecto) {
        super(marca, numMotor, placas, costoCamion, totalPasaj);
        this.lugarProyecto = lugarProyecto;
    }
    
    public double calculaCostoServicio(){
        double costo = super.calculaCostoServicio(250);
        return costo;
    }
}
