package buscaminas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaReiniciar extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;// Jpanel que envuelve to el Frame.
	JButton btnSi, btnNo;// 2 botones como respuestas.

	public VentanaReiniciar() {
		setBounds(100, 100, 520, 160);// Tamanio del Frame.
		setTitle("Reiniciar Partida (Ventana principal bloqueada)");// Titulo del frame.
		contentPane = new JPanel();// Inizializacion del JPanel.
		GridBagLayout gbl_contentPane = new GridBagLayout();// Declaracion del GridBagLayout.
		gbl_contentPane.columnWidths = new int[] { 200, 200 };// Dimensiones de cada columna.
		gbl_contentPane.rowHeights = new int[] { 50, 50 };// Dimensiones de cada fila.
		contentPane.setLayout(gbl_contentPane);// Meter el nuevo Layout al JPanel.
		setContentPane(contentPane);// Aniadir el JPanel con el JFrame.

		JLabel lblPregunta = new JLabel("Quieres volver ha jugar con la misma configuracion?");// Label con la pregunta.
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblPregunta = new GridBagConstraints();// Declaracion del GridBagLayout.
		gbc_lblPregunta.gridwidth = 2;// Ocupar 2 celdas en lo ancho.
		gbc_lblPregunta.gridx = 0;// Indicacion de la cordenada X.
		gbc_lblPregunta.gridy = 0;// Indicacion de la cordenada Y.
		contentPane.add(lblPregunta, gbc_lblPregunta);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		btnSi = new JButton("Si");// Boton con una respuesta.
		btnSi.setBackground(new Color(210, 210, 210));// Color de fondo.
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_btnSi = new GridBagConstraints();// Declaracion del GridBagLayout.
		gbc_btnSi.gridx = 0;// Indicacion de la cordenada X.
		gbc_btnSi.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(btnSi, gbc_btnSi);// Aniadir al JPanel el JButton junto con el GridBagConstraints.
		btnSi.addActionListener(this);// Llamada al listener.

		btnNo = new JButton("No");// Boton con una respuesta.
		btnNo.setBackground(new Color(210, 210, 210));// Color de fondo.
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_btnNo = new GridBagConstraints();// Declaracion del GridBagLayout.
		gbc_btnNo.gridx = 1;// Indicacion de la cordenada X.
		gbc_btnNo.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(btnNo, gbc_btnNo);// Aniadir al JPanel el JButton junto con el GridBagConstraints.
		btnNo.addActionListener(this);// Llamada al listener.

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
//				Si se cierra esta ventana se habilitara la ventana del juego ya que anteriormente la hemos deahabilitado.
				VentanaJuego.frame.setEnabled(true);
			}
		});

		setVisible(true);// Hacer visible el JFrame.
	}

//	Metodo actionPerformed del listener ActionListener.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSi) {
			VentanaJuego.frame.dispose();// Cerrar la ventana del juego.
			dispose();// Cerrar la centana actual.
			new VentanaJuego();// Abrir la ventana del juego.
		} else if (e.getSource() == btnNo) {
			VentanaJuego.frame.dispose();// Cerrar la ventana del juego.
			dispose();// Cerrar la centana actual.
			new Main();// Abrri la ventana de configuracion de partida.
		}
	}
}
