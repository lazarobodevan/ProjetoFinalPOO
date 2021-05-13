/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinalpoo;
import br.ufv.visaoGUI.funcionario.TelaLogin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Lázaro
 */
public class ProjetoFinalPOO {
    public static void main(String[] args) {
        //TelaProduto telaProduto = new TelaProduto();
        //telaProduto.telaPrincipal();
        //TelaCliente telaCliente = new TelaCliente();
        //telaCliente.telaPrincipal();
        //TelaInicial in = new TelaInicial();
        
        new TelaLogin().setVisible(true);
        
        
        Date hoje = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(hoje);
        System.out.println(data);
       
    }
    
}
