package projetofinalpoo;
import projetofinalpoo.Vendas;
public class Funcionario {
    //Atributos
    private String nome;
    private String CPF;
    private int idade;
    public float salario;
    //Construtor
    public Funcionario(String nome, String CPF, int idade) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
    }
    
    Vendas V1 = new Vendas(100.00f, "jogo");
    public void comissoFunc(float V1, float salario, float soma, String nome){
        this.nome = nome;
        this.salario = salario;
        soma = (float) ((V1*0.2) + salario);
    }
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
}