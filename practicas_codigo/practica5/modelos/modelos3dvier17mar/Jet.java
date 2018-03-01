
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.mouse.*;

public class Jet {
   float coorde []={ 0.0f, 0.0f, 0.0f ,                                //Center
         0.0f, -1.7f, 0.9f ,  0.0f, -1.3f, 0.9f ,      //Tail1
         0.0f, -1.45f, 0.3f ,  0.0f, -0.8f, 0.3f ,//4
         0.0f, -1.45f, 0.2f ,  0.0f, -0.5f, 0.2f ,       
 //{ -0.50, -16.00, 1.00 }, { -1.00, -16.00, 0.00 },
         -0.05f, -1.6f, 0.1f ,  -0.1f, -1.6f, 0.0f ,   //Exhaust
//{ -0.50, -16.00, -0.50 }, { 0.00, -16.00, -1.00 },
         -0.05f, -1.6f, -0.05f ,  0.0f, -1.6f, -0.1f ,//10
//{ 0.50, -16.00, -0.50 }, { 1.00, -16.00, 0.00},
         0.05f, -1.6f, -0.05f ,  0.1f, -1.6f, 0.0f,
//{ 0.50, -16.00, 1.00 },
         0.05f, -1.6f, 0.1f ,
 //{ -1.00, -13.00, 2.00 }, { -2.00, -13.00, 0.00 }
         -0.1f, -1.3f, 0.2f ,  -0.2f, -1.3f, 0.0f ,   //Fuse 14, 42
         0.15f, -1.3f, 0.15f ,  0.0f, -1.3f, -0.2f ,
         0.15f, -1.3f, 0.15f ,  0.2f, -1.3f, 0.0f , //19
         0.1f, -1.3f, 0.2f ,  -0.1f, 0.7f, 0.2f ,
         -0.2f, 0.7f, 0.0f ,  0.15f, 0.7f, 0.15f ,
         0.0f, 0.7f, -0.2f ,  0.15f, 0.7f, 0.15f ,
         0.2f, 0.7f, 0.0f ,  0.1f, 0.7f, 0.2f ,//27
         0.2f, -0.8f, 0.0f ,  1.1f, -0.8f, 0.0f , //Wings
         1.1f,-0.5f,0.0f ,  0.5f, 0.0f, 0.0f ,
         0.2f, 0.7f, 0.0f ,  -0.2f, -0.8f, 0.0f ,
         -1.1f, -0.8f, 0.0f ,  -1.1f, -0.5f, 0.0f ,
         -0.5f, 0.0f, 0.0f ,  -0.2f, 0.7f, 0.0f ,
         0.05f, 0.2f, 0.2f ,  -0.05f, 0.2f, 0.2f ,        //Cockpit
         0.1f, 0.5f, 0.2f ,  0.05f, 0.5f, 0.35f ,
         -0.05f, 0.5f, 0.35f ,  -0.1f, 0.5f, 0.2f ,
         0.1f, 0.8f, 0.2f ,  0.05f, 0.8f, 0.35f ,
         -0.05f, 0.8f, 0.35f ,  -0.1f, 0.8f, 0.2f ,
         0.05f, 1.1f, 0.2f ,  -0.05f, 1.1f, 0.2f ,
         0.0f, 0.7f, -0.1f ,  -0.1f, 1.1f, 0.2f ,      //Subfuse
         -0.2f, 1.1f, 0.0f ,  0.0f, 1.1f, -0.1f ,
         0.2f, 1.1f, 0.0f ,  0.1f, 1.1f, 0.2f ,
         0.0f, 1.1f, -0.1f ,  0.0f, 1.7f, 0.0f ,      //Nose
         -0.2f, -1.6f, 0.0f ,  -0.8f, -1.6f, 0.0f ,  //Elevators
         -0.8f, -1.4f, 0.0f ,  -0.2f, -1.0f, 0.0f ,
         0.2f, -1.6f, 0.0f ,  0.8f, -1.6f, 0.0f ,
         0.8f, -1.4f, 0.0f ,  0.2f, -1.0f, 0.0f 
        };
  int indices[]={
     58, 61, 60, 59, 58, 62, 63, 64, 65, 62, 58, 59, 60, 61, 58, // Elevators
        62, 65, 64, 63, 62, //20
         1,  3,  4,  2,  1, 3,  5,  6,  4,  3,  1,  2,  4,  3,  1, // Tail
         3,  4,  6,  5,  3, //40
        14, 15,  8,  7, 14, 15, 16,  9,  8, 15, 16, 17, 10,  9, 16, // Exhaust
        17, 18, 11, 10, 17, 18, 19, 12, 11, 18, 19, 20, 13, 12, 19,
        20, 14, 7, 13, 20, //75

        14, 21, 22, 15, 14, 15, 22, 23, 16, 15, 16, 23, 24, 17, 16, // Fuse
        17, 24, 25, 18, 17, 18, 25, 26, 19, 18, 19, 26, 27, 20, 19,
        20, 27, 21, 14, 20, //110
        28, 29, 30, 31, 32, 28, 33, 37, 36, 35, 34, 33, 28, 32, 31, // Wings
        30, 29, 28, 33, 34, 35, 36, 37, 33, //134
        21, 51, 52, 22, 21, 22, 52, 53, 50, 22, 50, 53, 54, 26, 50, // Subfuse
        26, 54, 55, 27, 26, 27, 55, 51, 21, 27,//159
        55, 54, 57, 55, 54, 56, 57, 54, 56, 52, 57, 56, 52, 51, 57, 52, // Nose
        51, 55, 57, 51,//179
        41, 42, 39, 38, 41, 45, 46, 42, 41, 45, 48, 49, 46, 45, 48, // Cockpit
//194
        40, 41, 38, 40, 42, 43, 39, 42,  //202
        44, 45, 41, 40, 44, 46, 47, 43, 42, 46, //212
        48, 45, 44, 48, 49, 47, 46, 49 //220
   };
   BranchGroup contentRoot;
   TransformGroup objSpin;
   public void giraX(float angulo){ 
      try{
         if(angulo < Math.PI * 2){
          //angulo+=0.2f;
          Transform3D t3d1=new Transform3D();
          Transform3D t3d2=new Transform3D();
          objSpin.getTransform(t3d1);
          t3d2.rotX(angulo);
          t3d1.mul(t3d2);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          objSpin.setTransform(t3d1);
         }
      }catch(Exception e){ }
   }
   public void giraY(float angulo){ 
      try{
         if(angulo < Math.PI * 2){
          //angulo+=0.2f;
          Transform3D t3d1=new Transform3D();
          Transform3D t3d2=new Transform3D();
          objSpin.getTransform(t3d1);
          t3d2.rotY(angulo);
          t3d1.mul(t3d2);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          objSpin.setTransform(t3d1);
         }
      }catch(Exception e){ }
   }
   public void giraZ(float angulo){ 
      try{
         if(angulo < Math.PI * 2){
          //angulo+=0.2f;
          Transform3D t3d1=new Transform3D();
          Transform3D t3d2=new Transform3D();
          objSpin.getTransform(t3d1);
          t3d2.rotZ(angulo);
          t3d1.mul(t3d2);
	  //t3d2.rotY(Math.PI   + nAnguloDoor);
          objSpin.setTransform(t3d1);
         }
      }catch(Exception e){ }
   }
   public void giraHD(float angulo){}
   public void giraHI(float angulo){}
   float[] createCoordinateData() {
      float[] data = new float[indices.length*3];
      for(int i=0; i< indices.length ;i++){
       System.out.println("i= "+i+"ind = "+indices[i]);
       data[i*3]=coorde[indices[i]*3];
       data[i*3+1]=coorde[indices[i]*3+1];
       data[i*3+2]=coorde[indices[i]*3+2];
      }
      return data;
   }
   Appearance createMaterialAppearance() {
      Appearance materialAppear = new Appearance();
      PolygonAttributes polyAttrib = new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      materialAppear.setPolygonAttributes(polyAttrib);
      Material material = new Material();
      material.setDiffuseColor(new Color3f(1.0f, 0.0f, 0.0f));
      materialAppear.setMaterial(material);
      return materialAppear;
   }
   Appearance createWireFrameAppearance() {
      Appearance materialAppear = new Appearance();
      PolygonAttributes polyAttrib = new PolygonAttributes();
      polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      materialAppear.setPolygonAttributes(polyAttrib);
      ColoringAttributes redColoring = new ColoringAttributes();
      redColoring.setColor(1.0f, 0.0f, 0.0f);
      materialAppear.setColoringAttributes(redColoring);
      return materialAppear;
   }
   public Jet(boolean wireFrame) {
      int total = 0;
    System.out.println("\n --- geometry debug information --- \n");

    float[] coordinateData = null;
    coordinateData = createCoordinateData();
    int[] stripCount = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 , 
                         5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                         5, 5, 6, 6, 6, 6, 5, 5, 5, 5, 5,
                         4, 4, 4, 4, 4, 5, 5, 5, 4, 4,
                         5, 5, 4, 4}; 
    for (int i = 0; i < stripCount.length; i++) {
      System.out.println("stripCount[" + i + "] = " + stripCount[i]);
      total += stripCount[i];
    }

    if (total != coordinateData.length / 3) {
      System.out.println("  coordinateData vertex count: "
          + coordinateData.length / 3);
      System.out.println("stripCount total vertex count: " + total);
    }

    GeometryInfo gi = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
    gi.setCoordinates(coordinateData);
    gi.setStripCounts(stripCount);

    Triangulator tr = new Triangulator();
    //        Triangulator tr = new Triangulator(1);
    System.out.println("begin triangulation");
    tr.triangulate(gi);
    System.out.println("  END triangulation");
    gi.recomputeIndices();

    NormalGenerator ng = new NormalGenerator();
    ng.generateNormals(gi);
    gi.recomputeIndices();

    Stripifier st = new Stripifier();
    st.stripify(gi);
    gi.recomputeIndices();

    Shape3D part = new Shape3D();
    if (wireFrame == true)
      part.setAppearance(createWireFrameAppearance());
    else
      part.setAppearance(createMaterialAppearance());
    part.setGeometry(gi.getGeometryArray());

    //contentRoot = new BranchGroup();

    objSpin = new TransformGroup();
    objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    //contentRoot.addChild(objSpin);

    objSpin.addChild(part);

    LineStripArray lineArray = new LineStripArray(indices.length ,
        LineArray.COORDINATES, stripCount); //*****
    //        LineStripArray lineArray = new LineStripArray(51,
    // LineArray.COORDINATES, stripCount); //*****
    lineArray.setCoordinates(0, coordinateData);
    Appearance blueColorAppearance = new Appearance();
    ColoringAttributes blueColoring = new ColoringAttributes();
    blueColoring.setColor(0.0f, 0.0f, 1.0f);
    blueColorAppearance.setColoringAttributes(blueColoring);
    LineAttributes lineAttrib = new LineAttributes();
    lineAttrib.setLineWidth(2.0f);
    blueColorAppearance.setLineAttributes(lineAttrib);

    objSpin.addChild(new Shape3D(lineArray, blueColorAppearance));
    BoundingSphere bounds = new BoundingSphere(new Point3d(),0.0);
    MouseRotate r=new MouseRotate(objSpin);
    r.setSchedulingBounds(bounds);
    objSpin.addChild(r);
    //giraX((float)Math.PI/2);
    //giraY((float)Math.PI);
    giraZ((float)Math.PI/2);
    giraY((float)Math.PI/2);
    giraZ((float)Math.PI/2);
  } // end of CreateSceneGraph method of MobiusApp
  /*public BranchGroup myBody(){
        return contentRoot;
  }*/
  public TransformGroup myBody(){
        return objSpin;
  }
}