/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;
import br.ufv.modelo.Produto;
/**
 *
 * @author igorl
 */
public class Jogo extends Produto {

    public Jogo(String nome, double preco, String categoria, int codigo, int qtdEstoque) {
        super(nome, preco, categoria, codigo, qtdEstoque);
    }
    
    private String categoria;
    private String descricao;
    
    
}
