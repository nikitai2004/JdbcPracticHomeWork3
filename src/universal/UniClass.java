package universal;

import db.MySQLConnector;

import java.sql.*;
import java.util.Map;
import java.util.stream.Collectors;

public class UniClass {
    public static boolean isTableExist(String tableName) throws SQLException {
        MySQLConnector db = new MySQLConnector();
        ResultSet rs1 = db.executeRequestWithAnswer("Show tables");
        int columns = rs1.getMetaData().getColumnCount();
        while (rs1.next()) {
            for (int i = 1; i <= columns; i++) {
                String mysqlTable = rs1.getString(1);
                if (mysqlTable.equals(tableName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void deleteTable(String tableName) {
        MySQLConnector db = new MySQLConnector();
        String sqlRequest = String.format("drop table %s;", tableName);
        db.executeRequest(sqlRequest);
    }

    public static void selectCountMales(String tableName) {
        MySQLConnector db = new MySQLConnector();
       // final Logger log = LogManager.getLogger(UniClass.class);
        String sqlRequest = String.format("SELECT count(*) FROM %s where sex = 'М';", tableName);
        try {
            ResultSet rs = db.execute(sqlRequest);
            rs.next();
            System.out.println();
            System.out.print("Количество студентов (М) - ");
            System.out.println(rs.getString(1));
            //log.info("Количество студентов (М) - ");
            //log.info(rs.getString(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.print("Ошибка выполнения запроса");
        }
    }

    public static void showStudentsFemales(String tableName) {
        MySQLConnector db = new MySQLConnector();
        System.out.println();
        System.out.println("Вывод студенток:");
        System.out.println("Пол; №; №.гр; ФИО");
        final String sqlRequest = String.format("SELECT * FROM %s where sex = 'Ж';", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void selectFull(String tableName) {
        MySQLConnector db = new MySQLConnector();
        System.out.println();
        System.out.println("Вывод информации о всех студентах включая название группы и имя куратора:");
        System.out.println("№; ФИО студента; Пол;  №.гр; Название группы; № куратора; ФИО куратора");
        final String sqlRequest = String.format("select s.id, s.fio, s.sex, g.id, g.name, c.id, c.fio from %s s left join gruppa g on s.id_group = g.id left  join curator c on c.id = g.id_curator;", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String convertMapColumnsToString(Map<String, String> columns) {
        return columns.entrySet().stream().map((Map.Entry entry) -> String.format("%s %s", entry.getKey(), entry.getValue())).collect(Collectors.joining(", "));
    }

    public static void createDB(String tableName, Map<String, String> columns) {
        try {
            if (UniClass.isTableExist(tableName)) {
                UniClass.deleteTable(tableName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        MySQLConnector db = new MySQLConnector();
        String sqlRequest = String.format("create table %s (%s);", tableName, convertMapColumnsToString(columns));
        db.executeRequest(sqlRequest);
    }

    public static void showGroupsAndCurators() {
        MySQLConnector db = new MySQLConnector();
        System.out.println();
        System.out.println("Вывод групп и кураторов: ");
        System.out.println("№ гр.;  Группа ;  Куратор");
        final String sqlRequest = "select  g.id, g.name,  c.fio from gruppa g left  join curator c on c.id = g.id_curator;";
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void showStudentsFromGroup(String group){
        MySQLConnector db = new MySQLConnector();
        System.out.println();
        System.out.println("Вывод студентов группы: " + group);
        System.out.println("№ ;      ФИО     ; пол; № гр.");
        final String sqlRequest = String.format("select id, fio, sex, id_group from student where id_group in (select id from gruppa where name = '%s');", group);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void showOneGroupAndCurators(String tableName) {
        MySQLConnector db = new MySQLConnector();
        System.out.println();
        System.out.println("Вывод информации о студентах 1 группы, и ФИО куратора:");
        System.out.println("№; ФИО студента; Пол;  №.гр; Название группы; № куратора; ФИО куратора");
        final String sqlRequest = String.format("select s.id, s.fio, s.sex, g.id, g.name, c.id, c.fio from %s s left join gruppa g on s.id_group = g.id left  join curator c on c.id = g.id_curator where g.id = 1 ;", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void changeCur(String tableName) {
        MySQLConnector db = new MySQLConnector();
        String sqlRequest = String.format("update %s set id_curator = 4 where id_curator = 1;", tableName);
        db.executeRequest(sqlRequest);
    }
}