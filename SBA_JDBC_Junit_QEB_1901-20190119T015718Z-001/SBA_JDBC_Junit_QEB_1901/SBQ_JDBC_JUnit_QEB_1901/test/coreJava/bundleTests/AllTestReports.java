package coreJava.bundleTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import coreJava.systemInterface.AttendingDAOI;
import coreJava.systemInterface.CourseDAOI;
import coreJava.systemInterface.InstructorDAOI;
import coreJava.systemInterface.TeachingDAOI;
import coreJava.unitTesting.AttendingDAOTest;
import coreJava.unitTesting.CourseDAOTest;
import coreJava.unitTesting.InstructorDAOTest;
import coreJava.unitTesting.TeachingDAOTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({AttendingDAOI.class, CourseDAOI.class, 
							InstructorDAOI.class, TeachingDAOI.class})
@Suite.SuiteClasses({AttendingDAOTest.class,CourseDAOTest.class, 
					InstructorDAOTest.class, TeachingDAOTest.class})

public class AllTestReports
{
	
}
