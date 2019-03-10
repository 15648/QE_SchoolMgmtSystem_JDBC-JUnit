package coreJava.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import coreJava.dao.OracleConnection;
import coreJava.models.Attending;
import coreJava.models.Course;

public class TestHelper
{
    public static void deleteRecordHelper(String query, int idToDelete) throws ClassNotFoundException,
    IOException,SQLException {
  /*  	String deleteAttendingRecord = "delete from attending where attending_id = ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
    			"junit_sba", "junit_sba");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deleteAttendingRecord);
    		    System.out.printlns("Record deleted successfully");
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		}	
    	String deleteTeachingRecord = "delete from teaching where teaching_id = ?";
    	try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
    			"junit_sba", "junit_sba");
    			Statement stmt = conn.createStatement();) {
    			stmt.executeUpdate(deleteTeachingRecord);
    		    System.out.println("Record deleted successfully");
    	
    	 		} catch (SQLException e) {
    	 			e.printStackTrace();
    	 		}  */
    }
public Boolean removeUser(int userId) throws IOException, SQLException, ClassNotFoundException {
    // Declare variables
    Connection conn = null;
    PreparedStatement stmt = null;
    Integer updateResult = null;
    
    // Assign delete string to variable
    String deleteString = "delete from users where user_id = ?";
    
    // Create Oracle Connection class instance
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:orcl","junit_sba","junit_sba");
    // Begin try/catch block to query the database
    try
    {
        // Connect to database and assign query string to PreparedStatement object
        con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","junit_sba","junit_sba");
        stmt = conn.prepareStatement(deleteString);
        
        // Set query parameters (?)
        stmt.setInt(1, userId);
        // Run query and assign to ResultSet
        updateResult = stmt.executeUpdate();
    }
    catch (SQLException e)
    {
        System.out.println("Error: " + e.getMessage());
    }
    finally
    {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    if (updateResult > 0) {
        return true;
    }
    return false;
} // End removeUser() method
    
    public static List<Course> coursesHelper(String fileName) throws IOException {
    	Course c;
    	List<Course> courseList;
    	BufferedReader br;
    	FileReader fr = new FileReader(fileName);
    	
		br = new BufferedReader(fr);
		br.readLine(); // Reads first line of column headers

		String line = br.readLine();
		courseList = new ArrayList<Course>();
		
		while (line != null) {
			String [] lineArray = line.split("(\\s\\s+)");
				c = new Course();
				c.setCourse_id(Integer.parseInt(lineArray[0]));
				c.setCourse_name(lineArray[1]);
				c.setMinimum_gpa(Double.parseDouble(lineArray[2]));
				courseList.add(c);
			line = br.readLine();
		}
		br.close();
    	
		return courseList;
    	
    }
}
