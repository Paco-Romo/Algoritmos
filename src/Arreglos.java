public class Arreglos {

    public class ArregloNumeroMenor {
        public static void main(String[] args) {
            int[] arreglo = {8, 4, 10, 2, 6, 1, 9};
            int m = arreglo[0];
            for (int i = 1; i < arreglo.length; i++)
            {
                if (arreglo[i] < m)
                {
                    m = arreglo[i];
                }
            }
            return m;
        }
    }
    public class OrdenarArreglo {
        static void main(String[] args) {
            int[] A = {3, 6, 7, 8, 9};
            int min = A[0];
            int inicio = 1;
            boolean ordenado=false;
            int n=0;
            int m=0;
            int num=0;
            while(ordenado=false)
            {
                for(i=inicio; i < n; i++)
                {
                    if (min >= A[i])
                    {
                        min=A[i];
                        m=i-1;
                    }
                    if (A[i]<A[i-1])
                    {
                        num = A[i-1];
                        A[i-1] = A[i];
                        A[i] = num;
                        ordenado = false;
                        num=A[inicio-1];
                        A[inicio-1]=min;
                        A[m]=num;
                        inicio++;
                        n--;
                        min=A[inicio-1];
                    }
                }
            }
        }
    }
}
