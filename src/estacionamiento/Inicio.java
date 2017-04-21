
package estacionamiento;

// <editor-fold defaultstate="collapsed" desc="Imports"> 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// </editor-fold>

public class Inicio extends JFrame implements ActionListener{
    
////////////////////////////////////////////////////////////////////////////////  
    
// <editor-fold defaultstate="collapsed" desc="Inicializacion de Elementos"> 
    
    JLabel bienvenido, espacio,espacio1,espacio2,espacio3;
    JButton b_entrada;
    GridLayout Primera;
    
    public int num;
// </editor-fold>

////////////////////////////////////////////////////////////////////////////////  
    
// <editor-fold defaultstate="collapsed" desc="Funcion init()"> 
    void init(){

        //Imágenes
//        ((JPanel)getContentPane()).setOpaque(false); 
//        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/portada.jpg")); 
//        JLabel fondo = new JLabel(); 
//        fondo.setIcon(uno); 
//        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
//        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
////////////////////////////////////////////////////////////////////////////////
       //Label
       bienvenido = new JLabel("Bienvenido",new ImageIcon("welcome.png"),JLabel.CENTER);
       Font auxFont=bienvenido.getFont();
       bienvenido.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
       espacio = new JLabel();
       espacio1 = new JLabel();
       espacio2 = new JLabel();
       espacio3 = new JLabel();
       espacio.setEnabled(false);
       espacio1.setEnabled(false);
       espacio2.setEnabled(false);
       espacio3.setEnabled(false);
       //Boton
       b_entrada = new JButton("Entrada",new ImageIcon("next.png"));
       b_entrada.setCursor(new Cursor(Cursor.HAND_CURSOR));
       b_entrada.setToolTipText("Entrada al Cliente");
       Font auxFont2=b_entrada.getFont();
       b_entrada.setFont(new Font(auxFont2.getFontName(), auxFont2.getStyle(),30));
       //Rejillas
       Primera = new GridLayout(3,2,5,5);
       setLayout(Primera);
       add(espacio);
       add(espacio1);
       add(bienvenido);
       add(b_entrada);
       add(espacio2);
       add(espacio3);
////////////////////////////////////////////////////////////////////////////////
         
       b_entrada.addActionListener(this);
////////////////////////////////////////////////////////////////////////////////

        try {
            UIManager.setLookAndFeel(
                    //            "javax.swing.plaf.metal.MetalLookAndFeel");
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel");//posibles
            //"com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//posibles
            //"com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("No se ha podido configura el look and feel" + e);
            e.printStackTrace();
        }
        
        setTitle("Estacionamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(700,400);
    }
// </editor-fold>

////////////////////////////////////////////////////////////////////////////////
public void modnum(){  
    Cliente c1;
    c1 = new Cliente();
    c1.init(); 
    dispose();     
    this.num=num+1;
    if(c1.onum==0){
        c1.onum=num;
        c1.enumero.setText(""+num);
    }
    else{
        num=c1.onum+1;
        c1.enumero.setText(""+num);
    }
}     
        
// <editor-fold defaultstate="collapsed" desc="Overrride">
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b_entrada)==true){ 
           modnum();
        }
    }
// </editor-fold>
    
    
}
