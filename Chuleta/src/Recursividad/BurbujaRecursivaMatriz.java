package Recursividad;
import java.util.Arrays;

public class BurbujaRecursivaMatriz {

	/* ORDENACION POR COLUMNAS*/
	public static int ordenacioArray(int auxiliar, int[][] array, int i, int j, int a, int contadorFinal) {
		if (contadorFinal >= array.length) {
			return 0;
		} else {
			if (j >= array.length) {
				return ordenacioArray(auxiliar, array, i = 0, j = 0, a = 1, contadorFinal + 1);
			} else {
				if (a == array.length) {
					return ordenacioArray(auxiliar, array, i = 0, j + 1, a = 1, contadorFinal);
				}
				if (array[i][j] > array[a][j]) {
					auxiliar = array[a][j];
					array[a][j] = array[i][j];
					array[i][j] = auxiliar;
					return ordenacioArray(auxiliar, array, i + 1, j, a + 1, contadorFinal);
				} else {
					return ordenacioArray(auxiliar, array, i + 1, j, a + 1, contadorFinal);
				}
			}
		}
	}

	/*
	 * ORDENACION POR FILAS public static int ordenacioArray(int auxiliar, int[][]
	 * array, int i, int j, int a, int contadorFinal) { if (contadorFinal >=
	 * array.length) { return 0; } else { if (i >= array.length) { return
	 * ordenacioArray(auxiliar, array, i = 0, j = 0, a = 1, contadorFinal + 1); }
	 * else { if (a == array.length) { return ordenacioArray(auxiliar, array, i + 1,
	 * j = 0, a = 1, contadorFinal); } if (array[i][j] > array[i][a]) { auxiliar =
	 * array[i][a]; array[i][a] = array[i][j]; array[i][j] = auxiliar; return
	 * ordenacioArray(auxiliar, array, i, j + 1, a + 1, contadorFinal); } else {
	 * return ordenacioArray(auxiliar, array, i, j + 1, a + 1, contadorFinal); } } }
	 * }
	 */

	public static void main(String[] args) {
		int auxiliar = 0;
		int[][] array = new int[5][5];
		int k = 0;
		int j = 0;
		int a = 1;
		int contadorFinal = 0;

		for (int i = 0; i < array.length; i++) {
			for (int l = 0; l < array.length; l++) {
				array[i][l] = (int) (Math.random() * 21);
			}
		}

		// ARRAY DESORDENADO
		System.out.println("Array Desordenado: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}

		// ORDENACION DEL ARRAY
		ordenacioArray(auxiliar, array, k, j, a, contadorFinal);

		// ARRAY DESORDENADO
		System.out.println("\nArray Ordenado: ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}

	}

}
