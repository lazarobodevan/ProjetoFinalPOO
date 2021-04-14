/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;
import br.ufv.modelo.Produto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lázaro
 */
public class ProdutoDAO {
    ArrayList<Produto> produtos;
    Scanner leitor;
    
    public ProdutoDAO(){
        produtos = new ArrayList<>();
        leitor = new Scanner(System.in);
    }
    
    public void cadastraProduto(Produto p){
        produtos.add(p);
        System.out.println("Produto inserido com sucesso!");
        System.out.println("Qtd produtos: "+produtos.size());
    }
    
    public Produto pesquisaProdutoCod(int codigo){
        for(Produto p: produtos){
            if(p.getCodigo() == codigo){
                return p;
            }
        }
        return null;
    }
    
    public ArrayList<Produto> listarProdutosCadastrados(){
        return this.produtos;
    }
}
