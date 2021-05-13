/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;
import br.ufv.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lázaro
 */
public class ProdutoDAO {
    private Connection conexao;
    private ArrayList<Produto> produtos;    
    
    public ProdutoDAO(){
        conexao = new ConexaoMySQL().getConexaoMySQL();
        if(produtos == null){
            produtos = listarProdutosCadastradosSql();
        }
    }
    
    public boolean cadastraProduto(Produto p){
        String sql =  "INSERT INTO produto(idProduto, nome, preco, qtdEstoque, categoria) VALUES(?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, String.valueOf(p.getCodigo()));
            stmt.setString(2, p.getNome());
            stmt.setString(3, String.valueOf(p.getPreco()));
            stmt.setString(4, String.valueOf(p.getQtdEstoque()));
            stmt.setString(5, p.getCategoria());
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Produto pesquisaProdutoCod(int codigo){
        for(Produto p: produtos){
            if(p.getCodigo() == codigo)
                return p;
        }
        return null;
    }
    public Produto pesquisaProdutoCodSql(int codigo){
        String sql = "SELECT * FROM produto WHERE idProduto = "+codigo;
        System.out.println(sql);
        PreparedStatement stmt;
        Produto p = null;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null && rs.next()){
                int id = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int qtdEstoque = rs.getInt("qtdEstoque");
                String categoria = rs.getString("categoria");

                p = new Produto(nome, preco, categoria, codigo, qtdEstoque);
            }
            stmt.close();
            return p;
            
        } catch (Exception e) {
            System.out.println(e);
          }
        
        return null;
    }
    
    public ArrayList<Produto> listarProdutosCadastradosSql(){
        ArrayList<Produto> ps = new ArrayList<>();
        
        String sql = "SELECT * FROM produto";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int qtdEstoque = rs.getInt("qtdEstoque");
                String categoria = rs.getString("categoria");

                Produto p = new Produto(nome, preco, categoria, id, qtdEstoque);
                ps.add(p);
            }
            stmt.close();
            return ps;
            
        } catch (Exception e) {
            System.out.println(e);
          }
        return ps;
    }
    
    public boolean atualizarProduto(Produto p){
        String sql =  "UPDATE produto SET nome = ?, preco = ?, qtdEstoque = ?, categoria = ? WHERE idProduto = ?";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, String.valueOf(p.getPreco()));
            stmt.setString(3, String.valueOf(p.getQtdEstoque()));
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, String.valueOf(p.getCodigo()));
            produtos = listarProdutosCadastradosSql();

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Produto> filtrarNome(String nomeParam){
        ArrayList<Produto> ps = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM produto WHERE nome LIKE '"+nomeParam+"'";
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int qtdEstoque = rs.getInt("qtdEstoque");
                String categoria = rs.getString("categoria");

                Produto p = new Produto(nome, preco, categoria, id, qtdEstoque);
                ps.add(p);
            }
            stmt.close();
            return ps;
            
        } catch (Exception e) {
            System.out.println(e);
          }
        return ps;
    }
    
    public boolean deletarProduto(int codigo){
        String sql =  "DELETE FROM produto WHERE idProduto = "+codigo;
        
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
