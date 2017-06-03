/**
 * Created by stay5 on 28-05-17.
 */
import java.util.Arrays;
import java.util.Scanner;

public class MainProgram {

    private static void inOrden(NodoArbolB raiz) {
        if (raiz != null) {
            inOrden(raiz.getIzq());
            System.out.print(raiz.getDato()+" ");
            inOrden(raiz.getDer());
        }
    }

    private static void posOrden(NodoArbolB raiz){
        if (raiz != null){
            posOrden(raiz.getIzq());
            posOrden(raiz.getDer());
            System.out.print(raiz.getDato());
        }
    }

    private static void crearArbolBinario(PilaArbol pila_metodo, String[] array_metodo){
        String[] miarray = array_metodo;
        PilaArbol pila = pila_metodo;
        String operadores = "+-*/";

        for (int i = 0; i < miarray.length; i++) {
            NodoArbolB der = new NodoArbolB();
            NodoArbolB izq = new NodoArbolB();

            if (operadores.indexOf(miarray[i]) == -1) {
                pila.apilar_simbolo(miarray[i]);
            } else {
                NodoArbolB arbol = new NodoArbolB();
                arbol.entrada = miarray[i];
                if (pila.getTop().identificador == 1) {
                    arbol.der = pila.desapilar_arbol();
                } else {
                    der.entrada = pila.desapilar_simbolo();
                    arbol.der = der;
                }
                if (pila.getTop().identificador == 1) {
                    arbol.izq = pila.desapilar_arbol();
                } else {
                    izq.entrada = pila.desapilar_simbolo();
                    arbol.izq = izq;
                }
                pila.apilar_arbol(arbol);
            }
        }
    }

    public String Recorrer(NodoArbolB arbol_derivado){
        String arbol_recorrer = arbol_derivado.entrada;
        if (arbol_recorrer == )
    }

    public static void main(String args[]) {
        Scanner op_aritmetica = new Scanner(System.in);
        System.out.print("Ingresar expresion en polaca inversa: ");
        String aritmetica = op_aritmetica.nextLine();
        Scanner op_variable = new Scanner(System.in);
        System.out.print("Ingresar variable a derivar: ");
        String variable = op_variable.next();
        String aritmetica_new = aritmetica.replace(" ","");
        String[] miarray = aritmetica_new.split("");
        PilaArbol pila = new PilaArbol();
        crearArbolBinario(pila,miarray);
        NodoArbolB arbol = pila.desapilar_arbol();
        System.out.println("Expresion inorden:");
        inOrden(arbol);
    }
}
















