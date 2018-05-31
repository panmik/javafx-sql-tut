package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.models.User;
import main.java.views.UserView;

public class DatabaseController {
    private Connection connection = null;
    private Statement statement = null;

    public DatabaseController() throws Exception {
        readDatabase();
    }

    private void readDatabase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ejdb?user=root&password=potis");
            statement = connection.createStatement();
        } catch (Exception e) {
            throw e;
        }
    }

    private void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        String[] columnLabels = new String[columnCount];
        for (int i = 1; i <= columnCount; i++ ) {
            columnLabels[i-1] = rsmd.getColumnName(i);
        }

        while (rs.next()) {
            String row = "";
            for (String label : columnLabels) {
                row += label + ": " + rs.getString(label) + ", ";
            }
            System.out.println(row);
        }
    }

    public void close() throws SQLException{
        if (connection != null) {
            connection.close();
        }
    }

    public void insertUser(User user) throws SQLException {
        PreparedStatement query = connection.prepareStatement("INSERT INTO USER VALUES (default, ?, ?, ?)");
        query.setString(1, user.getUsername());
        query.setString(2, user.getPassword());
        query.setString(3, user.getEmail());

        query.executeUpdate();
    }

    public List<UserView> getUserViews() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM user");

        List<UserView> userList = new ArrayList<UserView>();

        while (rs.next()) {
            userList.add(new UserView(
                    rs.getInt("iduser"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email")));
        }

        return userList;
    }
}
