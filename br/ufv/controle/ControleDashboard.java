/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.controle;

import br.ufv.persistencia.DashboardDAO;
import java.util.ArrayList;

/**
 *
 * @author Lázaro
 */
public class ControleDashboard {
    
    private DashboardDAO dashboardDAO;
    public ControleDashboard(){
        dashboardDAO = new DashboardDAO();
    }
    
    public ArrayList<String> getNomeProdutos(){
        return dashboardDAO.getNomeProdutos();
    }
    
    public ArrayList<Integer> getQtdVendasProd(){
        return dashboardDAO.getQtdVendasProd();
    }
    
    public void relacaoProdutoEQtdsVendidos(){
        dashboardDAO.relacaoProdutoEQtdsVendidos();
    }
    
    public void relacaoSexos(){
        dashboardDAO.relacaoSexos();
    }
    
    public ArrayList<String> getSexos(){
        return dashboardDAO.getSexos();
    }
    
    public ArrayList<Integer> getQtdSexos(){
        return dashboardDAO.getQtdSexos();
    }
    
    public double getValVenda() {
        return dashboardDAO.getValVenda();
    }

    public double getSalFunc() {
        return dashboardDAO.getSalFunc();
    }

    public int getQtdProdEst() {
        return dashboardDAO.getQtdProdEst();
    }

    public double getValEst() {
        return dashboardDAO.getValEst();
    }

    public int getQtdCli() {
        return dashboardDAO.getQtdCli();
    }

    public int getQtdVendas() {
        return dashboardDAO.getQtdVendas();
    }

    public int getQtdProdVend() {
        return dashboardDAO.getQtdProdVend();
    }

    public int getQtdProdVendMesA() {
        return dashboardDAO.getQtdProdVendMesA();
    }
    
    public ArrayList<String> getDataSemanas() {
        return dashboardDAO.getDataSemanas();
    }

    public ArrayList<String> getDataMeses() {
        return dashboardDAO.getDataMeses();
    }
    
     public ArrayList<Integer> getQtdProdVendSem(){
        return dashboardDAO.getQtdProdVendSem();
    }

    public ArrayList<Integer> getQtdProdVendMes() {
        return dashboardDAO.getQtdProdVendMes();
    }
    
     public ArrayList<String> getDataAnos() {
        return dashboardDAO.getDataAnos();
    }

    public ArrayList<Integer> getQtdProdVendAno() {
        return dashboardDAO.getQtdProdVendAno();
    }
    
}
