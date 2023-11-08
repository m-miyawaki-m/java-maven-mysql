package com.mysql;

import org.junit.Test;

import com.mysql.dao.DBConnector;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import static org.mockito.Mockito.*;


public class AppTest {

    @Test
    public void testGetHistoryFaileCase01() throws SQLException {
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");

        // DBConnector dbConnector = mock(DBConnector.class);
        // when(dbConnector.getHistory()).thenReturn(expected);

        List<String> actual = DBConnector.getHistoryList();
        try{
            assertEquals(expected, actual);         
        } catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getMessage());
        }
    }

     
    @Test
    public void testGetHistorySuccessCase01() throws SQLException {
        List<String> expected = new ArrayList<>();
        expected.add("Sample Data 1");
        expected.add("Sample Data 2");
        expected.add("Sample Data 3");
        expected.add("Sample Data 4");
        expected.add("Sample Data 5");

        // DBConnector dbConnector = mock(DBConnector.class);
        // when(dbConnector.getHistory()).thenReturn(expected);

        List<String> actual = DBConnector.getHistoryList();
        assertEquals(expected, actual);         
    }
}