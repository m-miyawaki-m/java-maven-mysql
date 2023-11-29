package com.mysql;

import com.mysql.service.UsersService;
public class App {
    public static void main(String[] args) {
        UsersService usersService = new UsersService();
        usersService.getUsersAndPrint();
        usersService.getUsersAndPrintStoredProcedure();
    }
}
