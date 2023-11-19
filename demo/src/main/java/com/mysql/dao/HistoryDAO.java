// HistoryDAO.java
public class HistoryDAO {
    public static List<String> getHistoryList() throws SQLException {
        Connection connection = DBConnector.getConnection();
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

    public static List<SampleDataDTO> getHistorySampleDataDTOs() throws SQLException {
        List<SampleDataDTO> history = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dev_history")) {

            while (resultSet.next()) {
                // ...
            }
        }
        return history;
    }
}