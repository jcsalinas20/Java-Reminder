import java.util.Scanner;

public class validacion {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int[] array = new int[5];
		int num1;
		String palabra = "";
		boolean validacion = false;

		// SIN BUCLE INT
		do {
			System.out.print("Introduce un numero: ");
			if (lector.hasNextInt()) {
				num1 = lector.nextInt();
				validacion = true;
			} else {
				lector.nextLine();
			}
		} while (validacion != true);

		// CON BUCLE INT
		validacion = false;
		do {
			for (int i = 0; i < array.length; i++) {
				System.out.print("Introduce un numero para la posicion[" + i + "]: ");
				if (lector.hasNextInt()) {
					num1 = lector.nextInt();
					validacion = true;
				} else {
					lector.nextLine();
					i--;
				}
			}
		} while (validacion != true);

		// STRINGS
		validacion = false;
		do {
			System.out.println("Introduce Si o No.");
			palabra = lector.next();
			if (palabra.equalsIgnoreCase("No")) {
				System.out.println("Has salido.");
				validacion = true;
			} else if (palabra.equalsIgnoreCase("Si")) {
				System.out.println("Sigues.");
				validacion = true;
			}
		} while (validacion != true);

		lector.close();
	}

}
