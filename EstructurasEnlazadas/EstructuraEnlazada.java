package EstructurasEnlazadas;

import java.util.Iterator;
import pilaUso.EmptyCollectionException;

public class EstructuraEnlazada<T> {

    private Nodo<T> primero;

    public EstructuraEnlazada() {
        primero = null;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void agregaInicio(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSig(primero);
        primero = nuevo;
    }

    public void agregaFinal(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        if (isEmpty()) {
            primero = nuevo;
        } else {
            Nodo<T> aux;
            aux = primero;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        return toString(res, primero);
    }

    private String toString(StringBuilder res, Nodo<T> ap) {
        if (ap == null) {
            return res.toString();
        } else {
            res.append(ap.getDato() + "  ");
            return toString(res, ap.getSig());
        }
    }

    public boolean buscaDato(T dato) {
        boolean res;
        Nodo<T> ap = primero;
        while (ap != null && !ap.getDato().equals(dato)) {
            ap = ap.getSig();
        }
        res = ap != null;
        return res;
    }

    public T quitaPrimero() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        T res = primero.getDato();
        Nodo<T> ap = primero;
        primero = primero.getSig();
        ap.setSig(null);
        return res;
    }

    public T quitaUltimo() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        Nodo<T> actual = primero;
        Nodo<T> ant = null;
        while (actual.getSig() != null) {
            ant = actual;
            actual = actual.getSig();
        }
        if (ant != null) {
            ant.setSig(null);
        } else {
            primero = null;
        }
        return actual.getDato();
    }

    public T quitaDato(T dato) {
        if (!isEmpty()) {
            if (primero.getDato().equals(dato)) {
                return quitaPrimero();
            } else {
                Nodo<T> act, ant;
                ant = primero;
                act = primero.getSig();
                while (act != null && !act.getDato().equals(dato)) {
                    ant = act;
                    act = act.getSig();
                }
                if (act == null) {
                    throw new EmptyCollectionException();
                } else {
                    T resul = act.getDato();
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    return resul;
                }
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    public boolean eliminaAnteriorA(T dato) {
        if (!isEmpty() || dato != null) {
            if (primero.getDato().equals(dato) || primero.getSig() == null) {
                return false;
            } else {

                Nodo ant = primero;
                Nodo act = primero.getSig();
                if (act.getDato().equals(dato)) {
                    quitaPrimero();
                    return true;
                }
                while (act.getSig() != null && !act.getSig().getDato().equals(dato)) {
                    ant = act;
                    act = act.getSig();
                }
                if (act.getSig() != null) {
                    ant.setSig(act.getSig());
                    act.setSig(null);
                    return true;
                }
                return false;
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    public boolean eliminaSiguienteA(T dato) {
        if (!isEmpty() || dato != null) {
            Nodo<T> ap = primero;
            while (ap != null && !ap.getDato().equals(dato)) {
                ap = ap.getSig();
            }
            if (ap == null || ap.getSig() == null) {
                return false;
            } else {
                Nodo<T> eli = ap.getSig();
                ap.setSig(eli.getSig());
                eli.setSig(null);
                return true;
            }

        } else {
            throw new EmptyCollectionException();
        }
    }

    public boolean insertaAntesQue(T refer, T nuevo) {
        if (!isEmpty() || nuevo != null) {
            if (primero.getDato().equals(refer)) {
                agregaInicio(nuevo);
                return true;
            } else {
                Nodo ant = primero;
                Nodo act = primero.getSig();
                while (act != null && !act.getDato().equals(refer)) {
                    ant = act;
                    act = act.getSig();
                }
                if (act != null) {
                    Nodo<T> nuevo1 = new Nodo(nuevo);
                    T aux = (T) ant.getDato();
                    ant.setSig(nuevo1);
                    nuevo1.setSig(act);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    public int eliminaTodosRepetidosOrdenado() {
        if (!isEmpty()) {
            int elim = 0;
            if (primero.getSig() == null) {
                return 0;
            } else {
                Nodo ant = primero;
                Nodo act = primero.getSig();
                while (act != null) {
                    if (ant.getDato().equals(act.getDato())) {
                        ant.setSig(act.getSig());
                        act.setSig(null);
                        elim++;
                        act = ant.getSig();
                    } else {
                        ant = act;
                        act = act.getSig();
                    }

                }
                return elim;
            }

        } else {
            throw new EmptyCollectionException();
        }
    }

    public int eliminaTodosRepetidosDesordenado() {
        if (!isEmpty()) {
            int elim = 0;
            if (primero.getSig() == null) {
                return 0;
            } else {
                Nodo base = primero;
                Nodo ant;
                Nodo act;
                while (base != null) {
                    ant = base;

                    act = base.getSig();
                    while (act != null) {

                        if (base.getDato().equals(act.getDato())) {
                            elim++;

                            ant.setSig(act.getSig());
                            act.setSig(null);
                            act = ant.getSig();

                        } else {
                            ant = act;
                            act = act.getSig();
                        }
                    }

                    base = base.getSig();
                }
                return elim;
            }
        } else {
            /*game of */
            throw/*ns*/ new EmptyCollectionException();
        }
    }

    public void mezcla(EstructuraEnlazada dos) {
        if (dos != null){
            if (!isEmpty() && !dos.isEmpty()) {
                if (primero.getSig() != null) {
                    Nodo ant = primero;
                    Nodo act = primero.getSig();
                    Nodo ant1 = dos.primero;
                    Nodo act2;
                    while (act != null && ant1 != null) {
                        act2 = ant1.getSig();
                        ant.setSig(ant1);
                        ant1.setSig(act);
                        ant = act;
                        act = act.getSig();
                        ant1 = act2;
                    }
                    if(act == null )
                        ant.setSig(ant1);
                }
                else
                    primero.setSig(dos.primero);
            }
            else if (!isEmpty())
                primero = dos.primero;
        } else
            throw new NullPointerException();
    }

    

    public static void main(String[] args) {
        /*EstructuraEnlazada<String> nom = new EstructuraEnlazada();
        if (nom.isEmpty()) {
            System.out.println("está vacía");
        } else {
            System.out.println("No está vacía");
        }
        nom.agregaInicio("Diana");
        nom.agregaInicio("Elisa");
        nom.agregaFinal("Nora");
        System.out.println("Contenido: " + nom.toString());
        nom.agregaFinal("Edgar");
        System.out.println("Contenido: " + nom.toString());
        if (!nom.isEmpty()) {
            System.out.println("Quita: " + nom.quitaPrimero());
        }
        if (!nom.isEmpty()) {
            System.out.println("Quita: " + nom.quitaUltimo());
        }
        if (nom.buscaDato("Diana")) {
            System.out.println("diana si esta aqui");
        }
        if (nom.buscaDato("Diaa")) {
            System.out.println("diaa si esta aqui");
        } else {
            System.out.println("no esta Diaa");
        }
         */
        EstructuraEnlazada<String> nom1 = new EstructuraEnlazada();
        if (nom1.isEmpty()) {
            System.out.println(" ");
        } else {
            System.out.println(" ");
        }
        nom1.agregaInicio("Juan");
        nom1.agregaInicio("María");
        nom1.agregaFinal("Pedro");
        System.out.println(" " + nom1);
        nom1.agregaFinal("Pedro");
        nom1.agregaFinal("Pedro");
        nom1.insertaAntesQue("Pedro", "Diana");
        nom1.agregaFinal("Lucas");
        nom1.insertaAntesQue("Lucas", "Diana");
        System.out.println(" " + nom1);
        nom1.agregaFinal("Lucas");
        nom1.agregaFinal("María");
        System.out.println(" " + nom1);
        /*if(!nom.estaVacio())
           System.out.println(" "+nom.quitaPrimero());
       if(!nom.estaVacio())
           System.out.println(" "+ nom.quitaUltimo());
       System.out.println(" "+ nom);
       if(nom.buscaDato("Pedro"))
           System.out.println("Sí");
       else
           System.out.println("No");
         */
        //System.out.println(nom1.eliminaAnteriorA("Pedro"));
        //System.out.println(nom1.eliminaTodosRepetidosOrdenado());
        System.out.println("Elimina desordenada:");
        System.out.println(nom1.eliminaTodosRepetidosDesordenado());
        System.out.println(" " + nom1);
        System.out.println(nom1.eliminaSiguienteA("María"));
        System.out.println(" " + nom1);
        nom1.quitaUltimo();
        nom1.quitaUltimo();
        nom1.quitaUltimo();
        System.out.println("Nom1: " + nom1);
        EstructuraEnlazada<String> dos = new EstructuraEnlazada();
        
        dos.agregaInicio("Fernández");
        dos.agregaFinal("Espinosa");
        dos.agregaFinal("Páramo");
        dos.agregaFinal("Muecas");
        dos.agregaFinal("Paca-Hernández");
        System.out.println("Dos: " + dos);
        nom1.mezcla(dos);
        System.out.println(" " + nom1);

    }

}
