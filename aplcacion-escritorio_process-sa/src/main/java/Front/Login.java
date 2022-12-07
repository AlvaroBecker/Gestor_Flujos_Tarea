/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Front;

import java.awt.Color;
import Metodos.MetodosBD;
import Metodos.MetodosBD.ConexionOracle;
import Metodos.MetodosFront;
import java.awt.event.KeyEvent;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

/**
 *
 * @author Alvaro Becker
 */
public class Login extends javax.swing.JFrame {

    ConexionOracle conn;
    int xMouse, yMouse;
    Color color_fondo = new Color(0, 76, 92);
    Color letras = new Color(204, 204, 204);
    String pass;

    class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        setShape(forma);
        setLocationRelativeTo(null);
        contrasena.setBorder(new RoundedBorder(12));
        lblnombreusuario.setBorder(new RoundedBorder(12));
        MetodosFront.SetImageLabel(Fondo, "src/main/resources/Images/Login.png", this);
        conn = new ConexionOracle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraSuperior = new javax.swing.JLabel();
        Xpnl = new javax.swing.JPanel();
        Xbtn = new javax.swing.JLabel();
        lblnombreusuario = new javax.swing.JTextField();
        contrasena = new javax.swing.JPasswordField();
        LoginBTN = new javax.swing.JLabel();
        Usuariolbl = new javax.swing.JLabel();
        contrasenalbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(3, 3, 3, 3));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraSuperiorMouseDragged(evt);
            }
        });
        BarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraSuperiorMousePressed(evt);
            }
        });
        getContentPane().add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 30));

        Xpnl.setBackground(new java.awt.Color(255, 255, 255));
        Xpnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Xpnl.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        Xpnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XpnlMouseClicked(evt);
            }
        });

        Xbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        Xbtn.setForeground(new java.awt.Color(117, 170, 250));
        Xbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Xbtn.setLabelFor(Xbtn);
        Xbtn.setText("X");
        Xbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout XpnlLayout = new javax.swing.GroupLayout(Xpnl);
        Xpnl.setLayout(XpnlLayout);
        XpnlLayout.setHorizontalGroup(
            XpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Xbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        XpnlLayout.setVerticalGroup(
            XpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Xbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(Xpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(848, 0, 30, 30));

        lblnombreusuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnombreusuario.setForeground(new java.awt.Color(204, 204, 204));
        lblnombreusuario.setText("INGRESE USUARIO");
        lblnombreusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblnombreusuarioFocusGained(evt);
            }
        });
        lblnombreusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombreusuarioActionPerformed(evt);
            }
        });
        lblnombreusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblnombreusuarioKeyPressed(evt);
            }
        });
        getContentPane().add(lblnombreusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 250, 50));

        contrasena.setText("******");
        contrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                contrasenaFocusGained(evt);
            }
        });
        contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaActionPerformed(evt);
            }
        });
        contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contrasenaKeyPressed(evt);
            }
        });
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 250, 50));

        LoginBTN.setBorder(LoginBTN.getBorder());
        LoginBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBTNMouseClicked(evt);
            }
        });
        getContentPane().add(LoginBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 230, 70));

        Usuariolbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Usuariolbl.setText("Usuario:");
        getContentPane().add(Usuariolbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 136, 140, 40));

        contrasenalbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        contrasenalbl.setText("Password:");
        getContentPane().add(contrasenalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 256, 130, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenid@");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 190, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Process S.A.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 255, 280, 130));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login.PNG"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBTNMouseClicked
        //String[] credenciales = {lblnombreusuario.getText(), pass.valueOf(contrasena.getPassword())};

        Boolean encontrado = conn.iniciarSesion(lblnombreusuario.getText(), pass.valueOf(contrasena.getPassword()));
        
        String usuariocon = conn.usrConn(lblnombreusuario.getText());
        if (encontrado) {

            String nombrecompleto = conn.getNombreFull(lblnombreusuario.getText());
            Admin admin = new Admin(nombrecompleto, usuariocon,conn);
            admin.setVisible(true);
            
            dispose();

        } else {
            Error err = new Error("Usuario o Contrasena incorrectos", this, this);
            err.setVisible(true);
            System.out.println("no se puede iniciar sesion");
        }

        

    }//GEN-LAST:event_LoginBTNMouseClicked

    private void XpnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XpnlMouseClicked

    }//GEN-LAST:event_XpnlMouseClicked

    private void lblnombreusuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblnombreusuarioFocusGained
        if (lblnombreusuario.getText().equals("INGRESE USUARIO")) {
            lblnombreusuario.setText("");
            lblnombreusuario.setForeground(color_fondo);

        }
        if (String.valueOf(contrasena.getPassword()).isEmpty()) {
            contrasena.setText("******");
            contrasena.setForeground(Color.gray);
        }
    }//GEN-LAST:event_lblnombreusuarioFocusGained

    private void lblnombreusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombreusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombreusuarioActionPerformed

    private void contrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contrasenaFocusGained
        if (String.valueOf(contrasena.getPassword()).equals("******")) {
            contrasena.setText("");
            contrasena.setForeground(color_fondo);

        }
        if (lblnombreusuario.getText().isEmpty()) {
            lblnombreusuario.setText("INGRESE USUARIO");
            lblnombreusuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_contrasenaFocusGained

    private void contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaActionPerformed

    private void lblnombreusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblnombreusuarioKeyPressed

        int i = 0;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            i = evt.getKeyCode();
        }
        if (i == KeyEvent.VK_ENTER) {
            Boolean encontrado = conn.iniciarSesion(lblnombreusuario.getText(), pass.valueOf(contrasena.getPassword()));
            
            String usuariocon = conn.usrConn(lblnombreusuario.getText());
            if (encontrado) {

                String nombrecompleto = conn.getNombreFull(lblnombreusuario.getText());
                Admin admin = new Admin(nombrecompleto,usuariocon,conn);
                admin.setVisible(true);
                
                dispose();

            } else {
                Error err = new Error("Usuario o Contrasena incorrectos", this, this);
                err.setVisible(true);
                System.out.println("no se puede iniciar sesion");
            }

        }


    }//GEN-LAST:event_lblnombreusuarioKeyPressed

    private void contrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contrasenaKeyPressed
        //String[] credenciales = {lblnombreusuario.getText(), pass.valueOf(contrasena.getPassword())};

        int i = 0;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            i = evt.getKeyCode();
        }
        if (i == KeyEvent.VK_ENTER) {
            Boolean encontrado = conn.iniciarSesion(lblnombreusuario.getText(), pass.valueOf(contrasena.getPassword()));
            
            String usuariocon=conn.usrConn(lblnombreusuario.getText());
            if (encontrado) {

                String nombrecompleto = conn.getNombreFull(lblnombreusuario.getText());
                Admin admin = new Admin(nombrecompleto,usuariocon,conn);
                admin.setVisible(true);
                
                dispose();

            } else {
                Error err = new Error("Usuario o Contrasena incorrectos", this, this);
                err.setVisible(true);
                System.out.println("no se puede iniciar sesion");
            }

        }
    }//GEN-LAST:event_contrasenaKeyPressed

    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BarraSuperiorMousePressed

    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    private void XbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbtnMouseClicked
        conn.desconectar();
        dispose();
    }//GEN-LAST:event_XbtnMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarraSuperior;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LoginBTN;
    private javax.swing.JLabel Usuariolbl;
    private javax.swing.JLabel Xbtn;
    private javax.swing.JPanel Xpnl;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JLabel contrasenalbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField lblnombreusuario;
    // End of variables declaration//GEN-END:variables
}
