package problema4;

public class Empresa {
    private String nombre;
    private String direccion;
    private String nombreDueño;
    private Administrativo[] admis;
    private Operario[] operarios;
    private int tO;
    private int tA;
    private final int MAX_ADM = 10;
    private final int MAX_OPER = 10;
    
    public Empresa() {
        admis = new Administrativo[MAX_ADM];
        tA = 0;
        operarios = new Operario[MAX_OPER];
        tO = 0;
    } 
    
   
    public Empresa (String nombre, String direccion, String nombreDueño) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreDueño = nombreDueño;
    }
    
    public boolean alta(String nombre, double sueldoBase, String dept, String telefono) {
        boolean resp = false;
        if(admis.length > tA ) {
            resp = true;
            admis[tA] = new Administrativo(nombre, sueldoBase, dept, telefono);
            tA++;
        }
        
        return resp;
    }
    
    public boolean alta(String nombre, double sueldoBase, int hE) {
        boolean resp = false;
        if(operarios.length > tO ) {
            resp = true;
            operarios[tO] = new Operario(nombre, sueldoBase, hE);
            tO++;
        }
        
        return resp;
    }
    
    private int busca(int clave){
        int i = 0;
        while (i < tA && admis[i].getClaveEmpleado() != clave)
            i++;
        if(i == tA)
            i = -1;
        return i;
    }
    
    public boolean actualizaSueldo(int clave, double por) {
        boolean res = false;
        int pos = busca(clave);
        if(pos >= 0) {
            res = true;
            admis[pos].actSB(por);
        }
        
        return res;
    }
    
    public boolean actualizaDep(int clave, String dep) {
        boolean res = false;
        int pos = busca(clave);
        if(pos >= 0) {
            res = true;
            admis[pos].setDepartamento(dep);
        }
        
        return res;
    }
    
    public <T> int buscaGenerica(T[] array, int tot, T obj) {
        int i = 0;
        while (i < tot && array[i].equals(obj))
            i++;
        
        if(i == tot)
            i = -1;
        
        return i;
    }
    
    public boolean actDep(int clave, String dep) {
        boolean res;
        int pos;
        Administrativo a = new Administrativo(clave);
        pos = buscaGenerica(admis, tA, a);
        if(pos < 0)
            res = false;
        else {
            res = true;
            admis[pos].setDepartamento(dep);
        }
        
        return res;
    }
    
}
