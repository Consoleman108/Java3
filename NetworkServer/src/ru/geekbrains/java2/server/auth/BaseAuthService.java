package ru.geekbrains.java2.server.auth;
import java.sql.*;

public class BaseAuthService implements AuthService {

    private static Connection connection;
    private static Statement stmt;


    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        String sql = String.format("SELECT nickname FROM main where login = '%s' and password = '%s'", login, password);

        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации оставлен");
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
