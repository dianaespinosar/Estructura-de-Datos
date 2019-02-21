package problema10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EmpTransp implements Serializable{
    String nombreEmp;
    int tC;
    private Camion[] camiones;
    private final int MAX_CAM = 15;
    

    public EmpTransp() {
        tC = 0;
        camiones = new Camion[MAX_CAM]; 
        
    }

    public EmpTransp(String nombreEmp) {
        this();
        this.nombreEmp = nombreEmp;
        
    }
    
    public String infoTipoCamion(String nom){
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < tC; i++){
            if(camiones[i].getClass().getSimpleName().equals(nom))
                res.append(camiones[i].toString() + "\n");
        }
        
        if(res == null )
            res.append("No hay camiones " + nom);
        
        return res.toString();
    }
        
    
    public boolean alta(String marca, String numMotor, String placas,
        double costoCamion, int totalPasaj, boolean lugarProyecto){
        boolean res = false;
        if(tC < MAX_CAM ) {
            camiones[tC] = new Escolar(marca, numMotor, placas, 
                costoCamion, totalPasaj, lugarProyecto);
            res = true;
            tC++;
        }
        return res;
    }
    
    public boolean alta(String marca, String numMotor, String placas, 
        double costoCamion, int totalPasaj, boolean asientoCama, boolean serviBar){
        boolean res = false;
        if(tC < MAX_CAM ) {
            camiones[tC] = new Turismo(marca, numMotor, placas, costoCamion,
                totalPasaj, asientoCama, serviBar);
            res = true;
            tC++;
        }
        return res;
    }
    
    public void lee(String nombreArchivo) {
        try(
            FileInputStream file = new FileInputStream(nombreArchivo);
            ObjectInputStream lee = new ObjectInputStream(file);){
                Object o;
                int i = 0;
                o = lee.readObject();
                while(o != null && i < camiones.length){
                    if(o instanceof Camion){
                        camiones[i] = (Camion)o;
                        i++;
                    }
                    o = lee.readObject();

                }
                lee.close();
        }catch(Exception e){
                System.out.println("\nError"+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        EmpTransp elRapido = new EmpTransp("El Rápido");
        
        
        Turismo a = new Turismo("Tesla", "23G", "UBG356", 234567, 34, true, false);
        Escolar b = new Escolar("Honda", "12G", "UOH123", 123445, 22, false);
        Turismo c = new Turismo("Tesla", "23G", "UBG356", 139597, 34, false, false);
        Escolar d = new Escolar("Honda", "12G", "UOH123", 155575, 22, false);
        Escolar e = new Escolar("Honda", "12G", "UOH123", 82345, 22, true);
        Turismo f = new Turismo("Tesla", "23G", "UBG356", 274517, 34, true, true);
       
        try(FileOutputStream file = new FileOutputStream("ejemplo");
            ObjectOutputStream salida = new ObjectOutputStream(file);){
            salida.writeObject(a);
            salida.writeObject(b);
            salida.writeObject(c);
            salida.writeObject(d);
            salida.writeObject(e);
            salida.writeObject(f);
        
        }catch(Exception ex){
            System.out.println("\nError "+ex.getMessage());
        }
        
        elRapido.lee("ejemplo");
    }
    
    
}
