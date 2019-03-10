package coreJava.models;

public class Instructor
{
    private int instructor_id;
    private String full_name;
    private String email;
    private String speciality;
    private int admin_role;
    private String pass;
    
    /**
     * @param instructor_id
     * @param full_name
     * @param email
     * @param gpa
     * @param speciality
     * @param admin_role
     */
    public Instructor() {
        this.instructor_id = 0;
        this.full_name = "";
        this.email = "";
        this.speciality = "";
        this.admin_role = 0;
        this.pass = "";
    }
    /**
     * @param instructor_id
     * @param full_name
     * @param email
     * @param gpa
     * @param speciality
     * @param admin_role
     */
    public Instructor(int instructor_id, String full_name, String email, String speciality,
            int admin_role, String pass) {
        this.instructor_id = instructor_id;
        this.full_name = full_name;
        this.email = email;
        this.speciality = speciality;
        this.admin_role = admin_role;
        this.pass = pass;
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
     * @return the instructor_id
     */
    public int getInstructor_id()
    {
        return instructor_id;
    }
    /**
     * @param instructor_id the instructor_id to set
     */
    public void setInstructor_id(int instructor_id)
    {
        this.instructor_id = instructor_id;
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
    /**
     * @return the speciality
     */
    public String getSpeciality()
    {
        return speciality;
    }
    /**
     * @param speciality the speciality to set
     */
    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }
    /**
     * @return the admin_role
     */
    public int getAdmin_role()
    {
        return admin_role;
    }
    /**
     * @param admin_role the admin_role to set
     */
    public void setAdmin_role(int admin_role)
    {
        this.admin_role = admin_role;
    }
}
