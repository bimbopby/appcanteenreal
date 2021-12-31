/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.stat;
import Model.stat2;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Administrator
 */
public class qltk {
    
    ThongKe_Con stcon  ;

    public qltk() {
   
        stcon = new ThongKe_Con();
    }
    

   
    
    public void setdatachart1(JPanel jpn){
        List<stat> lst = stcon.getListstat();
        if(lst !=null){
            DefaultCategoryDataset dcd = new DefaultCategoryDataset();
            for(stat item : lst){
                dcd.addValue(item.getSoluong(), "Hóa đơn", item.getNgay());
            }
            JFreeChart chart = ChartFactory.createLineChart("Biểu đồ đường thống kê hóa đơn đã bán", "Ngày/tháng/năm", "Số lượng hóa đơn bán ra", dcd);
            ChartPanel cp  = new ChartPanel(chart);
            cp.setPreferredSize(new Dimension(jpn.getWidth(), 300));
            
            
            jpn.removeAll();
            jpn.setLayout(new CardLayout());
            jpn.add(cp);
            jpn.validate();
            jpn.repaint();
        }
    }
    
    public void setdatachart2(JPanel jpn){
        List<stat2> lst = stcon.getListstat2();
        if(lst !=null){
            DefaultCategoryDataset dcd = new DefaultCategoryDataset();
            for(stat2 item : lst){
                dcd.addValue(item.getTonghd(), "000 VNĐ", item.getNgay());
            }
            JFreeChart chart = ChartFactory.createLineChart("Biểu đồ đường thống kê doanh thu", "Ngày/tháng/năm", "Doanh thu", dcd);
            ChartPanel cp  = new ChartPanel(chart);
            cp.setPreferredSize(new Dimension(jpn.getWidth(), 300));
            
            
            jpn.removeAll();
            jpn.setLayout(new CardLayout());
            jpn.add(cp);
            jpn.validate();
            jpn.repaint();
        }
    }
}
