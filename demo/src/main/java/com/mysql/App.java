package com.mysql;

import java.sql.SQLException;

import com.mysql.logging.AppLogger;
import com.mysql.service.DBService;
public class App {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        try {
            dbService.getHistoryAndPrint();
            dbService.getUsersAndPrint();
            dbService.getUsersAndPrintStoredProcedure();
            AppLogger.getInstance().logInfo("Hello World!");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
