/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visao;

import br.ufv.controle.ControleProduto;
import java.util.Scanner;

/**
 *
 * @author Lázaro
 */
public class TelaProduto {
    private Scanner s;
    private ControleProduto controleProduto;
    
    public TelaProduto(){
        s = new Scanner(System.in);
        controleProduto = new ControleProduto();
    }
    
    public void telaPrincipal(){
        
    }
    
    public void menu(){
        System.out.println("Nome: ");
        System.out.println("Preco: ");
        System.out.println("Codigo: ");
        System.out.println("Estoque: ");
        System.out.println("Categoria: ");
    }
}
