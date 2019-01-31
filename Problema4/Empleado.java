package problema4;

public class Empleado {
    private static int serie = 100;
    private int claveEmpleado;
    private String nombreEmpleado;
    private double sueldoBase;
    
    public Empleado(){
        claveEmpleado = serie;
        serie++;
    }
     public Empleado(int clave) {
        claveEmpleado = clave;
    }
    
    public Empleado (String nombre, double sueldo) {
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
    
    public double calculaSalario (double prestac, double deduc) {
        return sueldoBase * (1 +(prestac - deduc) / 100);
    }
    
    
}
