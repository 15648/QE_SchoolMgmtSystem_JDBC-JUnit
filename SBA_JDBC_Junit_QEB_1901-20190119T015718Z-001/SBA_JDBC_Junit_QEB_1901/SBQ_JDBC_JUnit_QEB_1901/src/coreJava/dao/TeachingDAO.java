package coreJava.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.models.Teaching;
import coreJava.systemInterface.TeachingDAOI;

public class TeachingDAO implements TeachingDAOI
{
    public int assignInstructorToCourse(int course_id, int instructor_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        String register = "INSERT INTO TEACHING(course_id, instructor_id) VALUES(?,?)";
        OracleConnection Oracle = new OracleConnection();
        String[] ID = {"teaching_id"};
        int newId = -1;
        try
        {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(register, ID);
            stmt.setInt(1, course_id);
            stmt.setInt(2, instructor_id);
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
        return newId;
    }
    
    public List<Teaching> getIntructorsCourses() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Teaching tea = null;
        String GETALLINSTRUCTORCOURSES = "SELECT te.teaching_id, cr.course_name, cr.minimum_gpa, ins.full_name, ins.email FROM teaching te " + 
                "JOIN COURSE cr " + 
                "ON te.COURSE_ID = cr.COURSE_ID " + 
                "JOIN INSTRUCTOR ins " + 
                "ON te.INSTRUCTOR_ID = ins.INSTRUCTOR_ID";
        List<Teaching> teaList = null;
        OracleConnection Oracle = new OracleConnection();
        
        try
        {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETALLINSTRUCTORCOURSES);
            
            result = stmt.executeQuery();
            
            teaList = new ArrayList<Teaching>();
            while(result.next()) {
                tea = new Teaching();
                tea.setTeaching_id(result.getInt(1));
                tea.setCourse_name(result.getString(2));
                tea.setMinimum_gpa(result.getDouble(3));
                tea.setFull_name(result.getString(4));
                tea.setEmail(result.getString(5));
                teaList.add(tea);
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
        
        return teaList;
    }
}
