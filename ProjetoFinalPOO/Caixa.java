package projetofinalpoo;
public class Caixa {
    //Atributos
    private float valor_recebido;
    private float troco;
    Funcionario func;
    
    //Construtor
    public Caixa(float valor_recebido, float troco) {
        this.valor_recebido = valor_recebido;
        this.troco = troco;
    }
    
    //Getters e Setters
    public float getValor_recebido() {
        return valor_recebido;
    }

    public void setValor_recebido(float valor_recebido) {
        this.valor_recebido = valor_recebido;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }
    
}
