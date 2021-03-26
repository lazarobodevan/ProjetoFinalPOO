package projetofinalpoo;
public class Vendas {
    //Atributos
    private float valor_total;
    private String produtos_vendidos;
    
    //Construtor
    public Vendas(float valor_total, String produtos_vendidos) {
        this.valor_total = valor_total;
        this.produtos_vendidos = produtos_vendidos;
    }
    
    //Getters e Setters
    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getProdutos_vendidos() {
        return produtos_vendidos;
    }

    public void setProdutos_vendidos(String produtos_vendidos) {
        this.produtos_vendidos = produtos_vendidos;
    }
    
    
    
}