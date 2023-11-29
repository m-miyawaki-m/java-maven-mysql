package com.mysql.service;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLRunnable {
    void run() throws SQLException;
}