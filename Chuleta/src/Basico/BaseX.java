package Basico;
import java.util.Scanner;

public class BaseX {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		boolean validacion = false;
		int posiciones = 0;
		int base = 0;
		int total = 0;

		do {
			System.out.println("Que base quieres utilizar: ");
			if (x.hasNextInt()) {
				base = x.nextInt();
				if (base > 0) {
					validacion = true;
				}
			} else {
				x.next();
			}
		} while (validacion != true);
		System.out.print("BASE " + base);

		validacion = false;
		do {
			System.out.print("\rIntroduce los numero que quieres: ");
			if (x.hasNextInt()) {
				posiciones = x.nextInt();
				if (posiciones > 0) {
					validacion = true;
				}
			} else {
				x.next();
			}
		} while (validacion != true);

		//creacion de array
		int[] tabla = new int[posiciones];

		validacion = false;
		for (int i = 0; i < posiciones; i++) {
			do {
				System.out.print("Introduce un numero: ");
				if (x.hasNextInt()) {
					tabla[i] = x.nextInt();
					if (tabla[i] >= 0 && tabla[i] < base) {
						validacion = true;
					} else if (i == 0) {
						System.out
								.println("El numero tiene que ser mas grande o igual que 0 i mas pequeno que la base.");
					} else {
						System.out
								.println("El numero tiene que ser mas grande o igual que 0 i mas pequeno que la base.");
						i--;
					}
				} else if (i == 0) {
					x.next();
				} else {
					x.next();
					i--;
				}
			} while (validacion != true);
		}

		System.out.print("El numero introducido es: ");
		for (int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i]);
		}

		int elevado=tabla.length;
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = tabla[i] * (base*elevado);
			elevado--;
		}

		for (int i = 0; i < tabla.length; i++) {
			total = total + tabla[i];
		}
		
		System.out.println("\rResultado: " + total);
		x.close();
	}

}
