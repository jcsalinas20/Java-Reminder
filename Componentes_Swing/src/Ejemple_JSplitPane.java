import javax.swing.*;

public class Ejemple_JSplitPane extends JFrame {
	private static final long serialVersionUID = 1L;

	// frame
	static JFrame f;

	// text areas
	static JTextArea t1, t2;

	// main class
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// create a new frame
		f = new JFrame("frame");

		// create a object
		new Ejemple_JSplitPane();

		// create a panel
		JPanel p1 = new JPanel();
		JPanel p = new JPanel();

		// create text areas
		t1 = new JTextArea(10, 10);
		t2 = new JTextArea(10, 10);

		// set texts
		t1.setText("this is first text area");
		t2.setText("this is second text area");

		// add text area to panel
		p1.add(t1);
		p.add(t2);

		// create a splitpane
		JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, p1, p);

		// set Orientation for slider
		sl.setOrientation(SwingConstants.VERTICAL);

		// add panel
		f.add(sl);

		// set the size of frame
		f.setSize(300, 300);

		f.show();
	}
}