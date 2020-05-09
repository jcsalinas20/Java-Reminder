import java.awt.*;

import javax.swing.*;

public class Ejemplo_JProgressBar extends JFrame {
	private static final long serialVersionUID = 1L;
	JProgressBar current;
	JTextArea out;
	JButton find;
	Thread runner;
	int num = 0;

	public Ejemplo_JProgressBar() {
		super("Progress");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		current = new JProgressBar(0, 1000);
		current.setValue(0);
		current.setPreferredSize(new Dimension(400, 13));
		current.setForeground(Color.GREEN);
		current.setBorder(BorderFactory.createLineBorder(Color.red, 1, true));
//		current.setStringPainted(true);//MOSTRAR NUMERO DE PORCENTAJE
		pane.add(current);
		setContentPane(pane);
	}

	public void iterate() {
		while (num < 2000) {
			current.setValue(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			num += 95;
		}
	}

	public static void main(String[] arguments) {
		Ejemplo_JProgressBar frame = new Ejemplo_JProgressBar();
		frame.pack();
		frame.setVisible(true);
		frame.iterate();
	}
}
