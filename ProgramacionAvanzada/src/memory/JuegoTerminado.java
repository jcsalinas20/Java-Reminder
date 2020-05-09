package memory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoTerminado extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JButton btnJugarOtraVez, btnOtroJuego;

	public JuegoTerminado(int intentos) {
		setTitle("Game Over");
		setBounds(100, 100, 500, 465);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 230, 230 };// Cada posicion define los pixeles que ocupa cada
																// columna.
		gbl_contentPane.rowHeights = new int[] { 75, 240, 0 };// Cada posicion define los pixeles que ocupa cada fila.
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };// Este 1.0 de la 3a posicion rellena el
																	// hueco que queda a la derecha en el JFrame.
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0 };// 1.0 significa rellenar la 3a fila con el hueco
																	// que queda a bajo del JFrame.
		contentPane.setLayout(gbl_contentPane);
		contentPane.setBackground(Color.gray);// Color de fondo.

//		JLabel con el numero de intentos.
		JLabel lblTitulo = new JLabel("Has terminado la partida con " + intentos + " intentos.");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);

//		Posicionamiento: si tienes 8 intentos eres Experto, menos de 13 Profesional, menos de 21 Normal o mas de 20 Novato.
		String posicionamiento = "";
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				posicionamiento += "<html>Experto (8 intentos) <br>";
				if (intentos == 8) {
					posicionamiento += " Jugador 1<br><br>";
				} else {
					posicionamiento += " - - -<br><br>";
				}
			} else if (i == 1) {
				posicionamiento += "Profesional (9-12 intentos)<br>";
				if (intentos >= 9 && intentos <= 12) {
					posicionamiento += " Jugador 1<br><br>";
				} else {
					posicionamiento += " - - -<br><br>";
				}
			} else if (i == 2) {
				posicionamiento += "Normal (13-20 intentos)<br>";
				if (intentos >= 13 && intentos <= 20) {
					posicionamiento += " Jugador 1<br><br>";
				} else {
					posicionamiento += " - - -<br><br>";
				}
			} else if (i == 3) {
				posicionamiento += "Novato (+20 intentos)<br>";
				if (intentos > 20) {
					posicionamiento += " Jugador 1</html>";
				} else {
					posicionamiento += " - - -</html>";
				}
			}

		}

//		JPanel para el posicionamiento.
		JPanel panelPosicionamiento = new JPanel();
		panelPosicionamiento.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//		JLabel posicionamiento.
		JLabel lblPosicionamiento = new JLabel(posicionamiento);
		lblPosicionamiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosicionamiento.setPreferredSize(new Dimension(400, 250));
		lblPosicionamiento.setBorder(new EmptyBorder(5, 20, 5, 5));
		panelPosicionamiento.add(lblPosicionamiento);
		
		GridBagConstraints gbc_lblPosicionamiento = new GridBagConstraints();
		gbc_lblPosicionamiento.gridwidth = 2;
		gbc_lblPosicionamiento.gridx = 0;
		gbc_lblPosicionamiento.gridy = 1;
		contentPane.add(panelPosicionamiento, gbc_lblPosicionamiento);

//		Boton para jugar otra vez.
		btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnJugarOtraVez.setBackground(new Color(210, 210, 210));
		GridBagConstraints gbc_btnJugarOtraVez = new GridBagConstraints();
		gbc_btnJugarOtraVez.gridx = 0;
		gbc_btnJugarOtraVez.gridy = 2;
		contentPane.add(btnJugarOtraVez, gbc_btnJugarOtraVez);
		btnJugarOtraVez.addActionListener(this);

//		Boton para elegir otro juego.
		btnOtroJuego = new JButton("Otro juego");
		btnOtroJuego.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOtroJuego.setBackground(new Color(210, 210, 210));
		GridBagConstraints gbc_btnOtroJuego = new GridBagConstraints();
		gbc_btnOtroJuego.gridx = 1;
		gbc_btnOtroJuego.gridy = 2;
		contentPane.add(btnOtroJuego, gbc_btnOtroJuego);
		btnOtroJuego.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJugarOtraVez) {
			Main.frame.dispose();
			dispose();
			new Main();
		} else if (e.getSource() == btnOtroJuego) {
			dispose();
//			new SeleccionJuegos();			
		}
	}

}
