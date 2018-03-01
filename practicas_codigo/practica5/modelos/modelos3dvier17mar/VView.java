import java.awt.*;
import java.applet.Applet;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import org.jdesktop.j3d.loaders.vrml97.VrmlLoader;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.utils.geometry.*;

public class Vrml {
    Scene scene = null; // the VRML scene that we load
    static String naam_file;
   // public VView(String avatar)
    public void init()
    {
        VrmlLoader loader = new VrmlLoader();
        //String naam_file = "ratonsol";
        
        try { 
                scene = loader.load(naam_file + ".wrl"); 
        } catch (Exception e) {
                    System.out.println("Exception loading file! from path:" + naam_file + ".wrl");
                    System.exit(1);
        }

    // get the scene group from the loaded VRML scene
    BranchGroup sceneGroup = scene.getSceneGroup();
    sceneGroup.setCapability(BranchGroup.ALLOW_DETACH);
    sceneGroup.setCapability(BranchGroup.ALLOW_BOUNDS_READ);

    Color3f light1Color = new Color3f(1.8f, 1.8f, 0.1f);

BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);

light1.setInfluencingBounds(bounds);

    sceneGroup.addChild(light1);
    universe.addBranchGraph(sceneGroup);
    
    BoundingSphere sceneBounds = (BoundingSphere)sceneGroup.getBounds();
    //light1.setInfluencingBounds(sceneBounds);
    double radius = sceneBounds.getRadius();
    System.out.println("radio:(" + radius + ")");
    Point3d center = new Point3d();
    sceneBounds.getCenter(center);

    
    Vector3d temp = new Vector3d(center);
    temp.z += 1.4 * radius / Math.tan(view.getFieldOfView() / 2.0);
    
}

}
