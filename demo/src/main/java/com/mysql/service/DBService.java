package com.mysql.service;

import com.mysql.dao.HistoryDAO;
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
}