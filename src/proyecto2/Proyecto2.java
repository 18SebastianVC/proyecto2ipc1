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
import java.util.ArrayList;
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
    
    //administrador
    JFileChooser explorar;
    File archivoEmpleado;//contiene el archivo csv de empleados
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

        bCargar.setText("Nuevo empleado");
        bCargar.setBounds(50, 125, 135, 30);
        bCargar.addActionListener((ActionListener) this);
        pSuper.add(bCargar);

        bEliminar.setText("Editar Empleado");
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

        Empleado empleado = new Empleado(0, "Sebastián", "Cabrera", "Super Usuario", 1, false, true, true, true, true, true, false, "SebasVGC", "pass");
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
        cnombre2.setBounds(175, 50, 100, 25);

        capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));
        capellido2.setFont(titulo);
        pcarrusel.add(capellido2);
        capellido2.setBounds(175, 80, 100, 25);

        cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));
        cpuesto2.setFont(titulo);
        pcarrusel.add(cpuesto2);
        cpuesto2.setBounds(175, 110, 100, 25);

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

        Empleado comboEditar = listadoEmpleado.getInicial().getValor();//agrega los id al combo
        for (int i = 0; i < listadoEmpleado.count; i++) {
            comboEditar = listadoEmpleado.getActual().getValor();
            cbxEditarId.addItem(comboEditar.getId());
            listadoEmpleado.Avanzar();
        }
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
                    //mostrarTarea();                                                                                                    
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

    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == b1) //    LOGIN 
        {
            String texto, texto2;
            texto = txusuario.getText();
            texto2 = textopassword.getText();
            if ((texto.contains("ROOT"))&&(texto2.contains("201612190")))//si es ROOT muestra el menu exclusivo Super Usuario
        {
            getContentPane().add(pSuper);
            pSuper.setVisible(true);
            plogin.setVisible(false);
            }
        else//si no es Super usuario, muestra menu de administrador o de Empleado
        {    
            Empleado indice=listadoEmpleado.getInicial().getValor();
            listadoEmpleado.Avanzar();
            for (int i=1; i<listadoEmpleado.getCount();i++)
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
                        getContentPane().add(pmenu1);
                        pmenu1.setVisible(true);
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

        if (evento.getSource() == bCargar) //    Cargar los datos
        {
        JFileChooser chooser = new JFileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("csv");
        //chooser.setFileFilter(filter);
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

                    Empleado nuevoEmpleado = new Empleado(Id, Nombre, Apellido, Puesto, Tipo, D, L, M, Mi, J, V, S, Nick, Password);
                    listadoEmpleado.Agregar(nuevoEmpleado);
                    modeloAgregar.addElement(nuevoEmpleado);
                    cbxEditarId.addItem(nuevoEmpleado.getId());                    
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

        if (evento.getSource() == bCrearTarea) //    Editar los datos de un empleado
        {
            CrearTarea();
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

            BufferedWriter output = null;
            try {

                output = new BufferedWriter(new FileWriter(archivoEmpleado, false));//false sobre escribe el archivo
                output.write("Id,nombre,apellido,puesto,tipousuario,d,l,m,mi,j,v,s,nick,contraseña");                
                
/*                Empleado indice2 = listadoEmpleado.getInicial().getValor();
                for (int i = 0; i < listadoEmpleado.getCount(); i++) {
                            indice2 = listadoEmpleado.getActual().getValor();
                            String der = String.valueOf(indice2.getId());
                                
                            output.write(indice2.getId()+","+
                            indice2.getNombre()+","+
                            indice2.getApellido()+","+
                            indice2.getPuesto()+","+
                            indice2.getTipousuario()+","+
                            indice2.isD()+","+
                            indice2.isL()+","+
                            indice2.isM()+","+
                            indice2.isMi()+","+
                            indice2.isJ()+","+
                            indice2.isV()+","+
                            indice2.isS()+","+
                            indice2.getNick()+","+
                            indice2.getPassword());
                listadoEmpleado.Avanzar();
                }*/
                
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
        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Editar Empleado", JOptionPane.DEFAULT_OPTION);
    }

    private void CrearTarea() {
        String NombreTarea, DescTarea, EmpleadoTarea;
        int Duracion, Porcentaje;
        Date FechaI, FechaF;

        NombreTarea = txCrearTareaNombre.getText();
        DescTarea = txCrearTareaDesc.getText();
        EmpleadoTarea = String.valueOf(cbxCrearTareaEmpleado.getSelectedItem());
        Duracion = Integer.parseInt(String.valueOf(snCrearTareaDuracion.getValue()));
        Porcentaje = 0;
        FechaI = dcCrearTareaFechaI.getDate();
        FechaF = FechaI;

        Tarea nuevaTarea = new Tarea(NombreTarea, DescTarea, EmpleadoTarea, Duracion, Porcentaje, FechaI, FechaF);
        modeloCrearTarea.addElement(nuevaTarea);

        JOptionPane.showMessageDialog(null, "Tarea agregada existosamente", "Agregar Tarea", JOptionPane.DEFAULT_OPTION);

//      JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION);                        
        System.out.println((dcCrearTareaFechaI.getDate()));
    }

}
