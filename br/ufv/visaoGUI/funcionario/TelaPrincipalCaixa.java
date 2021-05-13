/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.visaoGUI.funcionario;

import br.ufv.visaoGUI.cliente.TelaCliente;
import br.ufv.visaoGUI.produto.TelaProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Lázaro
 */
public class TelaPrincipalCaixa extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalCaixa
     */
    private TelaLogin tl = new TelaLogin();
    private TelaPrincipalGerente t;
    public TelaPrincipalCaixa() {
        initComponents();
        this.setLocationRelativeTo(null);
        showDate();
        showTime();
        try{
            lblBemVindo.setText("Bem Vind@, "+ tl.getFuncionarioLogado().getNome());
        }catch(NullPointerException e){
            lblBemVindo.setText("Bem Vind@");
            Logger.getLogger(TelaPrincipalCaixa.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    private void showDate(){
        Date d = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/YYYY");
        lblData.setText(dt.format(d));
    }
    private void showTime(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
                lblHora.setText(dt.format(d));
            }
        }).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniCliente = new javax.swing.JMenuItem();
        mniProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniVenda = new javax.swing.JMenuItem();
        mniEstoque = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setName("frmTelaPrincipalCaixa"); // NOI18N
        setResizable(false);

        lblData.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblBemVindo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(23, 0, 255));
        lblBemVindo.setText("Bem Vind@, ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblBemVindo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblBemVindo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mais.png"))); // NOI18N
        jMenu1.setText("Cadastrar");

        mniCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes.png"))); // NOI18N
        mniCliente.setText("Cliente");
        mniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mniCliente);

        mniProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Produtos.png"))); // NOI18N
        mniProduto.setText("Produto");
        mniProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(mniProduto);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pasta.png"))); // NOI18N
        jMenu2.setText("Gerenciar");

        mniVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/movimentos.png"))); // NOI18N
        mniVenda.setText("Realizar venda");
        jMenu2.add(mniVenda);

        mniEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Produtos.png"))); // NOI18N
        mniEstoque.setText("Verificar estoque");
        jMenu2.add(mniEstoque);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnSair)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClienteActionPerformed
        this.dispose();
        TelaCliente t = new TelaCliente();
    }//GEN-LAST:event_mniClienteActionPerformed

    private void mniProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProdutoActionPerformed
        this.dispose();
        TelaProduto t = new TelaProduto();
    }//GEN-LAST:event_mniProdutoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        if(TelaLogin.getFuncionarioLogado().getCargo().getDescricao().toUpperCase().equals("GERENTE")){
            t = new TelaPrincipalGerente();
            t.setVisible(true);
            this.dispose();
        }else{
            this.dispose();
            tl.setVisible(true);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenuItem mniCliente;
    private javax.swing.JMenuItem mniEstoque;
    private javax.swing.JMenuItem mniProduto;
    private javax.swing.JMenuItem mniVenda;
    // End of variables declaration//GEN-END:variables
}
