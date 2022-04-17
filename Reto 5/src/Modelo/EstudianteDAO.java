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

import Vista.FormEstudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que contiene todos los métodos del CRUD y demás consultas.
 * @author Alejandro Meneses Roldan
 */
public class EstudianteDAO extends Conexion{
    
   /**
    * Método encargado de generar un objeto del tipo Estudiante y grabarlo en
    * la base de datos de estudiante.
    * @param nombres String que almacena el Nombre del estudiante.
    * @param apellidos String que almacena los Apellidos del estudiante.
    * @param fNacimiento String que almacena la Fecha de nacimiento del estudiante.
    * @param correoInst String que almacena el Correo institucional del estudiante.
    * @param correoPers String que almacena el Correo personal del estudiante.
    * @param celular String que almacena el Celular del estudiante.
    * @param fijo String que almacena el Número fijo del estudiante.
    * @param programa String que almacena el Programa del estudiante.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return Un Boolaeno, si logra grabar el dato es True y si no es False.
    */
    public boolean agregarEstudiante(String nombres, String apellidos, String fNacimiento,
            String correoInst, String correoPers, long celular, long fijo, String programa,
            Connection con) { 
        PreparedStatement ps = null; 
        Estudiante est = new Estudiante(nombres, apellidos, fNacimiento, correoInst, correoPers, celular, fijo, programa);
        String sql = "INSERT INTO Estudiantes (Nombres, Apellidos, Nacimiento, Co_inst, Co_Per, Num_cel, Num_fijo, programa)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getNombres());
            ps.setString(2, est.getApellidos());
            ps.setString(3, est.getFNacimiento());
            ps.setString(4, est.getCorreoInst());
            ps.setString(5, est.getCorreoPers());
            ps.setLong(6, est.getCelular());
            ps.setLong(7, est.getFijo());
            ps.setString(8, est.getPrograma());
            ps.execute();
            return true;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    }
    
   /**
    * Método encargado de eliminar estudiantes de la base de datos de 
    * Estudiantes.
    * @param buscar String que almacena el correo institucional del estudiante 
    * que vamos a eliminar
    * @param con objeto DTO que permite la conexión a la base de datos.
    */
    public void eliminarEstudiante(String buscar, Connection con) { 
        PreparedStatement ps = null; 
        String sql = "DELETE FROM Estudiantes WHERE Co_inst=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, buscar);
            ps.execute();
            
        } catch(SQLException e){
            System.err.println(e);
            
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }   
    } 
    
   /**
    * Método encargado de modificar algunos datos de un estudiante, Correo 
    * Personal, Celular, Fijo, Programa, usando el Correo institucional
    * @param correoInst String que almacena el Correo institucional del estudiante.
    * @param correoPers String que almacena el Correo personal del estudiante.
    * @param celular String que almacena el Celular del estudiante.
    * @param fijo String que almacena el Número fijo del estudiante.
    * @param programa String que almacena el Programa del estudiante.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return un booleano si logra modificar el estudiante es True si no es False.
    */
    public boolean modificar(String correoInst, String correoPers, long celular, long fijo, String programa, Connection con){ 
        PreparedStatement ps = null; 
        String sql = "UPDATE Estudiantes SET CO_per=?, Num_cel=?, Num_fijo=?, programa=? WHERE Co_inst=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, correoPers);
            ps.setLong(2, celular);
            ps.setLong(3, fijo);
            ps.setString(4, programa);
            ps.setString(5, correoInst);
            ps.execute();
            return true;
        } catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }  
    }
    
   /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según los apellidos del estudiante.
    * @param apellidos String que contiene el dato que se va a consultar en la 
    * base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la 
    * base de datos de estudiantes según la consulta.
    */    
    public String buscarEstudianteApellido (String apellidos, Connection con){
        FormEstudiante frmEst = new FormEstudiante();
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Apellidos=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, apellidos);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += "Nombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getLong("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getLong("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n\n";
            }
        } catch(SQLException e){
            System.err.println(e);

        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
   /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según la fecha de nacimiento.
    * @param fNacimiento String que contiene el dato que se va a consultar 
    * en la base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la
    * base de datos de estudiantes según la consulta.
    */       
    public String buscarEstudianteNacimiento(String fNacimiento, Connection con){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Nacimiento=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, fNacimiento);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += "Nombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getLong("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getLong("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n\n";
            }
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
    /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según el correo institucional.
    * @param correo String que contiene el dato que se va a consultar en la 
    * base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la 
    * base de datos de estudiantes según la consulta.
    */  
    public String buscarEstudianteCorreoInst (String correo, Connection con){ 
        PreparedStatement ps = null; 
        ResultSet rs = null;
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Co_inst=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if(rs.next()){
                PRINT += "Nombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getLong("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getLong("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n\n";
            }
            
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
    
    
   /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según el correo personal.
    * @param correo String que contiene el dato que se va a consultar en la 
    * base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la 
    * base de datos de estudiantes según la consulta.
    */   
    public String buscarEstudianteCorreoPers (String correo, Connection con){ 
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Co_per=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if(rs.next()){
                PRINT += "Nombres: " + rs.getString("Nombres") + "\n" + 
                         "Apellido: " + rs.getString("Apellidos") + "\n" + 
                         "Nacimiento: " + rs.getString("Nacimiento") + "\n" + 
                         "Correo Institucional: " + rs.getString("Co_inst") + "\n" +
                         "Correo Personal: " + rs.getString("Co_per") + "\n" +
                         "Numero celular: " + rs.getLong("Num_cel") + "\n" +
                         "Numero fijo: " + rs.getLong("Num_fijo") + "\n" +
                         "Programa: " + rs.getString("programa") + "\n\n";
            }
            
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
 
    /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según el número de celular.
    * @param celular variable que contiene el dato que se va a consultar 
    * en la base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la 
    * base de datos de estudiantes según la consulta.
    */    
    public String buscarEstudianteCelular(long celular, Connection con){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Num_cel=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setLong(1, celular);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += rs.getString("Nombres") + " " + rs.getString("Apellidos") + " " + rs.getString("programa") + "\n";
            }
 
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
    /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según  el número Fijo.
    * @param fijo variable que contiene el dato que se va a consultar 
    * en la base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la 
    * base de datos de estudiantes según la consulta.
    */    
    public String buscarEstudianteFijo(long fijo, Connection con){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Num_fijo=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setLong(1, fijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT += rs.getString("Nombres") + " " + rs.getString("Apellidos") + " " + rs.getString("programa") + "\n";
            }
 
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }
    
    /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según los programas académicos.
    * @param programa String que contiene el dato que se va a consultar en la 
    * base de datos de estudiantes.
    * @param con objeto DTO que permite la conexión a la base de datos.
    * @return retorna un String que contiene los datos encontrados en la 
    * base de datos de estudiantes según la consulta.
    */   
    public String buscarEstudiantePrograma(String programa, Connection con){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT * FROM Estudiantes WHERE Programa=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, programa);
            rs = ps.executeQuery();
            PRINT += "Estudiantes matriculados en el programa de " + programa + "\n\n";
            while (rs.next()) {     
                PRINT += rs.getString("Nombres") + " " + rs.getString("Apellidos") + "\n";
            }
            PRINT += "\n";
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    return PRINT;
    }

    /**
    * Método encargado de hacer la consulta en la base de datos de estudiantes
    * según el número de celular.
    * @param programa variable que contiene el dato que se va a consultar 
    * en la base de datos de estudiantes.
    * @return retorna un String que contiene la cantidad de estudiantes que 
    * están inscritos en un programa académico determinado según la consulta.
    */    
    public String calcularPrograma(String programa, Connection con){
        PreparedStatement ps = null; 
        ResultSet rs = null; 
        String PRINT = "";
        String sql = "SELECT count (*) as cantidad FROM Estudiantes WHERE Programa=?";
         try{
            ps = con.prepareStatement(sql);
            ps.setString(1, programa);
            rs = ps.executeQuery();
            rs.next();
            PRINT = "La cantidad de estudiantes matriculados en " + programa + " es: "+ rs.getString("cantidad");
        } catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                con.close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
        return PRINT;
    }
}
