import java.rmi.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String url = "rmi://localhost/Server";

            ServerIntf serverIntf = (ServerIntf) Naming.lookup(url);

            System.out.println("Enter num1 ");
            int a = sc.nextInt();

            System.out.println("Enter num2 ");
            int b = sc.nextInt();

            // System.out.println("Enter str1 ");
            // String str1 = sc.nextLine();

            // System.out.println("Enter str2 ");
            // String str2 = sc.nextLine();

            System.out.println("Add is " + serverIntf.addition(a, b));

            System.out.println("sub is " + serverIntf.substraction(a, b));

            System.out.println("mul is " + serverIntf.multiplication(a, b));

            System.out.println("div is " + serverIntf.division(a, b));

            System.out.println("square is " + serverIntf.square(a));

            System.out.println("squar root is " + serverIntf.squareroot(b));

            // System.out.println("Palindrome of string is ");
            // serverIntf.palindrome(str1);

            // System.out.println("String is equal or not");
            // serverIntf.isequalstring(str1, str2);

        } catch (Exception e) {
            System.out.println("Exception at Client " + e);
        }
        sc.close();
    }
}
