import java.util.ArrayList;
import java.util.Scanner;

public class BackTracking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arreglo = Main.pedirArreglo();
        ArrayList<Integer> solucion = new ArrayList<>();


        System.out.println("Ingresa el valor al que quieres encontrar solución: ");
        int valor = sc.nextInt();
        int suma = 0;

        // Restricción
        if (suma < valor) {

            for (int i = 0; i < arreglo.size(); i++) {

                if (suma + arreglo.get(i) <= valor) {

                    solucion.add(arreglo.get(i));
                    suma += arreglo.get(i);

                }
            }
        }

        System.out.println("Arreglo original: " + arreglo);
        System.out.println("Solución: " + solucion);
        System.out.println("Suma: " + suma);
    }
}