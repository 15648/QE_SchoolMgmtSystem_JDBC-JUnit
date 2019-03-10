package coreJava.unitTesting;

import static org.junit.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.categoryInterface.SampleDataTests;
import coreJava.dao.CourseDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Course;


@Category(SampleDataTests.class)
public class CourseDAOTest
{    
	
	private static List<Course> allCourses;
	private static List<Course> coursesByInst;
	private static CourseDAO cdao;
	
    @BeforeClass 
    public static void readFile() throws IOException {
    	allCourses = TestHelper.coursesHelper("getAllCoursesTestData.txt");
    	coursesByInst = TestHelper.coursesHelper("getCourseByInstructorTestData.txt");
    	cdao = new CourseDAO();
	} // End of @BeforeClass
    

    @Test
    public void getAllCoursesTest() throws ClassNotFoundException, IOException {
//    	assertNotNull(allCourses);
//    	assertNotNull(coursesByInst);
    	List<Course> allCoursesDB = cdao.getAllCourses();
    	for (Course cr : allCoursesDB) { // Outer Loop
    		for (Course c : allCourses) { // Inner Loop
    			if ( cr.getCourse_id()==c.getCourse_id()) {
    				assertThat(cr.getCourse_id(), equalTo(c.getCourse_id()));
    				assertThat(cr.getCourse_name(), equalTo (c.getCourse_name()));
    				assertThat(cr.getMinimum_gpa(), equalTo(c.getMinimum_gpa()));
    			}
    		}
    		
    	
    		
    	}
    }
    
    @Test
    public void getCourseByInstructorTest() throws ClassNotFoundException, IOException {

    }
    
    public void cleanUpTestWork(int id) throws ClassNotFoundException, IOException, SQLException {
    	TestHelper coursesHelper = new TestHelper();
    }
}