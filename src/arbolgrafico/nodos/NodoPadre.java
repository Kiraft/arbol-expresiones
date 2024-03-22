/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico.nodos;

/**
 * @author ploks
 */
public class NodoPadre {

    private int dato;
    private NodoPadre izq, der;

    public NodoPadre(int dato, NodoPadre izq, NodoPadre der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoPadre getIzq() {
        return izq;
    }

    public void setIzq(NodoPadre izq) {
        this.izq = izq;
    }

    public NodoPadre getDer() {
        return der;
    }

    public void setDer(NodoPadre der) {
        this.der = der;
    }

}
