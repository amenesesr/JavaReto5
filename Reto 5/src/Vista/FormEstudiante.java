/**
 * Paquete de Vista que almacena las clases referentes a la presentación al 
 * usuario y la captura de datos.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
* Clase que contiene el formulario principal que se muestra al usuario al 
* ejecutar la aplicación.
* @author Alejandro Meneses Roldan.
*/
public class FormEstudiante extends JFrame{
    
    public PanelDatos panelDatos ;
    public PanelTabla panelTabla ;
    
   /**
    * Método constructor que unifica todos los paneles y los muestra en pantalla
    */
    public FormEstudiante (){
        
        panelDatos = new PanelDatos();
        panelTabla = new PanelTabla();
        
        setTitle("La Floresta - Gestion de Estudiantes");
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(panelDatos,BorderLayout.NORTH);
        cp.add(panelTabla,BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    
    
}
