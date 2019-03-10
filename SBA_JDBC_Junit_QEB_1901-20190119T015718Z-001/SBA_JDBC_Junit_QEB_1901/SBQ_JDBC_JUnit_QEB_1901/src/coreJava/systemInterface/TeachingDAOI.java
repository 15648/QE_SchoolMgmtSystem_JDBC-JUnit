package coreJava.systemInterface;


import java.util.List;

import coreJava.models.Teaching;

public interface TeachingDAOI
{
    public int assignInstructorToCourse(int course_id, int instructor_id);
    
    public List<Teaching> getIntructorsCourses();
}
