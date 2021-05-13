/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.CargoFuncionario;
import br.ufv.modelo.Funcionario;
import br.ufv.modelo.SituacaoFuncionario;
import br.ufv.persistencia.FuncionarioDAO;
import br.ufv.visaoGUI.funcionario.TelaLogin;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class ControleFuncionario {
    private FuncionarioDAO funcionarioDAO;

    public ControleFuncionario(){
        funcionarioDAO = new FuncionarioDAO();
    }
    
    public boolean contrataFuncionario(String nome, String cpf, String dtNasc, int codigo, String telefone, int matricula, String senha, double salario,
            String cargo, String dtContrat, String situacao, String sexo, String foto) throws SQLException{
        Funcionario f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, sexo, matricula, senha, salario, 
                        CargoFuncionario.valueOf(cargo.toUpperCase()), SituacaoFuncionario.valueOf(situacao.toUpperCase()), dtContrat);
        f.setFoto(foto);
        return funcionarioDAO.contrataFuncionario(f);
    }
    
    public boolean atualizaFuncionario(String nome, String cpf, String dtNasc, int codigo, String telefone, int matricula, String senha, double salario,
            String cargo, String dtContratado, String situacao, String sexo, String foto){
        Funcionario f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, sexo, matricula, senha, salario, 
                        CargoFuncionario.valueOf(cargo), SituacaoFuncionario.valueOf(situacao), dtContratado);
        f.setFoto(foto);
        //if(funcionarioDAO.validaAtualizacao(f)){
            return funcionarioDAO.atualizaFuncionario(f);
        //}
        //return false;
    }
    
    public boolean deletarFuncionario(int id){
        return funcionarioDAO.deletaFuncionario(id);
    }
    
    public ArrayList<Funcionario> getFuncionariosSql(){
        return funcionarioDAO.getFuncionariosSQL();
        
    }
    
    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarioDAO.getFuncionarios();
    }
    
    public Funcionario getFuncionarioCpf(String cpf){
        return funcionarioDAO.getFuncionarioCpf(cpf);
    }
    
    public Funcionario getFuncionarioId(int id){
        return funcionarioDAO.getFuncionarioId(id);
    }
    
    public ArrayList<Funcionario> getFuncionariosSituacao(String situacao){
        return funcionarioDAO.getFuncionariosSituacao(situacao);
    }
    
    public ArrayList<Funcionario> getFuncionariosCargo(String cargo){
        return funcionarioDAO.getFuncionariosCargo(cargo);
    }
    
    public ArrayList<Funcionario> getFuncionariosSalario(Double salario){
        return funcionarioDAO.getFuncionariosSalario(salario);
    }
    
    public ArrayList<Funcionario> getFuncionariosSalario(Double min, Double max){
        return funcionarioDAO.getFuncionariosSalario(min, max);
    }
    public Funcionario pesquisaFuncionarioMat(int matricula){
        if(matricula < 0){
            return null;
        }
        return funcionarioDAO.pesquisaFuncionarioMatSql(matricula);
    }
    
    public boolean validaCadastro(String cpfParam, int matriculaParam){
        return funcionarioDAO.validaCadastro(cpfParam, matriculaParam);
    }
    
    public void setAcessoAoSistema(int idFuncionario, String dtEntrada, String hrEntrada, String hrSaida){
        funcionarioDAO.setAcessoAoSistema(idFuncionario, dtEntrada, hrEntrada, hrSaida);
    }
}
