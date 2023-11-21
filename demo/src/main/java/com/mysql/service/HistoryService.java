package com.mysql.service;

import com.mysql.dao.HistoryDAO;

// HistoryService.java
public class HistoryService extends DBService {
    public void getHistoryAndPrint() {
        // SQLRunnableをラムダ式で呼び出しています。
        // これにより、SQLExceptionをスローする可能性のあるコードを
        // executeWithExceptionHandlingメソッドに渡すことができます。
        executeWithExceptionHandling(() -> HistoryDAO.getHistorySampleDataDTOs());
    }
}