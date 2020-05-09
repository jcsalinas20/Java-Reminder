import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejemplo_Imagenes extends JFrame {
	private static final long serialVersionUID = 1L;

	public Ejemplo_Imagenes() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		Image img = new ImageIcon("src/images/image.jpeg").getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(450, 500, Image.SCALE_SMOOTH));
		
		c.add(new JLabel("", img2, JLabel.CENTER));
		c.add(new JButton("", img2));
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ejemplo_Imagenes();
	}

}
