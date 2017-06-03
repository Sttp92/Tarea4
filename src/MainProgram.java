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

    //public static boolean isNumeric(String s) {
        //return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    //}

    public String Recorrer(PilaArbol arbol_derivado){
        PilaArbol pila_recorrer = new PilaArbol();
        pila_recorrer = arbol_derivado;
        if (pila_recorrer.getTop().identificador == 0){
            return pila_recorrer.desapilar_simbolo();
        }
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

    public static void String derivar(PilaArbol arbol_sin_derivar, String respecto_a){
        NodoArbol nodo_raiz = arbol_sin_derivar.getTop();
        if(nodo_raiz.identificador == 0){
            if (nodo_raiz.getDato().equals(respecto_a)){
                return "1";
            } else {
                return "0";
            }
        } else {
            switch () {
            case "+":
                return derivar(arbolHijo1, respecto_a) + derivar(arbolHijo2, respecto_a) + "+";
            case "-":
                return derivar(arbolHijo1, respecto_a) + derivar(arbolHijo2, respecto_a) + "-";
            case "*":
                return derivar(arbolHijo1, respecto_a) + "arbolHijo2" + "*" + derivar(arbolHijo2, respecto_a) + "arbolHijo1" + "*" + "+";
            default:
                return derivar(arbolHijo1, respecto_a) + "arbolHijo2" + "*" + derivar(arbolHijo2, respecto_a) + "arbolHijo1" + "*" + "-" + "arbolHijo2" + "arbolHijo2" + "*" + "/";
                break;
            }
        }

    }
}



def derivar(arbol, respecto_a)
  if raiz == numero
    return 0
  elsif raiz == respecto_a
    return 1
  elsif (raiz == ( "+" || "-" || "*" || "/"))
    if raiz == "+"
      return "derivar(arbolHijo1, respecto_a) derivar(arbolHijo2, respecto_a) +"
    elsif raiz == "-"
      return "derivar(arbolHijo1, respecto_a) derivar(arbolHijo2, respecto_a) -"
    elsif raiz == "*"
      return "derivar(arbolHijo1, respecto_a) arbolHijo2 * derivar(arbolHijo2, respecto_a) arbolHijo1 * +"
    else
      return "derivar(arbolHijo1, respecto_a) arbolHijo2 * derivar(arbolHijo2, respecto_a) arbolHijo1 * - arbolHijo2 arbolHijo2 * /"
    end
  else #Es una variable tomada como constante
    return 0
  end
end












