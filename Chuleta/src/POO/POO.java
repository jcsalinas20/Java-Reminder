package POO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class POO {

	public static void main(String[] args) {
		int suma = 0;
		int media = 0;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		System.out.println("Introduce numeros: ");
		while (fin == false) {
			int num = lector.nextInt();
			if (num == 0) {
				fin = true;
				int divisor = lista.size();
				media = suma / divisor;
			} else {
				lista.add(num);
				suma = suma + num;
			}
		}
		Iterator<Integer> it = lista.iterator();
		System.out.print("Iterator [ ");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("]");
		System.out.print("For [ ");
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i) + ", ");
		}
		System.out.println("]");
		System.out.println("Suma total: " + suma);
		System.out.println("Media: " + media);
		lector.close();
	}

}
