package coreJava.systemInterface;


import java.util.List;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Student;



public interface AttendingDAOI
{
    public int registerStudentToCourse(Student student, Course course) throws StudentRegistrationException;
    
    public List<Attending> getStudentCourse(int student_id);
}

