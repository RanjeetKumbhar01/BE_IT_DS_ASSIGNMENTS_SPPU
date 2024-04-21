
// client.java
import java.rmi.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Define the URL of the server
            String serverurl = "rmi://localhost/Server";
            // Look up for the remote object on the specified URL and cast it to ServerIntf
            // interface
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverurl);

            // Get user input for two numbers
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            // Display the entered numbers
            System.out.println("First Number is: " + num1);
            System.out.println("Second Number is: " + num2);
            System.out.println(" ------------ Results-----------");
            // Call the remote method 'add' on the server and display the result
            System.out.println("Addition is: " + serverIntf.add(num1, num2));
        } catch (Exception e) {
            // Handle any exceptions occurred during the execution
            System.out.println("Exception Occurred at Client!" + e.getMessage());
        }

        sc.close();
    }
}
