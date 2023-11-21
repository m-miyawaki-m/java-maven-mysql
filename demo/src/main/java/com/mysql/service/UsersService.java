package com.mysql.service;

import com.mysql.dao.UsersDAO;

// UsersService.java
public class UsersService extends DBService {
    public void getUsersAndPrint() {
        // SQLRunnableをラムダ式で呼び出しています。
        // これにより、SQLExceptionをスローする可能性のあるコードを
        // executeWithExceptionHandlingメソッドに渡すことができます。
        executeWithExceptionHandling(() -> UsersDAO.getUsersDataDTOs());
    }

    public void getUsersAndPrintStoredProcedure() {
        // SQLRunnableをラムダ式で呼び出しています。
        // これにより、SQLExceptionをスローする可能性のあるコードを
        // executeWithExceptionHandlingメソッドに渡すことができます。
        executeWithExceptionHandling(() -> UsersDAO.getUsersDataDTOsForStoredProcedure());
    }
}