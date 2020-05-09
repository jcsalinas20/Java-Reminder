
import java.io.File;

import javax.swing.JFileChooser;

import javax.swing.filechooser.FileSystemView;

public class Ejemplo_JFileChooser {

	public static void main(String[] args) {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}

	}

}

class FolderChooser {

	public static void main(String[] args) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setCurrentDirectory(new File(System.getProperty("user.home")));

		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getSelectedFile(): " + jfc.getSelectedFile());
		}

	}

}