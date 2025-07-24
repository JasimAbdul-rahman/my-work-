package xt.studentsapp;
import java.util.Scanner;
public class STUDENTS_APP { 
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("please enter your Age");
        int age = s.nextInt();
        
          System.out.println("please enter your Course");
        String course = s.nextLine();
        
          System.out.println("please enter your Number");
        String reg = s.nextLine();
        
        System.out.println("please enter your Name");
        String name = s.nextLine();
        
       UNDER_GRADUATE_STUDENT Std1 =new UNDER_GRADUATE_STUDENT(age,course,reg,name);
       Std1.getStudentDetails();
       
       
       if(Std1.isAbove18()){
           System.out.println("this is home to green parents");
       }
       else{
           System.out.println("This programm is designed for adults");
       }      
    }   }      
