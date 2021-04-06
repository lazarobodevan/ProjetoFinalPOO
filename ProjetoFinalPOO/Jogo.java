package projetofinal;

import projetofinal.CategoriaJogo;
import projetofinal.PlataformaJogo;

public class Jogo extends Produto{
    //Construtor
    public Jogo(String nome, String desc, double preco, int codigo, CategoriaJogo catJogo, PlataformaJogo platJogo) {
        super(nome, desc, preco, codigo);
    }
    public CategoriaJogo catj;
    public PlataformaJogo platj;
    
    //getters e setters
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }
    
    
}
