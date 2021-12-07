package homework16;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static final Connection connection = ConnectionRun.getConnect();

    public static void main(String[] args) throws SQLException {
        System.out.println(getStudentById(13344));
        System.out.println(deleteStudentById(43545));
        System.out.println(getAllStudents());
        System.out.println(getStudentListByLastName("Виктор"));
        ConnectionRun.shutdown();
    }

    private static Student getStudentById(int id) throws SQLException {
        final Student result = new Student();
        result.setID(-1);
        PreparedStatement statement = null;
        try {
            String sql = "select * from students where ID =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setID(1);
                result.setName(rs.getString(2));
                result.setIdGroup(rs.getInt(3));
                result.setYearOfEntry(rs.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return result;
    }

    private static boolean deleteStudentById(int id) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "delete from students where ID =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return false;
    }

    private static List<Student> getAllStudents() throws SQLException {
        List<Student> allStudents = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            String sql = "select * from students";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt(1);
                String Name = rs.getString(2);
                int IdGroup = rs.getInt(3);
                int YearOfEntry = rs.getInt(4);
                Student s = new Student(ID, Name, IdGroup, YearOfEntry);
                allStudents.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return allStudents;
    }

    private static List<Student> getStudentListByLastName(String lastName) throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            String sql = "select * from students where Name like ?";
            statement = connection.prepareStatement(sql);
            String lastNameFirst = lastName + "%";
            statement.setString(1, lastNameFirst);
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int groupId = rs.getInt(3);
                int yearOfEntry = rs.getInt(4);
                Student s = new Student(id, name, groupId, yearOfEntry);
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return students;
    }
}
