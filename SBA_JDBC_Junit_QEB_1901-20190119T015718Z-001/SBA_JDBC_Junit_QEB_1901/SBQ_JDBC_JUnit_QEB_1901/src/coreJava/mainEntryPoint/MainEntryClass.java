package coreJava.mainEntryPoint;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.AttendingDAO;
import coreJava.dao.CourseDAO;
import coreJava.dao.InstructorDAO;
import coreJava.dao.StudentDAO;
import coreJava.dao.TeachingDAO;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Instructor;
import coreJava.models.Student;
import coreJava.models.Teaching;

public class MainEntryClass
{
//    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        InstructorDAO InstDAO = new InstructorDAO();
//        
//        List<Instructor> InsList = InstDAO.getAllInstructors();
//        Instructor si = InstDAO.getInstructoByEmail("luke@gmail.com");
//        System.out.println(si.getFull_name());
//        for(Instructor ins: InsList){
//            System.out.println(ins.getEmail());
//        }
        
//        StudentDAO stuDAO = new StudentDAO();
//        Student stu = stuDAO.getStudentByEmail("b@gmail.com");
//        System.out.println(stu.getFull_name());
        
        
//      CourseDAO CouDAO = new CourseDAO();
//      
//      List<Course> CouList = CouDAO.getAllCourses();
//      for(Course ins: CouList){
//          System.out.println(ins.getCourse_name());
//      }
//      Course c = CouDAO.getCourseByInstructor(1);
//      System.out.println(c.getCourse_name());
        
//        AttendingDAO attDAO = new AttendingDAO();
//        int isID = attDAO.registerStudentToCourse(1, 1);
//        System.out.println(isID);
//        List<Attending> attList = attDAO.getStudentCourse(3);
//        
//        for(Attending att : attList) {
//            System.out.println(att.getEmail());
//        }
        
//        TeachingDAO teaDAO = new TeachingDAO();
//        List<Teaching> teaList = teaDAO.getIntructorsCourses();
//        for(Teaching tea : teaList) {
//            System.out.println(tea.getCourse_name());
//            System.out.println(tea.getFull_name());
//            System.out.println("============================");
//        }
//        int newId = teaDAO.assignInstructorToCourse(21, 1);
//        System.out.println(newId);
//    }
    
    public void allIntructors() throws ClassNotFoundException, IOException {
        InstructorDAO insDAO = new InstructorDAO();
        
        List<Instructor> allIns = insDAO.getAllInstructors();
        System.out.printf("\nInstructors:\n======================================================================\n");
        System.out.printf("%-3s INTRUCTOR NAME \t INSTRUCTOR EMAIL \t INSTRUCTOR SPECIALITY\n","ID");
        
        for(Instructor insAGN : allIns) {
            System.out.printf("%-3s %-20s %-23s %s\n",insAGN.getInstructor_id(),  insAGN.getFull_name(), insAGN.getEmail(), insAGN.getSpeciality());
        }
        
    }
    
    public void allCourse() throws ClassNotFoundException, IOException {
        CourseDAO coDAO = new CourseDAO();
        
        List<Course> allCo = coDAO.getAllCourses();
        System.out.printf("\nCourses:\n===============================================\n");
        System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
        
        for(Course coAGN : allCo) {
            System.out.printf("%-3s %-20s %s\n",coAGN.getCourse_id(),  coAGN.getCourse_name(), coAGN.getMinimum_gpa());
        }
        
    }
    
    public void allCoursesWithInstructor() {
        TeachingDAO teaDAO = new TeachingDAO();
        List<Teaching> teaList = teaDAO.getIntructorsCourses();
        System.out.printf("COURSE NAME \t COURSE MINIMUN GPA \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n\n");
        for(Teaching teaAGN : teaList) {
            System.out.printf("%-16s %-23s %-23s %s\n", teaAGN.getCourse_name(), teaAGN.getMinimum_gpa(), 
                    teaAGN.getFull_name(), teaAGN.getEmail());
        }
    }
    
    public void StudentCourses(List<Attending> attList) {
        int counter = 1;
        System.out.printf("\nMy Classes:\n");
        System.out.printf("%-3s COURSE NAME \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n", "#");
        for(Attending att : attList) {
            System.out.printf("%-3s %-20s %-23s %s\n", counter, att.getCourse_name(), att.getFull_name(), att.getEmail());
            counter++;
            
        }
    }
    
    public void allCourses(List<Course> coList) {
        int counter = 0;
        System.out.printf("\nAll Courses:\n");
        System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
        for(Course co : coList) {
            System.out.printf("%-3s %-20s %s\n", counter + 1, co.getCourse_name(), co.getMinimum_gpa());
            counter++;
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, IOException, StudentRegistrationException {
        boolean quit = false;
        Scanner reader = new Scanner(System.in);
        MainEntryClass mainObj = new MainEntryClass();
        int InsOrStu = -1;
        Instructor ins = null;  InstructorDAO insDAO = null;   String insROLE = "";
        
        
        Student stu = null;     StudentDAO stuDAO = null;
        
        CourseDAO coDAO = null;
        
        AttendingDAO attDAO = null;
        
        TeachingDAO teaDAO = null;
        
        String email = "";
        String password = "";
        
        while(!quit) {
            System.out.println("Are you a(n)\n1. Instructor \n2. Student \n3. quit \nPlease, enter 1, 2 or 3 \n");
            InsOrStu = reader.nextInt();
            if(InsOrStu == 1) {
                boolean logout = false;
                while(!logout) {
                    reader.nextLine();
                    System.out.println("Enter Your Email:\n");
                    email = reader.next();
                    System.out.println("Enter Your Password:\n");
                    password = reader.next();
                    insDAO = new InstructorDAO();
                    
                    //This is the missing line of code:
                    //*********************************
                    ins = insDAO.getInstructoByEmail(email);
                    //*********************************
                    
                    insROLE = insDAO.validateUser(ins, password);
                    
                    
                    if("Admin".equals(insROLE)) {
                        teaDAO = new TeachingDAO();
                        mainObj.allCoursesWithInstructor();
                        String out = "-1";
                        while(!out.equals("2")) {
                            System.out.printf("\n\n");
                            System.out.println("1. Assign Instructor to Course");
                            System.out.println("2. Logout");
                            out = reader.next();  
                            
                            if(out.equals("1")) {
                                int instructor_id = -1;
                                int course_id = -1;
                                mainObj.allIntructors();
                                System.out.println("\nWhat Instructor?\n");
                                instructor_id = reader.nextInt();
                                mainObj.allCourse();
                                System.out.println("\nWhich Course?\n");
                                course_id = reader.nextInt();
                                int assignId =  teaDAO.assignInstructorToCourse(course_id, instructor_id);
                                if(assignId != -1) {
                                    System.out.println("\n -->Instructor Assigned<--\nNew Record Id: "+ assignId+"\n");
                                }
                                mainObj.allCoursesWithInstructor();
                            }
                        }
                        System.out.printf("\n\n");
                        logout = true;
                    }else if("Instructor".equals(insROLE)) {
                        coDAO = new CourseDAO();
                        List<Course> coList = coDAO.getCourseByInstructor(ins.getInstructor_id());
                        System.out.printf("%-20s %s\n","COURSE NAME", "COURSE MINIMUN GPA");
                        for(Course insCO : coList) {
                            System.out.printf("%-20s %s\n", insCO.getCourse_name(), insCO.getMinimum_gpa());
                        }
                        String out = "-1";
                        while(!out.equals("1")) {
                            System.out.println("1. Logout");
                            out = reader.next();  
                        }
                        ins = null;
                        logout = true;
                    }else if("Wrong Credentials".equals(insROLE)) {
                        System.out.println(insROLE);
                        continue;
                    }
                
                }
                
            }else if(InsOrStu == 2) {
                stuDAO = new StudentDAO();
                attDAO = new AttendingDAO();
                boolean logout = false;
                while(!logout) {
                    System.out.println("Enter Your Email:\n");
                    email = reader.next();
                    System.out.println("Enter Your Password:\n");
                    password = reader.next();
                    
                    List<Attending> attList = null;
                    stu = stuDAO.getStudentByEmail(email);
                    
                    if(stu != null && stu.getStudent_role() == -1 && stuDAO.validateUser(stu.getPass(), password)) {
                        
                        String classesTo = "";
                        while(!classesTo.equals("2")) {
                            attList = attDAO.getStudentCourse(stu.getStudent_id());
                            mainObj.StudentCourses(attList);
                            System.out.printf("\n1. Register to Class");
                            System.out.printf("\n2. Logout\n");
                            classesTo = reader.next();
                            if(classesTo.equals("1")) {
                                coDAO = new CourseDAO();
                                attDAO = new AttendingDAO();
                                List<Course> coList = coDAO.getAllCourses();
                                mainObj.allCourses(coList);
                                System.out.println("\nWhich Course?\n");
                                int course_idForStudent = reader.nextInt();
                                attDAO.registerStudentToCourse(stu, coList.get(course_idForStudent - 1));
                                
                                classesTo = "";
                            }
                        }
                        logout = true;
                    }else {
                        System.out.printf("\nWrong Credentials\n");
                        continue;
                    }
                }
                
            }else if(InsOrStu == 3) {
                quit = true;
            }
        }
        reader.close();
    }
}
