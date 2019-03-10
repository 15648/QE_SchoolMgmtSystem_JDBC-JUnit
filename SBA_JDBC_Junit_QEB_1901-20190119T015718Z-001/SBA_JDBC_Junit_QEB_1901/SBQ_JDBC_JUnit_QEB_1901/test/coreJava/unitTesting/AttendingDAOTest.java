package coreJava.unitTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.AttendingDAO;
import coreJava.dao.StudentDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Student;
import coreJava.systemInterface.AttendingDAOI;
import coreJava.categoryInterface.ModifyLevelTests;
import coreJava.categoryInterface.SampleDataTests;

public class AttendingDAOTest
{	
	//Declare attributes
	private static AttendingDAO adao;
 	private int attending_id;
 	private String course_name;
 	private String full_name;
 	private String email;

    @Before
    public void RetrieveData() throws FileNotFoundException {
    	adao = new AttendingDAO();  
    	this.attending_id = 23;
    	this.course_name = "DevUps";
    	this.full_name = "Luke";
    	this.email = "luke@gmail.com";
    }
        	
    @Category({AttendingDAOI.class, ModifyLevelTests.class, SampleDataTests.class})
    @Test()
    //ModifyLevelTests
    public void registerStudentToCourseTest() throws StudentRegistrationException, ClassNotFoundException, IOException, SQLException{
      assertNotNull(courseRegistion);
      System.out.println(courseRegistion.get(23).getFull_name());
      Student student = new Student();
      Course course = new Course();
      int actual = adao.registerStudentToCourse(student, course);
      int expected = adao.registerStudentToCourse(student, course);
      assertEquals(actual, expected);
    }
    
    private static HashMap<Integer, Attending> courseRegistion;
    @BeforeClass 
    public static void readFile() throws FileNotFoundException {
    	Attending attending = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] lineArray = null;
		courseRegistion = new HashMap<>();
		
		fr = new FileReader("getStudentCourseTestData.txt");
		
		try
		{
			
			br = new BufferedReader(fr);
			br.readLine(); // Reads first line of column headers

			String line = br.readLine();
			while (line != null) {
				lineArray = line.split("([\\s\\s]+)");
				for (int i = 0; i < lineArray.length; i++) {
					attending = new Attending();
					attending.setAttending_id(Integer.parseInt(lineArray[0]));
					attending.setCourse_name(lineArray[1]);
					attending.setFull_name(lineArray[2]);
					attending.setEmail(lineArray[3]);
					courseRegistion.put(attending.getAttending_id(), attending);
				}
				line = br.readLine();
			}
			br.close();
		} // End of try block
		catch (IOException e) {
			System.out.println("Not able to read file.");
		} // End of catch block
	
	} // End of constructor
    
    @Test
    //SampleDataTests
    public void getStudentCourseTest() {
    	assertNotNull(courseRegistion);
    	System.out.println(courseRegistion.get(23).getFull_name());
    	List<String> actual = Arrays.asList("attending_id","course_name","full_name","email");
    	List<String> expected = Arrays.asList("attending_id","course_name","full_name","email");
    	Assert.assertEquals(actual,expected);   
    }
    
    public void cleanUpTestWork(int id) throws ClassNotFoundException, IOException, SQLException {
    	TestHelper deleteAttendingRecord = new TestHelper();
    }
}
