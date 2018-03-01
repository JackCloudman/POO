import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class DibujaFig3 extends Applet implements LeeRed, ActionListener{
        JButton benvia;
        private JTextField t;
        private MuestraIcon mi;
        private Red r;
        private static int size=300;
public void init(){
        add(t=new JTextField(20));
        mi=new MuestraIcon("imagen recibida", new ImageIcon("fondo.jpg"));
	add(mi);
        r=new Red(this);
}
public static void main(String args[]){
	DibujaFig3 df=new DibujaFig3();
	df.init();
	df.start();
	JFrame f=new JFrame("Dibuja");  
	f.add("Center",df);  
        f.add("South", df.benvia=new JButton("envia"));         
        df.benvia.addActionListener(df); 
        f.setSize(400, 300);                 
	f.setVisible(true);
	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e) {
	JButton btn=(JButton)e.getSource();
	envia(t.getText());
}
void envia(String nombre){
        Imagen i; 	     
        i=new Imagen("Piolin", "", nombre);
        ImageIcon ic=(ImageIcon)i.getIcon(); 
	mi.setComent(i.getNick());
	mi.setImage(ic);
        r.escribeRed(i); 
}
public void leeRed(Object obj){
	System.out.println("recibi clase "+ obj.getClass().getName());
	if( obj instanceof Imagen){
		Imagen i=(Imagen)obj;
		ImageIcon ic=(ImageIcon)i.getIcon(); 
	        mi.setComent(i.getNick());
	        mi.setImage(ic);  
         }
}
}                                                                                    
