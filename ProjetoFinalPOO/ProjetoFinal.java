/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ProjFinal;
import java.util.Calendar;
import projetofinal.*;

/**
 *
 * @author Lázaro
 */
public class ProjetoFinal {

    public static void main(String[] args) {
       Calendar data = Calendar.getInstance();
       data.set(2001, 2, 15);
       Funcionario f1 = new Funcionario("Jose", "18864378740", data, 2000, 2877);
       System.out.println(f1.calculaIdade(data));
       
       
        
        //Funcionario f1 = new Funcionario("Joao", "18864378740", , 2000, 3877);
    }
    
}
