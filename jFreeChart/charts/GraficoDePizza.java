/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFreeChart.charts;

import br.ufv.controle.ControleDashboard;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Lázaro
 */
public class GraficoDePizza {
    ControleDashboard controleDashboard = new ControleDashboard();
    public DefaultPieDataset createDataSet(ArrayList<String> sexos, ArrayList<Integer> quantidadeSexos){
        
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (int i = 0; i < controleDashboard.getQtdSexos().size(); i++) {
            dataSet.setValue(sexos.get(i), quantidadeSexos.get(i));
        }
        
        return dataSet;
    }
    
    public JFreeChart createPizzaChart(DefaultPieDataset dataSet){
        JFreeChart graficoBarra = ChartFactory.createPieChart("Relação de Sexos Cadastrados", dataSet, true, 
                true, false);
        
        return graficoBarra;
    }
    
    public ChartPanel criarGrafico(ArrayList<String> produtos, ArrayList<Integer> vendas){
        
        DefaultPieDataset dataset = createDataSet(produtos, vendas);
        
        JFreeChart grafico = this.createPizzaChart(dataset);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        painelGrafico.setPreferredSize(new Dimension(300,300));
        painelGrafico.validate();
        
        return painelGrafico;
    }
}
