//import com.sun.j3d.utils.geometry.*;
//import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
public interface Movible {
  public void giraTron(float angulo);
  public void giraHD(float angulo);
  public void giraHI(float angulo);
  public BranchGroup myBody();
  public void changeTextureCab(Texture texture, String image);
}


