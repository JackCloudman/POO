import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class IconAnim extends Canvas implements Serializable, Runnable {
        int frame;
	String nombres[]={"RIGHT1.GIF", "RIGHT2.GIF"};
        ImageIcon im[];
        private Point fPt;
	transient Thread hilo=null;
        Dimension offDimension;
        Image offImage;
        Graphics offGraphics;
        public IconAnim(){
                frame=0;
		fPt = new Point(100, 100);
                nombres = new String[2];
                im=new ImageIcon[2];
                im[0]=new ImageIcon(nombres[0]);
		im[1]=new ImageIcon(nombres[1]);
                setSize(200, 200);
                setBackground(Color.yellow);
	}
	/*public IconAnim(Point p1, String nombre){
		fPt = p1;
		this.nombre=nombre;
                im=new ImageIcon(nombre);
	}*/
        void pause(int time) {
    		try { Thread.sleep(time); }
    		catch (InterruptedException e) { }
        }
        public void run() {
		while (Thread.currentThread() == hilo) {
                //while (true) {
	    		// Display the next frame of animation.
	    		repaint();
	    		pause(250);
	    		frame++;
                        //setIcon(im[frame % 2]);
                        System.out.println("Corre "+frame);
		}
        }
    public void paint(Graphics g) {
	//update(g);
	Image img = im[frame % 2].getImage();
	if (img != null) {
	    g.drawImage(img, 100, 100, this);
	}
    }
	public void start(){    
		if(hilo==null)   
			hilo=new Thread(this);
		hilo.start();	
	}
	public void stop(){    
		if(hilo!=null){
			hilo.stop();	
			hilo=null;
		}
	}
}


