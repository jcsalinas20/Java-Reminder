import java.util.Arrays;
import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int a = 1;
		// FORMAS DE DECLARAR LA VARIABLE STRING
		String cadena = "Esto es un string";
		String cadena1 = new String();
		String cadena2 = new String("HOLA");
		//
		String[] array = { "String 1", " String 2", " String 3" };

		String S;

		// MOSTRAR UN CARACTER DE UN STRING
		System.out.println("MOSTRAR UN CARACTER DE UN STRING: " + cadena.charAt(5));

		// MOSTRAR TODO EL STRING
		System.out.println("\nMOSTRAR TODO EL STRING:");
		for (int i = 0; i < cadena.length(); i++) {
			System.out.print(cadena.charAt(i));
		}
		System.out.println("\nMOSTRAR TODO EL STRING INVERSO:");
		for (int i = cadena.length() - 1; i >= 0; i--) {
			System.out.print(cadena.charAt(i));
		}

		// JUNTAR STRINGS SIN MACHACAR
		String cad1 = "Hola ";
		String cad2 = "mon";
		cad1.concat(cad2);
		System.out.println("\n\nJUNTAR STRINGS SIN MACHACAR: " + cad1.concat(cad2));

		// MOSTRAR STRING DE ARRAYS
		System.out.println("\nMOSTRAR STRING DE ARRAYS:");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length(); j++) {
				System.out.print(array[i].charAt(j));
			}
		}

		System.out.println("\n\nBUSCAR CARACTER (TE MUESTRA LA POSICION) DES DEL PRINCIPIO: " + cadena.indexOf("g"));
		System.out.println("\nBUSCAR CARACTER (TE MUESTRA LA POSICION) DES DEL FINAL: " + cadena.lastIndexOf("es"));
		System.out.println(
				"\nCOMPARACION DE VALORES STRING CIERTAS(key sensitive): " + cadena.equals("Esto es un string"));
		System.out.println("COMPARACION DE VALORES STRING ERRONEA(key sensitive): " + cadena.equals("un string"));
		System.out.println("\nCOMPARACION DE VALORES STRING CIERTAS: " + cadena.equalsIgnoreCase("ESTO ES UN STRING"));
		System.out.println("\nCOMPARE TO(key sensitive): " + cadena.compareTo("ESTO ES UN STRING"));
		System.out.println("COMPARE TO: " + cadena.compareToIgnoreCase("Esto es un string"));

		// EL 8 NO LO COGE
		String subcadena = cadena.substring(2, 8);
		System.out.println("\nMOSTRAR DES DE UNA POSICION A OTRA: " + subcadena);

		// SPLIT QUITA EL CARACTER INTRODUCIDO POR UN ESPACIO
		String[] cadenatosString = cadena.split("");
		System.out.println("\nDIVIDES EL STRING EN ARRAYS POR EL CARACTER ELEGIDO: "+Arrays.toString(cadenatosString));

		// CAMBIAR DE INT A STRING
		int v = 5;
		String V = String.valueOf(v);
		System.out.println("\nCAMBIAR DE INT A STRING: "+V);

		// CAMBIAR DE STRING A INT
		String numero = "25";
		int numero1 = Integer.parseInt(numero);
		System.out.println("\nCAMBIAR DE STRING A INT: "+numero1);

		
	}

}
