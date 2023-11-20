package com.mysql.service;

import com.mysql.dao.HistoryDAO;
import com.mysql.dao.UsersDAO;
import com.mysql.logging.AppLogger;
import java.sql.SQLException;

public class DBService {
    private AppLogger logger = AppLogger.getInstance();

    public void getHistoryAndPrint() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            HistoryDAO.getHistoryList();
            HistoryDAO.getHistorySampleDataDTOs();
        } catch (SQLException e) {
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.logerror("MySQL JDBC Driver not found." + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getUsersAndPrint() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            UsersDAO.getUsersDataDTOs();
        } catch (SQLException e) {
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.logerror("MySQL JDBC Driver not found." + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getUsersAndPrintStoredProcedure() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            UsersDAO.getUsersDataDTOsForStoredProcedure();
        } catch (SQLException e) {
            logger.logerror("Connection Failed." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.logerror("MySQL JDBC Driver not found." + e.getMessage());
            e.printStackTrace();
        }
    }
}