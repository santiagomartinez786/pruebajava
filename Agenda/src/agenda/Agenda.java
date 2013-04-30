/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.*;
import agenda.usuario;
/**
 *
 * @author SANTIAGO MARTINEZ MONTAÑO
 */
public class Agenda extends JFrame implements ActionListener{
    JDesktopPane desktop;

    public Agenda(){
    	super("Agenda");
    	usuario user = new usuario();
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane
        createFirstFrame(user); //create first "window"
        setContentPane(desktop);
        //setJMenuBar(createMenuBar());
        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }
   
    public void createFirstFrame(usuario user){
        logFrame ventanaLog = new logFrame(user);
        ventanaLog.setVisible(true); //necessary as of 1.3
        ventanaLog.center(this.getWidth(),this.getHeight());
        desktop.add(ventanaLog);
        try {
            ventanaLog.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    
    protected void quit() {
        System.exit(0);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("Entrar")==true){
    		JOptionPane.showMessageDialog(null,"A Pulsado Entrar");
    	}
    }
    
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        Agenda myframe = new Agenda();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        myframe.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
