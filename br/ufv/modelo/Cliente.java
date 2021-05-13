package br.ufv.modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private ArrayList<Venda> compras;
    public Cliente(String nome, String cpf, String dtNasc, int codigo, String telefone, String sexo) {
        super(nome, cpf, dtNasc, codigo, telefone, sexo);
        compras = new ArrayList<>();
    }
    
    public ArrayList getCompras(){
        return this.compras;
    }

    
    @Override
    public String toString() {
        return "Cliente" + "\nNome = " + this.getNome() + " \nCPF = " + this.getCpf()
                + " \nData de Nascimento = " + this.getDtNasc() + " \nCodigo = " + this.getCodigo()
                + " \nTelefone = " + this.getTelefone() ;
    }   
}