import java.util.*;

public class Extras {
    //Torre de Hanoi
    private Stack<Integer> torreIzquierda = new Stack<>();
    private Stack<Integer> torreMedio = new Stack<>();
    private Stack<Integer> torreDerecha = new Stack<>();
    private int c = 0;

    //Cambio con monedas
    public ArrayList<Integer> lista = new ArrayList<>();
    private ArrayList<Integer> min = new ArrayList<>();

    //Reinas
    private int n;
    private int[] reinas; // reinas[i] = columna donde está la reina en la fila i
    private int soluciones = 0;


    //Torres de Hanoi
    public void torresHanoi(int n) {
        c = 0;
        for (int i = n; i > 0; i--) {
            torreIzquierda.push(i);
        }
        resolviendoTorres(n, torreIzquierda, torreMedio, torreDerecha);
        System.out.println("El numero de procedimientos fue: " + c);
    }

    public void resolviendoTorres(int n, Stack<Integer> torreInicio, Stack<Integer> torreDestino, Stack<Integer> torreAuxiliar) {

        int inicio = torreInicio.isEmpty() ? 0 : torreInicio.peek();
        int destino = torreDestino.isEmpty() ? 0 : torreDestino.peek();
        int auxiliar = torreAuxiliar.isEmpty() ? 0 : torreAuxiliar.peek();

        if (inicio == n && (destino > inicio || destino == 0)) {
            torreDestino.push(torreInicio.pop());
            System.out.println("\n");
            System.out.println(torreInicio + "  " + torreDestino + "  " + torreAuxiliar);
            c++;

            if (torreInicio.isEmpty() && torreAuxiliar.isEmpty())
                return;
            int inicio2 = torreInicio.isEmpty() ? 0 : torreInicio.peek();
            if (auxiliar < inicio && auxiliar != 0)
                resolviendoTorres((n - 1), torreAuxiliar, torreDestino, torreInicio);
            else if (inicio2 < auxiliar && auxiliar != 0 && inicio2 != 0) {
                resolviendoTorres((n + 1), torreInicio, torreAuxiliar, torreDestino);
            } else if (auxiliar != 0) {
                resolviendoTorres((n + 1), torreAuxiliar, torreDestino, torreInicio);
            } else if (auxiliar == 0) {
                resolviendoTorres((n + 1), torreInicio, torreAuxiliar, torreDestino);
            }
        } else if (inicio != n) {
            if (inicio > n)
                resolviendoTorres((n + 1), torreInicio, torreAuxiliar, torreDestino);
            else
                resolviendoTorres((n - 1), torreInicio, torreAuxiliar, torreDestino);
        }
    }

    //Cambio de monedas
    public int Cambio(int n, ArrayList<Integer> monedas, int k) {
        lista.clear();
        for (int i = 0; i < k; i++) {
            lista.add(0);
        }
        for (int i = 0; i < n; i++) {
            lista.set((monedas.get(i) - 1), 1);
        }
        System.out.println(lista);
        return resolviendoCambio(k, monedas);
    }

    public int resolviendoCambio(int k, ArrayList<Integer> monedas) {

        if (lista.get(k - 1) != 0)
            return lista.get(k - 1);
        for (int i = 0; i < (k / 2); i++) {
            min.add(resolviendoCambio(k - (i + 1), monedas) + resolviendoCambio(i + 1, monedas));
        }
        lista.set(k - 1, Collections.min(min));
        System.out.println(k + " --> " + min);
        min.clear();
        return lista.get(k - 1);
    }


    //Damas no chinas
    public void N_Reinas(int n) {//Pero no en P, solo en NP, xd
        this.n = n;
        this.reinas = new int[n];
        resolver();

    }

    public void resolver() {
        backtrack(0); // Inicia en la fila con índice 0
        System.out.println("Total de soluciones: " + soluciones);
    }

    private boolean enConflicto(int i, int j) {

        // Misma columna
        if (reinas[i] == reinas[j]) {
            return true;
        }

        // Misma diagonal
        if (Math.abs(i - j) == Math.abs(reinas[i] - reinas[j])) {
            return true;
        }

        return false;
    }

    private void backtrack(int i) {

        // Si llegamos al final, encontramos una solución
        if (i == n) {
            soluciones++;
            imprimirTablero();
            return;
        }

        // Probamos colocar la reina en cada columna
        for (int j = 0; j < n; j++) {

            reinas[i] = j; // Colocar reina provisionalmente

            if (esValido(i)) {
                backtrack(i + 1);
            }
        }
    }

    private boolean esValido(int i) {

        // Compara la reina actual con las anteriores
        for (int j = 0; j < i; j++) {

            if (enConflicto(i, j)) {
                return false;
            }
        }

        return true;
    }

    private void imprimirTablero() {

        System.out.println("Solución #" + soluciones + ":");

        for (int i = 0; i < n; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {

                if (reinas[i] == j) {
                    sb.append(" Q ");
                } else {
                    sb.append(" . ");
                }
            }

            System.out.println(sb.toString().trim());
        }

        System.out.println();
    }

}
