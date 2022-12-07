/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * ;
 * /**
 *
 * @author alvar
 */
public class MetodosFront {

    /*
    clase para moldear los bordes de forma redonda a un componente
     */
    static class RoundedBorder implements Border {

        private int radius;
        private Color color;
        private Boolean rell;
        private Color colorfill;

        RoundedBorder(int radius, Color color, Boolean rell, Color colorfill) {
            this.radius = radius;
            this.color = color;
            this.rell = rell;
            this.colorfill = colorfill;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius + 2);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(color);
            if (rell.equals(true)) {
                g.setColor(colorfill);
                g.fillRoundRect(x, y, width, height, radius, radius);
                g.setColor(color);
                g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);

        }
    }

    /*funcion para poner una imagen en un label y que se adecue a las dimensiones del label
    datos: JLabel, path o ruta de la imagen, frame
     */
    public static void SetImageLabel(JLabel labelname, String root, JFrame frame) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelname.getWidth(), labelname.getHeight(), Image.SCALE_DEFAULT));
        labelname.setIcon(icon);
        frame.repaint();
    }

    public static RoundedBorder setRoundedborder(int radius, Color color, Boolean rell, Color colorfill) {
        return new RoundedBorder(radius, color, rell, colorfill);
    }

    /*
    clase para dar formato y validar rut
     */
    public static class rut {

        private String dv;
        private Object[] array;

        public rut(String rut) {
            try {
                this.dv = rut.split("-")[1];
                this.array = rut.split("-")[0].split("");
            } catch (Exception e) {

            }

        }

        public String getDv() {
            return dv;
        }

        public Object[] getArray() {
            return array;
        }

        public static Object[] invertir(Object[] array) {
            try {
                Object[] invertir_int = new Object[array.length];
                int maximo = array.length;

                for (int i = 0; i < array.length; i++) {
                    Object j = array[maximo - 1];
                    invertir_int[maximo - 1] = array[i];
                    maximo--;
                }
                return invertir_int;
            } catch (Exception e) {
                return null;
            }

        }

        public static String verificador(Object[] array) {
            try {
                int a = 2;
                int rutSumado;
                rutSumado = 0;
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt((String) array[i]) * a;
                    rutSumado += Integer.parseInt(String.valueOf(array[i]));
                    if (a == 7) {
                        a = 1;
                    }
                    a++;
                }
                int resto = rutSumado % 11;
                String Digito = String.valueOf(11 - resto);
                if (Digito.equals("11")) {
                    Digito = "0";
                }
                if (Digito.equals("10")) {
                    Digito = "K";
                }
                return Digito;
            } catch (Exception e) {
                return null;
            }

        }

        public static boolean validar(String Digito, String DigitoVerificado) {
            if (Digito.equals(DigitoVerificado)) {
                return true;
            } else {
                return false;
            }

        }
        /*funcion para validar que el rut sea correcto
        datos: rut en formato array, digito verificador       
        retorna: true si el rut es correcto o false en caso contrario
        */
        public static boolean validadorRut(Object[] array, String dv) {
            try {
                return validar(verificador(invertir(array)), dv.toUpperCase());
            } catch (Exception e) {
                return false;
            }

        }
    }
    /*funcion que calcula la edad del usuario nuevo
    datos:fecha de nacimiento, label
    retorna: true si es mayor que la regla estipulada o false si es es menor de la edad permitida  
    */
    public static boolean mayor15(JDateChooser datech, JLabel label) throws ParseException {
        try {
            Date fechanac = datech.getDate();
            Date fechahoy = new Date();
            SimpleDateFormat ff = new SimpleDateFormat("dd MMM yyyy");
            String fhoy = ff.format(fechahoy);
            String fnac = ff.format(fechanac);
            fechahoy = ff.parse(fhoy);
            fechanac = ff.parse(fnac);
            LocalDate fechainiciold = convertToLocalDateViaMilisecond(fechanac);
            LocalDate fechahoyld = convertToLocalDateViaMilisecond(fechahoy);
            Period periodo = Period.between(fechainiciold, fechahoyld);

            if (periodo.getYears() >= 15) {
                label.setForeground(Color.GREEN);
                label.setText("Correcto");
                return true;

            } else {
                label.setForeground(Color.RED);
                label.setText("Es menor de edad");
                return false;
            }
        } catch (Exception e) {
            label.setForeground(Color.RED);
            label.setText("Campo vacio");
            return false;
        }

    }
    /*
    funcion que verifica que los campos de usuario esten llenos
    datos: Componentes{nombre, apellido, rut, date, frame}
    retorna: true si todos los campos estan llenos, false si al menos 1 esta vacio
    */
    public static boolean addUsercamposLlenos(JTextField nombre, JTextField apellido, JTextField rut, JDateChooser date, JFrame F) {
        try {
            if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || rut.getText().isEmpty() || date.getDate().equals(null)) {

                return false;
            } else {

                return true;
            }
        } catch (Exception e) {

            return false;
        }

    }
    
    /*funcion que valida el formato del rut 
    datos: Textfield rut, booleano rutvalido, label, booleano repetido   
    retorna: true si el rut tiene el formato valido y no esta repetido, false si esta repetido o el formato del rut esta equivocado
    comentario: dependiendo del retorno cambia el color del label a verde si es true o rojo se false con su respectivo mensaje
    */
    public static boolean VerificadorRut(JTextField rut, boolean rutValido, JLabel label, boolean rep) {
        
        if (rutValido && rep) {
            rut.setBorder(setRoundedborder(0, Color.GREEN, false, null));
            rut.setForeground(Color.BLACK);
            label.setForeground(Color.GREEN);
            label.setText("Correcto");
            return true;
        } else {
            rut.setBorder(setRoundedborder(0, Color.RED, false, null));
            rut.setForeground(Color.RED);
            if (rep == false) {
                label.setForeground(Color.RED);
                label.setText("El rut ya existe");
            } else {
                label.setForeground(Color.RED);
                label.setText("Formato equivocado");
            }
            return false;
        }
    }
    /*funcion para validar el formato del nombre y el apellido
    datos: JtextField, JLabel
    retorna: true si los nombre y el apellido no tiene caracteres especiales, en caso contrario o que el nombre y apellido contenga mas de un espacio false  
    comentario: dependiendo del retorno cambia el color del label a verde si es true o rojo se false con su respectivo mensaje
    */
    public static boolean formatoNomApe(JTextField txt, JLabel lbl) {
        try {
            int txtchar;
            int inco = 0;
            int espacio = 0;
            boolean bool;

            for (int i = 0; i < txt.getText().length(); i++) {
                txtchar = txt.getText().charAt(i);

                if (txtchar >= 33 && txtchar <= 64
                        || txtchar >= 91 && txtchar <= 96
                        || txtchar >= 123 && txtchar <= 208
                        || txtchar >= 210 && txtchar <= 240
                        || txtchar >= 242 && txtchar <= 255
                        || txtchar >= 338 && txtchar <= 8482) {
                    inco++;

                }
                if (txtchar == 32) {
                    espacio++;
                }
            }
            if (inco > 0 || txt.getText().length() == 0 || espacio > 1) {

                txt.setForeground(Color.RED);
                lbl.setForeground(Color.RED);
                if (txt.getText().length() == 0) {
                    lbl.setText("Error! este campo esta vacio");
                } else {
                    lbl.setText("Error! caracteres especiales");
                }
                return false;
            } else {
                if (espacio <= 1) {
                    txt.setForeground(Color.BLACK);
                    lbl.setForeground(Color.GREEN);
                    lbl.setText("Correcto");

                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    /*funcion que valida que la contrasena sea segura al editar el usuario
    dato: contrasena, label, panel1(donde se almacena el jpassword) y panel2 (donde se almacena el mensaje de error de formato) 
    retorna: true si cumple el formato minimo, false en caso contrario
    */
    public static boolean esSegura(String texto, JLabel lbl, JPanel pnl, JPanel pnl2) {
        if ((texto.length() > 7 && texto.length() < 13)) {
            boolean mayuscula = false;
            boolean minuscula = false;
            boolean especial = false;
            boolean numero = false;
            String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
            char c;
            for (int i = 0; i < texto.length(); i++) {
                c = texto.charAt(i);
                String t = texto.substring(i, i);
                if (Character.isDigit(c)) {
                    numero = true;
                }
                if (Character.isUpperCase(c)) {
                    mayuscula = true;
                }
                if (Character.isLowerCase(c)) {
                    minuscula = true;
                }
                if (specialChars.contains(t)) {
                    especial = true;
                }
            }
            if (numero && mayuscula && minuscula && especial) {

                lbl.setForeground(Color.GREEN);
                lbl.setText("           Formato correcto");
                pnl2.setOpaque(false);
                return true;

            } else {
                lbl.setForeground(Color.RED);

                lbl.setText("""
                         minimo 1: numero, mayuscula, minuscula y caracter especial""");
                pnl2.setBackground(Color.red);
                pnl2.setOpaque(false);
                return false;
            }

        } else {

            lbl.setText("El largo minimo de contrasena es 8 y el maximo 12");
            lbl.setForeground(Color.RED);
            pnl2.setOpaque(false);
            return false;
        }
    }
    /*
    funcion que verifica que los campos de flujo esten llenos
    datos: Componentes{fehcainicio, fechacreacion,fecha termino, estado, progreso}
    retorna: true si todos los campos estan llenos, false si al menos 1 esta vacio
    */
    public static boolean flujolleno(Object[] campos) {
        try {
            JTextField descripcion = (JTextField) campos[0];
            JDateChooser fechaini = (JDateChooser) campos[1];
            JDateChooser fechacrea = (JDateChooser) campos[2];
            JDateChooser fechater = (JDateChooser) campos[3];
            Date fechainicial = fechaini.getDate();
            Date fechacreacion = fechacrea.getDate();
            Date fechatermino = fechater.getDate();
            SimpleDateFormat ff = new SimpleDateFormat("dd MMM yyyy");
            String fini = ff.format(fechainicial);
            String fcrea = ff.format(fechacreacion);
            String fter = ff.format(fechatermino);
            fechainicial = ff.parse(fini);
            fechacreacion = ff.parse(fcrea);
            fechatermino = ff.parse(fter);

            if (descripcion.getText().isEmpty() || fechaini.getDate().equals(null) || fechacrea.getDate().equals(null) || fechater.getDate().equals(null) || descripcion.getForeground().equals(new Color(204, 204, 204))) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {

            return false;
        }

    }
    /*funcion que convierte una fecha de tipo Date a LocalDate
    datos: fecha a convertir
    retorna: fecha transformada a tipo LocalDate
    */
    public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    /*
    funcion que verifica que los campos de fechas cumplan los requisitos minimos de fecha inicio y creacion no pueden ser despues de fecha termino,
    fechainicio no puede ser antes de la fecha creacion y la fecha de termino no puede ser antes de fecha creacion o inicio y la fecha de inicio no puede
    ser antes de fecha de creacion
    datos: Componentes{fechainicio, fechacreacion, fechatermino}
    retorna: true si todas las validaciones son correctas y false en caso contrario
    */
    public static boolean fechaok(Object[] campos) {
        try {
            JDateChooser fechaini = (JDateChooser) campos[1];
            JDateChooser fechacrea = (JDateChooser) campos[2];
            JDateChooser fechater = (JDateChooser) campos[3];
            Date fechainicio = fechaini.getDate();
            Date fechacreacion = fechacrea.getDate();
            Date fechatermino = fechater.getDate();

            SimpleDateFormat ff = new SimpleDateFormat("dd MMM yyyy");
            String fini = ff.format(fechainicio);
            String fcrea = ff.format(fechacreacion);
            String fter = ff.format(fechatermino);

            fechainicio = ff.parse(fini);
            fechacreacion = ff.parse(fcrea);
            fechatermino = ff.parse(fter);

            boolean iniciok = fechainicio.equals(fechacreacion) || fechainicio.equals(fechatermino) || fechainicio.after(fechacreacion) && fechainicio.before(fechatermino);
            boolean creacionok = fechacreacion.equals(fechainicio) || fechacreacion.equals(fechatermino) || fechacreacion.before(fechainicio) && fechacreacion.before(fechatermino);
            boolean terminok = fechatermino.equals(fechainicio) || fechatermino.equals(fechacreacion) || fechatermino.after(fechacreacion) && fechatermino.after(fechainicio);

            if (fechainicio.equals(null) || fechacreacion.equals(null) || fechatermino.equals(null)) {
                return false;
            } else {
                if (iniciok && creacionok && terminok) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

    }
    /*funcion que verifica que los combobox de la vista inicial no sean iguales 
    datos: combobox 1,2,3 y 4
    retorna: true si son todos distintos y false en caso de que al menos uno este repetido    
    */
    public static boolean cboxdistintos(String[] cbox) {
        String cbox1 = cbox[0];
        String cbox2 = cbox[1];
        String cbox3 = cbox[2];
        String cbox4 = cbox[3];

        if (!cbox1.equals(cbox2) && !cbox1.equals(cbox3) && !cbox1.equals(cbox4)
                && !cbox2.equals(cbox1) && !cbox2.equals(cbox3) && !cbox2.equals(cbox4)
                && !cbox2.equals(cbox1) && !cbox2.equals(cbox3) && !cbox2.equals(cbox4)
                && !cbox3.equals(cbox1) && !cbox3.equals(cbox2) && !cbox3.equals(cbox4)
                && !cbox4.equals(cbox1) && !cbox4.equals(cbox3) && !cbox4.equals(cbox2)) {
            return true;
        } else {
            return false;
        }

    }

}
