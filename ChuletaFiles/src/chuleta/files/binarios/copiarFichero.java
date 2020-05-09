package chuleta.files.binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class copiarFichero {

	private static void copiarOrigenDestino(File carpetaDestino, File carpetaOrigen) {
		try {
			byte[] buffer = new byte[1024];
			InputStream fis = new FileInputStream(carpetaOrigen);
			OutputStream fos = new FileOutputStream(carpetaDestino);
			int numRead;
			while ((numRead = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, numRead);
			}
			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
