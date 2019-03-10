package coreJava.systemInterface;

import java.io.IOException;
import java.util.List;

import coreJava.models.Instructor;

public interface InstructorDAOI
{
    public List<Instructor> getAllInstructors() throws ClassNotFoundException, IOException;
    public Instructor getInstructoByEmail(String email) throws ClassNotFoundException, IOException;
}
