
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.mouse.*;

public class Pez {
   float coorde []={ 
         -2.9140f, -5.9636f, 2.8686f,-3.0038f, -5.9636f, 2.8686f, 
         -2.8814f, -6.0100f, 2.9550f,-3.0404f, -6.0100f, 2.9550f,
         -2.8831f, -6.0100f, 2.9550f,-2.8869f, -6.0063f, 2.9404f,
         -2.9133f, -5.9751f, 2.8553f,-3.0046f, -5.9751f, 2.8553f,
         -3.0377f, -6.0063f, 2.9404f,-3.0397f, -6.0100f, 2.9550f,
         -2.9140f, -5.9636f, 2.8686f,-3.0038f, -5.9636f, 2.8686f,
         -2.9011f, -6.0100f, 2.9550f,-2.8869f, -6.0063f, 2.9404f,
         -2.9133f, -5.9751f, 2.8553f,-3.0046f, -5.9751f, 2.8553f,
         -3.0377f, -6.0063f, 2.9404f,-3.0410f, -6.0100f, 2.9550f,
         -2.9878f, -6.1923f, 3.0187f,-2.9242f, -6.1923f, 3.0187f,
         -2.9276f, -6.1732f, 2.9906f,-2.9924f, -6.1732f, 2.9906f,
         -2.9458f, -6.1368f, 2.9520f,-2.9742f, -6.1368f, 2.9520f,
         -2.9576f, -5.8065f, 3.0187f,-2.9316f, -5.8618f, 2.9691f,
         -2.8727f, -5.8613f, 3.0673f,-2.9447f, -5.8549f, 2.9341f,
         -2.9732f, -5.8549f, 2.9341f,-2.9868f, -5.8618f, 2.9691f,
         -3.0393f, -5.8613f, 3.0673f,-2.8946f, -5.9000f, 2.9508f,
         -2.9178f, -5.9020f, 2.8926f,-3.0001f, -5.9020f, 2.8926f,
         -3.0300f, -5.9000f, 2.9508f,-2.8727f, -6.1189f, 3.0187f,
         -2.8946f, -6.1000f, 2.9708f,-2.9178f, -6.0833f, 2.9076f,
         -3.0001f, -6.0833f, 2.9076f,-3.0300f, -6.1000f, 2.9708f,
         -3.0393f, -6.1189f, 3.0187f,-2.9448f, -6.1482f, 4.7032f,
         -2.9051f, -6.1219f, 4.4499f,-2.9389f, -6.2010f, 4.4125f,
         -2.9745f, -6.2843f, 4.6503f,-2.9742f, -6.2843f, 4.6503f,
         -2.9494f, -6.1512f, 4.7327f,-2.9735f, -6.2931f, 4.6756f,
         -2.7893f, -6.2377f, 3.6541f,-2.8005f, -6.2218f, 3.4485f,
         -2.8563f, -6.2795f, 3.2916f,-2.9009f, -6.3531f, 3.3402f,
         -2.8923f, -6.3844f, 3.6136f,-2.8117f, -6.2059f, 3.2430f,
         -3.1003f, -6.2059f, 3.2430f,-3.1115f, -6.2218f, 3.4485f,
         -3.0557f, -6.2795f, 3.2916f,-3.1227f, -6.2377f, 3.6541f,
         -3.0197f, -6.3844f, 3.6136f,-3.0111f, -6.3531f, 3.3402f,
         -3.0804f, -6.4672f, 3.3819f,-3.1161f, -6.5227f, 3.4835f,
         -3.0931f, -6.4870f, 3.5666f,-2.8269f, -6.4870f, 3.5666f,
         -2.8039f, -6.5227f, 3.4835f,-2.8396f, -6.4672f, 3.3819f,
         -2.9588f, -5.6538f, 4.0003f,-2.9560f, -5.6155f, 4.1339f,
         -2.9560f, -5.6164f, 4.2656f,-2.9573f, -5.7367f, 4.3820f,
         -2.9653f, -5.8081f, 4.3877f,-2.9588f, -5.6639f, 3.3078f,
         -2.9560f, -5.5347f, 3.3968f,-2.9560f, -5.4548f, 3.5285f,
         -2.9560f, -5.4943f, 3.7088f,-2.9593f, -5.6117f, 3.8242f,
         -2.9935f, -6.1512f, 4.7327f,-2.9696f, -6.1725f, 4.9974f,
         -2.9704f, -6.2849f, 4.8814f,-2.9727f, -5.7203f, 4.8494f,
         -2.9675f, -5.8292f, 4.9724f,-2.9931f, -5.8503f, 4.7139f, 
         -2.9756f, -5.7118f, 4.6457f,-2.9508f, -5.8503f, 4.7139f,
         -2.9700f, -6.0000f, 4.9982f,-2.9939f, -6.0000f, 4.7475f,
         -2.9484f, -6.0000f, 4.7475f,-2.7500f, -6.0002f, 3.6379f,
         -2.7776f, -6.0608f, 3.2268f,-3.1344f, -6.0608f, 3.2268f, 
         -3.1620f, -6.0002f, 3.6379f,-3.1003f, -5.7945f, 3.3078f,
         -3.1227f, -5.7627f, 3.7027f,-2.8117f, -5.7945f, 3.3078f,
         -2.7893f, -5.7627f, 3.7027f,-2.8872f, -6.0002f, 4.4719f,
         -2.7776f, -5.9497f, 3.9517f,-2.8117f, -6.1756f, 3.9841f,
         -2.9006f, -6.1189f, 4.4214f,-2.9009f, -6.3531f, 3.9679f,
         -2.9356f, -6.1923f, 4.3877f,-3.0111f, -6.3531f, 3.9679f,
         -2.9857f, -6.1923f, 4.3877f,-3.1003f, -6.1756f, 3.9841f,
         -3.0275f, -6.1189f, 4.4214f,-3.1344f, -5.9497f, 3.9517f,
         -3.0409f, -6.0002f, 4.4719f,-3.1003f, -5.8046f, 3.9922f,
         -3.0275f, -5.8815f, 4.4382f,-2.8117f, -5.8046f, 3.9922f,
         -2.9006f, -5.8815f, 4.4382f,-2.9000f, -6.3563f, 3.9328f,
         -3.0120f, -6.3563f, 3.9328f,-2.9589f, -5.6463f, 3.9688f,
         -2.8094f, -5.8003f, 3.9623f,-3.1026f, -5.8003f, 3.9623f,
         -3.1024f, -6.1813f, 3.9537f,-3.1370f, -5.9544f, 3.9224f,
         -2.8096f, -6.1813f, 3.9537f,-2.7750f, -5.9544f, 3.9224f,
         -3.1204f, -5.7669f, 3.7315f,-3.1593f, -5.9952f, 3.6692f,
         -2.7527f, -5.9952f, 3.6692f,-2.7916f, -5.7669f, 3.7315f,
         -2.7913f, -6.2321f, 3.6837f,-2.8929f, -6.3823f, 3.6372f,
         -3.1207f, -6.2321f, 3.6837f,-3.0191f, -6.3823f, 3.6372f,
         -2.9592f, -5.6184f, 3.8521f,-2.8200f, -5.8036f, 3.2750f,
         -2.7908f, -6.0537f, 3.1989f,-2.9587f, -5.6787f, 3.2778f,
         -2.8199f, -5.8036f, 3.2752f,-3.0920f, -5.8036f, 3.2750f,
         -3.1212f, -6.0537f, 3.1989f,-3.0918f, -6.1937f, 3.2116f,
         -3.0077f, -6.3295f, 3.2928f,-2.9043f, -6.3295f, 3.2928f,
         -2.8202f, -6.1937f, 3.2116f,-3.2266f, -6.2653f, 3.4744f,
         -3.3538f, -6.3333f, 3.4363f,-3.4078f, -6.4071f, 3.3442f,
         -3.3170f, -6.4031f, 3.2522f,-3.1746f, -6.3640f, 3.2140f,
         -2.7454f, -6.3640f, 3.2140f,-2.5830f, -6.4031f, 3.2522f,
         -2.4922f, -6.4071f, 3.3442f,-2.5462f, -6.3333f, 3.4363f,
         -2.6934f, -6.2653f, 3.4744f,-2.8669f, -6.1272f, 3.0400f,
         -2.8435f, -6.0255f, 3.0873f,-2.8530f, -6.0204f, 3.0673f,
         -2.9227f, -6.2023f, 3.0387f,-2.9893f, -6.2023f, 3.0387f,
         -3.0451f, -6.1272f, 3.0400f,-3.0590f, -6.0204f, 3.0673f,
         -3.0685f, -6.0255f, 3.0873f,-3.0444f, -5.8557f, 3.0873f,
         -2.9577f, -5.7965f, 3.0389f,-2.8676f, -5.8557f, 3.0873f,
         -2.9665f, -5.7975f, 4.4160f,-2.9057f, -5.8783f, 4.4662f,
         -3.0240f, -5.8783f, 4.4662f,-2.8939f, -6.0002f, 4.5019f,
         -3.0358f, -6.0002f, 4.5019f,-3.0244f, -6.1219f, 4.4499f,
         -2.9847f, -6.2010f, 4.4125f,-2.9967f, -6.1482f, 4.7032f,
         -2.9971f, -6.0001f, 4.7175f,-2.9990f, -6.0000f, 4.7175f,
         -2.9417f, -6.0000f, 4.7175f,-2.9438f, -6.0001f, 4.7175f, 
         -2.9967f, -5.8536f, 4.6850f,-2.9455f, -5.8536f, 4.6850f,
         -2.9746f, -5.7209f, 4.6213f,-3.0347f, -5.9003f, 2.9888f,
         -3.0360f, -5.8900f, 3.0100f,-3.0399f, -5.9003f, 3.0312f,
         -3.0440f, -5.9250f, 3.0400f,-3.0459f, -5.9497f, 3.0312f,
         -3.0446f, -5.9600f, 3.0100f,-3.0407f, -5.9497f, 2.9888f,
         -3.0366f, -5.9250f, 2.9800f,-3.0405f, -6.0000f, 2.9413f,
         -2.8850f, -5.9003f, 2.9888f,-2.8839f, -5.9250f, 2.9800f,
         -2.8789f, -5.9497f, 2.9888f,-2.8730f, -5.9600f, 3.0100f,
         -2.8696f, -5.9497f, 3.0312f,-2.8708f, -5.9250f, 3.0400f,
         -2.8757f, -5.9003f, 3.0312f,-2.8816f, -5.8900f, 3.0100f,
         -2.8842f, -6.0000f, 2.9413f
        };
  int indices[]={
     18, 19, 20, 18, 21, 18, 20, 21, 21, 20, 22, 21, 22, 23, 21, 22,//16
     //24  25  26   -1, 24  27  25 -1,  24  28 27   -1, 24 29 28 -1,
     24, 25, 26, 24, 24, 27, 25, 24, 24, 28, 27, 24, 24, 29, 28, 24,//32
     24, 30, 29, 24, 26, 25, 31, 26, //40
     31, 25, 27, 32, 31, 32, 27, 28, 33, 32, 33, 28, 29, 34, 33, //55
     34, 29, 30, 34, //59
     19, 35, 36, 20, 19, 20, 36, 37, 22, 20, //69
     22, 37, 38, 23, 22, 23, 38, 39, 21, 23, 21, 39, 40, 18, 21, //84
     48, 49, 50, 51, 52, 48, //90
     53, 50, 49, 53, 54, 55, 56, 54, //98
     57, 58, 59, 56, 55, 57, //104
     76, 77, 78, 76, 78, 47, 76, 78, 46, 47, 78, 46, 46, 78, 77, 46, 79, 80, 81, 79,//124
     79, 81, 82, 79, 79, 82, 83, 79, 83, 80, 79, 83, //136
     84, 77, 76, 85, 84, //141

     86, 46, 77, 84, 86 , 80, 84, 85, 81, 80, 83, 86, 84, 80, 83, //156
     87, 88, 53, 49, 48, 87, // 162

     52, 51, 59, 58, 52, // 167
     57, 55, 54, 89, 90, 57, // 173
     90, 89, 91, 92, 90, 92, 91, 71, 75, 92 , //183
     75, 71, 93, 94, 75, 94, 93, 88, 87, 94, 95, 96, 97, 98, 95, 98, 97, 99, 100, 98,//203
     100,  99, 101, 102, 100, 102, 101, 103, 104, 102, 104, 103, 105, 106, 104,//218
     106, 105, 107, 108, 106, 108, 107, 66, 70, 108, 70, 66, 109, 110, 70, //233
     110, 109, 96, 95, 110, // 238
     155, 183, 34, 175, 182, 181, 180, 179, 178, 177, 176, 175, 34, 30, 155, //253
     151, 26, 31, 184, 191, 190 , 189, 188, 187, 186, 185, 184, 31, 192, 151, //268
     155, 40, 39, 16, 17, 183, 155, //275
     16, 39, 38, 15, 16, 14, 15, 38, 37, 14, 13, 14, 37, 36, 13, //290
     151, 192, 12, 13, 36, 35, 151, //297
     34, 183, 11, 33, 34, 11, 10, 32, 33, 11, 31, 32, 10, 192, 31, //312
     41, 42, 43, 44, 45, 41, //318
     121, 120, 115, 117, 121, 123, 122, 119, 114, 123, //328
     124, 118, 119, 122, 124, 111, 118, 124, 125, 111, 112, 127, 126, 116, 112,//343
     117, 116, 126, 121, 117, 115, 120, 128, 113, 115, 114, 113, 128, 123, 114, 
     112, 111, 125, 127, 112, 138, 130, 150, 149, 138, 137, 138, 149, 152, 137,
     137, 152, 153, 136, 137, 136, 153, 154, 135, 136, 135, 154, 156, 134, 135, 
     133, 134, 156, 157, 133, 131, 133, 157, 158, 131, 131, 158, 159, 132, 131,//403 
     129, 159, 150, 130, 129, //408
     43, 166, 44, 45, 44, 47, 43, //415

     44, 166, 165, 167, 44, //420
     165, 164, 169, 168, 167, 165, 42, 41, 171, 170, 163, 42, //432
     162, 172, 169, 164, 162, 161, 163, 170, 173, 161, 174, 172, 162, 160, 174,//447
     174, 160, 161, 173, 174, //452

     58, 59, 60, 61, 62, 58, 52, 63, 64, 65, 51, 52, 66, 67, 68, 69, 70, 66, 
     71, 72, 73, 74, 75, 71, // 476
     55, 139, 140, 141, 142, 143, 56, 55, 49, 50, 144, 145, 146, 147, 148, 49//492

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
      //float[] data = new float[indices.length*3];
      float[] data = new float[492*3];
      System.out.println("lobgi cooord = "+coorde.length+"ind len= "+indices.length);
      for(int i=0; i< 492 /*indices.length*/ ;i++){
       //System.out.println("i= "+i+"ind = "+indices[i]+"por 3 ="+indices[i]*3);
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
      material.setDiffuseColor(new Color3f(1.0f, 0.8118f, 0.0f));
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
   public Pez(boolean wireFrame) {
      int total = 0;
    System.out.println("\n --- geometry debug information --- \n");

    float[] coordinateData = null;
    coordinateData = createCoordinateData();
    int[] stripCount = { 4, 4, 4, 4 , 4, 4, 4, 4, 4, 4 ,//40 
                         5, 5, 5, 4, 5, 5, 5, 5, 5 , 6, //90
                         4, 4 , 6, 4, 4, 4, 4, 4 , 4, 4, 4, 5,//141
                         5, 5, 5, 6, 5, 6 , 5, 5, 5, 5,
                         5, 5, 5, 5, 5, 5, 5, 5, 5, 15, 15, 
                         7, 5, 5, 5, 7, 5, 5, 5, 6, 5, 5, 5, 5, 5,
                         5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                         7, 5, 6, 6, 5, 5, 5, 5, 
                         6, 6, 6, 6, 8, 8}; 
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
    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 0.0);
    //BoundingSphere bounds = new BoundingSphere(new Point3d(),0.0);
    MouseRotate r=new MouseRotate(objSpin);
    r.setSchedulingBounds(bounds);
    //objSpin.addChild(r);
    //giraX((float)Math.PI/2);
    //giraY((float)Math.PI);
    Color3f light1Color = new Color3f(1.8f, 1.8f, 0.1f);
    Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
    DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
    light1.setInfluencingBounds(bounds);
    objSpin.addChild(light1);
    /*giraZ((float)Math.PI/2);
    giraY((float)Math.PI/2);
    giraZ((float)Math.PI/2);
    giraY((float)Math.PI);*/
  } // end of CreateSceneGraph method of MobiusApp
  /*public BranchGroup myBody(){
        return contentRoot;
  }*/
  public TransformGroup myBody(){
        return objSpin;
  }
}
