import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Ejemplo_JColorChooser extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton b;
	Container c;
	JLabel a;

	Ejemplo_JColorChooser() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		b = new JButton("color");
		b.addActionListener(this);

		a = new JLabel("");

		c.add(b);
		c.add(a);
	}

	public void actionPerformed(ActionEvent e) {
		Color initialcolor = Color.RED;
		Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
		c.setBackground(color);
		a.setText("R: " + color.getRed() + "  G: " + color.getGreen() + "  B: " + color.getBlue());
	}

	public static void main(String[] args) {
		Ejemplo_JColorChooser ch = new Ejemplo_JColorChooser();
		ch.setSize(400, 400);
		ch.setVisible(true);
		ch.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}