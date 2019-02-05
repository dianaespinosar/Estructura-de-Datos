package problema10;

public class EmpresaMinera {
    private String nombreEmpresa;
    private Camion[] camiones;
    private int totalCam;
    private final int MAX_CAM = 10;

    public EmpresaMinera() {
        camiones = new Camion[MAX_CAM];
        totalCam = 0;
    }

    public EmpresaMinera(String nombreEmpresa) {
        this();
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public boolean alta(String marca, String numMotor, String placas, int totalPasaj){
        boolean res = false;
        if(totalCam < MAX_CAM ) {
            camiones[totalCam] = new DePasajeros(marca, numMotor, placas, totalPasaj);
            res = true;
            totalCam++;
        }
        return res;
    }
    
    public boolean alta(String marca, String numMotor, String placas, double capacidadTon){
        boolean res = false;
        if(totalCam < MAX_CAM ) {
            camiones[totalCam] = new DeVolteo(marca, numMotor, placas, capacidadTon);
            res = true;
            totalCam++;
        }
        return res;
    }
    
    public String infoTipoCamion(String nom){
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < totalCam; i++){
            if(camiones[i].getClass().getSimpleName().equals(nom))
                res.append(camiones[i].toString() + "\n");
        }
        
        if(res == null )
            res.append("No hay camiones " + nom);
        
        return res.toString();
    }
    
   public boolean actualizaCapTon(String placas, double capacidad){
       boolean ans = false;
       int i = 0;
       while (i < totalCam && !camiones[i].getPlacas().equals(placas))
           i++;
       if (i < totalCam && camiones[i] instanceof DeVolteo){
           ((DeVolteo)camiones[i]).setCapacidadTon(capacidad);
           ans = true;
       }
       return ans;
   }
   
   public int marcaPasajeros(String marcas){
       int count = 0;
       
       for (int i = 0; i < totalCam; i++){
            if(camiones[i] instanceof DePasajeros && 
               camiones[i].getMarca().equals(marcas)) {
               count++;
            }
       }
       return count;
   }
 

    public double totalTon(){
        double ton  = 0;
        
        for (int i = 0; i < totalCam; i++){
            if(camiones[i] instanceof DeVolteo)) {
                ton += ((DeVolteo)camiones[i]).getCapacidadTon();
            }
       }
       
       
       return ton;
   }
}
