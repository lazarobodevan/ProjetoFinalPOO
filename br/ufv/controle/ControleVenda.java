/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

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
    private Scanner s;
    
    public ControleVenda(){
        vendaDAO = new VendaDAO();
        s = new Scanner(System.in);
    }
    
    public void cadastraVenda(double precoTotal, String cliente, ArrayList<String> produtos, Calendar data){
        int codigo = vendaDAO.listarVendasCadastradas().size()+1;
        Venda v = new Venda(precoTotal, codigo, cliente, produtos, data);
        
        vendaDAO.cadastraVenda(v);
        JOptionPane.showMessageDialog (null, "Venda cadastrada!");
        
    }
    
}
