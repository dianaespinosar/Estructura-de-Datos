
package problema6;

public abstract class Empleado {
    private static int serie = 100;
    private int claveEmpleado;
    private String nombreEmpleado;
    protected double sueldoBase;
    
    protected Empleado(){
        claveEmpleado = serie;
        serie++;
    }
    
    protected Empleado (String nombre, double sueldo) {
        nombreEmpleado = nombre;
        sueldoBase = sueldo;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getClaveEmpleado() {
        return claveEmpleado;
    }
   public void actSB(double por) {
       sueldoBase *= (1 + (por/100));

   }
   

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract double calculaSalario (double prestac, double deduc);
    
    
}