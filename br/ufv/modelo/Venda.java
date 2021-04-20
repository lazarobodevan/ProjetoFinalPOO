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
    private String cliente;
    private ArrayList <String> produtos; 
    private Calendar data;

    public Venda(double precoTotal, int codigo, String cliente, ArrayList<String> produtos, Calendar data) {
        this.precoTotal = precoTotal;
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "\n Codigo: "+this.codigo
                +"\n Data: "+this.data
                +"\n Cliente: "+this.cliente
                +"\n Produtos: "+this.produtos
                +"\n Preco Total: "+this.precoTotal;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
