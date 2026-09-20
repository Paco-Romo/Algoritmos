import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BackTracking {
    Scanner sc = new Scanner(System.in);
    int a[];
    int suma;

    void main() {
        ArrayList<String> subconjuntos = new ArrayList<String>() ;
        new BackTracking().backtracking(5, 11,subconjuntos);
    }

    public String backtracking(int n, int k, ArrayList<String> subconjuntos ) {
        a = new int[n];
        System.out.println("Introduce los valores para el arreglo:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                suma = a[i] + a[j];
                if (suma == k) {
                    subconjuntos.add(a[i] + "," + a[j]);
                }
            }
        }
        System.out.println(subconjuntos);
        return subconjuntos.toString();
    }
}

