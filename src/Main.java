import groupDAO.GroupDAO;
import studentDAO.StudentDAO;
import curatorDAO.CuratorDAO;
import universal.UniClass;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        GroupDAO groupDAO = new GroupDAO();
        CuratorDAO curatorDAO = new CuratorDAO();

// create table Students
        UniClass.createDB(StudentDAO.tableName, StudentDAO.columns);
// fill table Students
        studentDAO.InsertStudent();
// create table Group
        UniClass.createDB(GroupDAO.tableName, GroupDAO.columns);
// fill table Group
        groupDAO.InsertGroup();
// create table Curator
        UniClass.createDB(CuratorDAO.tableName, CuratorDAO.columns);
// fill table Curator
        curatorDAO.InsertCurator();
// show all students, groups, curators
        UniClass.selectFull(StudentDAO.tableName);
// show count of Students
        UniClass.selectCountMales(StudentDAO.tableName);
// show list Females
        UniClass.showStudentsFemales(StudentDAO.tableName);
//      Обновить данные по группе сменив куратора   ============
//      Распечатаем первую группу с куратором
        UniClass.showOneGroupAndCurators(StudentDAO.tableName);
//      Изменить куратора у первой группы
        UniClass.changeCur(GroupDAO.tableName);
//      Распечатаем группу с куратором для проверки
        UniClass.showOneGroupAndCurators(StudentDAO.tableName);
//      Завершено - Обновить данные по группе сменив куратора   ============
//      Вывести список групп с их кураторами
        UniClass.showGroupsAndCurators();
//      Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название группы, например - \"Группа SQL\" или \"Группа Java\" (без кавычек)");
        String name = sc.nextLine();
        UniClass.showStudentsFromGroup(name);
//      или просто запросом UniClass.showStudentsFromGroup(db,"Группа Java");
    }
}