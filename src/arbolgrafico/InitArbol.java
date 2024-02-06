
package arbolgrafico;

import javax.swing.JPanel;


public class InitArbol {


    ArboldeExpresiones miArbol = new ArboldeExpresiones();

    public InitArbol() {
    }

    public boolean insertar(String dato) {
        return (this.miArbol.contruir(dato));
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }

}
