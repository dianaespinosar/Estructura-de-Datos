
package problema7;

import estructuradiana.ManejadorArregloGenerico;


public class Problema7 {
    private Avion[] aviones;
    private Pajaro[] pajaros;
    private int tA;
    private int tP;
    private final int MAX_VOLADOR = 10;
    
    public Problema7(){
        aviones = new Avion[MAX_VOLADOR];
        pajaros = new Pajaro[MAX_VOLADOR];
        tA = 0;
        tP = 0;
    }
    
    public boolean alta(String especie, String habitat) {
        boolean resp = false;
        if(pajaros.length > tP ) {
            resp = true;
            pajaros[tP] = new Pajaro(especie, habitat);
            tP++;
        }
        
        return resp;
    }
    
    public boolean alta(int pasajeros, int numVuelo) {
        boolean resp = false;
        if(aviones.length > tA ) {
            resp = true;
            aviones[tA] = new Avion(pasajeros, numVuelo);
            tA++;
        }
        
        return resp;
    }
    
    public String buscaP(int clave) {
        String res ;
        int pos;
        Pajaro a = new Pajaro(clave);
        pos = ManejadorArregloGenerico.buscaGenerica(pajaros, tP, a);
        if(pos < 0)
            res = "No se encontró pájaro con clave " + clave;
        
        else 
            res = pajaros[pos].toString();
        
        return res;
    }
    
    public String buscaA(int clave) {
        String res ;
        int pos;
        Avion a = new Avion(clave);
        pos = ManejadorArregloGenerico.buscaGenerica(aviones, tA, a);
        
        if(pos < 0)
            res = "No se encontró avión con clave " + clave;
        else 
            res = aviones[pos].toString();
        
        return res;
    }
    
    public boolean cambiaHabitat(int clave, String habitat){
        boolean res ;
        int pos;
        Pajaro a = new Pajaro(clave);
        pos = ManejadorArregloGenerico.buscaGenerica(pajaros, tP, a);
        if(pos < 0)
            res = false;
        
        else {
            res = true;
            pajaros[pos].setHabitat(habitat);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Problema7 prueba = new Problema7();
        prueba.alta("perico","Nueva Zelanda");
        prueba.alta("guacamaya", "Selva");
        prueba.alta("avestruz", "Desierto");
        prueba.alta(26, 234);
        prueba.alta(31, 987);
        System.out.println(prueba.buscaP(102));
        if(prueba.cambiaHabitat(102, "Jungla"))
            System.out.println("Se cambió el hábitat correctamente");
        
        
    }
}
