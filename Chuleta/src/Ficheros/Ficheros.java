package Ficheros;
import java.io.File;
import java.util.Date;

public class Ficheros {

	public static void main(String[] args) {
//		DECLARACION DE VARIABLE
		File ruta = new File("C:/Windows");
		File document = new File("C:/Users/jcsal/text.txt");

		System.out.println("Separador del sistema: " + File.separator + "\n");

		String dirTreball = System.getProperty("user.dir");
		System.out.println("Ruta de trabajo de eclipse: " + System.setProperty("user.dir", dirTreball) + "\n");

		System.out.println("La ruta és " + ruta.getAbsolutePath());
		System.out.println("El seu pare és " + ruta.getParent());
		System.out.println("El seu nom és " + ruta.getName() + "\n");

//		COMPROBACION SI SON FICHEROS O CARPETAS
		System.out.println(document.getAbsolutePath() + " és un fitxer? " + document.isFile());
		System.out.println(ruta.getAbsolutePath() + " és una carpeta? " + ruta.isDirectory());

		Date data = new Date(ruta.lastModified());
		System.out.println("\nDarrera modificació: " + data);
		System.out.println("Mida (Peso del archivo o carpeta): " + ruta.length());

		File carpeta = new File("C:/IOC Programacio/Java/Fonts/Unitat 6/Temp");
		if (carpeta.exists() == true) {
			carpeta.delete();
			System.out.println("\nSe ha borrado la carpeta C:/IOC Programació/Java/Fonts/Unitat 6/Temp.");
		} else {
			carpeta.mkdirs();
			System.out.println("\nSe ha creado la carpeta C:/IOC Programació/Java/Fonts/Unitat 6/Temp.");
		}

		File origenCarpeta = new File("C:/IOC Programació/Java/Fonts/Unitat 6/Salinas");
		File destiCarpeta = new File("C:/IOC Programació/Java/Fonts/Carlos");
		File origenDocument = new File("C:/IOC Programació/Java/Fonts/Unitat 6/doc.txt");
		File destiDocument = new File("C:/IOC Programació/Java/Fonts/doc.txt");
		boolean resultat = origenCarpeta.renameTo(destiCarpeta);
		System.out.println("\nS'ha mogut i reanomenat la carpeta? " + resultat);
		resultat = origenDocument.renameTo(destiDocument);
		System.out.println("S'ha mogut el document? " + resultat);

		File rutaOrigen = new File("C:/IOC Programació/Java/Fonts/Unitat 6/doc.txt");
		// Reanomenar: mateixa ruta pare però diferent nom final
		String nouNom = rutaOrigen.getParent() + File.separator + "Reanomenat.txt";
		File rutaDesti = new File(nouNom);
		System.out.println(rutaOrigen.renameTo(rutaDesti));

		
		System.out.println(ruta.listFiles());
	}

}
