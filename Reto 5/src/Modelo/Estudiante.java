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

import java.io.Serializable;

/**
 *Clase encargada de generar los objetos de tipo estudiante.
 * @author Alejandro Meneses Roldan.
 */
public class Estudiante implements Serializable {
    
    private String nombres;
    private String apellidos;
    private String fNacimiento;
    private String correoInst;
    private String correoPers;
    private long celular;
    private long fijo;
    private String programa;

    /**
     * Constructor de objetos Estudiante con todos sus parámetros
     * @param nombres Contiene los nombres del estudiante.
     * @param apellidos Contiene los apellidos del estudiante.
     * @param fNacimiento Contiene la fecha de nacimiento del estudiante.
     * @param correoInst Contiene el correo institucional del estudiante.
     * @param correoPers Contiene el correo personal del estudiante.
     * @param celular Contiene el número celular del estudiante.
     * @param fijo Contiene el número fijo del estudiante.
     * @param programa Contiene el programa académico del estudiante.
     */
    public Estudiante(String nombres, String apellidos, String fNacimiento, String correoInst, String correoPers, long celular, long fijo, String programa) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fNacimiento = fNacimiento;
        this.correoInst = correoInst;
        this.correoPers = correoPers;
        this.celular = celular;
        this.fijo = fijo;
        this.programa = programa;
    }
    
    /**
     * Constructor genérico de objetos estudiante.
     */
    public Estudiante() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getCorreoInst() {
        return correoInst;
    }

    public void setCorreoInst(String correoInst) {
        this.correoInst = correoInst;
    }

    public String getCorreoPers() {
        return correoPers;
    }

    public void setCorreoPers(String correoPers) {
        this.correoPers = correoPers;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getFijo() {
        return fijo;
    }

    public void setFijo(long fijo) {
        this.fijo = fijo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "\nDatos del Estudiante                                   "
             + "\n_____________________________________________________"
             + "\n" 
             + "\nNombres               : " + nombres 
             + "\nApellidos             : " + apellidos 
             + "\nFecha de Nacimiento   : " + fNacimiento 
             + "\nCorreo Institucional  : " + correoInst 
             + "\nCorreo Personal       : " + correoPers 
             + "\nNumero de Celular     : " + celular 
             + "\nNumero Fijo           : " + fijo 
             + "\nPrograma Academico    : " + programa;
    }  
} 