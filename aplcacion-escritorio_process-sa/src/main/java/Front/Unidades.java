/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Alvaro Becker
 */
public class Unidades extends javax.swing.JFrame {

    int xMouse, yMouse;
    String string;
    JFrame framep;
    Metodos.MetodosBD.ConexionOracle conn;
    JTable table;

    /**
     * Creates new form Unidades
     * @param args
     * @param con
     */
    public Unidades(Object[] args, Metodos.MetodosBD.ConexionOracle con) {
        initComponents();
        conn = con;
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        setShape(forma);
        crearunidad_addu_btn_pnl.setOpaque(false);
        crearunidad_canceladdu_btn_pnl.setOpaque(false);
        crearunidad_canceladdu_btn_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.LIGHT_GRAY));
        crearunidad_addu_btn_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        editunidad_btn_guardar_pnl.setOpaque(false);
        editunidad_btn_guardar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        editunidad_btn_cancelar_pnl.setOpaque(false);
        editunidad_btn_cancelar_pnl.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.LIGHT_GRAY, true, Color.LIGHT_GRAY));
        this.setComponentZOrder(labelFondo, 0);
        labelFondo.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.BLACK, false, null));
        labelFondo.setFocusable(false);
        labelFondo.setEnabled(false);
        table = (JTable) args[2];
        if (args[0].equals("crear")) {
            crearunidad_crear_pnl.setVisible(true);
            crearunidad_crear_pnl.setFocusable(true);
            crearunidad_crear_pnl.setEnabled(true);
            crearunidad_editar_pnl.setVisible(false);
            crearunidad_editar_pnl.setFocusable(false);
            crearunidad_editar_pnl.setEnabled(false);
        } else {
            crearunidad_crear_pnl.setVisible(false);
            crearunidad_crear_pnl.setFocusable(false);
            crearunidad_crear_pnl.setEnabled(false);
            crearunidad_editar_pnl.setVisible(true);
            crearunidad_editar_pnl.setFocusable(true);
            crearunidad_editar_pnl.setEnabled(true);
            crearunidad_editar_pnl.setBackground(Color.WHITE);
            editunidad_btn_guardar_lbl_bloq.setVisible(false);
            editarunidad_newnameu_contenedor_jf.setText((String) args[args.length - 1]);

        }
        framep = (JFrame) args[1];
        framep.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_inicial = new javax.swing.JPanel();
        panelsup = new javax.swing.JPanel();
        Exit8 = new javax.swing.JLabel();
        crearunidad_crear_pnl = new javax.swing.JPanel();
        crearunidad_nameu_titulo_lbl = new javax.swing.JLabel();
        crearunidad_detalle_titulo_lbl = new javax.swing.JLabel();
        crearunidad_addu_titulo_lbl = new javax.swing.JLabel();
        crearunidad_unidad_contenedor_jf = new javax.swing.JTextField();
        crearunidad_separador_separador = new javax.swing.JSeparator();
        crearunidad_addu_btn_pnl = new javax.swing.JPanel();
        crearunidad_addu_btn_lbl_bloq = new javax.swing.JLabel();
        crearunidad_addu_btn_lbl = new javax.swing.JLabel();
        crearunidad_canceladdu_btn_pnl = new javax.swing.JPanel();
        crearunidad_canceladdu_btn_lbl = new javax.swing.JLabel();
        crearunidad_editar_pnl = new javax.swing.JPanel();
        editarunidad_newnameu_titulo_lbl = new javax.swing.JLabel();
        editarunidad_detalle_titulo_lbl = new javax.swing.JLabel();
        editarunidad_newnameu_titulo_lb = new javax.swing.JLabel();
        editarunidad_newnameu_contenedor_jf = new javax.swing.JTextField();
        editarunidad_separador_separador = new javax.swing.JSeparator();
        editunidad_btn_guardar_pnl = new javax.swing.JPanel();
        editunidad_btn_guardar_lbl_bloq = new javax.swing.JLabel();
        editunidad_btn_guardar_lbl = new javax.swing.JLabel();
        editunidad_btn_cancelar_pnl = new javax.swing.JPanel();
        editunidad_btn_cancelar_lbl = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setSize(new java.awt.Dimension(520, 245));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_inicial.setBackground(new java.awt.Color(255, 255, 255));
        panel_inicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelsup.add(Exit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 0, 25, 25));

        panel_inicial.add(panelsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 25));

        crearunidad_crear_pnl.setBackground(new java.awt.Color(255, 255, 255));
        crearunidad_crear_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearunidad_nameu_titulo_lbl.setText("Nombre de la unidad");
        crearunidad_crear_pnl.add(crearunidad_nameu_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        crearunidad_detalle_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        crearunidad_detalle_titulo_lbl.setText("Detalles");
        crearunidad_crear_pnl.add(crearunidad_detalle_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        crearunidad_addu_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        crearunidad_addu_titulo_lbl.setText("Crear unidad interna");
        crearunidad_crear_pnl.add(crearunidad_addu_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 243, -1));

        crearunidad_unidad_contenedor_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearunidad_unidad_contenedor_jfActionPerformed(evt);
            }
        });
        crearunidad_unidad_contenedor_jf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                crearunidad_unidad_contenedor_jfKeyReleased(evt);
            }
        });
        crearunidad_crear_pnl.add(crearunidad_unidad_contenedor_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 327, 42));

        crearunidad_separador_separador.setOrientation(javax.swing.SwingConstants.VERTICAL);
        crearunidad_crear_pnl.add(crearunidad_separador_separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 6, -1, 210));

        crearunidad_addu_btn_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearunidad_addu_btn_lbl_bloq.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        crearunidad_addu_btn_lbl_bloq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crearunidad_addu_btn_lbl_bloq.setText("Guardar ");
        crearunidad_addu_btn_lbl_bloq.setEnabled(false);
        crearunidad_addu_btn_lbl_bloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearunidad_addu_btn_lbl_bloqMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearunidad_addu_btn_lbl_bloqMouseEntered(evt);
            }
        });
        crearunidad_addu_btn_pnl.add(crearunidad_addu_btn_lbl_bloq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        crearunidad_addu_btn_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        crearunidad_addu_btn_lbl.setForeground(new java.awt.Color(255, 255, 255));
        crearunidad_addu_btn_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crearunidad_addu_btn_lbl.setText("Guardar ");
        crearunidad_addu_btn_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearunidad_addu_btn_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearunidad_addu_btn_lblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearunidad_addu_btn_lblMouseEntered(evt);
            }
        });
        crearunidad_addu_btn_pnl.add(crearunidad_addu_btn_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        crearunidad_crear_pnl.add(crearunidad_addu_btn_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 40, 100, 40));

        crearunidad_canceladdu_btn_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearunidad_canceladdu_btn_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        crearunidad_canceladdu_btn_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crearunidad_canceladdu_btn_lbl.setText("Cancelar");
        crearunidad_canceladdu_btn_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearunidad_canceladdu_btn_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearunidad_canceladdu_btn_lblMouseClicked(evt);
            }
        });
        crearunidad_canceladdu_btn_pnl.add(crearunidad_canceladdu_btn_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        crearunidad_crear_pnl.add(crearunidad_canceladdu_btn_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 130, 100, 40));

        panel_inicial.add(crearunidad_crear_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 520, 220));

        crearunidad_editar_pnl.setBackground(new java.awt.Color(255, 255, 255));
        crearunidad_editar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editarunidad_newnameu_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editarunidad_newnameu_titulo_lbl.setText("Editar unidad interna");
        crearunidad_editar_pnl.add(editarunidad_newnameu_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 243, -1));

        editarunidad_detalle_titulo_lbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editarunidad_detalle_titulo_lbl.setText("Detalles");
        crearunidad_editar_pnl.add(editarunidad_detalle_titulo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, -1, -1));

        editarunidad_newnameu_titulo_lb.setText("Nuevo Nombre de la unidad");
        crearunidad_editar_pnl.add(editarunidad_newnameu_titulo_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, -1, -1));

        editarunidad_newnameu_contenedor_jf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarunidad_newnameu_contenedor_jfActionPerformed(evt);
            }
        });
        crearunidad_editar_pnl.add(editarunidad_newnameu_contenedor_jf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, 327, 42));

        editarunidad_separador_separador.setOrientation(javax.swing.SwingConstants.VERTICAL);
        crearunidad_editar_pnl.add(editarunidad_separador_separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 6, -1, 214));

        editunidad_btn_guardar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editunidad_btn_guardar_lbl_bloq.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editunidad_btn_guardar_lbl_bloq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editunidad_btn_guardar_lbl_bloq.setText("Guardar ");
        editunidad_btn_guardar_lbl_bloq.setEnabled(false);
        editunidad_btn_guardar_lbl_bloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editunidad_btn_guardar_lbl_bloqMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editunidad_btn_guardar_lbl_bloqMouseEntered(evt);
            }
        });
        editunidad_btn_guardar_pnl.add(editunidad_btn_guardar_lbl_bloq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        editunidad_btn_guardar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editunidad_btn_guardar_lbl.setForeground(new java.awt.Color(255, 255, 255));
        editunidad_btn_guardar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editunidad_btn_guardar_lbl.setText("Guardar ");
        editunidad_btn_guardar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editunidad_btn_guardar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editunidad_btn_guardar_lblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editunidad_btn_guardar_lblMouseEntered(evt);
            }
        });
        editunidad_btn_guardar_pnl.add(editunidad_btn_guardar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        crearunidad_editar_pnl.add(editunidad_btn_guardar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 40, 100, 40));

        editunidad_btn_cancelar_pnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editunidad_btn_cancelar_pnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editunidad_btn_cancelar_pnlMouseClicked(evt);
            }
        });
        editunidad_btn_cancelar_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editunidad_btn_cancelar_lbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editunidad_btn_cancelar_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editunidad_btn_cancelar_lbl.setText("Cancelar");
        editunidad_btn_cancelar_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editunidad_btn_cancelar_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editunidad_btn_cancelar_lblMouseClicked(evt);
            }
        });
        editunidad_btn_cancelar_pnl.add(editunidad_btn_cancelar_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        crearunidad_editar_pnl.add(editunidad_btn_cancelar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 130, 100, 40));

        panel_inicial.add(crearunidad_editar_pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 520, 220));

        getContentPane().add(panel_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 245));
        getContentPane().add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 245));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void crearunidad_unidad_contenedor_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearunidad_unidad_contenedor_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearunidad_unidad_contenedor_jfActionPerformed

    private void crearunidad_addu_btn_lbl_bloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearunidad_addu_btn_lbl_bloqMouseClicked
        Error err = new Error("Error, revisa los datos ingresados!", this, framep);
        err.setVisible(true);
    }//GEN-LAST:event_crearunidad_addu_btn_lbl_bloqMouseClicked

    private void crearunidad_addu_btn_lbl_bloqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearunidad_addu_btn_lbl_bloqMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_crearunidad_addu_btn_lbl_bloqMouseEntered

    private void crearunidad_addu_btn_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearunidad_addu_btn_lblMouseClicked
        String unidad = crearunidad_unidad_contenedor_jf.getText();
        String[] args = new String[]{
            unidad
        };

        Object[] confirmar = new Object[]{"¿Crear Unidad " + unidad + "?", this, table, 0, "agregar", "unidad", args, framep};
        ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
        conf.setVisible(true);

    }//GEN-LAST:event_crearunidad_addu_btn_lblMouseClicked

    private void crearunidad_addu_btn_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearunidad_addu_btn_lblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_crearunidad_addu_btn_lblMouseEntered

    private void crearunidad_canceladdu_btn_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearunidad_canceladdu_btn_lblMouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_crearunidad_canceladdu_btn_lblMouseClicked

    private void editunidad_btn_guardar_lbl_bloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editunidad_btn_guardar_lbl_bloqMouseClicked
        Error err = new Error("Error, revisa los datos ingresados!", this, framep);
        err.setVisible(true);
    }//GEN-LAST:event_editunidad_btn_guardar_lbl_bloqMouseClicked

    private void editunidad_btn_guardar_lbl_bloqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editunidad_btn_guardar_lbl_bloqMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_editunidad_btn_guardar_lbl_bloqMouseEntered

    private void editunidad_btn_guardar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editunidad_btn_guardar_lblMouseClicked
        String unidad = (String) table.getValueAt(table.getSelectedRow(), 0);
        int idunidad = conn.obteneridUnidad(unidad);
        String[] args = new String[]{
            editarunidad_newnameu_contenedor_jf.getText(),
            String.valueOf(idunidad)
        };

        Object[] confirmar = new Object[]{"¿Editar Unidad " + unidad + "?", this, table, 0, "editar", "unidad", args, framep};
        ConfirmarAccion conf = new ConfirmarAccion(confirmar, conn);
        conf.setVisible(true);


    }//GEN-LAST:event_editunidad_btn_guardar_lblMouseClicked

    private void editunidad_btn_guardar_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editunidad_btn_guardar_lblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_editunidad_btn_guardar_lblMouseEntered

    private void editunidad_btn_cancelar_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editunidad_btn_cancelar_lblMouseClicked
        framep.setEnabled(true);
        dispose();
    }//GEN-LAST:event_editunidad_btn_cancelar_lblMouseClicked

    private void editunidad_btn_cancelar_pnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editunidad_btn_cancelar_pnlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editunidad_btn_cancelar_pnlMouseClicked

    private void editarunidad_newnameu_contenedor_jfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarunidad_newnameu_contenedor_jfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarunidad_newnameu_contenedor_jfActionPerformed

    private void crearunidad_unidad_contenedor_jfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crearunidad_unidad_contenedor_jfKeyReleased
        boolean unidadrepetida = conn.unidadRep(crearunidad_unidad_contenedor_jf);
        if (unidadrepetida) {
            crearunidad_addu_btn_lbl_bloq.setVisible(true);
            crearunidad_addu_btn_lbl.setVisible(false);
            crearunidad_addu_btn_lbl.setEnabled(false);
            crearunidad_addu_btn_lbl.setFocusable(false);
        } else {
            crearunidad_addu_btn_lbl_bloq.setVisible(false);
            crearunidad_addu_btn_lbl.setVisible(true);
            crearunidad_addu_btn_lbl.setEnabled(true);
            crearunidad_addu_btn_lbl.setFocusable(true);
        }

    }//GEN-LAST:event_crearunidad_unidad_contenedor_jfKeyReleased

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
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unidades(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit8;
    private javax.swing.JLabel crearunidad_addu_btn_lbl;
    private javax.swing.JLabel crearunidad_addu_btn_lbl_bloq;
    private javax.swing.JPanel crearunidad_addu_btn_pnl;
    private javax.swing.JLabel crearunidad_addu_titulo_lbl;
    private javax.swing.JLabel crearunidad_canceladdu_btn_lbl;
    private javax.swing.JPanel crearunidad_canceladdu_btn_pnl;
    private javax.swing.JPanel crearunidad_crear_pnl;
    private javax.swing.JLabel crearunidad_detalle_titulo_lbl;
    private javax.swing.JPanel crearunidad_editar_pnl;
    private javax.swing.JLabel crearunidad_nameu_titulo_lbl;
    private javax.swing.JSeparator crearunidad_separador_separador;
    private javax.swing.JTextField crearunidad_unidad_contenedor_jf;
    private javax.swing.JLabel editarunidad_detalle_titulo_lbl;
    private javax.swing.JTextField editarunidad_newnameu_contenedor_jf;
    private javax.swing.JLabel editarunidad_newnameu_titulo_lb;
    private javax.swing.JLabel editarunidad_newnameu_titulo_lbl;
    private javax.swing.JSeparator editarunidad_separador_separador;
    private javax.swing.JLabel editunidad_btn_cancelar_lbl;
    private javax.swing.JPanel editunidad_btn_cancelar_pnl;
    private javax.swing.JLabel editunidad_btn_guardar_lbl;
    private javax.swing.JLabel editunidad_btn_guardar_lbl_bloq;
    private javax.swing.JPanel editunidad_btn_guardar_pnl;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JPanel panel_inicial;
    private javax.swing.JPanel panelsup;
    // End of variables declaration//GEN-END:variables
}
