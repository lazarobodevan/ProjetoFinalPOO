/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author igorl
 */
public class Venda {
    private double precoTotal;
    private int codigo;
    private Cliente cliente;
    private ArrayList <Produto> produtos; 
    private ArrayList<Integer> qtds;
    private String data;
    private Funcionario funcionario;

    public Venda(double precoTotal, int codigo, Cliente cliente, ArrayList<Produto> produtos, ArrayList<Integer> qtds, String data, Funcionario f) {
        this.precoTotal = precoTotal;
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.qtds = qtds;
        this.data = data;
        this.funcionario = f;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Integer> getQtds() {
        return qtds;
    }

    public String getData() {
        return data;
    }
    
    public Funcionario getFuncionario(){
        return this.funcionario;
    }
    
    @Override
    public String toString(){
        return "\n Codigo: "+this.codigo
                +"\n Data: "+this.data
                +"\n Cliente: "+this.cliente.toString()
                +"\n Produtos: "+this.produtos
                +"\n Preco Total: "+this.precoTotal;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
