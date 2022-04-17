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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite hacer uso de los datos de la clase EstudianteDAO a la clase
 * Controlador.
 * @author Alejandro Meneses Roldan.
 */
public class EstudianteDTO {
    
    private EstudianteDAO estudianteDAO;
    private final String url = "jdbc:sqlite:D:/Documents/NetBeansProjects/bd_estudiantes.db";
    private Connection con = null;
    
   /**
    *Constructor genérico de Estudiante DTO
    */
    public EstudianteDTO(){ 
        estudianteDAO = new EstudianteDAO();
    }
    
   /**
    * Método que permite la conexión entre la base de datos y los métodos de 
    * EstudianteDAO,
    * @return objeto tipo Connection que permite la conexión a la base de datos.
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
    
    public void setConexion(Connection con){
        this.con = con;
    }
    
    public EstudianteDAO getEstudianteDAO(){
        return estudianteDAO;
    }
    
    public void setEstudianteDAO(EstudianteDAO estudianteDAO){
        this.estudianteDAO = estudianteDAO;
    }
    
}