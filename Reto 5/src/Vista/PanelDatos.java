/**
 * Paquete de Vista que almacena las clases referentes a la presentación al 
 * usuario y la captura de datos.
 */
package Vista;

import Controlador.EstudianteControlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
* Clase que contiene todos los elementos del panel de datos que permite la 
* interacción con el usuario
* @author Alejandro Meneses Roldan
*/
public class PanelDatos extends JPanel implements ActionListener{
    
    private VistaGrafica vista = new VistaGrafica();
    
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblNacimiento;
    private JLabel lblCorreoInst;
    private JLabel lblCorreoPers;
    private JLabel lblNumCel;
    private JLabel lblNumFijo;
    private JLabel lblPrograma;
    
    public JTextField txtNombres = new JTextField();
    public JTextField txtApellidos = new JTextField();
    public JTextField txtNacimiento = new JTextField();
    public JTextField txtCorreoInst = new JTextField();
    public JTextField txtCorreoPers = new JTextField();
    public JTextField txtNumCel = new JTextField();
    public JTextField txtNumFijo = new JTextField(); 
    public JTextField txtPrograma = new JTextField();

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public JTextField getTxtNacimiento() {
        return txtNacimiento;
    }

    public void setTxtNacimiento(JTextField txtNacimiento) {
        this.txtNacimiento = txtNacimiento;
    }

    public JTextField getTxtCorreoInst() {
        return txtCorreoInst;
    }

    public void setTxtCorreoInst(JTextField txtCorreoInst) {
        this.txtCorreoInst = txtCorreoInst;
    }

    public JTextField getTxtCorreoPers() {
        return txtCorreoPers;
    }

    public void setTxtCorreoPers(JTextField txtCorreoPers) {
        this.txtCorreoPers = txtCorreoPers;
    }

    public JTextField getTxtNumCel() {
        return txtNumCel;
    }

    public void setTxtNumCel(JTextField txtNumCel) {
        this.txtNumCel = txtNumCel;
    }

    public JTextField getTxtNumFijo() {
        return txtNumFijo;
    }

    public void setTxtNumFijo(JTextField txtNumFijo) {
        this.txtNumFijo = txtNumFijo;
    }

    public JTextField getTxtPrograma() {
        return txtPrograma;
    }

    public void setTxtPrograma(JTextField txtPrograma) {
        this.txtPrograma = txtPrograma;
    }
    
    
    public final static String CREAR = "CREAR";
    public final static String ELIMINAR = "ELIMINAR";
    public final static String MODIFICAR = "MODIFICAR";
    public final static String LIMPIAR = "LIMPIAR";
    public final static String CONSULTAS = "CONSULTAS";
    public final static String ACTUALIZAR = "ACTUALIZAR";
    public final static String SALIR = "SALIR";
    
    public final static String CONSAPE = "CONSAPE";
    public final static String CONSNAC = "CONSNAC";
    public final static String CONSCORINST = "CONSCORINST";
    public final static String CONSCORPER = "CONSCORPER";
    public final static String CONSCEL = "CONSCEL";
    public final static String CONSFIJO = "CONSFIJO";
    public final static String CONSPROG = "CONSPROG";
    public final static String CONSCANT = "CONSCANT";
  
    public JButton btnCrear;
    public JButton btnEliminar;
    public JButton btnModificar;
    public JButton btnLimpiar;
    public JButton btnConsultas;
    public JButton btnActualizar;
    public JButton btnSalir;
    
    public JButton btnConApe;
    public JButton btnConNac;
    public JButton btnConCorInst;
    public JButton btnConCorPers;
    public JButton btnConCel;
    public JButton btnConFijo;
    public JButton btnConProg;
    public JButton btnConCant;
    
    private FormEstudiante formulario;
    
    public PanelDatos(){
        
        setLayout (new BorderLayout());
        setBorder (new CompoundBorder(new EmptyBorder(10,10,10,10), new TitledBorder("Datos")));
        
        JLabel lblNombres = new JLabel ("        Nombres: ");
        JLabel lblApellidos = new JLabel ("        Apellidos: ");
        JLabel lblNacimiento = new JLabel ("        Fecha de nacimiento: ");
        JLabel lblCorreoInst = new JLabel ("        Correo institucional: ");
        JLabel lblCorreoPers = new JLabel ("        Correo personal: ");
        JLabel lblNumCel = new JLabel ("        Numero celular: ");
        JLabel lblNumFijo = new JLabel ("        Numero fijo: ");
        JLabel lblPrograma= new JLabel ("        Programa académico: ");
        
      
        txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
        txtNombres.setToolTipText("Digite el nombre del estudiante");
        
        txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
        txtNombres.setToolTipText("Digite los apellidos del estudiante");
        
        txtNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
        txtNacimiento.setToolTipText("Digite la fecha de nacimiento del estudiante\n en formato AAAA-MM-DD");
        
        txtCorreoInst.setHorizontalAlignment(SwingConstants.LEFT);
        txtCorreoInst.setToolTipText("Digite el correo institucional del estudiante");
        
        txtCorreoPers.setHorizontalAlignment(SwingConstants.LEFT);
        txtCorreoPers.setToolTipText("Digite el correo personal del estudiante");
                
        txtNumCel.setHorizontalAlignment(SwingConstants.LEFT);
        txtNumCel.setToolTipText("Digite el número de celular del estudiante");
        
        txtNumFijo.setHorizontalAlignment(SwingConstants.LEFT);
        txtNumFijo.setToolTipText("Digite el número telefónico fijo del estudiante");
        
        txtPrograma.setHorizontalAlignment(SwingConstants.LEFT);
        txtPrograma.setToolTipText("Digite el programa académico del estudiante");
        
        JLabel espacioVacio1 = new JLabel( "" );
        JLabel espacioVacio2 = new JLabel( "" );
        JLabel espacioVacio3 = new JLabel( "" );
        

        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(8,2);
        panelDatos.setLayout(gl);
               
        panelDatos.add(lblNombres);
        panelDatos.add(txtNombres);
        
        panelDatos.add(lblApellidos);
        panelDatos.add(txtApellidos);
        
        panelDatos.add(lblNacimiento);
        panelDatos.add(txtNacimiento);
        
        panelDatos.add(lblCorreoInst);
        panelDatos.add(txtCorreoInst);
        
        panelDatos.add(lblCorreoInst);
        panelDatos.add(txtCorreoInst);
        
        panelDatos.add(lblCorreoPers);
        panelDatos.add(txtCorreoPers);
        
        panelDatos.add(lblNumCel);
        panelDatos.add(txtNumCel);
        
        panelDatos.add(lblNumFijo);
        panelDatos.add(txtNumFijo);
        
        panelDatos.add(lblPrograma);
        panelDatos.add(txtPrograma);

        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("./images.png");
        imagen =  new JLabel( "" );
        imagen.setIcon(icono);
        add(imagen);
        
        btnCrear = new JButton();
        btnCrear.setText(" Crear ");
        btnCrear.setActionCommand(CREAR);
        btnCrear.setToolTipText("Digite todos los datos para crear un estudiante.");
        btnCrear.addActionListener(this);
      
        btnEliminar = new JButton();
        btnEliminar.setText(" Eliminar ");
        btnEliminar.setActionCommand(ELIMINAR);
        btnEliminar.setToolTipText("Digite el Correo Institucional para eliminar un estudiante.");
        btnEliminar.addActionListener(this);
        
        btnModificar = new JButton();
        btnModificar.setText(" Modificar ");
        btnModificar.setActionCommand(MODIFICAR);
        btnModificar.setToolTipText("Digite el Correo Institucional para modificar el Correo Personal, Celular, fijo y programa de un estudiante.");
        btnModificar.addActionListener(this);
        
        btnLimpiar = new JButton();
        btnLimpiar.setText(" Limpiar ");
        btnLimpiar.setActionCommand(LIMPIAR);
        btnLimpiar.setToolTipText("Presione para limpiar los campos del registro de estudiantes.");
        btnLimpiar.addActionListener(this);
                       
        btnActualizar = new JButton();
        btnActualizar.setText(" Actualizar ");
        btnActualizar.setActionCommand(ACTUALIZAR);
        btnActualizar.setToolTipText("Presione para actualizar los datos de la tabla inferior.");
        btnActualizar.addActionListener(this);
        
        btnSalir = new JButton();
        btnSalir.setText(" Salir ");
        btnSalir.setActionCommand(SALIR);
        btnSalir.setToolTipText("Presione para salir de la aplicación.");
        btnSalir.addActionListener(this);
            
        btnConApe = new JButton();
        btnConApe.setText(" Buscar por Apellido ");
        btnConApe.setActionCommand(CONSAPE);
        btnConApe.setToolTipText("Digite los apellidos para buscar por los estudiantes por apellidos.");
        btnConApe.addActionListener(this);
        
        btnConNac = new JButton();
        btnConNac.setText(" Buscar por Fecha de Nacimiento ");
        btnConNac.setActionCommand(CONSNAC);
        btnConNac.setToolTipText("Digite una fecha para buscar por los estudiantes que nacieron en esa fecha.");
        btnConNac.addActionListener(this);
        
        btnConCorInst = new JButton();
        btnConCorInst.setText(" Buscar por Correo Institucional ");
        btnConCorInst.setActionCommand(CONSCORINST);
        btnConCorInst.setToolTipText("Digite el correo institucional para buscar al estudiante.");
        btnConCorInst.addActionListener(this);

        btnConCorPers = new JButton();
        btnConCorPers.setText(" Buscar por Correo Personal ");
        btnConCorPers.setActionCommand(CONSCORPER);
        btnConCorPers.setToolTipText("Digite el correo personal para buscar al estudiante.");
        btnConCorPers.addActionListener(this);

        btnConCel = new JButton();
        btnConCel.setText(" Buscar por Numero de Celular ");
        btnConCel.setActionCommand(CONSCEL);
        btnConCel.setToolTipText("Digite el número de celular para buscar al estudiante.");
        btnConCel.addActionListener(this);
        
        btnConFijo = new JButton();
        btnConFijo.setText(" Buscar por Numero Fijo");
        btnConFijo.setActionCommand(CONSFIJO);
        btnConFijo.setToolTipText("Digite el número fijo para buscar al estudiante.");
        btnConFijo.addActionListener(this);
        
        btnConProg = new JButton();
        btnConProg.setText(" Buscar por Programa Académico.");
        btnConProg.setActionCommand(CONSPROG);
        btnConProg.setToolTipText("Digite el programa académico para buscar sus estudiantes.");
        btnConProg.addActionListener(this);
        
        btnConCant = new JButton();
        btnConCant.setText(" Buscar Cantidad por Programa ");
        btnConCant.setActionCommand(CONSCANT);
        btnConCant.setToolTipText("Digite el programa académico para contar la cantidad de estudiantes que tiene registrados.");
        btnConCant.addActionListener(this);

        JPanel panelBotones = new JPanel(new GridLayout(8,1));
        espacioVacio1.setPreferredSize(new Dimension(10,10));
        panelBotones.add(btnCrear);
        panelBotones.add(btnConApe);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnConNac);
        panelBotones.add(btnModificar);
        panelBotones.add(btnConCorInst);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnConCorPers);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnConCel);
        panelBotones.add(espacioVacio1);
        panelBotones.add(btnConFijo);
        panelBotones.add(espacioVacio2); 
        panelBotones.add(btnConProg);
        panelBotones.add(btnSalir);
        panelBotones.add(btnConCant);
        
        add(imagen, BorderLayout.WEST);
        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.EAST);
         
    }

    @Override/**
     * Metodo que contiene todas las acciones de los botones del panel.
     */
    public void actionPerformed(ActionEvent evento) {
        EstudianteControlador cont = new EstudianteControlador();
        String comando = evento.getActionCommand();
        String nombres, apellidos, fNacimiento, correoInst, correoPers, programa, buscar, tipoConsulta, PRINT,
               cambioCP,  cambioP, estEliminar, verificador;;
        long fijo, celular, cambioNF, cambioNC, buscarLong;
        if (comando.equals(CREAR))
        {
            nombres = ""; apellidos = ""; fNacimiento = ""; correoInst = ""; correoPers = ""; programa = "";
            fijo = 0; celular = 0;
            boolean crear;
            
                nombres = txtNombres.getText();
                apellidos = txtApellidos.getText();
                fNacimiento = txtNacimiento.getText();
                correoInst = txtCorreoInst.getText();
                correoPers = txtCorreoPers.getText();

                try{
                    celular = Long.parseLong(txtNumCel.getText());
                }catch(Exception e){
                    celular = 0;
                }

                 try{
                    fijo = Long.parseLong(txtNumFijo.getText());
                }catch(Exception e){
                    fijo = 0;
                }
                programa = txtPrograma.getText();
                
                if ("".equals(nombres) || "".equals(apellidos) || "".equals(fNacimiento) ||
                        "".equals(correoInst) || "".equals(correoPers) || celular == 0 ||
                        fijo == 0 || "".equals(programa))
                {

                   vista.mostrarInformacion("Para agregar un estudiante debe llenar los campos:\n\n"
                                                   + "- Nombres.\n"                        
                                                   + "- Apellidos.\n"
                                                   + "- Fecha de nacimiento.\n"
                                                   + "- Correo institucional.\n"
                                                   + "- Correo Personal.\n"
                                                   + "- Celular.\n"
                                                   + "- Fijo.\n"
                                                   + "- Programa Académico. "
                                                   + "\n\n",
                                                         "LA FLORESTA - CAMPOS VACIOS",0); 
                }
                else
                {
                    crear = cont.crear(nombres, apellidos, fNacimiento, correoInst, correoPers, celular, fijo, programa);
                    if (crear)
                    {
                        vista.mostrarInformacion("Estudiante agregado con éxito a la base de datos.\n\n",
                                             "LA FLORESTA - ESTUDIANTE AGREGADO", 1); 
                    }
                    else
                    {
                        vista.mostrarInformacion("El estudiante ya está registrado en la base de datos.\n\n",
                                                 "LA FLORESTA - ESTUDIANTE NO AGREGADO",0); 
                    }
                }
            limpiarCampos();
            
        }
        
        if (comando.equals(ELIMINAR))
        {
            estEliminar = "";
            estEliminar = txtCorreoInst.getText();
            
            
            if ("".equals(estEliminar))
                {

                   vista.mostrarInformacion("Para eliminar un estudiante debe llenar los campos:\n\n"
                                                   + "- Correo institucional.\n"
                                                   + "\n\n",
                                                         "LA FLORESTA - CAMPOS VACIOS",0); 
                }
            else
            {
                if(cont.eliminar(estEliminar))
                {
                    vista.mostrarInformacion("Estudiante eliminado con éxito de la base de datos.\n\n",
                                             "LA FLORESTA - ESTUDIANTE ELIMINADO", 1); 
                }
                else
                {
                    vista.mostrarInformacion("El estudiante no ha sido encontrado en la base de datos.\n\n",
                                             "LA FLORESTA - ESTUDIANTE NO ELIMINADO",0); 
                }
            }
            limpiarCampos();
           
        }
        
        if (comando.equals(MODIFICAR))
        {
            buscar = ""; cambioCP = "";  cambioP = ""; tipoConsulta = "correoInst";
            cambioNF = 0; cambioNC = 0;
            buscar = txtCorreoInst.getText();
            if ("".equals(buscar))
                {
                    vista.mostrarInformacion("Para modificar un estudiante debe llenar los campos:\n\n"
                                                   + "- Correo Institucional.\n"
                                                   + "- Correo Personal.\n"
                                                   + "- Celular.\n"
                                                   + "- Fijo.\n"
                                                   + "- Programa Académico. "
                                                   + "\n\n",
                                                         "LA FLORESTA - CAMPOS VACIOS",0); 
                }    
            else
                {
                    if (cont.consultas(buscar, tipoConsulta).isEmpty())
                    {
                        vista.mostrarInformacion("El estudiante no ha sido encontrado en la base de datos.\n\n",
                                                 "LA FLORESTA - ESTUDIANTE NO ENCONTRADO",0); 
                    }
                    else
                    {
                        cambioCP = txtCorreoPers.getText();

                        try{
                            cambioNC  = Long.parseLong(txtNumCel.getText());
                        }catch(Exception e){
                            celular = 0;
                        }

                         try{
                            cambioNF = Long.parseLong(txtNumFijo.getText());
                        }catch(Exception e){
                            fijo = 0;
                        }
                         
                        cambioP = txtPrograma.getText();
    
                        if (txtPrograma.getText().isBlank() || txtNumCel.getText().isBlank() || txtNumFijo.getText().isBlank() || txtCorreoPers.getText().isBlank())
                        {

                            vista.mostrarInformacion("Para modificar un estudiante debe llenar los campos: \n\n"
                                                   + "- Correo Institucional.\n"
                                                   + "- Correo Personal.\n"
                                                   + "- Celular.\n"
                                                   + "- Fijo.\n"
                                                   + "- Programa Académico. "
                                                   + "\n\n",
                                                         "LA FLORESTA - CAMPOS VACIOS",0); 
                        }
                        else
                        {
                            cont.modificar(buscar, cambioCP, cambioNC, cambioNF, cambioP);

                            vista.mostrarInformacion("El estudiante ha sido modificado con éxito.\n\n",
                                                     "LA FLORESTA - ESTUDIANTE MODIFICADO", 1);
                        }
                    }
                }
            limpiarCampos();
          
        }
        
        if (comando.equals(CONSAPE))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "apellidos";
            buscar =  txtApellidos.getText();
            PRINT = cont.consultas(buscar, tipoConsulta);
            if ("".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por apellido debe llenar los campos:\n\n"
                                       + "- Apellidos.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                    if (PRINT.isEmpty())
                    {
                        vista.mostrarInformacion("El apellido no ha sido encontrado en la base de datos.\n\n",
                                                 "LA FLORESTA - APELLIDO NO ENCONTRADO",0); 
                    }
                    else
                    {
                        vista.mostrarInformacion(PRINT,"LA FLORESTA - APELLIDO ENCONTRADO", 1);
                    }
            }
            limpiarCampos();
        }
                
        if (comando.equals(CONSNAC))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "nacimiento";
            buscar =  txtNacimiento.getText();
            PRINT = cont.consultas(buscar, tipoConsulta);
            if ("".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por Fecha de Nacimiento debe llenar los campos:\n\n"
                                       + "- Fecha de Nacimiento.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                if (PRINT.isEmpty())
                {
                    vista.mostrarInformacion("La fecha no fue encontrada en la base de datos.\n\n",
                                             "LA FLORESTA - FECHA DE NACIMIENTO NO ENCONTRADA",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - FECHA DE NACIMIENTO ENCONTRADA", 1);
                }
            }
            limpiarCampos();
        }
        
        if (comando.equals(CONSCORINST))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "correoInst";
            buscar =  txtCorreoInst.getText();
            PRINT = cont.consultas(buscar, tipoConsulta);
            if ("".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por Correo Institucional debe llenar los campos:\n\n"
                                       + "- Correo Institucional.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                if (PRINT.isEmpty())
                {
                    vista.mostrarInformacion("El correo institucional no fue encontrado en la base de datos.\n\n",
                                             "LA FLORESTA - CORREO INSTITUCIONAL NO ENCONTRADO",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - CORREO INSTITUCIONAL ENCONTRADO", 1);
                }
            }
            limpiarCampos();
        }
        
        if (comando.equals(CONSCORPER))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "correoPers";
            buscar =  txtCorreoPers.getText();
            PRINT = cont.consultas(buscar, tipoConsulta);
            if ("".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por Correo Personal debe llenar los campos:\n\n"
                                       + "- Correo Personal.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                if (PRINT.isEmpty())
                {
                    vista.mostrarInformacion("El correo personal no fue encontrado en la base de datos.\n\n",
                                             "LA FLORESTA - CORREO PERSONAL NO ENCONTRADO",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - CORREO PERSONAL ENCONTRADO", 1);
                }
            }
            limpiarCampos();
        }
        
        if (comando.equals(CONSCEL))
        {
            buscarLong = 0; PRINT = ""; tipoConsulta = "celular";
            try{
                    buscarLong  = Long.parseLong(txtNumCel.getText());
                }catch(Exception e){
                    buscarLong  = 0;
                }
            buscar = Long.toString(buscarLong);
            if ("0".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por Numero de Celular debe llenar los campos:\n\n"
                                       + "- Numero Celular.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                PRINT = cont.consultas(buscar, tipoConsulta);
                if (PRINT.isEmpty())
                {
                    vista.mostrarInformacion("El número de celular no fue encontrado en la base de datos.\n\n",
                                             "LA FLORESTA - NUMERO DE CELULAR NO ENCONTRADO",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - NUMERO DE CELULAR ENCONTRADO", 1);
                }
            }    
            limpiarCampos();
        }
        
        if (comando.equals(CONSFIJO))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "fijo";
            try{
                    buscarLong  = Long.parseLong(txtNumFijo.getText());
                }catch(Exception e){
                    buscarLong  = 0;
                }
            buscar = Long.toString(buscarLong);
             if ("0".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por el Número Fijo debe llenar los campos:\n\n"
                                       + "- Numero Fijo.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                PRINT = cont.consultas(buscar, tipoConsulta);
                if (PRINT.isEmpty())
                {
                    vista.mostrarInformacion("El Número fijo no fue encontrado en la base de datos.\n\n",
                                             "LA FLORESTA - NUMERO FIJO NO ENCONTRADO",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - NUMERO FIJO ENCONTRADO", 1);
                }
            }
            limpiarCampos();
        }
        
        if (comando.equals(CONSPROG))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "programa"; verificador= "";
            buscar =  txtPrograma.getText();
             if ("".equals(buscar))
            {

                vista.mostrarInformacion("Para buscar por Programa académico debe llenar los campos:\n\n"
                                       + "- Programa Académico.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                PRINT = cont.consultas(buscar, tipoConsulta);
                verificador += "Estudiantes matriculados en el programa de " + buscar+ "\n\n\n";
                System.out.println(PRINT);
                System.out.println(verificador);
                if (PRINT == null ? verificador == null : PRINT.equals(verificador))
                {
                    vista.mostrarInformacion("El programa academico no fue encontrado en la base de datos.\n\n",
                                             "LA FLORESTA - PROGRAMA ACADEMICO NO ENCONTRADO",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - PROGRAMA ACADEMICO ENCONTRADO", 1);
                }
            }
            limpiarCampos();
        }
        
        if (comando.equals(CONSCANT))
        {
            buscar = ""; PRINT = ""; tipoConsulta = "contar"; verificador = "";
            buscar =  txtPrograma.getText();
             if ("".equals(buscar))
            {

                vista.mostrarInformacion("Para contar lo estudiante que están inscritos en un programa académico debe llenar los campos:\n\n"
                                       + "- Programa Académico.\n"
                                       + "\n\n",
                                             "LA FLORESTA - CAMPOS VACIOS",0); 
            }
            else
            {
                PRINT = cont.consultas(buscar, tipoConsulta);
                verificador += "La cantidad de estudiantes matriculados en "+ buscar +" es: 0";
                if (PRINT == null ? verificador == null : PRINT.equals(verificador))
                {
                    vista.mostrarInformacion("El programa Académico no fue encontrada en la base de datos.\n\n",
                                             "LA FLORESTA - PROGRAMA ACADEMICO NO ENCONTRADO",0); 
                }
                else
                {
                    vista.mostrarInformacion(PRINT,"LA FLORESTA - PROGRAMA ACADEMICO ENCONTRADO", 1);
                }
            }
            limpiarCampos();
        }
        
        if (comando.equals(LIMPIAR))
        {
            limpiarCampos();
        }
        if (comando.equals(ACTUALIZAR))
        {
            vista.mostrarInformacion("Por favor no insista, ese botón no funciona.\n\n",
                                 "LA FLORESTA - BOTON QUE NO FUNCIONA", -1);
           // NO PUDE CON ESTO
        }
        if (comando.equals(SALIR))
        {
        despedida();
        }
    }
    
   /**
    * Método que limpia los campos del formulario.
    */
    public void limpiarCampos(){
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtNacimiento.setText(null);
        txtCorreoInst.setText(null);
        txtCorreoPers.setText(null);
        txtNumCel.setText(null);
        txtNumFijo.setText(null);
        txtPrograma.setText(null);
    
    }
    
   /**
    * Método que da la despedida al usar el botón salir.
    */
    public void despedida(){
        vista.mostrarInformacion("                           Hasta pronto\n\n",
                                 "LA FLORESTA - SALIDA", -1);
        System.exit(0);
    }  
}
