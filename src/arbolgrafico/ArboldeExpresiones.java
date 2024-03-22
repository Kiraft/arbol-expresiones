/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico;

import arbolgrafico.nodos.NodoHijo;
import arbolgrafico.ui.ArbolExpresionGrafico;

import java.util.*;
import javax.swing.JPanel;


public class ArboldeExpresiones {
    Stack<NodoHijo> pOperandos = new Stack<NodoHijo>();
    Stack<String> pOperadores = new Stack<String>();

    final String blanco;           // Cadena de espacios en blanco
    final String operadores;       // Cadena con operadores para expresiones

    public ArboldeExpresiones() {
        blanco = " \t";
        operadores = ")+-*/%^(";  //acomodados por precedencia;
    }

    private NodoHijo raiz;

    public NodoHijo getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NodoHijo r) {
        this.raiz = r;
    }

    public boolean contruir(String con) {
        construirArbol(con);
        return true;
    }

    public NodoHijo construirArbol(String expresion) {
        StringTokenizer tokenizer;
        String token;

        tokenizer = new StringTokenizer(expresion, blanco + operadores, true);
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (blanco.indexOf(token) >= 0)
                ;               // Es un espacio en blanco, se ignora
            else if (operadores.indexOf(token) < 0) {
                // Es operando y lo guarda como nodo del arbol
                NodoHijo a;
                pOperandos.push(new NodoHijo(token));
            } else if (token.equals(")")) { // Saca elementos hasta encontrar (
                while (!pOperadores.empty() && !pOperadores.peek().equals("(")) {
                    guardarSubArbol();
                }
                pOperadores.pop();  // Saca el parentesis izquierdo
            } else {
                if (!token.equals("(") && !pOperadores.empty()) {
                    //operador diferente de cualquier parentesis
                    String op = (String) pOperadores.peek();
                    while (!op.equals("(") && !pOperadores.empty()
                            && operadores.indexOf(op) >= operadores.indexOf(token)) {
                        guardarSubArbol();
                        if (!pOperadores.empty())
                            op = (String) pOperadores.peek();
                    }
                }
                pOperadores.push(token);  //Guarda el operador
            }
        }

        raiz = (NodoHijo) pOperandos.peek();
        while (!pOperadores.empty()) {
            if (pOperadores.peek().equals("(")) {
                pOperadores.pop();
            } else {
                guardarSubArbol();
                raiz = (NodoHijo) pOperandos.peek();
            }
        }
        return raiz;
    }

    /*
     * Metodo privado para almacenar en la pila un subarbol
     */
    private void guardarSubArbol() {
        NodoHijo op2 = (NodoHijo) pOperandos.pop();
        NodoHijo op1 = (NodoHijo) pOperandos.pop();
        pOperandos.push(new NodoHijo(op2, pOperadores.pop(), op1));

    }

    /**
     * Metodo para imprimir un arbol en inorden
     *
     * @param n -- nodo raiz
     */
    public void imprime(NodoHijo n) {
        if (n != null) {

            imprime(n.getNodoDerecho());
            System.out.print(n.getInformacion() + " ");
            imprime(n.getNodoIzquierdo());
        }
    }

    /**
     * ((3-4)*(3+5))
     * (((a+b)+c)+d)
     * Metodo para imprimir un arbol en postorden
     *
     * @param n -- nodo raiz
     */
    public void imprimePos(NodoHijo n) {
        if (n != null) {
            imprimePos(n.getNodoIzquierdo());
            imprimePos(n.getNodoDerecho());
            System.out.print(n.getInformacion() + " ");
        }
    }

    /**
     * Metodo para imprimir un arbol en preorden
     *
     * @param n -- nodo raiz
     */
    public void imprimePre(NodoHijo n) {
        if (n != null) {
            System.out.print(n.getInformacion() + " ");

            imprimePre(n.getNodoDerecho());
            imprimePre(n.getNodoIzquierdo());
        }
    }

    public JPanel getdibujo() {

        return new ArbolExpresionGrafico(this);

    }

    public static void main(String[] pps) {
        ArboldeExpresiones expr = new ArboldeExpresiones();

        Scanner leer = new Scanner(System.in);
        System.out.println("Digite la expresion aritmetica");
        String expresion = leer.nextLine();

        NodoHijo raiz = expr.construirArbol(expresion);
        System.out.print("El arbol es ");
        expr.imprime(raiz);
        expr.imprimePre(raiz);

    }
}

