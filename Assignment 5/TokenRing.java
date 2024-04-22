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
        // System.out.println("0");

        int choice = 0;
        do {
            // Getting sender, receiver, and data
            System.out.print("\nEnter Sender: ");
            int sender = sc.nextInt();

            if (sender < 0 || sender >= n) {
                System.out.print("\nEnter valid senter between " + 1 + " & " + (n - 1));
                System.out.print("\nEnter Sender: ");
                sender = sc.nextInt();

            }

            System.out.print("\nEnter Receiver: ");
            int receiver = sc.nextInt();

            if (receiver < 0 || receiver >= n) {
                System.out.print("\nEnter valid receiver between " + 1 + " & " + (n - 1));
                System.out.print("\nEnter Receiver: ");
                receiver = sc.nextInt();

            }

            System.out.print("\nEnter Data to Send: ");
            int data = sc.nextInt();
            int token = 0;
            int i = 0;
            // System.out.println(" " + sender);
            System.out.println("Sender: " + sender + " Sending Data: " + data);

            // Token Passing
            System.out.println("\nToken Passing: [Current Token At: " + token + " ]");
            for (i = token; i < sender; i++) {
                System.out.print(" " + i + " ->");
            }

            // Forwarding data until it reaches the receiver
            for (i = sender; i != receiver; i = (i + 1) % n) {
                // System.out.println("Data Forwarded by: " + i);
                System.out.print(" " + i + " ->");
            }
            System.out.print(" " + receiver);
            System.out.println("\nReceiver: " + receiver + ", Received the data: " + data);
            token = sender;
            if (i < n - 1) {
                for (; i < n; i++)
                    System.out.print(" " + i + " ->");

            }
            // Asking user if they want to send data again
            System.out.print("\nDo you want to send data again? If yes Enter 1, If no Enter 0: ");
            choice = sc.nextInt();
        } while (choice == 1);

        // Closing scanner
        sc.close();
    }
}
