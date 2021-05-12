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
public enum SituacaoFuncionario {
    TRABALHANDO("Trabalhando"), 
    ADVERTENCIA("Advertencia"),
    AFASTADO("Afastado"),
    ATESTADO("Atestado"), 
    DEMITIDO("Demitido");
    
    private String descricao;
    
    SituacaoFuncionario(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
