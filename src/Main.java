import GroupDAO.GroupDAO;
import StudentDAO.StudentDAO;
import CuratorDAO.CuratorDAO;
import Universal.UniClass;
import db.MySQLConnector;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        MySQLConnector db = new MySQLConnector();
        StudentDAO studentDAO = new StudentDAO();
        GroupDAO groupDAO = new GroupDAO();
        CuratorDAO curatorDAO = new CuratorDAO();

// create table Students
        UniClass.createDB(db, StudentDAO.tableName, StudentDAO.columns);
// fill table Students
        studentDAO.InsertStudent();
// create table Group
        UniClass.createDB(db, GroupDAO.tableName, GroupDAO.columns);
// fill table Group
        groupDAO.InsertGroup();
// create table Group
        UniClass.createDB(db, CuratorDAO.tableName, CuratorDAO.columns);
// fill table Group
        curatorDAO.InsertCurator();
// show all students, groups, curators
        UniClass.selectFull(db, StudentDAO.tableName);
// show count of Students
        UniClass.selectCountMales(db, StudentDAO.tableName);
// show list Females
        UniClass.showStudentsFemales(db, StudentDAO.tableName);
//      Обновить данные по группе сменив куратора   ============
//      Распечатаем первую группу с куратором
        UniClass.showOneGroupAndCurators(db, StudentDAO.tableName);
//      Изменить куратора у первой группы
        UniClass.changeCur(db, GroupDAO.tableName);
//      Распечатаем группу с куратором для проверки
        UniClass.showOneGroupAndCurators(db, StudentDAO.tableName);
//      Завершено - Обновить данные по группе сменив куратора   ============
//      Вывести список групп с их кураторами
        UniClass.showGroupsAndCurators(db);
//      Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название группы, например - \"Группа SQL\" или \"Группа Java\" (без кавычек)");
        String name = sc.nextLine();
        UniClass.showStudentsFromGroup(db, name);
//      или просто запросом UniClass.showStudentsFromGroup(db,"Группа Java");
    }

}