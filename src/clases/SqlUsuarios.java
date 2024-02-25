package clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Diego EC Roman */
public class SqlUsuarios extends Conexion {
    public boolean registrar(Rusuarios user) {
        PreparedStatement ps = null;
        Connection con = Conectar();
        String sql = "INSERT INTO usuarios (user, password, correo,id_tipo) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCorreo());
            ps.setInt(4, user.getId_tipo());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
