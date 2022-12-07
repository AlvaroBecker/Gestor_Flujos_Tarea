/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front;

import Metodos.MetodosBD;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import Metodos.MetodosFront.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.Image;
import java.util.List;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.ABORT;
import static java.awt.image.ImageObserver.ERROR;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.io.FileOutputStream;
//com.lowagie...   old version
//com.itextpdf...  recent version
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collection;
import java.util.Date;

import java.util.GregorianCalendar;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Alvaro Becker
 */
public class Admin extends javax.swing.JFrame {

    public static int columna, row;
    int xMouse, yMouse;
//    JLabel labelEliminar=new JLabel();
//    JLabel labelEditar=new JLabel();
    int inicial;

    MetodosBD.ConexionOracle conn;
    //public static JTable table;
    String nombre, usrcon;
    String[] cboxes;

    /**
     * Creates new form Admin
     *
     * @param nomb
     * @param usuariocon
     * @param con
     */
    public Admin(String nomb, String usuariocon, MetodosBD.ConexionOracle con) {
        initComponents();
        conn = con;
        
        String[] capitalizenombre = nomb.toLowerCase().split(" ");
        nombre = capitalizenombre[0].substring(0, 1).toUpperCase() + capitalizenombre[0].substring(1) + " " + capitalizenombre[1].substring(0, 1).toUpperCase() + capitalizenombre[1].substring(1);
        nombreusuario.setText(nombre);//rellenar el nombre superior de la vista con las credenciales del usuario ingresado
        usrcon = usuariocon;
        //Asignar forma redondeada de la vista
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        setShape(forma);
        setLocationRelativeTo(null);
        //asignacion de color y bordes redondeados a botones y componentes
        panelHeader.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, new Color(212, 227, 252)));
        gestion_contenedor_usuarios_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        gestion_contenedor_unidades_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        gestion_contenedor_roles_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        panelu1.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        panelu2.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        panelu3.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        panelu4.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(10, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        //establecer paneles visibles 
        PanelGestion.setVisible(false);
        PanelGestion.setEnabled(false);
        PanelGestion.setFocusable(false);
        panelu1_cambiarcontent.setVisible(false);
        panelu2_cambiarcontent.setVisible(false);
        panelu3_cambiarcontent.setVisible(false);
        panelu4_cambiarcontent.setVisible(false);
        panelu1_cambiarcontent.setEnabled(false);
        panelu2_cambiarcontent.setEnabled(false);
        panelu3_cambiarcontent.setEnabled(false);
        panelu4_cambiarcontent.setEnabled(false);
        panelu1_cambiarcontent.setFocusable(false);
        panelu2_cambiarcontent.setFocusable(false);
        panelu3_cambiarcontent.setFocusable(false);
        panelu4_cambiarcontent.setFocusable(false);
        PanelGestion.setVisible(false);
        PanelGestion.setEnabled(false);
        PanelGestion.setFocusable(false);
        //rellenado de combobox para visualizar graficos
        conn.rellenarCbox("UNIDAD_INTERNA", panelu1_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu2_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu3_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu4_cambiarcontent);
        panelu1_title_lbll_rrhh.setText(panelu1_cambiarcontent.getItemAt(0));
        panelu2_title_lbl_cont.setText(panelu2_cambiarcontent.getItemAt(1));
        panelu3_title_lbl_dir.setText(panelu3_cambiarcontent.getItemAt(2));
        panelu4_title_lbl_logi.setText(panelu4_cambiarcontent.getItemAt(3));
       
        conn.listar("FLUJO", flujos_contenedor_tabla, "ID_FLUJO");
        cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(10, new Color(242, 242, 242), true, new Color(242, 242, 242)));
        ContenedorGraficos.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        ContenedorTorta.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        FlujosContenedor.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.WHITE));
        labelFondo.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.BLACK, false, null));
         panelu1_cambiarcontent.setVisible(false);
        panelu2_cambiarcontent.setVisible(false);
        panelu3_cambiarcontent.setVisible(false);
        panelu4_cambiarcontent.setVisible(false);
        panelu1_cambiarcontent.setEnabled(false);
        panelu2_cambiarcontent.setEnabled(false);
        panelu3_cambiarcontent.setEnabled(false);
        panelu4_cambiarcontent.setEnabled(false);
        panelu1_cambiarcontent.setFocusable(false);
        panelu2_cambiarcontent.setFocusable(false);
        panelu3_cambiarcontent.setFocusable(false);
        panelu4_cambiarcontent.setFocusable(false);
        guardar_pnl.setVisible(false);
        guardar_pnl.setFocusable(false);
        guardar_pnl.setEnabled(false);
        guardar_pnl.setOpaque(false);
        cancelar_pnl.setFocusable(false);
        cancelar_pnl.setVisible(false);
        cancelar_pnl.setEnabled(false);
        cancelar_pnl.setOpaque(false);
        labelFondo.setFocusable(false);
        labelFondo.setEnabled(false);
        //rellenado de labels con imagenes
        Metodos.MetodosFront.SetImageLabel(BtnConfiguracionHeader, "src/main/resources/Images/Configuracion.png", this);
        Metodos.MetodosFront.SetImageLabel(btnagregarflujo, "src/main/resources/Images/Agregar.png", this);
        Metodos.MetodosFront.SetImageLabel(logopersona, "src/main/resources/Images/usuario.png", this);
        Metodos.MetodosFront.SetImageLabel(apagar, "src/main/resources/Images/off.png", this);
        Metodos.MetodosFront.SetImageLabel(Homeleft, "src/main/resources/Images/home.png", this);
        Metodos.MetodosFront.SetImageLabel(gestion_btn_adduser_lbl, "src/main/resources/Images/Agregar.png", this);
        Metodos.MetodosFront.SetImageLabel(gestion_btn_addunidad_lbl, "src/main/resources/Images/Agregar.png", this);
        Metodos.MetodosFront.SetImageLabel(gestion_btn_addrol_lbl, "src/main/resources/Images/Agregar.png", this);
        Metodos.MetodosFront.SetImageLabel(Generar_reporte, "src/main/resources/Images/reportes.png", this);
        gestion_btn_addrol_lbl.setBorder(null);
        gestion_btn_addunidad_lbl.setBorder(null);
        gestion_btn_adduser_lbl.setBorder(null);
        btnagregarflujo.setBorder(null);
        BtnConfiguracionHeader.setBorder(null);
        empresalogo.setBorder(null);
        this.setComponentZOrder(labelFondo, 0);
        Gestionlblbtn.setBorder(Metodos.MetodosFront.setRoundedborder(10, Color.WHITE, false, null));
        Homelblbtn.setBorder(Metodos.MetodosFront.setRoundedborder(10, Color.WHITE, false, null));
        inicial = (int) BarraLateral.getSize().getWidth();
        panelu1_number_lbl_rrhh.setText(String.valueOf(conn.contarTareas(panelu1_title_lbll_rrhh.getText())));
        panelu2_number_lbl_cont.setText(String.valueOf(conn.contarTareas(panelu2_title_lbl_cont.getText())));
        panelu3_number_lbl_dir.setText(String.valueOf(conn.contarTareas(panelu3_title_lbl_dir.getText())));
        panelu4_number_lbl_logi.setText(String.valueOf(conn.contarTareas(panelu4_title_lbl_logi.getText())));
        String[] datos = conn.obtenerdatosTorta(panelu1_title_lbll_rrhh.getText());
        List<String> datossinnulos = new ArrayList<>(Arrays.asList(datos));
        datossinnulos.removeIf(Objects::isNull);
        DefaultPieDataset torta = new DefaultPieDataset();
        for (int i = 0; i < datossinnulos.size(); i++) {
            torta.setValue((String) datossinnulos.get(i), Integer.parseInt(datossinnulos.get(i + 1)));
            i++;
        }
        JFreeChart greaficoTorta = ChartFactory.createRingChart(panelu1_title_lbll_rrhh.getText(), torta, true, true, false);
        ChartPanel graficotortapnl = new ChartPanel(greaficoTorta);
        ContenedorTorta.setLayout(new BorderLayout());
        ContenedorTorta.add(graficotortapnl, BorderLayout.CENTER);
        DefaultCategoryDataset barras = new DefaultCategoryDataset();
        barras.setValue(Integer.parseInt(panelu1_number_lbl_rrhh.getText()), panelu1_task_lbl_rrhh.getText(), panelu1_title_lbll_rrhh.getText());
        barras.setValue(Integer.parseInt(panelu2_number_lbl_cont.getText()), panelu2_task_lbl_cont.getText(), panelu2_title_lbl_cont.getText());
        barras.setValue(Integer.parseInt(panelu3_number_lbl_dir.getText()), panelu3_task_lbl_dir.getText(), panelu3_title_lbl_dir.getText());
        barras.setValue(Integer.parseInt(panelu4_number_lbl_logi.getText()), panelu4_task_lbl_logi.getText(), panelu4_title_lbl_logi.getText());
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "Total Tareas por Departamento",
                "Departamento",
                "Tareas",
                barras,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartPanel graficoBarrapnl = new ChartPanel(grafico_barras);
        ContenedorGraficos.setLayout(new BorderLayout());
        ContenedorGraficos.add(graficoBarrapnl, BorderLayout.CENTER);
        conn.listar("USUARIO", gestion_lista_user_table, "ID_USR");
        conn.listar("TAREA_ROL", gestion_lista_rol_table, "ID_TR");
        conn.listar("UNIDAD_INTERNA", gestion_lista_unidad_table, "ID_UNIDAD");
        pack();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        Burgerpnl = new javax.swing.JPanel();
        BarraLateral = new javax.swing.JPanel();
        apagar = new javax.swing.JLabel();
        Gestionleft = new javax.swing.JLabel();
        Homelblbtn = new javax.swing.JLabel();
        Homeleft = new javax.swing.JLabel();
        Gestionlblbtn = new javax.swing.JLabel();
        offbtn = new javax.swing.JLabel();
        Generar_reporte = new javax.swing.JLabel();
        BarraLimite = new javax.swing.JPanel();
        Minimizar = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        Superior = new javax.swing.JPanel();
        empresalogo = new javax.swing.JLabel();
        nombreusuario = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();
        logopersona = new javax.swing.JLabel();
        vistas = new javax.swing.JLayeredPane();
        PanelIncial = new javax.swing.JPanel();
        ContenedorGraficos = new javax.swing.JPanel();
        FlujosContenedor = new javax.swing.JPanel();
        btnagregarflujo = new javax.swing.JLabel();
        scroll_lista_flujo = new javax.swing.JScrollPane();
        flujos_contenedor_tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ContenedorTorta = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        panelu1 = new javax.swing.JPanel();
        panelu1_title_lbll_rrhh = new javax.swing.JLabel();
        panelu1_number_lbl_rrhh = new javax.swing.JLabel();
        panelu1_icon_lbl_rrhh = new javax.swing.JLabel();
        panelu1_task_lbl_rrhh = new javax.swing.JLabel();
        panelu1_cambiarcontent = new javax.swing.JComboBox<>();
        panelu2 = new javax.swing.JPanel();
        panelu2_title_lbl_cont = new javax.swing.JLabel();
        panelu2_number_lbl_cont = new javax.swing.JLabel();
        panelu2_icon_lbl_cont = new javax.swing.JLabel();
        panelu2_task_lbl_cont = new javax.swing.JLabel();
        panelu2_cambiarcontent = new javax.swing.JComboBox<>();
        panelu3 = new javax.swing.JPanel();
        panelu3_title_lbl_dir = new javax.swing.JLabel();
        panelu3_number_lbl_dir = new javax.swing.JLabel();
        panelu3_icon_lbl_dir = new javax.swing.JLabel();
        panelu3_task_lbl_dir = new javax.swing.JLabel();
        panelu3_cambiarcontent = new javax.swing.JComboBox<>();
        panelu4 = new javax.swing.JPanel();
        panelu4_title_lbl_logi = new javax.swing.JLabel();
        panelu4_number_lbl_logi = new javax.swing.JLabel();
        panelu4_icon_lbl_logi = new javax.swing.JLabel();
        panelu4_task_lbl_logi = new javax.swing.JLabel();
        panelu4_cambiarcontent = new javax.swing.JComboBox<>();
        BtnConfiguracionHeader = new javax.swing.JLabel();
        cancelar_pnl = new javax.swing.JPanel();
        cancelar = new javax.swing.JLabel();
        guardar_pnl = new javax.swing.JPanel();
        guardar_cambios = new javax.swing.JLabel();
        PanelGestion = new javax.swing.JPanel();
        gestion_contenedor_usuarios_pnl = new javax.swing.JPanel();
        gestion_btn_adduser_lbl = new javax.swing.JLabel();
        gestion_titulouser_titulo_lbl = new javax.swing.JLabel();
        scroll_lista_usuario = new javax.swing.JScrollPane();
        gestion_lista_user_table = new javax.swing.JTable();
        gestion_contenedor_roles_pnl = new javax.swing.JPanel();
        gestion_btn_addrol_lbl = new javax.swing.JLabel();
        gestion_titulorol_titulo_lbl = new javax.swing.JLabel();
        scroll_lista_roles = new javax.swing.JScrollPane();
        gestion_lista_rol_table = new javax.swing.JTable();
        gestion_contenedor_unidades_pnl = new javax.swing.JPanel();
        gestion_btn_addunidad_lbl = new javax.swing.JLabel();
        gestion_titulounidad_titulo_lbl = new javax.swing.JLabel();
        scroll_lista_unidad = new javax.swing.JScrollPane();
        gestion_lista_unidad_table = new javax.swing.JTable();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(930, 780));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Burgerpnl.setBackground(new java.awt.Color(3, 48, 118));
        Burgerpnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelFondo.add(Burgerpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 50, 50));

        BarraLateral.setBackground(new java.awt.Color(117, 170, 250));
        BarraLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off.PNG"))); // NOI18N
        apagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apagarMouseClicked(evt);
            }
        });
        BarraLateral.add(apagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 25, 25));

        Gestionleft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gestión.PNG"))); // NOI18N
        Gestionleft.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gestionleft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionleftMouseClicked(evt);
            }
        });
        BarraLateral.add(Gestionleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 210, 25, 25));

        Homelblbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Homelblbtn.setForeground(new java.awt.Color(255, 255, 255));
        Homelblbtn.setText("HOME");
        Homelblbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Homelblbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomelblbtnMouseClicked(evt);
            }
        });
        BarraLateral.add(Homelblbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 109, 25));

        Homeleft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.PNG"))); // NOI18N
        Homeleft.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Homeleft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeleftMouseClicked(evt);
            }
        });
        BarraLateral.add(Homeleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 110, 25, 25));

        Gestionlblbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Gestionlblbtn.setForeground(new java.awt.Color(255, 255, 255));
        Gestionlblbtn.setText("GESTION");
        Gestionlblbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gestionlblbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GestionlblbtnMouseClicked(evt);
            }
        });
        BarraLateral.add(Gestionlblbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 109, 25));

        offbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        offbtn.setForeground(new java.awt.Color(255, 255, 255));
        offbtn.setText("LOGOUT");
        offbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        offbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offbtnMouseClicked(evt);
            }
        });
        BarraLateral.add(offbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 109, 25));

        Generar_reporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Generar_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Generar_reporteMouseClicked(evt);
            }
        });
        BarraLateral.add(Generar_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 306, 25, 25));

        PanelFondo.add(BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 80, 50, 699));

        BarraLimite.setBackground(new java.awt.Color(255, 255, 255));
        BarraLimite.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraLimiteMouseDragged(evt);
            }
        });
        BarraLimite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarraLimiteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraLimiteMousePressed(evt);
            }
        });
        BarraLimite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Minimizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minimizar.setText("_");
        Minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
        });
        BarraLimite.add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 25, 25));

        Exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit.setText("X");
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        Exit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ExitKeyPressed(evt);
            }
        });
        BarraLimite.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 25, 25));

        PanelFondo.add(BarraLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 920, 29));

        Superior.setBackground(new java.awt.Color(117, 170, 250));
        Superior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empresalogo.setText("Process SA");
        empresalogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Superior.add(empresalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 30));

        nombreusuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreusuario.setText("Nicolas oportus");
        Superior.add(nombreusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 3, 120, 20));

        rol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rol.setText("Administrador");
        Superior.add(rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 23, 90, 20));
        Superior.add(logopersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 3, 40, 40));

        PanelFondo.add(Superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 879, 50));

        vistas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelIncial.setBackground(new java.awt.Color(255, 255, 255));
        PanelIncial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContenedorGraficos.setBackground(new java.awt.Color(255, 255, 255));
        ContenedorGraficos.setOpaque(false);
        ContenedorGraficos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelIncial.add(ContenedorGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 540, 240));

        FlujosContenedor.setOpaque(false);
        FlujosContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregarflujo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnagregarflujo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregarflujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnagregarflujoMouseClicked(evt);
            }
        });
        FlujosContenedor.add(btnagregarflujo, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 10, 35, 35));

        flujos_contenedor_tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        flujos_contenedor_tabla.setAutoCreateRowSorter(true);
        flujos_contenedor_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        flujos_contenedor_tabla.setAutoscrolls(false);
        flujos_contenedor_tabla.setCellSelectionEnabled(true);
        flujos_contenedor_tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flujos_contenedor_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flujos_contenedor_tablaMouseClicked(evt);
            }
        });
        scroll_lista_flujo.setViewportView(flujos_contenedor_tabla);
        flujos_contenedor_tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        FlujosContenedor.add(scroll_lista_flujo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 830, 230));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Flujo");
        FlujosContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 30));

        PanelIncial.add(FlujosContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 850, 300));

        ContenedorTorta.setOpaque(false);
        ContenedorTorta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelIncial.add(ContenedorTorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 300, 240));

        panelHeader.setOpaque(false);
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelu1.setOpaque(false);
        panelu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelu1_title_lbll_rrhh.setText("Recursos Humanos");
        panelu1.add(panelu1_title_lbll_rrhh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 20));

        panelu1_number_lbl_rrhh.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        panelu1_number_lbl_rrhh.setText("0");
        panelu1.add(panelu1_number_lbl_rrhh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 46, 30, 30));
        panelu1.add(panelu1_icon_lbl_rrhh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 30, 30));

        panelu1_task_lbl_rrhh.setText("Tareas");
        panelu1.add(panelu1_task_lbl_rrhh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 20));

        panelu1_cambiarcontent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelu1_cambiarcontent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                panelu1_cambiarcontentItemStateChanged(evt);
            }
        });
        panelu1_cambiarcontent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelu1_cambiarcontentPropertyChange(evt);
            }
        });
        panelu1.add(panelu1_cambiarcontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));

        panelHeader.add(panelu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 100));

        panelu2.setOpaque(false);
        panelu2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelu2_title_lbl_cont.setText("Contabilidad");
        panelu2.add(panelu2_title_lbl_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 20));

        panelu2_number_lbl_cont.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        panelu2_number_lbl_cont.setText("0");
        panelu2.add(panelu2_number_lbl_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 46, 30, 30));
        panelu2.add(panelu2_icon_lbl_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 30, 30));

        panelu2_task_lbl_cont.setText("Tareas");
        panelu2.add(panelu2_task_lbl_cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 20));

        panelu2_cambiarcontent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelu2_cambiarcontent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                panelu2_cambiarcontentItemStateChanged(evt);
            }
        });
        panelu2_cambiarcontent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelu2_cambiarcontentPropertyChange(evt);
            }
        });
        panelu2.add(panelu2_cambiarcontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        panelHeader.add(panelu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 190, 100));

        panelu3.setOpaque(false);
        panelu3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelu3_title_lbl_dir.setText("Direccion");
        panelu3.add(panelu3_title_lbl_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 10, 160, 20));

        panelu3_number_lbl_dir.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        panelu3_number_lbl_dir.setText("0");
        panelu3.add(panelu3_number_lbl_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, 30));
        panelu3.add(panelu3_icon_lbl_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 30, 30));

        panelu3_task_lbl_dir.setText("Tareas");
        panelu3.add(panelu3_task_lbl_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 20));

        panelu3_cambiarcontent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelu3_cambiarcontent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                panelu3_cambiarcontentItemStateChanged(evt);
            }
        });
        panelu3_cambiarcontent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelu3_cambiarcontentPropertyChange(evt);
            }
        });
        panelu3.add(panelu3_cambiarcontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        panelHeader.add(panelu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 190, 100));

        panelu4.setOpaque(false);
        panelu4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelu4_title_lbl_logi.setText("Logistica");
        panelu4.add(panelu4_title_lbl_logi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 20));

        panelu4_number_lbl_logi.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        panelu4_number_lbl_logi.setText("0");
        panelu4.add(panelu4_number_lbl_logi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, -1));
        panelu4.add(panelu4_icon_lbl_logi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 30, 30));

        panelu4_task_lbl_logi.setText("Tareas");
        panelu4.add(panelu4_task_lbl_logi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 20));

        panelu4_cambiarcontent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelu4_cambiarcontent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                panelu4_cambiarcontentItemStateChanged(evt);
            }
        });
        panelu4_cambiarcontent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelu4_cambiarcontentPropertyChange(evt);
            }
        });
        panelu4.add(panelu4_cambiarcontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));

        panelHeader.add(panelu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 180, 100));

        BtnConfiguracionHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnConfiguracionHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConfiguracionHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnConfiguracionHeaderMouseClicked(evt);
            }
        });
        panelHeader.add(BtnConfiguracionHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 35, 35));

        cancelar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelar.setText("Cancelar");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });
        cancelar_pnl.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 20));

        panelHeader.add(cancelar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 50, 20));

        guardar_pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guardar_cambios.setForeground(new java.awt.Color(255, 255, 255));
        guardar_cambios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardar_cambios.setText("Guardar");
        guardar_cambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardar_cambiosMouseClicked(evt);
            }
        });
        guardar_pnl.add(guardar_cambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 20));

        panelHeader.add(guardar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 50, 20));

        PanelIncial.add(panelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 850, 120));

        vistas.add(PanelIncial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 690));

        PanelGestion.setBackground(new java.awt.Color(255, 255, 255));
        PanelGestion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gestion_contenedor_usuarios_pnl.setBackground(new java.awt.Color(255, 255, 255));
        gestion_contenedor_usuarios_pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestion_contenedor_usuarios_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gestion_btn_adduser_lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestion_btn_adduser_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestion_btn_adduser_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestion_btn_adduser_lblMouseClicked(evt);
            }
        });
        gestion_contenedor_usuarios_pnl.add(gestion_btn_adduser_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 7, 35, 35));

        gestion_titulouser_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gestion_titulouser_titulo_lbl.setText("Usuarios");
        gestion_contenedor_usuarios_pnl.add(gestion_titulouser_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        scroll_lista_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scroll_lista_usuarioMouseClicked(evt);
            }
        });

        gestion_lista_user_table = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        gestion_lista_user_table.setAutoCreateRowSorter(true);
        gestion_lista_user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        gestion_lista_user_table.setAutoscrolls(false);
        gestion_lista_user_table.setCellSelectionEnabled(true);
        gestion_lista_user_table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestion_lista_user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestion_lista_user_tableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gestion_lista_user_tableMouseEntered(evt);
            }
        });
        scroll_lista_usuario.setViewportView(gestion_lista_user_table);

        gestion_contenedor_usuarios_pnl.add(scroll_lista_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 830, 250));

        PanelGestion.add(gestion_contenedor_usuarios_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 850, 320));

        gestion_contenedor_roles_pnl.setBackground(new java.awt.Color(255, 255, 255));
        gestion_contenedor_roles_pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestion_contenedor_roles_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gestion_btn_addrol_lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestion_btn_addrol_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestion_btn_addrol_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestion_btn_addrol_lblMouseClicked(evt);
            }
        });
        gestion_contenedor_roles_pnl.add(gestion_btn_addrol_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 35, 35));

        gestion_titulorol_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gestion_titulorol_titulo_lbl.setText("Roles");
        gestion_contenedor_roles_pnl.add(gestion_titulorol_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        gestion_lista_rol_table = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        gestion_lista_rol_table.setAutoCreateRowSorter(true);
        gestion_lista_rol_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        gestion_lista_rol_table.setCellSelectionEnabled(true);
        gestion_lista_rol_table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestion_lista_rol_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestion_lista_rol_tableMouseClicked(evt);
            }
        });
        scroll_lista_roles.setViewportView(gestion_lista_rol_table);

        gestion_contenedor_roles_pnl.add(scroll_lista_roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 400, 280));

        PanelGestion.add(gestion_contenedor_roles_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 420, 340));

        gestion_contenedor_unidades_pnl.setBackground(new java.awt.Color(255, 255, 255));
        gestion_contenedor_unidades_pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestion_contenedor_unidades_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gestion_btn_addunidad_lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gestion_btn_addunidad_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestion_btn_addunidad_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestion_btn_addunidad_lblMouseClicked(evt);
            }
        });
        gestion_contenedor_unidades_pnl.add(gestion_btn_addunidad_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 10, 35, 35));

        gestion_titulounidad_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gestion_titulounidad_titulo_lbl.setText("Unidades");
        gestion_contenedor_unidades_pnl.add(gestion_titulounidad_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        gestion_lista_unidad_table = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        gestion_lista_unidad_table.setAutoCreateRowSorter(true);
        gestion_lista_unidad_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        gestion_lista_unidad_table.setCellSelectionEnabled(true);
        gestion_lista_unidad_table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestion_lista_unidad_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestion_lista_unidad_tableMouseClicked(evt);
            }
        });
        scroll_lista_unidad.setViewportView(gestion_lista_unidad_table);

        gestion_contenedor_unidades_pnl.add(scroll_lista_unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 400, 280));

        PanelGestion.add(gestion_contenedor_unidades_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 420, 340));

        vistas.add(PanelGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 690));

        PanelFondo.add(vistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 860, 690));
        PanelFondo.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 790));

        getContentPane().add(PanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExitKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitKeyPressed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        conn.desconectar();
        dispose();

    }//GEN-LAST:event_ExitMouseClicked

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void BarraLimiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraLimiteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BarraLimiteMouseClicked

    private void BarraLimiteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraLimiteMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BarraLimiteMousePressed

    private void BarraLimiteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraLimiteMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BarraLimiteMouseDragged

    private void HomeleftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeleftMouseClicked
        conn.listar("FLUJO", flujos_contenedor_tabla, "ID_FLUJO");
        panelu1_number_lbl_rrhh.setText(String.valueOf(conn.contarTareas(panelu1_title_lbll_rrhh.getText())));
        panelu2_number_lbl_cont.setText(String.valueOf(conn.contarTareas(panelu2_title_lbl_cont.getText())));
        panelu3_number_lbl_dir.setText(String.valueOf(conn.contarTareas(panelu3_title_lbl_dir.getText())));
        panelu4_number_lbl_logi.setText(String.valueOf(conn.contarTareas(panelu4_title_lbl_logi.getText())));
        DefaultPieDataset torta = new DefaultPieDataset();
        torta.setValue("En Proceso", 30);
        torta.setValue("Pendiente", 20);
        torta.setValue("Cerrado", 50);

        JFreeChart greaficoTorta = ChartFactory.createRingChart(panelu1_title_lbll_rrhh.getText(), torta, true, true, false);
        ChartPanel graficotortapnl = new ChartPanel(greaficoTorta);
        //graficotortapnl.setSize(new Dimension(260, 220));
        ContenedorTorta.setLayout(new BorderLayout());
        ContenedorTorta.add(graficotortapnl, BorderLayout.CENTER);
        DefaultCategoryDataset barras = new DefaultCategoryDataset();

        barras.setValue(Integer.parseInt(panelu1_number_lbl_rrhh.getText()), panelu1_task_lbl_rrhh.getText(), panelu1_title_lbll_rrhh.getText());
        barras.setValue(Integer.parseInt(panelu2_number_lbl_cont.getText()), panelu2_task_lbl_cont.getText(), panelu2_title_lbl_cont.getText());
        barras.setValue(Integer.parseInt(panelu3_number_lbl_dir.getText()), panelu3_task_lbl_dir.getText(), panelu3_title_lbl_dir.getText());
        barras.setValue(Integer.parseInt(panelu4_number_lbl_logi.getText()), panelu4_task_lbl_logi.getText(), panelu4_title_lbl_logi.getText());
        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "Total Tareas por Departamento",
                "Departamento",
                "Tareas",
                barras,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel graficoBarrapnl = new ChartPanel(grafico_barras);
        //graficoBarrapnl.setPreferredSize(new Dimension(200,100));

        ContenedorGraficos.setLayout(new BorderLayout());
        ContenedorGraficos.add(graficoBarrapnl, BorderLayout.CENTER);

        conn.rellenarCbox("UNIDAD_INTERNA", panelu1_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu2_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu3_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu4_cambiarcontent);

        panelu1_cambiarcontent.setSelectedItem(panelu1_title_lbll_rrhh.getText());
        panelu2_cambiarcontent.setSelectedItem(panelu2_title_lbl_cont.getText());
        panelu3_cambiarcontent.setSelectedItem(panelu3_title_lbl_dir.getText());
        panelu4_cambiarcontent.setSelectedItem(panelu4_title_lbl_logi.getText());

        pack();
        repaint();
        PanelGestion.setVisible(false);
        PanelGestion.setEnabled(false);
        PanelGestion.setFocusable(false);
        PanelIncial.setVisible(true);
        PanelIncial.setEnabled(true);
        PanelIncial.setFocusable(true);

    }//GEN-LAST:event_HomeleftMouseClicked

    private void GestionleftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionleftMouseClicked
        PanelGestion.setVisible(true);
        PanelGestion.setEnabled(true);
        PanelGestion.setFocusable(true);
        PanelIncial.setVisible(false);
        PanelIncial.setEnabled(false);
        PanelIncial.setFocusable(false);
        //MetodosBD.ConexionOracle conn = new MetodosBD.ConexionOracle();
        conn.listar("USUARIO", gestion_lista_user_table, "ID_USR");
        conn.listar("TAREA_ROL", gestion_lista_rol_table, "ID_TR");
        conn.listar("UNIDAD_INTERNA", gestion_lista_unidad_table, "ID_UNIDAD");


    }//GEN-LAST:event_GestionleftMouseClicked

    private void btnagregarflujoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarflujoMouseClicked
        Object[] elementos = new Object[]{"crear", this, flujos_contenedor_tabla};
        Flujos ventanaCrear = new Flujos(elementos, conn);
        setEnabled(false);
        ventanaCrear.setVisible(true);


    }//GEN-LAST:event_btnagregarflujoMouseClicked

    private void HomelblbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomelblbtnMouseClicked
        PanelGestion.setVisible(false);
        PanelGestion.setEnabled(false);
        PanelGestion.setFocusable(false);
        PanelIncial.setVisible(true);
        PanelIncial.setEnabled(true);
        PanelIncial.setFocusable(true);

    }//GEN-LAST:event_HomelblbtnMouseClicked

    private void GestionlblbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GestionlblbtnMouseClicked
        PanelGestion.setVisible(true);
        PanelGestion.setEnabled(true);
        PanelGestion.setFocusable(true);
        PanelIncial.setVisible(false);
        PanelIncial.setEnabled(false);
        PanelIncial.setFocusable(false);

    }//GEN-LAST:event_GestionlblbtnMouseClicked

    private void gestion_btn_addrol_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_btn_addrol_lblMouseClicked
        Object[] elementos = new Object[]{"crear", this, gestion_lista_rol_table};
        Roles rol = new Roles(elementos, conn);
        rol.setVisible(true);
        setEnabled(false);
    }//GEN-LAST:event_gestion_btn_addrol_lblMouseClicked

    private void gestion_btn_addunidad_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_btn_addunidad_lblMouseClicked
        Object[] args = new Object[]{
            "crear",
            this,
            gestion_lista_unidad_table
        };
        Unidades und = new Unidades(args, conn);
        und.setVisible(true);

    }//GEN-LAST:event_gestion_btn_addunidad_lblMouseClicked

    private void gestion_btn_adduser_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_btn_adduser_lblMouseClicked
        Object[] elementos = new Object[]{"crear", this, gestion_lista_user_table};
        Usuarios us = new Usuarios(elementos, conn);
        us.setVisible(true);
    }//GEN-LAST:event_gestion_btn_adduser_lblMouseClicked

    private void apagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apagarMouseClicked
        Object[] cerrar;
        cerrar = new Object[]{"¿Seguro que deseas cerrar sesion?", this, null, 0, "cerrar", ""};
        ConfirmarAccion conf = new ConfirmarAccion(cerrar, conn);
        conf.setVisible(true);
    }//GEN-LAST:event_apagarMouseClicked

    private void gestion_lista_user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_lista_user_tableMouseClicked
        columna = gestion_lista_user_table.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / gestion_lista_user_table.getRowHeight();

        if (columna <= gestion_lista_user_table.getColumnCount() && columna >= 0 && row <= gestion_lista_user_table.getRowCount() && row >= 0) {
            Object objeto = gestion_lista_user_table.getValueAt(row, columna);
            if (objeto instanceof JLabel) {
                JLabel boton = (JLabel) objeto;
                if (boton.getName().equals("Editar")) {
                    Object[] elementos;
                    elementos = new Object[]{
                        "editar", this, gestion_lista_user_table
                    };

                    Usuarios us = new Usuarios(elementos, conn);
                    us.setVisible(true);

                } else if (boton.getName().equals("Eliminar")) {
                    String rut = gestion_lista_user_table.getValueAt(gestion_lista_user_table.getSelectedRow(), 1).toString();
                    Object[] confirmar;
                    String obj = conn.obtenerIDusuario(rut, this);
                    String nombre = (String) gestion_lista_user_table.getValueAt(gestion_lista_user_table.getSelectedRow(), 0);
                    int id = Integer.parseInt(obj);
                    confirmar = new Object[]{"¿Eliminar Usuario " + nombre + "?", this, gestion_lista_user_table, id, "eliminar", "usr"};
                    if (rut.equals(usrcon)) {
                        Error err = new Error("Usuario conectado, imposible eliminar", this, this);
                        err.setVisible(true);
                    } else {
                        ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
                        conf.setVisible(true);
                    }
                }
            }
        }

    }//GEN-LAST:event_gestion_lista_user_tableMouseClicked

    private void gestion_lista_user_tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_lista_user_tableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_gestion_lista_user_tableMouseEntered

    private void BtnConfiguracionHeaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConfiguracionHeaderMouseClicked
        conn.rellenarCbox("UNIDAD_INTERNA", panelu1_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu2_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu3_cambiarcontent);
        conn.rellenarCbox("UNIDAD_INTERNA", panelu4_cambiarcontent);
        //conn.rellenarCbox("UNIDAD_INTERNA", graficotorta_Cbox);
        //graficotorta_Cbox.setSelectedItem(panelu1_title_lbll_rrhh.getText());
        panelu1_cambiarcontent.setSelectedItem(panelu1_title_lbll_rrhh.getText());
        panelu2_cambiarcontent.setSelectedItem(panelu2_title_lbl_cont.getText());
        panelu3_cambiarcontent.setSelectedItem(panelu3_title_lbl_dir.getText());
        panelu4_cambiarcontent.setSelectedItem(panelu4_title_lbl_logi.getText());

        panelu1_cambiarcontent.setVisible(true);
        panelu2_cambiarcontent.setVisible(true);
        panelu3_cambiarcontent.setVisible(true);
        panelu4_cambiarcontent.setVisible(true);
        panelu1_cambiarcontent.setEnabled(true);
        panelu2_cambiarcontent.setEnabled(true);
        panelu3_cambiarcontent.setEnabled(true);
        panelu4_cambiarcontent.setEnabled(true);
        panelu1_cambiarcontent.setFocusable(true);
        panelu2_cambiarcontent.setFocusable(true);
        panelu3_cambiarcontent.setFocusable(true);
        panelu4_cambiarcontent.setFocusable(true);
        guardar_pnl.setVisible(true);
        guardar_pnl.setFocusable(true);
        guardar_pnl.setEnabled(true);
        guardar_pnl.setOpaque(false);
        cancelar_pnl.setFocusable(true);
        cancelar_pnl.setVisible(true);
        cancelar_pnl.setEnabled(true);
        cancelar_pnl.setOpaque(false);
        panelu1_title_lbll_rrhh.setVisible(false);
        panelu1_title_lbll_rrhh.setFocusable(false);
        panelu2_title_lbl_cont.setVisible(false);
        panelu2_title_lbl_cont.setFocusable(false);
        panelu3_title_lbl_dir.setVisible(false);
        panelu3_title_lbl_dir.setFocusable(false);
        panelu4_title_lbl_logi.setVisible(false);
        panelu4_title_lbl_logi.setFocusable(false);
        BtnConfiguracionHeader.setVisible(false);
        BtnConfiguracionHeader.setFocusable(false);
        BtnConfiguracionHeader.setEnabled(false);

        panelu1_cambiarcontent.setSelectedItem(panelu1_title_lbll_rrhh.getText());
        panelu2_cambiarcontent.setSelectedItem(panelu2_title_lbl_cont.getText());
        panelu3_cambiarcontent.setSelectedItem(panelu3_title_lbl_dir.getText());
        panelu4_cambiarcontent.setSelectedItem(panelu4_title_lbl_logi.getText());


    }//GEN-LAST:event_BtnConfiguracionHeaderMouseClicked

    private void guardar_cambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardar_cambiosMouseClicked
        cboxes = new String[]{
            String.valueOf(panelu1_cambiarcontent.getSelectedItem()),
            String.valueOf(panelu2_cambiarcontent.getSelectedItem()),
            String.valueOf(panelu3_cambiarcontent.getSelectedItem()),
            String.valueOf(panelu4_cambiarcontent.getSelectedItem())
        };
        boolean esdistinto = Metodos.MetodosFront.cboxdistintos(cboxes);
        if (esdistinto) {
            panelu1_cambiarcontent.setVisible(false);
            panelu2_cambiarcontent.setVisible(false);
            panelu3_cambiarcontent.setVisible(false);
            panelu4_cambiarcontent.setVisible(false);
            panelu1_cambiarcontent.setEnabled(false);
            panelu2_cambiarcontent.setEnabled(false);
            panelu3_cambiarcontent.setEnabled(false);
            panelu4_cambiarcontent.setEnabled(false);
            panelu1_cambiarcontent.setFocusable(false);
            panelu2_cambiarcontent.setFocusable(false);
            panelu3_cambiarcontent.setFocusable(false);
            panelu4_cambiarcontent.setFocusable(false);
            guardar_pnl.setVisible(false);
            guardar_pnl.setFocusable(false);
            guardar_pnl.setEnabled(false);
            guardar_pnl.setOpaque(false);
            cancelar_pnl.setFocusable(false);
            cancelar_pnl.setVisible(false);
            cancelar_pnl.setEnabled(false);
            cancelar_pnl.setOpaque(false);
            panelu1_title_lbll_rrhh.setVisible(true);
            panelu2_title_lbl_cont.setVisible(true);
            panelu3_title_lbl_dir.setVisible(true);
            panelu4_title_lbl_logi.setVisible(true);
            panelu1_title_lbll_rrhh.setFocusable(true);
            panelu2_title_lbl_cont.setFocusable(true);
            panelu3_title_lbl_dir.setFocusable(true);
            panelu4_title_lbl_logi.setFocusable(true);
            BtnConfiguracionHeader.setVisible(true);
            BtnConfiguracionHeader.setFocusable(true);
            BtnConfiguracionHeader.setEnabled(true);

            panelu1_title_lbll_rrhh.setText((String) panelu1_cambiarcontent.getSelectedItem());
            panelu2_title_lbl_cont.setText((String) panelu2_cambiarcontent.getSelectedItem());
            panelu3_title_lbl_dir.setText((String) panelu3_cambiarcontent.getSelectedItem());
            panelu4_title_lbl_logi.setText((String) panelu4_cambiarcontent.getSelectedItem());
            panelu1_number_lbl_rrhh.setText(String.valueOf(conn.contarTareas(panelu1_title_lbll_rrhh.getText())));
            panelu2_number_lbl_cont.setText(String.valueOf(conn.contarTareas(panelu2_title_lbl_cont.getText())));
            panelu3_number_lbl_dir.setText(String.valueOf(conn.contarTareas(panelu3_title_lbl_dir.getText())));
            panelu4_number_lbl_logi.setText(String.valueOf(conn.contarTareas(panelu4_title_lbl_logi.getText())));

            String[] datos = conn.obtenerdatosTorta(panelu1_title_lbll_rrhh.getText());
            List<String> datossinnulos = new ArrayList<>(Arrays.asList(datos));
            datossinnulos.removeIf(Objects::isNull);
            DefaultPieDataset torta = new DefaultPieDataset();
            for (int i = 0; i < datossinnulos.size(); i++) {
                torta.setValue((String) datossinnulos.get(i), Integer.parseInt(datossinnulos.get(i + 1)));
                i++;
            }

            JFreeChart greaficoTorta = ChartFactory.createRingChart(panelu1_title_lbll_rrhh.getText(), torta, true, true, false);
            ChartPanel graficotortapnl = new ChartPanel(greaficoTorta);

            ContenedorTorta.removeAll();
            ContenedorTorta.setLayout(new BorderLayout());
            ContenedorTorta.add(graficotortapnl, BorderLayout.CENTER);
            DefaultCategoryDataset barras = new DefaultCategoryDataset();

            barras.setValue(Integer.parseInt(panelu1_number_lbl_rrhh.getText()), panelu1_task_lbl_rrhh.getText(), panelu1_title_lbll_rrhh.getText());
            barras.setValue(Integer.parseInt(panelu2_number_lbl_cont.getText()), panelu2_task_lbl_cont.getText(), panelu2_title_lbl_cont.getText());
            barras.setValue(Integer.parseInt(panelu3_number_lbl_dir.getText()), panelu3_task_lbl_dir.getText(), panelu3_title_lbl_dir.getText());
            barras.setValue(Integer.parseInt(panelu4_number_lbl_logi.getText()), panelu4_task_lbl_logi.getText(), panelu4_title_lbl_logi.getText());
            JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                    "Total Tareas por Departamento",
                    "Departamento",
                    "Tareas",
                    barras,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            ChartPanel graficoBarrapnl = new ChartPanel(grafico_barras);

            ContenedorGraficos.removeAll();

            ContenedorGraficos.setLayout(new BorderLayout());
            ContenedorGraficos.add(graficoBarrapnl, BorderLayout.CENTER);

            conn.rellenarCbox("UNIDAD_INTERNA", panelu1_cambiarcontent);
            conn.rellenarCbox("UNIDAD_INTERNA", panelu2_cambiarcontent);
            conn.rellenarCbox("UNIDAD_INTERNA", panelu3_cambiarcontent);
            conn.rellenarCbox("UNIDAD_INTERNA", panelu4_cambiarcontent);

            panelu1_cambiarcontent.setSelectedItem(panelu1_title_lbll_rrhh.getText());
            panelu2_cambiarcontent.setSelectedItem(panelu2_title_lbl_cont.getText());
            panelu3_cambiarcontent.setSelectedItem(panelu3_title_lbl_dir.getText());
            panelu4_cambiarcontent.setSelectedItem(panelu4_title_lbl_logi.getText());

            pack();
            repaint();

        } else {
            Error err = new Error("Las unidades deben ser diferentes", this, this);
            err.setVisible(true);
        }


    }//GEN-LAST:event_guardar_cambiosMouseClicked

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        panelu1_cambiarcontent.setVisible(false);
        panelu2_cambiarcontent.setVisible(false);
        panelu3_cambiarcontent.setVisible(false);
        panelu4_cambiarcontent.setVisible(false);
        panelu1_cambiarcontent.setEnabled(false);
        panelu2_cambiarcontent.setEnabled(false);
        panelu3_cambiarcontent.setEnabled(false);
        panelu4_cambiarcontent.setEnabled(false);
        panelu1_cambiarcontent.setFocusable(false);
        panelu2_cambiarcontent.setFocusable(false);
        panelu3_cambiarcontent.setFocusable(false);
        panelu4_cambiarcontent.setFocusable(false);
        guardar_pnl.setVisible(false);
        guardar_pnl.setFocusable(false);
        guardar_pnl.setEnabled(false);
        guardar_pnl.setOpaque(false);
        cancelar_pnl.setFocusable(false);
        cancelar_pnl.setVisible(false);
        cancelar_pnl.setEnabled(false);
        cancelar_pnl.setOpaque(false);
        panelu1_title_lbll_rrhh.setVisible(true);
        panelu2_title_lbl_cont.setVisible(true);
        panelu3_title_lbl_dir.setVisible(true);
        panelu4_title_lbl_logi.setVisible(true);
        panelu1_title_lbll_rrhh.setFocusable(true);
        panelu2_title_lbl_cont.setFocusable(true);
        panelu3_title_lbl_dir.setFocusable(true);
        panelu4_title_lbl_logi.setFocusable(true);
        BtnConfiguracionHeader.setVisible(true);
        BtnConfiguracionHeader.setFocusable(true);
        BtnConfiguracionHeader.setEnabled(true);
        panelu1_cambiarcontent.setSelectedItem(panelu1_title_lbll_rrhh.getText());
        panelu2_cambiarcontent.setSelectedItem(panelu2_title_lbl_cont.getText());
        panelu3_cambiarcontent.setSelectedItem(panelu3_title_lbl_dir.getText());
        panelu4_cambiarcontent.setSelectedItem(panelu4_title_lbl_logi.getText());


    }//GEN-LAST:event_cancelarMouseClicked

    private void scroll_lista_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scroll_lista_usuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scroll_lista_usuarioMouseClicked

    private void flujos_contenedor_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flujos_contenedor_tablaMouseClicked
        columna = flujos_contenedor_tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / flujos_contenedor_tabla.getRowHeight();
        if (columna <= flujos_contenedor_tabla.getColumnCount() && columna >= 0 && row <= flujos_contenedor_tabla.getRowCount() && row >= 0) {
            Object objeto = flujos_contenedor_tabla.getValueAt(row, columna);
            if (objeto instanceof JLabel) {
                JLabel boton = (JLabel) objeto;
                if (boton.getName().equals("Editar")) {
                    try {
                        Object[] obj;
                        Date fechainiDate;
                        Date fechacreaDate;
                        Date fechaterDate;
                        Date fechaactual = new Date(System.currentTimeMillis());
                        String fechacrea = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 1);
                        String fechaini = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 2);
                        String fechater = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 3);
                        String Estado = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 4);
                        String desc = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 0);
                        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                        fechacreaDate = date.parse(fechacrea);
                        fechainiDate = date.parse(fechaini);
                        fechaterDate = date.parse(fechater);
                        String idflujo = String.valueOf(conn.obteneridFlujo(desc));
                        String progreso = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 5);
                        obj = new Object[]{"editar",
                            this,
                            flujos_contenedor_tabla,
                            idflujo,
                            fechacreaDate,
                            fechainiDate,
                            fechaterDate,
                            Estado,
                            desc,
                            progreso

                        };
                        Flujos flujo = new Flujos(obj, conn);
                        flujo.setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (boton.getName().equals("Eliminar")) {
                    Object[] confirmar;
                    String nombre = (String) flujos_contenedor_tabla.getValueAt(flujos_contenedor_tabla.getSelectedRow(), 0);
                    int id = conn.obteneridFlujo(nombre);
                    confirmar = new Object[]{"¿Eliminar Flujo " + nombre + "?", this, flujos_contenedor_tabla, id, "eliminar", "flujo"};
                    ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
                    conf.setVisible(true);
                }
            }
        }


    }//GEN-LAST:event_flujos_contenedor_tablaMouseClicked

    private void panelu1_cambiarcontentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelu1_cambiarcontentPropertyChange


    }//GEN-LAST:event_panelu1_cambiarcontentPropertyChange

    private void panelu2_cambiarcontentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelu2_cambiarcontentPropertyChange

    }//GEN-LAST:event_panelu2_cambiarcontentPropertyChange

    private void panelu3_cambiarcontentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelu3_cambiarcontentPropertyChange


    }//GEN-LAST:event_panelu3_cambiarcontentPropertyChange

    private void panelu4_cambiarcontentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelu4_cambiarcontentPropertyChange

    }//GEN-LAST:event_panelu4_cambiarcontentPropertyChange

    private void panelu1_cambiarcontentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_panelu1_cambiarcontentItemStateChanged
        panelu1_number_lbl_rrhh.setText(String.valueOf(conn.contarTareas((String) panelu1_cambiarcontent.getSelectedItem())));

    }//GEN-LAST:event_panelu1_cambiarcontentItemStateChanged

    private void panelu2_cambiarcontentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_panelu2_cambiarcontentItemStateChanged
        panelu2_number_lbl_cont.setText(String.valueOf(conn.contarTareas((String) panelu2_cambiarcontent.getSelectedItem())));
    }//GEN-LAST:event_panelu2_cambiarcontentItemStateChanged

    private void panelu3_cambiarcontentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_panelu3_cambiarcontentItemStateChanged
        panelu3_number_lbl_dir.setText(String.valueOf(conn.contarTareas((String) panelu3_cambiarcontent.getSelectedItem())));
    }//GEN-LAST:event_panelu3_cambiarcontentItemStateChanged

    private void panelu4_cambiarcontentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_panelu4_cambiarcontentItemStateChanged
        panelu4_number_lbl_logi.setText(String.valueOf(conn.contarTareas((String) panelu4_cambiarcontent.getSelectedItem())));
    }//GEN-LAST:event_panelu4_cambiarcontentItemStateChanged

    private void gestion_lista_unidad_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_lista_unidad_tableMouseClicked
        columna = gestion_lista_unidad_table.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / gestion_lista_unidad_table.getRowHeight();
        if (columna <= gestion_lista_unidad_table.getColumnCount() && columna >= 0 && row <= gestion_lista_unidad_table.getRowCount() && row >= 0) {
            Object objeto = gestion_lista_unidad_table.getValueAt(row, columna);
            if (objeto instanceof JLabel) {
                JLabel boton = (JLabel) objeto;
                if (boton.getName().equals("Editar")) {
                    try {
                        Object[] obj;
                        String unidad = (String) gestion_lista_unidad_table.getValueAt(gestion_lista_unidad_table.getSelectedRow(), 0);

                        obj = new Object[]{
                            "editar",
                            this,
                            gestion_lista_unidad_table,
                            unidad

                        };
                        Unidades uni = new Unidades(obj, conn);
                        uni.setVisible(true);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                } else if (boton.getName().equals("Eliminar")) {
                    Object[] confirmar;
                    String unidad = (String) gestion_lista_unidad_table.getValueAt(gestion_lista_unidad_table.getSelectedRow(), 0);
                    int idunidad = conn.obteneridUnidad(unidad);
                    String[] args = new String[]{
                        unidad,
                        String.valueOf(idunidad)
                    };
                    confirmar = new Object[]{"¿Eliminar unidad " + unidad + "?", this, gestion_lista_unidad_table, idunidad, "eliminar", "unidad"};
                    ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
                    conf.setVisible(true);
                }
            }
        }

    }//GEN-LAST:event_gestion_lista_unidad_tableMouseClicked

    private void gestion_lista_rol_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestion_lista_rol_tableMouseClicked
        columna = gestion_lista_rol_table.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / gestion_lista_rol_table.getRowHeight();
        if (columna <= gestion_lista_rol_table.getColumnCount() && columna >= 0 && row <= gestion_lista_rol_table.getRowCount() && row >= 0) {
            Object objeto = gestion_lista_rol_table.getValueAt(row, columna);
            if (objeto instanceof JLabel) {
                JLabel boton = (JLabel) objeto;
                if (boton.getName().equals("Editar")) {
                    try {
                        Object[] obj;
                        String rolempresa = (String) gestion_lista_rol_table.getValueAt(gestion_lista_rol_table.getSelectedRow(), 0);

                        obj = new Object[]{
                            "editar",
                            this,
                            gestion_lista_rol_table,
                            rolempresa

                        };
                        Roles Rol = new Roles(obj, conn);
                        Rol.setVisible(true);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                } else if (boton.getName().equals("Eliminar")) {
                    Object[] confirmar;
                    String rolemp = (String) gestion_lista_rol_table.getValueAt(gestion_lista_rol_table.getSelectedRow(), 0);
                    int idrol = conn.obteneridRol(rolemp);
                    String[] args = new String[]{
                        rolemp,
                        String.valueOf(idrol)
                    };
                    confirmar = new Object[]{"¿Eliminar rol " + rolemp + "?", this, gestion_lista_rol_table, idrol, "eliminar", "rol"};
                    ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
                    conf.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_gestion_lista_rol_tableMouseClicked

    private void offbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offbtnMouseClicked
        Object[] cerrar;
        cerrar = new Object[]{"¿Seguro que deseas cerrar sesion?", this, null, 0, "cerrar", ""};
        ConfirmarAccion conf = new ConfirmarAccion(cerrar, conn);
        conf.setVisible(true);
    }//GEN-LAST:event_offbtnMouseClicked

    private void Generar_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Generar_reporteMouseClicked

        Rectangle pageSize = new Rectangle(getWidth(), getHeight()); //ancho y alto
        BufferedImage img = new BufferedImage(PanelIncial.getWidth(), PanelIncial.getHeight(), BufferedImage.TYPE_INT_RGB);
        SimpleDateFormat ff = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
        Date fechacreacion = new Date();
        String fechacrea = ff.format(fechacreacion);
        PanelIncial.paint(img.getGraphics());
        File outputfile = new File("src/main/resources/Reportes/reporte" + fechacrea + ".png");
        try {
            ImageIO.write(img, "png", outputfile);

        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document document = new Document(pageSize);
        String input = outputfile.getPath(); // .gif and .jpg are ok too!
        String output = "src/main/resources/Reportes/reporte" + fechacrea + ".pdf";

        try {

            FileOutputStream fos = new FileOutputStream(output);
            PdfWriter writer = PdfWriter.getInstance(document, fos);
            writer.open();
            document.open();

            document.add(Image.getInstance(input));
            document.close();
            writer.close();
            outputfile.delete();
            Object[] abrirpdf;
            abrirpdf = new Object[]{"Creado nuevo reporte, ¿deseas abrirlo?", this, null, 0, "pdf", output};
            ConfirmarAccion conf = new ConfirmarAccion(abrirpdf, conn);
            conf.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_Generar_reporteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin("NICOLAS OPORTUS", "NICOLAS OPORTUS", new Metodos.MetodosBD.ConexionOracle()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraLateral;
    private javax.swing.JPanel BarraLimite;
    private javax.swing.JLabel BtnConfiguracionHeader;
    private javax.swing.JPanel Burgerpnl;
    private javax.swing.JPanel ContenedorGraficos;
    private javax.swing.JPanel ContenedorTorta;
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel FlujosContenedor;
    private javax.swing.JLabel Generar_reporte;
    private javax.swing.JLabel Gestionlblbtn;
    private javax.swing.JLabel Gestionleft;
    private javax.swing.JLabel Homelblbtn;
    private javax.swing.JLabel Homeleft;
    private javax.swing.JLabel Minimizar;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelGestion;
    private javax.swing.JPanel PanelIncial;
    private javax.swing.JPanel Superior;
    private javax.swing.JLabel apagar;
    private javax.swing.JLabel btnagregarflujo;
    private javax.swing.JLabel cancelar;
    private javax.swing.JPanel cancelar_pnl;
    private javax.swing.JLabel empresalogo;
    private javax.swing.JTable flujos_contenedor_tabla;
    private javax.swing.JLabel gestion_btn_addrol_lbl;
    private javax.swing.JLabel gestion_btn_addunidad_lbl;
    private javax.swing.JLabel gestion_btn_adduser_lbl;
    private javax.swing.JPanel gestion_contenedor_roles_pnl;
    private javax.swing.JPanel gestion_contenedor_unidades_pnl;
    private javax.swing.JPanel gestion_contenedor_usuarios_pnl;
    private javax.swing.JTable gestion_lista_rol_table;
    private javax.swing.JTable gestion_lista_unidad_table;
    private javax.swing.JTable gestion_lista_user_table;
    private javax.swing.JLabel gestion_titulorol_titulo_lbl;
    private javax.swing.JLabel gestion_titulounidad_titulo_lbl;
    private javax.swing.JLabel gestion_titulouser_titulo_lbl;
    private javax.swing.JLabel guardar_cambios;
    private javax.swing.JPanel guardar_pnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel logopersona;
    private javax.swing.JLabel nombreusuario;
    private javax.swing.JLabel offbtn;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelu1;
    private javax.swing.JComboBox<String> panelu1_cambiarcontent;
    private javax.swing.JLabel panelu1_icon_lbl_rrhh;
    private javax.swing.JLabel panelu1_number_lbl_rrhh;
    private javax.swing.JLabel panelu1_task_lbl_rrhh;
    private javax.swing.JLabel panelu1_title_lbll_rrhh;
    private javax.swing.JPanel panelu2;
    private javax.swing.JComboBox<String> panelu2_cambiarcontent;
    private javax.swing.JLabel panelu2_icon_lbl_cont;
    private javax.swing.JLabel panelu2_number_lbl_cont;
    private javax.swing.JLabel panelu2_task_lbl_cont;
    private javax.swing.JLabel panelu2_title_lbl_cont;
    private javax.swing.JPanel panelu3;
    private javax.swing.JComboBox<String> panelu3_cambiarcontent;
    private javax.swing.JLabel panelu3_icon_lbl_dir;
    private javax.swing.JLabel panelu3_number_lbl_dir;
    private javax.swing.JLabel panelu3_task_lbl_dir;
    private javax.swing.JLabel panelu3_title_lbl_dir;
    private javax.swing.JPanel panelu4;
    private javax.swing.JComboBox<String> panelu4_cambiarcontent;
    private javax.swing.JLabel panelu4_icon_lbl_logi;
    private javax.swing.JLabel panelu4_number_lbl_logi;
    private javax.swing.JLabel panelu4_task_lbl_logi;
    private javax.swing.JLabel panelu4_title_lbl_logi;
    private javax.swing.JLabel rol;
    private javax.swing.JScrollPane scroll_lista_flujo;
    private javax.swing.JScrollPane scroll_lista_roles;
    private javax.swing.JScrollPane scroll_lista_unidad;
    private javax.swing.JScrollPane scroll_lista_usuario;
    private javax.swing.JLayeredPane vistas;
    // End of variables declaration//GEN-END:variables
}
