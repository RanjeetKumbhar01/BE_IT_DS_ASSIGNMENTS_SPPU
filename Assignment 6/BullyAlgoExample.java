import java.io.*;
import java.util.Scanner;

// Create class BullyAlgoExample to understand how bully algorithms work
class BullyAlgoExample {
    // Declare variables and arrays for process and their status
    static int numberOfProcess;
    static int priorities[] = new int[100];
    static int status[] = new int[100];
    static int cord;

    // main() method start
    public static void main(String args[]) throws IOException {
        // Handle IOException
        try {
            // Get input from the user for the number of processes
            System.out.println("Enter total number of processes:");
            // Create scanner class object to get input from user
            Scanner sc = new Scanner(System.in);
            numberOfProcess = sc.nextInt();
            int i;
            // Use for loop to set priority and status of each process
            for (i = 0; i < numberOfProcess; i++) {
                System.out.println("Status for process " + (i + 1) + ":");
                status[i] = sc.nextInt();
                System.out.println("Priority of process " + (i + 1) + ":");
                priorities[i] = sc.nextInt();
            }
            System.out.println("Enter process which will initiate election");
            int ele = sc.nextInt();
            sc.close();
            // Call electProcess() method
            electProcess(ele);
            System.out.println("After electing process the final coordinator is " + cord);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }

    // Create electProcess() method
    static void electProcess(int ele) {
        ele = ele - 1;
        cord = ele + 1;
        for (int i = 0; i < numberOfProcess; i++) {
            if (priorities[ele] < priorities[i]) {
                System.out.println("Election message is sent from " + (ele + 1) + " to " + (i + 1));
                if (status[i] == 1)
                    electProcess(i + 1);
            }
        }
    }
}
