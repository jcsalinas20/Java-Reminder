package Ficheros;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FicherosBinarios {

	public static void main(String[] args) {
		try {
			File path = new File("FicherosBinarios.bin");
			RandomAccessFile raf = new RandomAccessFile(path, "rw");
			
//			CAMBIA LA LONGITUD DEL FICHERO
			raf.setLength(50);
			
			System.out.println("EL PUNTERO SE ENCUENTRA EN LA POSICION: "+raf.getFilePointer());
			
//			INDICA DONDE SE TIENE QUE SITUAR EL PUNTERO
			raf.seek(20);
			System.out.println("EL PUNTERO SE ENCUENTRA EN LA POSICION: "+raf.getFilePointer());
			
//			SE SALTA LAS POSICIONES QUE LE DICES
			raf.skipBytes(10);
			System.out.println("EL PUNTERO SE ENCUENTRA EN LA POSICION: "+raf.getFilePointer());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
