/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFreeChart.charts;

import br.ufv.modelo.Venda;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Lázaro
 */
public class GraficoDeLinha {
    public CategoryDataset createDataSet(ArrayList<Integer> produtos, ArrayList<String> datas, ArrayList<Integer> vendas){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Produtos";
        String series2 = "Vendas";
        
        for(int i = 0; i < vendas.size(); i++){
            dataset.addValue(vendas.get(i), series2, datas.get(i));
        }
        for(int i = 0; i < produtos.size(); i++){
            dataset.addValue(produtos.get(i), series1, datas.get(i));
            
        }
        
        
        return dataset;
    }
    
    public JFreeChart createLineChart(CategoryDataset dataSet, String chartTitle){
        JFreeChart graficoLinha = ChartFactory.createLineChart(chartTitle, "Datas","Produtos", dataSet, PlotOrientation.VERTICAL, true, true, false);
        return graficoLinha;
    }
    
    public ChartPanel criarGrafico(ArrayList<Integer> produtos, ArrayList<String> datas, ArrayList<Integer> vendas, String chartTitle){
        
        CategoryDataset dataset = createDataSet(produtos,datas, vendas);
        
        JFreeChart grafico = this.createLineChart(dataset, chartTitle);
        ChartPanel painelGrafico = new ChartPanel(grafico);
        painelGrafico.setPreferredSize(new Dimension(377, 249));
        
        CategoryPlot plot = grafico.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesStroke(1, new BasicStroke(4.0f));
        renderer.setSeriesStroke(2, new BasicStroke(3.0f));
        plot.setRenderer(renderer);
        
        
        
        return painelGrafico;
    }
}
