import java.util.ArrayList;

public class Arreglos {
    //- Encontrar número menor en un arreglo (Práctica 2)
    //- Ordenar un arreglo (Práctica 3)

    public class ArregloNumeroMenor {

        public static int numeroMenor(ArrayList<Integer> arreglo) {

            int m = arreglo.get(0);

            for (int i = 1; i < arreglo.size(); i++) {
                if (arreglo.get(i) < m) {
                    m = arreglo.get(i);
                }
            }

            return m;
        }
    }


    public class OrdenarArreglo {

        public void ordenarArreglo(ArrayList<Integer> A) {
            int min = A.get(0);
            int inicio = 1;
            boolean ordenado = false;
            int n = A.size();
            int m = 0;
            int num = 0;

            while (ordenado == false) {
                ordenado = true;

                for (int i = inicio; i < n; i++) {
                    if (min >= A.get(i)) {
                        min = A.get(i);
                        m = i - 1;
                    }

                    if (A.get(i) < A.get(i - 1)) {

                        num = A.get(i - 1);
                        A.set(i - 1, A.get(i));
                        A.set(i, num);

                        ordenado = false;
                    }
                }
                num = A.get(inicio - 1);
                A.set(inicio - 1, min);
                A.set(m, num);

                inicio++;
                n--;
                min = A.get(inicio - 1);
            }
            System.out.println(A);
        }
    }
}
