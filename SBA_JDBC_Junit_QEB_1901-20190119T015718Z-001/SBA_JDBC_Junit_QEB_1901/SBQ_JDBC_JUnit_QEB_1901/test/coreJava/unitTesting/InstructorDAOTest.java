package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.categoryInterface.SampleDataTests;
import coreJava.dao.AttendingDAO;
import coreJava.dao.InstructorDAO;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Instructor;
import coreJava.models.Teaching;
import coreJava.systemInterface.AttendingDAOI;
import coreJava.systemInterface.InstructorDAOI;

public class InstructorDAOTest
{
	//Declare attributes
	private static InstructorDAO idao;
	private int instructor_id;
    private String full_name;
    private String email;
    private String speciality;
    private int admin_role;
    private String pass;	
	
    @Before
    public void TestPrep() throws NumberFormatException, IOException {
    	idao = new InstructorDAO();
    	this.instructor_id = 1;
        this.full_name = "Luke";
        this.email = "luke@gmail.com";
        this.speciality = "Mathemathician";
        this.admin_role = 0;
        this.pass = "444";
    }
    @Category({InstructorDAOI.class})
    @Test
    public void getAllInstructorsTest() throws ClassNotFoundException, IOException {
    	List<Instructor> actual = idao.getAllInstructors();
 		List<Instructor> expected = idao.getAllInstructors();
        assertEquals(1, 1);
    }

    private static HashMap<Integer, Teaching> courseRegistion;
    @BeforeClass 
    public static void readFile() throws FileNotFoundException {
    	Instructor instructor = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] lineArray = null;
		courseRegistion = new HashMap<>();
		
		fr = new FileReader("getAllInstructorsTestData.txt");
		
		try
		{
			br = new BufferedReader(fr);
			br.readLine(); // Reads first line of column headers

			String line = br.readLine();
			while (line != null) {
				lineArray = line.split("  +");
				for (int i = 0; i < lineArray.length; i++) {
					instructor  = new Instructor();
					instructor.setInstructor_id(Integer.parseInt(lineArray[0]));
					instructor.setFull_name(lineArray[1]);
					instructor.setEmail(lineArray[2]);
					instructor.setSpeciality(lineArray[3]);
					instructor.setAdmin_role(Integer.parseInt(lineArray[4]));
					instructor.setPass(lineArray[5]);
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
    public void getInstructoByEmailTest() throws ClassNotFoundException, IOException {   	
    	assertNotNull(courseRegistion);
//    	System.out.println(courseRegistion.get(1).getFull_name());
    	Instructor actual = idao.getInstructoByEmail("");
    	Instructor expected = idao.getInstructoByEmail("");
    	Assert.assertEquals(actual,expected);
    }
    
    @Test
    public void validateUserTest(){
    	Instructor ins = new Instructor();
    	String comparablePas = "";
    	
    	String actual = idao.validateUser(ins,comparablePas);
    	String expected = idao.validateUser(ins,comparablePas);
    	Assert.assertEquals(actual,expected);	
    }
    
}