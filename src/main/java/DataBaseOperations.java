import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseOperations {
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "yRFZwKd6Be8!RYF";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DataBaseOperations() {
        try {
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SELECT 1
    public List<Students> getAllStudents() {
        System.out.println("Select 1: show all students");
        List<Students> studentsList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                Students students = buildStudents(resultSet);
                studentsList.add(students);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Students el : studentsList) {
            System.out.println(el);
        }
        return studentsList;
    }

    //SELECT 2
    public void classesTeacher1List() {
        System.out.println("\n" + "Select 2: show classes records with teacher id No.1");
        List<Classes> classesTeacher1List = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM classes WHERE id_teacher = 1");
            while (resultSet.next()) {
                Classes classesTeacher1 = buildClassesRecord(resultSet);
                classesTeacher1List.add(classesTeacher1);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Classes el : classesTeacher1List) {
            System.out.println(el);
        }
    }

    //SELECT 3
    public void studNameHasN() {
        System.out.println("\n" + "Select 3: show students which names consist \"n\" ");
        List<Students> studNameHasN = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE first_name LIKE '%n%'");
            while (resultSet.next()) {
                Students students = buildStudents(resultSet);
                studNameHasN.add(students);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Students el : studNameHasN) {
            System.out.println(el);
        }
    }

    //Select 4
    public void teachersListLimit2() {
        System.out.println("\n" + "Select 4: show 2 teachers from the list ");
        List<Teachers> teachersListLimit2 = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM teachers LIMIT 2");
            while (resultSet.next()) {
                Teachers teachers = buildTeachers(resultSet);
                teachersListLimit2.add(teachers);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Teachers el : teachersListLimit2) {
            System.out.println(el);
        }
    }

    //Select 5
    public void teachersList() {
        System.out.println("\n" + "Select 5: show all teachers ");
        List<Teachers> teachersList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM teachers");
            while (resultSet.next()) {
                Teachers teachers = buildTeachers(resultSet);
                teachersList.add(teachers);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Teachers el : teachersList) {
            System.out.println(el);
        }
    }

    public Students buildStudents(ResultSet resultSet) throws SQLException {
        Students students = new Students();
        students.setStudentId(resultSet.getInt("id_student"));  //getInt(1));
        students.setFirstName(resultSet.getString("first_name"));
        students.setLastName(resultSet.getString("last_name"));
        students.setYearOfBirth(resultSet.getInt("year_of_birth"));
        return students;
    }

    private static Classes buildClassesRecord(ResultSet resultSet) throws SQLException {
        Classes classes = new Classes();
        classes.setId(resultSet.getInt("id_record"));
        classes.setClassName(resultSet.getString("name_class"));
        classes.setTeacherId(resultSet.getInt("id_teacher"));
        classes.setStudentId(resultSet.getInt("id_student"));
        return classes;
    }

    private static Teachers buildTeachers(ResultSet resultSet) throws SQLException {
        Teachers teachers = new Teachers();
        teachers.setTeacherId(resultSet.getInt("id_teacher"));
        teachers.setTeacherName(resultSet.getString("name_teacher"));
        return teachers;
    }
}
