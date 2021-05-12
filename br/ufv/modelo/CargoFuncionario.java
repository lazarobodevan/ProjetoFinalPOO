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
public enum CargoFuncionario {
    GERENTE("Gerente"), 
    CAIXA("Caixa"), 
    GESTOR_ESTOQUE("Gestor de Estoque");
    
    private String descricao;
    
    CargoFuncionario(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
