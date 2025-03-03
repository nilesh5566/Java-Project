import java.util.Scanner;

public class BankAccount {
    /*
   ✅ Encapsulation: Account details are private and accessed through methods.
✅ User Input Handling: Uses Scanner to take input from the user.
✅ Menu System: Keeps running until the user chooses to exit.
✅ Error Handling: Prevents invalid deposits, withdrawals, and incorrect menu choices.
     */
      private String accountHolder;
      private String accountNumber;
      private double balance;
       // constructor

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    //  Amount Deposit Method
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("\n✅  Successfully Deposited : "+amount);
        }else{
            System.out.println("\n❌ Invalid deposit amount");
        }
    }
    // Withdrew method
    public void withdraw(double amount){
        if(amount>0 &&amount<=balance){
            balance-=amount;
            System.out.println("\n✅  Successfully Withdrawn : "+amount);
        }else{
            System.out.println("\n❌ Invalid Withdrawal amount or insufficient balance.");
        }
    }
    // Display Account Details
    public void  displayAccountDetails(){
        System.out.println("\n==========================");
        System.out.println("       BANK ACCOUNT ");
        System.out.println("==========================");
        System.out.println("👤 Account Holder: " + accountHolder);
        System.out.println("🏦 Account Number: " + accountNumber);
        System.out.println("💰 Balance: " + balance);
        System.out.println("==========================\n");
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n✨ Welcome to the Bank System ✨");
        System.out.println("Enter the Account Holder Name : ");
        String name= sc.nextLine();
        System.out.println("Enter Account Number : ");
        String accnumber= sc.nextLine();
        System.out.println("Enter the Initial Balance : ");
        double initialBalence= sc.nextDouble();

        // Creating an account
        BankAccount account=new BankAccount(name,accnumber,initialBalence);
        while(true){
            System.out.println("\n🔹 Choose an option:");
            System.out.println("1️⃣. View Account Details");
            System.out.println("2️⃣. Deposit Money");
            System.out.println("3️⃣. Withdraw Money");
            System.out.println("4️⃣. Exit");
            System.out.print("👉 Enter your choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter the deposit ammount : ");
                    double depositamount= sc.nextDouble();
                    account.deposit(depositamount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount : ");
                    double withdrawAmount= sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("\n\uD83D\uDE80 Thank you for using our Bank System. Goodbye! ✨\n");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
