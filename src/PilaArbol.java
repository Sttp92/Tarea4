/**
 * Created by stay5 on 28-05-17.
 */
public class PilaArbol {
    public class Nodo{
        private NodoArbolB NodoArbol;
        private String simbolo;
        private Nodo sgte;
        int identificador;

        Nodo(NodoArbolB arbol){
            NodoArbol = arbol;
            sgte = null;
            identificador = 1;
        }

        Nodo(String polaca_inversa){
            simbolo = polaca_inversa;
            sgte = null;
            identificador = 0;
        }
    }

    private Nodo top;

    public PilaArbol(){
        top = null;
    }

    public void apilar_simbolo(String simbolo){
        Nodo pila_simb = new Nodo(simbolo);
        pila_simb.sgte = top;
        top = pila_simb;
    }

    public void apilar_arbol(NodoArbolB arbolb){
        Nodo pila_arbol = new Nodo(arbolb);
        pila_arbol.sgte = top;
        top = pila_arbol;
    }

    public String desapilar_simbolo(){
        Nodo aux1 = top;
        top = top.sgte;
        return aux1.simbolo;
    }

    public NodoArbolB desapilar_arbol(){
        Nodo aux2 = top;
        top = top.sgte;
        return aux2.NodoArbol;
    }

    public Nodo getTop(){
        return top;
    }

    public boolean estaVacía(){
        return top==null;
    }
}
