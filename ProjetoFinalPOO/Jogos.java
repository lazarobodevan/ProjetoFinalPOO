package projetofinalpoo;
public class Jogos {
    //Atributos
    private String nome;
    private int codigo;
    CategoriaJogo catj;
    PlataformaJogo platj;
    
    //Construtor
    public Jogos(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
}
