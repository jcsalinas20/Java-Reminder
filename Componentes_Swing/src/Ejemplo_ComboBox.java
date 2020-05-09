import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class Ejemplo_ComboBox extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public Ejemplo_ComboBox() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox<String> cb = new JComboBox<String>();

		cb.addItem("Naruto");
		cb.addItem("Sasuke");
		cb.addItem("Hinata");
		cb.addItem("Temari");
		cb.addItem("Kakashi");
		
		cb.setFont(new Font("Arial", Font.BOLD, 20));
		
		c.add(cb);
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ejemplo_ComboBox();
	}

}
