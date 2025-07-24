package com.mycompany.loan_app;
import java.util.Date;

public class Loan {
    double annualInterestRate;
    int numberofyears;
    double loanamount;
    Date loanDate;
    
    public Loan(){
        this.annualInterestRate = 2.5;
        this.numberofyears = 1;
        this.loanamount = 10000;
        this.loanDate = new Date();
    }
    
    public Loan (double rate,int num,double loan){
    annualInterestRate =rate;
    numberofyears =num;
    loanamount= loan;
    
    }
   public double getannualInterestRate() {
       return annualInterestRate;
   }
   
   public void setannuslInterestRate(double annualInterestRate){
       this.annualInterestRate = annualInterestRate;
   }
   
 public int getnumberofyears() {
       return numberofyears;
   }
   
   public void setnumberofyears(int numberofyears){
       this.numberofyears = numberofyears;
   }  
   
   
 public double getloanamount() {
       return loanamount;
   }
   
   public void setloanamount(double loanamount){
       this.loanamount = loanamount;
   }  
   
  public double getMonthlyPayment() {
       return loanamount;
   }
   
   public void getMonthlyPayment(double loanamount){
       this.loanamount = loanamount;
       
   }      
   
public void getloandetails(){
    System.out.println("Number of years are"+numberofyears);
    System.out.println("Your loan amount is"+loanamount);
    System.out.println("Enter the date"+ loanDate );
}

}
