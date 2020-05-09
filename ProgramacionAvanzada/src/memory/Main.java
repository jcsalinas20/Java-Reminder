package memory;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

/* Clase principal */
public class Main implements ActionListener {
	/* Declaraciones de todas las varibles y objetos */
	static JFrame frame;
	JPanel contentPane;// JPanel que envuelve todo el JFrame.
	JPanel panelBotones;// JPanel que envuelve solo los botones.
	static JButton btnReiniciar;// Boton para reiniciar el juego actual.
	JButton btnOtroJuego;// Boton para elegir otro de los 4 juegos.
	static JLabel lblTemporizador;// JLabel donde aparecera el cronometro y los intentos.
	JMenuBar menuBar;// Barra del menu.
	JMenu mnOtrosJuegos, mnOpciones;// Todos los menus que tiene el menu bar.
	JMenuItem mItemBuscaminas;// MenuItem que estara en el menu "mnOtrosJuegos".
	static JMenuItem mItemReiniciar;// MenuItem que estara en el menu "Opciones".
	JMenuItem mItemExit;// MenuItem que estara en el menu "Opciones".

//	 Declaracion de array para los botones.
	static JButton[] botones = new JButton[16];
	int contadorBotonesSeleccionados = 0;// Contador para controlar la seleccion de botones y que no pase de 2.
	int contadorIntentos = 0;// Contador para contar todos los intentos de la partida.
	int contadorParejasAcertadas = 0;// Contador para contar las parejas acertadas hasta 8.

//	Array para almacenar los numeros para la asignacion del enlace al boton.
	static int[] asignacionNumeroDeFoto = new int[16];

// Array para comparar si los 2 botones seleccionador tiene la misma foto.
	String[] compararURLs = new String[2];

//	Constructor de la clase
	public Main() {
		frame = new JFrame();// Inicializando el JFrame.
		frame.setResizable(false);// No se puede modificar el tamanio del JFrame.
		frame.setTitle("Memory");// Titulo de la aplicacion.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Terminar programa cuando se cierre.
		frame.setBounds(100, 100, 450, 450);// Size del JFrame.
		contentPane = new JPanel();// JPanel generico.
		GridBagLayout gbl_contentPane = new GridBagLayout();// Declaracion GridBagLayout.
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0 };// 1.0 significa rellenar la 3a fila con el hueco
																	// que queda a bajo del JFrame.
		gbl_contentPane.rowHeights = new int[] { 120, 240, 45 };// Cada posicion define los pixeles que ocupa cada fila.
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };// Este 1.0 de la 3a posicion rellena el
																			// hueco que queda a la derecha en el
																			// JFrame.
		gbl_contentPane.columnWidths = new int[] { 19, 180, 180, 19 };// Cada posicion define los pixeles de cada
																		// columna.
		contentPane.setLayout(gbl_contentPane);
		frame.setContentPane(contentPane);

//		Metodo para crear el menu.
		creacionMenu();

//		Asignacion del numero 9 en todas las posiciones.
		asignacionDelNumero9();

//		Bucle for para asignar numeros del 0-7 repetidos 2 veces. 
		for (int i = 0; i < asignacionNumeroDeFoto.length / 2; i++) {
			int contador = 0;
			while (contador < 2) {// Bucle while para repetir el numero 2 veces en posiciones aleatorias.
				int posicionEnArray = (int) (Math.random() * 16);
				// Si el numero de la posicion es 9 significa que no tiene numero asignado.
				if (asignacionNumeroDeFoto[posicionEnArray] == 9) {
					asignacionNumeroDeFoto[posicionEnArray] = i;
					contador++;
				}
			}
		}

		panelBotones = new JPanel(new GridLayout(4, 4));// Nuevo JPanel para introducir todos los botones.
//		Bucle for para crear los botones.
		for (int i = 0; i < asignacionNumeroDeFoto.length; i++) {
			ImageIcon img = iconoBotones(asignacionNumeroDeFoto[i]);// Asignacion numero con numero de imagen.
			botones[i] = new JButton(img);
			botones[i].setName("Boton " + i);
			botones[i].setBackground(new Color(210, 210, 210));
			panelBotones.add(botones[i]);
			botones[i].addActionListener(this);
		}

//		JLabel con el cronometro y numero de intentos.
		lblTemporizador = new JLabel("Tiempo restante: 6");
		lblTemporizador.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblTemporizador.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTemporizador_1 = new GridBagConstraints();
		gbc_lblTemporizador_1.gridwidth = 4;// Numero de casillas a ocupan en lo ancho.
		gbc_lblTemporizador_1.gridx = 0;// Posicionamiento en X.
		gbc_lblTemporizador_1.gridy = 0;// Posicionamiento en Y.
		contentPane.add(lblTemporizador, gbc_lblTemporizador_1);

//		JPanel de los botones.
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.gridwidth = 2;
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 1;
		contentPane.add(panelBotones, gbc_panelBotones);

//		Llamada al contructor de la clase Temporizador para comenzar la cuenta atras de 6 segundos.
		new Temporizador(6);

		frame.setVisible(true);// Hacer visible el JFrame.
	}

//	Metodo que crea el menu.
	private void creacionMenu() {
		menuBar = new JMenuBar();// Inizializacion del MenuBar.
		frame.setJMenuBar(menuBar);// MenuBar aniadido al frame, no al JPanel.

		mnOtrosJuegos = new JMenu("Otros Juegos");// Creacion de un Menu con la opcion Memory.
		menuBar.add(mnOtrosJuegos);
		mItemBuscaminas = new JMenuItem("Buscaminas");
		mnOtrosJuegos.add(mItemBuscaminas);

		mnOpciones = new JMenu("Opciones");// creacion de un Menu con ls opciones Reiniciar, Salir.
		menuBar.add(mnOpciones);
		mItemReiniciar = new JMenuItem("Reiniciar");
		mItemReiniciar.setEnabled(false);// Hasta que no acabe la cuenta atras no se habilita.
		mnOpciones.add(mItemReiniciar);
		mItemExit = new JMenuItem("Salir");
		mnOpciones.add(mItemExit);

		mItemBuscaminas.addActionListener(this);// Listener del item Buscaminas.
		mItemReiniciar.addActionListener(this);// Listener del item Reiniciar.
		mItemExit.addActionListener(this);// Listener del item Exit.
	}

//	El nueve significa que no hay ninguna asignacion ya que los numeros de las fotos van de 1-8.
	private void asignacionDelNumero9() {
		for (int i = 0; i < asignacionNumeroDeFoto.length; i++) {
			asignacionNumeroDeFoto[i] = 9;
		}
	}

//	Metodo para coger la url con el numero que corresponde.
	private ImageIcon iconoBotones(int numFoto) {
		ImageIcon img = null;
		if (numFoto == 0) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\1.png").getImage();
//			APLICO LA URL EN LA DESCRIPCION PARA DESPUES PODER COMPARALA ENTRE LAS OTRAS.
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\1.png");
		} else if (numFoto == 1) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\2.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\2.png");
		} else if (numFoto == 2) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\3.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\3.png");
		} else if (numFoto == 3) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\4.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\4.png");
		} else if (numFoto == 4) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\5.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\5.png");
		} else if (numFoto == 5) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\6.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\6.png");
		} else if (numFoto == 6) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\7.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\7.png");
		} else if (numFoto == 7) {
			Image url = new ImageIcon(System.getProperty("user.dir") + "\\imagesMemory\\8.png").getImage();
			img = new ImageIcon(url.getScaledInstance(50, 50, Image.SCALE_SMOOTH),
					System.getProperty("user.dir") + "\\imagesMemory\\8.png");
		}
		return img;
	}

//	Quitar la imagen de los botones una vez acabe el tiempo.
	public static void ocultarImagenes() {
		for (int i = 0; i < botones.length; i++) {
			botones[i].setIcon(new ImageIcon());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mItemExit) {
			System.exit(0);// Esto cierra el programa y lo termina.
		} else if (e.getSource() == mItemReiniciar) {// Reiniciar el juego.
			frame.dispose();// Se cierra la ventana...
			new Main();// y se vuelve a abrir.
		} else if (e.getSource() == mItemBuscaminas) {// Elegir otro juego.
			frame.dispose();// Se cierra la ventana...
			new buscaminas.Main();// y se abre la ventana de los juegos.
		} else {
			if (contadorBotonesSeleccionados >= 2) {// Si el contadorBotonesSeleccionados es mas grande de 2...
				ocultarImagenes();// Se ocultan todas las imagenes,
				contadorBotonesSeleccionados = 0;// Se reinicia el contadorBotonesSeleccionados,
				contadorParejasAcertadas = 0;// Se reinicia el contadorParejasAcertadas,
				contadorIntentos++;// Se suma un intento y
				lblTemporizador.setText("Intentos: " + contadorIntentos);// Se recarga el JLabel con el numero de
																			// intentos.
			}
			String[] numeroDeBoton = ((JComponent) e.getSource()).getName().split(" ");
			int i = Integer.parseInt(numeroDeBoton[1]);
//			Estructura IF para encontrar el boton seleccionado.
			ImageIcon img = iconoBotones(asignacionNumeroDeFoto[i]);// Buscar la imagen,
			botones[i].setIcon(img);// La aplica al boton otra vez,
			compararURLs[contadorBotonesSeleccionados] = img.getDescription();// Coge la descripcion de la imagen
																				// para poder comparala con la otra
																				// y
			contadorBotonesSeleccionados++;// Suma 1 al contadorBotonesSeleccionados.

//			Este IF es igual que el primero(linea 203) pero compara las 2 URLs de los 2 botones seleccionados 
//			y no oculta las imagenes de los botones.
			if (contadorBotonesSeleccionados == 2 && compararURLs[0].equals(compararURLs[1])) {
				contadorBotonesSeleccionados = 0;
				contadorIntentos++;
				contadorParejasAcertadas++;
				lblTemporizador.setText("Intentos: " + contadorIntentos);
			}
//			Si contadorParejasAcertadas es igual a 8 significa que se han acertado todas.
			if (contadorParejasAcertadas == 8) {
//				Ahora se abrira una ventana nueva y...
				new JuegoTerminado(contadorIntentos);
			}
		}
	}

//	Metodo Main de la aplicacion Memory.
	public static void main(String[] args) {
		new Main();// Llamada al contructor
	}

}
