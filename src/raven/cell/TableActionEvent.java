/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.cell;

public interface TableActionEvent {

    public void onLock(int row);

    public void onRole(int row);

    public void onActive(int row);
}
