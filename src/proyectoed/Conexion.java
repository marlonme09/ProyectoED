/**
 *
 * @author Marlon Mejia
 * 
 * Clase Conexion
 * Se encarga de hacer la conexion con la base de datos, para obtener las
 * estaciones que se encuentran registradas en el sistema.
 * 
 */

package proyectoed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String driver, url;
    public Connection conex;
    
    public Conexion(){
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://NODO1;databaseName=ProyectoED";
        try{
            Class.forName(driver);
            conex = DriverManager.getConnection(url, "sa", "Qwerty098");
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public Connection ConnectionSQLServer(){
        return conex;
    }
}
