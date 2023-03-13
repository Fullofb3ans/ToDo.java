package Severstal;

import java.sql.*;
public class SqlConnect {
    private static Connection connection;
    private static Statement statement;
     static void disconnect() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }
    static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:Sqlite:C:\\Users\\Igor\\IdeaProjects\\Severstal2\\src\\Severstal\\Notez.db");
        statement = connection.createStatement();
    }

    static void insert(String title, String text) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO notes(title, text) values('%s', '%s');", title, text));
    }

    static void find_all() throws SQLException {
        try(ResultSet rs = statement.executeQuery("select * from notes")) {
            while (rs.next()){
                System.out.println("|" + " Задача: " + rs.getString("title") + " |" + " Содержание: " + rs.getString("text") + "|" );
            }
        }
    }

     static void update(String title, String text) throws SQLException {
        statement.executeUpdate(String.format("UPDATE notes SET text = '%s' where title = ('%s');", text, title));
    }

     static void delete (String title) throws SQLException{
        statement.executeUpdate(String.format("DELETE FROM notes where title = ('%s');", title));
    }

    static void clear() throws SQLException {
        statement.executeUpdate("DELETE FROM notes;");
    }
}


