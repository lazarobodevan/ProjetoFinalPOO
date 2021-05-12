/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.CargoFuncionario;
import br.ufv.modelo.Funcionario;
import br.ufv.persistencia.FuncionarioDAO;
import br.ufv.visaoGUI.funcionario.TelaLogin;
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
            String cargo, String dtContrat, String situacao){
        Funcionario f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, matricula, senha, salario, CargoFuncionario.valueOf(cargo.toUpperCase()));
        f.setDtContratado(dtContrat);
        f.setSituacao(situacao.toUpperCase());
        if(validaCadastro(cpf, matricula))
            return funcionarioDAO.contrataFuncionario(f);
        return false;
    }
    
    public boolean atualizaFuncionario(String nome, String cpf, String dtNasc, int codigo, String telefone, int matricula, String senha, double salario,
            String cargo, String dtContratado, String situacao){
        Funcionario f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, matricula, senha, salario, CargoFuncionario.valueOf(cargo));
        f.setDtContratado(dtContratado);
        f.setCargo(cargo);
        f.setSituacao(situacao);
        
        if(funcionarioDAO.validaAtualizacao(f)){
            return funcionarioDAO.atualizaFuncionario(f);
        }
        return false;
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
}
