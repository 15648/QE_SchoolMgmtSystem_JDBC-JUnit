package coreJava.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coreJava.models.Student;
import coreJava.systemInterface.StudentDAOI;

public class StudentDAO implements StudentDAOI
{
    public Student getStudentByEmail(String email) throws ClassNotFoundException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Student student = null;
        OracleConnection Oracle = new OracleConnection();
        String GETALLSTUDENTS = "SELECT * FROM STUDENT WHERE EMAIL = ?";
        try {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETALLSTUDENTS);
            stmt.setString(1, email);
            result = stmt.executeQuery();
            
            if(result.next()) {
                student = new Student(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4), result.getString(5), result.getInt(6));
            }
        }catch(SQLException e) {
            
        }finally {
            
        }
        return student;
    }
    
    public boolean validateUser(String passToValidate, String comparablePas) {
        return passToValidate.equals(comparablePas) ? true : false;
    }
}
