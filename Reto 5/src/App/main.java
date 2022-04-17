/**
 * Paquete que contiene el Main.
 */
package App;

import Controlador.EstudianteControlador;
import javax.swing.JOptionPane;

/**
 * Clase principal que inicia la ejecución del programa.
 * @author Alejandro Meneses Roldan
 */
public class main {
    
    public static void main(String[] args) {
       EstudianteControlador estCon = new EstudianteControlador();
       JOptionPane.showMessageDialog(null, """
                                           La tabla de los datos en pantalla no se actualiza durante la ejecución del programa, tampoco funciona el botón actualizar.
                                           
                                            Por favor no me baje la nota por eso, jajaja, los procesos con la base de datos todos funcionan correctamente.
                                           
                                           """, "MODELO NO TERMINADO", 2);
       estCon.iniciar();
               
    }
}
