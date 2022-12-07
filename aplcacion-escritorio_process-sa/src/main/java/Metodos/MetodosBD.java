/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Front.Error;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author alvar
 */
public class MetodosBD {

    //Conectar a base de datos Oracle Cloud
    public static class ConexionOracle {
        
        private JLabel labelEliminar;//label eliminar para asignar a JTables
        private JLabel labelEditar;//label editar para asignar a JTables
        private Connection conn = null;
        private String url, user, pass;
        String atps_tls;
        String usuario;
        String contrasena;
        private JTable table;

        public ConexionOracle() {
            conectar();

        }

        private void conectar() {
            try {
                //Establecer Conexion a BD Oracle cloud
                Class.forName("oracle.jdbc.driver.OracleDriver");
                atps_tls = "(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.sa-santiago-1.oraclecloud.com))(connect_data=(service_name=g034caa6987331d_dbmain_high.adb.oraclecloud.com))(security=(ssl_server_cert_dn=\"CN=adb.sa-santiago-1.oraclecloud.com, O=Oracle Corporation, L=Redwood City, ST=California, C=US\")))";
                url = "jdbc:oracle:thin:@" + atps_tls;
                user = "ProcessDB";
                pass = "ProcessDatabase2022";

                Properties props = new Properties();
                props.setProperty("user", user);
                props.setProperty("password", pass);
                props.setProperty("oracle.jdbc.fanEnabled", "false");

                conn = DriverManager.getConnection(url, props);
                System.out.println("Conectado!");
            } catch (Exception e) {
                System.out.println("Error, no se pudo conectar");
            }
        }

        /*funcion de inicio de sesion
        valores entrada: Nombre de usuario, contrasena 
        return: true o false, dependiendo si se encuentran las credenciales 
         */
        public Boolean iniciarSesion(String usr, String pas) {
            System.out.println("Ejecutando inicio de sesion");
            usuario = usr;
            contrasena = pas;
            //Verificacion de Credenciales
            String query = "SELECT * FROM USUARIO where USERNAME='" + usuario + "'";
            int rol;
            Boolean encontrado = false;
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    if (rs.getString("USERNAME").equals(usuario) && rs.getString("PASSWORD").equals(contrasena)) {
                        //Verificacion de rol en el sistema
                        rol = rs.getInt("FK_ROL");
                        if (rol == 1) {
                            encontrado = true;

                        } else {
                            System.out.println("El usuario no tiene permisos para entrar en esta aplicacion, porfavor contacte con un administrador");
                            break;
                        }

                    }

                }

            } catch (SQLException e) {
                e.printStackTrace();

                System.out.println("usuario o contrasena incorrecta");

            }
            return encontrado;

        }

        /*Funcion que retorna la cantidad de tareas por unidad interna para asignar valores a graficos de barra y torta
        Valor de entrada: Nombre unidad interna 
        retorna: cantidad de elementos de la unidad*/
        public int contarTareas(String nombre_unidad) {
            int elemento = 0;
            String query = "select ui.NOMBRE_UNIDAD,count(*) cantidad from tarea join UNIDAD_INTERNA ui on fk_unidad=id_unidad where nombre_unidad='" + nombre_unidad + "' group by ui.NOMBRE_UNIDAD";
            try {
                Statement st = conn.createStatement();
                ResultSet rs1 = st.executeQuery(query);
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    elemento = rs.getInt(2);
                    return elemento;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return elemento;

        }

        /*funcion para obtener id de un combo box para hacer cambios en la bd
        datos entrada: tabla de la bd, jcombobox, nombre de la columna id en la bd, nombre de la columna para sentencia where
        retorna: id del nombre en la tabla de la sentencia where
         */
        public int transformador(String proc, JComboBox box, String id, String nombre) {
            int elemento = 1;
            String query = "SELECT " + id + " FROM " + proc + " where " + nombre + "='" + box.getSelectedItem() + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs1 = st.executeQuery(query);
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    elemento = rs.getInt(1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return elemento;
        }

        /*funcion para agregar nuevo usuario
        datos entrada: nombre_full, rut,username,password,fec_nac,genero,fk_rol,fk_unidad,fk_contrato       
         */
        public void addUsrProc(String[] args) throws SQLException {
            String query = "{call mantenedor_usuario.add_usr(?,?,?,?,?,?,?,?)}";
            try {
                CallableStatement cs = conn.prepareCall(query);
                for (int i = 0; i < args.length; i++) {
                    cs.setString(i + 1, args[i]);
                }

                ResultSet rs = cs.executeQuery();
                System.out.println("Se creo el nuevo usuario");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int obtenerRol_Unidad(String valor, String columna, String where, String bdtabla) {
            String query = "select " + columna + " from " + bdtabla + " where " + where + "='" + valor + "'";
            int id = 0;
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                id = rs.getInt(1);
                return id;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }

        /*funcion para editar usuario
        datos: id_usr,nombre_full, rut,username,password,fec_nac,genero,fk_rol,fk_unidad,fk_contrato        
         */
        public void editarUsr(String[] args) {
            String query = "{call mantenedor_usuario.upt_usr(?,?,?,?,?,?,?,?,?,?)}";
            try {
                System.out.println("Actualizando usuario");
                CallableStatement cs = conn.prepareCall(query);
                for (int i = 1; i < args.length - 3; i++) {
                    cs.setString(i + 1, args[i]);
                }
                cs.setInt(1, Integer.parseInt(args[0]));
                cs.setInt(8, Integer.parseInt(args[args.length - 3]));
                cs.setInt(9, Integer.parseInt(args[args.length - 2]));
                cs.setInt(10, Integer.parseInt(args[args.length - 1]));
                System.out.println("Ejecutando procedimiento");
                cs.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para eliminar usuario
        datos: id_usr
         */
        public void eliminar(int id) throws SQLException {
            String query = "{?=call mantenedor_usuario.del_usr(?)}";

            try {
                CallableStatement cs = conn.prepareCall(query);
                cs.registerOutParameter(1, Types.INTEGER);
                cs.setInt(2, id);
                cs.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /*funcion para rellenar combo box de formularios
        datos: nombre tabla, jcombobox
         */
        public void rellenarCbox(String proc, JComboBox box) {
            String query = "SELECT * FROM " + proc;
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                box.removeAllItems();
                while (rs.next()) {
                    box.addItem(rs.getString(2));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /*funcion para validar nuevo usuario por rut 
        datos: rut,jframe
        retorna: false si hay un rut, true si no existe el rut
        comentario: si hay un problema con la query mostrara un mensaje de error en pantalla
         */
        public boolean repetido(String rut, JFrame F) {
            String query = "select id_usr from Usuario where rut='" + rut + "'";
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int rowNumber = 0;
                while (rs.next()) {
                    rowNumber++;
                }

                if (rowNumber > 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e);
                Error err = new Error("Error! al obtener id", F, null);
                err.setVisible(true);
                return false;

            }

        }

        /*funcion para obtener id de usuario por rut se utiliza en conjunto con funciones editar y agregar
        datos: rut, jframe
        retorna: id_usr en formato String
        comentario: si hay un problema con la query mostrara un mensaje de error en pantalla
         */
        public String obtenerIDusuario(String rut, JFrame F) {
            String query = "select id_usr from Usuario where rut='" + rut + "'";
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                while (rs.next()) {
                    return rs.getString(1);
                }

            } catch (SQLException e) {
                Error err = new Error("Error! al obtener id", F, null);
                err.setVisible(true);

            }

            return null;
        }

        /*funcion para obtener el nombre completo del usuario para rellenar el nombre en el panel inicial 
        datos: username
        retorna: nombre completo
         */
        public String getNombreFull(String usr) {
            String query = "select nombre_full from Usuario where username='" + usr + "'";
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                    return rs.getString(1);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener el nombre completo para pantalla inicial");

            }

            return null;

        }

        /*funcion para validar usuario conectado para evitar eliminacion del usuario actual
        datos: username
        retorna: rut
        
         */
        public String usrConn(String usr) {
            String query = "select RUT from Usuario where username='" + usr + "'";
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;
                    return rs.getString(1);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener el nombre de usuario");
                System.out.println(e);

            }

            return "";

        }

        /*funcion para validar el nombre de usuario
        datos: username
        retorna: true si hay una coincidencia, false en caso contrario
         */
        public boolean usrRep(String usr) {
            String query = "select USERNAME from Usuario where username='" + usr + "'";
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;

                }
                if (row >= 1) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener el nombre de usuario");

            }

            return false;

        }

        /*funcion para obtener contrasena para rellenar formulario
        datos: rut, jframe
        retorna: password
        comentario: si hay problemas para obtener la contrasena se abre un mensaje de error en pantalla
         */
        public String obtenerPass(String rut, JFrame F) {
            String query = "select password from Usuario where rut='" + rut + "'";
            try {

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                while (rs.next()) {
                    return rs.getString(1);
                }

            } catch (SQLException e) {
                Error err = new Error("Error! al obtener la contrasena", F, null);
                err.setVisible(true);

            }

            return null;
        }

        /*funcion para listar contenido de tablas de la bd en jtables
        datos: nombre tabla en la bd, jtable,id columna
        comentario: la funcion crea sobre el jtable dos columnas para agregar labels que seran utilizados para acciones sobre la tabla (eliminar o editar fila)
         */
        public void listar(String bdtable, JTable apptable, String idcolumn) {

            JLabel labelEliminar = new JLabel();
            JLabel labelEditar = new JLabel();
            String query;
            labelEditar.setName("Editar");
            labelEliminar.setName("Eliminar");
            labelEliminar.setText("Eliminar");
            labelEliminar.setBorder(Metodos.MetodosFront.setRoundedborder(10, Color.BLACK, false, null));
            labelEditar.setText("Editar");
            labelEditar.setBorder(Metodos.MetodosFront.setRoundedborder(10, Color.BLACK, false, null));
            String bdtb = bdtable;
            table = apptable;
            table.setRowHeight(40);
            String id = idcolumn;
            //listar usuarios 
            if (bdtable.equals("USUARIO")) {
                query = """
                   select 
                   u.nombre_full as "NOMBRE",
                   u.rut as "RUT",
                   u.username as "USUARIO",
                   u.fec_nac as "FECHA NACIMIENTO",
                   u.genero as "GENERO",
                   r.nombre_rol as "ROL",
                   ui.nombre_unidad as "UNIDAD INTERNA"
                   from usuario u inner join unidad_interna ui on u.fk_unidad=ui.id_unidad inner join rol r on u.fk_rol=r.id_rol  
                   order by u.id_usr""";
                try {

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();
                    DefaultTableModel modelo = new DefaultTableModel();
                    table.setDefaultRenderer(Object.class, new RenderTabla());
                    for (int i = 0; i < columnsNumber; i++) {
                        modelo.addColumn(rsmd.getColumnName(i + 1));
                    }
                    modelo.addColumn("");
                    modelo.addColumn("");
                    table.setModel(modelo);
                    Object[] dato = new Object[modelo.getColumnCount()];
                    while (rs.next()) {
                        for (int j = 0; j < dato.length - 2; j++) {
                            dato[j] = rs.getString(rs.findColumn(rsmd.getColumnName(j + 1)));
                        }
                        dato[dato.length - 2] = labelEliminar;
                        dato[dato.length - 1] = labelEditar;

                        modelo.addRow(dato);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();

                    System.out.println("Error al construir tabla: " + e);

                }
            } else {
                //listar tablas de forma automatica
                query = "SELECT * FROM " + bdtb + " ORDER BY " + id;
                try {

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();
                    DefaultTableModel modelo = new DefaultTableModel();
                    table.setDefaultRenderer(Object.class, new RenderTabla());
                    for (int i = 1; i < columnsNumber; i++) {

                        modelo.addColumn(rsmd.getColumnName(i + 1));
                    }
                    modelo.addColumn("");
                    modelo.addColumn("");
                    table.setModel(modelo);
                    Object[] dato = new Object[modelo.getColumnCount()];
                    while (rs.next()) {

                        for (int j = 0; j < dato.length - 2; j++) {
                            dato[j] = rs.getString(rs.findColumn(rsmd.getColumnName(j + 2)));
                        }
                        dato[dato.length - 2] = labelEliminar;
                        dato[dato.length - 1] = labelEditar;

                        modelo.addRow(dato);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();

                    System.out.println("Error al construir tabla: " + e);

                }
            }

        }

        /*funcion para validar que la descripcion del flujo no este repetido
        datos: JTextField
        retorna: true si existe, false si no existe
         */
        public boolean descRep(JTextField desc) {

            try {
                String query = "select DESCRIPCION from FLUJO where descripcion='" + desc.getText() + "'";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;

                }
                if (row >= 1) {
                    return true;
                } else {

                    return false;
                }
            } catch (SQLException e) {

                System.out.println("Error al obtener la descripcion");
                return false;
            }
        }

        /*funcion para obtener el id del flujo a traves de su descripcion
        datos: descripcion
        retorna: id del flujo
         */
        public int obteneridFlujo(String desc) {

            try {
                String query = "select id_FLUJO from FLUJO where descripcion='" + desc + "'";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;
                    return rs.getInt(1);
                }

            } catch (SQLException e) {

                System.out.println("Error al obtener la descripcion");
                return 0;
            }

            return 0;

        }

        /*funcion para agreagr un nuevo flujo a la bd
        datos:  DESCRIPCION, FEC_CREACION,FEC_INI,FEC_TER,ESTADO,PROGRESO       
         */
        public void addFlujoProc(String[] args) throws SQLException {
            String query = "{call mantenedor_flujo.add_flujo(?,?,?,?,?,?)}";
            try {
                CallableStatement cs = conn.prepareCall(query);
                PreparedStatement ps = conn.prepareStatement(query);
                cs.setString(1, args[0]);
                cs.setString(2, args[1]);
                cs.setString(3, args[2]);
                cs.setString(4, args[3]);
                cs.setString(5, args[4]);
                cs.setString(6, args[5]);
                cs.execute();
                cs.close();
            } catch (Exception e) {
                System.out.println("no se pudo insertar");
            }
        }

        /*funcion para editar un flujo existente 
        datos: DESCRIPCION, FEC_CREACION,FEC_INI,FEC_TER,ESTADO,PROGRESO        
         */
        public void editarFlujo(String[] args) {
            String query = "{call mantenedor_flujo.upt_flujo(?,?,?,?,?,?,?)}";
            try {
                System.out.println("Actualizando Flujo");
                CallableStatement cs = conn.prepareCall(query);
                cs.setString(1, args[0]);
                cs.setString(2, args[1]);
                cs.setString(3, args[2]);
                cs.setString(4, args[3]);
                cs.setString(5, args[4]);
                cs.setString(6, args[5]);
                cs.setString(7, args[6]);

                System.out.println("Ejecutando procedimiento");
                cs.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para eliminar flujo
        datos:id_flujo
         */
        public void eliminarflujo(int id) throws SQLException {
            String query = "{?=call mantenedor_flujo.del_flujo(?)}";
            try {
                CallableStatement cs = conn.prepareCall(query);
                cs.registerOutParameter(1, Types.INTEGER);
                cs.setInt(2, id);
                cs.executeUpdate();
                int retorno = cs.getInt(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para obtener el id de la unidad interna
        datos: nombre_unidad
        retorna: id_unidad        
         */
        public int obteneridUnidad(String desc) {

            try {
                String query = "select id_unidad from UNIDAD_INTERNA where NOMBRE_UNIDAD='" + desc + "'";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;
                    return rs.getInt(1);
                }

            } catch (SQLException e) {

                System.out.println("Error al obtener la Unidad");
                return 0;
            }

            return 0;

        }

        /*funcion para validar que el nombre de la unidad no este repetida
        datos: jtextField
        retorna: true si existe o false en caso contrario
         */
        public boolean unidadRep(JTextField desc) {

            try {
                String query = "select NOMBRE_UNIDAD from UNIDAD_INTERNA where NOMBRE_UNIDAD='" + desc.getText() + "'";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;

                }
                if (row == 1) {
                    return true;
                } else {

                    return false;
                }
            } catch (SQLException e) {

                System.out.println("Error al obtener la descripcion");
                return false;
            }
        }

        /*funcion para agregar una nueva unidad a la bd
        datos: nombre_unidad
         */
        public void addUnidad(String[] args) throws SQLException {
            String query = "insert into UNIDAD_INTERNA (NOMBRE_UNIDAD) VALUES (?)";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, args[0]);

                ps.execute();
                System.out.println("Se creo la nueva unidad");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para editar una unidad interna
        datos: nombre_unidad nuevo, id unidad        
         */
        public void editarUnidad(String[] args) {
            String query = "UPDATE UNIDAD_INTERNA set NOMBRE_UNIDAD='" + args[0] + "' where id_unidad='" + args[1] + "'";
            try {
                Statement st = conn.createStatement();
                st.executeUpdate(query);

                System.out.println("Unidad editada correctamente");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para eliminar una unidad existente 
        datos: id_unidad        
         */
        public void eliminarUnidad(String id) throws SQLException {
            String query = "DELETE FROM UNIDAD_INTERNA where id_unidad='" + id + "'";

            try {
                PreparedStatement st = conn.prepareStatement(query);
                st.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /*funcion para obtener datos que se utilizaran para rellenar el grafico de torta
        datos:nombre_unidad
        retorna: lista de string con los datos de las unidades en formato diccionario (nombre_estado,cantidad)
         */
        public String[] obtenerdatosTorta(String unidad) {
            String query = "select te.nombre_estado,count(*) from tarea t join TAREA_ESTADO te on t.estado=te.id_estado join UNIDAD_INTERNA ui on t.FK_UNIDAD=ui.ID_UNIDAD where ui.NOMBRE_UNIDAD=('" + unidad + "') group by te.nombre_estado";

            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int j = 0;
                String[] estados = new String[6];
                while (rs.next()) {

                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        estados[j] = rs.getString(i + 1);
                        j++;
                    }

                }
                return estados;
            } catch (Exception e) {
                return null;
            }

        }

        /*funcion para agregar un nuevo rol de empresa
        datos: nombre_rol        
         */
        public void addRol(String[] args) throws SQLException {
            String query = "insert into tarea_rol (NOMBRE_ROL) VALUES (?)";
            //String query ="insert into FLUJO (DESCRIPCION, FEC_CREACION,FEC_INI,FEC_TER,ESTADO,PROGRESO) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, args[0]);

                ps.execute();
                System.out.println("Se creo el nuevo rol");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para editar el nombre de un rol existente
        datos: nombre_rol nuevo, id_rol        
         */
        public void editarRol(String[] args) {
            String query = "UPDATE TAREA_ROL set NOMBRE_ROL='" + args[0] + "' where id_tr='" + args[1] + "'";
            try {
                Statement st = conn.createStatement();
                st.executeUpdate(query);

                System.out.println("Rol editado correctamente");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*funcion para eliminar un rol existente 
        datos: id_rol        
         */
        public void eliminarRol(String id) throws SQLException {
            String query = "DELETE FROM TAREA_ROL where ID_TR='" + id + "'";

            try {
                PreparedStatement st = conn.prepareStatement(query);
                st.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /*funcion para obtener el id de un rol existente
        datos: nombre_rol
        retorna: id_rol        
         */
        public int obteneridRol(String nombrerol) {

            try {
                String query = "select id_tr from TAREA_ROL where NOMBRE_ROL='" + nombrerol + "'";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;
                    return rs.getInt(1);
                }

            } catch (SQLException e) {

                System.out.println("Error al obtener el id " + e);
                return 0;
            }

            return 0;

        }

        /*funcion para validar que un rol no este repetido
        datos: jtextfield
        retorna: true si hay coincidencias, false en caso contrario    
         */
        public boolean RolRep(JTextField desc) {

            try {
                String query = "select NOMBRE_ROL from TAREA_ROL where NOMBRE_ROL='" + desc.getText() + "'";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();

                int row = 0;
                while (rs.next()) {
                    row++;

                }
                if (row == 1) {
                    return true;
                } else {

                    return false;
                }
            } catch (SQLException e) {

                System.out.println("Error al obtener nombre del rol");
                return false;
            }
        }
        /*funcion para desconectarse de la bd
        
        */
        public void desconectar() {
            try {
                conn.close();
                System.out.println("Desconectado!");
            } catch (Exception e) {
                System.out.println("no se pudo desconectar");
            }

            /**
             *
             */
        }
    }
    /*clase para renderizar jtables para agregar labels de editar y eliminar
    */
    public static class RenderTabla extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JLabel) {
                JLabel label = (JLabel) value;
                return label;
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }

    }

}
