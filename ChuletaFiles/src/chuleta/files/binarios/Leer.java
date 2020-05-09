package chuleta.files.binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Leer {

//	Leer objetos
	public static void main(String[] args) throws FileNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("hh.txt")));
			Object auxiliar = ois.readObject();
			while (auxiliar != null) {
//				Escribir c = (Escribir) auxiliar;
//				idCurs = c.key;// Guardar la key en la ID declarada globalmente
//				main.cursos.put(idCurs, c);// Agregar Curs(c) al HashMap
//				auxiliar = ois.readObject();
			}
			ois.close();
		} catch (Exception e) {
			System.out.println("Fitxer llegit correctament.");
		}
	}

}
