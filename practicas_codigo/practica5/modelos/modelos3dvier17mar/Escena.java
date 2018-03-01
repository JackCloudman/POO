import com.sun.j3d.utils.picking.*;
//import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;
//import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//import org.jdesktop.j3d.loaders.vrml97.VrmlLoader;

//sudo javac -cp .:MS3DLoader.jar:portfolio.jar Escena.java
//sudo java -cp .:MS3DLoader.jar:portfolio.jar Escena
public class Escena {

private PickCanvas pickCanvas;
BranchGroup group;
private TransformGroup cartmanTransX;
//Frame frame;
public Escena(){
    JFrame jf = new JFrame("Planetario");
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas = new Canvas3D(config);
    canvas.setSize(600, 500);
    SimpleUniverse universe = new SimpleUniverse(canvas);

    Background fondo=new Background();
    fondo.setColor(1.0f,1.0f,1.0f);
    fondo.setApplicationBounds(getBoundingSphere()/*bounds*/);
   
    BranchGroup group = new BranchGroup();
    group.addChild(fondo);
    lightScene(group);
    universe.addBranchGraph(group);
    universe.getViewingPlatform().setNominalViewingTransform();
    
    Stan body=new Stan(-0.4f,0.0f,0.0f,"",true, jf, "Avatar1", null);
    //group= body.mybody();
    BranchGroup grupo2 = Posi.escatrans1(
                         body.mybody(), new Vector3f(0.0f, 0.0f, 1.0f),
                       	new Vector3d(0.1f, 0.1f, 0.1f));
    universe.addBranchGraph(grupo2);
    Body b=new Body(-0.8f,0.0f,0.0f,"",true, jf, "Avatar1");
    group= b.mybody();
    universe.addBranchGraph(group);
    BodyBob bb=new BodyBob(0.0f,0.0f,0.0f,"",true, jf, "bob-esponja.jpg");
    //BodyBob bb = new BodyBob(jf);
    group = bb.mybody();
    universe.addBranchGraph(group);
    BodyZoey bz=new BodyZoey(-0.4f,0.0f,0.0f,"",true, jf, "cabeza.png");
    group = bz.myBody();
    universe.addBranchGraph(group);
    Raton raton=new Raton();
    group=raton.getGroup();
    universe.addBranchGraph(group);
    Gato gato=new Gato();
    group=gato.getGroup();
    universe.addBranchGraph(group);
    //group=obtenCoche();

    group = Posi.escatrans1( 
      CarBuilder.getBody(), new Vector3f(0.5f, 0.0f, 0.0f),
      new Vector3d(0.2f, 0.2f, 0.2f));
    universe.addBranchGraph(group);
    //Jet jet=new Jet(false);
    Pez pez=new Pez(false);
    /*TransformGroup objSpin = jet.myBody();
    group = new BranchGroup();
    group.addChild(objSpin);*/
    grupo2 = Posi.translate1(
                        pez.myBody(), new Vector3f(-2.0f, 5.5f, 0.0f));
    /*grupo2 = Posi.escatrans1(
                        pez.myBody(), new Vector3f(-1.0f, -3.5f, 3.0f),
                       	new Vector3d(1.0f, 1.0f, 1.0f));*/
    universe.addBranchGraph(grupo2);
    Jet jet=new Jet(false);
    grupo2 = Posi.escatrans1(
                        jet.myBody(), new Vector3f(0.0f, 0.0f, 1.0f),
                       	new Vector3d(0.1f, 0.1f, 0.1f));
    universe.addBranchGraph(grupo2);
    Personaje cartman= new Personaje( "Cartman2.ms3d", 0f, 0f, 0f);
    grupo2 = Posi.escatrans1(
                         cartman.mybody(), new Vector3f(0.0f, 0.0f, 1.0f),
                       	new Vector3d(0.1f, 0.1f, 0.1f));

    //cartmanTransX = Posi.translate(grupo2, new Vector3f(0.2f, 0.0f, 0.3f)); 
    //group = new BranchGroup();
    //group.addChild(cartmanTransX);
    
    //universe.addBranchGraph(grupo2);
    pickCanvas = new PickCanvas(canvas, group);
    pickCanvas.setMode(PickCanvas.BOUNDS);
    
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
    jf.add(canvas); jf.setSize(1000, 700); jf.setVisible(true); 
}
private void lightScene(Group bg)
  // one directional light
  { Color3f white = new Color3f(1.0f, 1.0f, 1.0f);

    Vector3f lightDir = new Vector3f(1.0f, -1.0f, -0.8f); // upper left
    DirectionalLight light1 = 
            new DirectionalLight(white, lightDir);
    light1.setInfluencingBounds(getBoundingSphere()/*bounds*/);
    /*AmbientLight luz= new AmbientLight();
    luz.setInfluencingBounds(bounds);
    bg.addChild(luz);*/
    bg.addChild(light1);
  }  //
BoundingSphere getBoundingSphere( ){
		return new BoundingSphere( new Point3d( 0.0,0.0,0.0 ), 250.0 );
}
public static void main( String[] args ) { new Escena(); }
}
