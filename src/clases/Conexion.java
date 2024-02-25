package clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String bd = "usuarios";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    boolean est;

    public boolean isEst() {
        return est;
    }

    public Conexion() {
    }
    public Conexion(String bd) {
        this.bd = bd;
    }
    public Connection Conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Se logro conectar a base de datos " + bd);
            this.est = true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la base de datos " + bd);
            this.est = false;
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
