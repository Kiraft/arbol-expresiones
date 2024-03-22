/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico.nodos;

/**
 * @author ESTUDIANTES
 */
public class NodoHijo {

    private String informacion;
    private NodoHijo padre;
    private NodoHijo nodoIzquierdo;
    private NodoHijo nodoDerecho;

    public NodoHijo() {
        this.informacion = "";
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
        this.padre = null;
    }

    public NodoHijo(String informacion) {
        this.informacion = informacion;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
        this.padre = null;
    }

    public NodoHijo(NodoHijo op1, String pop, NodoHijo op2) {
        this.nodoDerecho = op1;
        this.informacion = pop;
        this.nodoIzquierdo = op2;
        this.padre = null;

    }


    public NodoHijo getPadre() {
        return padre;
    }

    public void setPadre(NodoHijo padre) {
        this.padre = padre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public NodoHijo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(NodoHijo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public NodoHijo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(NodoHijo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }


}
