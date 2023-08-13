package db;

import java.sql.ResultSet;

public interface IDBConnector {
    void executeRequest(String request);

    ResultSet execute(String request);

    int executeUpdate(String request);

    ResultSet executeRequestWithAnswer(String response);

    void close();
}
