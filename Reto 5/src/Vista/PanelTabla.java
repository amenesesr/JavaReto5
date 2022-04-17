/**
 * Paquete de Vista que almacena las clases referentes a la presentación al 
 * usuario y la captura de datos.
 */
package Vista;

import Modelo.EstudianteDTO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase encargada de construir el panel con la tabla y enviarlo al panel 
 * principal.
 * @author Alejandro Meneses Roldan
 */
public class PanelTabla extends JPanel{
    
    public javax.swing.JTable tblEstudiantes;
    public javax.swing.JScrollPane jScrollPane1;
    public EstudianteDTO dto = new EstudianteDTO();
    
    public PanelTabla() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Fecha de Nacimiento", "Correo Insitucional", "Correo Personal", "Celular", "Fijo", "Programa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstudiantes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEstudiantes);
        if (tblEstudiantes.getColumnModel().getColumnCount() > 0) {
            tblEstudiantes.getColumnModel().getColumn(0).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(1).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(2).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(3).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(4).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(5).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(6).setResizable(false);
            tblEstudiantes.getColumnModel().getColumn(7).setResizable(false);
        }
        try {
            DefaultTableModel modelo = new DefaultTableModel ();
            tblEstudiantes.setModel(modelo);
            
            PreparedStatement ps = null; 
            ResultSet rs = null;
            
            String sql = "SELECT Nombres, Apellidos, Nacimiento, Co_inst, Co_Per, Num_cel, Num_fijo, programa FROM estudiantes";
            ps = dto.getConexion().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("NOMBRES");
            tblEstudiantes.getColumnModel().getColumn(0).setHeaderValue("Nombres");
            tblEstudiantes.getColumnModel().getColumn(0).setResizable(false);
            modelo.addColumn("APELLIDOS");
            tblEstudiantes.getColumnModel().getColumn(1).setHeaderValue("Apellidos");
            tblEstudiantes.getColumnModel().getColumn(1).setResizable(false);
            modelo.addColumn("NACIMIENTO");
            tblEstudiantes.getColumnModel().getColumn(2).setHeaderValue("Nacimiento");
            tblEstudiantes.getColumnModel().getColumn(2).setResizable(false);
            modelo.addColumn("CORREO INSTITUCIONAL");
            tblEstudiantes.getColumnModel().getColumn(3).setHeaderValue("Correo Inst");
            tblEstudiantes.getColumnModel().getColumn(3).setResizable(false);
            modelo.addColumn("CORREO PERSONAL");
            tblEstudiantes.getColumnModel().getColumn(4).setHeaderValue("Correo Pers");
            tblEstudiantes.getColumnModel().getColumn(4).setResizable(false);
            modelo.addColumn("CELULAR");
            tblEstudiantes.getColumnModel().getColumn(5).setHeaderValue("Celular");
            tblEstudiantes.getColumnModel().getColumn(5).setResizable(false);
            modelo.addColumn("FIJO");
            tblEstudiantes.getColumnModel().getColumn(6).setHeaderValue("Fijo");
            tblEstudiantes.getColumnModel().getColumn(6).setResizable(false);
            modelo.addColumn("PROGRAMA");
            tblEstudiantes.getColumnModel().getColumn(7).setHeaderValue("Programa");
            tblEstudiantes.getColumnModel().getColumn(7).setResizable(false);
            
            int[] anchos  = {200,200,100,200,200,100,100,200};
            
            for (int x = 0; x < cantidadColumnas ; x++) {
                tblEstudiantes.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
                
            }
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i=0 ; i<cantidadColumnas ; i++){
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            
        if (tblEstudiantes.getColumnModel().getColumnCount() > 0) {
                tblEstudiantes.getColumnModel().getColumn(0).setHeaderValue("Nombres");
                tblEstudiantes.getColumnModel().getColumn(1).setHeaderValue("Apellidos");
                tblEstudiantes.getColumnModel().getColumn(2).setHeaderValue("Nacimiento");
                tblEstudiantes.getColumnModel().getColumn(3).setHeaderValue("Correo Inst");
                tblEstudiantes.getColumnModel().getColumn(4).setHeaderValue("Correo Pers");
                tblEstudiantes.getColumnModel().getColumn(5).setHeaderValue("Celular");
                tblEstudiantes.getColumnModel().getColumn(6).setHeaderValue("Fijo");
                tblEstudiantes.getColumnModel().getColumn(7).setHeaderValue("Programa");
  
            }          
        }catch(SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                dto.getConexion().close();
            } catch(SQLException e)
                {
                    System.err.println(e);
                }
        }
    
        JPanel panelTabla = new JPanel(new GridLayout(1,1));
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new EmptyBorder (0,0,0,0), new TitledBorder("Base de datos")));
        panelTabla.add(tblEstudiantes);
        add(panelTabla, BorderLayout.CENTER);
        
    }    

}
