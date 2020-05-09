package Basico;
import java.util.Arrays;

public class MatrizAjedrez {

	public static void main(String[] args) {
		char[][] ajedrez = new char[16][16];

		for (int i = 0; i < ajedrez.length; i++) {
			for (int j = 0; j < ajedrez[i].length; j++) {
				ajedrez[i][j] = '#';
			}
		}

		for (int i = 0; i < ajedrez.length; i++) {
			System.out.print(Arrays.toString(ajedrez[i]));
			System.out.println();
		}
	}
}
