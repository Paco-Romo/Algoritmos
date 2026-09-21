public class Enteros {
    //todo Kevin crea estos algoritmos
    //- Suma N enteros - Iterativo

    public static int sumaIterativa(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma = suma + i;
        }
        return suma;
    }

    //- Suma N enteros - Recursivo

    public static int sumaRecursiva(int n) {
        if (n <= 0) {
            return 0; // Caso base
        }
        return n + sumaRecursiva(n - 1);
    }


}
