package Basico;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Factorial programa = new Factorial();
		programa.inici();
	}

	public void inici() {
		Scanner lector = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int numero = lector.nextInt();
		factorial(numero);
		System.out.println(factorial(numero));
		lector.close();
	}

	public int factorial(int numero) {
		int resultat = 1;
		for (int i = numero; i > 0; i--) {
			resultat = resultat * i;
		}
		return resultat;
	}

}
