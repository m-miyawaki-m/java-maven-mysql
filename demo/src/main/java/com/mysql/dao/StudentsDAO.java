package com.mysql.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.model.StudentsDataDTO;

import java.sql.Statement; // Add this import statement

// HistoryDAO.java
public class StudentsDAO {
    public static List<StudentsDataDTO> getStudentsDataDTOs() throws SQLException {
        List<StudentsDataDTO> students = new ArrayList<>();
        try (Connection connection = DBConnectorMySQL.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM dev01.students")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal height = resultSet.getBigDecimal("height");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Integer class_no = resultSet.getInt("class_no");
                students.add(new StudentsDataDTO(id, name, height, weight, class_no));
                //BigDecimal型の値を表示するには、%sを使用してBigDecimalのtoString()メソッドを呼び出す
                // System.out.printf("id:%d name:%s height:%s weight:%s class_no:%d\n",id,name,height,weight,class_no);
                System.out.printf("id:%04d height:%03.0f weight:%03.0f class_no:%02d name:%-20s \n", id, height, weight, class_no, name);
            }
            //test用に例外を発生させる
            //throw new SQLException("SQLエラーが発生しました。");
        } catch (SQLException e) {
            // 例外処理をここに書く
            e.printStackTrace();
        }
        return students;
    }
}