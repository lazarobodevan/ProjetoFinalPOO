/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;

import br.ufv.controle.ControleCliente;
import br.ufv.controle.ControleFuncionario;
import br.ufv.modelo.Cliente;
import br.ufv.modelo.Funcionario;
import br.ufv.modelo.Produto;
import br.ufv.modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igorl
 */
public class VendaDAO {
    private static ArrayList<Venda> vendas;
    private static ArrayList<Produto> produtosVenda;
    private static ArrayList<Integer> quantidadesProds;
    private Connection conexao;
    
    public VendaDAO(){
        produtosVenda = new ArrayList<>();
        quantidadesProds = new ArrayList<>();
        conexao = new ConexaoMySQL().getConexaoMySQL();
        vendas = getVendasCadastradasSql();
    }
    
    public void setProdutosVenda(ArrayList<Produto> produtos){
        produtosVenda = produtos;
    }
    
    public void setQtdsProdutosVenda(ArrayList<Integer> qtds){
        quantidadesProds = qtds;
    }
    
    public int getIdVenda(){
        try{
        String sql = "SELECT MAX(idVenda)+1 AS 'idVenda' from venda";
        PreparedStatement stmt;
        stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        int id = rs.getInt("idVenda");
        stmt.close();
        return id;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
    public ArrayList<Produto> getProdutosVenda(){
        return produtosVenda;
    }
    
    public boolean cadastraVendaSql(Venda v){
        if(v == null)
            System.out.println("porraaaaaa");
        vendas.add(v);
        String sqlVenda =  "INSERT INTO venda(idVenda, precoTotal, data, idCliente, idFuncionario) VALUES(?,?,?,?,?)";
        String sqlProdutoHasVenda = "INSERT INTO produto_has_venda(idProduto, idVenda, preco_na_compra, qtd_produto) VALUES(?,?,?,?)";
        PreparedStatement stmtV, stmtPV;
        try {
            stmtV = conexao.prepareStatement(sqlVenda);
            stmtV.setString(1, String.valueOf(v.getCodigo()));
            stmtV.setString(2, String.valueOf(v.getPrecoTotal()));
            stmtV.setString(3, String.valueOf(v.getData()));
            stmtV.setString(4, String.valueOf(v.getCliente().getCodigo()));
            stmtV.setString(5, String.valueOf(v.getFuncionario().getCodigo()));
            stmtV.execute();
            stmtV.close();
            
            stmtPV = conexao.prepareStatement(sqlProdutoHasVenda);
            int i = 0;
            for(Produto p: v.getProdutos()){
                stmtPV.setString(1, String.valueOf(p.getCodigo()));
                stmtPV.setString(2, String.valueOf(v.getCodigo()));
                stmtPV.setString(3, String.valueOf(p.getPreco()));
                stmtPV.setString(4, String.valueOf(v.getQtds().get(i)));
                stmtPV.execute();
                i++;
            }
            stmtPV.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   
    }
    
    public ArrayList<Venda> getVendasCadastradasSql(){
        ArrayList<Venda> vs = new ArrayList<>();
        String sql = "SELECT * FROM produto_has_venda NATURAL JOIN produto NATURAL JOIN venda";
        PreparedStatement stmt;
        PreparedStatement stmtjunc;
        ControleCliente controleCliente = new ControleCliente();
        ControleFuncionario controleFuncionario = new ControleFuncionario();
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while(rs.next()){
                int id = rs.getInt("idVenda");
                double precoTot = rs.getDouble("precoTotal");
                String data = sdf.format(rs.getDate("data"));
                int idCliente = rs.getInt("idCliente");
                int idFuncionario = rs.getInt("idFuncionario");
                
                while(rs.next()){
                    String nome = rs.getString("nome");
                    double precoVenda = rs.getDouble("preco_na_compra");
                    String categoria = rs.getString("categoria");
                    int codigo = rs.getInt("idProduto");
                    int qtdEstoque = rs.getInt("qtdEstoque");
                    int qtdsProds = rs.getInt("qtd_produto");
                    produtosVenda.add(new Produto(nome, precoVenda, categoria, codigo, qtdEstoque));
                    quantidadesProds.add(qtdsProds);
                }
                Cliente cliente = controleCliente.pesquisaClienteId(idCliente);
                Funcionario f = controleFuncionario.getFuncionarioId(idFuncionario);
                Venda v = new Venda(precoTot, id, cliente, produtosVenda, quantidadesProds, data, f);
                vs.add(v);
            }
            stmt.close();
            return vs;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
          }
    }
    
    public Venda pesquisaVendaCod(int codigo){
        for (Venda v: vendas){
            if(v.getCodigo() == codigo){
                return v;
            }
        }
        return null;
    }
    
    public ArrayList<Venda> getVendasCadastradas(){
        return vendas;
    }
}
