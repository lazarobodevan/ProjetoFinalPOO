package br.ufv.modelo;
public class Cliente {
    private String nome;
    private int cpf;
    private String dtNasc;
    private int codigo;
    private String telefone;

    public Cliente(String nome, int cpf, String dtNasc, int codigo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
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
        return "Cliente" + "\nNome = " + this.nome + " \nCPF = " + this.cpf 
                + " \nData de Nascimento = " + this.dtNasc + " \nCodigo = " + this.codigo 
                + " \nTelefone = " + this.telefone ;
    }   
}