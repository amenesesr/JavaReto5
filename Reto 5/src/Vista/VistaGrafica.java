/**
 * Paquete de Vista que almacena las clases referentes a la presentación al 
 * usuario y la captura de datos.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 * Esta clase contiene los metodos encargados de mostrar la informacion en la 
 * vista al usuario de forma grafica
 * @author Alejandro Meneses Roldan
 */
public class VistaGrafica {
    
    private JOptionPane leer;
    /**
     * Constructor generico de la clace.
     */
    public VistaGrafica(){
    }
    
    /**
     * Metodo encargado de capturar los datos String, los convierte en 
     * minusculas para ser enviados al controlador.
     * @param mensaje variable tipo String que contiene el texto de la ventana
     * @param titulo variable tipo String que contiene el titulo de la ventana
     * @param tipo variable tipo Int que contiene el icono de la ventana
     * @return un String en minusculas
     */
    public String leerDatosString (String mensaje, String titulo, int tipo){
        String dato = leer.showInputDialog(null, mensaje, titulo, tipo);
        String dato2 = dato.toLowerCase();
        return dato2;
    }
    
    /**
     * Metodo encargado de capturar los datos Long para ser enviados al 
     * controlador.
     * @param mensaje variable tipo String que contiene el texto de la ventana
     * @param titulo variable tipo String que contiene el titulo de la ventana
     * @param tipo variable tipo Int que contiene el icono de la ventana
     * @return Variable tipo Long
     */
    public long leerDatosLong(String mensaje, String titulo, int tipo){
        long dato = 0;
        try{
            dato = Long.parseLong(leer.showInputDialog(null, mensaje, titulo, tipo));
        }catch(Exception e){
            dato = 0;
        }
        return dato;
    }
    
    /**
     * Metodo encargado de capturar los datos Double para ser enviados al 
     * controlador.
     * @param mensaje variable tipo String que contiene el texto de la ventana
     * @param titulo variable tipo String que contiene el titulo de la ventana
     * @param tipo variable tipo Int que contiene el icono de la ventana
     * @return Variable tipo Double
     */
    public double leerDatosDouble(String mensaje, String titulo, int tipo){
        double dato = 0;
        try{
            dato = Double.parseDouble(leer.showInputDialog(null, mensaje, titulo, tipo));
        }catch(Exception e){
            dato = 0;
        }
        return dato;
    }
    
    /**
     * Metodo encargado de capturar los datos Int para ser enviados al 
     * controlador.
     * @param mensaje variable tipo String que contiene el texto de la ventana
     * @param titulo variable tipo String que contiene el titulo de la ventana
     * @param tipo variable tipo Int que contiene el icono de la ventana
     * @return Variable tipo Int
     */
    public int leerDatosEntero(String mensaje, String titulo, int tipo){
        int dato = 0;
        try{
            dato = Integer.parseInt(leer.showInputDialog(null, mensaje, titulo, tipo));
        }catch(Exception e){
            dato = 0;
        }
        return dato;
    }
    
    /**
     * Metodo encargado de mostrar ventanas de informacion al usuario
     * @param mensaje variable tipo String que contiene el texto de la ventana
     * @param titulo variable tipo String que contiene el titulo de la ventana
     * @param tipo variable tipo Int que contiene el icono de la ventana
     */
    public void mostrarInformacion(String mensaje, String titulo, int tipo){
            leer.showMessageDialog(null,mensaje, titulo, tipo); 
    }       
}
