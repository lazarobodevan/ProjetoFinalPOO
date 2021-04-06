package projetofinal;

import java.util.Calendar;
public class Caixa extends Funcionario{
 
    public Caixa(String nome, String CPF, Calendar dtNasc, float salario, int matricula){
        super(nome, CPF, dtNasc, salario, matricula);
    }
    
    public double calculaTroco(double valorVenda, double dinheiro){
        return dinheiro - valorVenda;
    }
    
    public void realizaVenda(){
        
    }
    
    public void cadastraCliente(){
        
    }
    
    
}
