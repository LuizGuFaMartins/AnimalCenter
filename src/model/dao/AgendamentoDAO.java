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
import model.bean.Agendamento;

public class AgendamentoDAO {
    public void Create(Agendamento fun){        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO agendamento (Animal_id_ani, servico_age, data_age, Funcionario_id_fun) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, fun.getId_animal());
            stmt.setString(2, fun.getServico_age());
            stmt.setString(3, fun.getData_age());
            stmt.setInt(4, fun.getId_func_age());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        } 
    }
    
    public void Update(Agendamento fun){        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE agendamento SET servico_age = ?, data_age = ? WHERE id_age = ?");
            stmt.setString(1, fun.getServico_age());
            stmt.setString(2, fun.getData_age());
            stmt.setInt(3, fun.getId_age());          
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
       
        List<Agendamento> funcionarios = new ArrayList<>();
        
        try {           
            stmt = con.prepareStatement("SELECT * FROM agendamento"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Agendamento func = new Agendamento(); 
                
                func.setId_age(rs.getInt("id_age"));
                func.setId_animal(rs.getInt("Animal_id_ani"));
                func.setServico_age(rs.getString("servico_age"));
                func.setData_age(rs.getString("data_age"));
                func.setId_func_age(rs.getInt("Funcionario_id_fun"));                
                
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
    
    
    public List readID(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
       
        List<Agendamento> funcionarios = new ArrayList<>();
        
        try {           
            stmt = con.prepareStatement("SELECT * FROM agendamento WHERE id_age = ?"); 
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Agendamento func = new Agendamento(); 
                
                func.setId_age(rs.getInt("id_age"));
                func.setId_animal(rs.getInt("Animal_id_ani"));
                func.setServico_age(rs.getString("servico_age"));
                func.setData_age(rs.getString("data_age"));
                func.setId_func_age(rs.getInt("Funcionario_id_fun"));  
                
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
    public List readData(String data){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
       
        List<Agendamento> funcionarios = new ArrayList<>();
        
        try {           
            stmt = con.prepareStatement("SELECT * FROM agendamento WHERE data_age = ?"); 
            stmt.setString(1, data);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Agendamento func = new Agendamento(); 
                
                func.setId_age(rs.getInt("id_age"));
                func.setId_animal(rs.getInt("Animal_id_ani"));
                func.setServico_age(rs.getString("servico_age"));
                func.setData_age(rs.getString("data_age"));
                func.setId_func_age(rs.getInt("Funcionario_id_fun"));  
                
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
    
    public void delete(Agendamento fun){        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM agendamento WHERE id_age = ?");
            stmt.setInt(1, fun.getId_age());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
