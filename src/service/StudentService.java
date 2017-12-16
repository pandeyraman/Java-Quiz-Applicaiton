package service;

import domain.Student;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman on 2/10/2017.
 */
public class StudentService {

    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<Student>();

        String query = "select * from student";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstname(rs.getString("firstname"));
                student.setLastname(rs.getString("lastname"));
                student.setRoll(rs.getInt("roll"));
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public void add(Student student) {
        String query = "insert into student (firstname,lastname,roll) values (?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, student.getFirstname());
            pstm.setString(2, student.getLastname());
            pstm.setInt(3, student.getRoll());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Student student) {
        String query = "update student set firstname=?, lastname=?, roll=? where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, student.getFirstname());
            pstm.setString(2, student.getLastname());
            pstm.setInt(3, student.getRoll());
            pstm.setInt(4, student.getId());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String  query ="delete  from student where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public Student getStudent(int id) {
        Student student = null;
        String query = "select * from student where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstname(rs.getString("firstname"));
                student.setLastname(rs.getString("lastname"));
                student.setRoll(rs.getInt("roll"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

}
