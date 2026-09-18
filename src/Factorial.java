public class Factorial {
    // Fer crea los algoritmos de factorial (Listo :P xd)

    long factorial;
    public class FactorialIterativo {
        public long factorial(long n){
            for(int i = 0; i<=n; i++){
                if (factorial == 0){
                    factorial = 1;
                }
                else {
                    if (i == 0){
                        factorial = 1;
                    }
                    factorial = factorial * i;

                }
            }
            return factorial;
        }
    }

    public class FactorialRecursivo {
        public long numero(int n){
            if(n<3)
                return n;
            else
                return n * numero((n-1));
        }
    }
    }
