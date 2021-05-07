/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visao;

import br.ufv.controle.ControleCliente;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class TelaCliente {
    private Scanner s;
    private ControleCliente controleCliente;
    
    public TelaCliente(){
        s = new Scanner(System.in);
        controleCliente = new ControleCliente();
    }
    
    public void telaPrincipal(){
        int opc;
        Scanner sc = new Scanner(System.in);
        menu();
        opc = sc.nextInt();
        while(true){
            switch (opc){
                case 1:
                    telaCadastrarCliente();
                    break;
                
                case 2:
                    System.out.println(controleCliente.listarClientesCadastrados().toString());
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
        System.out.println("1 - Cadastrar cliente ");
        System.out.println("2 - Listar clientes ");
        System.out.println("3 - Sair ");
        System.out.print("Digite: ");
    }
    
    public void telaCadastrarCliente(){
        System.out.print("Nome: ");
        String nome = s.next();
        System.out.print("Cpf: ");
        int cpf = s.nextInt(); 
        System.out.print("Data de Nascimento: ");
        String dtNasc = s.next();
        System.out.print("Codigo: ");
        int codigo = s.nextInt();
        System.out.print("Telefne: ");
        String telefone = s.next();
         
        controleCliente.cadastrarCliente(nome, cpf, dtNasc, codigo, telefone);
    } 
}
