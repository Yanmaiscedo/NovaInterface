/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.repository;

import interfacegrafica3.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author yanma
 */
public class JuridicaRepository implements Crud<Fornecedor> {
    
    public JuridicaRepository(){
        //this.pessoa = pessoa;
    }
    
    public Fornecedor selecionar(int id){
        return null;
    } 

    @Override
    public boolean inserir(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try{
        String comando = "INSERT INTO fornecedor (nome, endereco, email, telefone, cnpj, inscricao_estadual, nome_fantasia, "
                + "categoria, sigla) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getCnpj());
            stmt.setString(6, fornecedor.getInscricaoEstadual());
            stmt.setString(7, fornecedor.getNomeFantasia());
            stmt.setString(8, fornecedor.getCategoria());
            stmt.setString(9, fornecedor.getUf());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir Fornecedor: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE fornecedor SET " +
                             "nome = ?, telefone = ?, email = ?, endereco = ?, sigla = ?, nome_fantasia = ?, cnpj = ?, inscricaoEstadual = ?, categoria = ? " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setString(5, fornecedor.getUf());
            stmt.setString(6, fornecedor.getNomeFantasia());
            stmt.setString(7, fornecedor.getCnpj());
            stmt.setString(8, fornecedor.getInscricaoEstadual());
            stmt.setString(9, fornecedor.getCategoria());
            stmt.setInt(10, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar Fornecedor: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }      
    }

    @Override
    public boolean deletar(Connection connection, Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try{
            String comando = "DELETE FROM fornecedor " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir Fornecedor: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public Fornecedor selecionar(Connection connection, String operador, int id) {
        try{
            Fornecedor fornecedor = new Fornecedor();
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM fornecedor WHERE id " + 
                             operador + " ? ";
            if(operador.equals("<"))
                comando += " ORDER BY id DESC";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res != null){
                while(res.next()){
                    fornecedor.setId(Integer.parseInt(res.getString("id") ));
                    fornecedor.setNome(res.getString("nome"));
                    fornecedor.setTelefone(res.getString("telefone"));
                    fornecedor.setEmail(res.getString("email")); 
                    fornecedor.setEndereco(res.getString("endereco"));
                    fornecedor.setUf(res.getString("sigla"));
                    fornecedor.setNomeFantasia(res.getString("nome_fantasia")); 
                    fornecedor.setCnpj(res.getString("cnpj"));
                    fornecedor.setInscricaoEstadual(res.getString("inscricao_estadual"));
                    fornecedor.setCategoria(res.getString("categoria")); 
                    break;
                }
            }
            return fornecedor;
        }catch(Exception ex){
             
            return null;
        }
    }
    
}
