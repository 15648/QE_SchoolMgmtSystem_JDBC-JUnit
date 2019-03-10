package coreJava.unitTesting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import coreJava.categoryInterface.ParameterizedTests;
import coreJava.dao.StudentDAO;
import coreJava.models.Instructor;
import coreJava.models.Student;

@RunWith(Parameterized.class)
@Category({Parameterized.class})
public class StudentDAOParameterizedTest
{
		//Declare attributes
		private static StudentDAO sdao;
	 	private int student_id;
	    private String full_name;
	    private String email;
	    private double gpa;
	    private String pass;
	    private int student_role;
	    private Boolean expectedoutcome;

		/* Create the constructor. The order of arguments in the parentheses
		 * determines the parameter position in the two-dimensional Object arrays.
		 * Parameter1 = argument num1, Parameter2 = argument num2,
		 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
			public StudentDAOParameterizedTest(int student_id, String full_name,
			String email, double gpa, String pass, int student_role, Boolean expectedoutcome) {
			this.student_id = student_id;
			this.full_name = full_name;
			this.email = email;
			this.gpa = gpa;
			this.pass = pass;
			this.student_role = student_role;
			this.expectedoutcome = expectedoutcome;
		}

		/* Set up the parameters. The confirmation parameter is null and will
		 * be assigned in the actual test method depending on accuracy of
		 * the addition result. */

		@Parameters()
	        public static Collection<Object[]> data() {
	        return Arrays.asList(
	                	new Object[][] {
	                		{61, "Josephine Darakjy", "josephine_darakjy@darakjy.org", 2.9, "48116", -1, true },
	                		{62, "Lenna Paprocki", "lpaprocki@hotmail.com", 3.3, "99501", -1, true},
	                		{64, "Roxane Campain", "roxane@hotmail.com", 2.5, "99708", -1, true},
	                		{68, "Jani Biddy", "jbiddy@yahoo.com", 2.2, "98104W", -1, false}
	                		});
	    }

	    // Create the static class variable additionClass to run the test methods
	    @BeforeClass
	    public static void setUp() {
	    	sdao = new StudentDAO();
	    }

	    // Run the test
	    @Test
	    public void getStudentByEmailTest() throws ClassNotFoundException, IOException {
	    	Student student = sdao.getStudentByEmail(email);
	    	assertThat(full_name, equalTo(student.getFull_name()));
	    }
	    
	    @Test
	    public void validateUserTest() {
	    		    	
	    	String passToValidate = "true";
	    	String comparablePas = "true";
	    	
	    	boolean actual = sdao.validateUser(passToValidate,comparablePas);
	    	boolean expected = sdao.validateUser(passToValidate,comparablePas);
	    	Assert.assertEquals(actual,expected);
	    }
	}