package projetofinal;
import java.time.Year;
import java.util.Calendar;
import projetofinal.Vendas;
public class Funcionario {
    //Atributos
    private String nome;
    private String CPF;
    private Calendar dtNasc;
    public float salario;
    public int matricula;
    public int idade;
    
    //Construtor
    public Funcionario(String nome, String CPF, Calendar dtNasc, float salario, int matricula) {
        this.nome = nome;
        this.CPF = CPF;
        this.dtNasc = dtNasc;
        this.matricula = matricula;
        this.salario = salario;
        
    }
    
    public int calculaIdade(Calendar data){
        return Year.now().getValue() - this.dtNasc.get(Calendar.YEAR);
    }
    
    public double comissaoFuncionario(double valorVenda, double porcentagem){
        return valorVenda * porcentagem;
    }
    
    public void cadastraFuncionario(String nome, String CPF, Calendar data, float salario, int matricula){
        Funcionario f1 = new Funcionario(nome, CPF, data, salario, matricula);
        System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO!");
    }
   
}