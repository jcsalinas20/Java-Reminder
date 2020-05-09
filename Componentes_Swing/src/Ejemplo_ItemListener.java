import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Ejemplo_ItemListener extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	Container c = getContentPane();
	JPanel body, menu;
	boolean checkColor = false, checkNegrita = false, checkInclinada = false, checkGran = false;
	JCheckBox color, negrita, inclinada, gran;
	JLabel labelText;
	Font f = new Font("Serif", Font.PLAIN, 30);
	Dimension dimBody = new Dimension(710, 50);
	Dimension dimMenu = new Dimension(260, 245);
	Dimension Mindimensio = new Dimension(1003, 302);

	public Ejemplo_ItemListener() {
		this.setTitle("Chechboxes");
		this.setLayout(new FlowLayout());
		this.setSize(Mindimensio);

		body = new JPanel();
		body.setPreferredSize(dimBody);
		body.setLayout(new FlowLayout());
		labelText = new JLabel("Jugem amb Checkboxes...");
		labelText.setFont(f);
		body.add(labelText);
		c.add(body);

		menu = new JPanel();
		menu.setPreferredSize(dimMenu);
		menu.setLayout(new GridLayout(4, 1));
		color = new JCheckBox("Color");
		menu.add(color);
		color.addItemListener(this);

		negrita = new JCheckBox("Negrita");
		menu.add(negrita);
		negrita.addItemListener(this);

		inclinada = new JCheckBox("Inclinada");
		menu.add(inclinada);
		inclinada.addItemListener(this);

		gran = new JCheckBox("Gran");
		menu.add(gran);
		gran.addItemListener(this);
		c.add(menu);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(Mindimensio);
		this.setVisible(true);
	}

	private void cambio() {
		if (!checkNegrita && !checkInclinada && !checkGran) {
			f = new Font("Serif", Font.PLAIN, 30);
		} else if (checkNegrita && !checkInclinada && !checkGran) {
			f = new Font("Serif", Font.BOLD, 30);
		} else if (!checkNegrita && !checkInclinada && checkGran) {
			f = new Font("Serif", Font.PLAIN, 35);
		} else if (!checkNegrita && checkInclinada && !checkGran) {
			f = new Font("Serif", Font.ITALIC, 30);
		} else if (checkNegrita && checkInclinada && !checkGran) {
			f = new Font("Serif", Font.BOLD + Font.ITALIC, 30);
		} else if (checkNegrita && checkInclinada && checkGran) {
			f = new Font("Serif", Font.BOLD + Font.ITALIC, 35);
		} else if (checkNegrita && !checkInclinada && checkGran) {
			f = new Font("Serif", Font.BOLD, 35);
		} else if (!checkNegrita && checkInclinada && checkGran) {
			f = new Font("Serif", Font.ITALIC, 35);
		}
		labelText.setFont(f);
	}

	public static void main(String[] args) {
		new Ejemplo_ItemListener();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int state = e.getStateChange();
		if (e.getSource() == color) {
			if (state == ItemEvent.SELECTED) {
				c.setBackground(Color.pink);
				body.setBackground(Color.pink);
			} else {
				c.setBackground(null);
				body.setBackground(null);
			}
		} else if (e.getSource() == negrita) {
			if (state == ItemEvent.SELECTED) {
				checkNegrita=true;
			} else {
				checkNegrita=false;
			}
		}else if (e.getSource() == inclinada) {
			if (state == ItemEvent.SELECTED) {
				checkInclinada=true;
			} else {
				checkInclinada=false;
			}
		}else if (e.getSource() == gran) {
			if (state == ItemEvent.SELECTED) {
				checkGran=true;
			} else {
				checkGran=false;
			}
		}
		cambio();
	}

}
