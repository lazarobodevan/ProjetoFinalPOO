/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.modelo.Cliente;
import br.ufv.modelo.Produto;
import br.ufv.modelo.Venda;
import br.ufv.persistencia.VendaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Lázaro
 */
public class ControleVenda {
    private VendaDAO vendaDAO;
    private ControleProduto controleProduto;
    
    public ControleVenda(){
        vendaDAO = new VendaDAO();
        controleProduto = new ControleProduto();
    }
    
    public int getIdVenda(){
        return vendaDAO.getIdVenda();
    }
    
    public boolean setProdutosVenda(ArrayList<Produto> p){
        if(p!= null){
            vendaDAO.setProdutosVenda(p);
            return true;
        }else{
            return false;
        }
    }
    
    public Produto getProdutoId(int id){
        return controleProduto.pesquisaProdutoCod(id);
    }
    
    public ArrayList<Produto> getProdutosVenda(){
        return vendaDAO.getProdutosVenda();
    }
    
    public boolean cadastraVenda(Venda v){
        return vendaDAO.cadastraVendaSql(v);
    }
    
    public ArrayList<Venda> getVendasCadastradas(){
        return vendaDAO.getVendasCadastradas();
    }
    
}
