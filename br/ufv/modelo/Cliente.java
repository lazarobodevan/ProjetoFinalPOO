package br.ufv.modelo;
public class Cliente {
    private String nome;
    private int cpf;
    private int idade;
    private int codigo;
    private String telefone;

    public Cliente(String nome, int cpf, int idade, int codigo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.codigo = codigo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "\nnome = " + this.nome + " \ncpf = " + this.cpf 
                + " \nidade = " + this.idade + " \ncodigo = " + this.codigo 
                + " \ntelefone = " + this.telefone + '}';
    }   
}