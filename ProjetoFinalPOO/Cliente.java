package projetofinalpoo;
public class Cliente {
    //Atributos
    private String nome;
    private int idade;
    Eletronicos el;
    Jogos jg;
    
    //Construtor
    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
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
    
    
    
}
