package com.mysql.service;

import com.mysql.dao.StudentsDAO;

// HistoryService.java
public class StudentsService extends DBService {
    public void getStudentsAndPrint() {
        // SQLRunnableをラムダ式で呼び出しています。
        // これにより、SQLExceptionをスローする可能性のあるコードを
        // executeWithExceptionHandlingメソッドに渡すことができます。
        executeWithExceptionHandling(() -> StudentsDAO.getStudentsDataDTOs());
    }
}