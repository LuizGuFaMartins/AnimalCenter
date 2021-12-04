package model.dao;

import connection.ConnectionFactory;
/*import java.awt.List;*/
import java.util.List;
import model.bean.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    
    public void Create(Funcionario fun){        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (nome_fun, cpf_func, cargo_fun, senha_fun, Administrador_id_adm) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, fun.getNome_func());
            stmt.setString(2, fun.getCpf_func());
            stmt.setString(3, fun.getCargo_func());
            stmt.setString(4, fun.getSenha_func());
            stmt.setInt(5, fun.getId_adm());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void Update(Funcionario fun){        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome_fun = ?, cpf_func = ?, cargo_fun = ?, senha_fun = ? WHERE id_fun = ?");
            stmt.setString(1, fun.getNome_func());
            stmt.setString(2, fun.getCpf_func());
            stmt.setString(3, fun.getCargo_func());
            stmt.setString(4, fun.getSenha_func());
            stmt.setInt(5, fun.getId_func());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
       
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {           
            stmt = con.prepareStatement("SELECT * FROM funcionario"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario func = new Funcionario(); 
                
                func.setId_func(rs.getInt("id_fun"));
                func.setNome_func(rs.getString("nome_fun"));
                func.setCpf_func(rs.getString("cpf_func"));
                func.setCargo_func(rs.getString("cargo_fun"));
                func.setSenha_func(rs.getString("senha_fun"));
                func.setId_adm(rs.getInt("Administrador_id_adm"));
                
                funcionarios.add(func);
                
            }
        } catch (SQLException ex) {    
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
}
