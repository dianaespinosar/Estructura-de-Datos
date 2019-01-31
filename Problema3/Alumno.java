package estructuradiana;

public class Alumno {
    private static int serie = 100;
    private int claveUnica;
    private String nombreAl;
    private double[] calificaciones;
    private int tC;
    private final int MAX_CAL = 10;
    
    public Alumno() {
        calificaciones = new double[MAX_CAL];
        tC = 0;     
        claveUnica = serie;
        serie++;
    }
    
    public Alumno (String nombre) {
        this();
        nombreAl = nombre;
    }

    public String getNombreAl() {
        return nombreAl;
    }
    
    
    public boolean altaCalificion(double cal) {
        boolean res = false;
        if (tC < MAX_CAL) {
            calificaciones[tC] = cal;
            tC++;
            res = true;
        }
        
        return res;
    }
    
    public double promedio() {
        double prom = 0;
        for (int i = 0; i < tC; i++) {
            prom += calificaciones[i];
        }
        
        prom /= tC;
        return prom;        
    }

    public int getClaveUnica() {
        return claveUnica;
    }


    public boolean equals(Object obj) {
        Alumno a = (Alumno)obj;
        
        return  claveUnica == a.claveUnica;
    }
    
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Nombre: " + nombreAl);
        res.append("\nClave Única: " + claveUnica + "\n");
        for (int i = 0;  i < tC; i++){
            res.append(calificaciones[i] + "\n");
        }
        res.append("Promedio: " + promedio());   
        return res.toString();
        
    }
    
    public int materiasAprobadas() {
        int mA = 0;
        for ( int i = 0; i < tC ; i++) {
            if (calificaciones[i] >= 6) 
                mA++;
        }
        return mA;
    }    
}
