package com.mysql.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.model.UsersDataDTO;

public class UsersDAO {
    public static List<UsersDataDTO> getUsersDataDTOs() throws SQLException {
    List<UsersDataDTO> users = new ArrayList<>();
    try (Connection connection = DBConnectorMySQL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dev01.users")) {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Integer age = resultSet.getInt("age");
            String birthPlace = resultSet.getString("birth_place");
            java.sql.Date birthDay = resultSet.getDate("birth_day");
            Boolean isAdmin = resultSet.getBoolean("is_admin");
            users.add(new UsersDataDTO(id,name,age,birthPlace,birthDay,isAdmin));
            System.out.println("id:" + id + " name:" + name);
        }
        //test用に例外を発生させる
        //throw new SQLException("SQLエラーが発生しました。");
    } catch (SQLException e) {
        // 例外処理をここに書く
        e.printStackTrace();
    }
        return users;
    }

    public static List<UsersDataDTO> getUsersDataDTOsForStoredProcedure() throws SQLException {
    List<UsersDataDTO> users = new ArrayList<>();
    try (Connection connection = DBConnectorMySQL.getConnection()){
            CallableStatement statement = connection.prepareCall("{CALL procedure_users()}");
            // ストアドプロシージャの実行
            ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Integer age = resultSet.getInt("age");
            String birthPlace = resultSet.getString("birth_place");
            java.sql.Date birthDay = resultSet.getDate("birth_day");
            Boolean isAdmin = resultSet.getBoolean("is_admin");
            users.add(new UsersDataDTO(id,name,age,birthPlace,birthDay,isAdmin));
            System.out.println("id:" + id + " name:" + name);
        }
        //test用に例外を発生させる
        //throw new SQLException("SQLエラーが発生しました。");
    } catch (SQLException e) {
        // 例外処理をここに書く
        e.printStackTrace();
    }
        return users;
    }
}
