import java.util.ArrayList;
import java.util.Scanner;

class Account{
   
    protected String accountHolderName;
    protected double balance;
    protected ArrayList<String> transection;
    
    Account( String accountHolderName, double balance){
        
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transection = new ArrayList<>();
    }

    public void deposit(double amount){
        if (amount>0) {
            balance = amount + balance;
            System.out.println("deposit:  " +amount+"rs");
            transection.add("Deposit:  " +amount);
        }else{
            System.out.println("Please Enter Write Amount");
        }
}
      

    public double getbalance(){
        return balance;
    }



public void withdraw(double amount){
 if(amount > 0.0 && amount<= balance){
    balance-=amount;
    System.out.println("withdrawn: " +amount+ "rs");
    transection.add("withdraw: " + amount);
 }else{
    System.out.println("Infucient Balance");
 }
   
}



 public void showTransection(){
System.out.println("History: " +accountHolderName);
for (String t: transection) {
    System.out.println(t+"rs");
    
}
 }
}



class SavingAccount extends Account{

    SavingAccount( String accountHolderName, double balance) {
        
        super(accountHolderName, balance);
    }


    @Override
        public  void withdraw (double amount){
 
  if (amount > balance) {
System.out.println("Cannot Withdrawn ammount more than balance");
    
  }else{
    super.withdraw(amount);
  }

        }
    }



    
public class BankAcountSimulation {


public static void main(String[] args) {
    
    
    System.out.println  (" ##WELLCOME TO OUR BANK## ");
    Scanner sc = new Scanner(System.in);


        System.out.println("Enter your Name");
        String Name = sc.nextLine();


     System.out.println(" Deposit Ammount to open ACCOUNT ");
     System.out.println("NOTE!: please deposit more then 100rs");


     double cash = sc.nextDouble();
    
     SavingAccount savingAccount = new SavingAccount(Name, cash);
  System.out.println("Account has been opened ");
  System.out.println("Name: " +Name+ "  Balance: " +cash+"rs");
     

     boolean Bank = true;

     while (Bank){

        System.out.println("Enter Your Choise ");
     System.out.println("Press 1 to DEPOSIT ");
     System.out.println("Press 2 to WITHDRAW ");
     System.out.println("Press 3 to CHECK BALANCE");
     System.out.println("Press 4 for HISTORY");
     System.out.println("Press 5 to EXIST");
       int choice = sc.nextInt();
       sc.nextLine();

switch (choice) {
    case 1:
   
   
    System.out.println("Enter Amount To Deposit");
    double amountToDeposit = sc.nextDouble();
    sc.nextLine();
        savingAccount.deposit(amountToDeposit);
        break;


        case 2:

        System.out.println("Enter Amount To Withdraw");
        double amountToWithdraw = sc.nextDouble();
        sc.nextLine();
        savingAccount.withdraw(amountToWithdraw);
        break;


        case 3:
        System.out.println("Your Balance is: " +savingAccount.getbalance()+"rs");
        break;

        case 4: 
       savingAccount.showTransection();
         break;
     
     
       case 5:
       System.out.println("ThankYou For Useing Our Service");
       Bank = false;
       break;
        
    default:
    System.out.println("ERROR!");
        break;
}

     }

}
    
}
    


    
