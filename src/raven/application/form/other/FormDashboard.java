package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
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
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CHECK_BOX, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));

        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));

        Icon icon5 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.INSERT_CHART, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));

        card2.setData(new CardModel("Inventories", 30000, 20,icon2));
        card6.setData(new CardModel("Income", 300000, 60,icon3));
        card7.setData(new CardModel("Purchasing", 18000, 60,icon4));
        card8.setData(new CardModel("Stock", 100, 60,icon5));
        
        chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        chart.addData(new ModelChart("July", new double[]{420, 380, 220, 300}));
        chart.addData(new ModelChart("August", new double[]{520, 430, 130, 400}));
        chart.addData(new ModelChart("September", new double[]{390, 470, 150, 230}));
        chart.addData(new ModelChart("October", new double[]{210, 260, 100, 160}));
        chart.addData(new ModelChart("November", new double[]{480, 520, 170, 390}));
        chart.addData(new ModelChart("December", new double[]{570, 610, 250, 450}));

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
