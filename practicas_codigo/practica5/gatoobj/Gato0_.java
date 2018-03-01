import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.*;
public class Gato0 extends Panel implements ActionListener, Runnable, Serializable {	
Socket cliente;  
private ObjectInputStream oisNet;
private ObjectOutputStream oosNet;
Thread thread;
int puerto, turno;
Button botones[], conecta;
String signos[]={"X", "O"};
public Gato0(){
        Panel p1, p2;
	turno=0; puerto=5000;
	p1=new Panel();
        p2=new Panel();
	p1.setLayout(new GridLayout(3,3));
	p2.setLayout(new BorderLayout());
	botones=new Button[9];
	for(int i=0; i< botones.length ; i++){
		p1.add(botones[i]=new Button(""+i));
                botones[i].setEnabled(false);
		botones[i].addActionListener(this);
	}
        conecta=new Button("conecta");
	conecta.addActionListener(this);       
        p2.add(p1,BorderLayout.NORTH);
	p2.add(conecta,BorderLayout.SOUTH);
        add(p2);
}    
public static void main(String args[]){
	Frame f=new Frame("Gato");
	f.add("Center", new Gato());
        f.setSize(250, 250); f.setVisible(true);	
}       
public void run(){
	int j;
	Object c=null;
   	for(;;)
   	{
    		j=0;
                try {
                        c=oisNet.readObject();	
    		} catch ( IOException e) {
			System.out.println("IO ex"+e);
         		j=1;
                } catch (ClassNotFoundException ex) {
                     	System.out.println("Class no found"+ex);
			j=1;
		} 
    		if (j==0) {
                        Tirada t=(Tirada)c;
                        //System.out.println("prog=("+t.getPrograma()+")");
			if(t.getPrograma().equals("Gato")){
                        	int k=t.getPosicion(); 
                             	if(botones[k].isEnabled()){
					botones[k].setLabel(signos[turno]);
					botones[k].setEnabled(false);
					turno=1-turno;
			     	}
                         }
		}
	}
}
public void actionPerformed(ActionEvent e) {
	Button btn=(Button)e.getSource();
        if(btn==conecta){
           	conectar();
	} else {
        	Object c=null;
		btn.setLabel(signos[turno]);
		btn.setEnabled(false);
		turno=1-turno;              
		for(byte i=0;i<9;i++)
			if(botones[i]==btn){
				System.out.println("e i("+i+")");
				try {
                                	c=new Tirada("Gato","jug1",i); 
          				oosNet.writeObject(c);
     				} catch (IOException ex) {
          				ex.printStackTrace();
     				}
                	}
	}
}
void conectar(){
     for(int i=0; i< botones.length ; i++)
     	botones[i].setEnabled(true);
	int i=0;
   	while(i==0)
   	{
    		i=1;
    		System.out.println("Gato Esperando por el servidor . . .");
    		try {
			cliente=new Socket("localhost", puerto);

    		} catch ( IOException ioe) {
			System.out.println("Fallo creacion Socket"+ioe);
            		i=0;
   		}
   	}
   	System.out.println("Gato Connectado al servidor.");
   	try {
		oisNet = getOISNet(cliente.getInputStream());
            	oosNet = getOOSNet(cliente.getOutputStream()); 
   	} catch ( IOException ioe) {
         	System.out.println("ERROR(2)"+ioe);
   	}
        System.out.println("flujos obtenidos.");
        thread = new Thread (this);
   	thread.start ();
}
ObjectOutputStream getOOSNet(OutputStream os) throws IOException {
	return new ObjectOutputStream(os);
}
ObjectInputStream getOISNet(InputStream is) throws IOException {
	return new ObjectInputStream(is);
}
}
