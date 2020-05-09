package chuleta.files.planos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leer {

	public static void main(String[] args) throws FileNotFoundException {
		File fichero = new File("src" + File.separator + "ejercicio2" + File.separator + "ReadLineFileJava.java");// Ruta relativa del mismo fichero.

//		Comprobacion que existe el fichero.
		if (fichero.exists()) {
			Scanner lector = new Scanner(fichero);// Variable scanner del fichero de la ruta.

			while (lector.hasNextLine()) {// While hasta que no ecuentre ninguna linea mas.
				System.out.println(lector.nextLine());// Mostrar cada linea del fichero.
			}

			lector.close();// Cierre de la varible scanner del fichero.
		}
	}

}
