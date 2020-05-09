package Recursividad;

public class BurbujaRecursiva {

	public static int ordenacioArray(int auxiliar, int[] array, int i, int j) {
		if (i == array.length) {
			return 0;
		} else {
			if (j == array.length) {
				return ordenacioArray(auxiliar, array, i + 1, j = 0);
			}
			if (array[i] < array[j]) {
				auxiliar = array[i];
				array[i] = array[j];
				array[j] = auxiliar;
				return ordenacioArray(auxiliar, array, i, j + 1);
			} else {
				return ordenacioArray(auxiliar, array, i, j + 1);
			}
		}
	}

	public static void main(String[] args) {
		int auxiliar = 0;
		int[] ordenacion = new int[20];
		int k = 0;
		int j = 1;

		for (int i = 0; i < ordenacion.length; i++) {
			ordenacion[i] = (int) (Math.random() * 100);
		}

		// ARRAY DESORDENADO
		System.out.println("Array Desordenado: ");
		for (int i = 0; i < ordenacion.length; i++) {
			System.out.println(ordenacion[i]);
		}

		// ORDENACION DEL ARRAY
		ordenacioArray(auxiliar, ordenacion, k, j);

		// ARRAY DESORDENADO
		System.out.println("\nArray Ordenado: ");
		for (int i = 0; i < ordenacion.length; i++) {
			System.out.println(ordenacion[i]);
		}

	}

}
