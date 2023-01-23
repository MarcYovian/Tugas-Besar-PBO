package com.dataStorage;

import com.connection.DatabaseConnection;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import swinger.glasspanepopup.GlassPanePopup;

public class rak extends abstractClass{
    
    ResultSet rs;
    private int total; 
    DatabaseConnection db = new DatabaseConnection();
        
    @Override
    public int hitungTotal() {
        rs = db.getData("SELECT * FROM rak_gudang");
        int jumlah = 0;
        try {
            while (rs.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            Message ms = new Message();
            ms.setData(new Model_Message("Error", e.getMessage()));
            ms.eventOK(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(ms);
        }
        this.total = jumlah;
        return total;
    }
    
}
