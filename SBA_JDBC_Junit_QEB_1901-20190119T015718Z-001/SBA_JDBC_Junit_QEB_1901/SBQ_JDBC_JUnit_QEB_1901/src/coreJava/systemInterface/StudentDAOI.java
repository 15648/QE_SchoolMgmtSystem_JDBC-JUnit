package coreJava.systemInterface;

import java.io.IOException;

import coreJava.models.Student;

public interface StudentDAOI
{
    public Student getStudentByEmail(String email) throws ClassNotFoundException, IOException;
}
