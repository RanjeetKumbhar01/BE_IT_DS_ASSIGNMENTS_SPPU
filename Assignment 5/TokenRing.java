/*
To run
javac TokenRing.java
java TokenRing
*/

import java.util.*;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Getting the number of nodes in the ring
        System.out.print("Enter the number of nodes you want in the ring: ");
        int n = sc.nextInt();

        // Displaying the ring formation
        System.out.println("Ring Formed is as below: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("0 (loop back to Node 0)");
        System.out.println("Note: Initialy Token is at Node 0");

        int choice = 0;
        int token = 0;
        int sender, receiver;
        do {
            // Getting sender, receiver, and data
            // validation of sender
            while (true) {
                System.out.print("\nEnter Sender: ");
                sender = sc.nextInt();
                if (sender < 0 || sender >= n)
                    System.out.print("\nEnter valid senter between " + 1 + " & " + (n - 1));
                else
                    break;
            }

            // validation of receiver
            while (true) {
                System.out.print("\nEnter Receiver: ");
                receiver = sc.nextInt();
                if (receiver < 0 || receiver >= n)
                    System.out.print("\nEnter valid receiver between " + 1 + " & " + (n - 1));
                else
                    break;
            }

            System.out.print("\nEnter Data to Send: ");
            int data = sc.nextInt();
            int i = 0;
            // System.out.println(" " + sender);
            System.out.println("\nSender is " + sender + " and Sending Data is " + data);

            // Token Passing
            System.out.println("\nToken Passing: [Previous Node -> Next Node]");
            for (i = token; i != sender; i = (i + 1) % n) {
                System.out.print(" " + i + " ->");
            }
            System.out.println(" " + sender);
            System.out.println("Note: Current Token is at Node " + sender);

            System.out.println("\nData Passing: [Previous Node -> Next Node]");
            // Forwarding data until it reaches the receiver
            for (i = sender; i != receiver; i = (i + 1) % n) {
                System.out.print(" " + i + " ->");
            }
            System.out.println(" " + receiver);
            System.out.println("\nReceiver: " + receiver + ", Received the data: " + data);
            token = sender;

            // Asking user if they want to send data again
            System.out.print("\nDo you want to send data again? If yes Enter 1, If no Enter 0: ");
            choice = sc.nextInt();
        } while (choice == 1);

        // Closing scanner
        sc.close();
    }
}
