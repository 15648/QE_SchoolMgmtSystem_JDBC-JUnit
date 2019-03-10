package coreJava.systemInterface;

import java.io.IOException;
import java.util.List;

import coreJava.models.Course;


public interface CourseDAOI
{
    public List<Course> getAllCourses() throws ClassNotFoundException, IOException; 
    public List<Course> getCourseByInstructor(int instructor_id) throws ClassNotFoundException, IOException;
}
