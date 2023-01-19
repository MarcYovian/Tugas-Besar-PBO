package com.actionTableAdmin;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableActionCellRender  extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        action act = new action();
        if(isSelected == false && row % 2 == 0){
            act.setBackground(Color.WHITE);
        }else{
            act.setBackground(com.getBackground());
        }
        return act;
    }
    
}
