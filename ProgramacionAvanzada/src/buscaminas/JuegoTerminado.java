package buscaminas;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoTerminado extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;// Jpanel que envuelve to el Frame.
	JButton btnSi, btnNo;// 2 botones como respuestas.

//	A este constructor se le pasa un string para saber si ha ganado o perdido.
	public JuegoTerminado(String partida) {
		VentanaJuego.frame.setEnabled(false);// Deshabilitar la ventana principal.
		setTitle("Game Over");// Titulo del Frame.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Terminar el programa cuando se cierre o acabe.
		setBounds(100, 100, 570, 175);// Tamanio del Frame.
		contentPane = new JPanel();// Inizializacion del JPanel.
		setContentPane(contentPane);// Aniadir el JPanel al Frame.
		GridBagLayout gbl_contentPane = new GridBagLayout();/// Declaracion del GridBagLayout.
		gbl_contentPane.columnWidths = new int[] { 220, 220 };// Dimensiones de las columnas.
		gbl_contentPane.rowHeights = new int[] { 70, 30 };// Dimensiones de las filas.
		contentPane.setLayout(gbl_contentPane);// Meter el nuevo Layout al JPanel.

		JLabel lblMensage = new JLabel();// Label vacio.
//		Dependiendo del mensaje del string pasado al construcor es un mesaje u otro.
		if (partida.equals("perdida")) {
			lblMensage.setText("Perdiste la partida. Quieres volver a jugar?");
		} else if (partida.equals("ganada")) {
			lblMensage.setText("Ganaste la partida. Quieres volver a jugar?");
		}
		lblMensage.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblMensage = new GridBagConstraints();// Declaracion de GridBagConstraints.
		gbc_lblMensage.gridwidth = 2;// Ocupar 2 celdas en lo ancho.
		gbc_lblMensage.gridx = 0;// Indicacion de la cordenada X.
		gbc_lblMensage.gridy = 0;// Indicacion de la cordenada Y.
		contentPane.add(lblMensage, gbc_lblMensage);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		btnSi = new JButton("Si");
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		btnSi.setBackground(new Color(210, 210, 210));// Color de fondo.
		GridBagConstraints gbc_btnSi = new GridBagConstraints();// Declaracion de GridBagConstraints.
		gbc_btnSi.gridx = 0;// Indicacion de la cordenada X.
		gbc_btnSi.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(btnSi, gbc_btnSi);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.
		btnSi.addActionListener(new ActionListener() {// Listener.
			public void actionPerformed(ActionEvent e) {
				VentanaJuego.frame.setEnabled(true);// Habilitar el Frame de VentanaJuego.
				VentanaJuego.frame.dispose();// Cerramos VentanaJuego.
				dispose();// Cerramos esta ventana.
				new VentanaJuego();// Abrimos VentanaJuego.
			}
		});

		btnNo = new JButton("No");
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		btnNo.setBackground(new Color(210, 210, 210));// Color de fondo.
		GridBagConstraints gbc_btnNo = new GridBagConstraints();// Declaracion de GridBagConstraints.
		gbc_btnNo.gridx = 1;// Indicacion de la cordenada X.
		gbc_btnNo.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(btnNo, gbc_btnNo);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.
		btnNo.addActionListener(new ActionListener() {// Listener.
			public void actionPerformed(ActionEvent e) {
				VentanaJuego.frame.dispose();// Cerramos VentanaJuego.
				dispose();// Cerramos esta ventana.
			}
		});

		setVisible(true);// Hacer visible el JFrame.
	}

}
