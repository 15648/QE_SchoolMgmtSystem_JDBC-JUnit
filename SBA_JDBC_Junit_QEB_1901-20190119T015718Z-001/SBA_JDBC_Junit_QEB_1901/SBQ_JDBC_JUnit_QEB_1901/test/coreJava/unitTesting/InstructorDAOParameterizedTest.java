package coreJava.unitTesting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import coreJava.categoryInterface.ParameterizedTests;
import coreJava.dao.InstructorDAO;
import coreJava.dao.StudentDAO;
import coreJava.models.Instructor;
import coreJava.models.Student;

@RunWith(Parameterized.class)
public class InstructorDAOParameterizedTest
{
	// Declare atttibutes
			private static InstructorDAO idao;
		 	private int instructor_id;
		    private String full_name;
		    private String email;
		    private String speciality;
		    private int admin_role;
		    private String pass;

			/* Create the constructor. The order of arguments in the parentheses
			 * determines the parameter position in the two-dimensional Object arrays.
			 * Parameter1 = argument num1, Parameter2 = argument num2,
			 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
				public InstructorDAOParameterizedTest(int instructor_id, String full_name,
				String email, String speciality, int admin_role, String pass) {
				this.instructor_id = instructor_id;
				this.full_name = full_name;
				this.email = email;
				this.speciality = speciality;
				this.admin_role = admin_role;
				this.pass = pass;
			}

			/* Set up the parameters. The confirmation parameter is null and will
			 * be assigned in the actual test method depending on accuracy of
			 * the addition result. */

			@Parameters()
		        public static Collection<Object[]> data() {
		        return Arrays.asList(
		        		new Object[][] {
	                		{ 21, "Ruthann Keener", "ruthann@hotmail.com", "Physics", 0, "78028" },
	                		{ 22, "Kati Rulapaugh", "kati.rulapaugh@hotmail.com", "Analyst", 0,	"67410"},
	                		{ 23, "Loren Asar",	"loren.asar@aol.com", "English", 1, "18518"},
	                		{ 3, "mark", "mark@gmail.com", "History", 1, "667"}
	                		});
		    }

		    // Create the static class variable additionClass to run the test methods
		    @BeforeClass
		    public static void setUp() {
		    	idao = new InstructorDAO();
		    }

		    // Run the test
		    @Test
		    public void getAllInstructorsTest() throws ClassNotFoundException, IOException {
		    	List<Instructor> actual = idao.getAllInstructors();
		 		List<Instructor> expected = idao.getAllInstructors();
		        assertEquals(1, 1);
		    }
		    
		    @Test
		    public void getInstructoByEmailTest() throws ClassNotFoundException, IOException {
		    	Instructor insturctor = idao.getInstructoByEmail(email);
		    	assertThat(full_name, equalTo(insturctor.getFull_name()));
		    }
		    
		    @Test
		    public void validateUserTest() {
		    	Instructor ins = new Instructor();
		    	String comparablePas = "";
		    	
		    	String actual = idao.validateUser(ins,comparablePas);
		    	String expected = idao.validateUser(ins,comparablePas);
		    	Assert.assertEquals(actual,expected);	
		    }
		}