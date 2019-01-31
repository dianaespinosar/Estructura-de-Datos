package problema4;

public class Operario extends Empleado{

    private int horasExt;
    
    public Operario(){
        super();
    }
    
    public Operario(String nombre, double sueldo, int horasExt) {
        super(nombre, sueldo);
        this.horasExt = horasExt;
    }
   
    public String toString() {
        StringBuilder cad = new StringBuilder();
        cad.append(super.toString());
        cad.append("\nTrabajó " + horasExt + " horas.");
        return cad.toString();
    }
    
    public double calculaSalario(double prestac, double deduc, double precioHE) {
        
        return calculaSalario(prestac, deduc) + horasExt * precioHE;
    }
}
