/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
//import javax.swing.AbstractButton; no se que hace comentado de momento
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import agenda.usuario;
//para ir probando
//import javax.swing.Imageicon; //Más Tarde para poder poner iconos.
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.awt.*;//no se que hacen comentados de momento
/**
 *
 * @author SANTIAGO MARTINEZ MONTAÑO
 */
public class logFrame extends JInternalFrame{
    protected JButton entrarButton;
    protected JTextField usuarioText;
    protected JPasswordField passField;
    protected JLabel usuarioLabel;
    protected JLabel passLabel;
    public usuario user;
    
    static final int xOffset = 30, yOffset = 30;
    public logFrame(usuario miusuario){
        super("Entrada a la Agenda",false,false,false,false);
        setSize(300,300);
        //Set the window's location.
        setLocation(xOffset, yOffset);
        this.user=miusuario;
        entrarButton = new JButton ("Entrar");
        entrarButton.setActionCommand("Entrar");
        passLabel = new JLabel("Password:");
        usuarioLabel = new JLabel("Usuario:");
        usuarioText = new JTextField();
        passField = new JPasswordField();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					entrarActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        javax.swing.GroupLayout logFrameLayout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(logFrameLayout);
        logFrameLayout.setHorizontalGroup(
            logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logFrameLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioLabel)
                    .addComponent(passLabel))
                .addGap(18, 18, 18)
                .addGroup(logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuarioText)
                    .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addGroup(logFrameLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(entrarButton)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        logFrameLayout.setVerticalGroup(
            logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logFrameLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioLabel)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(logFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(entrarButton)
                .addGap(27, 27, 27))
        );
        pack();        
    }
    
    public void center(int x,int y){
        int width = (x - this.getWidth()) / 2;
        int height = (y - this.getHeight()) / 2;
        this.setLocation(width, height);
    }
    
    
    public void entrarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
      //JOptionPane.showMessageDialog(null,"A Pulsado Entrar");
      //conectaria con la base de datos
    	int usertext = Integer.parseInt(usuarioText.getText());
    	String passtext =  new String(passField.getPassword());
    	boolean res= this.user.ulogin(usertext, passtext);
    	if(res==true){
    		JOptionPane.showMessageDialog(null,"ha funcionado");
    	}
    	else{
    		JOptionPane.showMessageDialog(null,"ha debuggear");
    	}
    }
}
