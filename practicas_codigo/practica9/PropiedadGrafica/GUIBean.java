//javac -cp beanutils.jar:commons-logging.jar:. GUIBean.java
//java -cp beanutils.jar:commons-logging.jar:. GUIBean java.awt.Button
// modificar las propiedades background, enabled, label, y visible 
//java -cp beanutils.jar:commons-logging.jar:. GUIBean java.awt.TextArea
//java -cp beanutils.jar:commons-logging.jar:. GUIBean PerroBean
import java.beans.*;
import org.apache.commons.beanutils.PropertyUtils;
import java.lang.reflect.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GUIBean implements ActionListener{
    private String[] propertys;
    private String[] names;
    private BeanProp bean;
    private JTextField[] prop;
    private JLabel[] nprop;
    private JColorChooser colors;
    private JButton bset, bcolor;
    private JPanel jp, jp1;
    private Color color;
public GUIBean(String name) throws Exception {
    bean=new BeanProp(name);
    names=bean.getPropertyNames();
    nprop=new JLabel[names.length];
    prop=new JTextField[names.length];  
    colors=new JColorChooser();
    //System.out.println(bean.getComponent());  
    jp=new JPanel(); jp1=new JPanel();
    jp.setLayout(new GridLayout(names.length,2));
    for (int j=0;j<names.length;j++) {
      jp.add(nprop[j]=new JLabel(names[j]));
      System.out.println(names[j]+": "+PropertyUtils.getProperty(bean.getComponent(), names[j]));
      Object o1=PropertyUtils.getProperty(bean.getComponent(), names[j]);
      String s1;
      if(o1==null)  s1="";
      else
	 s1=o1.toString().trim();
      jp.add(prop[j]=new JTextField(s1));
    }
    bset=new JButton("Set");
    bset.addActionListener(this);
    jp1.add(bset);
    bcolor=new JButton("Color");
    bcolor.addActionListener(this);
    jp1.add(bcolor);
    JFrame f=new JFrame("Reflexion");
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
    if( bean.getComponent() instanceof Component)
    	f.add("North", (Component)bean.getComponent());
    f.add("Center", jp); f.add("South", jp1);
    f.setSize(300, 300); f.setVisible(true);  
}
public void actionPerformed(ActionEvent e){ 
       JButton sel=(JButton)e.getSource();
       if(sel==bset){        
           for(int i=0;i<names.length;i++){
               if(names[i].equals("foreground"))
                        bean.setProperty(names[i], color);
               if(names[i].equals("nombre"))
                        bean.setProperty(names[i],prop[i].getText());
	       if(names[i].equals("raza"))
                        bean.setProperty(names[i],prop[i].getText());
	       //if(names[i].equals("edad"))
                        //bean.setProperty(names[i],12); modificar primero
  //BeanProp.java para poder quitar los 2 comentarios de arriba y asi se pueda 
  //cambiar la edad del perro
               try{
System.out.println(names[i]+": "+PropertyUtils.getProperty(bean.getComponent(), names[i]));
	        } catch(Exception ex){ex.printStackTrace();} 
            }
        }
	if(sel==bcolor)
	         color=Color.BLUE;
 }
public static void main(String[] s) throws Exception {  new GUIBean(s[0]); }
}
