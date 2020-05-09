package Recursividad;
import java.util.Scanner;

public class CercaBinariaRecursiva {

	public static void cercaBinaria(int inf, int sup, int medio, int valor, int[] array, boolean validacion) {
		if (inf <= sup && validacion == false) {
			medio = (sup + inf) / 2;
			if (array[medio] == valor) {
				validacion = true;
			}
			if (valor < array[medio]) {
				cercaBinaria(inf, sup = medio - 1, medio, valor, array, validacion);
			} else {
				cercaBinaria(inf = medio + 1, sup, medio, valor, array, validacion);
			}
		} else {
			if (validacion == true) {
				System.out.println("Se ha encontrado.");
			} else {
				System.out.println("No se ha encontrado.");
			}
		}
	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		int auxiliar = 0;
		int[] array = new int[5];
		int k = 0;
		int j = 1;

		int inf = 0, sup = array.length - 1, medio = 0;
		boolean validacion = false;

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 21);
		}

		// ARRAY DESORDENADO
		System.out.println("Array Desordenado: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		ordenacio(array, auxiliar, k, j);

		// ARRAY DESORDENADO
		System.out.println("\nArray Ordenado: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		int valor = lector.nextInt();

		cercaBinaria(inf, sup, medio, valor, array, validacion);

	}

	public static int ordenacio(int[] array, int auxiliar, int i, int j) {
		if (i == array.length) {
			return 0;
		} else {
			if (j == array.length) {
				return ordenacio(array, auxiliar, i + 1, j = 0);
			}
			if (array[i] < array[j]) {
				auxiliar = array[i];
				array[i] = array[j];
				array[j] = auxiliar;
				return ordenacio(array, auxiliar, i, j + 1);
			} else {
				return ordenacio(array, auxiliar, i, j + 1);
			}
		}
	}

}
