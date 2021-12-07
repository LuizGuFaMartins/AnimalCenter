
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Funcionario;


public class LoginDAO {
    
    public boolean readFuncionario(int id_fun, String senha_fun){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;   
        
        boolean retornoFunc = false;     
        
        try {           
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE id_fun = ? AND senha_fun = ?");
            stmt.setInt(1, id_fun);
            stmt.setString(2, senha_fun);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                retornoFunc = true;
            }
            
        } catch (SQLException ex) {             
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return retornoFunc;
    }
    
    public boolean readAdm(int id_adm, String senha_adm){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        
        boolean retornoAdm = false;      
        
        try {           
            stmt = con.prepareStatement("SELECT * FROM administrador WHERE id_adm = ? AND senha_adm = ?"); 
            stmt.setInt(1, id_adm);
            stmt.setString(2, senha_adm);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                retornoAdm = true;  
                /*JOptionPane.showMessageDialog(null, "Login");*/
            }
            
        } catch (SQLException ex) {              
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return retornoAdm;
    }
}
