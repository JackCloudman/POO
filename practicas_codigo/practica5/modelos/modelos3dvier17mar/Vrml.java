import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import org.jdesktop.j3d.loaders.vrml97.VrmlLoader;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.behaviors.mouse.*;
public class Vrml {
    Scene scene = null; 
    static String naam_file;
    BranchGroup sceneGroup;
    public BranchGroup mybody(){
       return sceneGroup;
    }
    public Vrml(String avatar){
        VrmlLoader loader = new VrmlLoader();
        naam_file = avatar;      
        try { 
                scene = loader.load(naam_file + ".wrl"); 
        } catch (Exception e) {
              System.out.println("Exception loading file! from path:" + naam_file + ".wrl");
               System.exit(1);
        }
    // get the scene group from the loaded VRML scene
    sceneGroup = scene.getSceneGroup();
    sceneGroup.setCapability(BranchGroup.ALLOW_DETACH);
    sceneGroup.setCapability(BranchGroup.ALLOW_BOUNDS_READ);

    Color3f light1Color = new Color3f(1.8f, 1.8f, 0.1f);

    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);

    Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

    DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);

    light1.setInfluencingBounds(bounds);

    sceneGroup.addChild(light1);  
    /*MouseRotate rotator=new MouseRotate(tran);
    rotator.setSchedulingBounds(bounds);
    MouseTranslate t=new MouseTranslate(tran);
    t.setSchedulingBounds(bounds);
    tran.addChild(t);
    tran.addChild(rotator); */  
}

}