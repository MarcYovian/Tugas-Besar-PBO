package com.connection;

import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import swinger.glasspanepopup.GlassPanePopup;

public class DatabaseConnection{
    private String dbuser = "root";
    private String dbpsswd = "";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public DatabaseConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_warehouse", 
                dbuser, 
                dbpsswd
            );
            stmt = con.createStatement();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e.getMessage(), 
            "JDBCDriver Error", JOptionPane.WARNING_MESSAGE);
        }

    }

       
    public ResultSet getData(String SQLString){
        try{
            rs = stmt.executeQuery(SQLString);
        }catch (Exception e){
            Message ms = new Message();
            ms.setData(new Model_Message("Comunication Error",e.getMessage()));
            ms.eventOK(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();                   
                }
            });
            GlassPanePopup.showPopup(ms);
        }
        return rs;
    }

    public void query(String title, String message, String sQLString, Object... args) {
        try (PreparedStatement pstmt = con.prepareStatement(sQLString)){
            for(int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            int i = pstmt.executeUpdate();
            if(i>0){
                    Message ms = new Message();
                    ms.setData(new Model_Message(title,message));
                    ms.eventOK(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                                
                        }
                    });
                    GlassPanePopup.showPopup(ms);
            }else{
                JOptionPane.showMessageDialog(null,"Error");
            }

        } catch (Exception e) {
            // TODO: handle exception
            Message ms = new Message();
            ms.setData(new Model_Message("Error",e.getMessage()));
            ms.eventOK(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();                   
                }
            });
            GlassPanePopup.showPopup(ms);
        }
    }
    
    public void queryACC(String title, String message, String sQLString, Object... args) {
        try (PreparedStatement pstmt = con.prepareStatement(sQLString)){
            for(int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            int i = pstmt.executeUpdate();
            if(i>0){
                    Message ms = new Message();
                    ms.setData(new Model_Message(title,message));
                    ms.eventOK(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                                
                        }
                    });
                    GlassPanePopup.showPopup(ms);
            }else{
                JOptionPane.showMessageDialog(null,"Error");
            }

        } catch (Exception e) {
            // TODO: handle exception
            Message ms = new Message();
            ms.setData(new Model_Message("Error",e.getMessage()));
            ms.eventOK(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();                   
                }
            });
            GlassPanePopup.showPopup(ms);
        }
    }
}



