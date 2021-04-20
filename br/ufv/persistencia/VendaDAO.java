/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;

import br.ufv.modelo.Venda;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author igorl
 */
public class VendaDAO {
    private static ArrayList<Venda> vendas;
    private Scanner leitor;
    
    public VendaDAO(){
        vendas = new ArrayList<>();
        leitor = new Scanner(System.in);
    }
    
    public void cadastraVenda(Venda v){
        vendas.add(v);
        System.out.println("Venda Inserida com sucesso!");
        System.out.println("Quantidade produto: " +vendas.size());
    }
    
    public Venda pesquisaVendaCod(int codigo){
        for (Venda v: vendas){
            if(v.getCodigo() == codigo){
                return v;
            }
        }
        return null;
    }
    
    public static ArrayList<Venda> listarVendasCadastradas(){
        return vendas;
    }
}
