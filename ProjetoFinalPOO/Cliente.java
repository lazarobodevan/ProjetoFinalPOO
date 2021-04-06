package projetofinal;
public class Cliente {
    //Atributos
    private String nome, cpf;
    private int idade;
    Eletronicos el;
    Jogo jg;
    
    //Construtor
    public Cliente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }
    
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf; //depois introduzir funcao de validacao
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    
}
