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
    
    public boolean cadastraProduto(String nome, double preco, String categoria, int codigo, int qtdEstoque){
        Produto p = new Produto(nome, preco, categoria, codigo, qtdEstoque);
        
        Produto pExistente = produtoDAO.pesquisaProdutoCod(codigo);
        if(pExistente != null){
            return false;
        }else{
            produtoDAO.cadastraProduto(p);
            return true;
        }
        
    }
    
    public ArrayList<Produto> listarProdutosCadastrados(){
        return produtoDAO.listarProdutosCadastradosSql();
    }
    
    
    public Produto pesquisaProdutoCod(int cod){
        if(cod < 0){
            System.err.println("Erro.");
            return null;
        }
        return produtoDAO.pesquisaProdutoCod(cod);
    }
    
    public boolean atualizarProduto(String nome, double preco, String categoria, int codigo, int qtdEstoque){
        Produto p = new Produto(nome, preco, categoria, codigo, qtdEstoque);
        if(pesquisaProdutoCod(codigo) == null)
            return false;
        produtoDAO.atualizarProduto(p);
        return true;
    }
    
    public ArrayList<Produto> filtrarNome(String nomeParam){
        return produtoDAO.filtrarNome(nomeParam);
    }
    
    public boolean deletarProduto(int codigo){
        return produtoDAO.deletarProduto(codigo);
    }
    
    public boolean isDisponivel(Produto p, int qtd){
        return produtoDAO.isDisponivel(p, qtd);
    }
    public void alteraEstoque(ArrayList<Produto> prods, ArrayList<Integer> qtds){
        produtoDAO.alteraEstoque(prods, qtds);
    }
    
}
