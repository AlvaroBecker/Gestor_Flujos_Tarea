/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front;

import Metodos.MetodosBD;
import Metodos.MetodosBD.ConexionOracle;
import Metodos.MetodosFront.rut;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Toolkit;
import static java.awt.image.ImageObserver.ABORT;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.time.Period;

/**
 *
 * @author Alvaro Becker
 */
public class Usuarios extends javax.swing.JFrame {

    int xMouse, yMouse;
    String string, pas, username, apellidomat, last3rut,midium3rut,first3rut;
    JFrame framep;
    String[] items;
    JTable table;
    ConexionOracle conn;
    int verificador;
    boolean usrnamerep,usrnamerep2;
    Period periodo;

    /**
     * Creates new form Usuarios
     *
     * @param componentes
     * @param con
     */
    
    public Usuarios(Object[] componentes, ConexionOracle con) {
        initComponents();
        conn = con;
        
        Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText());
        Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addname_jf, formatonombre);
        Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addlastname_jf, formatoApe);

        Metodos.MetodosFront.VerificadorRut(adduser_contenedor_addrut_jf, Metodos.MetodosFront.rut.validadorRut(r.getArray(), r.getDv()), validadoRut, conn.repetido(adduser_contenedor_addrut_jf.getText(), framep));
        Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
        Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
        edituser_btn_guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        edituser_btn_guardar_pnl.setOpaque(false);
        edituser_btn_cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.LIGHT_GRAY));
        edituser_btn_cancelar_pnl.setOpaque(false);
        edituser_contenedor_password_pf.setText(edituser_contenedor_password_jf.getText());

        adduser_btn_guardar_lbl.setEnabled(false);
        adduser_btn_guardar_lbl.setFocusable(false);

        verificador = 0;

        table = (JTable) componentes[2];
        framep = (JFrame) componentes[1];
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        setShape(forma);
        adduser_btn_guardar_pnl.setOpaque(false);
        adduser_btn_cancelar_pnl.setOpaque(false);
        adduser_btn_guardar_lbl.setEnabled(false);
        adduser_btn_guardar_lbl.setFocusable(false);
        adduser_btn_guardar_lbl.setVisible(false);
        adduser_btn_guardar_lbl_bloq.setVisible(true);
        adduser_btn_guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        adduser_btn_cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.LIGHT_GRAY));
        this.setComponentZOrder(labelFondo, 0);
        labelFondo.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.BLACK, false, null));
        labelFondo.setFocusable(false);
        labelFondo.setEnabled(false);
        string = (String) componentes[0];
        if (string.equals("crear")) {
            CrearUsuario.setVisible(true);
            CrearUsuario.setFocusable(true);
            CrearUsuario.setEnabled(true);
            EditarUsuario.setVisible(false);
            EditarUsuario.setFocusable(false);
            EditarUsuario.setEnabled(false);
        } else {
            CrearUsuario.setVisible(false);
            CrearUsuario.setFocusable(false);
            CrearUsuario.setEnabled(false);
            EditarUsuario.setVisible(true);
            EditarUsuario.setFocusable(true);
            EditarUsuario.setEnabled(true);

            String nbr_full = table.getValueAt(table.getSelectedRow(), 0).toString();
            String rut = table.getValueAt(table.getSelectedRow(), 1).toString();
            String usname = table.getValueAt(table.getSelectedRow(), 2).toString();
            String pass = conn.obtenerPass(rut, this);
            String date = table.getValueAt(table.getSelectedRow(), 3).toString();
            String gen = table.getValueAt(table.getSelectedRow(), 4).toString();
            String rol_str = table.getValueAt(table.getSelectedRow(), 5).toString();
            String unidad_str = table.getValueAt(table.getSelectedRow(), 6).toString();
            String[] d = date.split(" ");
            String da = d[0];
            String[] fech = da.split("-");
            String fecha = fech[2] + "-" + fech[1] + "-" + fech[0];
            conn.rellenarCbox("ROL", edituser_contenedor_rol_cbox);
            conn.rellenarCbox("UNIDAD_INTERNA", edituser_contenedor_unidad_cbox);
            try {
                java.util.Date dat = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
                edituser_contenedor_fecha_ftf.setDate(dat);
            } catch (ParseException ex) {
                //Do something
            }
            String[] nbr_apell = nbr_full.split(" ");
            edituser_contenedor_addname_jf.setText(nbr_apell[0]);
            edituser_contenedor_addlastname_jf.setText(nbr_apell[1]);
            edituser_contenedor_addrut_jf.setText(rut);
            edituser_contenedor_unidad_cbox.setSelectedItem(unidad_str);
            edituser_contenedor_rol_cbox.setSelectedItem(rol_str);
            edituser_contenedor_genero_cbox.setSelectedItem(gen);
            edituser_contenedor_password_jf.setText(pass);
            edituser_contenedor_password_jf.setVisible(false);
            edituser_contenedor_password_jf.setFocusable(false);
            edituser_contenedor_password_jf.setEnabled(false);
            edituser_contenedor_password_pf.setText(pass);
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(edituser_contenedor_addname_jf, edituser_contenedor_addlastname_jf, edituser_contenedor_addrut_jf, edituser_contenedor_fecha_ftf, this);
            

            boolean validcon = Metodos.MetodosFront.esSegura(edituser_contenedor_password_jf.getText(), FormatoPass, pass_pnl, formatopasspnl);

            if (llenos && formatnombre && formatape && validcon) {

                edituser_btn_guardar_lbl.setEnabled(true);
                edituser_btn_guardar_lbl.setFocusable(true);
                edituser_btn_guardar_lbl.setVisible(true);
                edituser_btn_guardar_lbl_bloq.setVisible(false);
                //edituser_btn_guardar_lbl_bloq.setEnabled(false);
                edituser_btn_guardar_lbl_bloq.setFocusable(false);

            } else {

                edituser_btn_guardar_lbl.setEnabled(false);
                edituser_btn_guardar_lbl.setFocusable(false);
                edituser_btn_guardar_lbl.setVisible(false);
                edituser_btn_guardar_lbl_bloq.setVisible(true);
                //edituser_btn_guardar_lbl_bloq.setEnabled(true);
                edituser_btn_guardar_lbl_bloq.setFocusable(true);

            }
        }

        framep.setEnabled(false);

        conn.rellenarCbox("ROL", adduser_contenedor_rol_cbox);

        conn.rellenarCbox("UNIDAD_INTERNA", adduser_contenedor_unidad_cbox);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarios_principal_fondo_pnl = new javax.swing.JPanel();
        panelsup = new javax.swing.JPanel();
        Exit8 = new javax.swing.JLabel();
        CrearUsuario = new javax.swing.JPanel();
        usuarios_principal_contenedor_pnl = new javax.swing.JPanel();
        adduser_principal_titulo_lbl = new javax.swing.JLabel();
        adduser_principal_subtitulo_lbl = new javax.swing.JLabel();
        adduser_titulo_genero_lbl = new javax.swing.JLabel();
        adduser_contenedor_addrut_jf = new javax.swing.JTextField();
        adduser_titulo_addrut_lbl = new javax.swing.JLabel();
        adduser_contenedor_addname_jf = new javax.swing.JTextField();
        adduser_titulo_addlastname_lbl = new javax.swing.JLabel();
        adduser_titulo_addname_lbl = new javax.swing.JLabel();
        adduser_contenedor_genero_cbox = new javax.swing.JComboBox<>();
        adduser_titulo_rol_lbl = new javax.swing.JLabel();
        adduser_contenedor_rol_cbox = new javax.swing.JComboBox<>();
        adduser_titulo_unidad_lbl = new javax.swing.JLabel();
        adduser_contenedor_fecha_ftf = new com.toedter.calendar.JDateChooser();
        adduser_titulo_datenacimiento_lbl = new javax.swing.JLabel();
        adduser_contenedor_unidad_cbox = new javax.swing.JComboBox<>();
        adduser_contenedor_addlastname_jf = new javax.swing.JTextField();
        adduser_btn_guardar_pnl = new javax.swing.JPanel();
        adduser_btn_guardar_lbl_bloq = new javax.swing.JLabel();
        adduser_btn_guardar_lbl = new javax.swing.JLabel();
        adduser_btn_cancelar_pnl = new javax.swing.JPanel();
        adduser_btn_cancelar_lbl = new javax.swing.JLabel();
        validadoRut = new javax.swing.JLabel();
        formatorut = new javax.swing.JLabel();
        obligatorio = new javax.swing.JLabel();
        formatoApe = new javax.swing.JLabel();
        formatonombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        formatofecha = new javax.swing.JLabel();
        EditarUsuario = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        edituser_principal_titulo_lbl = new javax.swing.JLabel();
        edituser_principal_subtitulo_lbl = new javax.swing.JLabel();
        edituser_titulo_genero_lbl = new javax.swing.JLabel();
        edituser_contenedor_addrut_jf = new javax.swing.JTextField();
        edituser_titulo_addrut_lbl = new javax.swing.JLabel();
        edituser_contenedor_addname_jf = new javax.swing.JTextField();
        edituser_titulo_addlastname_lbl = new javax.swing.JLabel();
        edituser_titulo_addname_lbl = new javax.swing.JLabel();
        edituser_titulo_password_lbl = new javax.swing.JLabel();
        edituser_titulo_rol_lbl = new javax.swing.JLabel();
        edituser_contenedor_rol_cbox = new javax.swing.JComboBox<>();
        edituser_titulo_unidad_lbl = new javax.swing.JLabel();
        edituser_titulo_datenacimiento_lbl = new javax.swing.JLabel();
        edituser_contenedor_unidad_cbox = new javax.swing.JComboBox<>();
        edituser_contenedor_addlastname_jf = new javax.swing.JTextField();
        edituser_contenedor_fecha_ftf = new com.toedter.calendar.JDateChooser();
        edituser_contenedor_genero_cbox = new javax.swing.JComboBox<>();
        ver_nover = new javax.swing.JLabel();
        formatonombre1 = new javax.swing.JLabel();
        formatoApe1 = new javax.swing.JLabel();
        validadoRut1 = new javax.swing.JLabel();
        edituser_btn_guardar_pnl = new javax.swing.JPanel();
        edituser_btn_guardar_lbl_bloq = new javax.swing.JLabel();
        edituser_btn_guardar_lbl = new javax.swing.JLabel();
        edituser_btn_cancelar_pnl = new javax.swing.JPanel();
        edituser_btn_cancelar_lbl = new javax.swing.JLabel();
        formatopasspnl = new javax.swing.JPanel();
        FormatoPass = new javax.swing.JLabel();
        pass_pnl = new javax.swing.JPanel();
        edituser_contenedor_password_jf = new javax.swing.JTextField();
        edituser_contenedor_password_pf = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        Editarfechanacformat = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(700, 425));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarios_principal_fondo_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelsup.add(Exit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 0, 25, 25));

        usuarios_principal_fondo_pnl.add(panelsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        CrearUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarios_principal_contenedor_pnl.setBackground(new java.awt.Color(255, 255, 255));
        usuarios_principal_contenedor_pnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarios_principal_contenedor_pnlMouseClicked(evt);
            }
        });
        usuarios_principal_contenedor_pnl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarios_principal_contenedor_pnlKeyReleased(evt);
            }
        });
        usuarios_principal_contenedor_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adduser_principal_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adduser_principal_titulo_lbl.setText("Crear Usuario");
        usuarios_principal_contenedor_pnl.add(adduser_principal_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 243, -1));

        adduser_principal_subtitulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adduser_principal_subtitulo_lbl.setText("Detalles");
        usuarios_principal_contenedor_pnl.add(adduser_principal_subtitulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 70, -1));

        adduser_titulo_genero_lbl.setText("Género");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_genero_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, -1));

        adduser_contenedor_addrut_jf.setForeground(new java.awt.Color(204, 204, 204));
        adduser_contenedor_addrut_jf.setText("12345678-9");
        adduser_contenedor_addrut_jf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_contenedor_addrut_jfMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adduser_contenedor_addrut_jfMouseReleased(evt);
            }
        });
        adduser_contenedor_addrut_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_contenedor_addrut_jfActionPerformed(evt);
            }
        });
        adduser_contenedor_addrut_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adduser_contenedor_addrut_jfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adduser_contenedor_addrut_jfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adduser_contenedor_addrut_jfKeyTyped(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_addrut_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 150, 30));

        adduser_titulo_addrut_lbl.setText("Rut *");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_addrut_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 30, 20));

        adduser_contenedor_addname_jf.setForeground(new java.awt.Color(204, 204, 204));
        adduser_contenedor_addname_jf.setText("Pedro");
        adduser_contenedor_addname_jf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_contenedor_addname_jfMouseClicked(evt);
            }
        });
        adduser_contenedor_addname_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_contenedor_addname_jfActionPerformed(evt);
            }
        });
        adduser_contenedor_addname_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adduser_contenedor_addname_jfKeyReleased(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_addname_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 150, 30));

        adduser_titulo_addlastname_lbl.setText("Apellidos *");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_addlastname_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 60, -1));

        adduser_titulo_addname_lbl.setText("Nombre *");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_addname_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 60, -1));

        adduser_contenedor_genero_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "Otro" }));
        adduser_contenedor_genero_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_contenedor_genero_cboxActionPerformed(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_genero_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 150, 30));

        adduser_titulo_rol_lbl.setText("Rol");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_rol_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        adduser_contenedor_rol_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adduser_contenedor_rol_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_contenedor_rol_cboxActionPerformed(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_rol_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 150, 30));

        adduser_titulo_unidad_lbl.setText("Unidad");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_unidad_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        adduser_contenedor_fecha_ftf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                adduser_contenedor_fecha_ftfFocusLost(evt);
            }
        });
        adduser_contenedor_fecha_ftf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_contenedor_fecha_ftfMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adduser_contenedor_fecha_ftfMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adduser_contenedor_fecha_ftfMouseReleased(evt);
            }
        });
        adduser_contenedor_fecha_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                adduser_contenedor_fecha_ftfPropertyChange(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_fecha_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, 30));

        adduser_titulo_datenacimiento_lbl.setText("Fecha de nacimiento *");
        usuarios_principal_contenedor_pnl.add(adduser_titulo_datenacimiento_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        adduser_contenedor_unidad_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adduser_contenedor_unidad_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_contenedor_unidad_cboxActionPerformed(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_unidad_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 150, 30));

        adduser_contenedor_addlastname_jf.setForeground(new java.awt.Color(204, 204, 204));
        adduser_contenedor_addlastname_jf.setText("Pascal");
        adduser_contenedor_addlastname_jf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_contenedor_addlastname_jfMouseClicked(evt);
            }
        });
        adduser_contenedor_addlastname_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_contenedor_addlastname_jfActionPerformed(evt);
            }
        });
        adduser_contenedor_addlastname_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adduser_contenedor_addlastname_jfKeyReleased(evt);
            }
        });
        usuarios_principal_contenedor_pnl.add(adduser_contenedor_addlastname_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 150, 30));

        adduser_btn_guardar_pnl.setBackground(new java.awt.Color(8, 68, 164));
        adduser_btn_guardar_pnl.setForeground(new java.awt.Color(8, 68, 164));
        adduser_btn_guardar_pnl.setToolTipText("");
        adduser_btn_guardar_pnl.setEnabled(false);
        adduser_btn_guardar_pnl.setFocusable(false);
        adduser_btn_guardar_pnl.setVerifyInputWhenFocusTarget(false);
        adduser_btn_guardar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adduser_btn_guardar_lbl_bloq.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adduser_btn_guardar_lbl_bloq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adduser_btn_guardar_lbl_bloq.setText("Guardar");
        adduser_btn_guardar_lbl_bloq.setEnabled(false);
        adduser_btn_guardar_lbl_bloq.setFocusable(false);
        adduser_btn_guardar_lbl_bloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_btn_guardar_lbl_bloqMouseClicked(evt);
            }
        });
        adduser_btn_guardar_pnl.add(adduser_btn_guardar_lbl_bloq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        adduser_btn_guardar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adduser_btn_guardar_lbl.setForeground(new java.awt.Color(255, 255, 255));
        adduser_btn_guardar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adduser_btn_guardar_lbl.setText("Guardar");
        adduser_btn_guardar_lbl.setAlignmentY(1.0F);
        adduser_btn_guardar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adduser_btn_guardar_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adduser_btn_guardar_lbl.setMaximumSize(new java.awt.Dimension(100, 40));
        adduser_btn_guardar_lbl.setMinimumSize(new java.awt.Dimension(100, 40));
        adduser_btn_guardar_lbl.setPreferredSize(new java.awt.Dimension(100, 40));
        adduser_btn_guardar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_btn_guardar_lblMouseClicked(evt);
            }
        });
        adduser_btn_guardar_pnl.add(adduser_btn_guardar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        usuarios_principal_contenedor_pnl.add(adduser_btn_guardar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, 40));

        adduser_btn_cancelar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adduser_btn_cancelar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adduser_btn_cancelar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adduser_btn_cancelar_lbl.setText("Cancelar");
        adduser_btn_cancelar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adduser_btn_cancelar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adduser_btn_cancelar_lblMouseClicked(evt);
            }
        });
        adduser_btn_cancelar_pnl.add(adduser_btn_cancelar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        usuarios_principal_contenedor_pnl.add(adduser_btn_cancelar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 100, 40));

        validadoRut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarios_principal_contenedor_pnl.add(validadoRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 150, 20));

        formatorut.setForeground(new java.awt.Color(204, 204, 204));
        formatorut.setText("(12345678-9) ");
        formatorut.setEnabled(false);
        formatorut.setFocusable(false);
        usuarios_principal_contenedor_pnl.add(formatorut, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 120, -1));

        obligatorio.setForeground(new java.awt.Color(204, 204, 204));
        obligatorio.setText("(* Obligatorio)");
        obligatorio.setEnabled(false);
        obligatorio.setFocusable(false);
        usuarios_principal_contenedor_pnl.add(obligatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 110, 20));

        formatoApe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarios_principal_contenedor_pnl.add(formatoApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 190, 20));

        formatonombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarios_principal_contenedor_pnl.add(formatonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(117, 170, 250));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("@ Process S.A.");
        usuarios_principal_contenedor_pnl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 330, 50));
        usuarios_principal_contenedor_pnl.add(formatofecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 115, 140, 20));

        CrearUsuario.add(usuarios_principal_contenedor_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        usuarios_principal_fondo_pnl.add(CrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 700, 400));

        EditarUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(117, 170, 250));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("@ Process S.A.");
        jPanel11.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 330, 50));

        edituser_principal_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        edituser_principal_titulo_lbl.setText("Editar Usuario");
        jPanel11.add(edituser_principal_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 243, -1));

        edituser_principal_subtitulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        edituser_principal_subtitulo_lbl.setText("Detalles");
        jPanel11.add(edituser_principal_subtitulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        edituser_titulo_genero_lbl.setText("Genero");
        jPanel11.add(edituser_titulo_genero_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, -1));

        edituser_contenedor_addrut_jf.setText("11222333-4");
        edituser_contenedor_addrut_jf.setEnabled(false);
        edituser_contenedor_addrut_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituser_contenedor_addrut_jfActionPerformed(evt);
            }
        });
        jPanel11.add(edituser_contenedor_addrut_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 150, 30));

        edituser_titulo_addrut_lbl.setText("Rut");
        jPanel11.add(edituser_titulo_addrut_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 30, 20));

        edituser_contenedor_addname_jf.setText("A");
        edituser_contenedor_addname_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituser_contenedor_addname_jfActionPerformed(evt);
            }
        });
        edituser_contenedor_addname_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edituser_contenedor_addname_jfKeyReleased(evt);
            }
        });
        jPanel11.add(edituser_contenedor_addname_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 150, 30));

        edituser_titulo_addlastname_lbl.setText("Apellidos");
        jPanel11.add(edituser_titulo_addlastname_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 60, -1));

        edituser_titulo_addname_lbl.setText("Nombre");
        jPanel11.add(edituser_titulo_addname_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 60, -1));

        edituser_titulo_password_lbl.setText("Contraseña");
        jPanel11.add(edituser_titulo_password_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        edituser_titulo_rol_lbl.setText("Rol");
        jPanel11.add(edituser_titulo_rol_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        edituser_contenedor_rol_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        edituser_contenedor_rol_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituser_contenedor_rol_cboxActionPerformed(evt);
            }
        });
        jPanel11.add(edituser_contenedor_rol_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 150, 30));

        edituser_titulo_unidad_lbl.setText("Unidad");
        jPanel11.add(edituser_titulo_unidad_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        edituser_titulo_datenacimiento_lbl.setText("Fecha de nacimiento");
        jPanel11.add(edituser_titulo_datenacimiento_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        edituser_contenedor_unidad_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        edituser_contenedor_unidad_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituser_contenedor_unidad_cboxActionPerformed(evt);
            }
        });
        jPanel11.add(edituser_contenedor_unidad_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 150, 30));

        edituser_contenedor_addlastname_jf.setText("B");
        edituser_contenedor_addlastname_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituser_contenedor_addlastname_jfActionPerformed(evt);
            }
        });
        edituser_contenedor_addlastname_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edituser_contenedor_addlastname_jfKeyReleased(evt);
            }
        });
        jPanel11.add(edituser_contenedor_addlastname_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 150, 30));

        edituser_contenedor_fecha_ftf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                edituser_contenedor_fecha_ftfPropertyChange(evt);
            }
        });
        jPanel11.add(edituser_contenedor_fecha_ftf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, 30));

        edituser_contenedor_genero_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "Otro" }));
        jPanel11.add(edituser_contenedor_genero_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 150, 30));

        ver_nover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ver_nover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ver.png"))); // NOI18N
        ver_nover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ver_nover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ver_noverMouseClicked(evt);
            }
        });
        jPanel11.add(ver_nover, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 115, 20, 20));

        formatonombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel11.add(formatonombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, 20));

        formatoApe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel11.add(formatoApe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 190, 20));

        validadoRut1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel11.add(validadoRut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 150, 20));

        edituser_btn_guardar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edituser_btn_guardar_lbl_bloq.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        edituser_btn_guardar_lbl_bloq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edituser_btn_guardar_lbl_bloq.setText("Guardar ");
        edituser_btn_guardar_lbl_bloq.setEnabled(false);
        edituser_btn_guardar_lbl_bloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edituser_btn_guardar_lbl_bloqMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edituser_btn_guardar_lbl_bloqMouseEntered(evt);
            }
        });
        edituser_btn_guardar_pnl.add(edituser_btn_guardar_lbl_bloq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        edituser_btn_guardar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        edituser_btn_guardar_lbl.setForeground(new java.awt.Color(255, 255, 255));
        edituser_btn_guardar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edituser_btn_guardar_lbl.setText("Guardar ");
        edituser_btn_guardar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edituser_btn_guardar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edituser_btn_guardar_lblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edituser_btn_guardar_lblMouseEntered(evt);
            }
        });
        edituser_btn_guardar_pnl.add(edituser_btn_guardar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jPanel11.add(edituser_btn_guardar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 100, 40));

        edituser_btn_cancelar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edituser_btn_cancelar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        edituser_btn_cancelar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edituser_btn_cancelar_lbl.setText("Cancelar");
        edituser_btn_cancelar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edituser_btn_cancelar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edituser_btn_cancelar_lblMouseClicked(evt);
            }
        });
        edituser_btn_cancelar_pnl.add(edituser_btn_cancelar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jPanel11.add(edituser_btn_cancelar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 100, 40));

        formatopasspnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FormatoPass.setBackground(new java.awt.Color(204, 204, 204));
        formatopasspnl.add(FormatoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 20));

        jPanel11.add(formatopasspnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 370, 20));

        pass_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edituser_contenedor_password_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edituser_contenedor_password_jfActionPerformed(evt);
            }
        });
        edituser_contenedor_password_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edituser_contenedor_password_jfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edituser_contenedor_password_jfKeyTyped(evt);
            }
        });
        pass_pnl.add(edituser_contenedor_password_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        edituser_contenedor_password_pf.setText("jPasswordField1");
        edituser_contenedor_password_pf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edituser_contenedor_password_pfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edituser_contenedor_password_pfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edituser_contenedor_password_pfKeyTyped(evt);
            }
        });
        pass_pnl.add(edituser_contenedor_password_pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        jPanel11.add(pass_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 150, 30));

        jLabel2.setText("Permitidos (/*!@#$%^&*()\\\"{}_[]|\\\\?/<>,.)");
        jLabel2.setEnabled(false);
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 240, 30));

        Editarfechanacformat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel11.add(Editarfechanacformat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 170, 20));

        EditarUsuario.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        usuarios_principal_fondo_pnl.add(EditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 700, 400));

        getContentPane().add(usuarios_principal_fondo_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 425));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 425));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adduser_contenedor_addrut_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_contenedor_addrut_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_addrut_jfActionPerformed

    private void adduser_contenedor_addname_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_contenedor_addname_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_addname_jfActionPerformed

    private void adduser_contenedor_genero_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_contenedor_genero_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_genero_cboxActionPerformed

    private void adduser_contenedor_rol_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_contenedor_rol_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_rol_cboxActionPerformed

    private void adduser_contenedor_unidad_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_contenedor_unidad_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_unidad_cboxActionPerformed

    private void adduser_contenedor_addlastname_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_contenedor_addlastname_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_addlastname_jfActionPerformed

    private void Exit8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Exit8MouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_Exit8MouseClicked

    private void Exit8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Exit8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Exit8KeyPressed

    private void panelsupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelsupMouseDragged

    private void panelsupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsupMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelsupMousePressed

    private void adduser_btn_cancelar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_btn_cancelar_lblMouseClicked
        framep.setEnabled(true);
        dispose();

    }//GEN-LAST:event_adduser_btn_cancelar_lblMouseClicked

    private void adduser_btn_guardar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_btn_guardar_lblMouseClicked
        //'Alvaro Becker','22222222-2','ABECKER','password','01-ene-00','M','1','1'
        //ConexionOracle conn = new MetodosBD.ConexionOracle();

        try {
            SimpleDateFormat ff = new SimpleDateFormat("dd/MMMM/YYYY");

            String Fecha = ff.format(adduser_contenedor_fecha_ftf.getDate());

            String[] apellidos = adduser_contenedor_addlastname_jf.getText().split(" ");
            apellidomat = apellidos[apellidos.length - 1];
            String[] rutsindv = adduser_contenedor_addrut_jf.getText().split("-");
            last3rut = rutsindv[0].substring(rutsindv[0].length() - 3, rutsindv[0].length());
            midium3rut=rutsindv[0].substring(3,rutsindv[0].length() - 2);
            first3rut=rutsindv[0].substring(0,3);
            //username = (adduser_contenedor_addname_jf.getText().trim().substring(0, 1) + adduser_contenedor_addlastname_jf.getText().trim()).toUpperCase();
            username = apellidomat.substring(0, 1).toUpperCase() + last3rut;
            usrnamerep = conn.usrRep(username);
            if(usrnamerep){
            username=apellidomat.substring(0, 1).toUpperCase() + midium3rut;
            usrnamerep2 = conn.usrRep(username);
            if(usrnamerep2){
            username=apellidomat.substring(0, 1).toUpperCase() + first3rut;
            }
            }
            String[] args = {adduser_contenedor_addname_jf.getText().trim() + " " + adduser_contenedor_addlastname_jf.getText().trim(),
                adduser_contenedor_addrut_jf.getText(),
                username,
                adduser_contenedor_addrut_jf.getText().substring(0, 5),
                Fecha,
                adduser_contenedor_genero_cbox.getSelectedItem().toString(),
                String.valueOf(conn.transformador("ROL", adduser_contenedor_rol_cbox, "id_rol", "nombre_rol")),
                String.valueOf(conn.transformador("UNIDAD_INTERNA", adduser_contenedor_unidad_cbox, "id_unidad", "nombre_unidad"))
            };

            if (conn.repetido(adduser_contenedor_addrut_jf.getText().toString(), framep)) {
                Object[] confirmar = new Object[]{"¿Agregar Usuario " + args[0] + "?", this, table, 0, "agregar", "usr", args, framep};
                ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
                conf.setVisible(true);
            } else {
                Error err = new Error("El RUT ingresado ya existe", this, framep);
                err.setVisible(true);
            }

        } catch (Exception e) {
            Error err = new Error("Error, revisa los datos ingresados", this, framep);
            err.setVisible(true);
        }

    }//GEN-LAST:event_adduser_btn_guardar_lblMouseClicked

    private void edituser_contenedor_addrut_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituser_contenedor_addrut_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_addrut_jfActionPerformed

    private void edituser_contenedor_addname_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituser_contenedor_addname_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_addname_jfActionPerformed

    private void edituser_contenedor_password_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituser_contenedor_password_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_password_jfActionPerformed

    private void edituser_contenedor_rol_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituser_contenedor_rol_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_rol_cboxActionPerformed

    private void edituser_contenedor_unidad_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituser_contenedor_unidad_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_unidad_cboxActionPerformed

    private void edituser_contenedor_addlastname_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edituser_contenedor_addlastname_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_addlastname_jfActionPerformed

    private void edituser_btn_cancelar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edituser_btn_cancelar_lblMouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_edituser_btn_cancelar_lblMouseClicked

    private void edituser_btn_guardar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edituser_btn_guardar_lblMouseClicked
        //ConexionOracle conn=new ConexionOracle();
        SimpleDateFormat ff = new SimpleDateFormat("dd/MMMM/YYYY");
        String Fecha = ff.format(edituser_contenedor_fecha_ftf.getDate());
        String rol = String.valueOf(conn.obtenerRol_Unidad((String) edituser_contenedor_rol_cbox.getSelectedItem(), "id_rol", "nombre_rol", "ROL"));
        String unidad = String.valueOf(conn.obtenerRol_Unidad((String) edituser_contenedor_unidad_cbox.getSelectedItem(), "id_unidad", "nombre_unidad", "UNIDAD_INTERNA"));
        String[] apellidos = edituser_contenedor_addlastname_jf.getText().split(" ");
        apellidomat = apellidos[apellidos.length - 1];
        String[] rutsindv = edituser_contenedor_addrut_jf.getText().split("-");
        last3rut = rutsindv[0].substring(rutsindv[0].length() - 3, rutsindv[0].length());
        //username = (adduser_contenedor_addname_jf.getText().trim().substring(0, 1) + adduser_contenedor_addlastname_jf.getText().trim()).toUpperCase();
        username = apellidomat.substring(0, 1).toUpperCase() + last3rut;
        try {
            String[] args = new String[]{
                conn.obtenerIDusuario((String) table.getValueAt(table.getSelectedRow(), 1), this),
                edituser_contenedor_addname_jf.getText().trim() + " " + edituser_contenedor_addlastname_jf.getText().trim(),
                edituser_contenedor_addrut_jf.getText(),
                username,
                edituser_contenedor_password_jf.getText(),
                Fecha,
                (String) edituser_contenedor_genero_cbox.getSelectedItem(),
                rol,
                unidad,
                "1"
            };
            Object[] confirmar = new Object[]{"¿Editar Usuario " + args[1] + "?", this, table, 0, "editar", "usr", args, framep};
            ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
            conf.setVisible(true);

        } catch (Exception e) {
        }

    }//GEN-LAST:event_edituser_btn_guardar_lblMouseClicked

    private void edituser_btn_guardar_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edituser_btn_guardar_lblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_btn_guardar_lblMouseEntered

    private void adduser_contenedor_addrut_jfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adduser_contenedor_addrut_jfKeyPressed

    }//GEN-LAST:event_adduser_contenedor_addrut_jfKeyPressed

    private void adduser_contenedor_addrut_jfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_addrut_jfMouseClicked

    }//GEN-LAST:event_adduser_contenedor_addrut_jfMouseClicked

    private void adduser_contenedor_addrut_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adduser_contenedor_addrut_jfKeyReleased
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addname_jf, formatonombre);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addlastname_jf, formatoApe);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(adduser_contenedor_addname_jf, adduser_contenedor_addlastname_jf, adduser_contenedor_addrut_jf, adduser_contenedor_fecha_ftf, this);
            Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText());
            boolean repetido = conn.repetido(adduser_contenedor_addrut_jf.getText(), framep);

            boolean ver = Metodos.MetodosFront.VerificadorRut(adduser_contenedor_addrut_jf, Metodos.MetodosFront.rut.validadorRut(r.getArray(), r.getDv()), validadoRut, repetido);
            boolean mayoredad = Metodos.MetodosFront.mayor15(adduser_contenedor_fecha_ftf, formatofecha);
            if (llenos && ver && formatnombre && formatape && mayoredad) {

                adduser_btn_guardar_lbl.setEnabled(true);
                adduser_btn_guardar_lbl.setFocusable(true);
                adduser_btn_guardar_lbl.setVisible(true);
                adduser_btn_guardar_lbl_bloq.setVisible(false);

            } else {

                adduser_btn_guardar_lbl.setEnabled(false);
                adduser_btn_guardar_lbl.setFocusable(false);
                adduser_btn_guardar_lbl.setVisible(false);
                adduser_btn_guardar_lbl_bloq.setVisible(true);

            }
            if (adduser_contenedor_addrut_jf.getText().length() >= 10) {
                evt.consume();
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_adduser_contenedor_addrut_jfKeyReleased

    private void adduser_contenedor_addrut_jfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_addrut_jfMouseReleased


    }//GEN-LAST:event_adduser_contenedor_addrut_jfMouseReleased

    private void usuarios_principal_contenedor_pnlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarios_principal_contenedor_pnlKeyReleased


    }//GEN-LAST:event_usuarios_principal_contenedor_pnlKeyReleased

    private void adduser_btn_guardar_lbl_bloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_btn_guardar_lbl_bloqMouseClicked
        Error err = new Error("Error, revisa los datos ingresados!", this, framep);
        err.setVisible(true);
    }//GEN-LAST:event_adduser_btn_guardar_lbl_bloqMouseClicked

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void usuarios_principal_contenedor_pnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarios_principal_contenedor_pnlMouseClicked
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addname_jf, formatonombre);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addlastname_jf, formatoApe);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(adduser_contenedor_addname_jf, adduser_contenedor_addlastname_jf, adduser_contenedor_addrut_jf, adduser_contenedor_fecha_ftf, this);
            Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText());
            boolean repetido = conn.repetido(adduser_contenedor_addrut_jf.getText(), framep);
            boolean ver = Metodos.MetodosFront.VerificadorRut(adduser_contenedor_addrut_jf, Metodos.MetodosFront.rut.validadorRut(r.getArray(), r.getDv()), validadoRut, repetido);
            boolean mayoredad = Metodos.MetodosFront.mayor15(adduser_contenedor_fecha_ftf, formatofecha);
            if (llenos && ver && formatnombre && formatape && mayoredad) {

                adduser_btn_guardar_lbl.setEnabled(true);
                adduser_btn_guardar_lbl.setFocusable(true);
                adduser_btn_guardar_lbl.setVisible(true);
                adduser_btn_guardar_lbl_bloq.setVisible(false);

            } else {

                adduser_btn_guardar_lbl.setEnabled(false);
                adduser_btn_guardar_lbl.setFocusable(false);
                adduser_btn_guardar_lbl.setVisible(false);
                adduser_btn_guardar_lbl_bloq.setVisible(true);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_usuarios_principal_contenedor_pnlMouseClicked

    private void adduser_contenedor_addname_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adduser_contenedor_addname_jfKeyReleased
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addname_jf, formatonombre);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addlastname_jf, formatoApe);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(adduser_contenedor_addname_jf, adduser_contenedor_addlastname_jf, adduser_contenedor_addrut_jf, adduser_contenedor_fecha_ftf, this);
            Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText());
            boolean repetido = conn.repetido(adduser_contenedor_addrut_jf.getText(), framep);
            boolean ver = Metodos.MetodosFront.VerificadorRut(adduser_contenedor_addrut_jf, Metodos.MetodosFront.rut.validadorRut(r.getArray(), r.getDv()), validadoRut, repetido);
            boolean mayoredad = Metodos.MetodosFront.mayor15(adduser_contenedor_fecha_ftf, formatofecha);
            if (llenos && ver && formatnombre && formatape && mayoredad) {

                adduser_btn_guardar_lbl.setEnabled(true);
                adduser_btn_guardar_lbl.setFocusable(true);
                adduser_btn_guardar_lbl.setVisible(true);
                adduser_btn_guardar_lbl_bloq.setVisible(false);

            } else {

                adduser_btn_guardar_lbl.setEnabled(false);
                adduser_btn_guardar_lbl.setFocusable(false);
                adduser_btn_guardar_lbl.setVisible(false);
                adduser_btn_guardar_lbl_bloq.setVisible(true);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_adduser_contenedor_addname_jfKeyReleased

    private void adduser_contenedor_addlastname_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adduser_contenedor_addlastname_jfKeyReleased
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addname_jf, formatonombre);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addlastname_jf, formatoApe);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(adduser_contenedor_addname_jf, adduser_contenedor_addlastname_jf, adduser_contenedor_addrut_jf, adduser_contenedor_fecha_ftf, this);
            Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText());
            boolean repetido = conn.repetido(adduser_contenedor_addrut_jf.getText(), framep);
            boolean ver = Metodos.MetodosFront.VerificadorRut(adduser_contenedor_addrut_jf, Metodos.MetodosFront.rut.validadorRut(r.getArray(), r.getDv()), validadoRut, repetido);
            boolean mayoredad = Metodos.MetodosFront.mayor15(adduser_contenedor_fecha_ftf, formatofecha);
            if (llenos && ver && formatnombre && formatape && mayoredad) {

                adduser_btn_guardar_lbl.setEnabled(true);
                adduser_btn_guardar_lbl.setFocusable(true);
                adduser_btn_guardar_lbl.setVisible(true);
                adduser_btn_guardar_lbl_bloq.setVisible(false);

            } else {

                adduser_btn_guardar_lbl.setEnabled(false);
                adduser_btn_guardar_lbl.setFocusable(false);
                adduser_btn_guardar_lbl.setVisible(false);
                adduser_btn_guardar_lbl_bloq.setVisible(true);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_adduser_contenedor_addlastname_jfKeyReleased

    private void adduser_contenedor_fecha_ftfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_fecha_ftfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_adduser_contenedor_fecha_ftfMouseClicked

    private void adduser_contenedor_fecha_ftfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_fecha_ftfMouseExited

    }//GEN-LAST:event_adduser_contenedor_fecha_ftfMouseExited

    private void adduser_contenedor_fecha_ftfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adduser_contenedor_fecha_ftfFocusLost

    }//GEN-LAST:event_adduser_contenedor_fecha_ftfFocusLost

    private void adduser_contenedor_fecha_ftfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_fecha_ftfMouseReleased

    }//GEN-LAST:event_adduser_contenedor_fecha_ftfMouseReleased

    private void adduser_contenedor_addname_jfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_addname_jfMouseClicked

    }//GEN-LAST:event_adduser_contenedor_addname_jfMouseClicked

    private void adduser_contenedor_addlastname_jfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adduser_contenedor_addlastname_jfMouseClicked

    }//GEN-LAST:event_adduser_contenedor_addlastname_jfMouseClicked

    private void edituser_contenedor_addname_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_addname_jfKeyReleased
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(edituser_contenedor_addname_jf, edituser_contenedor_addlastname_jf, edituser_contenedor_addrut_jf, edituser_contenedor_fecha_ftf, this);
            //Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText().toString());
            edituser_contenedor_password_pf.setText(edituser_contenedor_password_jf.getText());
            boolean validcon = Metodos.MetodosFront.esSegura(edituser_contenedor_password_jf.getText(), FormatoPass, pass_pnl, formatopasspnl);
            boolean mayoredad = Metodos.MetodosFront.mayor15(edituser_contenedor_fecha_ftf, Editarfechanacformat);
            if (llenos && formatnombre && formatape && validcon && mayoredad) {

                edituser_btn_guardar_lbl.setEnabled(true);
                edituser_btn_guardar_lbl.setFocusable(true);
                edituser_btn_guardar_lbl.setVisible(true);
                edituser_btn_guardar_lbl_bloq.setVisible(false);
                // edituser_btn_guardar_lbl_bloq.setEnabled(false);
                edituser_btn_guardar_lbl_bloq.setFocusable(false);

            } else {

                edituser_btn_guardar_lbl.setEnabled(false);
                edituser_btn_guardar_lbl.setFocusable(false);
                edituser_btn_guardar_lbl.setVisible(false);
                edituser_btn_guardar_lbl_bloq.setVisible(true);
                // edituser_btn_guardar_lbl_bloq.setEnabled(true);
                edituser_btn_guardar_lbl_bloq.setFocusable(true);

            }
        } catch (ParseException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_edituser_contenedor_addname_jfKeyReleased

    private void edituser_btn_guardar_lbl_bloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edituser_btn_guardar_lbl_bloqMouseClicked
        Error err = new Error("Error, revisa los datos ingresados!", this, framep);
        err.setVisible(true);
    }//GEN-LAST:event_edituser_btn_guardar_lbl_bloqMouseClicked

    private void edituser_btn_guardar_lbl_bloqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edituser_btn_guardar_lbl_bloqMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_btn_guardar_lbl_bloqMouseEntered

    private void edituser_contenedor_addlastname_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_addlastname_jfKeyReleased
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(edituser_contenedor_addname_jf, edituser_contenedor_addlastname_jf, edituser_contenedor_addrut_jf, edituser_contenedor_fecha_ftf, this);
            //Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText().toString());
            edituser_contenedor_password_pf.setText(edituser_contenedor_password_jf.getText());
            boolean validcon = Metodos.MetodosFront.esSegura(edituser_contenedor_password_jf.getText(), FormatoPass, pass_pnl, formatopasspnl);
            boolean mayoredad = Metodos.MetodosFront.mayor15(edituser_contenedor_fecha_ftf, Editarfechanacformat);
            if (llenos && formatnombre && formatape && validcon && mayoredad) {

                edituser_btn_guardar_lbl.setEnabled(true);
                edituser_btn_guardar_lbl.setFocusable(true);
                edituser_btn_guardar_lbl.setVisible(true);
                edituser_btn_guardar_lbl_bloq.setVisible(false);
                // edituser_btn_guardar_lbl_bloq.setEnabled(false);
                edituser_btn_guardar_lbl_bloq.setFocusable(false);

            } else {

                edituser_btn_guardar_lbl.setEnabled(false);
                edituser_btn_guardar_lbl.setFocusable(false);
                edituser_btn_guardar_lbl.setVisible(false);
                edituser_btn_guardar_lbl_bloq.setVisible(true);
                // edituser_btn_guardar_lbl_bloq.setEnabled(true);
                edituser_btn_guardar_lbl_bloq.setFocusable(true);

            }
        } catch (ParseException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edituser_contenedor_addlastname_jfKeyReleased

    private void ver_noverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver_noverMouseClicked
        if (edituser_contenedor_password_pf.isVisible()) {
            Metodos.MetodosFront.SetImageLabel(ver_nover, "src/main/resources/Images/no ver.png", this);
            edituser_contenedor_password_pf.setVisible(false);
            edituser_contenedor_password_pf.setEnabled(false);
            edituser_contenedor_password_pf.setFocusable(false);
            edituser_contenedor_password_jf.setVisible(true);
            edituser_contenedor_password_jf.setEnabled(true);
            edituser_contenedor_password_jf.setFocusable(true);
        } else {
            Metodos.MetodosFront.SetImageLabel(ver_nover, "src/main/resources/Images/ver.png", this);
            edituser_contenedor_password_jf.setVisible(false);
            edituser_contenedor_password_jf.setEnabled(false);
            edituser_contenedor_password_jf.setFocusable(false);
            edituser_contenedor_password_pf.setVisible(true);
            edituser_contenedor_password_pf.setEnabled(true);
            edituser_contenedor_password_pf.setFocusable(true);
        }
    }//GEN-LAST:event_ver_noverMouseClicked

    private void edituser_contenedor_password_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_password_jfKeyReleased
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(edituser_contenedor_addname_jf, edituser_contenedor_addlastname_jf, edituser_contenedor_addrut_jf, edituser_contenedor_fecha_ftf, this);
            //Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText().toString());
            edituser_contenedor_password_pf.setText(edituser_contenedor_password_jf.getText());
            boolean validcon = Metodos.MetodosFront.esSegura(edituser_contenedor_password_jf.getText(), FormatoPass, pass_pnl, formatopasspnl);
            boolean mayoredad = Metodos.MetodosFront.mayor15(edituser_contenedor_fecha_ftf, Editarfechanacformat);
            if (llenos && formatnombre && formatape && validcon && mayoredad) {

                edituser_btn_guardar_lbl.setEnabled(true);
                edituser_btn_guardar_lbl.setFocusable(true);
                edituser_btn_guardar_lbl.setVisible(true);
                edituser_btn_guardar_lbl_bloq.setVisible(false);
                // edituser_btn_guardar_lbl_bloq.setEnabled(false);
                edituser_btn_guardar_lbl_bloq.setFocusable(false);

            } else {

                edituser_btn_guardar_lbl.setEnabled(false);
                edituser_btn_guardar_lbl.setFocusable(false);
                edituser_btn_guardar_lbl.setVisible(false);
                edituser_btn_guardar_lbl_bloq.setVisible(true);
                // edituser_btn_guardar_lbl_bloq.setEnabled(true);
                edituser_btn_guardar_lbl_bloq.setFocusable(true);

            }
        } catch (ParseException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edituser_contenedor_password_jfKeyReleased

    private void edituser_contenedor_password_pfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_password_pfKeyReleased
        edituser_contenedor_password_jf.setText(pas.valueOf(edituser_contenedor_password_pf.getPassword()));
        boolean formatnombre = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
        boolean formatape = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
        boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(edituser_contenedor_addname_jf, edituser_contenedor_addlastname_jf, edituser_contenedor_addrut_jf, edituser_contenedor_fecha_ftf, this);
        //Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText().toString());

        boolean validcon = Metodos.MetodosFront.esSegura(edituser_contenedor_password_jf.getText(), FormatoPass, pass_pnl, formatopasspnl);
        if (llenos && formatnombre && formatape && validcon) {

            edituser_btn_guardar_lbl.setEnabled(true);
            edituser_btn_guardar_lbl.setFocusable(true);
            edituser_btn_guardar_lbl.setVisible(true);
            edituser_btn_guardar_lbl_bloq.setVisible(false);
            //edituser_btn_guardar_lbl_bloq.setEnabled(false);
            edituser_btn_guardar_lbl_bloq.setFocusable(false);

        } else {

            edituser_btn_guardar_lbl.setEnabled(false);
            edituser_btn_guardar_lbl.setFocusable(false);
            edituser_btn_guardar_lbl.setVisible(false);
            edituser_btn_guardar_lbl_bloq.setVisible(true);
            //edituser_btn_guardar_lbl_bloq.setEnabled(true);
            edituser_btn_guardar_lbl_bloq.setFocusable(true);
        }
    }//GEN-LAST:event_edituser_contenedor_password_pfKeyReleased

    private void edituser_contenedor_password_pfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_password_pfKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_edituser_contenedor_password_pfKeyPressed

    private void adduser_contenedor_fecha_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_adduser_contenedor_fecha_ftfPropertyChange
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addname_jf, formatonombre);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(adduser_contenedor_addlastname_jf, formatoApe);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(adduser_contenedor_addname_jf, adduser_contenedor_addlastname_jf, adduser_contenedor_addrut_jf, adduser_contenedor_fecha_ftf, this);
            Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText());
            boolean repetido = conn.repetido(adduser_contenedor_addrut_jf.getText(), framep);
            boolean ver = Metodos.MetodosFront.VerificadorRut(adduser_contenedor_addrut_jf, Metodos.MetodosFront.rut.validadorRut(r.getArray(), r.getDv()), validadoRut, repetido);
            boolean mayoredad = Metodos.MetodosFront.mayor15(adduser_contenedor_fecha_ftf, formatofecha);
            if (llenos && ver && formatnombre && formatape && mayoredad) {

                adduser_btn_guardar_lbl.setEnabled(true);
                adduser_btn_guardar_lbl.setFocusable(true);
                adduser_btn_guardar_lbl.setVisible(true);
                adduser_btn_guardar_lbl_bloq.setVisible(false);

            } else {

                adduser_btn_guardar_lbl.setEnabled(false);
                adduser_btn_guardar_lbl.setFocusable(false);
                adduser_btn_guardar_lbl.setVisible(false);
                adduser_btn_guardar_lbl_bloq.setVisible(true);

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_adduser_contenedor_fecha_ftfPropertyChange

    private void edituser_contenedor_fecha_ftfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_edituser_contenedor_fecha_ftfPropertyChange
        try {
            boolean formatnombre = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addname_jf, formatonombre1);
            boolean formatape = Metodos.MetodosFront.formatoNomApe(edituser_contenedor_addlastname_jf, formatoApe1);
            boolean llenos = Metodos.MetodosFront.addUsercamposLlenos(edituser_contenedor_addname_jf, edituser_contenedor_addlastname_jf, edituser_contenedor_addrut_jf, edituser_contenedor_fecha_ftf, this);
            //Metodos.MetodosFront.rut r = new rut(adduser_contenedor_addrut_jf.getText().toString());
            edituser_contenedor_password_pf.setText(edituser_contenedor_password_jf.getText());
            boolean validcon = Metodos.MetodosFront.esSegura(edituser_contenedor_password_jf.getText(), FormatoPass, pass_pnl, formatopasspnl);
            boolean mayoredad = Metodos.MetodosFront.mayor15(edituser_contenedor_fecha_ftf, Editarfechanacformat);
            if (llenos && formatnombre && formatape && validcon && mayoredad) {

                edituser_btn_guardar_lbl.setEnabled(true);
                edituser_btn_guardar_lbl.setFocusable(true);
                edituser_btn_guardar_lbl.setVisible(true);
                edituser_btn_guardar_lbl_bloq.setVisible(false);
                // edituser_btn_guardar_lbl_bloq.setEnabled(false);
                edituser_btn_guardar_lbl_bloq.setFocusable(false);

            } else {

                edituser_btn_guardar_lbl.setEnabled(false);
                edituser_btn_guardar_lbl.setFocusable(false);
                edituser_btn_guardar_lbl.setVisible(false);
                edituser_btn_guardar_lbl_bloq.setVisible(true);
                // edituser_btn_guardar_lbl_bloq.setEnabled(true);
                edituser_btn_guardar_lbl_bloq.setFocusable(true);

            }
        } catch (ParseException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edituser_contenedor_fecha_ftfPropertyChange

    private void adduser_contenedor_addrut_jfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adduser_contenedor_addrut_jfKeyTyped
        if (adduser_contenedor_addrut_jf.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_adduser_contenedor_addrut_jfKeyTyped

    private void edituser_contenedor_password_jfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_password_jfKeyTyped
        if (edituser_contenedor_password_jf.getText().length() >= 12) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_edituser_contenedor_password_jfKeyTyped

    private void edituser_contenedor_password_pfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edituser_contenedor_password_pfKeyTyped
        if (edituser_contenedor_password_pf.getText().length() >= 12) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_edituser_contenedor_password_pfKeyTyped

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CrearUsuario;
    private javax.swing.JPanel EditarUsuario;
    private javax.swing.JLabel Editarfechanacformat;
    private javax.swing.JLabel Exit8;
    private javax.swing.JLabel FormatoPass;
    private javax.swing.JLabel adduser_btn_cancelar_lbl;
    private javax.swing.JPanel adduser_btn_cancelar_pnl;
    private javax.swing.JLabel adduser_btn_guardar_lbl;
    private javax.swing.JLabel adduser_btn_guardar_lbl_bloq;
    private javax.swing.JPanel adduser_btn_guardar_pnl;
    private javax.swing.JTextField adduser_contenedor_addlastname_jf;
    private javax.swing.JTextField adduser_contenedor_addname_jf;
    private javax.swing.JTextField adduser_contenedor_addrut_jf;
    private com.toedter.calendar.JDateChooser adduser_contenedor_fecha_ftf;
    private javax.swing.JComboBox<String> adduser_contenedor_genero_cbox;
    private javax.swing.JComboBox<String> adduser_contenedor_rol_cbox;
    private javax.swing.JComboBox<String> adduser_contenedor_unidad_cbox;
    private javax.swing.JLabel adduser_principal_subtitulo_lbl;
    private javax.swing.JLabel adduser_principal_titulo_lbl;
    private javax.swing.JLabel adduser_titulo_addlastname_lbl;
    private javax.swing.JLabel adduser_titulo_addname_lbl;
    private javax.swing.JLabel adduser_titulo_addrut_lbl;
    private javax.swing.JLabel adduser_titulo_datenacimiento_lbl;
    private javax.swing.JLabel adduser_titulo_genero_lbl;
    private javax.swing.JLabel adduser_titulo_rol_lbl;
    private javax.swing.JLabel adduser_titulo_unidad_lbl;
    private javax.swing.JLabel edituser_btn_cancelar_lbl;
    private javax.swing.JPanel edituser_btn_cancelar_pnl;
    private javax.swing.JLabel edituser_btn_guardar_lbl;
    private javax.swing.JLabel edituser_btn_guardar_lbl_bloq;
    private javax.swing.JPanel edituser_btn_guardar_pnl;
    private javax.swing.JTextField edituser_contenedor_addlastname_jf;
    private javax.swing.JTextField edituser_contenedor_addname_jf;
    private javax.swing.JTextField edituser_contenedor_addrut_jf;
    private com.toedter.calendar.JDateChooser edituser_contenedor_fecha_ftf;
    private javax.swing.JComboBox<String> edituser_contenedor_genero_cbox;
    private javax.swing.JTextField edituser_contenedor_password_jf;
    private javax.swing.JPasswordField edituser_contenedor_password_pf;
    private javax.swing.JComboBox<String> edituser_contenedor_rol_cbox;
    private javax.swing.JComboBox<String> edituser_contenedor_unidad_cbox;
    private javax.swing.JLabel edituser_principal_subtitulo_lbl;
    private javax.swing.JLabel edituser_principal_titulo_lbl;
    private javax.swing.JLabel edituser_titulo_addlastname_lbl;
    private javax.swing.JLabel edituser_titulo_addname_lbl;
    private javax.swing.JLabel edituser_titulo_addrut_lbl;
    private javax.swing.JLabel edituser_titulo_datenacimiento_lbl;
    private javax.swing.JLabel edituser_titulo_genero_lbl;
    private javax.swing.JLabel edituser_titulo_password_lbl;
    private javax.swing.JLabel edituser_titulo_rol_lbl;
    private javax.swing.JLabel edituser_titulo_unidad_lbl;
    private javax.swing.JLabel formatoApe;
    private javax.swing.JLabel formatoApe1;
    private javax.swing.JLabel formatofecha;
    private javax.swing.JLabel formatonombre;
    private javax.swing.JLabel formatonombre1;
    private javax.swing.JPanel formatopasspnl;
    private javax.swing.JLabel formatorut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel obligatorio;
    private javax.swing.JPanel panelsup;
    private javax.swing.JPanel pass_pnl;
    private javax.swing.JPanel usuarios_principal_contenedor_pnl;
    private javax.swing.JPanel usuarios_principal_fondo_pnl;
    private javax.swing.JLabel validadoRut;
    private javax.swing.JLabel validadoRut1;
    private javax.swing.JLabel ver_nover;
    // End of variables declaration//GEN-END:variables
}
