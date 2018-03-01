import com.sun.j3d.utils.picking.*;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.event.*;
import java.awt.*;


public class Gato {

BranchGroup group1;

public BranchGroup getGroup(){
      return group1;
}

public Gato(){

    group1 = new BranchGroup();
    Vector3f vectorRat = new Vector3f(0.0f, 0.0f, 0.0f);

    Transform3D transformRat = new Transform3D();

    transformRat.setTranslation(vectorRat);

    Vector3d escalaRat = new Vector3d(0.35f, 0.35f, 0.35f);
    //Vector3d escalaRat = new Vector3d(1.0f, 1.0f, 1.0f);
    transformRat.setScale(escalaRat);

    TransformGroup transformGroupRat = new TransformGroup(transformRat);
    transformGroupRat.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    transformGroupRat.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    BoundingSphere bounds = new BoundingSphere(new Point3d(),0.0);
    MouseRotate rotator=new MouseRotate(transformGroupRat);
    rotator.setSchedulingBounds(bounds);
    MouseTranslate t=new MouseTranslate(transformGroupRat);
    t.setSchedulingBounds(bounds);
    transformGroupRat.addChild(t);
    transformGroupRat.addChild(rotator); 


    BranchGroup group = new BranchGroup();

    Vector3f vector = new Vector3f(0.2f, 0.0f, 0.0f);

    Transform3D transform = new Transform3D();

    transform.setTranslation(vector);

    Vector3d escala = new Vector3d(1.0f, 1.0f, 1.2f);

    transform.setScale(escala);

    TransformGroup transformGroup = new TransformGroup(transform);
  

Material yellowSphMaterial1 = new Material();
yellowSphMaterial1.setDiffuseColor(1.0f, 0.0f, 1.0f);
Appearance yellowSphAppearance1 = new Appearance();
yellowSphAppearance1.setMaterial(yellowSphMaterial1);

Material yellowSphMaterial2 = new Material();
yellowSphMaterial2.setDiffuseColor(0.0f, 0.1f, 0.0f);
Appearance yellowSphAppearance2 = new Appearance();
yellowSphAppearance2.setMaterial(yellowSphMaterial2);

Material yellowSphMaterial = new Material();
yellowSphMaterial.setDiffuseColor(1.0f, 1.0f, 1.0f);
Appearance yellowSphAppearance = new Appearance();
yellowSphAppearance.setMaterial(yellowSphMaterial);
Sphere yellowSph = new Sphere(0.7f,
Primitive.GENERATE_NORMALS, 32,
yellowSphAppearance);
   
    transformGroup.addChild(yellowSph);


    group.addChild(transformGroup);


    Vector3f vector2 = new Vector3f(0.8f, 0.0f, 0.0f);

    Transform3D transform2 = new Transform3D();

    transform2.setTranslation(vector2);

    Vector3d escala2 = new Vector3d(1.0f, 1.0f, 1.0f);

    transform2.setScale(escala2);

    TransformGroup transformGroup2 = new TransformGroup(transform2);

    Sphere pata1 = new Sphere(0.35f,
Primitive.GENERATE_NORMALS, 32,
yellowSphAppearance);

    transformGroup2.addChild(pata1);

    group.addChild(transformGroup2);


Vector3f vector8 = new Vector3f(0.5f, -0.8f, -0.3f);
Transform3D transform8 = new Transform3D();
    //transform8.rotZ(Math.PI/1.5d);
    transform8.rotZ(0.0d);
    transform8.setTranslation(vector8);
    
    TransformGroup transformGroup8 = new TransformGroup(transform8);
    Cylinder bigo1 = new Cylinder(0.1f,0.6f ,
yellowSphAppearance2);

    transformGroup8.addChild(bigo1);

    group.addChild(transformGroup8);


Vector3f vector9 = new Vector3f(0.5f, -0.8f, 0.3f);
Transform3D transform9 = new Transform3D();
Transform3D transform9_1 = new Transform3D();

    //transform9.rotZ(Math.PI/3.0d);
   
    //transform9_1.setIdentity();
    //transform9_1.rotY(Math.PI*0.75);
    transform9.rotZ(0.0d);
    //transform9.mul(transform9_1);
    transform9.setTranslation(vector9);
    
    TransformGroup transformGroup9 = new TransformGroup(transform9);
    Cylinder bigo2 = new Cylinder(0.1f,0.6f ,
yellowSphAppearance);

    transformGroup9.addChild(bigo2);

    group.addChild(transformGroup9);
    
Vector3f vector10 = new Vector3f(-0.2f, -0.8f, -0.3f);
Transform3D transform10 = new Transform3D();
    //transform10.rotZ(Math.PI/3.0d);
    transform10.rotZ(0.0d);
    transform10.setTranslation(vector10);
    
    TransformGroup transformGroup10 = new TransformGroup(transform10);
    Cylinder bigo3 = new Cylinder(0.1f,0.6f ,
yellowSphAppearance1);

    transformGroup10.addChild(bigo3);

    group.addChild(transformGroup10);

Vector3f vector11 = new Vector3f(-0.2f, -0.8f, 0.3f);
Transform3D transform11 = new Transform3D();
    //transform11.rotZ(Math.PI/1.5d);
    transform11.rotZ(0.0d);
    transform11.setTranslation(vector11);
    
    TransformGroup transformGroup11 = new TransformGroup(transform11);
    Cylinder bigo4 = new Cylinder(0.1f,0.6f ,
yellowSphAppearance);

    transformGroup11.addChild(bigo4);

    group.addChild(transformGroup11);

    Vector3f vector12 = new Vector3f(0.9f, 0.37f, 0.2f);
    
    Transform3D transform12 = new Transform3D();

    transform12.setTranslation(vector12);
 
     Vector3d escala12 = new Vector3d(0.35f, 0.35f, 0.05f);

    transform12.setScale(escala12);
    TransformGroup transformGroup12 = new TransformGroup(transform12);

    Cone cono1= new Cone(0.1f, 0.4f, yellowSphAppearance);
    transformGroup12.addChild(cono1);

    group.addChild(transformGroup12);

Vector3f vector13 = new Vector3f(0.9f, 0.37f, -0.2f);
    
    Transform3D transform13 = new Transform3D();

    transform13.setTranslation(vector13);
 
     Vector3d escala13 = new Vector3d(0.35f, 0.35f, 0.05f);

    transform13.setScale(escala13);

    TransformGroup transformGroup13 = new TransformGroup(transform13);
    Cone cono2= new Cone(0.1f, 0.4f, yellowSphAppearance);

    transformGroup13.addChild(cono2);

    group.addChild(transformGroup13);  
    
    Vector3f vector14 = new Vector3f(-0.3f, 0.7f, 0.0f);

Transform3D transform14 = new Transform3D();
    //transform8.rotZ(Math.PI/1.5d);
    transform14.rotZ(0.0d);
    transform14.setTranslation(vector14);
    
    TransformGroup transformGroup14 = new TransformGroup(transform14);
    //Cone cono2= new Cone(0.1f, 0.4f, yellowSphAppearance);
    Cylinder cola = new Cylinder(0.1f,0.6f ,
yellowSphAppearance);

    transformGroup14.addChild(cola);

    group.addChild(transformGroup14);

Vector3f vector15 = new Vector3f(0.2f, 0.7f, 0.3f);

Transform3D transform15 = new Transform3D();
    //transform8.rotZ(Math.PI/1.5d);
    transform15.rotZ(0.0d);

    transform15.setTranslation(vector15);
    
    TransformGroup transformGroup15 = new TransformGroup(transform15);
    //Cone cono2= new Cone(0.1f, 0.4f, yellowSphAppearance);
    Cylinder cola1 = new Cylinder(0.1f, 0.6f ,yellowSphAppearance);

    transformGroup15.addChild(cola1);

    //group.addChild(transformGroup15);


    transformGroupRat.addChild(group);
    group1.addChild(transformGroupRat);
}

public static void main( String[] args ) {

    new Gato();

}


} // end of class Gato