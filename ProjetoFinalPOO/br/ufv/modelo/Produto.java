/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;

/**
 *
 * @author Lázaro
 */
public class Produto {
    private String nome;
    private double preco;
    private String categoria;
    private int codigo;
    private int qtdEstoque;

    public Produto(String nome, double preco, String categoria, int codigo, int qtdEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.codigo = codigo;
        this.qtdEstoque = qtdEstoque;
    }
    
    @Override
    public String toString(){
        return "Nome: "+this.nome
                +"Preco: "+this.preco
                +"Codigo: "+this.codigo
                +"Estoque: "+this.qtdEstoque;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public int qtdEstoque(){
        return this.qtdEstoque;
    }

}
