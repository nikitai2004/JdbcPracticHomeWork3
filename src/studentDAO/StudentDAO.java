package studentDAO;

import db.MySQLConnector;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO implements Dao<Student, Integer> {
    public static final String tableName = "student";

    public static final Map<String, String> columns = new HashMap<>() {{
        put("id", "varchar(30)");
        put("fio", "varchar(30)");
        put("sex", "varchar(30)");
        put("id_group", "varchar(30)");
    }};

    @Override
    public void InsertStudent() throws SQLException {
        MySQLConnector mySQLConnector = new MySQLConnector();
        Connection con = mySQLConnector.getConnection();
        StudentList studentList = new StudentList();
        for (int i = 1; i < 16; i++) {
            Student student = studentList.listFio(i);
            String sqlRequest = "insert into student(id, fio, sex, id_group) VALUES (?,?,?,?);";
            try (PreparedStatement statement = con.prepareStatement(sqlRequest)) {
                statement.setString(1, student.getId().toString());
                statement.setString(2, student.getFio());
                statement.setString(3, student.getSex());
                statement.setString(4, student.getId_group().toString());
                int rs = statement.executeUpdate();
            }
        }
    }
}