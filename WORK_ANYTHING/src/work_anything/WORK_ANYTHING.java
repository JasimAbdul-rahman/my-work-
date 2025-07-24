/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package work_anything;

/**
 *
 * @author HP
 */
import java.util.Scanner;
public class WORK_ANYTHING {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of num1 ");
        int num1 = input.nextInt();
        System.out.println("Enter the value of num2");
        int num2 = input.nextInt();
        System.out.println("Hello the max value between num1 and num2 is "+ max(num1,num2));
    }
    public static int max(int num1,int num2){
    int result;
    if(num1>num2){
        result =  num1;
    }
    else{
        result = num2;
    }
    return result;
    }
}  

