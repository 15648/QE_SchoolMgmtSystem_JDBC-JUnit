package coreJava.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.models.Course;
import coreJava.systemInterface.CourseDAOI;
public class CourseDAO implements CourseDAOI
{
    public List<Course> getAllCourses() throws ClassNotFoundException, IOException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Course> courseList = null;
        Course course = null;
        OracleConnection Oracle = new OracleConnection();
        String GETALLINSTRUCTORS = "SELECT * FROM course";
        
        try {
            
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETALLINSTRUCTORS);
            result = stmt.executeQuery();
            
            courseList = new ArrayList<Course>();
            while(result.next()) {
                course = new Course(result.getInt(1), result.getString(2), result.getDouble(3));
                courseList.add(course);
            }
        }catch(SQLException e) {
            
        }finally {
            
        }
        return courseList;
    }
    
    
    public List<Course> getCourseByInstructor(int instructor_id) throws ClassNotFoundException, IOException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Course course = null;
        List<Course> courseList = null;
        OracleConnection Oracle = new OracleConnection();
        String GETCOURSEBYINSTRUCTOR = "SELECT cr.course_id, cr.course_name, cr.minimum_gpa FROM course cr " + 
                "JOIN teaching tc ON cr.COURSE_ID = tc.COURSE_ID " + 
                "WHERE tc.INSTRUCTOR_ID = ?";
        try {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETCOURSEBYINSTRUCTOR);
            stmt.setInt(1, instructor_id);
            result = stmt.executeQuery();
            courseList = new ArrayList<Course>();
            while(result.next()) {
                course = new Course(result.getInt(1), result.getString(2), result.getDouble(3));
                courseList.add(course);
            }
        }catch(SQLException e) {
            
        }finally {
            
        }
        return courseList;
    }
    
}
