package ColasUso;

import MAG.ManejadorArregloGenerico;


public class problema37 {
    public static ColaA<Persona> reacomodoEdad(ColaA<Persona> personas){
        int total = personas.cuentaElementos();
        Persona[] aux = new Persona[total];
        Persona ele;
        
        while(!personas.isEmpty()){
            ele = personas.quita();
            ManejadorArregloGenerico.insertaOrdena(aux, total, ele );
        }
        for(int i = total - 1; i >= 0; i--){
            personas.agrega(aux[i]);
        }
        return personas;
    }
}
