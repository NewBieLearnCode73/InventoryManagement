/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import javax.swing.Icon;


public class CardModel {
    String title;
    double values;
    int percentage;
    Icon icon;

    public CardModel() {
    }

    public CardModel(String title, double values, int percentage, Icon icon) {
        this.title = title;
        this.values = values;
        this.percentage = percentage;
        this.icon = icon;
    }
    
    

    public String getTitle() {
        return title;
    }

    public double getValues() {
        return values;
    }

    public int getPercentage() {
        return percentage;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    
}

