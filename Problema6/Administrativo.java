
package problema6;

public class Administrativo extends Empleado {
    private String departamento;
    private String telefono;
    
    public Administrativo(){
        
    }
    
    public Administrativo (String nombre, double sueldo, String departamento, String telefono) {
        super(nombre, sueldo);
        this.departamento = departamento;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        cad.append(super.toString());
        cad.append("\nDepartamento: " + departamento);
        cad.append("\nTeléfono: " + telefono);
        return cad.toString(); 
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public double calculaSalario(double prestac, double deduc) {
       return sueldoBase * (1 + prestac - deduc);
    }
    
    
}
