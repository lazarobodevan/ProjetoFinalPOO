/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;

import br.ufv.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class ClienteDAO {
   private Connection conexao;
    
    public ClienteDAO(){
        conexao = new ConexaoMySQL().getConexaoMySQL();
    }
    
    public boolean cadastraCliente(Cliente c) throws ParseException{
        String sql =  "INSERT INTO cliente(idCliente, nome, cpf, dtNasc, telefone) VALUES(?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, String.valueOf(c.getCodigo()));
            stmt.setString(2, c.getNome());
            stmt.setString(3, String.valueOf(c.getCpf()));
            String dia = c.getDtNasc().substring(0,2);
            String mes = c.getDtNasc().substring(3,5);
            String ano = c.getDtNasc().substring(6);
            String dtNascBanco = ano+"-"+mes+"-"+dia;
            stmt.setString(4, dtNascBanco);
            stmt.setString(5, c.getTelefone());
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public Cliente pesquisaClienteCpf(String cpfParam){
        String sql = "SELECT idCliente, nome, cpf, date_format(dtNasc, '%d/%m/%Y') AS 'dtNasc', telefone FROM cliente WHERE cpf LIKE '"+cpfParam+"'";
        System.out.println(sql);
        PreparedStatement stmt;
        Cliente c = null;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null && rs.next()){
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dtNasc = rs.getString("dtNasc");
                String telefone = rs.getString("telefone");

                c = new Cliente(nome, cpf, dtNasc, id, telefone);
            }
            stmt.close();
            return c;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
          }
    }
    
    public ArrayList<Cliente> listarClientesCadastrados(){
        ArrayList<Cliente> clientes =  new ArrayList<>();
        String sql = "SELECT idCliente, nome, cpf, date_format(dtNasc, '%d/%m/%Y') AS 'dtNasc', telefone FROM cliente";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dtNasc = rs.getString("dtNasc");
                String telefone = rs.getString("telefone");

                Cliente c = new Cliente(nome, cpf, dtNasc, id, telefone);
                clientes.add(c);
            }
            stmt.close();
            return clientes;
            
        } catch (Exception e) {
            System.out.println(e);
            return clientes;
          }
    }
    
    public boolean atualizarCadastroCliente(Cliente c){
        String sql =  "UPDATE cliente SET nome = ?, cpf = ?, dtNasc = ?, telefone = ? WHERE idCliente = ?";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, String.valueOf(c.getCpf()));
            String dia = c.getDtNasc().substring(0,2);
            String mes = c.getDtNasc().substring(3,5);
            String ano = c.getDtNasc().substring(6);
            String dtNascBanco = ano+"-"+mes+"-"+dia;
            stmt.setString(3, String.valueOf(dtNascBanco));
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, String.valueOf(c.getCodigo()));
            
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
//    public Cliente filtrarClienteCpf(int cpfParam){
//        Cliente c = null;
//        try {
//            String sql = "SELECT * FROM cliente WHERE nome = "+cpfParam;
//            PreparedStatement stmt;
//            
//            stmt = conexao.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery(sql);
//            
//            int id = rs.getInt("idProduto");
//            String nome = rs.getString("nome");
//            int cpf = rs.getInt("cpf");
//            String dtNasc = rs.getString("dtNasc");
//            String telefone = rs.getString("telefone");
//
//            c = new Cliente(nome, id, nome, id, nome);
//            stmt.close();
//            return c;
//            
//        } catch (Exception e) {
//            System.out.println(e);
//          }
//        return c;
//    }
    
    public ArrayList filtrarClienteNome(String nomeParam){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT idCliente, nome, cpf, date_format(dtNasc, '%d/%m/%Y') AS 'dtNasc', telefone FROM cliente"
                    + " WHERE nome LIKE '%"+nomeParam+"%'";
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dtNasc = rs.getString("dtNasc");
                String telefone = rs.getString("telefone");

                Cliente c = new Cliente(nome, cpf, dtNasc, id, telefone);
                clientes.add(c);
            }
            stmt.close();
            return clientes;
            
            
        } catch (Exception e) {
            System.out.println(e);
          }
        return clientes;
    }
    
    public boolean deletarCliente(String cpfParam){
        String sql =  "DELETE FROM cliente WHERE cpf LIKE '"+cpfParam+"'";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
