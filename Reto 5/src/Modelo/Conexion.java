/**
* Paquete que contiene toda la capa lógica.
* Contiene las siguientes clases:
* Clase Estudiante que genera los objetos del tipo Estudiante, 
* Clase EstudianteDAO que contiene la lógica de todos los procedimientos.
* Clase Conexion que contiene los métodos para conectarse a la base de datos.
* Clase EstudianteDTO que contiene el acceso a los elementos del DAO desde el
* controlador.
*/
package Modelo;

import java.sql.Connection ;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager ;
import java.sql.SQLException;

/**
* Clase encargada de hacer la conexión a la base de datos en SQLite.
* @author Alejandro Meneses Roldan.
*/

public class Conexion {
    
    private final String url = "jdbc:sqlite:D:/Documents/NetBeansProjects/bd_estudiantes.db";
    private Connection con = null;
    
    /**
    * Método que realiza la conexión a la base de datos 
    * @return Objeto de tipo Connection para hacer las solicitudes a la base 
    * de datos.
    */
    public Connection getConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            con = (Connection)DriverManager.getConnection(this.url);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}