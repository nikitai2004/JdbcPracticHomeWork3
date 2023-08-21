package curatorDAO;

import db.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CuratorDAO implements Dao<Curator, Integer> {
    public final static String tableName = "curator";

    public static final Map<String, String> columns = new HashMap<>() {{
        put("id", "varchar(30)");
        put("fio", "varchar(30)");
    }};

    @Override
    public void InsertCurator() throws SQLException {
        MySQLConnector mySQLConnector = new MySQLConnector();
        Connection con = mySQLConnector.getConnection();
        CuratorList curatorlist = new CuratorList();
        for (int i = 1; i < 5; i++) {
            Curator curator = curatorlist.listCur(i);
            String sqlRequest = "insert into curator (id, fio) VALUES (?,?);";
            try (PreparedStatement statement = con.prepareStatement(sqlRequest)) {
                statement.setString(1, curator.getId().toString());
                statement.setString(2, curator.getFio());
                int rs = statement.executeUpdate();
            }
        }
    }
}
