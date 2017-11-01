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
    
    //administrador
    JPanel pmenu1;
    JPanel pcarrusel,paddempleado,peditempleado,ptarea1,ptarea2,ptarea3;//tarea1 crea, tarea2 edita, tarea3 reportes
    
    JButton b01,b11,b12,b13,b14,b15,b16;//botones del menu administrador
    JButton banterior,bsiguiente;//botones del carrusel
    JLabel cnombre,capellido,cpuesto,cnombre2,capellido2,cpuesto2;
    JLabel domingo,lunes,martes,miercoles,jueves,viernes,sabado,dom,lun,mar,mie,jue,vie,sab;    
    String xd="";//marca con x los dias
    String xl="";
    String xm="";
    String xmi="";
    String xj="";
    String xv="";
    String xs="";
    
    Lista listadoEmpleado;    //lista del carrusel
    
    
    JButton b1;
    JList d1;
    DefaultListModel modeloLista = new DefaultListModel();
      JScrollPane barra;
         
    
    public Proyecto2()
    {
        setTitle("Proyecto No. 2");
                
        setSize(500,350);				
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
    
    empleado= new Empleado(02,"Aaron","Flores","Desarrollador",2,0,1,1,0,1,1,1,"aflores","pass1");
    listadoEmpleado.Agregar(empleado);
    
    empleado= new Empleado(03,"Sarah","Aguilar","Desarrollador",2,0,0,1,1,1,1,1,"saguilar","aguilar1");
    listadoEmpleado.Agregar(empleado);
    
        
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
    
    domingo.setText("D");	//500 70-430
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
//        lun.setText(xl);	
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
//        mar.setText(xm);	
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
//        mie.setText(xmi);	
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
//        jue.setText(xj);	
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
//        vie.setText(xv);	
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
//        sab.setText(xs);	
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
    
    
    banterior.setText("Anterior");
    banterior.setBounds(50,225,100,30);			
    banterior.addActionListener((ActionListener) this);
    pcarrusel.add(banterior);
    
    bsiguiente.setText("Siguiente");
    bsiguiente.setBounds(250,225,100,30);			
    bsiguiente.addActionListener((ActionListener) this);
    pcarrusel.add(bsiguiente);
    

    }
    
public void actionPerformed (ActionEvent evento)
{

    if (evento.getSource()==b1) //    LOGIN 
    {		
        String texto,texto2;
        texto=txusuario.getText();
        texto2=textopassword.getText();

        Empleado indice=listadoEmpleado.getInicial().getValor();                                
        for (int i=1; i<=listadoEmpleado.getCount();i++)
        {                            
            if ((texto.contains(indice.getNick()))&&(texto2.contains(indice.getPassword())))
            {                                        
                getContentPane().add(pmenu1);
                pmenu1.setVisible(true);
                plogin.setVisible(false);                                    
            }                      
            indice=listadoEmpleado.getActual().getNext().getValor();
        }
        if (plogin.isVisible())
        {                                        
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto(s)");
        }
    }

    
                
    if (evento.getSource()==b01) //    REGRESAR
    {		                
        pmenu1.setVisible(false);
        plogin.setVisible(true);                
    }

    if (evento.getSource()==b11) //    Carrusel
    {		                
        getContentPane().add(pcarrusel);
        pmenu1.setVisible(false);
        pcarrusel.setVisible(true);                
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
                
                
                
}
}


