import java.awt.*;

import javax.swing.*;

public class Ejemple_JToolBar {
public static void main(final String args[]) {
    JFrame frame = new JFrame("JToolBar Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JToolBar toolbar = new JToolBar();
    toolbar.setRollover(true);

    
    JButton button = new JButton("button");
    toolbar.add(button);
    toolbar.addSeparator();
    
    toolbar.add(new JButton("button 2"));
    
    toolbar.add(new JComboBox<String>(new String[]{"A","B","C"}));
    
    Container contentPane = frame.getContentPane();
    contentPane.add(toolbar, BorderLayout.NORTH);
    JTextArea textArea = new JTextArea();
    JScrollPane pane = new JScrollPane(textArea);
    contentPane.add(pane, BorderLayout.CENTER);
    frame.setSize(350, 150);
    frame.setVisible(true);
  }
}