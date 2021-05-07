/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

/**
 *
 * @author Pedro
 */
import br.ufv.persistencia.ClienteDAO;
import br.ufv.modelo.Cliente;
import java.util.ArrayList;
public class ControleCliente {
    
    ClienteDAO clienteDAO;
    public ControleCliente(){
        clienteDAO = new ClienteDAO();
    }
    
    public void cadastrarCliente(String nome, int cpf, String dtNasc, int codigo, String telefone){
        Cliente c = new Cliente(nome, cpf, dtNasc, codigo, telefone);
        Cliente cExistente = clienteDAO.pesquisaClienteCpf(cpf);
        if(cExistente != null){
            System.err.println("Cliente já existente!");
        }else{
            clienteDAO.cadastraCliente(c);
        }      
    }
    
    public ArrayList<String> listarClientesCadastrados(){
        ArrayList<Cliente> clientes = clienteDAO.listarClientesCadastrados();
        ArrayList<String> clientesStr = new ArrayList<>();
        
        for(Cliente p: clientes){
            clientesStr.add(clientes.toString());
        }
        return clientesStr;
    }
    
}
