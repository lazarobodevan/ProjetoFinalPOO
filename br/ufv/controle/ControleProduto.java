/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;
import br.ufv.modelo.Produto;
import br.ufv.persistencia.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lázaro
 */
public class ControleProduto {
    ProdutoDAO produtoDAO;
    
    public ControleProduto(){
        produtoDAO = new ProdutoDAO();
    }
    
    public void cadastraProduto(String nome, double preco, String categoria, int codigo, int qtdEstoque){
        Produto p = new Produto(nome, preco, categoria, codigo, qtdEstoque);
        
        Produto pExistente = produtoDAO.pesquisaProdutoCod(codigo);
        if(pExistente != null){
            JOptionPane.showMessageDialog (null, "Produto já existente!");
        }else{
            produtoDAO.cadastraProduto(p);
            JOptionPane.showMessageDialog (null, "Produto cadastrado!");
        }
        
    }
    
    public ArrayList<String> listarProdutosCadastrados(){
        ArrayList<Produto> produtos = produtoDAO.listarProdutosCadastrados();
        ArrayList<String> produtosStr = new ArrayList<>();
        
        for(Produto p: produtos){
            produtosStr.add(produtos.toString());
        }
        return produtosStr;
    }
    
    public ArrayList<Produto> obterProdutosCadastrados(){
        return produtoDAO.listarProdutosCadastrados();
    }
}
