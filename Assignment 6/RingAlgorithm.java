import java.util.Scanner;

public class RingAlgorithm {
    public static void main(String[] args) {
        int thisProcessId, numProcesses, failedID;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        numProcesses = scanner.nextInt();

        // while loop for validation
        while (true) {
            System.out.print("Enter the ID of this process (between 1 and " + numProcesses + "): ");
            thisProcessId = scanner.nextInt();
            if (thisProcessId <= 0 && thisProcessId > numProcesses) {
                System.out.println("Please enter correct input");
            } else
                break;
        }

        // while loop for validation
        while (true) {
            System.out.print("Enter the ID of this process which failed ");
            failedID = scanner.nextInt();
            if (failedID <= 0 && failedID > numProcesses) {
                System.out.println("Please enter correct input");
                continue;
            } else
                break;
        }

        // Initialize the ring
        RingProcess[] ring = new RingProcess[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            ring[i] = new RingProcess(i + 1);
        }

        // Set the next process in the ring for each process
        for (int i = 0; i < numProcesses; i++) {
            ring[i].setNextProcess(ring[(i + 1) % numProcesses]);
        }

        // Start the election
        ring[thisProcessId - 1].startElection(failedID, numProcesses);
        scanner.close();
    }
}

class RingProcess {
    private int processId;
    private RingProcess nextProcess;
    private boolean isLeader;

    public RingProcess(int processId) {
        this.processId = processId;
        this.isLeader = false;
    }

    public void setNextProcess(RingProcess nextProcess) {
        this.nextProcess = nextProcess;
    }

    public void startElection(int failedID, int numProcesses) {
        System.out.println("Process " + processId + " starts the election.");

        if (isLeader) {
            System.out.println("Process " + processId + " is already the leader.");
            return;
        }

        int[] arr = new int[numProcesses - 1];

        int i = 0;
        RingProcess currentProcess = this;
        arr[i] = currentProcess.processId;

        while (currentProcess.nextProcess != this) {
            if (currentProcess.nextProcess.processId != failedID) {
                arr[i++] = currentProcess.nextProcess.processId;

            }
            currentProcess = currentProcess.nextProcess;

        }
        int max = arr[0];

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        System.out.println(max + " elected as the new leader.");

    }
}