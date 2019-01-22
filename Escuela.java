package estructuradiana;

import java.util.ArrayList;

public class Escuela {
    private String nombre;
    private String direccion;
    private Alumno[] alumnos;
    private int tA;
    private final int MAX_ALUMNOS = 50;
    
    public Escuela() {
        alumnos = new Alumno[MAX_ALUMNOS];
        tA = 0;
    }
    
    public Escuela(String nombre, String direccion) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public boolean altaAlumnos (String nombre) {
        boolean res = false;
        if (tA < MAX_ALUMNOS) {
            alumnos[tA] = new Alumno(nombre);
            res = true;
            tA++;
        }
        
        return res;
    }
    
    public boolean altaCal(int clave, double cal) {
       boolean res = false;
       int i = 0;
       while (alumnos[i].getClaveUnica() != clave && i < tA)
           i++;
       if (alumnos[i].altaCalificion(cal))
           res = true;
       
       return res;
    }
    
    public String  boletaAlumno(int clave) {
        int i = 0;
        while (alumnos[i].getClaveUnica() != clave && i < tA)
            i++;
        return alumnos[i].toString();
    }
    
    public String infoAlumnos() {
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < tA; i++) {
            res.append("Nombre: " + alumnos[i].getNombreAl() + "\nPromedio: " +
                alumnos[i].promedio() + "\n");
        }
        return res.toString();
    }
        
    public  String alumnoMaAp () {
        int alAp = 0;
        for (int i = 0; i < tA; i++) {
            if (alumnos[i].materiasAprobadas() > alumnos[alAp].materiasAprobadas())
                alAp = i;
        }
        
        return alumnos[alAp].getNombreAl();
    }
    public ArrayList<String> mejoresAlumnos() {
        int alAp = 0;
        ArrayList<String> res = new ArrayList();
        for (int i = 0; i < tA; i++) {
            if(alumnos[i].materiasAprobadas() == alumnos[alAp].materiasAprobadas())
                res.add(alumnos[i].getNombreAl());
            
            if (alumnos[i].materiasAprobadas() > alumnos[alAp].materiasAprobadas()){
                alAp = i;
                res.clear();
                res.add(alumnos[alAp].getNombreAl());
            }
                
        }
        
        return res;
    }

}
