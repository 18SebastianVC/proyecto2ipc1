package proyecto2;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JCalendarBeanInfo;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserBeanInfo;
import com.toedter.calendar.JDateChooserCellEditor;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDayChooserBeanInfo;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JMonthChooserBeanInfo;
import com.toedter.calendar.JSpinnerDateEditor;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JYearChooserBeanInfo;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.demo.DateChooserPanelBeanInfo;
import com.toedter.calendar.demo.DemoTable;
import com.toedter.calendar.demo.JCalendarDemo;
import com.toedter.components.GenericBeanInfo;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JLocaleChooserBeanInfo;
import com.toedter.components.JSpinField;
import com.toedter.components.JSpinFieldBeanInfo;
import com.toedter.components.JTitlePanel;
import com.toedter.components.LocaleEditor;
import com.toedter.plaf.JCalendarTheme;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import javax.swing.JList;
//import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Marcos Sebastián :v
 */
public class Proyecto2 extends JFrame implements ActionListener {

    Font titulo, subtitulo, subsubtitulo, tnormal;
    //login
    JPanel plogin;
    JLabel lbusuario, lbpassword;
    JTextField txusuario;
    JPasswordField textopassword;
    JButton b1;//boton de login
        JFileChooser pdf1;    
    //administrador
    JFileChooser explorar;
    File archivoEmpleado;//contiene el archivo csv de empleados
    File archivoTarea;//contiene el archivo csv de empleados
    
    JPanel pmenu1;
    JPanel pSuper, pcarrusel, pAddEmpleado, pEditarEmpleado, pCrearTarea, pEditarTarea1, pReporteTarea;

    JButton b01, b11, b12, b13, b14, b15, b16;//botones del menu administrador
    
    //Root
    JButton bRootRegresar,bCargar, bEliminar;//botones del menu ROOT
    
    
    //carrusel
    JButton bcRegresar, banterior, bsiguiente;//botones del carrusel
    JLabel cnombre, capellido, cpuesto, cnombre2, capellido2, cpuesto2;
    JLabel domingo, lunes, martes, miercoles, jueves, viernes, sabado, dom, lun, mar, mie, jue, vie, sab;
    Lista listadoEmpleado;    //lista del carrusel

    //Agregar empleado: Jpanel : paddEmpleado
    DefaultListModel modeloAgregar = new DefaultListModel();
    JButton bRegresar2, bAgregarEmpleado;
    JCheckBox chbxaddD, chbxaddL, chbxaddM, chbxaddMi, chbxaddJ, chbxaddV, chbxaddS;
    JComboBox cbxaddTipo;
    JLabel lbaddId, lbaddNombre, lbaddApellido, lbaddPuesto, lbaddTipo, lbaddNick, lbaddPassword;
    JList listaEmpleados1;
    JPasswordField txaddPassword;
    JScrollPane barraAgregarE;
    JTextField txaddId, txaddNombre, txaddApellido, txaddPuesto, txaddNick;

    //Editar empleado: Jpanel : pEditarEmpleado
    //DefaultListModel modeloEditar = new DefaultListModel();
    JButton bRegresar3, bEditarEmpleado;
    JCheckBox chbxEditarD, chbxEditarL, chbxEditarM, chbxEditarMi, chbxEditarJ, chbxEditarV, chbxEditarS;
    JComboBox cbxEditarId, cbxEditarTipo;
    JLabel lbEditarId, lbEditarNombre, lbEditarApellido, lbEditarPuesto, lbEditarTipo, lbEditarNick, lbEditarPassword;
    //JList listaEmpleados2;
    JTextField txEditarPassword;
    JScrollPane barraEditarE;
    JTextField txEditarNombre, txEditarApellido, txEditarPuesto, txEditarNick;

    //Agregar tarea: Jpanel : pCrearTarea
    Lista listadoTareas;    //lista de tareas
    DefaultListModel modeloCrearTarea = new DefaultListModel();
    JButton bRegresar4, bCrearTarea;
    JComboBox cbxCrearTareaEmpleado;
    JDateChooser dcCrearTareaFechaI;
    JLabel lbCrearTareaNombre, lbCrearTareaDesc, lbCrearTareaFechaI, lbCrearTareaDuracion, lbCrearTareaEmpleado;//,lbCrearTareaPorcentaje,lbCrearTareaEstado;        
    JList listaTareas1;
    JScrollPane barraCrearTarea;
    JSpinner snCrearTareaDuracion;
    JTextField txCrearTareaNombre, txCrearTareaDesc;//,txCrearTareaPorcentaje,txCrearTareaEstado;

    //editar tarea ADministrador
    JButton bRegresar5, bEditarTarea,bDetallesEditarTarea;    
    JComboBox cbxEditarTarea, cbxEditarTareaEmpleado;
    JLabel lbEditarTareaNombre1, lbEditarTareaDesc1, lbEditarTareaFechaI1, lbEditarTareaDuracion1, lbEditarTareaFechaF1, lbEditarTareaPorcentaje1, lbEditarTareaEmpleado;
    JLabel lbEditarTareaNombre2, lbEditarTareaDesc2, lbEditarTareaFechaI2, lbEditarTareaDuracion2, lbEditarTareaFechaF2, lbEditarTareaPorcentaje2;            
    JLabel lbEditarTareaEmpleado2,lbEditarTareaEmpleado3;
    
    //Panel PDF admin
    JButton bRegresarPDF,bpdfSinAsignar,bpdfFinalizadas,bpdfEmpleado,bpdfPorcentaje;
    JLabel lbTituloPDF,lbTareasSinAsignar,lbTareasFinalizadas,lbTareasPorcentaje,lbTareasPorEmpleado;
    JTextField txpdfPorcentaje;
    JComboBox cbxpdfEmpleado;
    
//panel menu Empleado    
    JPanel pEmpleado,pEditarTarea2,pTareasPendientes;
    JButton bRegresarEmpleado1,bRegresarEmpleado2,bRegresarEmpleado3,bEmpleadoEditarTarea,bEmpleadoReportes;
    JButton bEmpleadoDetalles,bEditarPorcentaje,bpdfTareasPendientes;
    
    JComboBox cbxEmpleadoEditarTarea, cbxEmpleadoEditarTareaPorcentaje;
    JLabel lbEmpleadoEditarTareaNombre1, lbEmpleadoEditarTareaDesc1, lbEmpleadoEditarTareaFechaI1, lbEmpleadoEditarTareaDuracion1, lbEmpleadoEditarTareaFechaF1, lbEmpleadoEditarTareaPorcentaje1, lbEmpleadoEditarTareaEmpleado;
    JLabel lbEmpleadoEditarTareaNombre2, lbEmpleadoEditarTareaDesc2, lbEmpleadoEditarTareaFechaI2, lbEmpleadoEditarTareaDuracion2, lbEmpleadoEditarTareaFechaF2, lbEmpleadoEditarTareaPorcentaje2;            
    JLabel lbEmpleadoEditarTareaEmpleado2,lbEmpleadoEditarTareaEmpleado3;
    JTextField txEmpleadoEditarAvance;
    
    
    public Proyecto2() {
        setTitle("Proyecto No. 2");

        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Proyecto2.EXIT_ON_CLOSE);

        //FUENTES
        titulo = new Font("Arial", Font.BOLD, 15);
        subtitulo = new Font("Arial", Font.BOLD, 13);
        subsubtitulo = new Font("Arial", Font.BOLD, 10);

        plogin = new JPanel();

        getContentPane().add(plogin);

        plogin.setVisible(true);
        plogin.setLayout(null);

        lbusuario = new JLabel();
        lbpassword = new JLabel();

        txusuario = new JTextField();
        textopassword = new JPasswordField();

        b1 = new JButton();

        lbusuario = new JLabel();
        lbusuario.setText("Usuario: ");
        lbusuario.setFont(titulo);
        plogin.add(lbusuario);
        lbusuario.setBounds(60, 50, 100, 25);

        txusuario = new JTextField(50);
        plogin.add(txusuario);
        txusuario.setBounds(175, 45, 150, 25);

        lbpassword = new JLabel();
        lbpassword.setText("Contraseña: ");
        lbpassword.setFont(titulo);
        plogin.add(lbpassword);
        lbpassword.setBounds(60, 100, 100, 25);

        textopassword = new JPasswordField(50);
        plogin.add(textopassword);
        textopassword.setBounds(175, 95, 150, 25);

        b1.setText("Acceder");
        b1.addActionListener((ActionListener) this);
        plogin.add(b1);
        b1.setBounds(175, 140, 90, 25);

//panel menu ROOT: pSuper
//-------------------
        pSuper = new JPanel();
        pSuper.setLayout(null);
        pSuper.setVisible(false);

        bRootRegresar = new JButton();
        bCargar = new JButton();
        bEliminar = new JButton();

        bRootRegresar.setText("Regresar");
        bRootRegresar.setBounds(20, 25, 100, 30);
        bRootRegresar.addActionListener((ActionListener) this);
        pSuper.add(bRootRegresar);

        bCargar.setText("Cargar Datos");
        bCargar.setBounds(50, 125, 135, 30);
        bCargar.addActionListener((ActionListener) this);
        pSuper.add(bCargar);

        bEliminar.setText("Eliminar Datos");
        bEliminar.setBounds(50, 175, 135, 30);
        bEliminar.addActionListener((ActionListener) this);
        pSuper.add(bEliminar);
        
//panel menu administrador: 1
//-------------------
        pmenu1 = new JPanel();
        pmenu1.setLayout(null);
        pmenu1.setVisible(false);

        b11 = new JButton();
        b12 = new JButton();
        b13 = new JButton();
        b14 = new JButton();
        b15 = new JButton();
        b16 = new JButton();
        b01 = new JButton();

        b01.setText("Regresar");
        b01.setBounds(20, 25, 100, 30);
        b01.addActionListener((ActionListener) this);
        pmenu1.add(b01);

        b11.setText("Carrusel");
        b11.setBounds(50, 75, 135, 30);
        b11.addActionListener((ActionListener) this);
        pmenu1.add(b11);

        b12.setText("Nuevo empleado");
        b12.setBounds(50, 125, 135, 30);
        b12.addActionListener((ActionListener) this);
        pmenu1.add(b12);

        b13.setText("Editar Empleado");
        b13.setBounds(50, 175, 135, 30);
        b13.addActionListener((ActionListener) this);
        pmenu1.add(b13);

        b14.setText("Crear Tarea");
        b14.setBounds(225, 75, 135, 30);
        b14.addActionListener((ActionListener) this);
        pmenu1.add(b14);

        b15.setText("Editar Tarea");
        b15.setBounds(225, 125, 135, 30);
        b15.addActionListener((ActionListener) this);
        pmenu1.add(b15);

        b16.setText("Reportes");
        b16.setBounds(225, 175, 135, 30);
        b16.addActionListener((ActionListener) this);
        pmenu1.add(b16);

//panel carrusel
//-------------------
        listadoEmpleado = new Lista();
        pcarrusel = new JPanel();
        pcarrusel.setLayout(null);
        pcarrusel.setVisible(false);

        bcRegresar = new JButton();
        banterior = new JButton();
        bsiguiente = new JButton();

        cnombre = new JLabel();
        capellido = new JLabel();
        cpuesto = new JLabel();
        domingo = new JLabel();
        lunes = new JLabel();
        martes = new JLabel();
        miercoles = new JLabel();
        jueves = new JLabel();
        viernes = new JLabel();
        sabado = new JLabel();

        cnombre2 = new JLabel();
        capellido2 = new JLabel();
        cpuesto2 = new JLabel();
        dom = new JLabel();
        lun = new JLabel();
        mar = new JLabel();
        mie = new JLabel();
        jue = new JLabel();
        vie = new JLabel();
        sab = new JLabel();

        Empleado empleado = new Empleado(0, "Sebastián", "Cabrera", "Super Usuario", 1, false, true, true, true, true, true, false, "ROOT", "201611290");
        listadoEmpleado.Agregar(empleado);
/*
        empleado = new Empleado(02, "Aaron", "Flores", "Desarrollador", 2, false, true, true, false, true, true, true, "aflores", "passtrue");
        listadoEmpleado.Agregar(empleado);

        empleado = new Empleado(03, "Sarah", "Aguilar", "Desarrollador", 2, false, false, true, true, true, true, true, "saguilar", "aguilartrue");
        listadoEmpleado.Agregar(empleado);
*/
        bcRegresar.setText("Regresar");
        bcRegresar.setBounds(20, 20, 100, 25);
        bcRegresar.addActionListener((ActionListener) this);
        pcarrusel.add(bcRegresar);

        cnombre.setText("Nombre: ");
        cnombre.setFont(titulo);
        pcarrusel.add(cnombre);
        cnombre.setBounds(60, 50, 100, 25);

        capellido.setText("Apellido: ");
        capellido.setFont(titulo);
        pcarrusel.add(capellido);
        capellido.setBounds(60, 80, 100, 25);

        cpuesto.setText("Puesto: ");
        cpuesto.setFont(titulo);
        pcarrusel.add(cpuesto);
        cpuesto.setBounds(60, 110, 100, 25);

        domingo.setText("D");
        domingo.setFont(titulo);
        domingo.setHorizontalAlignment(SwingConstants.CENTER);
        domingo.setForeground(Color.WHITE);//LIGHT_GRAY
        domingo.setBackground(Color.GRAY);
        domingo.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        domingo.setOpaque(true);
        pcarrusel.add(domingo);
        domingo.setBounds(70, 145, 50, 25);

        if (listadoEmpleado.getActual().getValor().isD()) {
            dom.setText("X");
        } else {
            dom.setText("");
        }//MUESTRA X O NADA DE ACUERDO SEA EL CASO            
        if (listadoEmpleado.getActual().getValor().isL()) {
            lun.setText("X");
        } else {
            lun.setText("");
        }
        if (listadoEmpleado.getActual().getValor().isM()) {
            mar.setText("X");
        } else {
            mar.setText("");
        }
        if (listadoEmpleado.getActual().getValor().isMi()) {
            mie.setText("X");
        } else {
            mie.setText("");
        }
        if (listadoEmpleado.getActual().getValor().isJ()) {
            jue.setText("X");
        } else {
            jue.setText("");
        }
        if (listadoEmpleado.getActual().getValor().isV()) {
            vie.setText("X");
        } else {
            vie.setText("");
        }
        if (listadoEmpleado.getActual().getValor().isS()) {
            sab.setText("X");
        } else {
            sab.setText("");
        }

        dom.setFont(titulo);
        dom.setHorizontalAlignment(SwingConstants.CENTER);
        dom.setForeground(Color.BLACK);//
        dom.setBackground(Color.LIGHT_GRAY);
        dom.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        dom.setOpaque(true);
        pcarrusel.add(dom);
        dom.setBounds(70, 170, 50, 25);

        lunes.setText("L");
        lunes.setFont(titulo);
        lunes.setHorizontalAlignment(SwingConstants.CENTER);
        lunes.setForeground(Color.WHITE);//LIGHT_GRAY
        lunes.setBackground(Color.GRAY);
        lunes.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        lunes.setOpaque(true);
        pcarrusel.add(lunes);
        lunes.setBounds(120, 145, 50, 25);
        lun.setFont(titulo);
        lun.setHorizontalAlignment(SwingConstants.CENTER);
        lun.setForeground(Color.BLACK);//
        lun.setBackground(Color.LIGHT_GRAY);
        lun.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        lun.setOpaque(true);
        pcarrusel.add(lun);
        lun.setBounds(120, 170, 50, 25);

        martes.setText("M");
        martes.setFont(titulo);
        martes.setHorizontalAlignment(SwingConstants.CENTER);
        martes.setForeground(Color.WHITE);//LIGHT_GRAY
        martes.setBackground(Color.GRAY);
        martes.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        martes.setOpaque(true);
        pcarrusel.add(martes);
        martes.setBounds(170, 145, 50, 25);
        mar.setFont(titulo);
        mar.setHorizontalAlignment(SwingConstants.CENTER);
        mar.setForeground(Color.BLACK);
        mar.setBackground(Color.LIGHT_GRAY);
        mar.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        mar.setOpaque(true);
        pcarrusel.add(mar);
        mar.setBounds(170, 170, 50, 25);

        miercoles.setText("Mi");
        miercoles.setFont(titulo);
        miercoles.setHorizontalAlignment(SwingConstants.CENTER);
        miercoles.setForeground(Color.WHITE);//LIGHT_GRAY
        miercoles.setBackground(Color.GRAY);
        miercoles.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        miercoles.setOpaque(true);
        pcarrusel.add(miercoles);
        miercoles.setBounds(220, 145, 50, 25);
        mie.setFont(titulo);
        mie.setHorizontalAlignment(SwingConstants.CENTER);
        mie.setForeground(Color.BLACK);
        mie.setBackground(Color.LIGHT_GRAY);
        mie.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        mie.setOpaque(true);
        pcarrusel.add(mie);
        mie.setBounds(220, 170, 50, 25);

        jueves.setText("J");
        jueves.setFont(titulo);
        jueves.setHorizontalAlignment(SwingConstants.CENTER);
        jueves.setForeground(Color.WHITE);//LIGHT_GRAY
        jueves.setBackground(Color.GRAY);
        jueves.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        jueves.setOpaque(true);
        pcarrusel.add(jueves);
        jueves.setBounds(270, 145, 50, 25);
        jue.setFont(titulo);
        jue.setHorizontalAlignment(SwingConstants.CENTER);
        jue.setForeground(Color.BLACK);
        jue.setBackground(Color.LIGHT_GRAY);
        jue.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        jue.setOpaque(true);
        pcarrusel.add(jue);
        jue.setBounds(270, 170, 50, 25);

        viernes.setText("V");
        viernes.setFont(titulo);
        viernes.setHorizontalAlignment(SwingConstants.CENTER);
        viernes.setForeground(Color.WHITE);//LIGHT_GRAY
        viernes.setBackground(Color.GRAY);
        viernes.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        viernes.setOpaque(true);
        pcarrusel.add(viernes);
        viernes.setBounds(320, 145, 50, 25);
        vie.setFont(titulo);
        vie.setHorizontalAlignment(SwingConstants.CENTER);
        vie.setForeground(Color.BLACK);
        vie.setBackground(Color.LIGHT_GRAY);
        vie.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        vie.setOpaque(true);
        pcarrusel.add(vie);
        vie.setBounds(320, 170, 50, 25);

        sabado.setText("S");
        sabado.setFont(titulo);
        sabado.setHorizontalAlignment(SwingConstants.CENTER);
        sabado.setForeground(Color.WHITE);//LIGHT_GRAY
        sabado.setBackground(Color.GRAY);
        sabado.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        sabado.setOpaque(true);
        pcarrusel.add(sabado);
        sabado.setBounds(370, 145, 50, 25);
        sab.setFont(titulo);
        sab.setHorizontalAlignment(SwingConstants.CENTER);
        sab.setForeground(Color.BLACK);
        sab.setBackground(Color.LIGHT_GRAY);
        sab.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        sab.setOpaque(true);
        pcarrusel.add(sab);
        sab.setBounds(370, 170, 50, 25);

        cnombre2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getNombre()));
        cnombre2.setFont(titulo);
        pcarrusel.add(cnombre2);
        cnombre2.setBounds(175, 50, 200, 25);

        capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));
        capellido2.setFont(titulo);
        pcarrusel.add(capellido2);
        capellido2.setBounds(175, 80, 200, 25);

        cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));
        cpuesto2.setFont(titulo);
        pcarrusel.add(cpuesto2);
        cpuesto2.setBounds(175, 110, 200, 25);

        banterior.setText("Anterior");//Boton anterior
        banterior.setBounds(50, 225, 100, 30);
        banterior.addActionListener((ActionListener) this);
        pcarrusel.add(banterior);

        bsiguiente.setText("Siguiente");//boton siguiente
        bsiguiente.setBounds(250, 225, 100, 30);
        bsiguiente.addActionListener((ActionListener) this);
        pcarrusel.add(bsiguiente);

//    
//Panel: Agregar nuevo empleado
        pAddEmpleado = new JPanel();
        bRegresar2 = new JButton();
        bAgregarEmpleado = new JButton();
        chbxaddD = new JCheckBox();
        chbxaddL = new JCheckBox();
        chbxaddM = new JCheckBox();
        chbxaddMi = new JCheckBox();
        chbxaddJ = new JCheckBox();
        chbxaddV = new JCheckBox();
        chbxaddS = new JCheckBox();
        cbxaddTipo = new JComboBox();
        lbaddId = new JLabel();
        lbaddNombre = new JLabel();
        lbaddApellido = new JLabel();
        lbaddPuesto = new JLabel();
        lbaddTipo = new JLabel();
        lbaddNick = new JLabel();
        lbaddPassword = new JLabel();
        listaEmpleados1 = new JList();
        //barraAgregarE = new JScrollPane(listaEmpleados1);
        txaddId = new JTextField();
        txaddNombre = new JTextField();
        txaddApellido = new JTextField();
        txaddPuesto = new JTextField();
        txaddNick = new JTextField();
        txaddPassword = new JPasswordField();

        pAddEmpleado.setLayout(null);
        pAddEmpleado.setVisible(false);

        bRegresar2.setText("Regresar");
        bRegresar2.setBounds(20, 25, 100, 30);
        bRegresar2.addActionListener((ActionListener) this);
        pAddEmpleado.add(bRegresar2);

        lbaddId.setText("Id: ");
        lbaddId.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddId.setFont(subtitulo);
        pAddEmpleado.add(lbaddId);
        lbaddId.setBounds(30, 75, 100, 25);
        pAddEmpleado.add(txaddId);
        txaddId.setBounds(135, 75, 130, 20);

        lbaddNombre.setText("Nombre: ");
        lbaddNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddNombre.setFont(subtitulo);
        pAddEmpleado.add(lbaddNombre);
        lbaddNombre.setBounds(30, 100, 100, 25);
        pAddEmpleado.add(txaddNombre);
        txaddNombre.setBounds(135, 100, 130, 20);

        lbaddApellido.setText("Apellido: ");
        lbaddApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddApellido.setFont(subtitulo);
        pAddEmpleado.add(lbaddApellido);
        lbaddApellido.setBounds(30, 125, 100, 25);
        pAddEmpleado.add(txaddApellido);
        txaddApellido.setBounds(135, 125, 130, 20);

        lbaddPuesto.setText("Puesto: ");
        lbaddPuesto.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddPuesto.setFont(subtitulo);
        pAddEmpleado.add(lbaddPuesto);
        lbaddPuesto.setBounds(30, 150, 100, 25);
        pAddEmpleado.add(txaddPuesto);
        txaddPuesto.setBounds(135, 150, 130, 20);

        lbaddTipo.setText("Tipo Empleado: ");
        lbaddTipo.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddTipo.setFont(subtitulo);
        pAddEmpleado.add(lbaddTipo);
        lbaddTipo.setBounds(20, 175, 110, 25);
        pAddEmpleado.add(cbxaddTipo);
        cbxaddTipo.setBounds(135, 175, 130, 20);
        cbxaddTipo.addItem("Administrador");
        cbxaddTipo.addItem("Empleado");

        lbaddNick.setText("Nick: ");
        lbaddNick.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddNick.setFont(subtitulo);
        pAddEmpleado.add(lbaddNick);
        lbaddNick.setBounds(30, 200, 100, 25);
        pAddEmpleado.add(txaddNick);
        txaddNick.setBounds(135, 200, 130, 20);

        lbaddPassword.setText("Password: ");
        lbaddPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lbaddPassword.setFont(subtitulo);
        pAddEmpleado.add(lbaddPassword);
        lbaddPassword.setBounds(30, 225, 100, 25);
        pAddEmpleado.add(txaddPassword);
        txaddPassword.setBounds(135, 225, 130, 20);

        chbxaddD.setText("Dom");
        pAddEmpleado.add(chbxaddD);
        chbxaddD.setBounds(50, 275, 55, 25);

        chbxaddL.setText("Lun");
        pAddEmpleado.add(chbxaddL);
        chbxaddL.setBounds(110, 275, 55, 25);

        chbxaddM.setText("Mar");
        pAddEmpleado.add(chbxaddM);
        chbxaddM.setBounds(170, 275, 55, 25);

        chbxaddMi.setText("Mie");
        pAddEmpleado.add(chbxaddMi);
        chbxaddMi.setBounds(230, 275, 55, 25);

        chbxaddJ.setText("Jue");
        pAddEmpleado.add(chbxaddJ);
        chbxaddJ.setBounds(50, 300, 55, 25);

        chbxaddV.setText("Vie");
        pAddEmpleado.add(chbxaddV);
        chbxaddV.setBounds(110, 300, 55, 25);

        chbxaddS.setText("Sab");
        pAddEmpleado.add(chbxaddS);
        chbxaddS.setBounds(170, 300, 55, 25);

        listaEmpleados1.setModel(modeloAgregar);
        listaEmpleados1.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JList
        pAddEmpleado.add(listaEmpleados1);

        listaEmpleados1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {// Cuenta la cantidad de clicks para saber si es doble                        
                    mostrarEmpleado();
                }
            }
        });

        Empleado listaAgregar = listadoEmpleado.getInicial().getValor();
        //listadoEmpleado.Avanzar();i=1
        for (int i = 0; i < listadoEmpleado.count; i++)//agregar los empleados al modelo lista
        {
            listaAgregar = listadoEmpleado.getActual().getValor();
            modeloAgregar.addElement(listaAgregar);
            listadoEmpleado.Avanzar();
        }

        barraAgregarE = new JScrollPane(listaEmpleados1);
        barraAgregarE.setBounds(300, 75, 150, 175);//300,75,150,175     
        pAddEmpleado.add(barraAgregarE);

        bAgregarEmpleado.setText("Agregar");
        bAgregarEmpleado.setBounds(325, 275, 100, 25);
        bAgregarEmpleado.addActionListener((ActionListener) this);
        pAddEmpleado.add(bAgregarEmpleado);

        //Panel: Editar Empleado   
        pEditarEmpleado = new JPanel();
        bRegresar3 = new JButton();
        bEditarEmpleado = new JButton();
        chbxEditarD = new JCheckBox();
        chbxEditarL = new JCheckBox();
        chbxEditarM = new JCheckBox();
        chbxEditarMi = new JCheckBox();
        chbxEditarJ = new JCheckBox();
        chbxEditarV = new JCheckBox();
        chbxEditarS = new JCheckBox();
        cbxEditarId = new JComboBox();
        cbxEditarTipo = new JComboBox();
        lbEditarId = new JLabel();
        lbEditarNombre = new JLabel();
        lbEditarApellido = new JLabel();
        lbEditarPuesto = new JLabel();
        lbEditarTipo = new JLabel();
        lbEditarNick = new JLabel();
        lbEditarPassword = new JLabel();
//    listaEmpleados2 = new JList();
        txEditarNombre = new JTextField();
        txEditarApellido = new JTextField();
        txEditarPuesto = new JTextField();
        txEditarNick = new JTextField();
        txEditarPassword = new JTextField();

        pEditarEmpleado.setLayout(null);
        pEditarEmpleado.setVisible(false);

        bRegresar3.setText("Regresar");
        bRegresar3.setBounds(20, 25, 100, 30);
        bRegresar3.addActionListener((ActionListener) this);
        pEditarEmpleado.add(bRegresar3);

        lbEditarId.setText("Id: ");
        lbEditarId.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarId.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarId);
        lbEditarId.setBounds(30, 75, 100, 25);
        pEditarEmpleado.add(cbxEditarId);
        cbxEditarId.setBounds(135, 75, 130, 20);

        /*Empleado comboEditar = listadoEmpleado.getInicial().getValor();//agrega los id al combo
        for (int i = 0; i < listadoEmpleado.count; i++) {
            comboEditar = listadoEmpleado.getActual().getValor();
            cbxEditarId.addItem(comboEditar.getId());
            listadoEmpleado.Avanzar();
        }*/
        cbxEditarId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Empleado indiceComboEditar = listadoEmpleado.getInicial().getValor();
                for (int i = 0; i < listadoEmpleado.getCount(); i++) {
                    indiceComboEditar = listadoEmpleado.getActual().getValor();
                    if (Integer.parseInt(cbxEditarId.getSelectedItem().toString()) == indiceComboEditar.getId()) {
                        txEditarNombre.setText(listadoEmpleado.getActual().getValor().getNombre());
                        txEditarApellido.setText(listadoEmpleado.getActual().getValor().getApellido());
                        txEditarPuesto.setText(listadoEmpleado.getActual().getValor().getPuesto());

                        String tipoEditar;
                        if (listadoEmpleado.getActual().getValor().getTipousuario() == 1) {
                            tipoEditar = "Administrador";
                        } else {
                            tipoEditar = "Empleado";
                        }
                        cbxEditarTipo.setSelectedItem(tipoEditar);
                        txEditarNick.setText(listadoEmpleado.getActual().getValor().getNick());
                        txEditarPassword.setText(listadoEmpleado.getActual().getValor().getPassword());

                        if (listadoEmpleado.getActual().getValor().isD()) {
                            chbxEditarD.setSelected(true);
                        } else {
                            chbxEditarD.setSelected(false);
                        }
                        if (listadoEmpleado.getActual().getValor().isL()) {
                            chbxEditarL.setSelected(true);
                        } else {
                            chbxEditarL.setSelected(false);
                        }
                        if (listadoEmpleado.getActual().getValor().isM()) {
                            chbxEditarM.setSelected(true);
                        } else {
                            chbxEditarM.setSelected(false);
                        }
                        if (listadoEmpleado.getActual().getValor().isMi()) {
                            chbxEditarMi.setSelected(true);
                        } else {
                            chbxEditarMi.setSelected(false);
                        }
                        if (listadoEmpleado.getActual().getValor().isJ()) {
                            chbxEditarJ.setSelected(true);
                        } else {
                            chbxEditarJ.setSelected(false);
                        }
                        if (listadoEmpleado.getActual().getValor().isV()) {
                            chbxEditarV.setSelected(true);
                        } else {
                            chbxEditarV.setSelected(false);
                        }
                        if (listadoEmpleado.getActual().getValor().isS()) {
                            chbxEditarS.setSelected(true);
                        } else {
                            chbxEditarS.setSelected(false);
                        }
                    }
                    listadoEmpleado.Avanzar();
                }
            }
        });

        lbEditarNombre.setText("Nombre: ");
        lbEditarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarNombre.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarNombre);
        lbEditarNombre.setBounds(30, 100, 100, 25);
        pEditarEmpleado.add(txEditarNombre);
        txEditarNombre.setBounds(135, 100, 130, 20);

        lbEditarApellido.setText("Apellido: ");
        lbEditarApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarApellido.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarApellido);
        lbEditarApellido.setBounds(30, 125, 100, 25);
        pEditarEmpleado.add(txEditarApellido);
        txEditarApellido.setBounds(135, 125, 130, 20);

        lbEditarPuesto.setText("Puesto: ");
        lbEditarPuesto.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarPuesto.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarPuesto);
        lbEditarPuesto.setBounds(30, 150, 100, 25);
        pEditarEmpleado.add(txEditarPuesto);
        txEditarPuesto.setBounds(135, 150, 130, 20);

        lbEditarTipo.setText("Tipo Empleado: ");
        lbEditarTipo.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTipo.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarTipo);
        lbEditarTipo.setBounds(20, 175, 110, 25);
        pEditarEmpleado.add(cbxEditarTipo);
        cbxEditarTipo.setBounds(135, 175, 130, 20);
        cbxEditarTipo.addItem("Administrador");
        cbxEditarTipo.addItem("Empleado");

        lbEditarNick.setText("Nick: ");
        lbEditarNick.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarNick.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarNick);
        lbEditarNick.setBounds(30, 200, 100, 25);
        pEditarEmpleado.add(txEditarNick);
        txEditarNick.setBounds(135, 200, 130, 20);

        lbEditarPassword.setText("Password: ");
        lbEditarPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarPassword.setFont(subtitulo);
        pEditarEmpleado.add(lbEditarPassword);
        lbEditarPassword.setBounds(30, 225, 100, 25);
        pEditarEmpleado.add(txEditarPassword);
        txEditarPassword.setBounds(135, 225, 130, 20);

        chbxEditarD.setText("Dom");
        pEditarEmpleado.add(chbxEditarD);
        chbxEditarD.setBounds(50, 275, 55, 25);

        chbxEditarL.setText("Lun");
        pEditarEmpleado.add(chbxEditarL);
        chbxEditarL.setBounds(110, 275, 55, 25);

        chbxEditarM.setText("Mar");
        pEditarEmpleado.add(chbxEditarM);
        chbxEditarM.setBounds(170, 275, 55, 25);

        chbxEditarMi.setText("Mie");
        pEditarEmpleado.add(chbxEditarMi);
        chbxEditarMi.setBounds(230, 275, 55, 25);

        chbxEditarJ.setText("Jue");
        pEditarEmpleado.add(chbxEditarJ);
        chbxEditarJ.setBounds(50, 300, 55, 25);

        chbxEditarV.setText("Vie");
        pEditarEmpleado.add(chbxEditarV);
        chbxEditarV.setBounds(110, 300, 55, 25);

        chbxEditarS.setText("Sab");
        pEditarEmpleado.add(chbxEditarS);
        chbxEditarS.setBounds(170, 300, 55, 25);

        bEditarEmpleado.setText("Editar");
        bEditarEmpleado.setBounds(325, 150, 100, 25);
        bEditarEmpleado.addActionListener((ActionListener) this);
        pEditarEmpleado.add(bEditarEmpleado);

//Panel: Crear Nueva tarea
        listadoTareas = new Lista();
        pCrearTarea = new JPanel();
        bRegresar4 = new JButton();
        bCrearTarea = new JButton();
        cbxCrearTareaEmpleado = new JComboBox();
        dcCrearTareaFechaI = new JDateChooser();
        lbCrearTareaNombre = new JLabel();
        lbCrearTareaDesc = new JLabel();
        lbCrearTareaFechaI = new JLabel();
        lbCrearTareaDuracion = new JLabel();
        lbCrearTareaEmpleado = new JLabel();
        listaTareas1 = new JList();
        snCrearTareaDuracion = new JSpinner();
        txCrearTareaNombre = new JTextField();
        txCrearTareaDesc = new JTextField();
//    txCrearTareaDuracion = new JTextField ();

        pCrearTarea.setLayout(null);
        pCrearTarea.setVisible(false);

        bRegresar4.setText("Regresar");
        bRegresar4.setBounds(20, 25, 100, 30);
        bRegresar4.addActionListener((ActionListener) this);
        pCrearTarea.add(bRegresar4);

        lbCrearTareaNombre.setText("Nombre de la tarea: ");
        lbCrearTareaNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lbCrearTareaNombre.setFont(subtitulo);
        pCrearTarea.add(lbCrearTareaNombre);
        lbCrearTareaNombre.setBounds(30, 75, 175, 25);
        pCrearTarea.add(txCrearTareaNombre);
        txCrearTareaNombre.setBounds(50, 100, 215, 20);

        lbCrearTareaDesc.setText("Desc de la tarea: ");
        lbCrearTareaDesc.setHorizontalAlignment(SwingConstants.RIGHT);
        lbCrearTareaDesc.setFont(subtitulo);
        pCrearTarea.add(lbCrearTareaDesc);
        lbCrearTareaDesc.setBounds(30, 125, 175, 25);
        pCrearTarea.add(txCrearTareaDesc);
        txCrearTareaDesc.setBounds(50, 150, 215, 70);

        lbCrearTareaFechaI.setText("Fecha Inicio: ");
        lbCrearTareaFechaI.setHorizontalAlignment(SwingConstants.RIGHT);
        lbCrearTareaFechaI.setFont(subtitulo);
        pCrearTarea.add(lbCrearTareaFechaI);
        lbCrearTareaFechaI.setBounds(30, 225, 100, 25);
        pCrearTarea.add(dcCrearTareaFechaI);
        dcCrearTareaFechaI.setBounds(135, 225, 130, 20);

        lbCrearTareaDuracion.setText("Duracion: ");
        lbCrearTareaDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
        lbCrearTareaDuracion.setFont(subtitulo);
        pCrearTarea.add(lbCrearTareaDuracion);
        lbCrearTareaDuracion.setBounds(30, 250, 100, 25);
        pCrearTarea.add(snCrearTareaDuracion);
        snCrearTareaDuracion.setBounds(135, 250, 130, 20);

        lbCrearTareaEmpleado.setText("Empleado: ");
        lbCrearTareaEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        lbCrearTareaEmpleado.setFont(subtitulo);
        pCrearTarea.add(lbCrearTareaEmpleado);
        lbCrearTareaEmpleado.setBounds(20, 275, 110, 25);
        pCrearTarea.add(cbxCrearTareaEmpleado);
        cbxCrearTareaEmpleado.setBounds(135, 275, 130, 20);
        cbxCrearTareaEmpleado.addItem("Sin Asignar");
        
        Empleado comboCrearTareaEmpleado = listadoEmpleado.getInicial().getValor();//agrega los empleados al combo        
        for (int i = 0; i < listadoEmpleado.count; i++) {
            comboCrearTareaEmpleado = listadoEmpleado.getActual().getValor();
            cbxCrearTareaEmpleado.addItem(comboCrearTareaEmpleado);
            listadoEmpleado.Avanzar();
        }

        listaTareas1.setModel(modeloCrearTarea);
        listaTareas1.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JList
        pCrearTarea.add(listaTareas1);

        listaTareas1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {// Cuenta la cantidad de clicks para saber si es doble                        
                    mostrarTarea();                                                                                                    
                }
            }
        });

        barraCrearTarea = new JScrollPane(listaTareas1);
        barraCrearTarea.setBounds(300, 100, 150, 150);
        pCrearTarea.add(barraCrearTarea);

        bCrearTarea.setText("Crear");
        bCrearTarea.setBounds(325, 275, 100, 25);
        bCrearTarea.addActionListener((ActionListener) this);
        pCrearTarea.add(bCrearTarea);


//Panel: editar tarea            
            
        pEditarTarea1 = new JPanel();
        bRegresar5 = new JButton();
        bEditarTarea = new JButton();
        bDetallesEditarTarea = new JButton();
        cbxEditarTarea = new JComboBox();
        cbxEditarTareaEmpleado = new JComboBox();
            
        lbEditarTareaNombre1 = new JLabel();
        lbEditarTareaDesc1 = new JLabel();
        lbEditarTareaFechaI1 = new JLabel();
        lbEditarTareaDuracion1 = new JLabel();
        lbEditarTareaFechaF1 = new JLabel();
        lbEditarTareaPorcentaje1 = new JLabel();
        lbEditarTareaEmpleado = new JLabel();        
        lbEditarTareaEmpleado2 = new JLabel();        
        lbEditarTareaEmpleado3 = new JLabel();        
                
            lbEditarTareaNombre2 = new JLabel();
            lbEditarTareaDesc2 = new JLabel();
            lbEditarTareaFechaI2 = new JLabel();
            lbEditarTareaDuracion2 = new JLabel();
            lbEditarTareaFechaF2 = new JLabel();
            lbEditarTareaPorcentaje2 = new JLabel();

        
        pEditarTarea1.setLayout(null);
        pEditarTarea1.setVisible(false);

        bRegresar5.setText("Regresar");
        bRegresar5.setBounds(20, 25, 100, 30);
        bRegresar5.addActionListener((ActionListener) this);
        pEditarTarea1.add(bRegresar5);

        bDetallesEditarTarea.setText("Detalles");
        bDetallesEditarTarea.setBounds(350, 35, 100, 25);
        bDetallesEditarTarea.addActionListener((ActionListener) this);
        pEditarTarea1.add(bDetallesEditarTarea);

        lbEditarTareaNombre1.setText("Tarea: ");
        lbEditarTareaNombre1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaNombre1.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaNombre1);
        lbEditarTareaNombre1.setBounds(50, 75, 75, 25);
                pEditarTarea1.add(cbxEditarTarea);
                cbxEditarTarea.setBounds(150, 75, 275, 25);
                
        lbEditarTareaDesc1.setText("Descripcion: ");
        lbEditarTareaDesc1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaDesc1.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaDesc1);
        lbEditarTareaDesc1.setBounds(30, 100, 90, 25);                        
            lbEditarTareaDesc2.setText("");
            lbEditarTareaDesc2.setHorizontalAlignment(SwingConstants.CENTER);            
            lbEditarTareaDesc2.setFont(subtitulo);
            pEditarTarea1.add(lbEditarTareaDesc2);
            lbEditarTareaDesc2.setBounds(10, 125, 480, 25);

        lbEditarTareaFechaI1.setText("Fecha Inicio: ");
        lbEditarTareaFechaI1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaFechaI1.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaFechaI1);
        lbEditarTareaFechaI1.setBounds(30, 175, 100, 25);
            lbEditarTareaFechaI2.setText("Fecha Inicio: ");
            lbEditarTareaFechaI2.setFont(subtitulo);
            pEditarTarea1.add(lbEditarTareaFechaI2);
            lbEditarTareaFechaI2.setBounds(150, 175, 100, 25);
        
        
        lbEditarTareaDuracion1.setText("Duracion: ");
        lbEditarTareaDuracion1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaDuracion1.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaDuracion1);
        lbEditarTareaDuracion1.setBounds(30, 200, 100, 25);
            lbEditarTareaDuracion2.setText("");
            lbEditarTareaDuracion2.setFont(subtitulo);
            pEditarTarea1.add(lbEditarTareaDuracion2);
            lbEditarTareaDuracion2.setBounds(150, 200, 100, 25);

        lbEditarTareaFechaF1.setText("Fecha Fin: ");
        lbEditarTareaFechaF1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaFechaF1.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaFechaF1);
        lbEditarTareaFechaF1.setBounds(30, 225, 100, 25);
            lbEditarTareaFechaF2.setText("Fecha Fin ");
            lbEditarTareaFechaF2.setFont(subtitulo);
            pEditarTarea1.add(lbEditarTareaFechaF2);
            lbEditarTareaFechaF2.setBounds(150, 225, 100, 25);

        lbEditarTareaPorcentaje1.setText("Avance: ");
        lbEditarTareaPorcentaje1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaPorcentaje1.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaPorcentaje1);
        lbEditarTareaPorcentaje1.setBounds(30, 250, 100, 25);
            lbEditarTareaPorcentaje2.setText("Fecha Fin ");
            lbEditarTareaPorcentaje2.setFont(subtitulo);
            pEditarTarea1.add(lbEditarTareaPorcentaje2);
            lbEditarTareaPorcentaje2.setBounds(150, 250, 100, 25);
        
        lbEditarTareaEmpleado.setText("Empleado actual: ");
        lbEditarTareaEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaEmpleado.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaEmpleado);
        lbEditarTareaEmpleado.setBounds(30, 275, 100, 25);
            lbEditarTareaEmpleado2.setText("");
            lbEditarTareaEmpleado2.setFont(subtitulo);
            pEditarTarea1.add(lbEditarTareaEmpleado2);
            lbEditarTareaEmpleado2.setBounds(150, 275, 100, 25);
        
        
        lbEditarTareaEmpleado3.setText("Nuevo Empleado: ");
        lbEditarTareaEmpleado3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEditarTareaEmpleado3.setFont(subtitulo);
        pEditarTarea1.add(lbEditarTareaEmpleado3);
        lbEditarTareaEmpleado3.setBounds(20, 300, 110, 25);
            pEditarTarea1.add(cbxEditarTareaEmpleado);
            cbxEditarTareaEmpleado.setBounds(150, 300, 130, 20);
            cbxEditarTareaEmpleado.addItem("Sin Asignar");

        Empleado comboEditarTareaEmpleado = listadoEmpleado.getInicial().getValor();//agrega los empleados al combo        
        for (int i = 0; i < listadoEmpleado.count; i++) {
            comboEditarTareaEmpleado = listadoEmpleado.getActual().getValor();
            cbxEditarTareaEmpleado.addItem(comboEditarTareaEmpleado);
            listadoEmpleado.Avanzar();
        }

        bDetallesEditarTarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String abc= String.valueOf(cbxEditarTarea.getSelectedItem());
                for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
                    
                    Tarea indicet =(Tarea)modeloCrearTarea.getElementAt(i);
                    if (abc.contains(indicet.getNombreTarea())){
                    String sfi=new SimpleDateFormat("dd-MM-yyyy").format(indicet.getFechaI());
                    String sff=new SimpleDateFormat("dd-MM-yyyy").format(indicet.getFechaF());
                    
                    lbEditarTareaDesc2.setText(indicet.getDescTarea());
                    lbEditarTareaFechaI2.setText(sfi);
                    lbEditarTareaDuracion2.setText(String.valueOf(indicet.getDuracion()));
                    lbEditarTareaFechaF2.setText(sff);
                    lbEditarTareaPorcentaje2.setText(indicet.getPorcentaje()+" %");
                    lbEditarTareaEmpleado2.setText(indicet.getEmpleadoTarea());
                    
                    }
                }
            }
        });
                
        bEditarTarea.setText("Editar");
        bEditarTarea.setBounds(325, 200, 100, 25);
        bEditarTarea.addActionListener((ActionListener) this);
        pEditarTarea1.add(bEditarTarea);
            

//panel PDF administrador
//-------------------
        pReporteTarea = new JPanel();
        pReporteTarea.setLayout(null);
        pReporteTarea.setVisible(false);

        bpdfSinAsignar = new JButton();
        bpdfFinalizadas = new JButton();
        bpdfEmpleado = new JButton();
        bpdfPorcentaje = new JButton();
        bRegresarPDF = new JButton();
        cbxpdfEmpleado = new JComboBox();
        txpdfPorcentaje = new JTextField();                
        
        lbTareasFinalizadas = new JLabel();
        lbTareasSinAsignar = new JLabel();
        lbTareasPorEmpleado = new JLabel();
        lbTareasPorcentaje = new JLabel();       
        lbTituloPDF = new JLabel();                
        
        bRegresarPDF.setText("Regresar");
        bRegresarPDF.setBounds(20, 25, 100, 30);
        bRegresarPDF.addActionListener((ActionListener) this);
        pReporteTarea.add(bRegresarPDF);

        lbTituloPDF.setText("Reportes de Tareas");
        lbTituloPDF.setHorizontalAlignment(SwingConstants.CENTER);
        lbTituloPDF.setFont(titulo);
        pReporteTarea.add(lbTituloPDF);
        lbTituloPDF.setBounds(175, 30, 150, 25);                        

        lbTareasSinAsignar.setText("Tareas sin Asignar: tares sin empleado asginado");
        lbTareasSinAsignar.setHorizontalAlignment(SwingConstants.RIGHT);
        lbTareasSinAsignar.setFont(subtitulo);
        pReporteTarea.add(lbTareasSinAsignar);
        lbTareasSinAsignar.setBounds(25, 75, 325, 25);                        
            bpdfSinAsignar.setText("PDF");
            bpdfSinAsignar.setBounds(375, 75, 75, 30);
            bpdfSinAsignar.addActionListener((ActionListener) this);
            pReporteTarea.add(bpdfSinAsignar);

        lbTareasFinalizadas.setText("Tareas Finalizadas: Tareas 100% compleatadas");
        lbTareasFinalizadas.setHorizontalAlignment(SwingConstants.RIGHT);
        lbTareasFinalizadas.setFont(subtitulo);
        pReporteTarea.add(lbTareasFinalizadas);
        lbTareasFinalizadas.setBounds(25, 125, 325, 25);                        
            bpdfFinalizadas.setText("PDF");
            bpdfFinalizadas.setBounds(375, 125, 75, 30);
            bpdfFinalizadas.addActionListener((ActionListener) this);
            pReporteTarea.add(bpdfFinalizadas);

        lbTareasPorEmpleado.setText("Tareas por Empleado:");
        lbTareasPorEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        lbTareasPorEmpleado.setFont(subtitulo);
        pReporteTarea.add(lbTareasPorEmpleado);
        lbTareasPorEmpleado.setBounds(25, 175, 150, 25);
            pReporteTarea.add(cbxpdfEmpleado);
            cbxpdfEmpleado.setBounds(200, 175, 150, 25);
            cbxCrearTareaEmpleado.addItem("Sin Asignar");
                bpdfEmpleado.setText("PDF");
                bpdfEmpleado.setBounds(375, 175, 75, 30);
                bpdfEmpleado.addActionListener((ActionListener) this);
                pReporteTarea.add(bpdfEmpleado);
        
        lbTareasPorcentaje.setText("Porcentaje menor a:");
        lbTareasPorcentaje.setHorizontalAlignment(SwingConstants.RIGHT);
        lbTareasPorcentaje.setFont(subtitulo);
        pReporteTarea.add(lbTareasPorcentaje);
        lbTareasPorcentaje.setBounds(25, 225, 150, 25); 
            txpdfPorcentaje.setText("0");
            txpdfPorcentaje.setFont(subtitulo);
            pReporteTarea.add(txpdfPorcentaje);
            txpdfPorcentaje.setBounds(200, 225, 150, 25);
                bpdfPorcentaje.setText("PDF");
                bpdfPorcentaje.setBounds(375, 225, 75, 30);
                bpdfPorcentaje.addActionListener((ActionListener) this);
                pReporteTarea.add(bpdfPorcentaje);
        
        
        
//*/            

//PANEL menu Empleado: 1
//-------------------
        pEmpleado = new JPanel();
        pEmpleado.setLayout(null);
        pEmpleado.setVisible(false);

        bRegresarEmpleado1 = new JButton();
        bRegresarEmpleado2 = new JButton();
        bRegresarEmpleado3 = new JButton();
        bEmpleadoEditarTarea = new JButton();
        bEmpleadoReportes = new JButton();
        bEditarPorcentaje = new JButton();
        bpdfTareasPendientes = new JButton();

        bRegresarEmpleado1.setText("Regresar");
        bRegresarEmpleado1.setBounds(20, 25, 100, 30);
        bRegresarEmpleado1.addActionListener((ActionListener) this);
        pEmpleado.add(bRegresarEmpleado1);

        bEmpleadoEditarTarea.setText("Editar Tarea");
        bEmpleadoEditarTarea.setBounds(50, 125, 135, 30);
        bEmpleadoEditarTarea.addActionListener((ActionListener) this);
        pEmpleado.add(bEmpleadoEditarTarea);

        bEmpleadoReportes.setText("Reporte Tareas P");
        bEmpleadoReportes.setBounds(50, 175, 135, 30);
        bEmpleadoReportes.addActionListener((ActionListener) this);
        pEmpleado.add(bEmpleadoReportes);


//Panel: editar tarea empleado
            
        pEditarTarea2 = new JPanel();
        bRegresar5 = new JButton();
        bEmpleadoDetalles = new JButton();
        cbxEmpleadoEditarTarea = new JComboBox();

            
        lbEmpleadoEditarTareaNombre1 = new JLabel();
        lbEmpleadoEditarTareaDesc1 = new JLabel();
        lbEmpleadoEditarTareaFechaI1 = new JLabel();
        lbEmpleadoEditarTareaDuracion1 = new JLabel();
        lbEmpleadoEditarTareaFechaF1 = new JLabel();
        lbEmpleadoEditarTareaPorcentaje1 = new JLabel();
        txEmpleadoEditarAvance = new JTextField();
        lbEmpleadoEditarTareaEmpleado = new JLabel();        
        lbEmpleadoEditarTareaEmpleado2 = new JLabel();        
                
            lbEmpleadoEditarTareaNombre2 = new JLabel();
            lbEmpleadoEditarTareaDesc2 = new JLabel();
            lbEmpleadoEditarTareaFechaI2 = new JLabel();
            lbEmpleadoEditarTareaDuracion2 = new JLabel();
            lbEmpleadoEditarTareaFechaF2 = new JLabel();


        
        pEditarTarea2.setLayout(null);
        pEditarTarea2.setVisible(false);

        bRegresar5.setText("Regresar");
        bRegresar5.setBounds(20, 25, 100, 30);
        bRegresar5.addActionListener((ActionListener) this);
        pEditarTarea2.add(bRegresar5);

        bEmpleadoDetalles.setText("Detalles");
        bEmpleadoDetalles.setBounds(350, 35, 100, 25);
        bEmpleadoDetalles.addActionListener((ActionListener) this);
        pEditarTarea2.add(bEmpleadoDetalles);

        lbEmpleadoEditarTareaNombre1.setText("Tarea: ");
        lbEmpleadoEditarTareaNombre1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaNombre1.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaNombre1);
        lbEmpleadoEditarTareaNombre1.setBounds(50, 75, 75, 25);
                pEditarTarea2.add(cbxEmpleadoEditarTarea);
                cbxEmpleadoEditarTarea.setBounds(150, 75, 275, 25);
                
        lbEmpleadoEditarTareaDesc1.setText("Descripcion: ");
        lbEmpleadoEditarTareaDesc1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaDesc1.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaDesc1);
        lbEmpleadoEditarTareaDesc1.setBounds(30, 100, 90, 25);                        
            lbEmpleadoEditarTareaDesc2.setText("");
            lbEmpleadoEditarTareaDesc2.setHorizontalAlignment(SwingConstants.CENTER);            
            lbEmpleadoEditarTareaDesc2.setFont(subtitulo);
            pEditarTarea2.add(lbEmpleadoEditarTareaDesc2);
            lbEmpleadoEditarTareaDesc2.setBounds(10, 125, 480, 25);

        lbEmpleadoEditarTareaFechaI1.setText("Fecha Inicio: ");
        lbEmpleadoEditarTareaFechaI1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaFechaI1.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaFechaI1);
        lbEmpleadoEditarTareaFechaI1.setBounds(30, 175, 100, 25);
            lbEmpleadoEditarTareaFechaI2.setText("dd-MM-aaaa");
            lbEmpleadoEditarTareaFechaI2.setFont(subtitulo);
            pEditarTarea2.add(lbEmpleadoEditarTareaFechaI2);
            lbEmpleadoEditarTareaFechaI2.setBounds(150, 175, 100, 25);
        
        
        lbEmpleadoEditarTareaDuracion1.setText("Duracion: ");
        lbEmpleadoEditarTareaDuracion1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaDuracion1.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaDuracion1);
        lbEmpleadoEditarTareaDuracion1.setBounds(30, 200, 100, 25);
            lbEmpleadoEditarTareaDuracion2.setText("");
            lbEmpleadoEditarTareaDuracion2.setFont(subtitulo);
            pEditarTarea2.add(lbEmpleadoEditarTareaDuracion2);
            lbEmpleadoEditarTareaDuracion2.setBounds(150, 200, 100, 25);

        lbEmpleadoEditarTareaFechaF1.setText("Fecha Fin: ");
        lbEmpleadoEditarTareaFechaF1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaFechaF1.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaFechaF1);
        lbEmpleadoEditarTareaFechaF1.setBounds(30, 225, 100, 25);
            lbEmpleadoEditarTareaFechaF2.setText("dd-MM-aaaa");
            lbEmpleadoEditarTareaFechaF2.setFont(subtitulo);
            pEditarTarea2.add(lbEmpleadoEditarTareaFechaF2);
            lbEmpleadoEditarTareaFechaF2.setBounds(150, 225, 100, 25);

        lbEmpleadoEditarTareaPorcentaje1.setText("Avance: %");
        lbEmpleadoEditarTareaPorcentaje1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaPorcentaje1.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaPorcentaje1);
        lbEmpleadoEditarTareaPorcentaje1.setBounds(30, 250, 100, 25);
            txEmpleadoEditarAvance.setText("0");
            txEmpleadoEditarAvance.setFont(subtitulo);
            pEditarTarea2.add(txEmpleadoEditarAvance);
            txEmpleadoEditarAvance.setBounds(150, 250, 100, 25);
        
        lbEmpleadoEditarTareaEmpleado.setText("Empleado: ");
        lbEmpleadoEditarTareaEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        lbEmpleadoEditarTareaEmpleado.setFont(subtitulo);
        pEditarTarea2.add(lbEmpleadoEditarTareaEmpleado);
        lbEmpleadoEditarTareaEmpleado.setBounds(30, 275, 100, 25);
            lbEmpleadoEditarTareaEmpleado2.setText("");
            lbEmpleadoEditarTareaEmpleado2.setFont(subtitulo);
            pEditarTarea2.add(lbEmpleadoEditarTareaEmpleado2);
            lbEmpleadoEditarTareaEmpleado2.setBounds(150, 275, 100, 25);
        
        
        bEmpleadoDetalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String abc= String.valueOf(cbxEmpleadoEditarTarea.getSelectedItem());
                for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
                    
                    Tarea indicet =(Tarea)modeloCrearTarea.getElementAt(i);
                    if (abc.contains(indicet.getNombreTarea())){
                    String sfi=new SimpleDateFormat("dd-MM-yyyy").format(indicet.getFechaI());
                    String sff=new SimpleDateFormat("dd-MM-yyyy").format(indicet.getFechaF());
                    
                    lbEmpleadoEditarTareaDesc2.setText(indicet.getDescTarea());
                    lbEmpleadoEditarTareaFechaI2.setText(sfi);
                    lbEmpleadoEditarTareaDuracion2.setText(String.valueOf(indicet.getDuracion())+" dias");
                    lbEmpleadoEditarTareaFechaF2.setText(sff);
                    txEmpleadoEditarAvance.setText(String.valueOf(indicet.getPorcentaje()));
                    lbEmpleadoEditarTareaEmpleado2.setText(indicet.getEmpleadoTarea());
                    
                    }
                }
            }
        });
        
        

        bEditarPorcentaje.setText("Editar");
        bEditarPorcentaje.setBounds(325, 200, 100, 25);
        bEditarPorcentaje.addActionListener((ActionListener) this);
        pEditarTarea2.add(bEditarPorcentaje);

            
        //CARGAR LAS TAREAS
        String NombreTarea2,DescTarea2,EmpleadoTarea2,sfechai2,sfechaf2;
            int Duracion2,Porcentaje2;
            Date FechaI2,FechaF2;
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
/*

            NombreTarea2="Papeleo de Ventas";
            DescTarea2="Realizar documentación de las ventas hechas durante el mes";
            EmpleadoTarea2 = "Juan Lopez";
            sfechai2 = "14/08/2017";//dia/mes/año
            sfechaf2="24/08/2017";
            Duracion2 = 10;
            Porcentaje2=100;        
            try {
                FechaI2 = formato2.parse(sfechai2);
                FechaF2 = formato2.parse(sfechaf2);            
                Tarea tarea2 = new Tarea (NombreTarea2,DescTarea2,EmpleadoTarea2,Duracion2,Porcentaje2,FechaI2,FechaF2);
                modeloCrearTarea.addElement(tarea2);
                cbxEditarTarea.addItem(tarea2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
*/
            archivoTarea=new File("C:\\progra\\Tareas2.csv");

            BufferedReader reader2 = null;

            try {
                int linea = 0;
                reader2 = new BufferedReader(new FileReader(archivoTarea));
                String text2 = null;

                while ((text2 = reader2.readLine()) != null) {
                    linea++;
                    if (linea == 1) {
                        continue;
                    }
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String[] valor = text2.split(",");
                    String NombreTarea = valor[0];
                    String DescTarea = valor[1];
                    String EmpleadoTarea = valor[2];
                    int Duracion = Integer.parseInt(valor[3]);
                    int Porcentaje = Integer.parseInt(valor[4]);
			String sfechai=valor[5];
			String sfechaf=valor[6];

                    Date FechaI;
                    Date FechaF;

            try {
                FechaI = formato.parse(sfechai);
                FechaF = formato.parse(sfechaf);            
                Tarea tarea = new Tarea (NombreTarea,DescTarea,EmpleadoTarea,Duracion,Porcentaje,FechaI,FechaF);
                modeloCrearTarea.addElement(tarea);
                cbxEditarTarea.addItem(tarea);
                cbxEmpleadoEditarTarea.addItem(tarea);
            } catch (ParseException e) {
                e.printStackTrace();
            }

                }
                //JOptionPane.showMessageDialog(null, "Datos Cargados");
                System.out.println("Tareas cargadas");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader2 != null) {
                        reader2.close();
                    }
                } catch (IOException e) {
                }
            }

            
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == b1) //    LOGIN 
        {
            String texto, texto2;
            texto = txusuario.getText();
            texto2 = textopassword.getText();
            if ((texto.contains("ROOT"))&&(texto2.contains("201612190")))//si es ROOT muestra el menu exclusivo Super Usuario
        {
            /*getContentPane().add(pSuper);
            pSuper.setVisible(true);
            plogin.setVisible(false);
            */
                        getContentPane().add(pmenu1);
                        pmenu1.setVisible(true);
                        plogin.setVisible(false);
                        

            }

            else//si no es Super usuario, muestra menu de administrador o de Empleado
        {    
            Empleado indice=listadoEmpleado.getInicial().getValor();
            listadoEmpleado.Avanzar();
            for (int i=1; i<listadoEmpleado.getCount();i++)//for i=1
            {                            
                indice = listadoEmpleado.getActual().getValor();
                if ((texto.contains(indice.getNick()))&&(texto2.contains(indice.getPassword())))
                {
                    if(indice.getTipousuario()==1)//si es Administrador, muestra menu1
                    {
                        getContentPane().add(pmenu1);
                        pmenu1.setVisible(true);
                        plogin.setVisible(false);
                        System.out.println("Administrador");
                    }
                    else//si es Empleado, muestra el menu 2
                    {
                        getContentPane().add(pEmpleado);
                        pEmpleado.setVisible(true);
                        plogin.setVisible(false);
                        System.out.println("Empleado");
                    }
                }                      
                listadoEmpleado.Avanzar();
            }
        }
        if (plogin.isVisible())
        {                                        
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto(s)");
        }
        }
        if (evento.getSource() == bRootRegresar) //    REGRESAR de Root a login
        {
            pSuper.setVisible(false);
            plogin.setVisible(true);
        }
        if (evento.getSource() == bRegresarEmpleado1) //    REGRESAR de Root a login
        {
            pEmpleado.setVisible(false);
            plogin.setVisible(true);
        }

        if (evento.getSource() == bCargar) //    Cargar los datos
        {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            archivoEmpleado = chooser.getSelectedFile();

            BufferedReader reader = null;

            try {
                int line = 0;
                reader = new BufferedReader(new FileReader(archivoEmpleado));
                String text = null;

                while ((text = reader.readLine()) != null) {
                    line++;
                    if (line == 1) {
                        continue;
                    }

                    String[] valores = text.split(",");
                    int Id = Integer.parseInt(valores[0]);
                    String Nombre = valores[1];
                    String Apellido = valores[2];
                    String Puesto = valores[3];
                    int Tipo = Integer.parseInt(valores[4]);
                    boolean D = Integer.parseInt(valores[5]) == 1;
                    boolean L = Integer.parseInt(valores[6]) == 1;
                    boolean M = Integer.parseInt(valores[7]) == 1;
                    boolean Mi = Integer.parseInt(valores[8]) == 1;
                    boolean J = Integer.parseInt(valores[9]) == 1;
                    boolean V = Integer.parseInt(valores[10]) == 1;
                    boolean S = Integer.parseInt(valores[11]) == 1;
                    String Nick = valores[12];
                    String Password = valores[13];

                    Empleado CargarEmpleado = new Empleado(Id, Nombre, Apellido, Puesto, Tipo, D, L, M, Mi, J, V, S, Nick, Password);
                    listadoEmpleado.Agregar(CargarEmpleado);
                    modeloAgregar.addElement(CargarEmpleado);
                    cbxEditarId.addItem(CargarEmpleado.getId());
                    cbxCrearTareaEmpleado.addItem(CargarEmpleado);
                    cbxEditarTareaEmpleado.addItem(CargarEmpleado);
                    cbxCrearTareaEmpleado.addItem(CargarEmpleado);
                }
                JOptionPane.showMessageDialog(null, "Datos Cargados");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                }
            }
        }


            
            
        }

        if (evento.getSource() == bEliminar) //    Eliminar los datos
        {

        }

        if (evento.getSource() == b11) //    Carrusel
        {
            getContentPane().add(pcarrusel);
            pmenu1.setVisible(false);
            pcarrusel.setVisible(true);
        }
        if (evento.getSource() == b01) //    REGRESAR
        {
            pmenu1.setVisible(false);
            plogin.setVisible(true);
        }

        if (evento.getSource() == b12) //    Ir a Agregar Empleado
        {
            getContentPane().add(pAddEmpleado);
            pmenu1.setVisible(false);
            pAddEmpleado.setVisible(true);
        }

        if (evento.getSource() == b13) //    Ir a Editarar Empleado
        {
            getContentPane().add(pEditarEmpleado);
            pmenu1.setVisible(false);
            pEditarEmpleado.setVisible(true);
        }

        if (evento.getSource() == b14) //    Ir a Crear Tarea
        {
            getContentPane().add(pCrearTarea);
            pmenu1.setVisible(false);
            pCrearTarea.setVisible(true);
        }
        if (evento.getSource() == b15) //    Ir a editar Tarea
        {
            getContentPane().add(pEditarTarea1);
            pmenu1.setVisible(false);
            pEditarTarea1.setVisible(true);
        }
        if (evento.getSource() == b16) //    Ir a reportes de administrador Tarea
        {
            getContentPane().add(pReporteTarea);
            pmenu1.setVisible(false);
            pReporteTarea.setVisible(true);
        }
        

        if (evento.getSource() == bcRegresar) //    REGRESAR: de carrusel a menu administrador
        {
            pcarrusel.setVisible(false);
            pmenu1.setVisible(true);
        }

        if (evento.getSource() == bRegresar2) //    REGRESAR: de Agregar empleado a menu administrador
        {
            pAddEmpleado.setVisible(false);
            pmenu1.setVisible(true);
        }

        if (evento.getSource() == bRegresar3) //    REGRESAR: de Editar empleado a menu administrador
        {
            pEditarEmpleado.setVisible(false);
            pmenu1.setVisible(true);
        }

        if (evento.getSource() == bRegresar4) //    REGRESAR: de Crear Tarea a menu administrador
        {
            pCrearTarea.setVisible(false);
            pmenu1.setVisible(true);
        }

        if (evento.getSource() == bRegresar5) //    REGRESAR: de Editar tarea a menu administrador
        {
            pEditarTarea1.setVisible(false);
            pmenu1.setVisible(true);
        }

        if (evento.getSource() == bsiguiente) //    Carrusel anterior
        {
            listadoEmpleado.Avanzar();
            cnombre2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getNombre()));
            capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));
            cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));
            if (listadoEmpleado.getActual().getValor().isD()) {
                dom.setText("X");
            } else {
                dom.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isL()) {
                lun.setText("X");
            } else {
                lun.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isM()) {
                mar.setText("X");
            } else {
                mar.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isMi()) {
                mie.setText("X");
            } else {
                mie.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isJ()) {
                jue.setText("X");
            } else {
                jue.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isV()) {
                vie.setText("X");
            } else {
                vie.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isS()) {
                sab.setText("X");
            } else {
                sab.setText("");
            }

        }
        if (evento.getSource() == banterior) //    Carrusel siguietne
        {
            listadoEmpleado.Retroceder();
            cnombre2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getNombre()));
            capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));
            cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));
            if (listadoEmpleado.getActual().getValor().isD()) {
                dom.setText("X");
            } else {
                dom.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isL()) {
                lun.setText("X");
            } else {
                lun.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isM()) {
                mar.setText("X");
            } else {
                mar.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isMi()) {
                mie.setText("X");
            } else {
                mie.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isJ()) {
                jue.setText("X");
            } else {
                jue.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isV()) {
                vie.setText("X");
            } else {
                vie.setText("");
            }
            if (listadoEmpleado.getActual().getValor().isS()) {
                sab.setText("X");
            } else {
                sab.setText("");
            }
        }

        if (evento.getSource() == bAgregarEmpleado) //    Agregar un empleado nuevo
        {
            AgregarEmpleado();
        }

        if (evento.getSource() == bEditarEmpleado) //    Editar los datos de un empleado
        {
            EditarEmpleado();
        }

        if (evento.getSource() == bCrearTarea) //    CrearTarea
        {
            CrearTarea();
        }
        if (evento.getSource() == bEditarTarea) //    Editar tArea
        {
            EditarTareaA();
        }
            
            if (evento.getSource() == bpdfSinAsignar) //PDF tareas sin asignar
            {
                PDFsinAsignar();
            }
            if (evento.getSource() == bpdfEmpleado) //PDF tareas sin asignar
            {
                PDFtareaEmpleado();
            }
            if (evento.getSource() == bpdfFinalizadas) //PDF tareas sin asignar
            {
                PDFfinalizadas();
            }
            if (evento.getSource() == bpdfPorcentaje) //PDF tareas sin asignar
            {
                PDFporcentaje();
            }
        
        
        if (evento.getSource() == bEmpleadoEditarTarea) //    EMPLEADO: Editar tarea
        {
            getContentPane().add(pEditarTarea2);
            pEmpleado.setVisible(false);
            pEditarTarea2.setVisible(true);
        }
        
        if (evento.getSource() == bEditarPorcentaje) //    Editar porcentaje
        {
            EditarTareaE();
        }
        if (evento.getSource() == bRegresar5) //    regresar de editar porcentaje al menu epleado
        {
            pEditarTarea2.setVisible(false);
            pEmpleado.setVisible(true);
        }

                if (evento.getSource()==bEmpleadoReportes)//generar pdf
		{			
            
                    pdf1= new JFileChooser();
                    int op=pdf1.showSaveDialog(this);

                    if (op == JFileChooser.APPROVE_OPTION)
                    {            
                        File f = pdf1.getSelectedFile();
                        //t411.setText(f.toString());
                        String ruta = f.toString();
                        try {
                            FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
                            Document doc = new Document();
                            PdfWriter.getInstance(doc, archivo);
                            doc.open();

                            String conte="TAREAS PENDIENTES\n";
                            doc.add(new Paragraph(conte));
                            int size = modeloCrearTarea.size();
                            for (int i = 0; i < size; i++) {

                                Tarea tarea = (Tarea)modeloCrearTarea.getElementAt(i);

                                String finicio = "";
                                String ffinal="";

                                finicio=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaI());
                                ffinal=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaF());
                                
                                String contenido="Tarea" + "  |  "+ tarea.getNombreTarea()+"   \n"
                                        +"          Descripción: \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+tarea.getDescTarea()+"\n"
                                        +"          Fecha de Inicio: "+finicio+"\n"
                                        +"          Duracion: "+tarea.getDuracion()+" dias\n"
                                        +"          Fecha de Finalización: "+ffinal+"\n"
                                        +"          Empleado asignado: "+tarea.getEmpleadoTarea()+"\n"
                                        +"          Avance: "+tarea.getPorcentaje()+" % \n\n";
                                
                                if(tarea.getPorcentaje()<100){
                                doc.add(new Paragraph(contenido));}
                            }

                            doc.close();
                            JOptionPane.showMessageDialog(null,"PDF Creado exitosamente");

                        } catch (Exception e) {
                        }
                    }
                }
        
        
        
    }

    private void mostrarEmpleado() {
        int index = listaEmpleados1.getSelectedIndex();
        Empleado emp = (Empleado) modeloAgregar.getElementAt(index);
        String tipo = "";
        String dd, dl, dm, dmi, dj, dv, ds;

        if (emp.getTipousuario() == 1) {
            tipo = "Administrador";
        }
        if (emp.getTipousuario() == 2) {
            tipo = "Adminisdor";
        }

        if (emp.isD()) {
            dd = "D, ";
        } else {
            dd = "";
        }
        if (emp.isL()) {
            dl = "L, ";
        } else {
            dl = "";
        }
        if (emp.isM()) {
            dm = "M, ";
        } else {
            dm = "";
        }
        if (emp.isMi()) {
            dmi = "Mi, ";
        } else {
            dmi = "";
        }
        if (emp.isJ()) {
            dj = "J, ";
        } else {
            dj = "";
        }
        if (emp.isV()) {
            dv = "V, ";
        } else {
            dv = "";
        }
        if (emp.isS()) {
            ds = "S, ";
        } else {
            ds = "";
        }

        String dias = dd + dl + dm + dmi + dj + dv + ds;

        JOptionPane.showMessageDialog(null, "Id: " + emp.getId() + "\n"
                + "Nombre: " + emp.getNombre() + " " + emp.getApellido() + "\n"
                + "Puesto: " + emp.getPuesto() + "\n"
                + "Tipo: " + tipo + "\n"
                + "Nick: " + emp.getNick() + "\n"
                + "Password: " + emp.getPassword() + "\n"
                + "Dias Laborales: " + dias + "\n", "Información de ususario", JOptionPane.DEFAULT_OPTION);
//      JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION);                        
    }

    private void AgregarEmpleado() {
        int Id;
        String nombre, apellido, puesto;
        int tipousuario;
        boolean d, l, m, mi, j, v, s;
        String nick, password;

        String tipo1 = String.valueOf(cbxaddTipo.getSelectedItem());

        Id = Integer.parseInt(txaddId.getText());
        nombre = txaddNombre.getText();
        apellido = txaddApellido.getText();
        puesto = txaddPuesto.getText();
        if (tipo1 == "Administrador") {
            tipousuario = 1;
        } else {
            tipousuario = 2;
        }
        nick = txaddNick.getText();
        password = txaddPassword.getText();
        d = chbxaddD.isSelected();
        l = chbxaddL.isSelected();
        m = chbxaddM.isSelected();
        mi = chbxaddMi.isSelected();
        j = chbxaddJ.isSelected();
        v = chbxaddV.isSelected();
        s = chbxaddS.isSelected();

        String textoNick = txaddNick.getText();
        int textoId = Integer.parseInt(txaddId.getText());

        int error = 0;
        Empleado indice = listadoEmpleado.getInicial().getValor();

        for (int i = 0; i < listadoEmpleado.getCount(); i++) {
            indice = listadoEmpleado.getActual().getValor();
            if ((textoNick.contains(indice.getNick())) || (textoId == indice.getId())) {
                error = error + 1;
            }
            listadoEmpleado.Avanzar();
        }

        if (error != 0) {
            JOptionPane.showMessageDialog(null, "Uusario ya existente", "Error", JOptionPane.DEFAULT_OPTION);
        } else {
            Empleado nuevoEmpleado = new Empleado(Id, nombre, apellido, puesto, tipousuario, d, l, m, mi, j, v, s, nick, password);
            listadoEmpleado.Agregar(nuevoEmpleado);
            modeloAgregar.addElement(nuevoEmpleado);
            cbxEditarId.addItem(nuevoEmpleado.getId());
            cbxCrearTareaEmpleado.addItem(nuevoEmpleado);
            cbxCrearTareaEmpleado.addItem(nuevoEmpleado);
            BufferedWriter output = null;
            try {

                output = new BufferedWriter(new FileWriter(archivoEmpleado, false));//false sobre escribe el archivo
                output.write("Id,nombre,apellido,puesto,tipousuario,d,l,m,mi,j,v,s,nick,contraseña\n");                
                
                Empleado indice2 = listadoEmpleado.getInicial().getValor();
                listadoEmpleado.Avanzar();
                for (int i = 1; i < listadoEmpleado.getCount(); i++) {
                            indice2 = listadoEmpleado.getActual().getValor();
                            //String der = String.valueOf(indice2.getId());
                            int indice2D,indice2L,indice2M,indice2Mi,indice2J,indice2V,indice2S;
                            
                            if (indice2.isD()){indice2D=1;} else {indice2D=0;}
                            if (indice2.isL()){indice2L=1;} else {indice2L=0;}
                            if (indice2.isM()){indice2M=1;} else {indice2M=0;}
                            if (indice2.isMi()){indice2Mi=1;} else {indice2Mi=0;}
                            if (indice2.isJ()){indice2J=1;} else {indice2J=0;}
                            if (indice2.isV()){indice2V=1;} else {indice2V=0;}
                            if (indice2.isS()){indice2S=1;} else {indice2S=0;}
                            
                            output.write(indice2.getId()+","+
                            indice2.getNombre()+","+
                            indice2.getApellido()+","+
                            indice2.getPuesto()+","+
                            indice2.getTipousuario()+","+
                            indice2D+","+
                            indice2L+","+
                            indice2M+","+
                            indice2Mi+","+
                            indice2J+","+
                            indice2V+","+
                            indice2S+","+
                            indice2.getNick()+","+
                            indice2.getPassword()+"\n");//+"\n"
                listadoEmpleado.Avanzar();
                }
                
                //metodo para llenar
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Empleado agregado existosamente", "Agregar Empleado", JOptionPane.DEFAULT_OPTION);
        }
//      JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION);                        
    }

    private void EditarEmpleado() {
        Empleado indiceEditar = listadoEmpleado.getInicial().getValor();
        for (int i = 0; i < listadoEmpleado.getCount(); i++) {
            indiceEditar = listadoEmpleado.getActual().getValor();
            if (Integer.parseInt(cbxEditarId.getSelectedItem().toString()) == indiceEditar.getId()) {
                listadoEmpleado.getActual().getValor().setNombre(txEditarNombre.getText());
                listadoEmpleado.getActual().getValor().setApellido(txEditarApellido.getText());
                listadoEmpleado.getActual().getValor().setPuesto(txEditarPuesto.getText());
                if (cbxEditarTipo.getSelectedItem() == "Administrador") {
                    listadoEmpleado.getActual().getValor().setTipousuario(1);
                } else {
                    listadoEmpleado.getActual().getValor().setTipousuario(2);
                }
                listadoEmpleado.getActual().getValor().setNick(txEditarNick.getText());
                listadoEmpleado.getActual().getValor().setPassword(txEditarPassword.getText());

                if (chbxEditarD.isSelected()) {
                    listadoEmpleado.getActual().getValor().setD(true);
                } else {
                    listadoEmpleado.getActual().getValor().setD(false);
                }
                if (chbxEditarL.isSelected()) {
                    listadoEmpleado.getActual().getValor().setL(true);
                } else {
                    listadoEmpleado.getActual().getValor().setL(false);
                }
                if (chbxEditarM.isSelected()) {
                    listadoEmpleado.getActual().getValor().setM(true);
                } else {
                    listadoEmpleado.getActual().getValor().setM(false);
                }
                if (chbxEditarMi.isSelected()) {
                    listadoEmpleado.getActual().getValor().setMi(true);
                } else {
                    listadoEmpleado.getActual().getValor().setMi(false);
                }
                if (chbxEditarJ.isSelected()) {
                    listadoEmpleado.getActual().getValor().setJ(true);
                } else {
                    listadoEmpleado.getActual().getValor().setJ(false);
                }
                if (chbxEditarV.isSelected()) {
                    listadoEmpleado.getActual().getValor().setV(true);
                } else {
                    listadoEmpleado.getActual().getValor().setV(false);
                }
                if (chbxEditarS.isSelected()) {
                    listadoEmpleado.getActual().getValor().setS(true);
                } else {
                    listadoEmpleado.getActual().getValor().setS(false);
                }
            }
            listadoEmpleado.Avanzar();
        }

            BufferedWriter output = null;
            try {

                output = new BufferedWriter(new FileWriter(archivoEmpleado, false));//false sobre escribe el archivo
                output.write("Id,nombre,apellido,puesto,tipousuario,d,l,m,mi,j,v,s,nick,contraseña\n");                
                
                Empleado indice3 = listadoEmpleado.getInicial().getValor();
                listadoEmpleado.Avanzar();
                for (int i = 1; i < listadoEmpleado.getCount(); i++) {
                            indice3 = listadoEmpleado.getActual().getValor();
                            //String der = String.valueOf(indice3.getId());
                            int indice3D,indice3L,indice3M,indice3Mi,indice3J,indice3V,indice3S;
                            
                            if (indice3.isD()){indice3D=1;} else {indice3D=0;}
                            if (indice3.isL()){indice3L=1;} else {indice3L=0;}
                            if (indice3.isM()){indice3M=1;} else {indice3M=0;}
                            if (indice3.isMi()){indice3Mi=1;} else {indice3Mi=0;}
                            if (indice3.isJ()){indice3J=1;} else {indice3J=0;}
                            if (indice3.isV()){indice3V=1;} else {indice3V=0;}
                            if (indice3.isS()){indice3S=1;} else {indice3S=0;}
                            
                            output.write(indice3.getId()+","+
                            indice3.getNombre()+","+
                            indice3.getApellido()+","+
                            indice3.getPuesto()+","+
                            indice3.getTipousuario()+","+
                            indice3D+","+
                            indice3L+","+
                            indice3M+","+
                            indice3Mi+","+
                            indice3J+","+
                            indice3V+","+
                            indice3S+","+
                            indice3.getNick()+","+
                            indice3.getPassword()+"\n");//+"\n"
                listadoEmpleado.Avanzar();
                }
                
                //metodo para llenar
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }


        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Editar Empleado", JOptionPane.DEFAULT_OPTION);
    }

    private void CrearTarea() {
        String NombreTarea, DescTarea, EmpleadoTarea;
        int Duracion, Porcentaje;
        Date FechaI,FechaF;
        Calendar fechainicio=Calendar.getInstance();

        NombreTarea = txCrearTareaNombre.getText();
        DescTarea = txCrearTareaDesc.getText();
        EmpleadoTarea = String.valueOf(cbxCrearTareaEmpleado.getSelectedItem());
        Duracion = Integer.parseInt(String.valueOf(snCrearTareaDuracion.getValue()));
        Porcentaje = 0;
        FechaI=dcCrearTareaFechaI.getDate();
        fechainicio.setTime(FechaI);
        fechainicio.add(Calendar.DATE,Duracion);
        FechaF=fechainicio.getTime();
        //System.out.print(FechaF);
        Tarea nuevaTarea = new Tarea(NombreTarea, DescTarea, EmpleadoTarea, Duracion, Porcentaje, FechaI, FechaF);

        modeloCrearTarea.addElement(nuevaTarea);
        cbxEditarTarea.addItem(nuevaTarea);
        cbxEmpleadoEditarTarea.addItem(nuevaTarea);

        BufferedWriter output = null;
            try {

                output = new BufferedWriter(new FileWriter(archivoTarea, false));//false sobre escribe el archivo
                output.write("NombreTarea,Descripcion,Empleado,Duración,Porcentaje,FechaInicio,FechaFin\n");                
                
                for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
                    Tarea index2 =(Tarea)modeloCrearTarea.getElementAt(i);
                    String fi = "";
                    String ff="";

                fi=new SimpleDateFormat("dd/MM/yyyy").format(index2.getFechaI());
                ff=new SimpleDateFormat("dd/MM/yyyy").format(index2.getFechaF());



                    output.write(index2.getNombreTarea()+","+
                            index2.getDescTarea()+","+
                            index2.getEmpleadoTarea()+","+
                            index2.getDuracion()+","+
                            index2.getPorcentaje()+","+                            
                            fi+","+
                            ff+"\n");//+"\n"                                        
                }                
                                                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }        
        
        JOptionPane.showMessageDialog(null, "Tarea agregada existosamente", "Agregar Tarea", JOptionPane.DEFAULT_OPTION);
    }
    
    private void mostrarTarea() {
        int index = listaTareas1.getSelectedIndex();
        Tarea tar = (Tarea) modeloCrearTarea.getElementAt(index);
        String finicio = "";
        String ffinal="";

        finicio=new SimpleDateFormat("dd-MM-yyyy").format(tar.getFechaI());
        ffinal=new SimpleDateFormat("dd-MM-yyyy").format(tar.getFechaF());
        
        
        JOptionPane.showMessageDialog(null, "Tarea: " + tar.getNombreTarea() + "\n"
                + "Descripcion: " + tar.getDescTarea()+ "\n\n"
                + "Empleado: " + tar.getEmpleadoTarea() + "\n"
                + "Fecha Inicio: " + finicio + "\n"
                + "Fecha Final: " + ffinal + "\n"
                + "Avance: % " + tar.getPorcentaje() + "\n"                
                , "Información de la tarea", JOptionPane.DEFAULT_OPTION);
//      JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION);                        
    }    

    private void EditarTareaA() {

        String abc= String.valueOf(cbxEditarTarea.getSelectedItem());
        for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
            Tarea indicet =(Tarea)modeloCrearTarea.getElementAt(i);
            if (abc.contains(indicet.getNombreTarea())){        
            indicet.setEmpleadoTarea(String.valueOf(cbxEditarTareaEmpleado.getSelectedItem()));                            
            }
        }

        BufferedWriter output = null;
            try {

                output = new BufferedWriter(new FileWriter(archivoTarea, false));//false sobre escribe el archivo
                output.write("NombreTarea,Descripcion,Empleado,Duración,Porcentaje,FechaInicio,FechaFin\n");                
                
                for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
                    
                    Tarea index3 =(Tarea)modeloCrearTarea.getElementAt(i);
                    String fi = "";
                    String ff="";

                fi=new SimpleDateFormat("dd/MM/yyyy").format(index3.getFechaI());
                ff=new SimpleDateFormat("dd/MM/yyyy").format(index3.getFechaF());

                    
                    output.write(index3.getNombreTarea()+","+
                            index3.getDescTarea()+","+
                            index3.getEmpleadoTarea()+","+
                            index3.getDuracion()+","+
                            index3.getPorcentaje()+","+                            
                            fi+","+
                            ff+"\n");//+"\n"                                        
                }                
                                                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }        

        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Editar Tarea", JOptionPane.DEFAULT_OPTION);
    }
    
    private void EditarTareaE() {

        String abc= String.valueOf(cbxEmpleadoEditarTarea.getSelectedItem());
        for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
            Tarea indicet2 =(Tarea)modeloCrearTarea.getElementAt(i);
            if (abc.contains(indicet2.getNombreTarea())){        
                indicet2.setPorcentaje(Integer.parseInt(String.valueOf(txEmpleadoEditarAvance.getText())));
            }
        }

        BufferedWriter output = null;
            try {

                output = new BufferedWriter(new FileWriter(archivoTarea, false));//false sobre escribe el archivo
                output.write("NombreTarea,Descripcion,Empleado,Duración,Porcentaje,FechaInicio,FechaFin\n");                
                
                for (int i = 0; i < modeloCrearTarea.getSize(); i++) {                    
                    
                    Tarea index4 =(Tarea)modeloCrearTarea.getElementAt(i);
                    String fi = "";
                    String ff="";

                fi=new SimpleDateFormat("dd/MM/yyyy").format(index4.getFechaI());
                ff=new SimpleDateFormat("dd/MM/yyyy").format(index4.getFechaF());

                    
                    output.write(index4.getNombreTarea()+","+
                            index4.getDescTarea()+","+
                            index4.getEmpleadoTarea()+","+
                            index4.getDuracion()+","+
                            index4.getPorcentaje()+","+                            
                            fi+","+
                            ff+"\n");//+"\n"                                        
                }                
                                                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }        

        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Editar Tarea", JOptionPane.DEFAULT_OPTION);
    }

    private void PDFsinAsignar(){
                    
        pdf1= new JFileChooser();
        int op=pdf1.showSaveDialog(this);
               
        if (op == JFileChooser.APPROVE_OPTION)        
        {                    
            File f = pdf1.getSelectedFile();                                    
            String ruta = f.toString();
                
            try {            
                FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
                Document doc = new Document();                            
                PdfWriter.getInstance(doc, archivo);

                doc.open();
                String conte="TAREAS SIN ASIGNAR\n";                
                doc.add(new Paragraph(conte));                
                int size = modeloCrearTarea.size();                
                for (int i = 0; i < size; i++) {
                    Tarea tarea = (Tarea)modeloCrearTarea.getElementAt(i);
                    
                    String finicio = "";                    
                    String ffinal="";
                    
                    finicio=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaI());                    
                    ffinal=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaF());
                    
                    
                    
                    String contenido="Tarea" + "  |  "+ tarea.getNombreTarea()+"   \n"
                    
                            +"          Descripción: \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+tarea.getDescTarea()+"\n"                            
                            +"          Fecha de Inicio: "+finicio+"\n"                            
                            +"          Duracion: "+tarea.getDuracion()+" dias\n"                            
                            +"          Fecha de Finalización: "+ffinal+"\n"                            
                            +"          Empleado asignado: "+tarea.getEmpleadoTarea()+"\n"                            
                            +"          Avance: "+tarea.getPorcentaje()+" % \n\n";                                                
                    
                    if(tarea.getEmpleadoTarea()=="Sin Asignar"){                    
                        doc.add(new Paragraph(contenido));}                       
                }                                
                doc.close();                
                JOptionPane.showMessageDialog(null,"PDF Creado exitosamente");                                
            } catch (Exception e) {            
            }
        }
    }
   
    private void PDFfinalizadas(){
                    
        pdf1= new JFileChooser();
        int op=pdf1.showSaveDialog(this);
               
        if (op == JFileChooser.APPROVE_OPTION)        
        {                    
            File f = pdf1.getSelectedFile();                                    
            String ruta = f.toString();
                
            try {            
                FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
                Document doc = new Document();                            
                PdfWriter.getInstance(doc, archivo);

                doc.open();
                String conte="TAREAS FINALIZADAS\n";                
                doc.add(new Paragraph(conte));                
                int size = modeloCrearTarea.size();                
                for (int i = 0; i < size; i++) {
                    Tarea tarea = (Tarea)modeloCrearTarea.getElementAt(i);
                    
                    String finicio = "";                    
                    String ffinal="";
                    
                    finicio=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaI());                    
                    ffinal=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaF());
                    
                    
                    
                    String contenido="Tarea" + "  |  "+ tarea.getNombreTarea()+"   \n"
                    
                            +"          Descripción: \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+tarea.getDescTarea()+"\n"                            
                            +"          Fecha de Inicio: "+finicio+"\n"                            
                            +"          Duracion: "+tarea.getDuracion()+" dias\n"                            
                            +"          Fecha de Finalización: "+ffinal+"\n"                            
                            +"          Empleado asignado: "+tarea.getEmpleadoTarea()+"\n"                            
                            +"          Avance: "+tarea.getPorcentaje()+" % \n\n";                                                
                    
                    if(tarea.getPorcentaje()==100){                    
                        doc.add(new Paragraph(contenido));}                       
                }                                
                doc.close();                
                JOptionPane.showMessageDialog(null,"PDF Creado exitosamente");                                
            } catch (Exception e) {            
            }
        }
    }
    
    private void PDFtareaEmpleado(){
                    
        pdf1= new JFileChooser();
        int op=pdf1.showSaveDialog(this);
               
        if (op == JFileChooser.APPROVE_OPTION)        
        {                    
            File f = pdf1.getSelectedFile();                                    
            String ruta = f.toString();
                
            try {            
                FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
                Document doc = new Document();                            
                PdfWriter.getInstance(doc, archivo);

                doc.open();
                String abc= String.valueOf(cbxpdfEmpleado.getSelectedItem());
                String conte="TAREAS: "+abc.toUpperCase()+"\n";                
                doc.add(new Paragraph(conte));                
                int size = modeloCrearTarea.size();                
                for (int i = 0; i < size; i++) {
                    Tarea tarea = (Tarea)modeloCrearTarea.getElementAt(i);
                    
                    String finicio = "";                    
                    String ffinal="";
                    
                    finicio=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaI());                    
                    ffinal=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaF());
                                
                String contenido="Tarea" + "  |  "+ tarea.getNombreTarea()+"   \n"
                    
                            +"          Descripción: \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+tarea.getDescTarea()+"\n"                            
                            +"          Fecha de Inicio: "+finicio+"\n"                            
                            +"          Duracion: "+tarea.getDuracion()+" dias\n"                            
                            +"          Fecha de Finalización: "+ffinal+"\n"                            
                            +"          Empleado asignado: "+tarea.getEmpleadoTarea()+"\n"                            
                            +"          Avance: "+tarea.getPorcentaje()+" % \n\n";                                                
                    
                    if(tarea.getEmpleadoTarea().contains(abc)){                    
                        doc.add(new Paragraph(contenido));}                       
                }                                

                doc.close();                
                JOptionPane.showMessageDialog(null,"PDF Creado exitosamente");                                
            } catch (Exception e) {            
            }
        }
    }
    
    private void PDFporcentaje(){
                    
        pdf1= new JFileChooser();
        int op=pdf1.showSaveDialog(this);
               
        if (op == JFileChooser.APPROVE_OPTION)        
        {                    
            File f = pdf1.getSelectedFile();                                    
            String ruta = f.toString();
                
            try {            
                FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
                Document doc = new Document();                            
                PdfWriter.getInstance(doc, archivo);

                doc.open();
                String porcentaje1= txpdfPorcentaje.getText();
                int porcentaje2=Integer.parseInt(porcentaje1);
                String conte="TAREAS CON PROGRESO MENOR A "+porcentaje2+" % \n";                
                doc.add(new Paragraph(conte));                
                int size = modeloCrearTarea.size();                
                for (int i = 0; i < size; i++) {
                    Tarea tarea = (Tarea)modeloCrearTarea.getElementAt(i);
                    
                    String finicio = "";                    
                    String ffinal="";
                    
                    finicio=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaI());                    
                    ffinal=new SimpleDateFormat("dd-MM-yyyy").format(tarea.getFechaF());
                                
                String contenido="Tarea" + "  |  "+ tarea.getNombreTarea()+"   \n"
                    
                            +"          Descripción: \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+tarea.getDescTarea()+"\n"                            
                            +"          Fecha de Inicio: "+finicio+"\n"                            
                            +"          Duracion: "+tarea.getDuracion()+" dias\n"                            
                            +"          Fecha de Finalización: "+ffinal+"\n"                            
                            +"          Empleado asignado: "+tarea.getEmpleadoTarea()+"\n"                            
                            +"          Avance: "+tarea.getPorcentaje()+" % \n\n";                                                
                    
                    if(tarea.getPorcentaje()<porcentaje2){                    
                        doc.add(new Paragraph(contenido));}                       
                }                                

                doc.close();                
                JOptionPane.showMessageDialog(null,"PDF Creado exitosamente");                                
            } catch (Exception e) {            
            }
        }
    }
    
    
    
}
