package com.mysql;

import java.sql.SQLException;

import com.mysql.service.DBService;
public class App {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        try {
            dbService.getHistoryAndPrint();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
