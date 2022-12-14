/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front;

import Metodos.MetodosBD;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Alvaro Becker
 */
public class ConfirmarAccion extends javax.swing.JFrame {

    String msg, nomtabla;
    JFrame framep;
    JTable table;
    int idRow;
    int xMouse, yMouse;
    String acc;
    String[] args;
    JFrame framepp;
    MetodosBD.ConexionOracle conn;

    /**
     * Creates new form ConfirmarAccion
     *
     * @param confirmar
     * @param con
     */
    public ConfirmarAccion(Object[] confirmar, MetodosBD.ConexionOracle con) {
        initComponents();
        setLocationRelativeTo(null);
        conn = con;
        msg = (String) confirmar[0];
        framep = (JFrame) confirmar[1];
        table = (JTable) confirmar[2];
        idRow = (int) confirmar[3];
        acc = (String) confirmar[4];
        nomtabla = (String) confirmar[5];
        if (confirmar.length > 6) {

            args = (String[]) confirmar[6];
            framepp = (JFrame) confirmar[7];
        }

        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        setShape(forma);

        fondo.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(117, 170, 250), true, new Color(117, 170, 250)));
        fondo.setOpaque(false);
        contenedor.setBorder(Metodos.MetodosFront.setRoundedborder(20, Color.WHITE, true, Color.WHITE));
        contenedor.setOpaque(false);
        pnlconfirmar.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        pnlconfirmar.setOpaque(false);
        pnlcancelar.setBorder(Metodos.MetodosFront.setRoundedborder(20, new Color(8, 68, 164), true, new Color(8, 68, 164)));
        pnlcancelar.setOpaque(false);
        if(acc.equals("pdf")){
        Mensaje.setFont(new Font("Calibri",Font.BOLD,20));
        }
        Mensaje.setText(msg);
        framep.setEnabled(false);
        framep.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sup = new javax.swing.JPanel();
        fondo = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        pnlcancelar = new javax.swing.JPanel();
        lblcancelar = new javax.swing.JLabel();
        pnlconfirmar = new javax.swing.JPanel();
        lblconfirmar = new javax.swing.JLabel();
        Mensaje = new javax.swing.JLabel();
        borde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(350, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sup.setOpaque(false);
        sup.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                supMouseDragged(evt);
            }
        });
        sup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                supMousePressed(evt);
            }
        });

        javax.swing.GroupLayout supLayout = new javax.swing.GroupLayout(sup);
        sup.setLayout(supLayout);
        supLayout.setHorizontalGroup(
            supLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        supLayout.setVerticalGroup(
            supLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 20));

        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlcancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblcancelar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblcancelar.setForeground(new java.awt.Color(255, 255, 255));
        lblcancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcancelar.setText("Cancelar");
        lblcancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcancelarMouseClicked(evt);
            }
        });
        pnlcancelar.add(lblcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        contenedor.add(pnlcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 120, 50));

        pnlconfirmar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblconfirmar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblconfirmar.setForeground(new java.awt.Color(255, 255, 255));
        lblconfirmar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblconfirmar.setText("Confirmar");
        lblconfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblconfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblconfirmarMouseClicked(evt);
            }
        });
        pnlconfirmar.add(lblconfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        contenedor.add(pnlconfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, 50));

        Mensaje.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contenedor.add(Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 37, 380, 100));

        fondo.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 420, 270));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        borde.setText("jLabel2");
        getContentPane().add(borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblcancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcancelarMouseClicked
        framep.setEnabled(true);
        framep.setFocusable(true);
        dispose();
    }//GEN-LAST:event_lblcancelarMouseClicked

    private void lblconfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblconfirmarMouseClicked

        //MetodosBD.ConexionOracle conn = new MetodosBD.ConexionOracle();
        if (nomtabla.equals("usr")) {
            if (acc.equals("eliminar")) {
                try {
                    conn.eliminar(idRow);
                    conn.listar("USUARIO", table, "ID_USR");
                    //conn.desconectar();
                    /*ConfirmarAccion conf = new ConfirmarAccion();
                        conf.setVisible(true);*/
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                framep.setEnabled(true);
                framep.setFocusable(true);
                dispose();
                Error err = new Error("Usuario eliminado correctamente!", this, framep);
                err.setVisible(true);
            } else if (acc.equals("agregar")) {
                try {
                    conn.addUsrProc(args);

                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn.listar("USUARIO", table, "ID_USR");
                //conn.desconectar();
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Usuario agregado correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();

            } else if (acc.equals("editar")) {
                conn.editarUsr(args);
                conn.listar("USUARIO", table, "ID_USR");
                //conn.desconectar();
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Usuario editado correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();

            }
        } else if (nomtabla.equals("flujo")) {
            if (acc.equals("agregar")) {
                try {
                    conn.addFlujoProc(args);

                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn.listar("FLUJO", table, "ID_FLUJO");
                //conn.desconectar();
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Flujo agregado correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();
            } else if (acc.equals("editar")) {
                conn.editarFlujo(args);
                conn.listar("FLUJO", table, "ID_FLUJO");
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Flujo editado correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();
            }else if (acc.equals("eliminar")) {
                try {
                    conn.eliminarflujo(idRow);
                    conn.listar("FLUJO", table, "ID_FLUJO");
                    //conn.desconectar();
                    /*ConfirmarAccion conf = new ConfirmarAccion();
                        conf.setVisible(true);*/
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                framep.setEnabled(true);
                framep.setFocusable(true);
                dispose();
                Error err = new Error("Usuario eliminado correctamente!", this, framep);
                err.setVisible(true);
            }

        }else if(nomtabla.equals("unidad")){
            if (acc.equals("agregar")) {
                try {
                    conn.addUnidad(args);

                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn.listar("UNIDAD_INTERNA", table, "ID_UNIDAD");
                //conn.desconectar();
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Unidad agregada correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();
            } else if (acc.equals("editar")) {
                conn.editarUnidad(args);
                conn.listar("UNIDAD_INTERNA", table, "ID_UNIDAD");
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Unidad editada correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();
            }else if (acc.equals("eliminar")) {
                try {
                    conn.eliminarUnidad(String.valueOf(idRow));
                    conn.listar("UNIDAD_INTERNA", table, "ID_UNIDAD");
                    //conn.desconectar();
                    /*ConfirmarAccion conf = new ConfirmarAccion();
                        conf.setVisible(true);*/
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                framep.setEnabled(true);
                framep.setFocusable(true);
                dispose();
                Error err = new Error("Unidad eliminada correctamente!", this, framep);
                err.setVisible(true);
            }
            
        }else if(nomtabla.equals("rol")){
            if (acc.equals("agregar")) {
                try {
                    conn.addRol(args);

                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

                conn.listar("TAREA_ROL", table, "ID_TR");
                //conn.desconectar();
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Rol agregado correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();
            } else if (acc.equals("editar")) {
                conn.editarRol(args);
                conn.listar("TAREA_ROL", table, "ID_TR");
                framep.setEnabled(true);
                //framepp.setEnabled(true);
                Error err = new Error("Rol editado correctamente!", this, framepp);
                err.setVisible(true);
                framep.dispose();
                dispose();
            }else if (acc.equals("eliminar")) {
                try {
                    conn.eliminarRol(String.valueOf(idRow));
                    conn.listar("TAREA_ROL", table, "ID_TR");
                    //conn.desconectar();
                    /*ConfirmarAccion conf = new ConfirmarAccion();
                        conf.setVisible(true);*/
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                framep.setEnabled(true);
                framep.setFocusable(true);
                dispose();
                Error err = new Error("Rol eliminado correctamente!", this, framep);
                err.setVisible(true);
            }
            
        }
        else if (acc.equals("cerrar") && nomtabla.isEmpty()) {
            Login log = new Login();
            framep.dispose();
            dispose();
            log.setVisible(true);

        }else if (acc.equals("pdf")) {
            
            dispose();
            try {
                framep.setEnabled(true);
                framep.setFocusable(true);
                File path = new File(nomtabla);
                Desktop.getDesktop().open(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


    }//GEN-LAST:event_lblconfirmarMouseClicked

    private void supMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_supMousePressed

    private void supMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_supMouseDragged

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
            java.util.logging.Logger.getLogger(ConfirmarAccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmarAccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmarAccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmarAccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmarAccion(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mensaje;
    private javax.swing.JLabel borde;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblcancelar;
    private javax.swing.JLabel lblconfirmar;
    private javax.swing.JPanel pnlcancelar;
    private javax.swing.JPanel pnlconfirmar;
    private javax.swing.JPanel sup;
    // End of variables declaration//GEN-END:variables

    private int isEmpty(Object args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
