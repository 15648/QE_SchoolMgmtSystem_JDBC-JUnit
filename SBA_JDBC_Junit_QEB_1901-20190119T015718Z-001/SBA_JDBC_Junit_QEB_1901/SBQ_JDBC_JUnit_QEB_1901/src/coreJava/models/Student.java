package coreJava.models;

public class Student
{
    private int student_id;
    private String full_name;
    private String email;
    private double gpa;
    private String pass;
    private int student_role;

    public Student() {
        this.student_id = 0;
        this.full_name = "";
        this.email = "";
        this.gpa = 0.0;
        this.pass = "";
        this.student_role = 0;
    }
    /**
     * @param student_id
     * @param full_name
     * @param email
     * @param gpa
     */
    public Student(int student_id, String full_name, String email, double gpa, String pass, int student_role) {
        this.student_id = student_id;
        this.full_name = full_name;
        this.email = email;
        this.gpa = gpa;
        this.pass = pass;
        this.student_role = student_role;
    }
    
    
    /**
     * @return the student_role
     */
    public int getStudent_role()
    {
        return student_role;
    }
    /**
     * @param student_role the student_role to set
     */
    public void setStudent_role(int student_role)
    {
        this.student_role = student_role;
    }
    /**
     * @return the pass
     */
    public String getPass()
    {
        return pass;
    }
    /**
     * @param pass the pass to set
     */
    public void setPass(String pass)
    {
        this.pass = pass;
    }
    /**
     * @return the student_id
     */
    public int getStudent_id()
    {
        return student_id;
    }

    /**
     * @param student_id the student_id to set
     */
    public void setStudent_id(int student_id)
    {
        this.student_id = student_id;
    }

    /**
     * @return the full_name
     */
    public String getFull_name()
    {
        return full_name;
    }

    /**
     * @param full_name the full_name to set
     */
    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the gpa
     */
    public double getGpa()
    {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }
    
    
    
}
