import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

    public static int[] arreglo;
    public static int tamanioArreglo;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del arreglo a probar");
        tamanioArreglo = Integer.parseInt(scan.nextLine());
        arreglo = new int[tamanioArreglo];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = aleatorio(0, tamanioArreglo);
        }
        System.out.println("Ingrese la opcion a realizar:");
        System.out.println("1. Ingresar Dato");
        System.out.println("2. Buscar Dato");
        int opcionMenu = Integer.parseInt(scan.nextLine());
        if (opcionMenu == 1) {
            System.out.println("Ingrese un dato:");
            System.out.println("La cantidad de pasos que se realizaron en la insercion es de: "
                    + push(Integer.parseInt(scan.nextLine())));
            Arrays.sort(arreglo);
            System.out.println(Arrays.toString(arreglo));
        } else if (opcionMenu == 2) {
            Arrays.sort(arreglo);
            System.out.println(Arrays.toString(arreglo)); 
            System.out.println("Ingrese el numero a buscar");
            binarySearch(Integer.parseInt(scan.nextLine()));
        } else {
            System.out.println("No es una opcion valida");
        }   
        /* System.out.println("Ingrese un dato:");
        System.out.println("La cantidad de pasos que se realizaron en la insercion es de: "
                + push(Integer.parseInt(scan.nextLine())));
        Arrays.sort(arreglo);
        System.out.println(Arrays.toString(arreglo)); 
        System.out.println("Ingrese el numero a buscar");
        binarySearch(Integer.parseInt(scan.nextLine())); */
    }

    public static int push(int dato) {
        int contadorPasos = 0;
        int[] arregloTemporal = arreglo;
        tamanioArreglo++;
        arreglo = new int[tamanioArreglo];
        for (int i = 0; i < arreglo.length; i++) {
            if (i == 0) {
                arreglo[i] = dato;
            } else {
                arreglo[i] = arregloTemporal[i - 1];
            }
            contadorPasos++;
        }
        return contadorPasos;
    }

    public static int aleatorio(int minimo, int maximo) {
        int aleatorio = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
        return aleatorio;
    }

    public static int binarySearch(int datoIngresado) {
        int cantidadPasos = 1;
        int inicio, finalF, enMedio = 0, dato;
        char temp = 'N';
        dato = datoIngresado;
        inicio = 0;
        finalF = tamanioArreglo;
        while (inicio <= finalF) {
            enMedio = (inicio + finalF) / 2;
            if (arreglo[enMedio] == dato) {
                temp = 'S';
                break;
            }
            if (arreglo[enMedio] > dato) {
                finalF = enMedio;
                enMedio = (inicio + finalF) / 2;
            }
            if (arreglo[enMedio] < dato) {
                inicio = enMedio;
                enMedio = (inicio + finalF) / 2;
            }
            cantidadPasos++;
            if (cantidadPasos >= tamanioArreglo) {
                break;
            }
        }
        if (temp == 'S') {
            System.out.println("Dato encontrado en la posicion: " + enMedio);
            System.out.println("La cantidad de pasos realizados para la busqueda binaria es de: " + cantidadPasos);
        } else {
            System.out.println("No se encontró el dato");
        }
        return cantidadPasos;
    }

}
