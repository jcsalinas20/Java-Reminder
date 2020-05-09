// java Program to create a simple JDialog 
import java.awt.event.*; 
import javax.swing.*; 
public class Ejemplo_JDialog extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// frame 
    static JFrame f; 
  
    // main class 
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 
  
        // create a object 
        Ejemplo_JDialog s = new Ejemplo_JDialog(); 
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        JButton b = new JButton("click"); 
  
        // add actionlistener to button 
        b.addActionListener(s); 
  
        // add button to panel 
        p.add(b); 
  
        f.add(p); 
  
        // set the size of frame 
        f.setSize(400, 400); 
  
        f.show(); 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        if (s.equals("click")) { 
            // create a dialog Box 
            JDialog d = new JDialog(f, "dialog Box"); 
  
            // create a label 
            JLabel l = new JLabel("this is a dialog box"); 
  
            d.add(l); 
  
            // setsize of dialog 
            d.setSize(100, 100); 
  
            // set visibility of dialog 
            d.setVisible(true); 
        } 
    } 
} 