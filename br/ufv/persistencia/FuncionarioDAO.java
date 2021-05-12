/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;

import br.ufv.modelo.CargoFuncionario;
import br.ufv.modelo.Funcionario;
import static br.ufv.persistencia.ConexaoMySQL.getConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lázaro
 */
public class FuncionarioDAO {
    private Connection conexao;
    private ArrayList<Funcionario> funcionarios;
    
    public FuncionarioDAO(){
        conexao = new ConexaoMySQL().getConexaoMySQL();
        funcionarios = this.getFuncionariosSQL();
        
    }
    
    public boolean validaCadastro(String cpfParam, int matriculaParam){
        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(cpfParam) || f.getMatricula() == matriculaParam)
                return false;
        }
        return true;
    }
    
    public boolean contrataFuncionario(Funcionario f){
        String sql =  "INSERT INTO funcionario(nome, cpf, dtNasc, idFuncionario, telefone, matricula, senha, salario, situacao, cargo, dtContratado) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, String.valueOf(f.getNome()));
            stmt.setString(2, String.valueOf(f.getCpf()));
            String dia = f.getDtNasc().substring(0,2);
            String mes = f.getDtNasc().substring(3,5);
            String ano = f.getDtNasc().substring(6);
            String dtNascBanco = ano+"-"+mes+"-"+dia;
            stmt.setString(3, dtNascBanco);
            stmt.setString(4, String.valueOf(f.getCodigo()));
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, String.valueOf(f.getMatricula()));
            stmt.setString(7, String.valueOf(f.getSenha()));
            stmt.setString(8, String.valueOf(f.getSalario()));
            stmt.setString(9, String.valueOf(f.getSituacao()));
            stmt.setString(10, String.valueOf(f.getCargo()));
            dia = f.getDtContratacao().substring(0,2);
            mes = f.getDtContratacao().substring(3,5);
            ano = f.getDtContratacao().substring(6);
            String dtContratcBanco = ano+"-"+mes+"-"+dia;
            stmt.setString(11, String.valueOf(dtContratcBanco));
            stmt.execute();
            stmt.close();
            funcionarios.add(f);
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean atualizaFuncionario(Funcionario f){
        String sql =  "UPDATE funcionario SET nome = ?, cpf = ?, dtNasc = ?, telefone = ?, "
                + "matricula = ?, senha = ?, salario = ?, situacao = ?, cargo = ? WHERE idFuncionario = "+f.getCodigo();
        PreparedStatement stmt;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, String.valueOf(f.getNome()));
            stmt.setString(2, String.valueOf(f.getCpf()));
            String dia = f.getDtNasc().substring(0,2);
            String mes = f.getDtNasc().substring(3,5);
            String ano = f.getDtNasc().substring(6);
            String dtNascBanco = ano+"-"+mes+"-"+dia;
            stmt.setString(3, dtNascBanco);
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, String.valueOf(f.getMatricula()));
            stmt.setString(6, String.valueOf(f.getSenha()));
            stmt.setString(7, String.valueOf(f.getSalario()));
            stmt.setString(8, String.valueOf(f.getSituacao()));
            stmt.setString(9, String.valueOf(f.getCargo()));
            stmt.execute();
            stmt.close();
            funcionarios = this.getFuncionariosSQL();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean validaAtualizacao(Funcionario f){
        /*
            Nao posso querer atualizar os dados de um funcionario com
            cpf ou matricula de um funcionario ja cadastrado
        */
        for(Funcionario func : funcionarios){
            if(func.getCodigo() == f.getCodigo()) continue;
            if(func.getCpf().equals(f.getCpf()) || func.getMatricula() == f.getMatricula()){
                return false;
            }
        }
        return true;
    }
    
    public boolean deletaFuncionario(int id){
        String sql =  "DELETE FROM funcionario WHERE idFuncionario = "+id;
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            funcionarios = this.getFuncionariosSQL();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Funcionario> getFuncionariosSQL(){
        String sql = "SELECT * FROM funcionario";
        System.out.println(sql);
        PreparedStatement stmt;
        ArrayList<Funcionario> funcs = new ArrayList<>();
        Funcionario f = null;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs != null && rs.next()){
                int codigo = rs.getInt("idFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dtNasc = rs.getString("dtNasc");
                String telefone = rs.getString("telefone");
                int matricula = rs.getInt("matricula");
                String senha = rs.getString("senha");
                double salario = rs.getDouble("salario");
                CargoFuncionario cargo = CargoFuncionario.valueOf(rs.getString("cargo").toUpperCase());
                String dtContrat = rs.getString("dtContratado");
                String situacao = rs.getString("situacao");

                f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, matricula, senha, salario, cargo);
                f.setDtContratado(dtContrat);
                f.setSituacao(situacao.toUpperCase());
                funcs.add(f);
            }
            stmt.close();
            return funcs;
            
        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
          }
        
        return null;
    }
    
    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }
    
    public Funcionario pesquisaFuncionarioMatSql(int mat){
        String sql = "SELECT * FROM funcionario WHERE matricula = "+mat;
        System.out.println(sql);
        PreparedStatement stmt;
        Funcionario f = null;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null && rs.next()){
                int codigo = rs.getInt("idFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dtNasc = rs.getString("dtNasc");
                String telefone = rs.getString("telefone");
                int matricula = rs.getInt("matricula");
                String senha = rs.getString("senha");
                double salario = rs.getDouble("salario");
                CargoFuncionario cargo = CargoFuncionario.valueOf(rs.getString("cargo").toUpperCase());

                f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, matricula, senha, salario, cargo);
            }
            stmt.close();
            return f;
            
        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
          }
        
        return null;
    }
    
    public Funcionario pesquisaFuncionarioCpfSql(String cpfParam){
        String sql = "SELECT * FROM funcionario WHERE matricula = '"+cpfParam+"'";
        System.out.println(sql);
        PreparedStatement stmt;
        Funcionario f = null;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null && rs.next()){
                int codigo = rs.getInt("idFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String dtNasc = rs.getString("dtNasc");
                String telefone = rs.getString("telefone");
                int matricula = rs.getInt("matricula");
                String senha = rs.getString("senha");
                double salario = rs.getDouble("salario");
                CargoFuncionario cargo = CargoFuncionario.valueOf(rs.getString("cargo").toUpperCase());

                f = new Funcionario(nome, cpf, dtNasc, codigo, telefone, matricula, senha, salario, cargo);
            }
            stmt.close();
            return f;
            
        } catch (Exception e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
          }
        
        return null;
    }
    
    public ArrayList<Funcionario> getFuncionariosSituacao(String situacao){
        ArrayList<Funcionario> fsit = new ArrayList<>();
        for(Funcionario f: funcionarios){
            if(f.getSituacao().getDescricao().toUpperCase().equals(situacao))
                fsit.add(f);
        }
        return fsit;
    }
    
    public Funcionario getFuncionarioId(int id){
        for(Funcionario f: this.getFuncionarios()){
            if(f.getCodigo()== id)
                return f;
        }
        return null;
    }
    
    public Funcionario getFuncionarioCpf(String cpf){
        for(Funcionario f: this.getFuncionarios()){
            if(f.getCpf().equals(cpf))
                return f;
        }
        return null;
    }
    
    public ArrayList<Funcionario> getFuncionariosCargo(String cargo){
        ArrayList<Funcionario> fcg = new ArrayList<>();
        for(Funcionario f: this.getFuncionarios()){
            if(f.getCargo().getDescricao().toUpperCase().equals(cargo))
                fcg.add(f);
        }
        return fcg;
    }
    
     public ArrayList<Funcionario> getFuncionariosSalario(Double salario){
        ArrayList<Funcionario> fcg = new ArrayList<>();
        for(Funcionario f: this.getFuncionarios()){
            if(f.getSalario() == salario)
                fcg.add(f);
        }
        return fcg;
    }
     
     public ArrayList<Funcionario> getFuncionariosSalario(Double min, Double max){
        ArrayList<Funcionario> fcg = new ArrayList<>();
        for(Funcionario f: this.getFuncionarios()){
            if(f.getSalario() >= min && f.getSalario() <= max)
                fcg.add(f);
        }
        return fcg;
    }
}
