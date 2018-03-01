import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;
public class Tamagochi extends JFrame  implements LeeRed {
static String preguntas []= { "COMO TE LLAMAS","DONDE VIVES"};
static String respuestas []= {"MI NOMBRE ES TAMAGOCHI","EN LA COMPU"};
private Canvas3D canvas3D;
private Appearance ap;
private static Texture texture;
private JPanel jp;
private JButton bcambia;
private EventHandler eh; 
private String nombres[]={"carafeliz.jpg","caraenfermo.jpg"};
private int turno;
private Body body;
private Red r;
public Tamagochi(){
   super("Tamagochi 3D");
   turno=0;
   setResizable(false); setSize(450, 300);
   GraphicsConfiguration config =     
   SimpleUniverse.getPreferredConfiguration();
   canvas3D = new Canvas3D(config);
   eh = new EventHandler();  
   bcambia=new JButton("Cambiar");
   bcambia.addActionListener(eh);
   jp=new JPanel();
   jp.add(bcambia);
   add("North", jp); add("Center",canvas3D);
   setup3DGraphics();
   setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   setVisible(true);
   r=new Red(this);
}
void setup3DGraphics(){
   DirectionalLight light1;
   SimpleUniverse universe = new SimpleUniverse(canvas3D);
   universe.getViewingPlatform().setNominalViewingTransform();
   body=new Body(-0.4f,0.0f,0.0f,"",true, this, "Avatar1");
   body.changeTextureCab(texture, "carafeliz.jpg");
   BranchGroup group= body.mybody();
   Color3f light1Color = new Color3f(1.0f, 1.0f, 0.0f);
   BoundingSphere bounds =new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
   light1 = new DirectionalLight(light1Color, light1Direction);
   light1.setInfluencingBounds(bounds);
   group.addChild(light1);
   universe.addBranchGraph(group);
}
public static void main(String[] args) { new Tamagochi(); }
class EventHandler implements ActionListener {  
  public void actionPerformed(ActionEvent e) {  
     JButton btn=(JButton)e.getSource();
     if(btn==bcambia){ turno=1-turno; }
     body.changeTextureCab(texture, nombres[turno]);
     r.escribeRed(new Icono("Tamagochi", turno));   
  }
}
public void leeRed(Object obj){
	if(obj instanceof Icono){      
        	Icono i=(Icono)obj;  
                if(i.getPrograma().equals("Tamagochi")){
                	System.out.println("Recibi"+nombres[i.getTurno()]);
                        body.changeTextureCab(texture, nombres[i.getTurno()]);                   
		}	
	}
}
static String findMatch(String str) {
		String result = "";
		for(int i = 0; i < preguntas.length; ++i) {
			if(preguntas[i].equalsIgnoreCase(str)) {
				result = respuestas[i];
				break;
			}
		} 
		return result;
}
}
