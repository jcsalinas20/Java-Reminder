import java.awt.*;

import javax.swing.*;

public class Ejemplo_JTable extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ejemplo_JTable() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		final String[] nomCol = { "id", "Practica", "Aula" };

		String[][] datos = { { "1", "Instruccions", "103" }, { "2", "Paquetes", "102" }, { "3", "Herencia", "106" },
				{ "4", "Interfaces", "110" }, { "5", "Applets", "98" }, { "6", "GUI", "101" }, };

		JTable tabla = new JTable(datos, nomCol);
		tabla.setFont(new Font("Arail", Font.BOLD, 20));
		tabla.setRowHeight(27);

		JScrollPane jsp = new JScrollPane(tabla);

		c.add(jsp);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ejemplo_JTable();
	}

}
