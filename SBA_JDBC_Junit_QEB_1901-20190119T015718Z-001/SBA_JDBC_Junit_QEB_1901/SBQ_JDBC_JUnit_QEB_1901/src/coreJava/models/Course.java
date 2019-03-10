package coreJava.models;

public class Course
{
    private int course_id;
    private String course_name;
    private double minimum_gpa;
    /**
     * @param course_id
     * @param course_name
     * @param capability
     * @param minimun_gpa
     */
    public Course() {
        this.course_id = 0;
        this.course_name = "";
        this.minimum_gpa = 0.0;
    }
    /**
     * @param course_id
     * @param course_name
     * @param capability
     * @param minimun_gpa
     */
    public Course(int course_id, String course_name, double minimun_gpa) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.minimum_gpa = minimun_gpa;
    }
    /**
     * @return the course_id
     */
    public int getCourse_id()
    {
        return course_id;
    }
    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(int course_id)
    {
        this.course_id = course_id;
    }
    /**
     * @return the course_name
     */
    public String getCourse_name()
    {
        return course_name;
    }
    /**
     * @param course_name the course_name to set
     */
    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }
    /**
     * @return the minimun_gpa
     */
    public double getMinimum_gpa()
    {
        return minimum_gpa;
    }
    /**
     * @param minimun_gpa the minimun_gpa to set
     */
    public void setMinimum_gpa(double minimun_gpa)
    {
        this.minimum_gpa = minimun_gpa;
    }
}
