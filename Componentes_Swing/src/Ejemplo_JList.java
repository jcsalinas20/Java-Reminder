import java.awt.*;

import javax.swing.*;

public class Ejemplo_JList extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Ejemplo_JList() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		String[] datos= {"Naruto", "Sasuke", "Hinata", "Temari", "Kakashi"};
		JList<String> lista=new JList<String>(datos);
		
		lista.setFont(new Font("Arial", Font.BOLD, 20));
		
		c.add(lista);
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ejemplo_JList();
	}

}
