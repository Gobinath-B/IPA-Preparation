package Bank;

import java.util.Scanner;

public class BankIPA {
    public static void main(String[] args){
        Bank[] arr = new Bank[3];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            int accN = in.nextInt();in.nextLine();
            String name  = in.nextLine();
            double bal =in.nextDouble();in.nextLine();
            arr[i]= new Bank(accN,name,bal);
        }
        int tarNo = in.nextInt();in.nextLine();
        double Amount = in.nextDouble();in.nextLine();
        int targNo = in.nextInt();in.nextLine();
        double amount = in.nextDouble();in.nextLine();
        double result1 = withdraw(arr,targNo,Amount);
        double result2 = deposit(arr,targNo,amount);
        if(result1 == -2){
            System.out.println("Account Number Not Found");
        }
        if(result1 == -1){
            System.out.println("Insufficient Balance");
        }
        if(result1>=0){
            System.out.println(result1);
        }

        if(result2 == -1){
            System.out.println("Account Number Not Found");
        }
        if(result2>=0){
            System.out.println(result2);
        }

    }
    static double withdraw(Bank[] bank,int accNo,double Amount){
        for (int i = 0; i < bank.length; i++) {
           if(bank[i].getAccountNumber() == accNo){
               if(bank[i].getBalance() >= Amount) {
                   double newB = bank[i].getBalance() - Amount;
                   bank[i].setBalance(newB);
                   return bank[i].getBalance();
               }
               else{
                   return -1;
               }
           }

        }
        return -2;
    }
    static double deposit (Bank[] arr, int accNo,double amount){
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i].getAccountNumber() == accNo){
               double temp = arr[i].getBalance() +amount;
               arr[i].setBalance(temp);
               return arr[i].getBalance();
            }
        }
        return -1;
    }

}

class Bank{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    Bank(int accNo,String accName, double balance){
        this.accountNumber = accNo;
        this.accountHolderName = accName;
        this.balance = balance;
    }

    int getAccountNumber(){
        return accountNumber;
    }

    String getAccountHolderName(){
        return accountHolderName;
    }
    double getBalance(){
        return balance;
    }

    void setAccountNumber(int accNo){
         this.accountNumber = accNo;
    }

    void setAccountHolderName(String name){
         this.accountHolderName =name;
    }
    void setBalance(double bal){
         this.balance = bal;
    }
}
