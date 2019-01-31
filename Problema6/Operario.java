
package problema6;
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
 

    @Override
    public double calculaSalario(double prestac, double deduc) {
         return sueldoBase * (1 + prestac - deduc);
    }
    
    public double calculaSalario(double prestac, double deduc, double precio) {
         return calculaSalario(prestac, deduc) + horasExt * precio;
    }
}
