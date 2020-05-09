package Basico;

public class Burbuja {

	public static void main(String[] args) {
		// INT
		// VARIABLES
		int auxiliar2;
		int[] ordenacion2 = { 50, 5, 6, 3, 20, 1 };

		// ARRAY DESORDENADO
		System.out.println("Int\nArray Desordenado: ");
		for (int i = 0; i < ordenacion2.length; i++) {
			System.out.println(ordenacion2[i]);
		}

		// ORDENACION DEL ARRAY
		for (int i = 0; i < ordenacion2.length; i++) {
			for (int j = 0; j < ordenacion2.length - 1; j++) {
				if (ordenacion2[j] > ordenacion2[j + 1]) {
					auxiliar2 = ordenacion2[j];
					ordenacion2[j] = ordenacion2[j + 1];
					ordenacion2[j + 1] = auxiliar2;
				}
			}
		}

		// ARRAY DESORDENADO
		System.out.println("\nArray Ordenado: ");
		for (int i = 0; i < ordenacion2.length; i++) {
			System.out.println(ordenacion2[i]);
		}

		// STRING
		// VARIABLES
		String auxiliar;
		String[] ordenacion = { "b", "c", "z", "r", "a" };

		// ARRAY DESORDENADO
		System.out.println("\nStrings\nArray Desordenado: ");
		for (int i = 0; i < ordenacion.length; i++) {
			System.out.println(ordenacion[i]);
		}

		// ORDENACION DEL ARRAY
		for (int i = 1; i <= ordenacion.length; i++) {
			for (int j = 0; j < ordenacion.length - i; j++) {
				if (ordenacion[j].compareTo(ordenacion[j + 1]) > 0) {
					auxiliar = ordenacion[j];
					ordenacion[j] = ordenacion[j + 1];
					ordenacion[j + 1] = auxiliar;
				}
			}
		}

		// ARRAY DESORDENADO
		System.out.println("\nArray Ordenado: ");
		for (int i = 0; i < ordenacion.length; i++) {
			System.out.println(ordenacion[i]);
		}
	}
}
