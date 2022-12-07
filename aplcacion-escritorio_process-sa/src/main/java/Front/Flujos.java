/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front;

import Metodos.MetodosBD;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Nico Oportus
 */
public class Flujos extends javax.swing.JFrame {

    int xMouse, yMouse;
    String string, idflujo, progreso, desc;
    JFrame framep;
    Date fechainicial;
    Date fechacreacion;
    Date fechatermino;
    JTable table;

    MetodosBD.ConexionOracle conn;

    /**
     * Creates new form Flujo
     * @param obj
     * @param con
     */
    public Flujos(Object[] obj, MetodosBD.ConexionOracle con) {
        initComponents();
        conn = con;
        table = (JTable) obj[2];
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        setShape(forma);
        this.setComponentZOrder(labelFondo, 0);
        labelFondo.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.BLACK, false, null));
        labelFondo.setFocusable(false);
        labelFondo.setEnabled(false);
        addflujo_btn_guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        addflujo_btn_cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(242, 242, 242), true, new Color(242, 242, 242)));
        //addflujo_btn_guardar_lbl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8,68,164),false,null));
        addflujo_btn_cancelar_pnl.setOpaque(false);
        addflujo_btn_cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.LIGHT_GRAY));
        addflujo_btn_guardar_pnl.setOpaque(false);
        addflujo_btn_guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        editflujo_btn_cancelar_pnl.setOpaque(false);
        editflujo_btn_cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.LIGHT_GRAY));
        editflujo_btn_guardar_pnl.setOpaque(false);
        editflujo_btn_guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        if (obj[0].equals("crear")) {
            CrearFlujos.setVisible(true);
            CrearFlujos.setFocusable(true);
            CrearFlujos.setEnabled(true);
            EditarFlujo.setVisible(false);
            EditarFlujo.setFocusable(false);
            EditarFlujo.setEnabled(false);
            addflujo_btn_guardar_lbl.setVisible(false);

        } else {
            
            CrearFlujos.setVisible(false);
            CrearFlujos.setFocusable(false);
            CrearFlujos.setEnabled(false);
            EditarFlujo.setVisible(true);
            EditarFlujo.setFocusable(true);
            EditarFlujo.setEnabled(true);
            idflujo = (String) obj[3];
            editflujo_contenedores_fechcreacion_ftf.setDate((Date) obj[4]);
            editflujo_contenedores_fechinicio_ftf.setDate((Date) obj[5]);
            editflujo_contenedores_fechtermino_ftf.setDate((Date) obj[6]);
            editflujo_contenedores_estado_cbox.setSelectedItem(obj[7]);
            editflujo_contenedores_descripcion_ftf.setText((String) obj[8]);
            progreso = (String) obj[9];
            editflujo_contenedores_descripcion_ftf.setForeground(Color.BLACK);
            desc = (String) obj[8];

            try {
                Object[] campos = new Object[]{
                    editflujo_contenedores_descripcion_ftf,
                    editflujo_contenedores_fechinicio_ftf,
                    editflujo_contenedores_fechcreacion_ftf,
                    editflujo_contenedores_fechtermino_ftf
                };
                String descripcion = editflujo_contenedores_descripcion_ftf.getText();

                boolean descripcionrep = conn.descRep(editflujo_contenedores_descripcion_ftf);
                boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
                boolean llenos = Metodos.MetodosFront.flujolleno(campos);
                if (llenos && fechaOk && !descripcionrep) {
                    editflujo_btn_guardar_lbl_bloq.setVisible(false);

                    editflujo_btn_guardar_lbl.setVisible(true);
                    editflujo_btn_guardar_lbl.setEnabled(true);
                    editflujo_btn_guardar_lbl.setFocusable(true);

                } else {
                    editflujo_btn_guardar_lbl_bloq.setVisible(true);

                    editflujo_btn_guardar_lbl.setVisible(false);
                    editflujo_btn_guardar_lbl.setEnabled(false);
                    editflujo_btn_guardar_lbl.setFocusable(false);

                }
            } catch (Exception e) {
            }
        }

        framep = (JFrame) obj[1];
        framep.setEnabled(false);
        instruccionespnl.setOpaque(false);
        instruccionespnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.BLACK, true, Color.WHITE));
        instruccionespnl.setVisible(false);
        instruccionespnl.setEnabled(false);
        instruccionespnl.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flujos_principal_fondo_pnl = new javax.swing.JPanel();
        instruccionespnl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelsup = new javax.swing.JPanel();
        Exit8 = new javax.swing.JLabel();
        Instrucciones = new javax.swing.JLabel();
        CrearFlujos = new javax.swing.JPanel();
        addflujo_principal_contenedor_pnl = new javax.swing.JPanel();
        addflujo_principal_titulo_lbl = new javax.swing.JLabel();
        addflujo_principal_subtitulo_lbl = new javax.swing.JLabel();
        addflujo_titulo_fechfinal_lbl = new javax.swing.JLabel();
        addflujo_contenedor_fechatermino_ftf = new com.toedter.calendar.JDateChooser();
        addflujo_separador_divide_spr = new javax.swing.JSeparator();
        addflujo_btn_guardar_pnl = new javax.swing.JPanel();
        addflujo_btn_guardar_lbl_bloq = new javax.swing.JLabel();
        addflujo_btn_guardar_lbl = new javax.swing.JLabel();
        addflujo_btn_cancelar_pnl = new javax.swing.JPanel();
        addflujo_btn_cancelar_lbl = new javax.swing.JLabel();
        addflujo_titulo_fechInicio_lbl = new javax.swing.JLabel();
        addflujo_contenedor_fechainicio_ftf = new com.toedter.calendar.JDateChooser();
        addflujo_titulo_descripcion_lbl = new javax.swing.JLabel();
        addflujo_titulo_fechcreacion_lbl = new javax.swing.JLabel();
        addflujo_contenedor_fechacreacion_ftf = new com.toedter.calendar.JDateChooser();
        addflujo_contenedor_estado_cbox = new javax.swing.JComboBox<>();
        addflujo_titulo_estado_lbl = new javax.swing.JLabel();
        addflujo_contenedor_descripcion_jf = new javax.swing.JTextField();
        EditarFlujo = new javax.swing.JPanel();
        editflujo_principal_contenedor_pnl = new javax.swing.JPanel();
        editflujo_principal_titulo_lbl = new javax.swing.JLabel();
        editflujo_principal_subtitulo_lbl = new javax.swing.JLabel();
        editflujo_separador_divide_spr = new javax.swing.JSeparator();
        editflujo_btn_guardar_pnl = new javax.swing.JPanel();
        editflujo_btn_guardar_lbl_bloq = new javax.swing.JLabel();
        editflujo_btn_guardar_lbl = new javax.swing.JLabel();
        editflujo_btn_cancelar_pnl = new javax.swing.JPanel();
        editflujo_btn_cancelar_lbl = new javax.swing.JLabel();
        editflujo_titulo_fechfinal_lbl = new javax.swing.JLabel();
        editflujo_contenedores_fechtermino_ftf = new com.toedter.calendar.JDateChooser();
        editflujo_titulo_fechinicial_lbl = new javax.swing.JLabel();
        editflujo_contenedores_fechinicio_ftf = new com.toedter.calendar.JDateChooser();
        editflujo_titulo_fechcreacion_lbl = new javax.swing.JLabel();
        editflujo_contenedores_fechcreacion_ftf = new com.toedter.calendar.JDateChooser();
        editflujo_titulo_descripcion_lbl = new javax.swing.JLabel();
        editflujo_contenedores_estado_cbox = new javax.swing.JComboBox<>();
        editflujo_titulo_estado_lbl = new javax.swing.JLabel();
        editflujo_contenedores_descripcion_ftf = new javax.swing.JTextField();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(625, 375));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        flujos_principal_fondo_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instruccionespnl.setBackground(new java.awt.Color(255, 255, 255));
        instruccionespnl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                instruccionespnlPropertyChange(evt);
            }
        });
        instruccionespnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Fecha creacion debe ser antes o igual a la fecha de inicio o termino");
        instruccionespnl.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 30));

        jLabel3.setText("Fecha inicio debe ser antes de fecha termino y despues de creacion");
        instruccionespnl.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 30));

        jLabel4.setText("Fecha Termino debe ser despues o igual a fecha inicio o creacion");
        instruccionespnl.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 30));

        jLabel5.setText("La descripcion debe ser unica");
        instruccionespnl.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 370, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        instruccionespnl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 0, 20, 20));

        flujos_principal_fondo_pnl.add(instruccionespnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 25, 400, 155));

        panelsup.setBackground(new java.awt.Color(255, 255, 255));
        panelsup.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelsupMouseDragged(evt);
            }
        });
        panelsup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelsupMousePressed(evt);
            }
        });
        panelsup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Exit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit8.setText("X");
        Exit8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Exit8MouseClicked(evt);
            }
        });
        Exit8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Exit8KeyPressed(evt);
            }
        });
        panelsup.add(Exit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 25, 25));

        flujos_principal_fondo_pnl.add(panelsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Instrucciones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Instrucciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Instrucciones.setText("?");
        Instrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InstruccionesMouseClicked(evt);
            }
        });
        flujos_principal_fondo_pnl.add(Instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 35, 30, 30));

        CrearFlujos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addflujo_principal_contenedor_pnl.setBackground(new java.awt.Color(255, 255, 255));
        addflujo_principal_contenedor_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addflujo_principal_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addflujo_principal_titulo_lbl.setText("Crear Flujo");
        addflujo_principal_contenedor_pnl.add(addflujo_principal_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 243, -1));

        addflujo_principal_subtitulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addflujo_principal_subtitulo_lbl.setText("Detalles");
        addflujo_principal_contenedor_pnl.add(addflujo_principal_subtitulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        addflujo_titulo_fechfinal_lbl.setText("Fecha Termino");
        addflujo_principal_contenedor_pnl.add(addflujo_titulo_fechfinal_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 80, -1));

        addflujo_contenedor_fechatermino_ftf.setBackground(new java.awt.Color(255, 255, 255));
        addflujo_contenedor_fechatermino_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                addflujo_contenedor_fechatermino_ftfPropertyChange(evt);
            }
        });
        addflujo_principal_contenedor_pnl.add(addflujo_contenedor_fechatermino_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 150, 30));

        addflujo_separador_divide_spr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        addflujo_principal_contenedor_pnl.add(addflujo_separador_divide_spr, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 340));

        addflujo_btn_guardar_pnl.setBackground(new java.awt.Color(255, 255, 255));
        addflujo_btn_guardar_pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addflujo_btn_guardar_pnl.setForeground(new java.awt.Color(8, 68, 164));
        addflujo_btn_guardar_pnl.setToolTipText("");
        addflujo_btn_guardar_pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addflujo_btn_guardar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addflujo_btn_guardar_lbl_bloq.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addflujo_btn_guardar_lbl_bloq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addflujo_btn_guardar_lbl_bloq.setText("Guardar");
        addflujo_btn_guardar_lbl_bloq.setEnabled(false);
        addflujo_btn_guardar_lbl_bloq.setFocusable(false);
        addflujo_btn_guardar_lbl_bloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addflujo_btn_guardar_lbl_bloqMouseClicked(evt);
            }
        });
        addflujo_btn_guardar_pnl.add(addflujo_btn_guardar_lbl_bloq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        addflujo_btn_guardar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        addflujo_btn_guardar_lbl.setForeground(new java.awt.Color(255, 255, 255));
        addflujo_btn_guardar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addflujo_btn_guardar_lbl.setText("Guardar ");
        addflujo_btn_guardar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addflujo_btn_guardar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addflujo_btn_guardar_lblMouseClicked(evt);
            }
        });
        addflujo_btn_guardar_pnl.add(addflujo_btn_guardar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        addflujo_principal_contenedor_pnl.add(addflujo_btn_guardar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 120, -1));

        addflujo_btn_cancelar_pnl.setBackground(new java.awt.Color(255, 255, 255));
        addflujo_btn_cancelar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addflujo_btn_cancelar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addflujo_btn_cancelar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addflujo_btn_cancelar_lbl.setText("Cancelar");
        addflujo_btn_cancelar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addflujo_btn_cancelar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addflujo_btn_cancelar_lblMouseClicked(evt);
            }
        });
        addflujo_btn_cancelar_pnl.add(addflujo_btn_cancelar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        addflujo_principal_contenedor_pnl.add(addflujo_btn_cancelar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        addflujo_titulo_fechInicio_lbl.setText("Fecha Inicio");
        addflujo_principal_contenedor_pnl.add(addflujo_titulo_fechInicio_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        addflujo_contenedor_fechainicio_ftf.setBackground(new java.awt.Color(255, 255, 255));
        addflujo_contenedor_fechainicio_ftf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addflujo_contenedor_fechainicio_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                addflujo_contenedor_fechainicio_ftfPropertyChange(evt);
            }
        });
        addflujo_principal_contenedor_pnl.add(addflujo_contenedor_fechainicio_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 30));

        addflujo_titulo_descripcion_lbl.setText("Desripción");
        addflujo_principal_contenedor_pnl.add(addflujo_titulo_descripcion_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        addflujo_titulo_fechcreacion_lbl.setText("Fecha Creación");
        addflujo_principal_contenedor_pnl.add(addflujo_titulo_fechcreacion_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, -1));

        addflujo_contenedor_fechacreacion_ftf.setBackground(new java.awt.Color(255, 255, 255));
        addflujo_contenedor_fechacreacion_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                addflujo_contenedor_fechacreacion_ftfPropertyChange(evt);
            }
        });
        addflujo_principal_contenedor_pnl.add(addflujo_contenedor_fechacreacion_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 30));

        addflujo_contenedor_estado_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Proceso", "Atrasado", "Cerrado" }));
        addflujo_principal_contenedor_pnl.add(addflujo_contenedor_estado_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 150, 30));

        addflujo_titulo_estado_lbl.setText("Estado");
        addflujo_principal_contenedor_pnl.add(addflujo_titulo_estado_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 100, -1));

        addflujo_contenedor_descripcion_jf.setForeground(new java.awt.Color(204, 204, 204));
        addflujo_contenedor_descripcion_jf.setText("Ingresar Texto");
        addflujo_contenedor_descripcion_jf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addflujo_contenedor_descripcion_jfFocusLost(evt);
            }
        });
        addflujo_contenedor_descripcion_jf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addflujo_contenedor_descripcion_jfMouseClicked(evt);
            }
        });
        addflujo_contenedor_descripcion_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addflujo_contenedor_descripcion_jfActionPerformed(evt);
            }
        });
        addflujo_contenedor_descripcion_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addflujo_contenedor_descripcion_jfKeyReleased(evt);
            }
        });
        addflujo_principal_contenedor_pnl.add(addflujo_contenedor_descripcion_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 370, 110));

        CrearFlujos.add(addflujo_principal_contenedor_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 625, 350));

        flujos_principal_fondo_pnl.add(CrearFlujos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 625, 350));

        EditarFlujo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editflujo_principal_contenedor_pnl.setBackground(new java.awt.Color(255, 255, 255));
        editflujo_principal_contenedor_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editflujo_principal_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editflujo_principal_titulo_lbl.setText("Modificar Flujo");
        editflujo_principal_contenedor_pnl.add(editflujo_principal_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        editflujo_principal_subtitulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editflujo_principal_subtitulo_lbl.setText("Detalles");
        editflujo_principal_contenedor_pnl.add(editflujo_principal_subtitulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        editflujo_separador_divide_spr.setOrientation(javax.swing.SwingConstants.VERTICAL);
        editflujo_principal_contenedor_pnl.add(editflujo_separador_divide_spr, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 340));

        editflujo_btn_guardar_pnl.setBackground(new java.awt.Color(8, 68, 164));
        editflujo_btn_guardar_pnl.setForeground(new java.awt.Color(8, 68, 164));
        editflujo_btn_guardar_pnl.setToolTipText("");
        editflujo_btn_guardar_pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editflujo_btn_guardar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editflujo_btn_guardar_lbl_bloq.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editflujo_btn_guardar_lbl_bloq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editflujo_btn_guardar_lbl_bloq.setText("Guardar ");
        editflujo_btn_guardar_lbl_bloq.setEnabled(false);
        editflujo_btn_guardar_lbl_bloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editflujo_btn_guardar_lbl_bloqMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editflujo_btn_guardar_lbl_bloqMouseEntered(evt);
            }
        });
        editflujo_btn_guardar_pnl.add(editflujo_btn_guardar_lbl_bloq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 42));

        editflujo_btn_guardar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editflujo_btn_guardar_lbl.setForeground(new java.awt.Color(255, 255, 255));
        editflujo_btn_guardar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editflujo_btn_guardar_lbl.setText("Guardar ");
        editflujo_btn_guardar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editflujo_btn_guardar_lblMouseClicked(evt);
            }
        });
        editflujo_btn_guardar_pnl.add(editflujo_btn_guardar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 42));

        editflujo_principal_contenedor_pnl.add(editflujo_btn_guardar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 110, 42));

        editflujo_btn_cancelar_pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editflujo_btn_cancelar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editflujo_btn_cancelar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editflujo_btn_cancelar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editflujo_btn_cancelar_lbl.setText("Cancelar");
        editflujo_btn_cancelar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editflujo_btn_cancelar_lblMouseClicked(evt);
            }
        });
        editflujo_btn_cancelar_pnl.add(editflujo_btn_cancelar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 42));

        editflujo_principal_contenedor_pnl.add(editflujo_btn_cancelar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 110, 42));

        editflujo_titulo_fechfinal_lbl.setText("Fecha Termino");
        editflujo_principal_contenedor_pnl.add(editflujo_titulo_fechfinal_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 80, -1));

        editflujo_contenedores_fechtermino_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                editflujo_contenedores_fechtermino_ftfPropertyChange(evt);
            }
        });
        editflujo_principal_contenedor_pnl.add(editflujo_contenedores_fechtermino_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 150, 30));

        editflujo_titulo_fechinicial_lbl.setText("Fecha Inicio");
        editflujo_principal_contenedor_pnl.add(editflujo_titulo_fechinicial_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        editflujo_contenedores_fechinicio_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                editflujo_contenedores_fechinicio_ftfPropertyChange(evt);
            }
        });
        editflujo_principal_contenedor_pnl.add(editflujo_contenedores_fechinicio_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 30));

        editflujo_titulo_fechcreacion_lbl.setText("Fecha Creación");
        editflujo_principal_contenedor_pnl.add(editflujo_titulo_fechcreacion_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, -1));

        editflujo_contenedores_fechcreacion_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                editflujo_contenedores_fechcreacion_ftfPropertyChange(evt);
            }
        });
        editflujo_principal_contenedor_pnl.add(editflujo_contenedores_fechcreacion_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 30));

        editflujo_titulo_descripcion_lbl.setText("Desripción");
        editflujo_principal_contenedor_pnl.add(editflujo_titulo_descripcion_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        editflujo_contenedores_estado_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En Proceso", "Atrasado", "Cerrado" }));
        editflujo_principal_contenedor_pnl.add(editflujo_contenedores_estado_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 150, 30));

        editflujo_titulo_estado_lbl.setText("Estado");
        editflujo_principal_contenedor_pnl.add(editflujo_titulo_estado_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 100, -1));

        editflujo_contenedores_descripcion_ftf.setForeground(new java.awt.Color(204, 204, 204));
        editflujo_contenedores_descripcion_ftf.setText("Ingresar Texto");
        editflujo_contenedores_descripcion_ftf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editflujo_contenedores_descripcion_ftfActionPerformed(evt);
            }
        });
        editflujo_contenedores_descripcion_ftf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editflujo_contenedores_descripcion_ftfKeyReleased(evt);
            }
        });
        editflujo_principal_contenedor_pnl.add(editflujo_contenedores_descripcion_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 370, 110));

        EditarFlujo.add(editflujo_principal_contenedor_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 625, 350));

        flujos_principal_fondo_pnl.add(EditarFlujo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 625, 350));

        getContentPane().add(flujos_principal_fondo_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 625, 375));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 625, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editflujo_contenedores_descripcion_ftfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editflujo_contenedores_descripcion_ftfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editflujo_contenedores_descripcion_ftfActionPerformed

    private void addflujo_contenedor_descripcion_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addflujo_contenedor_descripcion_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addflujo_contenedor_descripcion_jfActionPerformed

    private void Exit8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Exit8MouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_Exit8MouseClicked

    private void Exit8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Exit8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Exit8KeyPressed

    private void addflujo_btn_cancelar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addflujo_btn_cancelar_lblMouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_addflujo_btn_cancelar_lblMouseClicked

    private void panelsupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsupMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelsupMousePressed

    private void panelsupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelsupMouseDragged

    private void editflujo_btn_cancelar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editflujo_btn_cancelar_lblMouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_editflujo_btn_cancelar_lblMouseClicked

    private void addflujo_btn_guardar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addflujo_btn_guardar_lblMouseClicked
        try {
            SimpleDateFormat ff = new SimpleDateFormat("dd/MMMM/YYYY");
            String Fechainicio = ff.format(addflujo_contenedor_fechainicio_ftf.getDate());
            String Fechacreacion = ff.format(addflujo_contenedor_fechacreacion_ftf.getDate());
            String Fechatermino = ff.format(addflujo_contenedor_fechatermino_ftf.getDate());
            String descripcion = addflujo_contenedor_descripcion_jf.getText();

            String[] args = {descripcion,
                Fechacreacion,
                Fechainicio,
                Fechatermino,
                addflujo_contenedor_estado_cbox.getSelectedItem().toString(),
                "0"
            };

            Object[] confirmar = new Object[]{"¿Agregar Flujo " + args[0] + "?", this, table, 0, "agregar", "flujo", args, framep};
            ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
            conf.setVisible(true);

        } catch (Exception e) {
            Error err = new Error("Error, revisa los datos ingresados", this, framep);
            err.setVisible(true);
        }

    }//GEN-LAST:event_addflujo_btn_guardar_lblMouseClicked

    private void editflujo_btn_guardar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editflujo_btn_guardar_lblMouseClicked

        fechainicial = editflujo_contenedores_fechinicio_ftf.getDate();
        fechacreacion = editflujo_contenedores_fechcreacion_ftf.getDate();
        fechatermino = editflujo_contenedores_fechtermino_ftf.getDate();

        try {
            SimpleDateFormat ff = new SimpleDateFormat("dd/MMMM/YYYY");
            String Fechainicio = ff.format(fechainicial);
            String Fechacreacion = ff.format(fechacreacion);
            String Fechatermino = ff.format(fechatermino);
            String descripcion = editflujo_contenedores_descripcion_ftf.getText();

            String[] args = {
                idflujo,
                descripcion,
                Fechacreacion,
                Fechainicio,
                Fechatermino,
                addflujo_contenedor_estado_cbox.getSelectedItem().toString(),
                progreso
            };

            Object[] confirmar = new Object[]{"¿Editar Flujo " + desc + "?", this, table, 0, "editar", "flujo", args, framep};
            ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
            conf.setVisible(true);

        } catch (Exception e) {
            Error err = new Error("Error, revisa los datos ingresados", this, framep);
            err.setVisible(true);
        }


    }//GEN-LAST:event_editflujo_btn_guardar_lblMouseClicked

    private void addflujo_contenedor_descripcion_jfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addflujo_contenedor_descripcion_jfMouseClicked
        if (addflujo_contenedor_descripcion_jf.getForeground().equals(new Color(204, 204, 204))) {
            addflujo_contenedor_descripcion_jf.setText("");
            addflujo_contenedor_descripcion_jf.setForeground(Color.BLACK);

        }

    }//GEN-LAST:event_addflujo_contenedor_descripcion_jfMouseClicked

    private void addflujo_contenedor_descripcion_jfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addflujo_contenedor_descripcion_jfFocusLost
        if (addflujo_contenedor_descripcion_jf.getText().trim().isEmpty()) {
            addflujo_contenedor_descripcion_jf.setForeground(new Color(204, 204, 204));
            addflujo_contenedor_descripcion_jf.setText("Ingresar Texto");
        }
    }//GEN-LAST:event_addflujo_contenedor_descripcion_jfFocusLost

    private void addflujo_btn_guardar_lbl_bloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addflujo_btn_guardar_lbl_bloqMouseClicked
        Error err = new Error("Error, revisa los datos ingresados!", this, framep);
        err.setVisible(true);
    }//GEN-LAST:event_addflujo_btn_guardar_lbl_bloqMouseClicked

    private void addflujo_contenedor_fechainicio_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_addflujo_contenedor_fechainicio_ftfPropertyChange
        try {
            Object[] campos = new Object[]{
                addflujo_contenedor_descripcion_jf,
                addflujo_contenedor_fechainicio_ftf,
                addflujo_contenedor_fechacreacion_ftf,
                addflujo_contenedor_fechatermino_ftf
            };
            String descripcion = addflujo_contenedor_descripcion_jf.getText();

            boolean descripcionrep = conn.descRep(addflujo_contenedor_descripcion_jf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                addflujo_btn_guardar_lbl_bloq.setVisible(false);

                addflujo_btn_guardar_lbl.setVisible(true);
                addflujo_btn_guardar_lbl.setEnabled(true);
                addflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                addflujo_btn_guardar_lbl_bloq.setVisible(true);

                addflujo_btn_guardar_lbl.setVisible(false);
                addflujo_btn_guardar_lbl.setEnabled(false);
                addflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_addflujo_contenedor_fechainicio_ftfPropertyChange

    private void addflujo_contenedor_fechatermino_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_addflujo_contenedor_fechatermino_ftfPropertyChange
        try {
            Object[] campos = new Object[]{
                addflujo_contenedor_descripcion_jf,
                addflujo_contenedor_fechainicio_ftf,
                addflujo_contenedor_fechacreacion_ftf,
                addflujo_contenedor_fechatermino_ftf
            };
            String descripcion = addflujo_contenedor_descripcion_jf.getText();

            boolean descripcionrep = conn.descRep(addflujo_contenedor_descripcion_jf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                addflujo_btn_guardar_lbl_bloq.setVisible(false);

                addflujo_btn_guardar_lbl.setVisible(true);
                addflujo_btn_guardar_lbl.setEnabled(true);
                addflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                addflujo_btn_guardar_lbl_bloq.setVisible(true);

                addflujo_btn_guardar_lbl.setVisible(false);
                addflujo_btn_guardar_lbl.setEnabled(false);
                addflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_addflujo_contenedor_fechatermino_ftfPropertyChange

    private void addflujo_contenedor_fechacreacion_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_addflujo_contenedor_fechacreacion_ftfPropertyChange
        try {
            Object[] campos = new Object[]{
                addflujo_contenedor_descripcion_jf,
                addflujo_contenedor_fechainicio_ftf,
                addflujo_contenedor_fechacreacion_ftf,
                addflujo_contenedor_fechatermino_ftf
            };
            String descripcion = addflujo_contenedor_descripcion_jf.getText();

            boolean descripcionrep = conn.descRep(addflujo_contenedor_descripcion_jf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                addflujo_btn_guardar_lbl_bloq.setVisible(false);

                addflujo_btn_guardar_lbl.setVisible(true);
                addflujo_btn_guardar_lbl.setEnabled(true);
                addflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                addflujo_btn_guardar_lbl_bloq.setVisible(true);

                addflujo_btn_guardar_lbl.setVisible(false);
                addflujo_btn_guardar_lbl.setEnabled(false);
                addflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_addflujo_contenedor_fechacreacion_ftfPropertyChange

    private void addflujo_contenedor_descripcion_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addflujo_contenedor_descripcion_jfKeyReleased
        try {
            Object[] campos = new Object[]{
                addflujo_contenedor_descripcion_jf,
                addflujo_contenedor_fechainicio_ftf,
                addflujo_contenedor_fechacreacion_ftf,
                addflujo_contenedor_fechatermino_ftf
            };
            String descripcion = addflujo_contenedor_descripcion_jf.getText();

            boolean descripcionrep = conn.descRep(addflujo_contenedor_descripcion_jf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                addflujo_btn_guardar_lbl_bloq.setVisible(false);

                addflujo_btn_guardar_lbl.setVisible(true);
                addflujo_btn_guardar_lbl.setEnabled(true);
                addflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                addflujo_btn_guardar_lbl_bloq.setVisible(true);

                addflujo_btn_guardar_lbl.setVisible(false);
                addflujo_btn_guardar_lbl.setEnabled(false);
                addflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_addflujo_contenedor_descripcion_jfKeyReleased

    private void editflujo_btn_guardar_lbl_bloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editflujo_btn_guardar_lbl_bloqMouseClicked
        Error err = new Error("Error, revisa los datos ingresados!", this, framep);
        err.setVisible(true);
    }//GEN-LAST:event_editflujo_btn_guardar_lbl_bloqMouseClicked

    private void editflujo_btn_guardar_lbl_bloqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editflujo_btn_guardar_lbl_bloqMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_editflujo_btn_guardar_lbl_bloqMouseEntered

    private void editflujo_contenedores_fechinicio_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_editflujo_contenedores_fechinicio_ftfPropertyChange
        try {
            Object[] campos = new Object[]{
                editflujo_contenedores_descripcion_ftf,
                editflujo_contenedores_fechinicio_ftf,
                editflujo_contenedores_fechcreacion_ftf,
                editflujo_contenedores_fechtermino_ftf
            };
            String descripcion = editflujo_contenedores_descripcion_ftf.getText();

            boolean descripcionrep = conn.descRep(editflujo_contenedores_descripcion_ftf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                editflujo_btn_guardar_lbl_bloq.setVisible(false);

                editflujo_btn_guardar_lbl.setVisible(true);
                editflujo_btn_guardar_lbl.setEnabled(true);
                editflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                editflujo_btn_guardar_lbl_bloq.setVisible(true);

                editflujo_btn_guardar_lbl.setVisible(false);
                editflujo_btn_guardar_lbl.setEnabled(false);
                editflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_editflujo_contenedores_fechinicio_ftfPropertyChange

    private void editflujo_contenedores_fechtermino_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_editflujo_contenedores_fechtermino_ftfPropertyChange
        try {
            Object[] campos = new Object[]{
                editflujo_contenedores_descripcion_ftf,
                editflujo_contenedores_fechinicio_ftf,
                editflujo_contenedores_fechcreacion_ftf,
                editflujo_contenedores_fechtermino_ftf
            };
            String descripcion = editflujo_contenedores_descripcion_ftf.getText();

            boolean descripcionrep = conn.descRep(editflujo_contenedores_descripcion_ftf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                editflujo_btn_guardar_lbl_bloq.setVisible(false);

                editflujo_btn_guardar_lbl.setVisible(true);
                editflujo_btn_guardar_lbl.setEnabled(true);
                editflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                editflujo_btn_guardar_lbl_bloq.setVisible(true);

                editflujo_btn_guardar_lbl.setVisible(false);
                editflujo_btn_guardar_lbl.setEnabled(false);
                editflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_editflujo_contenedores_fechtermino_ftfPropertyChange

    private void editflujo_contenedores_fechcreacion_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_editflujo_contenedores_fechcreacion_ftfPropertyChange
        try {
            Object[] campos = new Object[]{
                editflujo_contenedores_descripcion_ftf,
                editflujo_contenedores_fechinicio_ftf,
                editflujo_contenedores_fechcreacion_ftf,
                editflujo_contenedores_fechtermino_ftf
            };
            String descripcion = editflujo_contenedores_descripcion_ftf.getText();

            boolean descripcionrep = conn.descRep(editflujo_contenedores_descripcion_ftf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                editflujo_btn_guardar_lbl_bloq.setVisible(false);

                editflujo_btn_guardar_lbl.setVisible(true);
                editflujo_btn_guardar_lbl.setEnabled(true);
                editflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                editflujo_btn_guardar_lbl_bloq.setVisible(true);

                editflujo_btn_guardar_lbl.setVisible(false);
                editflujo_btn_guardar_lbl.setEnabled(false);
                editflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_editflujo_contenedores_fechcreacion_ftfPropertyChange

    private void editflujo_contenedores_descripcion_ftfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editflujo_contenedores_descripcion_ftfKeyReleased
        try {
            Object[] campos = new Object[]{
                editflujo_contenedores_descripcion_ftf,
                editflujo_contenedores_fechinicio_ftf,
                editflujo_contenedores_fechcreacion_ftf,
                editflujo_contenedores_fechtermino_ftf
            };
            String descripcion = editflujo_contenedores_descripcion_ftf.getText();

            boolean descripcionrep = conn.descRep(editflujo_contenedores_descripcion_ftf);
            boolean fechaOk = Metodos.MetodosFront.fechaok(campos);
            boolean llenos = Metodos.MetodosFront.flujolleno(campos);
            if (!fechaOk || descripcionrep) {
                Instrucciones.setForeground(Color.red);
            } else {
                Instrucciones.setForeground(Color.BLACK);
            }
            if (llenos && fechaOk && !descripcionrep) {
                editflujo_btn_guardar_lbl_bloq.setVisible(false);

                editflujo_btn_guardar_lbl.setVisible(true);
                editflujo_btn_guardar_lbl.setEnabled(true);
                editflujo_btn_guardar_lbl.setFocusable(true);

            } else {
                editflujo_btn_guardar_lbl_bloq.setVisible(true);

                editflujo_btn_guardar_lbl.setVisible(false);
                editflujo_btn_guardar_lbl.setEnabled(false);
                editflujo_btn_guardar_lbl.setFocusable(false);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_editflujo_contenedores_descripcion_ftfKeyReleased

    private void InstruccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InstruccionesMouseClicked
        instruccionespnl.setVisible(true);
        instruccionespnl.setEnabled(true);
        instruccionespnl.setFocusable(true);
    }//GEN-LAST:event_InstruccionesMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        instruccionespnl.setVisible(false);
        instruccionespnl.setEnabled(false);
        instruccionespnl.setFocusable(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void instruccionespnlPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_instruccionespnlPropertyChange
        if (instruccionespnl.isVisible()) {
            if (CrearFlujos.isVisible()) {

                addflujo_contenedor_fechatermino_ftf.setVisible(false);

            } else {

                editflujo_contenedores_fechtermino_ftf.setVisible(false);
            }
        } else {
            if (CrearFlujos.isVisible()) {

                addflujo_contenedor_fechatermino_ftf.setVisible(true);
            } else {

                editflujo_contenedores_fechtermino_ftf.setVisible(true);
            }

        }
    }//GEN-LAST:event_instruccionespnlPropertyChange

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
            java.util.logging.Logger.getLogger(Flujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Flujos(null, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CrearFlujos;
    private javax.swing.JPanel EditarFlujo;
    private javax.swing.JLabel Exit8;
    private javax.swing.JLabel Instrucciones;
    private javax.swing.JLabel addflujo_btn_cancelar_lbl;
    private javax.swing.JPanel addflujo_btn_cancelar_pnl;
    private javax.swing.JLabel addflujo_btn_guardar_lbl;
    private javax.swing.JLabel addflujo_btn_guardar_lbl_bloq;
    private javax.swing.JPanel addflujo_btn_guardar_pnl;
    private javax.swing.JTextField addflujo_contenedor_descripcion_jf;
    private javax.swing.JComboBox<String> addflujo_contenedor_estado_cbox;
    private com.toedter.calendar.JDateChooser addflujo_contenedor_fechacreacion_ftf;
    private com.toedter.calendar.JDateChooser addflujo_contenedor_fechainicio_ftf;
    private com.toedter.calendar.JDateChooser addflujo_contenedor_fechatermino_ftf;
    private javax.swing.JPanel addflujo_principal_contenedor_pnl;
    private javax.swing.JLabel addflujo_principal_subtitulo_lbl;
    private javax.swing.JLabel addflujo_principal_titulo_lbl;
    private javax.swing.JSeparator addflujo_separador_divide_spr;
    private javax.swing.JLabel addflujo_titulo_descripcion_lbl;
    private javax.swing.JLabel addflujo_titulo_estado_lbl;
    private javax.swing.JLabel addflujo_titulo_fechInicio_lbl;
    private javax.swing.JLabel addflujo_titulo_fechcreacion_lbl;
    private javax.swing.JLabel addflujo_titulo_fechfinal_lbl;
    private javax.swing.JLabel editflujo_btn_cancelar_lbl;
    private javax.swing.JPanel editflujo_btn_cancelar_pnl;
    private javax.swing.JLabel editflujo_btn_guardar_lbl;
    private javax.swing.JLabel editflujo_btn_guardar_lbl_bloq;
    private javax.swing.JPanel editflujo_btn_guardar_pnl;
    private javax.swing.JTextField editflujo_contenedores_descripcion_ftf;
    private javax.swing.JComboBox<String> editflujo_contenedores_estado_cbox;
    private com.toedter.calendar.JDateChooser editflujo_contenedores_fechcreacion_ftf;
    private com.toedter.calendar.JDateChooser editflujo_contenedores_fechinicio_ftf;
    private com.toedter.calendar.JDateChooser editflujo_contenedores_fechtermino_ftf;
    private javax.swing.JPanel editflujo_principal_contenedor_pnl;
    private javax.swing.JLabel editflujo_principal_subtitulo_lbl;
    private javax.swing.JLabel editflujo_principal_titulo_lbl;
    private javax.swing.JSeparator editflujo_separador_divide_spr;
    private javax.swing.JLabel editflujo_titulo_descripcion_lbl;
    private javax.swing.JLabel editflujo_titulo_estado_lbl;
    private javax.swing.JLabel editflujo_titulo_fechcreacion_lbl;
    private javax.swing.JLabel editflujo_titulo_fechfinal_lbl;
    private javax.swing.JLabel editflujo_titulo_fechinicial_lbl;
    private javax.swing.JPanel flujos_principal_fondo_pnl;
    private javax.swing.JPanel instruccionespnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JPanel panelsup;
    // End of variables declaration//GEN-END:variables
}
