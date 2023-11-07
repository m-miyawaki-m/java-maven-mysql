package com.mysql;

import com.mysql.dao.DBConnector;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DBConnector.getHistory();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }
}
