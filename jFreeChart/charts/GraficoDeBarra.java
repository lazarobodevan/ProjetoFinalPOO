/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFreeChart.charts;

import br.ufv.modelo.Produto;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Lázaro
 */
public class GraficoDeBarra {
    public CategoryDataset createDataSet(ArrayList<String> produtos, ArrayList<Integer> vendas){
        
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int i = 0;
        for(String p: produtos){
            dataSet.addValue(vendas.get(i), p, "");
            System.out.println(p + " "+ vendas.get(i));
            i++;
        }
        
        return dataSet;
    }
    
    public JFreeChart createBarChart(CategoryDataset dataSet){
        JFreeChart graficoBarra = ChartFactory.createBarChart("Produtos e Quantidades Vendidas", "", "Produto", 
                dataSet,PlotOrientation.VERTICAL, true, false, false);
        
        return graficoBarra;
    }
    
    public ChartPanel criarGrafico(ArrayList<String> produtos, ArrayList<Integer> vendas){
        
        CategoryDataset dataset = createDataSet(produtos, vendas);
        
        JFreeChart grafico = this.createBarChart(dataset);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        painelGrafico.setPreferredSize(new Dimension(400,400));
        
        return painelGrafico;
    }
}
