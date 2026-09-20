import org.w3c.dom.ls.LSOutput;

import java.util.EmptyStackException;
import java.util.Stack;

public class Extras {

    private Stack<Integer> torreIzquierda = new Stack<>();
    private Stack<Integer> torreMedio = new Stack<>();
    private Stack<Integer> torreDerecha = new Stack<>();
    private int c=0;


    public void torresHanoi(int n) {
        for (int i = n; i > 0; i--) {
            torreIzquierda.push(i);
        }
        resolviendoTorres(n, torreIzquierda, torreMedio, torreDerecha);
        System.out.println("El numero de procedimientos fue: "+c);
    }
    public void resolviendoTorres(int n, Stack<Integer> torreInicio, Stack<Integer> torreDestino, Stack<Integer> torreAuxiliar) {

        int inicio= torreInicio.isEmpty() ? 0 : torreInicio.peek();
        int destino= torreDestino.isEmpty() ? 0 : torreDestino.peek();
        int auxiliar= torreAuxiliar.isEmpty() ? 0 : torreAuxiliar.peek();

        if (inicio == n && (destino > inicio || destino == 0)) {
            torreDestino.push(torreInicio.pop());
            System.out.println(torreInicio);
            System.out.println(torreDestino);
            System.out.println(torreAuxiliar);
            c++;

            if (torreInicio.isEmpty() && torreAuxiliar.isEmpty())
                return;
            int inicio2= torreInicio.isEmpty() ? 0 : torreInicio.peek();
            if (auxiliar < inicio && auxiliar != 0)
                resolviendoTorres((n-1),torreAuxiliar,torreDestino,torreInicio);
            else if (inicio2 < auxiliar && auxiliar != 0 && inicio2 != 0) {
                resolviendoTorres((n+1),torreInicio,torreAuxiliar,torreDestino);
            } else if (auxiliar != 0) {
                resolviendoTorres((n+1),torreAuxiliar,torreDestino,torreInicio);
            } else if (auxiliar == 0) {
                resolviendoTorres((n+1),torreInicio, torreAuxiliar,torreDestino);
            }
        }
        else if (inicio != n) {
            if (inicio > n)
                resolviendoTorres((n+1),torreInicio,torreAuxiliar,torreDestino);
            else
                resolviendoTorres((n-1),torreInicio,torreAuxiliar,torreDestino);
        }
    }

}
