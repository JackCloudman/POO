/*

Defining the Table: Oracle and MySql

create table MyPictures1 (
   id INT PRIMARY KEY,
   name VARCHAR(50),
   photo BLOB
);
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPictureToMySql {
  public static void main(String[] args) throws Exception, IOException, SQLException {
String url = "jdbc:mysql://localhost:3306/", dbName = "classicmodels";
    Class.forName("com.mysql.jdbc.Driver");   
Connection conex=DriverManager.getConnection(url+dbName, "root", "gatito" );
   String INSERT_PICTURE = "insert into MyPictures1(id, name, photo) values (?, ?, ?)";

    FileInputStream fis = null;
    PreparedStatement ps = null;
    try {
      conex.setAutoCommit(false);
      File file = new File("conejo.jpg");
      fis = new FileInputStream(file);
      ps = conex.prepareStatement(INSERT_PICTURE);
      ps.setString(1, "002");
      ps.setString(2, "rabbit");
      ps.setBinaryStream(3, fis, (int) file.length());
      ps.executeUpdate();
      conex.commit();
    } finally {
      ps.close();
      fis.close();
    }
  }
}
