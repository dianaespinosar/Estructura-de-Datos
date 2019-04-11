package ColasUso;

import static javafx.scene.input.KeyCode.T;

public class  Persona implements Comparable <Persona> {
    private String curp;
    private int añoNac;

    public Persona ( String curp) {
            this.curp = curp;
    }

    public int calEdad() {
            int dig1, dig2;
            dig1 = curp.charAt(4) - '0';
            dig2 = curp.charAt(5) - '0';
            añoNac = 1900 + dig1 * 10 + dig2;
            if (añoNac >= 100) 
                    añoNac = añoNac + 100;
            return 2019 - añoNac;
    }

    public String genero() {
            String genero;
            if (curp.charAt(10) == 'M') {
                    genero = "Mujer";
            }

            else 
                    genero = "Hombre";
            return genero;
    }

    public String nacionalidad( ) {
            String nacionalidad;
            if (curp.charAt(11) == 'N' && curp.charAt(12) == 'E') {
                    nacionalidad = "Nacido en el Extranjero";
            }

            else 
                    nacionalidad = "Nacido en México";
            return nacionalidad;
    }

    public String getCurp() {
            return curp;
    }

    public int getAñoNac() {
        return añoNac;
    }
    
    public int compareTo(Persona o){
        return calEdad() - o.calEdad();
    }

    
    public boolean equals(Object obj) {
        Persona a = (Persona)obj;
       boolean ans = false;
       if (curp.equalsIgnoreCase(a.getCurp()))
           ans = true;
       return ans;
    
    }
        
    
}