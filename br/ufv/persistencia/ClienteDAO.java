/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.persistencia;

import br.ufv.modelo.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class ClienteDAO {
    private static ArrayList<Cliente> clientes;
    private Scanner leitor;
    
    public ClienteDAO(){
        clientes = new ArrayList<>();
        leitor = new Scanner(System.in);
    }
    
    public void cadastraCliente(Cliente c){
        clientes.add(c);
        System.out.println("Cliente inserido com sucesso");
        System.out.println("Quantidade de clientes: "+clientes.size());
    }
    
    public Cliente pesquisaClienteCpf(int cpf){
        for(Cliente c: clientes){
            if(c.getCpf() == cpf){
                return c;
            }
        }
        return null;
    }
    
    public static ArrayList<Cliente> listarClientesCadastrados(){
        return clientes;
    }
}
