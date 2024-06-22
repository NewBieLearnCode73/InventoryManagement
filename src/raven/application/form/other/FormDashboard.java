package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import dao.InventoryDAO;
import dao.TransactionDAO;
import java.awt.Color;
import javax.swing.Icon;
import model.CardModel;
import raven.chart.ModelChart;
import raven.swing.icon.GoogleMaterialDesignIcons;
import raven.swing.icon.IconFontSwing;
import raven.toast.Notifications;


public class FormDashboard extends javax.swing.JPanel {

    public FormDashboard() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        initData();
    }
    
    
     private void initData(){
        initCardData();
    }
    
    private void initCardData(){
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_CART, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon5 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.INSERT_CHART, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));

        card2.setData(new CardModel("Inventories", InventoryDAO.getInstance().getTotalOfInventory(),100 ,icon2));
        card6.setData(new CardModel("Profit", InventoryDAO.getInstance().getProfit(), 100 ,icon3));
        card7.setData(new CardModel("Purchasing", InventoryDAO.getInstance().getPurchasing(),100 ,icon4));
        card8.setData(new CardModel("Total Amount", TransactionDAO.getInstance().getTotalAmount(),100 ,icon5));
        
        chart.addLegend("Total Amount", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));

        chart.addData(new ModelChart("January", new double[]{TransactionDAO.getInstance().getProfitByMonth(1, 2024), TransactionDAO.getInstance().getTotalAmountByMount(1, 2024)}));
        chart.addData(new ModelChart("February", new double[]{TransactionDAO.getInstance().getProfitByMonth(2, 2024), TransactionDAO.getInstance().getTotalAmountByMount(2, 2024)}));
        chart.addData(new ModelChart("March", new double[]{TransactionDAO.getInstance().getProfitByMonth(3, 2024), TransactionDAO.getInstance().getTotalAmountByMount(3, 2024)}));
        chart.addData(new ModelChart("April", new double[]{TransactionDAO.getInstance().getProfitByMonth(4, 2024), TransactionDAO.getInstance().getTotalAmountByMount(4, 2024)}));
        chart.addData(new ModelChart("May", new double[]{TransactionDAO.getInstance().getProfitByMonth(5, 2024), TransactionDAO.getInstance().getTotalAmountByMount(5, 2024)}));
        chart.addData(new ModelChart("June", new double[]{TransactionDAO.getInstance().getProfitByMonth(6, 2024), TransactionDAO.getInstance().getTotalAmountByMount(6, 2024)}));
        chart.addData(new ModelChart("July", new double[]{TransactionDAO.getInstance().getProfitByMonth(7, 2024), TransactionDAO.getInstance().getTotalAmountByMount(7, 2024)}));
        chart.addData(new ModelChart("August", new double[]{TransactionDAO.getInstance().getProfitByMonth(8, 2024), TransactionDAO.getInstance().getTotalAmountByMount(8, 2024)}));
        chart.addData(new ModelChart("September", new double[]{TransactionDAO.getInstance().getProfitByMonth(9, 2024), TransactionDAO.getInstance().getTotalAmountByMount(9, 2024)}));
        chart.addData(new ModelChart("October", new double[]{TransactionDAO.getInstance().getProfitByMonth(10, 2024), TransactionDAO.getInstance().getTotalAmountByMount(10, 2024)}));
        chart.addData(new ModelChart("November", new double[]{TransactionDAO.getInstance().getProfitByMonth(11, 2024), TransactionDAO.getInstance().getTotalAmountByMount(11, 2024)}));
        chart.addData(new ModelChart("December", new double[]{TransactionDAO.getInstance().getProfitByMonth(12, 2024), TransactionDAO.getInstance().getTotalAmountByMount(12, 2024)}));

        chart.start();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        card2 = new raven.component.Card();
        card6 = new raven.component.Card();
        card7 = new raven.component.Card();
        card8 = new raven.component.Card();
        chart = new raven.chart.Chart();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Dashboard");

        card2.setBackground(new java.awt.Color(0, 153, 153));
        card2.setColorGradient(new java.awt.Color(255, 204, 0));

        card6.setBackground(new java.awt.Color(255, 204, 204));
        card6.setColorGradient(new java.awt.Color(255, 204, 0));

        card7.setBackground(new java.awt.Color(153, 255, 153));
        card7.setColorGradient(new java.awt.Color(153, 153, 255));

        card8.setBackground(new java.awt.Color(153, 153, 255));
        card8.setColorGradient(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(card6, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(card7, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(card8, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(card8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.component.Card card2;
    private raven.component.Card card6;
    private raven.component.Card card7;
    private raven.component.Card card8;
    private raven.chart.Chart chart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
