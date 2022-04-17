/**
 * Paquete controlador se encarga de administrar las solicitudes de la capa 
 * vista, DAO y DTO.
 * */
package Controlador;

import Modelo.EstudianteDTO;
import Vista.FormEstudiante;
import javax.swing.UIManager;

/**
 * Clase que contiene todos los métodos de interacción entre el paquete de Vista
 * y el paquete Modelo.
 * @author Alejandro Meneses Roldan.
 */
public class EstudianteControlador {
    
    FormEstudiante formEst = new FormEstudiante();
    EstudianteDTO dto = new EstudianteDTO();

    /**
    * Constructor genérico de la clase Controlador.
    * contiene los objetos capEst que permite acceso a los métodos de la vista
    * y DTO que permite el acceso a los métodos del DTO
    **/
    public EstudianteControlador() {
    }
    
    /**
     * Método encargado de cargar el formulario principal.
     */
    public void iniciar(){
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            FormEstudiante interfaz = new FormEstudiante ();
            interfaz.setVisible(true); 
            
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
    /**
    *Método encargado de atender la solicitud de crear Estudiante.
    * @param nombres Contiene los nombres del estudiante.
    * @param apellidos Contiene los apellidos del estudiante.
    * @param fNacimiento Contiene la fecha de nacimiento del estudiante.
    * @param correoInst Contiene el correo institucional del estudiante.
    * @param correoPers Contiene el correo personal del estudiante.
    * @param celular Contiene el número celular del estudiante.
    * @param fijo Contiene el número fijo del estudiante.
    * @param programa Contiene el programa académico del estudiante.
    * @return regresa true en caso de que el usuario se logra crear.
    */
    public boolean crear(String nombres, String apellidos, String fNacimiento, String correoInst, String correoPers, long celular, long fijo, String programa){
        boolean Crear;
        Crear = dto.getEstudianteDAO().agregarEstudiante(nombres, apellidos, fNacimiento, correoInst, correoPers, celular, fijo, programa, dto.getConexion());
        return Crear;
    }
    
    /**
     * Método encargado atender la solicitud de eliminar un estudiante 
     * de la base de datos de estudiantes.
     * El método con el valor que le envía el controlador realiza la búsqueda 
     * en la base de datos y borra el registro del estudiante encontrado.
     * @param buscar Contiene el dato del estudiante que se va a eliminar
     * @return regresa un dato booleano en caso del que el estudiante se borra 
     * toma el dato de false y si no lo encuentra toma el valor de true.
     */
    public boolean eliminar(String buscar){
        if(dto.getEstudianteDAO().buscarEstudianteCorreoInst(buscar, dto.getConexion()).isEmpty())
        {
            return false;           
        }
        else
        {
            dto.getEstudianteDAO().eliminarEstudiante(buscar, dto.getConexion());
            return true;
        }    
    }
    
    /**
    * Método encargado atender la solicitud de modific1ar algunos datos del 
    * estudiante.
    * Con los datos enviados por el controlador realiza los cambios al 
    * estudiante especifico la base de datos de estudiantes, solo permite 
    * el cambio de los datos Correo Personal, Numero de celular, 
    * Número Fijo y Programa Académico.
    * @param buscar Contiene el dato que del estudiante que vamos a cambiar.
    * @param cambioCP Contiene el nuevo Correo Personal del estudiante. 
    * @param cambioNC Contiene el nuevo Numero de Celular del estudiante.
    * @param cambioNF Contiene el nuevo Núme1el estudiante.
    * @param cambioP Contiene el nuevo Numero Programa Académico del 
    * estudiante.
    */
    public void modificar(String buscar, String cambioCP, long cambioNC, long cambioNF, String cambioP){
        dto.getEstudianteDAO().modificar(buscar, cambioCP, cambioNC, cambioNF, cambioP, dto.getConexion());    
    }
    
    /**
    * Método encargado de atender la solicitud de las Consultas
    * El método recibe el dato que se quiere consultar y el tipo de consulta 
    * que se va a realizar, con esos dos parámetros direcciona hacia la 
    * correspondiente consulta.
    * @param buscar Contiene el dato que se va a buscar en la base de datos 
    * de estudiantes.
    * @param tipoConsulta Contiene el tipo de consulta que se va a realizar.
    * @return Retorna los datos encontrados en la base de datos para ser 
    * mostrados al usuario en la vista
    */
    public String consultas(String buscar, String tipoConsulta){
        String PRINT = "";
        
        if ("apellidos".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudianteApellido(buscar, dto.getConexion());
        } 
        if ("nacimiento".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudianteNacimiento(buscar, dto.getConexion());
        }
        if ("correoInst".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudianteCorreoInst(buscar, dto.getConexion());
        }
        if ("correoPers".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudianteCorreoPers(buscar, dto.getConexion());
        }
        if ("celular".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudianteCelular(Long.parseLong(buscar), dto.getConexion());
        }
        if ("fijo".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudianteFijo(Long.parseLong(buscar), dto.getConexion());
        }
        if ("programa".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().buscarEstudiantePrograma(buscar, dto.getConexion());
        }
        if ("contar".equals(tipoConsulta))
        {
            PRINT = dto.getEstudianteDAO().calcularPrograma(buscar, dto.getConexion());
        }
        return PRINT;
    }
}
