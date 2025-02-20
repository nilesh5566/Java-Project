import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("\n Enter the first number : ");
            double num1= sc.nextDouble();
            System.out.println(" Enter teh operator (+,-,*,/,%) : ");
            char operator=sc.next().charAt(0);
            System.out.println(" Enter the second number : ");
            double num2= sc.nextDouble();
            double result=0;
            switch (operator){
                case '+': result=num1+num2; break;
                case '-': result=num1-num2; break;
                case '*': result=num1*num2; break;
                case '/':
                    if(num2>0) result=num1/num2;
                    else System.out.println(" Error : Division by zero !");
                    break;
                case '%': result=num1%num2; break;
                default:
                    System.out.println(" Not valid operater ");

            }
            System.out.println( "  Result : "+ result);
            System.out.println("  Do you want to perform  another calculation (yes/no) : ");
            String  choice=sc.next();
            if(!choice.equalsIgnoreCase("yes")) break;;

        }
        sc.close();
    }
}
