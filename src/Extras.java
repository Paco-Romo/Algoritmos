import java.util.*;

public class Extras {
    //Torre de Hanoi
    private Stack<Integer> torreIzquierda = new Stack<>();
    private Stack<Integer> torreMedio = new Stack<>();
    private Stack<Integer> torreDerecha = new Stack<>();
    private int c=0;

    //Cambio con monedas
    public ArrayList<Integer> lista = new ArrayList<>();
    private ArrayList<Integer> min = new ArrayList<>();


    public void torresHanoi(int n) {
        c=0;
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
            System.out.println("\n");
            System.out.println(torreInicio+"  "+torreDestino+"  "+torreAuxiliar);
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

    public int Cambio(int n, ArrayList<Integer> monedas, int k) {
        lista.clear();
        for (int i = 0; i < k; i++) {
            lista.add(0);
        }
        for (int i = 0; i < n; i++) {
            lista.set((monedas.get(i)-1), 1);
        }
        System.out.println(lista);
        return resolviendoCambio(k, monedas);
    }

    public int resolviendoCambio(int k, ArrayList<Integer> monedas) {

        if (lista.get(k-1) != 0)
            return lista.get(k-1);
        for (int i = 0; i < (k/2); i++) {
            min.add(resolviendoCambio(k-(i+1), monedas)+resolviendoCambio(i+1, monedas));
        }
        lista.set(k-1, Collections.min(min));
        System.out.println(k+" --> "+min);
        min.clear();
        return lista.get(k-1);
    }


}
