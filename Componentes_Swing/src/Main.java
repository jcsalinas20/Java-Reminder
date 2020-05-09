import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();

	public Main() {
		setTitle("Titulo");
//		setResizable(false);
		setLayout(new BorderLayout());

		JPanel container = new JPanel();
		container.setLayout(new GridBagLayout());
		container.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(3, 3, 3, 3),
				BorderFactory.createTitledBorder("Exemple GridBagLayout")));
		

		add(container);
//		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
//		Main m = new Main();
	}

}
