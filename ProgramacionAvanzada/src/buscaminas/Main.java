package buscaminas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

// Las partes donde veas una mezcla de numeros y letras como \u00F3 o \u00B2 es que son caracteres con acentos o simbolos raros en lenguaje Unicode.
public class Main extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	static int dimension = 0;// Se guarda el numero de la dimension introducido en tfNumero.
	JPanel contentPane;// JPanel que envuelve todo el JFrme.
	JLabel lblTitulo;// Label para poner el titulo.
	JLabel lblDimensiones;// Label que pone dimension.
	JLabel lblElevadoAlCuadrado;// Label que esta puesto el simbolo de elevado al cuadrado.
	JLabel lblReglas;// Label donde te explica las reglas.
	static JTextField tfNumero;// TextField donde introducir el numero de la dimension.
	JButton btnEmpezar;// Este boton hace que empieze la partida.
	JLabel lblError;// Laber que te muestra si hay algun fallo en el numero de la dimension
					// introducido.

//	Constructor de la clase VentanaPrincipal.
	public Main() {
		setTitle("Configuraci\u00F3n de partida");// Titulo del JFrame.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Terminar el programa cuando se cierre la ventana.
		setBounds(100, 100, 710, 335);// Dimensiones del JFrame.
		contentPane = new JPanel();// Inizializacion del JPanel general.
		GridBagLayout gbl_contentPane = new GridBagLayout();// Declaracion del GridBagLayout.
		gbl_contentPane.columnWidths = new int[] { 200, 40, 180, 240 };// Dimensiones de cada columna.
		gbl_contentPane.rowHeights = new int[] { 75, 40, 70, 39 };// Dimensiones de cada fila.
		contentPane.setLayout(gbl_contentPane);// Meter el nuevo Layout al JPanel
		setContentPane(contentPane);// Aniadir el JPanel con el JFrame.

		lblTitulo = new JLabel("Preparativos de Partida");// Inizializacion de label con texto.
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblTitulo.anchor = GridBagConstraints.CENTER;// Ponerlo en el centro de la celda.
		gbc_lblTitulo.gridwidth = 4;// Ocupar 4 celdas en lo ancho.
		gbc_lblTitulo.gridx = 0;// Indicacion de la cordenada X.
		gbc_lblTitulo.gridy = 0;// Indicacion de la cordenada Y.
		contentPane.add(lblTitulo, gbc_lblTitulo);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		lblDimensiones = new JLabel("Dimensi\u00F3n: ");// Inizializacion del label con text y con el symbolo unicode
														// \u00F3 que es la "o acentuada".
		lblDimensiones.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblDimensiones = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblDimensiones.anchor = GridBagConstraints.EAST;// Ponerlo en el este de la celda.
		gbc_lblDimensiones.gridx = 0;// Indicacion de la cordenada X.
		gbc_lblDimensiones.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(lblDimensiones, gbc_lblDimensiones);// Aniadir al JPanel el JLabel junto con el
															// GridBagConstraints.

		tfNumero = new JTextField("0", 1);// TextField con el numero 0 y con el numero de columnas 1.
		tfNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_tfNumero = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_tfNumero.fill = GridBagConstraints.HORIZONTAL;// Rellenar la celda horizontalmente.
		gbc_tfNumero.gridx = 1;// Indicacion de la cordenada X.
		gbc_tfNumero.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(tfNumero, gbc_tfNumero);// Aniadir al JPanel el TextField junto con el GridBagConstraints.

		lblElevadoAlCuadrado = new JLabel("\u00B2");// Simbolo unicode que es el "elevado al cuadrado".
		lblElevadoAlCuadrado.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y
																			// tamanio.
		GridBagConstraints gbc_lblElevadoAlCuadrado = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblElevadoAlCuadrado.anchor = GridBagConstraints.NORTHWEST;// Ponerlo en el noroeste de la celda.
		gbc_lblElevadoAlCuadrado.gridx = 2;// Indicacion de la cordenada X.
		gbc_lblElevadoAlCuadrado.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(lblElevadoAlCuadrado, gbc_lblElevadoAlCuadrado);// Aniadir al JPanel el JLabel junto con el
																		// GridBagConstraints.

		btnEmpezar = new JButton("Empezar partida");// Boton con texto.
		btnEmpezar.setBackground(new Color(210, 210, 210));// Cambio de color en el fondo del boton.
		btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_btnEmpezar = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_btnEmpezar.gridx = 3;// Indicacion de la cordenada X.
		gbc_btnEmpezar.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(btnEmpezar, gbc_btnEmpezar);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

//		Label compuesto por html para poner en negrita partes en concretas del texto.
		lblReglas = new JLabel(
				"<html>Reglas:<br>- <b>Casilla en blanco:</b> no hay minas alrededor.<br>- <b>Casilla con numero:</b> el numero indica las minas que hay alrededor.<br>- <b>Bandera blanca:</b> con el bot\u00F3n derecho indicas que hay una mina.<br>- <b>Mina:</b> Perdiste la partida.</html>");
		lblReglas.setFont(new Font("Tahoma", Font.PLAIN, 15));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblReglas = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblReglas.gridwidth = 4;// Ocupar 4 celdas en lo ancho.
		gbc_lblReglas.gridx = 0;// Indicacion de la cordenada X.
		gbc_lblReglas.gridy = 2;// Indicacion de la cordenada Y.
		contentPane.add(lblReglas, gbc_lblReglas);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		lblError = new JLabel();// Inizializacion del Label sin texto.
		lblError.setForeground(new Color(165, 42, 42));// Color del texto.
		lblError.setFont(new Font("Tahoma", Font.BOLD, 18));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblError = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblError.anchor = GridBagConstraints.SOUTH;// Ponerlo en el sur de la celda.
		gbc_lblError.gridwidth = 4;// Ocupar 4 celdas en lo ancho.
		gbc_lblError.gridx = 0;// Indicacion de la cordenada X.
		gbc_lblError.gridy = 3;// Indicacion de la cordenada Y.
		contentPane.add(lblError, gbc_lblError);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		btnEmpezar.addActionListener(this);// Listener del boton btnEmpezar.

		tfNumero.addKeyListener(this);// Listener del TextField tfNumero.

		setVisible(true);// Hacer visible el JFrame.
	}

//	Metodos del listener ActionListener.
	@Override
	public void actionPerformed(ActionEvent e) {
		dimension = Integer.parseInt(Main.tfNumero.getText());// Pasar el numero escrito al Integer e
																			// introducirlo en la varible "dimension".
//		Si el numero introducido es mas pequenio de 3 o mas grande de 9 lanza un mensaje en el lblError.
		if (dimension < 3) {
			lblError.setText("La Dimensi\u00F3n m\u00EDnima es de 3.");// \u00F3 = "o" acentuada,
																		// \u00ED = "i" acentuada.
		} else if (dimension > 9) {
			lblError.setText("La Dimensi\u00F3n m\u00E1xima es de 9.");// \u00F3 = "o" acentuada,
																		// \u00E1 = "a" acentuada.
		} else {
			VentanaJuego.cambioDimension();// llamada al metodo cambioDimension de la clase VentanaJuego.
			dispose();// Se cierra el JFrame VentanaPrincipal.
			new VentanaJuego();// Se abre el nuevo JFrame llamando al constructor de la clase VentanaJuego.
		}
	}

//	Metodos del listener KeyListener. 
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();// Convierte la tecla presionada en un int (todas las teclas por defecto tienen
									// un numero asignado).

//		Comprobacion si la tecla presionada es el enter.
		if (key == KeyEvent.VK_ENTER) {
			dimension = Integer.parseInt(Main.tfNumero.getText());// Pasar el numero escrito al Integer e
																				// introducirlo en la varible
																				// "dimension".
//			Si el numero introducido es mas pequenio de 3 o mas grande de 9 lanza un mensaje en el lblError.
			if (dimension < 3) {
				lblError.setText("La Dimensi\u00F3n m\u00EDnima es de 3.");// \u00F3 = "o" acentuada,
																			// \u00ED = "i" acentuada.
			} else if (dimension > 9) {
				lblError.setText("La Dimensi\u00F3n m\u00E1xima es de 9.");// \u00F3 = "o" acentuada,
																			// \u00E1 = "a" acentuada.
			} else {
				VentanaJuego.cambioDimension();// llamada al metodo cambioDimension de la clase VentanaJuego.
				dispose();// Se cierra el JFrame VentanaPrincipal.
				new VentanaJuego();// Se abre el nuevo JFrame llamando al constructor de la clase VentanaJuego.
			}
		}
	}

//	Metodos keyReleased y keyTyped no se utilizan.
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

// Metodo main de la aplicacion Buscaminas.
	public static void main(String[] args) {
		new Main();
	}

}
