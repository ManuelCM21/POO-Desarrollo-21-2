
package IGU;

import Entidades.Persona;
import Implementacion.ImplePersona;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CrudMysqlFrame extends JFrame {
    
    ImplePersona metodos = new ImplePersona();
    
    JLabel lb_id = new JLabel("Id");
    JTextField txt_id = new JTextField();

    JLabel lb_nombre = new JLabel("Nombre");
    JTextField txt_nombre = new JTextField();

    JLabel lb_apellido_paterno = new JLabel("Ap. Paterno");
    JTextField txt_apellido_paterno = new JTextField();

    JLabel lb_apellido_materno = new JLabel("Ap. Materno");
    JTextField txt_apellido_materno = new JTextField();

    JLabel lb_sexo = new JLabel("Sexo");
    JTextField txt_sexo = new JTextField();
    
    JRadioButton rbotonM = new JRadioButton("Masculino");
    JRadioButton rbotonF = new JRadioButton("Femenino");
    ButtonGroup bgsexo = new ButtonGroup();

    public CrudMysqlFrame() {
        bgsexo.add(rbotonM);
        bgsexo.add(rbotonF);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu();
        JMenu menuMantenimiento = new JMenu();
        JMenu menuReportes = new JMenu();

        JMenuItem menuFile_Exit = new JMenuItem();
        JMenuItem menuMantenimiento_Ingresar = new JMenuItem();
        JMenuItem menuMantenimiento_Eliminar = new JMenuItem();
        JMenuItem menuMantenimiento_Actualizar = new JMenuItem();
        JMenuItem menuReportes_General = new JMenuItem();
        JMenuItem menuReportes_Detallado = new JMenuItem();

        menuFile.setText("File");
        menuFile_Exit.setText("Salir");
        menuMantenimiento.setText("Mantenimiento");
        menuMantenimiento_Ingresar.setText("Ingresar");
        menuMantenimiento_Eliminar.setText("Eliminar");
        menuMantenimiento_Actualizar.setText("Actualizar");
        menuReportes.setText("Reportes");
        menuReportes_General.setText("General");
        menuReportes_Detallado.setText("Detallado");

        menuFile.add(menuFile_Exit);
        menuMantenimiento.add(menuMantenimiento_Ingresar);
        menuMantenimiento.add(menuMantenimiento_Eliminar);
        menuMantenimiento.add(menuMantenimiento_Actualizar);
        menuReportes.add(menuReportes_General);
        menuReportes.add(menuReportes_Detallado);

        menuBar.add(menuFile);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuReportes);

        setJMenuBar(menuBar);
        setTitle("Interfaz Grafica de Usuario");
        setSize(new Dimension(700, 500));
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuFile_Exit.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );

        menuMantenimiento_Ingresar.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel pan1 = new JPanel(new GridLayout(1, 2));
                pan1.add(lb_nombre);
                pan1.add(txt_nombre);

                JPanel pan2 = new JPanel(new GridLayout(1, 2));
                pan2.add(lb_apellido_paterno);
                pan2.add(txt_apellido_paterno);

                JPanel pan3 = new JPanel(new GridLayout(1, 2));
                pan3.add(lb_apellido_materno);
                pan3.add(txt_apellido_materno);

                JPanel pan4 = new JPanel(new GridLayout(1, 2));
                pan4.add(lb_sexo);
                pan4.add(rbotonM);
                pan4.add(rbotonF);

                Object msg[] = {pan1, pan2, pan3, pan4};

                if (JOptionPane.showOptionDialog(null, msg, "Registrar nueva persona", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {
                    Persona dp = new Persona();
                    dp.setNombre(txt_nombre.getText());
                    dp.setAp_paterno(txt_apellido_paterno.getText());
                    dp.setAp_materno(txt_apellido_materno.getText());
                    if (rbotonM.isSelected()==true) {
                        dp.setSexo("M");
                    } else {
                        dp.setSexo("F");
                    }
                    if (txt_nombre.getText().equals("") || txt_apellido_paterno.getText().equals("") || txt_apellido_materno.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Complete los datos", "Registrar", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        metodos.registrarPersona(dp);
                        JOptionPane.showMessageDialog(null, "Se registro correctamente", "Registrar", JOptionPane.INFORMATION_MESSAGE);
                        txt_nombre.setText("");
                        txt_apellido_paterno.setText("");
                        txt_apellido_materno.setText("");
                        txt_sexo.setText("");
                        bgsexo.clearSelection();
                    }
                }
            }
        }
        );

        menuReportes_General.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String columnas[]={"Nombres","Paterno","Materno","Sexo"};
//                    Object filas[][]=new Object[metodos.list.size()][4];
//                    ArrayList matriz = metodos.list;
//                    for(int i=0;i<matriz.size();i++){
//                        Persona v=(Persona)metodos.list.get(i);
//                        filas[i][0]=v.getNombre();
//                        filas[i][1]=v.getAp_paterno();
//                        filas[i][2]=v.getAp_materno();
//                        filas[i][3]=v.getSexo();
//                    }
//                JTable tabla = new JTable(filas, columnas);
//                JScrollPane tabla1 = new JScrollPane(tabla);
//                JPanel reporte = new JPanel();
//                reporte.add(tabla1);
//                Object msg[] = {reporte};
////                JOptionPane.showMessageDialog(null, msg, "Reporte", JOptionPane.QUESTION_MESSAGE);
            }
        }
        );

        menuMantenimiento_Eliminar.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JPanel pan1 = new JPanel(new GridLayout(1, 2));
                pan1.add(lb_id);
                pan1.add(txt_id);

                Object msg[] = {pan1};

                if (JOptionPane.showOptionDialog(null, msg, "Eliminar persona", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {
                    Persona dp = new Persona();
                    dp.setId(txt_id.getText());
                    if (txt_id.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Complete los datos", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        metodos.eliminarPersona(dp);
                        JOptionPane.showMessageDialog(null, "Se elimino correctamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                txt_id.setText("");
            }
        }
        );
    }
}
