package model.dao;

import java.sql.*;
import connection.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Administrador;

public class AdministradorDAO {
    public void create(Administrador adm) throws ClassNotFoundException, SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {            
            stmt = con.prepareStatement("INSERT INTO administrador (nome_adm, cpf_adm, senha_adm) VALUES (Luiz, 44455599987, 121314)");
            stmt.setString(1, adm.getNome_adm());
            stmt.setString(2, adm.getCpf_adm());
            stmt.setString(3, adm.getSenha_adm());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}

/*import com.sun.jdi.connect.spi.Connection;*/