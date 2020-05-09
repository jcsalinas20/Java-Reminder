import java.awt.Component;

import javax.swing.*;

public class Ejemplo_JOptionPane {

	private static Component frame;

	public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("src/images/correct.png");

		Object[] options = { "Si", "No" };
		int n = JOptionPane.showOptionDialog(frame, "Quieres conectarte a la base de datos?", "Conexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Conectado correctamente", "Succesfull", JOptionPane.INFORMATION_MESSAGE, icon);
		} else if (n == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar", "Failure", JOptionPane.ERROR_MESSAGE);
		}
		/*JOptionPane.showMessageDialog(null, "Este es un mensaje de informacion", "Information",
				JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "Este es un mensaje de cancelacion", "Failure", JOptionPane.CANCEL_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje para cerrar", "Failure", JOptionPane.CLOSED_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje por defecto", "Failure", JOptionPane.DEFAULT_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje sin opciones", "Failure", JOptionPane.NO_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de OK o Cancelar", "Failure",
				JOptionPane.OK_CANCEL_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de OK", "Failure", JOptionPane.OK_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de plano", "Failure", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de question", "Failure", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de alerta", "Failure", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de YES, NO o CANCEL", "Failure",
				JOptionPane.YES_NO_CANCEL_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de YES, NO", "Failure", JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(null, "Este es un mensaje de YES", "Failure", JOptionPane.YES_OPTION);*/

	}

}
