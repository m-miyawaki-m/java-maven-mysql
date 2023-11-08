package com.mysql;

import com.mysql.dao.DBConnector;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DBConnector.getHistoryList();
            DBConnector.getHistorySampleDataDTOs();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }
}
