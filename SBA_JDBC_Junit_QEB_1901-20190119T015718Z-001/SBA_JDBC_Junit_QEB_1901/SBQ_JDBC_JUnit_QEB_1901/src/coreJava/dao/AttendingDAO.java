package coreJava.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Student;
import coreJava.systemInterface.AttendingDAOI;

public class AttendingDAO implements AttendingDAOI
{
    public int registerStudentToCourse(Student student, Course course) throws StudentRegistrationException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        String register = "INSERT INTO ATTENDING(course_id, student_id) VALUES(?,?)";
        OracleConnection Oracle = new OracleConnection();
        String[] ID = {"attending_id"};
        int newId = -1;
        if(student.getGpa() >= course.getMinimum_gpa())
        {    
            try
            {
                conn = Oracle.getConnection();
                stmt = conn.prepareStatement(register, ID);
                stmt.setInt(1, course.getCourse_id());
                stmt.setInt(2, student.getStudent_id());
                stmt.executeUpdate();
                
                result = stmt.getGeneratedKeys();
                if(result.next()) {
                    newId = result.getInt(1);
                }
            }
            catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                
            }
        }else {
            throw new StudentRegistrationException("\nDid not meet the minimum GPA requirement\nRegistration Denied");
        }
        return newId;
    }
    
    public List<Attending> getStudentCourse(int student_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Attending att = null;
        String GETSTUDENTCOURSES = "SELECT att.attending_id, cr.course_name, ins.full_name, ins.email FROM teaching te " + 
                "JOIN COURSE cr " + 
                "ON te.course_id = cr.course_id " + 
                "JOIN INSTRUCTOR ins " + 
                "ON te.instructor_id = ins.instructor_id " + 
                "JOIN attending att " + 
                "ON te.course_id = att.course_id " + 
                "WHERE att.student_id = ?";
        List<Attending> attList = null;
        OracleConnection Oracle = new OracleConnection();
        
        try
        {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETSTUDENTCOURSES);
            stmt.setInt(1, student_id);
            
            result = stmt.executeQuery();
            
            attList = new ArrayList<Attending>();
            while(result.next()) {
                att = new Attending();
                att.setAttending_id(result.getInt(1));
                att.setCourse_name(result.getString(2));
                att.setFull_name(result.getString(3));
                att.setEmail(result.getString(4));
                attList.add(att);
            }
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return attList;
    }
}
