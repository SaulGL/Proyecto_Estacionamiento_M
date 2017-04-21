
package estacionamiento;

// <editor-fold defaultstate="collapsed" desc="Imports"> 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// </editor-fold>

public class Cliente extends JFrame implements ActionListener{

////////////////////////////////////////////////////////////////////////////////   
    
 // <editor-fold defaultstate="collapsed" desc="Inicializacion de componentes">    
    JLabel ehora;   //e= etiqueta
    JLabel enumero;
    JLabel efecha;
    JButton b_salida;
    
    JPanel centro; 
    JPanel este; 
    
    BorderLayout borde;
    GridLayout rcentro; //r= rejilla
    GridLayout reste;
    
    public int onum;
    //public String num2="";
// </editor-fold>
    
////////////////////////////////////////////////////////////////////////////////
    
// <editor-fold defaultstate="collapsed" desc="Funcion Init"> 
    void init(){
        
        //Imágenes
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/portada.jpg")); 
        JLabel fondo = new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
////////////////////////////////////////////////////////////////////////////////
        //Label
        ehora = new JLabel("Hora");    
        efecha = new JLabel("Fecha");
        enumero = new JLabel("");
        
        //Panel
        b_salida = new JButton("Aceptar");
        
        //Panel
        este = new JPanel();
        centro = new JPanel();
        
        //BorderLayout
        borde = new BorderLayout();
        setLayout(borde);
        
        //borde2 = new BorderLayout();// distribucion central
        
        
        //Rejillas
        reste = new GridLayout(3,1);
        este.setLayout(reste);
        
        rcentro = new GridLayout(2,1);
        centro.setLayout(rcentro);
        
////////////////////////////////////////////////////////////////////////////////

        este.add(ehora);
        este.add(efecha);
        este.add(enumero);
        
        centro.add(b_salida);
        
        add(este,BorderLayout.EAST);
        add(centro,BorderLayout.CENTER);
        
////////////////////////////////////////////////////////////////////////////////
       
    b_salida.addActionListener(this);
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
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
// </editor-fold>
////////////////////////////////////////////////////////////////////////////////
public void modonum(){  
    Inicio i1;
    i1 = new Inicio();
    i1.init(); 
    dispose();
    System.out.println(""+onum);
    i1.num=onum;
}        

 // <editor-fold defaultstate="collapsed" desc="Overrride">
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b_salida)==true){
            modonum();      
        }
    }    
// </editor-fold>
}    
