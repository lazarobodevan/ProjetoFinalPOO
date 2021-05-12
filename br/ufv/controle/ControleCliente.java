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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ControleCliente {
    
    ClienteDAO clienteDAO;
    public ControleCliente(){
        clienteDAO = new ClienteDAO();
    }
    
    public boolean cadastrarCliente(String nome, String cpf, String dtNasc, int codigo, String telefone){
        Cliente c = new Cliente(nome, cpf, dtNasc, codigo, telefone);
        Cliente cExistente = clienteDAO.pesquisaClienteCpf(cpf);
        if(cExistente != null){
            return false;
        }else{
            try {
                clienteDAO.cadastraCliente(c);
            } catch (ParseException ex) {
                Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }      
    }
    
    public ArrayList<Cliente> listarClientesCadastrados(){
        return clienteDAO.listarClientesCadastrados();
    }
    
    public boolean atualizarCadastroCliente(String nome, String cpf, String dtNasc, int codigo, String telefone){
        Cliente c = new Cliente(nome, cpf, dtNasc, codigo, telefone);
        //Cliente cExistente = clienteDAO.pesquisaClienteCpf(cpf);
//        if(cExistente != null){
//            return false;
//        }else{
            clienteDAO.atualizarCadastroCliente(c);
            return true;
        //}      
    }
    
    public Cliente pesquisaClienteCpf(String cpfParam){
        try{
            return clienteDAO.pesquisaClienteCpf(cpfParam);
        }catch(NullPointerException ex){
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch(NumberFormatException ex){
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
   public ArrayList filtrarClienteNome(String nomeParam){
       return clienteDAO.filtrarClienteNome(nomeParam);
   }
    
   
   public boolean deletarCliente(String cpfParam){
       if(pesquisaClienteCpf(cpfParam) != null){
           clienteDAO.deletarCliente(cpfParam);
           return true;
       }else{
           return false;
       }
   }
}
