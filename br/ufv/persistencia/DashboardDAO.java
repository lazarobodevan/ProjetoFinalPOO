/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class DashboardDAO {
    
    private static ArrayList<String> produtos;
    private static ArrayList<Integer> vendas;
    
    private static ArrayList<String> sexos;
    private static ArrayList<Integer>qtdSexo;
    
    private double valVenda;
    private double salFunc;
    private int qtdProdEst;
    private double valEst;
    private int qtdCli;
    private int qtdVendas;
    private int qtdProdVend; 
    private int qtdProdVendMesA;
    
    private ArrayList<String> datameses;
    private ArrayList<String> dataSemanas;
    private ArrayList<Integer> qtdProdVendSem;
    private ArrayList<Integer> qtdProdVendMes;
    private ArrayList<String> dataAnos;
    private ArrayList<Integer> qtdProdVendAno;
    
    private Connection conexao;
    public DashboardDAO(){
        conexao = new ConexaoMySQL().getConexaoMySQL();
        produtos = new ArrayList<>();
        vendas = new ArrayList<>();
        datameses = new ArrayList<>();
        dataSemanas = new ArrayList<>();
        qtdProdVendSem = new ArrayList<>();
        qtdProdVendMes = new ArrayList<>();
        dataAnos = new ArrayList<>();
        qtdProdVendAno = new ArrayList<>();
        
        sexos = new ArrayList<>();
        qtdSexo = new ArrayList<>();
        
        this.relacaoProdutoEQtdsVendidos();
        this.relacaoSexos();
        this.getInfoEmpresa();
    }
    
    public ArrayList<String> getNomeProdutos(){
        return produtos;
    }
    
    public ArrayList<Integer> getQtdVendasProd(){
        return vendas;
    }
    
    
    public ArrayList<String> getSexos(){
        return sexos;
    }
    
    public ArrayList<Integer> getQtdSexos(){
        return qtdSexo;
    }

    public double getValVenda() {
        return valVenda;
    }

    public double getSalFunc() {
        return salFunc;
    }

    public int getQtdProdEst() {
        return qtdProdEst;
    }

    public double getValEst() {
        return valEst;
    }

    public int getQtdCli() {
        return qtdCli;
    }

    public int getQtdVendas() {
        return qtdVendas;
    }

    public int getQtdProdVend() {
        return qtdProdVend;
    }

    public int getQtdProdVendMesA() {
        return qtdProdVendMesA;
    }

    public ArrayList<String> getDataSemanas() {
        return dataSemanas;
    }

    public ArrayList<String> getDataMeses() {
        return datameses;
    }
    
    public ArrayList<Integer> getQtdProdVendSem(){
        return qtdProdVendSem;
    }

    public ArrayList<Integer> getQtdProdVendMes() {
        return qtdProdVendMes;
    }

    public ArrayList<String> getDataAnos() {
        return dataAnos;
    }

    public ArrayList<Integer> getQtdProdVendAno() {
        return qtdProdVendAno;
    }
    
    
    
    public void relacaoProdutoEQtdsVendidos(){
        String sql = "SELECT produto.nome, IFNULL(SUM(qtd_produto), 0) AS 'qtd' FROM produto LEFT JOIN produto_has_venda ON produto.idProduto = produto_has_venda.idProduto\n" +
"GROUP BY produto.nome\n" +
"ORDER BY qtd desc LIMIT 10";
        PreparedStatement stmt;
        ResultSet rs;
        try{
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                produtos.add(rs.getString("nome"));
                vendas.add(rs.getInt("qtd"));
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void relacaoSexos(){
        String sql = "SELECT sexo, count(sexo) AS 'qtd' from cliente group by sexo";
        PreparedStatement stmt;
        ResultSet rs;
        try{
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                sexos.add(rs.getString("sexo"));
                qtdSexo.add(rs.getInt("qtd"));
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void getInfoEmpresa(){
        String sqlValVenda = "SELECT SUM(precoTotal) AS 'valVenda' from Venda WHERE MONTH(CURRENT_TIMESTAMP) = MONTH(data)";
        String sqlSalFunc = "SELECT SUM(salario) AS 'salFunc' from funcionario";
        String sqlProdEst = "SELECT SUM(qtdEstoque) AS 'prodEst' from produto" ;
        String sqlValEst = "SELECT SUM(preco*0.85*qtdEstoque) AS 'valEst' FROM produto";
        String sqlQtdCli = "SELECT COUNT(*) AS 'qtdCli' from Cliente";
        String sqlQtdVendas = "SELECT COUNT(*) AS 'qtdVendas' from venda";
        String sqlQtdProdVend = "SELECT SUM(qtd_produto) AS 'qtdProdVend' FROM Venda NATURAL JOIN produto_has_venda";
        String sqlQtdProdVendMesA = "SELECT IFNULL(SUM(qtd_produto),0) AS 'qtdProdVendMesA' FROM Venda NATURAL JOIN produto_has_venda\n" +
"WHERE YEAR(data) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
"AND MONTH(data) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)";
        String sqlGetDataSemanas = "SELECT DISTINCT date_format(data, \"%d/%m/%y\") AS data, SUM(qtd_produto) AS qtd from Venda NATURAL JOIN produto_has_venda\n" +
"WHERE YEAR(data) = YEAR(CURRENT_DATE - INTERVAL 1 WEEK)\n" +
"AND MONTH(data) = MONTH(CURRENT_DATE - INTERVAL 1 WEEK)\n" +
"GROUP BY Venda.data;";
        String sqlGetDataMeses = "SELECT DISTINCT date_format(data, \"%m/%y\") AS data, SUM(qtd_produto) AS qtd from Venda NATURAL JOIN produto_has_venda\n" +
"WHERE YEAR(data) = YEAR(CURRENT_DATE + INTERVAL 1 MONTH) OR YEAR(CURRENT_DATE)\n" +
"AND MONTH(data) = MONTH(CURRENT_DATE + INTERVAL 1 MONTH) OR MONTH(CURRENT_DATE)\n" +
"GROUP BY MONTH(Venda.data)";
        String sqlGetDataAnos = "SELECT DISTINCT date_format(data, \"%y\") AS data, SUM(qtd_produto) AS qtd from Venda NATURAL JOIN produto_has_venda\n" +
"WHERE YEAR(data) = YEAR(CURRENT_DATE - INTERVAL 1 YEAR) OR YEAR(CURRENT_DATE)\n" +
"AND MONTH(data) = MONTH(CURRENT_DATE - INTERVAL 1 YEAR) OR MONTH(CURRENT_DATE)\n" +
"GROUP BY YEAR(Venda.data)";
        
        
        PreparedStatement stmt;
        ResultSet rs;
        try{
            stmt = conexao.prepareStatement(sqlValVenda);
            rs = stmt.executeQuery(sqlValVenda);
            rs.next();
            valVenda = rs.getDouble("valVenda");
            rs.next();
            rs.close();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlSalFunc);
            rs = stmt.executeQuery(sqlSalFunc);
            rs.next();
            salFunc = rs.getDouble("salFunc");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlProdEst);
            rs = stmt.executeQuery(sqlProdEst);
            rs.next();
            qtdProdEst = rs.getInt("prodEst");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlValEst);
            rs = stmt.executeQuery(sqlValEst);
            rs.next();
            valEst = rs.getDouble("valEst");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlQtdCli);
            rs = stmt.executeQuery(sqlQtdCli);
            rs.next();
            qtdCli = rs.getInt("qtdCli");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlQtdVendas);
            rs = stmt.executeQuery(sqlQtdVendas);
            rs.next();
            qtdVendas = rs.getInt("qtdVendas");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlQtdProdVend);
            rs = stmt.executeQuery(sqlQtdProdVend);
            rs.next();
            qtdProdVend = rs.getInt("qtdProdVend");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlQtdProdVendMesA);
            rs = stmt.executeQuery(sqlQtdProdVendMesA);
            rs.next();
            qtdProdVendMesA = rs.getInt("qtdProdVendMesA");
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlGetDataSemanas);
            rs = stmt.executeQuery(sqlGetDataSemanas);
            while(rs.next()){
                dataSemanas.add(rs.getString("data"));
                qtdProdVendSem.add(rs.getInt("qtd"));
            }
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlGetDataMeses);
            rs = stmt.executeQuery(sqlGetDataMeses);
            while(rs.next()){
                datameses.add(rs.getString("data"));
                qtdProdVendMes.add(rs.getInt("qtd"));
            }
            rs.next();
            stmt.close();
            
            stmt = conexao.prepareStatement(sqlGetDataAnos);
            rs = stmt.executeQuery(sqlGetDataAnos);
            while(rs.next()){
                dataAnos.add(rs.getString("data"));
                qtdProdVendAno.add(rs.getInt("qtd"));
            }
            rs.next();
            stmt.close();
           
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
