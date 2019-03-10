package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.categoryInterface.ModifyLevelTests;
import coreJava.categoryInterface.SampleDataTests;
import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.TeachingDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Instructor;
import coreJava.models.Teaching;
import coreJava.systemInterface.CourseDAOI;
import coreJava.systemInterface.TeachingDAOI;

public class TeachingDAOTest
{
	//Declare attributes
    private static TeachingDAO tdao;
    private int teaching_id;
    private String course_name;
    private double minimum_gpa;
    private String full_name;
    private String email;
    private static HashMap<Integer, Teaching> courseAssignments;
    
    @Before
    public void testPrep() throws NumberFormatException, IOException {
    	tdao = new TeachingDAO();
    	this.teaching_id = 10;
        this.course_name = "Physics";
        this.minimum_gpa = 3.4;
        this.full_name = "Ruthann Keener";
        this.email = "ruthann@hotmail.com";
    }
    
    @BeforeClass
    public static void readFile() throws FileNotFoundException {
    		Teaching teaching = null;
    		FileReader fr = null;
    		BufferedReader br = null;
    		String[] lineArray = null;
    		courseAssignments = new HashMap<>();
    		
    		fr = new FileReader("getInstructorCoursesTestData.txt");
    		
    		try
    		{
    			
    			br = new BufferedReader(fr);
    			br.readLine(); // Reads first line of column headers

    			String line = br.readLine();
    			while (line != null) {
    				lineArray = line.split("(  +)");
//    				for (int i = 0; i < lineArray.length; i++) {
    					teaching = new Teaching();
    					teaching.setTeaching_id(Integer.parseInt(lineArray[0]));
    					teaching.setCourse_name(lineArray[1]);
    					teaching.setMinimum_gpa(Double.parseDouble(lineArray[2]));
    					teaching.setFull_name(lineArray[3]);
    					teaching.setEmail(lineArray[4]);
    					courseAssignments.put(teaching.getTeaching_id(), teaching);
//    				}
    				line = br.readLine();
    			}
    			br.close();
    		} // End of try block
    		catch (IOException e) {
    			System.out.println("Not able to read file.");
    		} // End of catch block
    	} 
    
    @Category({TeachingDAOI.class})
    @Test
    public void assignInstructorToCourse() throws StudentRegistrationException, ClassNotFoundException, IOException, SQLException{
    	int assignId = tdao.assignInstructorToCourse(1, 1);
    	List<Teaching> instList = tdao.getIntructorsCourses();
    	boolean found = false;
    	for (Teaching t : instList) {
    		if (assignId == t.getTeaching_id()) {
    			found = true;
    			break;
    		}
    	}
    	assertTrue(found);
//    	assertThat(found, equalTo(true));
    }
   
    @Test
    public void getIntructorsCoursesTest() {
    	assertNotNull(courseAssignments);
    	List<Teaching> dbList = tdao.getIntructorsCourses();
    	
    	for (Teaching t : dbList) { // Outer loop
    		for (Integer i : courseAssignments.keySet()) { // Inner Loop
    			if (t.getTeaching_id()== i) {
    				assertThat(t.getCourse_name(), equalTo(courseAssignments.get(i).getCourse_name()));
    				assertThat(t.getMinimum_gpa(), equalTo(courseAssignments.get(i).getMinimum_gpa()));
    				assertThat(t.getFull_name(), equalTo(courseAssignments.get(i).getFull_name()));
    				assertThat(t.getEmail(), equalTo(courseAssignments.get(i).getEmail()));
    				
    					
    			}
    		}// End inner loop
    	} // End outer loop
    }
    
    public void cleanUpTestWork(int id) throws ClassNotFoundException, IOException, SQLException {
    	TestHelper deleteTeachingingRecord = new TestHelper();
    }
}
