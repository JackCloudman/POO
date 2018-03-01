import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.*;
import java.sql.*; 
// mysql --password=gatito --user=root
public class CreaPerros {
String driverClassName = "com.mysql.jdbc.Driver";
String conexionUrl = "jdbc:mysql://localhost:3306/classicmodels";
String dbUser = "root";
String dbPwd = "gatito";

Connection conexion = null;
Statement stmt= null;
static PerroBean pb;
public CreaPerros (Object obj){
	 try {
	 	//pb= new PerroBean("fido","fox",2,"M"/*, Color.red*/);
		crear(/*"PerroBean"*/ obj, "Perraquillo");
	} catch (Exception e) {
		e.printStackTrace();
   	}
}
public Connection getConexion(){
   Connection conn;
   try {
     conn = ConnectionFactory.getInstance(driverClassName, conexionUrl, dbUser, dbPwd )
.getConexion();
   } catch (SQLException e) {
		e.printStackTrace();  conn = null;
   }
   return conn;
}
public void crear(/*String clase*/Object obj, String tabla) throws Exception{
   String qryStr = "CREATE TABLE "+ tabla + "(";
   try{
   conexion = getConexion();  
/*   Class c=Class.forName(clase);
   Object o=c.getDeclaredConstructor(new Class[]{String.class}).newInstance("objeto1");
   BeanInfo beanInfo = Introspector.getBeanInfo(c);*/
   BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
   PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
   for (PropertyDescriptor pd : pds) {
      String propName = pd.getName();
      if(propName.equals("class"))
	 continue;
         
      Method getter = pd.getReadMethod();
      Object args[] = { };
      Object value = getter.invoke(obj, args);
      //String value=()
      System.out.println("valor "+(String)value);
      //qryStr = qryStr+propName+" varchar(50), ";
      qryStr = qryStr+propName+" varchar("+(String)value+"), ";
   }
   qryStr =qryStr.substring(0,qryStr.length()-2);
   qryStr = qryStr+")";
   System.out.println("obj fin "+qryStr);
   stmt = conexion.createStatement();
   stmt.executeUpdate(qryStr);
   stmt.close();
   conexion.close();
   } catch(SQLException sqle){
   	sqle.printStackTrace();
   	throw new DAOException("");
   }
   catch(IntrospectionException ie){
	//ie.printStackTrace();
	//throw new DAOException("");
   }
}
public static void main(String args[]) { 
	//new CreaPerros(); 
}
}

