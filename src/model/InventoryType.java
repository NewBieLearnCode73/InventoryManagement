/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;


public class InventoryType {
    private String Type;

    public InventoryType() {
    }

    public InventoryType(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "InventoryType{" + "Type=" + Type + '}';
    }
    
    public static String[] getAllType(){
        String[] arr_type = {"Sách", "Bút", "Vở"}; 
        return arr_type;
    }
}

