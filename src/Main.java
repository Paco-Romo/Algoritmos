import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println(
                    "Seleccione el algoritmo que quiera usar:\n" +
                    "1.- Encontrar número menor en un arreglo (Práctica 2)\n" +
                    "2.- Ordenar un arreglo (Práctica 3)\n" +
                    "3.- Suma N enteros - Iterativo\n" +
                    "4.- Suma N enteros - Recursivo\n" +
                    "5.- Fibonacci - Iterativo\n" +
                    "6.- Fibonacci - Recursivo (sin programación dinámica)\n" +
                    "7.- Fibonacci - Recursivo (con programación dinámica)\n" +
                    "8.- Factorial - Iterativo (Práctica 4)\n" +
                    "9.- Factorial - Recursivo (Práctica 4)\n" +
                    "10.- Backtracking: dado un arreglo A de tamaño N, encontrar uno o varios subconjuntos \n" +
                    "cuya suma sea exactamente K (utilizando el ejemplo visto en clase)\n" +
                    "11.-Torres de hanoi (extra)\n" +
                    "12.-Cambio de la moneda (extra)\n" +
                    "13.-Problema de N-Reinas y todas sus soluciones\n" +
                    "14.Salir\n"
            );

            try {
                opcion = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                input.nextLine();
                System.out.println("Ingresa un numero valido");
                opcion=0;
                continue;
            }

            switch (opcion) {
                case 1:{
                    ArrayList<Integer> numeros = pedirArreglo();
                    Arreglos arreglo = new Arreglos();
                    Arreglos.ArregloNumeroMenor arreglo2= arreglo.new ArregloNumeroMenor();
                    System.out.println("El numero menor del arreglo es: "+
                            arreglo2.numeroMenor(numeros));

                    espera();
                    break;
                }

                case 2:{
                    ArrayList<Integer> numeros = pedirArreglo();
                    Arreglos arreglo = new Arreglos();
                    Arreglos.OrdenarArreglo arreglo3= arreglo.new OrdenarArreglo();
                    System.out.println("El arreglo ya ordenado es: ");
                    arreglo3.ordenarArreglo(numeros);
                    espera();
                    break;
                }

                case 3:{
                    int numero = pedirNumero();
                    System.out.println("La suma de los primeros "+numero+" es: "
                            +Enteros.sumaIterativa(numero));
                    espera();
                    break;
                }

                case 4:{
                    int numero = pedirNumero();
                    System.out.println("La suma de los primeros "+numero+" es: "+
                            Enteros.sumaRecursiva(numero));
                    espera();
                    break;
                }

                case 5:{
                    int numero = pedirNumero();
                    Fibonacci.fibonacciIterativo(numero);
                    espera();
                    break;
                }

                case 6:{
                    int numero = pedirNumero();
                    System.out.println("El numero del lugar "+numero+" en la sucecion" +
                            "de fibonacci es: "+Fibonacci.fibonacciRecursivo(numero));
                    espera();
                    break;//2
                }

                case 7:{
                    int numero = pedirNumero();
                    int[] afibd = new int[numero + 1];
                    System.out.println("El numero del lugar "+numero+" en la sucecion" +
                            "de fibonacci es: "+Fibonacci.fibonacciDinamico(numero, afibd));
                    espera();
                    break;//3
                }

                case 8:{
                    Factorial factorial = new Factorial();
                    Factorial.FactorialIterativo iterativo = factorial.new FactorialIterativo();
                    int numero = pedirNumero();
                    System.out.println("El resultado de "+numero+" factorial es: "+
                            iterativo.factorial(numero));
                    espera();
                    break;
                }

                case 9:{
                    Factorial factorial = new Factorial();
                    Factorial.FactorialRecursivo recusivo = factorial.new FactorialRecursivo();
                    int numero = pedirNumero();
                    System.out.println("El resultado de "+numero+" factorial es: "+
                            recusivo.numero(numero));
                    espera();
                    break;
                }

                case 10:{
                    ArrayList<Integer> arreglo = pedirArreglo();

                    System.out.println("Ingresa el valor al que quieres encontrar solución: ");
                    int valor = pedirNumero();

                    ArrayList<ArrayList<Integer>> soluciones = new ArrayList<>();
                    ArrayList<Integer> solucion = new ArrayList<>();

                    BackTracking.backtracking(arreglo, valor, 0, 0, solucion, soluciones);
                    System.out.println("\nArreglo original: " + arreglo);
                    System.out.println("Soluciones encontradas:");

                    for (ArrayList<Integer> s : soluciones) {
                        System.out.println(s);
                    }
                    espera();
                    break;
                }

                case 11:{
                    int N=pedirNumero();
                    Extras extras = new Extras();
                    extras.torresHanoi(N);
                    espera();
                    break;
                }

                case 12:{
                    System.out.println("Ingrese cuanto es el cambio");
                    int k=pedirNumero();
                    System.out.println("Ingrese las monedas que hay disponibles");
                    ArrayList<Integer> arreglo = new ArrayList<>();
                    arreglo=pedirArreglo();
                    Extras extras = new Extras();
                    int cambio=extras.Cambio(arreglo.toArray().length, arreglo, k);
                    System.out.println("El numero minimo de monedas es: "+cambio);
                    System.out.println(extras.lista);
                    espera();
                    break;
                }

                case 13:{
                    int N=pedirNumero();
                    Extras extras = new Extras();
                    extras.N_Reinas(N);
                    espera();
                    break;
                }

                case 14:{
                    System.out.println("Gracias por probar nuestro programa"+
                            "\nSaliendo...");
                    return;
                }



                default:{
                    System.out.println("Ingresa un numero valido");
                }
            }
        }
    }

    public static ArrayList<Integer> pedirArreglo(){

        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa el areglo número por número");
        int i=0;
        ArrayList<Integer> arreglo = new ArrayList<>();
        while (true) {
            System.out.println("Ingresa un numero entero, idice: "+i++);
            try {
                arreglo.add(input.nextInt());
                input.nextLine();
            }catch (InputMismatchException e){
                input.nextLine();
                System.out.println("Ingrese un numero entero");
                i--;
            }
            System.out.println("¿Quiere agregar otro número? Y/N");
            String respuesta = input.nextLine().toUpperCase();
            if (respuesta.equals("N"))
                break;
        }
        return arreglo;
    }

    public static int pedirNumero(){
        Scanner input = new Scanner(System.in);
        int N;
        while (true) {
            System.out.println("Ingresa un numero ENTERO");
            try {
                N = input.nextInt();
                input.nextLine();
                break;
            }
            catch (InputMismatchException e){
                input.nextLine();
                System.out.println("Ingresa un numero valido");
            }
        }
        return N;
    }

    public static void espera(){
        Scanner input = new Scanner(System.in);
        System.out.println("Presione cualquier tecla para continuar");
        input.nextLine();
    }
}