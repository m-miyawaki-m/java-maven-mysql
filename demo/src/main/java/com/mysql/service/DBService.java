package com.mysql.service;

import com.mysql.dao.HistoryDAO;
import com.mysql.dao.StudentsDAO;
import com.mysql.dao.UsersDAO;
import com.mysql.logging.AppLogger;
import java.sql.SQLException;

public class DBService {
    private AppLogger logger = new AppLogger();

    public void getHistoryAndPrint() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            HistoryDAO.getHistorySampleDataDTOs();
        } catch (SQLException e) {
            logger.logerror("Failed to get history data: " + e.getMessage());
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
            logger.logerror("Failed to get users data: " + e.getMessage());
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
            logger.logerror("Failed to get users data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.logerror("MySQL JDBC Driver not found." + e.getMessage());
        }
    }

        public void getStudentsAndPrint() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            StudentsDAO.getStudentsDataDTOs();
        } catch (SQLException e) {
            logger.logerror("Failed to get  data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.logerror("MySQL JDBC Driver not found." + e.getMessage());
        }
    }
}