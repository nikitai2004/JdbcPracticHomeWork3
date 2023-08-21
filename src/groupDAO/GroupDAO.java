package groupDAO;

import db.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GroupDAO implements Dao<Group, Integer> {
    public static final String tableName = "gruppa";

    public static final Map<String, String> columns = new HashMap<>() {{
        put("id", "varchar(30)");
        put("name", "varchar(30)");
        put("id_curator", "varchar(30)");
    }};

    @Override
    public void InsertGroup() throws SQLException {
        MySQLConnector mySQLConnector = new MySQLConnector();
        Connection con = mySQLConnector.getConnection();
        GroupList groupList = new GroupList();
        for (int i = 1; i < 4; i++) {
            Group group = groupList.listGr(i);
            String sqlRequest = "insert into gruppa (id, name, id_curator) VALUES (?,?,?);";
            try (PreparedStatement statement = con.prepareStatement(sqlRequest)) {
                statement.setString(1, group.getId().toString());
                statement.setString(2, group.getName());
                statement.setString(3, group.getId_curator().toString());
                int rs = statement.executeUpdate();
            }
        }
    }
}