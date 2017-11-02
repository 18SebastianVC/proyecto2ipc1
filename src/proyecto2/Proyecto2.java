package proyecto2;

 
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;

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
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Marcos Sebastián :v
 */
public class Proyecto2 extends JFrame implements ActionListener {

    Font titulo,subtitulo,subsubtitulo,tnormal;
    //login
    JPanel plogin;
    JLabel lbusuario,lbpassword;    
    JTextField txusuario;
    JPasswordField textopassword;
    JButton b1;
    //administrador
    JPanel pmenu1;
    JPanel pcarrusel,pAddEmpleado,pEditEmpleado,pCrearTarea,pEditarTarea1,pReporteTarea;
    
    JButton b01,b11,b12,b13,b14,b15,b16;//botones del menu administrador
    
    //carrusel
    JButton bcRegresar,banterior,bsiguiente;//botones del carrusel
    JLabel cnombre,capellido,cpuesto,cnombre2,capellido2,cpuesto2;
    JLabel domingo,lunes,martes,miercoles,jueves,viernes,sabado,dom,lun,mar,mie,jue,vie,sab;        
    
    Lista listadoEmpleado;    //lista del carrusel
    
    //Agregar empleado: Jpanel : paddEmpleado
    DefaultListModel modeloAgregar = new DefaultListModel();
    JButton bRegresar2,bAgregarEmpleado;
    JCheckBox chbxaddD,chbxaddL,chbxaddM,chbxaddMi,chbxaddJ,chbxaddV,chbxaddS;
    JComboBox cbxaddTipo;    
    JLabel lbaddId,lbaddNombre,lbaddApellido,lbaddPuesto,lbaddTipo,lbaddD,lbaddL,lbaddM,lbaddMi,lbaddJ,lbaddV,lbaddS,lbaddNick,lbaddPassword;        
    JList listaEmpleados1;
    JPasswordField txaddPassword;
    JScrollPane barraAgregarE;
    JTextField txaddId,txaddNombre,txaddApellido,txaddPuesto,txaddNick;             
    
    public Proyecto2()
    {
        setTitle("Proyecto No. 2");
                
        setSize(500,400);				
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Proyecto2.EXIT_ON_CLOSE);
		
        //FUENTES
        titulo=new Font("Arial", Font.BOLD, 15);
        subtitulo=new Font("Arial",Font.BOLD, 13);		
        subsubtitulo=new Font("Arial",Font.BOLD, 10);		
        
				
        plogin= new JPanel();
		
        getContentPane().add(plogin);

        plogin.setVisible(true);		
        plogin.setLayout(null);
		    
                lbusuario= new JLabel();
                lbpassword= new JLabel();
                
                txusuario= new JTextField();                       
                textopassword = new JPasswordField();
        
		b1= new JButton();

	lbusuario=new JLabel();
	lbusuario.setText("Usuario: ");	
        lbusuario.setFont(titulo);
        plogin.add(lbusuario);				
        lbusuario.setBounds(60,50,100,25);
        
	txusuario=new JTextField(50);
	plogin.add(txusuario);
	txusuario.setBounds(175, 45, 150, 25);
        

	lbpassword=new JLabel();
	lbpassword.setText("Contraseña: ");	
        lbpassword.setFont(titulo);
        plogin.add(lbpassword);		
        lbpassword.setBounds(60,100,100,25);
                
        textopassword=new JPasswordField(50);
	plogin.add(textopassword);
	textopassword.setBounds(175, 95, 150, 25);
        
	b1.setText("Acceder");			
	b1.addActionListener((ActionListener) this);
	plogin.add(b1);
        b1.setBounds(175,140,90,25);			

//panel menu administrador: 1
//-------------------

pmenu1 = new JPanel();
pmenu1.setLayout(null);
pmenu1.setVisible(false);
				
b11= new JButton();
b12= new JButton();
b13= new JButton();
b14= new JButton();
b15= new JButton();
b16= new JButton();
b01= new JButton();                

b01.setText("Regresar");
b01.setBounds(20,25,100,30);			
b01.addActionListener((ActionListener) this);
pmenu1.add(b01);
		
b11.setText("Carrusel");
b11.setBounds(50,75,135,30);			
b11.addActionListener((ActionListener) this);
pmenu1.add(b11);
		
b12.setText("Nuevo empleado");
b12.setBounds(50,125,135,30);			
b12.addActionListener((ActionListener) this);
pmenu1.add(b12);
		
b13.setText("Edtar Empleado");
b13.setBounds(50,175,135,30);			
b13.addActionListener((ActionListener) this);
pmenu1.add(b13);
		
b14.setText("Crear Tarea");
b14.setBounds(225,75,135,30);			
b14.addActionListener((ActionListener) this);
pmenu1.add(b14);
		
b15.setText("Editar Tarea");
b15.setBounds(225,125,135,30);			
b15.addActionListener((ActionListener) this);
pmenu1.add(b15);
		
b16.setText("Reportes");
b16.setBounds(225,175,135,30);			
b16.addActionListener((ActionListener) this);
pmenu1.add(b16);
		
//panel carrusel
//-------------------
    
    listadoEmpleado= new Lista();
    pcarrusel = new JPanel();
    pcarrusel.setLayout(null);
    pcarrusel.setVisible(false);

    bcRegresar = new JButton();
    banterior= new JButton();
    bsiguiente= new JButton();

    cnombre= new JLabel();
    capellido = new JLabel();
    cpuesto = new JLabel();
    domingo =new JLabel();
    lunes = new JLabel();
    martes = new JLabel();
    miercoles = new JLabel();
    jueves = new JLabel();
    viernes = new JLabel();
    sabado = new JLabel();
    
    cnombre2= new JLabel();
    capellido2 = new JLabel();
    cpuesto2 = new JLabel();
    dom = new JLabel();
    lun = new JLabel();
    mar = new JLabel();
    mie = new JLabel();
    jue = new JLabel();
    vie = new JLabel();
    sab = new JLabel();    
    
    Empleado empleado= new Empleado(01,"Ludwin","Escobar","Analista",1,0,1,1,1,1,1,0,"lescobar","lud24");
    listadoEmpleado.Agregar(empleado);
    modeloAgregar.addElement(empleado);    
    
    empleado= new Empleado(02,"Aaron","Flores","Desarrollador",2,0,1,1,0,1,1,1,"aflores","pass1");
    listadoEmpleado.Agregar(empleado);
    modeloAgregar.addElement(empleado);
    
    empleado= new Empleado(03,"Sarah","Aguilar","Desarrollador",2,0,0,1,1,1,1,1,"saguilar","aguilar1");
    listadoEmpleado.Agregar(empleado);
    modeloAgregar.addElement(empleado);
        
    bcRegresar.setText("Regresar");
    bcRegresar.setBounds(20,20,100,25);			
    bcRegresar.addActionListener((ActionListener) this);
    pcarrusel.add(bcRegresar);

    cnombre.setText("Nombre: ");	
    cnombre.setFont(titulo);
    pcarrusel.add(cnombre);				
    cnombre.setBounds(60,50,100,25);

    capellido.setText("Apellido: ");	
    capellido.setFont(titulo);
    pcarrusel.add(capellido);				
    capellido.setBounds(60,80,100,25);

    cpuesto.setText("Puesto: ");	
    cpuesto.setFont(titulo);
    pcarrusel.add(cpuesto);				
    cpuesto.setBounds(60,110,100,25);
    
    domingo.setText("D");
    domingo.setFont(titulo);
    domingo.setHorizontalAlignment(SwingConstants.CENTER);
    domingo.setForeground(Color.WHITE);//LIGHT_GRAY
    domingo.setBackground(Color.GRAY);
    domingo.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    domingo.setOpaque(true);    
    pcarrusel.add(domingo);				
    domingo.setBounds(70,145,50,25);
        if (listadoEmpleado.getActual().getValor().getD()==1){ dom.setText("X"); }else{dom.setText("");}//MUESTRA X O NADA DE ACUERDO SEA EL CASO            
        if (listadoEmpleado.getActual().getValor().getL()==1){ lun.setText("X"); }else{lun.setText("");}
        if (listadoEmpleado.getActual().getValor().getM()==1){ mar.setText("X"); }else{mar.setText("");}
        if (listadoEmpleado.getActual().getValor().getMi()==1){ mie.setText("X"); }else{mie.setText("");}
        if (listadoEmpleado.getActual().getValor().getJ()==1){ jue.setText("X"); }else{jue.setText("");}
        if (listadoEmpleado.getActual().getValor().getV()==1){ vie.setText("X"); }else{vie.setText("");}
        if (listadoEmpleado.getActual().getValor().getS()==1){ sab.setText("X"); }else{sab.setText("");}
    
        dom.setFont(titulo);
        dom.setHorizontalAlignment(SwingConstants.CENTER);
        dom.setForeground(Color.BLACK);//
        dom.setBackground(Color.LIGHT_GRAY);
        dom.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        dom.setOpaque(true);    
        pcarrusel.add(dom);				
        dom.setBounds(70,170,50,25);

    lunes.setText("L");	
    lunes.setFont(titulo);
    lunes.setHorizontalAlignment(SwingConstants.CENTER);
    lunes.setForeground(Color.WHITE);//LIGHT_GRAY
    lunes.setBackground(Color.GRAY);
    lunes.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    lunes.setOpaque(true);    
    pcarrusel.add(lunes);				
    lunes.setBounds(120,145,50,25);
        lun.setFont(titulo);
        lun.setHorizontalAlignment(SwingConstants.CENTER);
        lun.setForeground(Color.BLACK);//
        lun.setBackground(Color.LIGHT_GRAY);
        lun.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        lun.setOpaque(true);    
        pcarrusel.add(lun);				
        lun.setBounds(120,170,50,25);
        
    martes.setText("M");	
    martes.setFont(titulo);
    martes.setHorizontalAlignment(SwingConstants.CENTER);
    martes.setForeground(Color.WHITE);//LIGHT_GRAY
    martes.setBackground(Color.GRAY);
    martes.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    martes.setOpaque(true);    
    pcarrusel.add(martes);				
    martes.setBounds(170,145,50,25);
        mar.setFont(titulo);
        mar.setHorizontalAlignment(SwingConstants.CENTER);
        mar.setForeground(Color.BLACK);
        mar.setBackground(Color.LIGHT_GRAY);
        mar.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        mar.setOpaque(true);    
        pcarrusel.add(mar);				
        mar.setBounds(170,170,50,25);

    
    miercoles.setText("Mi");	
    miercoles.setFont(titulo);
    miercoles.setHorizontalAlignment(SwingConstants.CENTER);
    miercoles.setForeground(Color.WHITE);//LIGHT_GRAY
    miercoles.setBackground(Color.GRAY);
    miercoles.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    miercoles.setOpaque(true);    
    pcarrusel.add(miercoles);				
    miercoles.setBounds(220,145,50,25);
        mie.setFont(titulo);
        mie.setHorizontalAlignment(SwingConstants.CENTER);
        mie.setForeground(Color.BLACK);
        mie.setBackground(Color.LIGHT_GRAY);
        mie.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        mie.setOpaque(true);    
        pcarrusel.add(mie);				
        mie.setBounds(220,170,50,25);
    
    jueves.setText("J");	
    jueves.setFont(titulo);
    jueves.setHorizontalAlignment(SwingConstants.CENTER);
    jueves.setForeground(Color.WHITE);//LIGHT_GRAY
    jueves.setBackground(Color.GRAY);
    jueves.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    jueves.setOpaque(true);    
    pcarrusel.add(jueves);				
    jueves.setBounds(270,145,50,25);
        jue.setFont(titulo);
        jue.setHorizontalAlignment(SwingConstants.CENTER);
        jue.setForeground(Color.BLACK);
        jue.setBackground(Color.LIGHT_GRAY);
        jue.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        jue.setOpaque(true);    
        pcarrusel.add(jue);				
        jue.setBounds(270,170,50,25);
    
    viernes.setText("V");	
    viernes.setFont(titulo);
    viernes.setHorizontalAlignment(SwingConstants.CENTER);
    viernes.setForeground(Color.WHITE);//LIGHT_GRAY
    viernes.setBackground(Color.GRAY);
    viernes.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    viernes.setOpaque(true);    
    pcarrusel.add(viernes);				
    viernes.setBounds(320,145,50,25);
        vie.setFont(titulo);
        vie.setHorizontalAlignment(SwingConstants.CENTER);
        vie.setForeground(Color.BLACK);
        vie.setBackground(Color.LIGHT_GRAY);
        vie.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        vie.setOpaque(true);    
        pcarrusel.add(vie);				
        vie.setBounds(320,170,50,25);
    
    sabado.setText("S");	
    sabado.setFont(titulo);
    sabado.setHorizontalAlignment(SwingConstants.CENTER);
    sabado.setForeground(Color.WHITE);//LIGHT_GRAY
    sabado.setBackground(Color.GRAY);
    sabado.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
    sabado.setOpaque(true);    
    pcarrusel.add(sabado);				
    sabado.setBounds(370,145,50,25);
        sab.setFont(titulo);
        sab.setHorizontalAlignment(SwingConstants.CENTER);
        sab.setForeground(Color.BLACK);
        sab.setBackground(Color.LIGHT_GRAY);
        sab.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JLabel
        sab.setOpaque(true);    
        pcarrusel.add(sab);				
        sab.setBounds(370,170,50,25);    
    
    
    cnombre2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getNombre()));
    cnombre2.setFont(titulo);
    pcarrusel.add(cnombre2);				
    cnombre2.setBounds(175,50,100,25);

    capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));
    capellido2.setFont(titulo);
    pcarrusel.add(capellido2);				
    capellido2.setBounds(175,80,100,25);

    cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));
    cpuesto2.setFont(titulo);
    pcarrusel.add(cpuesto2);				
    cpuesto2.setBounds(175,110,100,25);
        
    banterior.setText("Anterior");//Boton anterior
    banterior.setBounds(50,225,100,30);			
    banterior.addActionListener((ActionListener) this);
    pcarrusel.add(banterior);
    
    bsiguiente.setText("Siguiente");//boton siguiente
    bsiguiente.setBounds(250,225,100,30);			
    bsiguiente.addActionListener((ActionListener) this);
    pcarrusel.add(bsiguiente);

//    
//Panel: Agregar nuevo empleado
            
    pAddEmpleado = new JPanel();
    bRegresar2= new JButton();
    bAgregarEmpleado= new JButton();
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
    lbaddD = new JLabel();
    lbaddL = new JLabel();
    lbaddM = new JLabel();
    lbaddMi = new JLabel();
    lbaddJ = new JLabel();
    lbaddV = new JLabel();
    lbaddS = new JLabel();
    lbaddNick = new JLabel();
    lbaddPassword = new JLabel();
    listaEmpleados1 = new JList();
    //barraAgregarE = new JScrollPane(listaEmpleados1);
    txaddId = new JTextField ();
    txaddNombre = new JTextField ();
    txaddApellido = new JTextField ();
    txaddPuesto = new JTextField ();
    txaddNick = new JTextField ();
    txaddPassword = new JPasswordField ();

    pAddEmpleado.setLayout(null);
    pAddEmpleado.setVisible(false);
    
    
    bRegresar2.setText("Regresar");
    bRegresar2.setBounds(20,25,100,30);			
    bRegresar2.addActionListener((ActionListener) this);
    pAddEmpleado.add(bRegresar2);

    lbaddId.setText("Id: ");
    lbaddId.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddId.setFont(subtitulo);
    pAddEmpleado.add(lbaddId);				
    lbaddId.setBounds(30,75,100,25);
	pAddEmpleado.add(txaddId);
	txaddId.setBounds(135, 75, 130, 20);


    lbaddNombre.setText("Nombre: ");	
    lbaddNombre.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddNombre.setFont(subtitulo);
    pAddEmpleado.add(lbaddNombre);				
    lbaddNombre.setBounds(30,100,100,25);
	pAddEmpleado.add(txaddNombre);
	txaddNombre.setBounds(135, 100, 130, 20);

    lbaddApellido.setText("Apellido: ");	
    lbaddApellido.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddApellido.setFont(subtitulo);
    pAddEmpleado.add(lbaddApellido);				
    lbaddApellido.setBounds(30,125,100,25);
	pAddEmpleado.add(txaddApellido);
	txaddApellido.setBounds(135, 125, 130, 20);
    
    lbaddPuesto.setText("Puesto: ");	
    lbaddPuesto.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddPuesto.setFont(subtitulo);
    pAddEmpleado.add(lbaddPuesto);				
    lbaddPuesto.setBounds(30,150,100,25);
	pAddEmpleado.add(txaddPuesto);
	txaddPuesto.setBounds(135, 150, 130, 20);
    
    lbaddTipo.setText("Tipo Empleado: ");	
    lbaddTipo.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddTipo.setFont(subtitulo);
    pAddEmpleado.add(lbaddTipo);				
    lbaddTipo.setBounds(20,175,110,25);
	pAddEmpleado.add(cbxaddTipo);
	cbxaddTipo.setBounds(135, 175, 130, 20);
        cbxaddTipo.addItem("Administrador");
        cbxaddTipo.addItem("Empleado");
        
    
    lbaddNick.setText("Nick: ");	
    lbaddNick.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddNick.setFont(subtitulo);
    pAddEmpleado.add(lbaddNick);				
    lbaddNick.setBounds(30,200,100,25);
	pAddEmpleado.add(txaddNick);
	txaddNick.setBounds(135, 200, 130, 20);
    
    lbaddPassword.setText("Password: ");
    lbaddPassword.setHorizontalAlignment(SwingConstants.RIGHT);
    lbaddPassword.setFont(subtitulo);
    pAddEmpleado.add(lbaddPassword);				
    lbaddPassword.setBounds(30,225,100,25);    	
	pAddEmpleado.add(txaddPassword);
	txaddPassword.setBounds(135, 225, 130, 20);
    
    chbxaddD.setText("Dom");
    pAddEmpleado.add(chbxaddD);				
    chbxaddD.setBounds(50,275,55,25);   
    
    chbxaddL.setText("Lun");
    pAddEmpleado.add(chbxaddL);				
    chbxaddL.setBounds(110,275,55,25);
    
    chbxaddM.setText("Mar");
    pAddEmpleado.add(chbxaddM);
    chbxaddM.setBounds(170,275,55,25);
    
    chbxaddMi.setText("Mie");
    pAddEmpleado.add(chbxaddMi);
    chbxaddMi.setBounds(230,275,55,25);
    
    chbxaddJ.setText("Jue");
    pAddEmpleado.add(chbxaddJ);
    chbxaddJ.setBounds(50,300,55,25);
    
    chbxaddV.setText("Vie");
    pAddEmpleado.add(chbxaddV);
    chbxaddV.setBounds(110,300,55,25);
    
    chbxaddS.setText("Sab");
    pAddEmpleado.add(chbxaddS);
    chbxaddS.setBounds(170,300,55,25);
    
    listaEmpleados1.setModel(modeloAgregar);		
    listaEmpleados1.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a JList
    pAddEmpleado.add(listaEmpleados1);
    
    listaEmpleados1.addMouseListener(new MouseAdapter()
    {
        public void mouseClicked(MouseEvent me)
        {
            if(me.getClickCount() == 2)
            {// Cuenta la cantidad de clicks para saber si es doble                        
                mostrarEmpleado();                                                                                                    
            }
        }
    });                

    
    barraAgregarE = new JScrollPane(listaEmpleados1);
    barraAgregarE.setBounds(300,75,150,175);//300,75,150,175     
    pAddEmpleado.add(barraAgregarE);
    
    
    bAgregarEmpleado.setText("Agregar");
    bAgregarEmpleado.setBounds(325,275,100,25);			
    bAgregarEmpleado.addActionListener((ActionListener) this);
    pAddEmpleado.add(bAgregarEmpleado);


    }
    
public void actionPerformed (ActionEvent evento)
{

    if (evento.getSource()==b1) //    LOGIN 
    {/*		
        String texto,texto2;
        texto=txusuario.getText();
        texto2=textopassword.getText();

        Empleado indice=listadoEmpleado.getInicial().getValor();                                
        for (int i=1; i<=listadoEmpleado.getCount();i++)
        {                            
            if ((texto.contains(indice.getNick()))&&(texto2.contains(indice.getPassword())))
            { */                                       
                getContentPane().add(pmenu1);
                pmenu1.setVisible(true);
                plogin.setVisible(false);                                    
/*            }                      
            indice=listadoEmpleado.getActual().getNext().getValor();
        }
        if (plogin.isVisible())
        {                                        
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto(s)");
        }*/
    }                

    if (evento.getSource()==b11) //    Carrusel
    {		                
        getContentPane().add(pcarrusel);
        pmenu1.setVisible(false);
        pcarrusel.setVisible(true);                
    }
    if (evento.getSource()==b01) //    REGRESAR
    {		                
        pmenu1.setVisible(false);
        plogin.setVisible(true);                
    }

    if (evento.getSource()==b12) //    Carrusel
    {		                
        getContentPane().add(pAddEmpleado);
        pmenu1.setVisible(false);
        pAddEmpleado.setVisible(true);                
    }

    if (evento.getSource()==bcRegresar) //    REGRESAR: de carrusel a menu administrador
    {		                
        pcarrusel.setVisible(false);
        pmenu1.setVisible(true);                
    }

    if (evento.getSource()==bRegresar2) //    REGRESAR: de Agregar emleado a menu administrador
    {		                
        pAddEmpleado.setVisible(false);
        pmenu1.setVisible(true);                
    }
    
    if (evento.getSource()==bsiguiente) //    Carrusel anterior
    {		                
        listadoEmpleado.Avanzar();
        cnombre2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getNombre()));
        capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));
        cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));
        if (listadoEmpleado.getActual().getValor().getD()==1){ dom.setText("X"); }else{dom.setText("");}
        if (listadoEmpleado.getActual().getValor().getL()==1){ lun.setText("X"); }else{lun.setText("");}
        if (listadoEmpleado.getActual().getValor().getM()==1){ mar.setText("X"); }else{mar.setText("");}
        if (listadoEmpleado.getActual().getValor().getMi()==1){ mie.setText("X"); }else{mie.setText("");}
        if (listadoEmpleado.getActual().getValor().getJ()==1){ jue.setText("X"); }else{jue.setText("");}
        if (listadoEmpleado.getActual().getValor().getV()==1){ vie.setText("X"); }else{vie.setText("");}
        if (listadoEmpleado.getActual().getValor().getS()==1){ sab.setText("X"); }else{sab.setText("");}
        
    }
    if (evento.getSource()==banterior) //    Carrusel siguietne
    {		                
        listadoEmpleado.Retroceder();
        cnombre2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getNombre()));        
        capellido2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getApellido()));        
        cpuesto2.setText(String.valueOf(listadoEmpleado.getActual().getValor().getPuesto()));        
        if (listadoEmpleado.getActual().getValor().getD()==1){ dom.setText("X"); }else{dom.setText("");}
        if (listadoEmpleado.getActual().getValor().getL()==1){ lun.setText("X"); }else{lun.setText("");}
        if (listadoEmpleado.getActual().getValor().getM()==1){ mar.setText("X"); }else{mar.setText("");}
        if (listadoEmpleado.getActual().getValor().getMi()==1){ mie.setText("X"); }else{mie.setText("");}
        if (listadoEmpleado.getActual().getValor().getJ()==1){ jue.setText("X"); }else{jue.setText("");}
        if (listadoEmpleado.getActual().getValor().getV()==1){ vie.setText("X"); }else{vie.setText("");}
        if (listadoEmpleado.getActual().getValor().getS()==1){ sab.setText("X"); }else{sab.setText("");}        
    }
                
    if (evento.getSource()==bAgregarEmpleado) //    Agregar un empleado nuevo
    {		                
        AgregarEmpleado();
    }
                
                
}

private void mostrarEmpleado()
{            
    int index= listaEmpleados1.getSelectedIndex();
    Empleado emp=(Empleado)modeloAgregar.getElementAt(index);    
    String tipo="";
    String dd,dl,dm,dmi,dj,dv,ds;    
    
    if(emp.getTipousuario()==1)
    { tipo="Administrador"; }    
    if(emp.getTipousuario()==2)
    { tipo="Adminisdor"; }
    
    if (emp.getD()==1){ dd="D, ";} else {dd="";}
    if (emp.getL()==1){ dl="L, ";} else {dl="";}
    if (emp.getM()==1){ dm="M, ";} else {dm="";}
    if (emp.getMi()==1){ dmi="Mi, ";} else {dmi="";}
    if (emp.getJ()==1){ dj="J, ";} else {dj="";}
    if (emp.getV()==1){ dv="V, ";} else {dv="";}
    if (emp.getS()==1){ ds="S, ";} else {ds="";}
    
    String dias=dd+dl+dm+dmi+dj+dv+ds;
    
    JOptionPane.showMessageDialog(null, "Id: "+emp.getId()+"\n"
                    + "Nombre: "+emp.getNombre()+" "+emp.getApellido()+"\n"
                    + "Puesto: "+emp.getPuesto()+"\n"
                    + "Tipo: "+tipo+"\n"
                    + "Nick: "+emp.getNick()+"\n"
                    + "Password: "+emp.getPassword()+"\n"                            
                    + "Dias Laborales: "+dias+"\n","Información de ususario", JOptionPane.DEFAULT_OPTION);          
//      JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION);                        
}       

private void AgregarEmpleado()
{            
     int Id;
     String nombre,apellido,puesto;
     int tipousuario,d,l,m,mi,j,v,s;
     String nick,password;
     
     String tipo1=String.valueOf(cbxaddTipo.getSelectedItem());
         
     Id=Integer.parseInt(txaddId.getText());
     nombre=txaddNombre.getText();
     apellido=txaddApellido.getText();
     puesto=txaddPuesto.getText();
     if (tipo1=="Administrador"){tipousuario=1;}else{tipousuario=2;}
     nick=txaddNick.getText();
     password=txaddPassword.getText();
     if (chbxaddD.isSelected()){d=1;}else {d=0;}
     if (chbxaddL.isSelected()){l=1;}else {l=0;}
     if (chbxaddM.isSelected()){m=1;}else {m=0;}
     if (chbxaddMi.isSelected()){mi=1;}else {mi=0;}
     if (chbxaddJ.isSelected()){j=1;}else {j=0;}
     if (chbxaddV.isSelected()){v=1;}else {v=0;}
     if (chbxaddS.isSelected()){s=1;}else {s=0;}

    String textoNick=txaddNick.getText();      
    int textoId=Integer.parseInt(txaddId.getText());      
    
    int error=0;
    Empleado indice=listadoEmpleado.getInicial().getValor();                                
    System.out.print(listadoEmpleado.getCount());
    
    for (int i=0; i<listadoEmpleado.getCount();i++)
    {                            
        if ((textoNick.contains(indice.getNick()))||(textoId==indice.getId()))
        {             
            error=error+1;
        }
        indice=listadoEmpleado.getActual().getNext().getValor();
    }
    
    if (error!=0)
    { 
        JOptionPane.showMessageDialog(null, "Uusario ya existente","Error", JOptionPane.DEFAULT_OPTION);          
    }
    else
    {
        Empleado nuevoEmpleado = new Empleado(Id, nombre, apellido, puesto, tipousuario,d,l,m,mi,j,v,s,nick,password);
        listadoEmpleado.Agregar(nuevoEmpleado);
        modeloAgregar.addElement(nuevoEmpleado);    
        JOptionPane.showMessageDialog(null, "Empleado agregado existosamente","Agregar Empleado", JOptionPane.DEFAULT_OPTION);                      
    }            
//      JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Titulo", JOptionPane.DEFAULT_OPTION);                        
}       







}


