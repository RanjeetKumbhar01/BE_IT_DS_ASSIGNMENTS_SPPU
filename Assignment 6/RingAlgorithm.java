import java.util.Scanner;

public class RingAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        System.out.print("Enter the ID of this process (between 1 and " + numProcesses + "): ");
        int thisProcessId = scanner.nextInt();

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
        ring[thisProcessId - 1].startElection();
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

    public void startElection() {
        System.out.println("Process " + processId + " starts the election.");

        if (isLeader) {
            System.out.println("Process " + processId + " is already the leader.");
            return;
        }

        RingProcess currentProcess = this;
        while (true) {
            if (currentProcess.nextProcess.processId == processId) {
                currentProcess.isLeader = true;
                System.out.println("Process " + processId + " is elected as the leader.");
                break;
            } else if (currentProcess.nextProcess.processId > processId) {
                currentProcess = currentProcess.nextProcess;
            } else {
                System.out.println("Process " + processId + " passes the election message to Process " +
                        currentProcess.nextProcess.processId);
                currentProcess = currentProcess.nextProcess;
            }
        }
    }
}
