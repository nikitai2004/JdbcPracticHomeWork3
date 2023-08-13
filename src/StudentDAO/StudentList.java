package StudentDAO;

public class StudentList {
    Student newStudent = new Student();

    public Student listFio(int count) {
        if (count == 1) {
            newStudent.setFio(" Аравин Алексей");
            newStudent.setSex("М");
            newStudent.setId_group(1);
            newStudent.setId(1);
            return newStudent;
        }
        if (count == 2) {
            newStudent.setFio(" Березов Борис");
            newStudent.setSex("М");
            newStudent.setId_group(3);
            newStudent.setId(2);
            return newStudent;
        }
        if (count == 3) {
            newStudent.setFio(" Воронов Виктор");
            newStudent.setSex("М");
            newStudent.setId_group(2);
            newStudent.setId(3);
            return newStudent;
        }
        if (count == 4) {
            newStudent.setFio(" Глушко Галина");
            newStudent.setSex("Ж");
            newStudent.setId_group(3);
            newStudent.setId(4);
            return newStudent;
        }
        if (count == 5) {
            newStudent.setFio(" Демин Дмитрий");
            newStudent.setSex("М");
            newStudent.setId_group(2);
            newStudent.setId(5);
            return newStudent;
        }
        if (count == 6) {
            newStudent.setFio(" Егоров Иван");
            newStudent.setSex("М");
            newStudent.setId_group(1);
            newStudent.setId(6);
            return newStudent;
        }
        if (count == 7) {
            newStudent.setFio(" Животова Жанна");
            newStudent.setSex("Ж");
            newStudent.setId_group(1);
            newStudent.setId(7);
            return newStudent;
        }
        if (count == 8) {
            newStudent.setFio(" Зимина Зарина");
            newStudent.setSex("Ж");
            newStudent.setId_group(2);
            newStudent.setId(8);
            return newStudent;
        }
        if (count == 9) {
            newStudent.setFio(" Иванов Иван");
            newStudent.setSex("М");
            newStudent.setId_group(3);
            newStudent.setId(9);
            return newStudent;
        }
        if (count == 10) {
            newStudent.setFio(" Ковалев Корней");
            newStudent.setSex("М");
            newStudent.setId_group(2);
            newStudent.setId(10);
            return newStudent;
        }
        if (count == 11) {
            newStudent.setFio(" Лямин Леонид");
            newStudent.setSex("М");
            newStudent.setId_group(3);
            newStudent.setId(11);
            return newStudent;
        }
        if (count == 12) {
            newStudent.setFio(" Морозова Мария");
            newStudent.setSex("Ж");
            newStudent.setId_group(1);
            newStudent.setId(12);
            return newStudent;
        }
        if (count == 13) {
            newStudent.setFio(" Нилова Надежда");
            newStudent.setSex("Ж");
            newStudent.setId_group(1);
            newStudent.setId(13);
            return newStudent;
        }
        if (count == 14) {
            newStudent.setFio(" Огурцов Олег");
            newStudent.setSex("М");
            newStudent.setId_group(2);
            newStudent.setId(14);
            return newStudent;
        }
        if (count == 15) {
            newStudent.setFio(" Прошин Петр");
            newStudent.setSex("М");
            newStudent.setId_group(3);
            newStudent.setId(15);
            return newStudent;
        }
        return null;
    }
}