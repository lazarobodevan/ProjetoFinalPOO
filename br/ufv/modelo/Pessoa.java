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
public class Pessoa {
    private String nome;
    private String cpf;
    private String dtNasc;
    private int codigo;
    private String telefone;

    public Pessoa(String nome, String cpf, String dtNasc, int codigo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.codigo = codigo;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
