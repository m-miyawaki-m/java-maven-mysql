package com.mysql.service;

import com.mysql.logging.AppLogger;
import java.sql.SQLException;

/*
 * このクラスの主な目的は、データベース操作を行うための共通のエラーハンドリングロジックを提供すること
 * executeWithExceptionHandlingメソッドは、SQLRunnableインターフェースのインスタンス
 * （つまり、SQLExceptionをスローする可能性のあるコード）を引数として受け取ります。
 * このメソッドは、そのタスクを実行し（task.run()）、発生したSQLExceptionをキャッチしてログに記録します。
 * 
 */

public class DBService {
    private AppLogger logger = new AppLogger();

    public void executeWithExceptionHandling(SQLRunnable task) {
        try {
            task.run();
        } catch (SQLException e) {
            logger.logerror("Failed to execute task: " + e.getMessage());
        }
    }
}