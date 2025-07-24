
package xt.studentsapp;


public class UNDER_GRADUATE_STUDENT {
    int Age;
     String name;
     String course;
     String regNo;
    
    public UNDER_GRADUATE_STUDENT(int age,String regs,String Course,String Name){
        Age = age;
        regNo = regs;
        name = Name;
        course = Course;
    }
   
    /**
     *
     */
    public void getStudentDetails() {
          System.out.println("Your full names are"+name+"aged"+Age);
         System.out.println("Your course details are"+course);
          System.out.println("Your registration number is"+regNo);
    }
  
    /**
     *
     * @return
     */
    public boolean isAbove18() {
      return Age>=18;  
    }
}
