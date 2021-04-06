package projetofinal;
import projetofinal.Produto;
public class Vendas {
    //Atributos
    private float valorTotal;
    private Produto produtosVendidos;
    
    //Construtor
    public Vendas(float valor_total, Produto produtosVendidos) {
        this.valorTotal = valor_total;
        this.produtosVendidos = produtosVendidos;
    }
    
    //Getters e Setters
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getProdutosVendidos() {
        return produtosVendidos.toString();
    }
    
    

}