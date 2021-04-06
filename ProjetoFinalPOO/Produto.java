/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author Lázaro
 */
public class Produto {
    public String nome;
    public String desc;
    public double preco;
    public int codigo;
    
    public Produto(String nome, String desc, double preco, int codigo){
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
