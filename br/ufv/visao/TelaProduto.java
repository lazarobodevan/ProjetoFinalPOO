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
        int opc;
        Scanner sc = new Scanner(System.in);
        menu();
        opc = sc.nextInt();
        while(true){
            switch (opc){
                case 1:
                    telaCadastrarProduto();
                    break;
                
                case 2:
                    System.out.println(controleProduto.listarProdutosCadastrados().toString());
                    break;
                    
                case 3:
                    System.out.println("Execução encerrada!!!");
                    System.exit(0);
                    break;
            }
            menu();
            opc = sc.nextInt();
            
            
        }
    }
    
    public void menu(){
        
        System.out.println("----MENU----");
        System.out.println("1 - Cadastrar produto ");
        System.out.println("2 - Listar produtos ");
        System.out.println("3 - Sair ");
        System.out.print("Digite: ");
    }
    
    public void telaCadastrarProduto(){
        System.out.print("Nome: ");
        String nome = s.next();
        System.out.print("Preco: ");
        double preco = s.nextDouble();
        System.out.print("Codigo: ");
        int codigo = s.nextInt();
        System.out.print("Estoque: ");
        int estoque = s.nextInt();
        System.out.print("Categoria: ");
        String categoria = s.next();
         
        controleProduto.cadastraProduto(nome, preco, categoria, codigo, estoque);
    } 
}
