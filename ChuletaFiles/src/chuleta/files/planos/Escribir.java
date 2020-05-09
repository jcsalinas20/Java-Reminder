package chuleta.files.planos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Escribir {

	public static void main(String[] args) throws FileNotFoundException {
		File fichero = new File("src" + File.separator + "ejercicio2" + File.separator + "ReadLineFileJava.java");// Ruta relativa del mismo fichero.
		PrintStream escriptor = new PrintStream(fichero);// PrintStream para poder escribir en el fichero

		// Nuevo mensaje que se introduce en el fichero.
		escriptor.println("Yo solo puedo mostrarte la puerta, tu eres quien la tiene que atravesar.");

		escriptor.close();// Cierre del escriptor
	}

}
