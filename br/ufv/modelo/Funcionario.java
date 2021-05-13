/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Lázaro
 */
public class Funcionario extends Pessoa{
    
    private int matricula;
    private String senha;
    private double salario;
    private String dtAcesso;
    private String hrAcesso;
    private String hrSaida;
    private String dtContratado;
    private SituacaoFuncionario situacao;
    private CargoFuncionario cargo;
    private String foto;
    
    
    public Funcionario(String nome, String cpf, String dtNasc, int codigo, String telefone, String sexo, int matricula, String senha, double salario, 
            CargoFuncionario cargo, SituacaoFuncionario situacao, String dtContratado) {
       super(nome, cpf, dtNasc, codigo, telefone, sexo);
       this.matricula = matricula;
       this.senha = senha;
       this.salario = salario;
       this.situacao = SituacaoFuncionario.TRABALHANDO;
       this.cargo = cargo;
       this.dtContratado = "00/00/0000";
       this.foto = "src/imagens/unknown.png";
       this.situacao = situacao;
       this.dtContratado = dtContratado;
    }
    

    public int getMatricula() {
        return this.matricula;
    }
    
    public double getSalario() {
        return this.salario;
    }

    public String getDtAcesso() {
        return this.dtAcesso;
    }

    public String getHrAcesso() {
        return this.hrAcesso;
    }

    public SituacaoFuncionario getSituacao() {
        return situacao;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public CargoFuncionario getCargo(){
        return this.cargo;
    }
    
    public String getDtContratacao(){
        return this.dtContratado;
    }
    
    public String getFoto(){
        return this.foto;
    }
//-------------------------------------------------

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDtAcesso(String dtAcesso) {
        this.dtAcesso = dtAcesso;
    }
    
    public static String getDtHoje(){
        Date hoje = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(hoje);
    }
    
    public void setDtContratado(String dt){
        this.dtContratado = dt;
    }
    
    public void setSituacao(String situacao){
        this.situacao = SituacaoFuncionario.valueOf(situacao);
    }
    
    public void setCargo(String cargo){
        this.cargo = CargoFuncionario.valueOf(cargo);
    }
    
    public void setFoto(String foto){
        this.foto = foto;
    }
}
