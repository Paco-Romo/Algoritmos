import java.util.ArrayList;
import java.util.Scanner;

public class BackTracking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arreglo = Main.pedirArreglo();

        System.out.println("Ingresa el valor al que quieres encontrar solución: ");
        int valor = sc.nextInt();

        ArrayList<ArrayList<Integer>> soluciones = new ArrayList<>();
        ArrayList<Integer> solucion = new ArrayList<>();

        backtracking(arreglo, valor, 0, 0, solucion, soluciones);

        System.out.println("\nArreglo original: " + arreglo);
        System.out.println("Soluciones encontradas:");

        for (ArrayList<Integer> s : soluciones) {
            System.out.println(s);
        }
    }


    public static void backtracking(
            ArrayList<Integer> arreglo,
            int valor,
            int indice,
            int suma,
            ArrayList<Integer> solucion,
            ArrayList<ArrayList<Integer>> soluciones) {

        if (suma == valor) {

            soluciones.add(new ArrayList<>(solucion));

            return;
        }

        if (suma > valor) {
            return;
        }

        for (int i = indice; i < arreglo.size(); i++) {

            if (suma + arreglo.get(i) <= valor) {

                solucion.add(arreglo.get(i));

                backtracking(
                        arreglo,
                        valor,
                        i + 1,
                        suma + arreglo.get(i),
                        solucion,
                        soluciones
                );

                solucion.remove(solucion.size() - 1);
            }
        }
    }
}