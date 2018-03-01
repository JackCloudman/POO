import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;
//javac  -cp .:MS3DLoader.jar:portfolio.jar Tamagochi.java
//java  -cp .:MS3DLoader.jar:portfolio.jar Tamagochi
public class Tamagochi extends JFrame  implements AccionInt , LeeRed {
static String preguntas []= { "COMO TE LLAMAS","DONDE VIVES"};
static String respuestas []= {"MI NOMBRE ES TAMAGOCHI","EN LA COMPU"};
private Canvas3D canvas3D;
private Appearance ap;
private static Texture texture;
private JPanel jp1;
private String nombres[]={"Stan2","Cartman2"};
private String etiqs[]={ "Stan","Cartman"};
private MicroChat microChat;
private Red r;
private Paleta pal;
private TransformGroup tgDesplazamiento=new TransformGroup();
Cartman body; 
SimpleUniverse universe;
BranchGroup group;
BranchGroup grupo;
public Tamagochi(){
   super("Tamagochi 3D");
   //setResizable(false); 
   setSize(400, 500);
   GraphicsConfiguration config =     
   SimpleUniverse.getPreferredConfiguration();
   canvas3D = new Canvas3D(config);
   canvas3D.setSize(300, 400);
   pal=new Paleta(etiqs,new GridLayout(1, etiqs.length),this); 
   add("North", pal); 
   add("Center",canvas3D);   
   setup3DGraphics();
   setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   setVisible(true);
   r=new Red(this);
   microChat = new MicroChat(r);
   add("South", microChat);
}
void setup3DGraphics(){
   DirectionalLight light1;
   universe = new SimpleUniverse(canvas3D);
   universe.getViewingPlatform().setNominalViewingTransform();
   cargarTexturas(this);
   tgDesplazamiento.addChild(new objetos3D.Suelo(Texturas.getObjeto().getApariencia("Suelo"),12, 12).getTransformGroup());
        tgDesplazamiento.addChild(new objetos3D.Techo(Texturas.getObjeto().getApariencia("Techo"), 12, 12).getTransformGroup());
   tgDesplazamiento.addChild((new objetos3D.Pared(Texturas.getObjeto().getApariencia("Pared"),
                                                            -1,0)).getTransformGroup());
    tgDesplazamiento.addChild((new objetos3D.Pared(Texturas.getObjeto().getApariencia("Pared"),
                                                            0,0)).getTransformGroup());
   group=new BranchGroup();  
   group.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
   group.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
   group.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
   group.setCapability(BranchGroup.ALLOW_DETACH);
   body= new Cartman( "Stan2.ms3d", 0f, 0f, 0f);
   grupo = escatrans1(
                         body.mybody(), new Vector3f(0.0f, -0.5f, 1.0f),
                       	new Vector3d(0.4f, 0.4f, 0.4f));
   group.addChild(grupo);
   group.addChild(tgDesplazamiento);
   Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
   BoundingSphere bounds =new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
   light1 = new DirectionalLight(light1Color, light1Direction);
   light1.setInfluencingBounds(bounds);
   group.addChild(light1);
   universe.addBranchGraph(group);
}
public static void main(String[] args) { new Tamagochi(); }
public void accion(int n){ 
     	r.escribeRed(new Icono("Tamagochi", n)); 
        grupo.detach();    
        body= new Cartman( nombres[n]+".ms3d", 0f, 0f, 0f);
        grupo = escatrans1(
                         body.mybody(), new Vector3f(0.0f, -0.5f, 1.0f),
                       	new Vector3d(0.4f, 0.4f, 0.4f));
        group.addChild(grupo);
}
public void leeRed(Object obj){
	if(obj instanceof Icono){      
        	Icono i=(Icono)obj;  
                System.out.println("Recibi "+nombres[i.getTurno()]); 	   	
	}
        if(obj instanceof Mensaje){ 
		System.out.println("Recibi "+(Mensaje)obj);
                microChat.recibir((Mensaje)obj);
	}
}
BranchGroup escatrans1(Node node, Vector3f vector, Vector3d escala) {
	Transform3D transform3D = new Transform3D();
	transform3D.setTranslation(vector);
        transform3D.setScale(escala);
	TransformGroup transformGroup =new TransformGroup();
	transformGroup.setTransform(transform3D); 
        transformGroup.addChild(node);
	BranchGroup branchGroup=new BranchGroup();	
	branchGroup.setCapability(BranchGroup.ALLOW_DETACH );
	branchGroup.addChild(transformGroup);
	return branchGroup;
}
public void cargarTexturas(java.awt.Component observer){
        Texturas.getObjeto().cargaTextura("pared1.jpg","Pared",observer);
        Texturas.getObjeto().cargaTextura("suelo1.jpg","Suelo",observer);
	Texturas.getObjeto().cargaTextura("puerta1.jpg","Puerta",observer);
        Texturas.getObjeto().cargaTextura("marco1.jpg","Marco",observer);
        Texturas.getObjeto().cargaTextura("techo1.jpg","Techo",observer);
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