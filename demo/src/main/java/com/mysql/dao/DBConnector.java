package com.mysql.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.dto.SampleDataDTO;

public class DBConnector {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    // static initializer
    // 静的初期化ブロックは、クラスが初めてロードされるときに一度だけ実行
    static {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("/workspaces/java-mysql/demo/src/main/resources/application.properties")) {
            props.load(input);
            URL = props.getProperty("MYSQL_URL");
            USER = props.getProperty("MYSQL_USER");
            PASSWORD = props.getProperty("MYSQL_PASSWORD");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // DBConnector.getConnection() is a static method, so we don't need to create an instance of DBConnector to use it.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // テーブル「dev_history」から値を取得するためのメソッド
    public static List<String> getHistoryList() throws SQLException {
        Connection connection = getConnection();
        List<String> history = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT sampleinput FROM dev_history");

            while (resultSet.next()) {
                String sampleInput = resultSet.getString("sampleinput");
                history.add(sampleInput);
                System.out.println(sampleInput);
            }
        } finally {
            connection.close();
        }
        return history;
    }

     // (recordクラス）テーブル「dev_history」から値を取得するためのメソッド
    public static List<SampleDataDTO> getHistorySampleDataDTOs() throws SQLException {
        List<SampleDataDTO> history = new ArrayList<>();
        //try-with-resources文を使うと、tryブロックを抜ける際に自動的にclose()が呼び出される
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dev_history")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("No");
                String sampleInput = resultSet.getString("sampleinput");
                history.add(new SampleDataDTO(id, sampleInput));
                System.out.println("No:" + id + " sampleInput:" + sampleInput);
            }

            //test用に例外を発生させる
            //throw new SQLException("SQLエラーが発生しました。");
        } catch (SQLException e) {
            // 例外処理をここに書く
            e.printStackTrace();
        }
        return history;
    }
}