package db;

import settings.PropertiesReader;

import java.sql.*;
import java.util.Map;

public class MySQLConnector implements IDBConnector {
    public static Connection connection = null;
    private static Statement statement = null;
    private final Map<String, String> settings = new PropertiesReader().read();

    public MySQLConnector() {
        connect();
    }

    public void connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        settings.get("url") + "/" + settings.get("db_name"),
                        settings.get("username"), settings.get("password")
                );
                System.out.println("Connected to Database");
            } catch (SQLException ex) {
                System.out.println("Cannot connect to database");
                ex.printStackTrace();
            }
        }
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ошибка in createStatement!");
            }
        }
    }

    @Override
    public ResultSet execute(String request) {
        try {
            return statement.executeQuery(request);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка выполнения SQL запроса!");
        }
        return null;
    }

    @Override
    public int executeUpdate(String response) {
        try {
            return statement.executeUpdate(response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка выполнения SQL запроса!");
        }
        return 0;
    }

    @Override
    public ResultSet executeRequestWithAnswer(String response) {
        try {
            return statement.executeQuery(response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка выполнения SQL запроса!");
        }
        return null;
    }

    public void executeRequest(String request) {
        try {
            statement.execute(request);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка выполнения SQL запроса!");
        }
    }

    @Override
    public void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ошибка закрытия SQL соединения!");
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ошибка закрытия SQL соединения!");
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}