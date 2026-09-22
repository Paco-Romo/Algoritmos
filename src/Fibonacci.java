import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de números de la sucesion de fibonacci que quieras ver: ");
        int n = sc.nextInt();

        System.out.println("\n--- Fibonacci Iterativo ---");
        fibonacciIterativo(n);

        System.out.println("\n--- Fibonacci Recursivo ---");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursivo(i) + " ");
        }

        System.out.println("\n\n--- Fibonacci Dinámico ---");
        int[] afibd = new int[n + 1];

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciDinamico(i, afibd) + " ");
        }

    }

    // 1. ITERATIVO
    public static void fibonacciIterativo(int n) {
        int a = 0, b = 1;

        for (int i = 0; i <= n; i++) {
            System.out.print(a + " ");

            int fn = a + b;
            a = b;
            b = fn;
        }

    }

    // 2. RECURSIVO
    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

    // 3. RECURSIVO CON PROGRAMACIÓN DINÁMICA
    public static int fibonacciDinamico(int n, int[] afibd) {
        if (n <= 1) {
            return n;
        }

        if (afibd[n] != 0) {
            return afibd[n];
        }

        afibd[n] = fibonacciDinamico(n - 1, afibd)
                + fibonacciDinamico(n - 2, afibd);

        return afibd[n];
    }
}
