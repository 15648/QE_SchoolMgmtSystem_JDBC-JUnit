package coreJava.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.models.Instructor;
import coreJava.systemInterface.InstructorDAOI;

public class InstructorDAO implements InstructorDAOI
{
    public List<Instructor> getAllInstructors() throws ClassNotFoundException, IOException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Instructor> instructorList = null;
        Instructor instructor = null;
        OracleConnection Oracle = new OracleConnection();
        String GETALLINSTRUCTORS = "SELECT * FROM INSTRUCTOR";
        try {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETALLINSTRUCTORS);
            result = stmt.executeQuery();
            
            instructorList = new ArrayList<Instructor>();
            while(result.next()) {
                instructor = new Instructor(result.getInt(1), result.getString(2), 
                		result.getString(3), result.getString(4), 
                		result.getInt(5), result.getString(6));
                instructorList.add(instructor);
            }
        }catch(SQLException e) {
            
        }finally {
            
        }
        return instructorList;
    }
    public Instructor getInstructoByEmail(String email) throws ClassNotFoundException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Instructor instructor = null;
        OracleConnection Oracle = new OracleConnection();
        String GETALLINSTRUCTORS = "SELECT * FROM INSTRUCTOR WHERE EMAIL = ?";
        try {
            conn = Oracle.getConnection();
            stmt = conn.prepareStatement(GETALLINSTRUCTORS);
            stmt.setString(1, email);
            result = stmt.executeQuery();
            
            if(result.next()) {
                instructor = new Instructor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6));
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            
        }
        return instructor;
    }
    public String validateUser(Instructor ins, String comparablePas) {
        String whichInstructor = "";
        if(ins == null ) {
            whichInstructor = "Wrong Credentials";
        }
        else if(ins.getAdmin_role() == 1 && comparablePas.equals(ins.getPass())) {
            whichInstructor = "Admin";
        }else if(ins.getAdmin_role() == 0 && comparablePas.equals(ins.getPass())) {
            whichInstructor = "Instructor";
        }else if(ins.getAdmin_role() == -1 || !comparablePas.equals(ins.getPass())) {
            whichInstructor = "Wrong Credentials";
        }
        return whichInstructor;
    }
}
