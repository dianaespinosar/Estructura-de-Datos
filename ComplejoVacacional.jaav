package estructuradiana;

public class ComplejoVacacional {
    private String nombre;
    private Rectangulo[] albercas;
    private final int MAX_AL = 10;
    private int tA;
 
    
    public ComplejoVacacional(){
        albercas = new Rectangulo[MAX_AL];
        tA = 0; 
    }

    public ComplejoVacacional(String nombre) {
       this();
       this.nombre = nombre;
    }

    
    public boolean agregaAl(double base, double altura){
        
        boolean res = false;
        if(tA < MAX_AL){
            albercas[tA] = new Rectangulo(base, altura);
            res = true;
            tA++;
        }
        return res;
    }
    
    public double totalLona(){
        double totalArea = 0;
        for(int i = 0; i < tA; i++){
            totalArea =+ albercas[i].Area();
        }
        
        return totalArea;
    }
    
    public double totalCerca(){
        double totalPeri = 0;
        for(int i = 0; i < tA; i++){
            totalPeri =+ albercas[i].Perimetro();
        }
        
        return totalPeri;
    }

}
