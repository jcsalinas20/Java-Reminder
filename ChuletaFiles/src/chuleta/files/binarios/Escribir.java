package chuleta.files.binarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escribir {

//	escribir objetos (xml)
	public static void main(String[] args) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("hh.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			for (Entry<String, Leer> entry : cursos.entrySet()) {
//				oos.writeObject(entry.getValue());// Escribir el objeto Curs en el archivo
//			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
