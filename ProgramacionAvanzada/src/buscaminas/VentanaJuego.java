package buscaminas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class VentanaJuego implements ActionListener, MouseListener {
	static int DIMENSION;// Varible con el numero introducido en el TextField de VentanaPrincipal.
	static JFrame frame;// Declaracion de JFrame;
	JPanel contentPane;// JPanel que envuelve todo el JFrme.
	JPanel panelBotones;// Panel que envuelve todos los botones
	JButton[][] btnMina = new JButton[DIMENSION][DIMENSION];// Matriz con las dimensiones que se han pasado del
															// TextField anterior para guardar todos los botones.
	boolean[][] localizacionMinas = new boolean[DIMENSION][DIMENSION];// Matriz con las dimensiones que se han pasado
																		// del TextField anterior para guardar la
																		// posicion donde van ha haber minas.
	int contadorNingunaMinaEncontrada;// Cuenta todos los botones seleccionados sin haber ninguna mina dentro hasta
										// llegar al maximo o hasta encontrar una mina.
	int contadorDeBanderas;// Cuenta todas las banderas que vas colocando en los botones.
	JLabel lblBanderas;// label para mostrar las banderas contadas.
	JMenuBar menuBar;// Barra del menu
	JMenu mnOtrosJuegos, mnOpciones;// Todos los menus que tiene el menu bar.
	JMenuItem mItemMemory, mItemReiniciar, mItemExit;// MenuItem que estara en el menu "mnOtrosJuegos".

//	Constructor de la clase.
	public VentanaJuego() {
		frame = new JFrame();// Inizializacion del JFrame.
		frame.setTitle("Buscaminas");// Titulo del JFrame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Terminar el programa cuando se cierre la ventana.
		frame.setBounds(100, 100, (80 + (DIMENSION * 70)), (140 + (DIMENSION * 70)));
		contentPane = new JPanel();// Inizializacion del JPanel general.
		frame.setContentPane(contentPane);// Aniadir el JPanel con el JFrame.
		GridBagLayout gbl_contentPane = new GridBagLayout();// Declaracion del GridBagLayout.
//		Las dimensiones van a partir del numero de la dimension * 35 si es columna o * 60 si es una fila.(Ejemplo columna: si la dimension es 6 (35*6=210), resultado final = {0, 210, 210, 0} ).
		gbl_contentPane.columnWidths = new int[] { 0, 35 * DIMENSION, 35 * DIMENSION, 0 };// Dimensiones de cada
																							// columna.
		gbl_contentPane.rowHeights = new int[] { 70, 0, 60 * DIMENSION, 50 };// Dimensiones de cada fila.
		contentPane.setLayout(gbl_contentPane);// Meter el nuevo Layout al JPanel

//		Metodo para crear un menu.
		creacionMenu();

		JLabel lblBuscaminas = new JLabel("Buscaminas");// Label con el titulo.
		lblBuscaminas.setFont(new Font("Tahoma", Font.BOLD, 25));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblBuscaminas = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblBuscaminas.gridwidth = 2;// Ocupar 2 celdas en lo ancho.
		gbc_lblBuscaminas.gridx = 1;// Indicacion de la cordenada X.
		gbc_lblBuscaminas.gridy = 0;// Indicacion de la cordenada Y.
		contentPane.add(lblBuscaminas, gbc_lblBuscaminas);// Aniadir al JPanel el JLabel junto con el
															// GridBagConstraints.

		JLabel lblMinas = new JLabel("Minas: " + ((DIMENSION * DIMENSION) / 4));// Label que te dice las minas que
																				// hay.(Es la cuarta parte del numero de
																				// la dimension al cuadrado).
		lblMinas.setFont(new Font("Tahoma", Font.PLAIN, 16));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblMinas = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblMinas.gridx = 1;// Indicacion de la cordenada X.
		gbc_lblMinas.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(lblMinas, gbc_lblMinas);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		lblBanderas = new JLabel("Banderas: 0");// Label que te muestra las banderas que tienes colocadas.
		lblBanderas.setFont(new Font("Tahoma", Font.PLAIN, 16));// Definiendo nuevo tipo de letra, estilo y tamanio.
		GridBagConstraints gbc_lblBanderas = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_lblBanderas.gridx = 2;// Indicacion de la cordenada X.
		gbc_lblBanderas.gridy = 1;// Indicacion de la cordenada Y.
		contentPane.add(lblBanderas, gbc_lblBanderas);// Aniadir al JPanel el JLabel junto con el GridBagConstraints.

		panelBotones = new JPanel();// Inizializacion del JPanel que envuelve a todos los botones.
		panelBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));// Creacion de una linea negra alrededor
																				// del JPanel con un ancho de 4.
		GridBagConstraints gbc_panel = new GridBagConstraints();// Declaracion del GridBagConstraints.
		gbc_panel.gridwidth = 2;// Ocupar 2 celdas en lo ancho.
		gbc_panel.fill = GridBagConstraints.BOTH;// Rellena toda su celda en la direccion horizontal y vertical.
		gbc_panel.gridx = 1;// Indicacion de la cordenada X.
		gbc_panel.gridy = 2;// Indicacion de la cordenada Y.
		contentPane.add(panelBotones, gbc_panel);// Aniadir al JPanel el Jpanel junto con el GridBagConstraints.
		panelBotones.setLayout(new GridLayout(DIMENSION, DIMENSION));// Aniadimos el nuevo GridLayout con el numero de
																		// la dimension.

//		Esta llamada al constructor GradiantButtons es para cambiar el color a los botones pero poniendoles un degradado.
		new BotonesDegradados();

//		Doble for para rellenar la matriz de btnMina.
		for (int i = 0; i < btnMina.length; i++) {
			for (int j = 0; j < btnMina.length; j++) {
				btnMina[i][j] = new JButton("");// Inizializacion del boton sin texto.
				btnMina[i][j].setName(i + "," + j);// Nombre del boton indicando la posicion "i" y "j".
				btnMina[i][j].setBorder(BorderFactory.createLineBorder(Color.white, 2));// Creacion de una linea blanca
																						// alrededor de cada boton con
																						// un tamanio de 2.
				panelBotones.add(btnMina[i][j]);// Aniadimos el boton al JPanel de botones.
				btnMina[i][j].addActionListener(this);// Listener de botones.
				btnMina[i][j].addMouseListener(this);// Listener de raton.
			}
		}

//		For para colocar la mina en una posicion aleatoria (las minas solo ocuparan una cuarta parte de todos los botones).
		for (int i = 0; i < ((DIMENSION * DIMENSION) / 4); i++) {
			int numColumna = (int) (Math.random() * DIMENSION);// Numero aleatorio para la columna.
			int numFila = (int) (Math.random() * DIMENSION);// Numero aleatorio para la fila.
			if (localizacionMinas[numFila][numColumna] == false) {// Comprobacion si en esa posicion no hay ninguna
																	// mina.
				localizacionMinas[numFila][numColumna] = true;// El true indica que en esa posicion hay una mina.
			} else {
				i--;// Si en la posicion ya hay una mina se le resta 1 al for para que no cuente.
			}
		}

		frame.setVisible(true);// Hacer visible el JFrame.
	}

//	Metodo que crea el menu
	private void creacionMenu() {
		menuBar = new JMenuBar();// Inizializacion del MenuBar.
		frame.setJMenuBar(menuBar);// MenuBar aniadido al frame, no al JPanel.

		mnOtrosJuegos = new JMenu("Otros Juegos");// Creacion de un Menu con la opcion Memory.
		menuBar.add(mnOtrosJuegos);
		mItemMemory = new JMenuItem("Memory");
		mnOtrosJuegos.add(mItemMemory);

		mnOpciones = new JMenu("Opciones");// creacion de un Menu con ls opciones Reiniciar, Salir.
		menuBar.add(mnOpciones);
		mItemReiniciar = new JMenuItem("Reiniciar");
		mnOpciones.add(mItemReiniciar);
		mItemExit = new JMenuItem("Salir");
		mnOpciones.add(mItemExit);

		mItemMemory.addActionListener(this);// Listener del item Memory.
		mItemReiniciar.addActionListener(this);// Listener del item Reiniciar.
		mItemExit.addActionListener(this);// Listener del item Exit.
	}

//	Este metodo te comprueba si cundo le das a un boton y no hay una mina te calcula cuantas minas tiene alrededor.
	private int comprobarSiHayMinasAlrededor(int i, int j) {// Le pasamos "i" y "j" para saber la posicion central.
		int contadorMinasAlrededor = 0;// Contador que calcula cuantas minas tiene alrededor.
		try {
			if (localizacionMinas[i - 1][j - 1] == true) {// Posicion arriba izquierda.
				contadorMinasAlrededor++;// Contamos 1 si hay una mina.
			}
		} catch (ArrayIndexOutOfBoundsException e) {// Si no exitse esa posicion salta un error pero con el catch no se
													// para el programa.
		}
		try {
			if (localizacionMinas[i - 1][j] == true) {// Posicion arriba centro.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (localizacionMinas[i - 1][j + 1] == true) {// Posicion arriba derecha.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (localizacionMinas[i][j - 1] == true) {// Posicion centro izquierda.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (localizacionMinas[i][j + 1] == true) {// Posicion centro derecha.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (localizacionMinas[i + 1][j - 1] == true) {// Posicion abajo izquierda.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (localizacionMinas[i + 1][j] == true) {// Posicion abajo centro.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			if (localizacionMinas[i + 1][j + 1] == true) {// Posicion abajo derecha.
				contadorMinasAlrededor++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return contadorMinasAlrededor;// Retornamos el numero que nos haya dado.
	}

//	Metodo para coger el numero de dimension de la clase Main y la varible dimension para ponerlo en la varible DIMENSION de esta clase.
	public static void cambioDimension() {
		DIMENSION = Main.dimension;
	}

//	Metodo actionPerformed del listener ActionListener.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mItemReiniciar) {// Comprueba que el boton pulsado es el item del menu Reiniciar.
			frame.setEnabled(false);// Deshabita el JFrame central donde esta el juego.
			new VentanaReiniciar();// Abre una ventana para poder reiniciar la partida.
		} else if (e.getSource() == mItemExit) {// Comprueba que el boton pulsado es el item del menu Exit.
			System.exit(0);// Esto cierra el programa y lo termina.
		} else if (e.getSource() == mItemMemory) {// Comprueba que el boton pulsado es el item del menu Memory.
			frame.dispose();// Cierra la ventana actual.
			new memory.Main();// Abre el Main del paquete memory.
		} else {// Si no es ninguno de los anteriores es uno del panelBotones.
			String[] numeroDeBoton = ((JComponent) e.getSource()).getName().split(",");// Split para sacar la posicion
																						// del numero gracias al Nombre
																						// del boton.
			int i = Integer.parseInt(numeroDeBoton[0]);// Creacion de la variable i y conversion de String a Integer de
														// la posicion 0.
			int j = Integer.parseInt(numeroDeBoton[1]);// Creacion de la variable j y conversion de String a Integer de
														// la posicion 1.
			boolean esUnaMina = localizacionMinas[i][j];// Guardamos en un booleano si en la posicion pulsada habia una
														// mina o no.
			btnMina[i][j].setIcon(null);// Ponemos el null por si habia una imagen de la bandera anteriormente.
			if (esUnaMina) {// Si es true
				Image url = new ImageIcon("imagesBuscaminas\\mina.png").getImage();// Creacion de la url con el objeto
																					// Image.
				ImageIcon img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH));// Creacion del
																									// ImageIcon para
																									// ponerle unas
																									// medidas exactas.
				btnMina[i][j].setIcon(img);// Aniadimos el ImageIcon al boton.
				btnMina[i][j].setBackground(new Color(255, 79, 65));// Cambio de color de fondo.
				new JuegoTerminado("perdida");// Llamamos al constructor de la clase JuegoTerminado con un string para
												// saber si hemos ganado o perdido.
//				En este else if comprueba que el boton no se haya pulsado en ningun momento por el color del boton (el numero del color 238 es el color gris fuerte).
			} else if (btnMina[i][j].getBackground().equals(new Color(238, 238, 238))) {
				btnMina[i][j].setBackground(new Color(220, 220, 220));// Cambiamos el color del background.
				int contadorMinasAlrededor = comprobarSiHayMinasAlrededor(i, j);// Llamamos al metodo para comprobar si
																				// hay alguna mina en el alrededor y nos
																				// devuelve un numero.
				if (contadorMinasAlrededor != 0) {// Si el numero que hemos obtenido es lo contrario a 0 escribimos el
													// numero en el boton si es un 0 no escribimos nada.
					btnMina[i][j].setText("" + contadorMinasAlrededor);
					btnMina[i][j].setFont(new Font("Arial", Font.BOLD, 25));// Definiendo nuevo tipo de letra, estilo y
																			// tamanio.
				}
				contadorNingunaMinaEncontrada++;// Sumamos 1 por cada vez que entremos aqui.
//				Comprobamos si el contador es igual a la tercera parte de DIMENSION * DIMENSION.
				if (contadorNingunaMinaEncontrada == ((DIMENSION * DIMENSION) - ((DIMENSION * DIMENSION) / 4))) {
					new JuegoTerminado("ganada");// Llamamos al constructor de la clase JuegoTerminado con un string para saber si hemos ganado o perdido.
				}
			}
		}
	}

//	Metodo mouseClicked de MouseListener.
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {// Esto comprueba el se haya presionado el boton de la deracha del raton.
			String[] numeroDeBoton = ((JComponent) e.getSource()).getName().split(",");// Split para sacar la posicion
																						// del numero gracias al Nombre
																						// del boton.
			int i = Integer.parseInt(numeroDeBoton[0]);// Creacion de la variable i y conversion de String a Integer de
														// la posicion 0.
			int j = Integer.parseInt(numeroDeBoton[1]);// Creacion de la variable j y conversion de String a Integer de
														// la posicion 1.
//			Comprueba que el boton no se haya pulsado en ningun momento por el color del boton (el numero del color 238 es el color gris fuerte).
			if (btnMina[i][j].getBackground().equals(new Color(238, 238, 238))) {
				Image url = new ImageIcon("imagesBuscaminas\\bandera.png").getImage();// Creacion de la url con el
																						// objeto Image.
				ImageIcon img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH));// Creacion del
																									// ImageIcon para
																									// ponerle unas
																									// medidas exactas.
				btnMina[i][j].setIcon(img);// Aniadimos el ImageIcon al boton.
				contadorDeBanderas++;// Se suma uno al contador de banderas.
				lblBanderas.setText("Banderas: " + contadorDeBanderas);// Se actualiza el Label de las banderas.
			}
		}
	}

//	Metodos de listeners que no se utilizan.
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}