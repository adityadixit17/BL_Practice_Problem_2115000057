class Process {
    int pid;
    int burstTime;
    int priority;
    Process next;
    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
class CircularLinkedList {
    private Process head;
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }
    public void removeProcess(int pid) {
        if (head == null) return;
        Process temp = head;
        Process prev = null;
        do {
            if (temp.pid == pid) {
                if (prev == null) {
                    if (head.next == head) {
                        head = null;
                    } else {
                        Process last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) return;
        int totalWaitTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;
        Process current = head;
        while (completedProcesses < getTotalProcessCount()) {
            if (current.burstTime > 0) {
                System.out.println("Executing Process ID: " + current.pid);
                if (current.burstTime > timeQuantum) {
                    current.burstTime -= timeQuantum;
                } else {
                    totalWaitTime += (timeQuantum - current.burstTime);
                    totalTurnAroundTime += (current.burstTime + timeQuantum);
                    current.burstTime = 0;
                    completedProcesses++;
                    removeProcess(current.pid);
                }
            }
            current = current.next;
        }
        System.out.println("Average Waiting Time: " + (totalWaitTime / getTotalProcessCount()));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / getTotalProcessCount()));
    }
    private int getTotalProcessCount() {
        int count = 0;
        Process temp = head;
        if (temp == null) return 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.pid + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}
public class RoundRobinScheduling {
    public static void main(String[] args) {
        CircularLinkedList processList = new CircularLinkedList();
        processList.addProcess(1, 10, 1);
        processList.addProcess(2, 5, 2);
        processList.addProcess(3, 8, 3);
        System.out.println("Processes before Round Robin scheduling:");
        processList.displayProcesses();
        processList.roundRobinScheduling(4);
        System.out.println("Remaining processes after Round Robin scheduling:");
        processList.displayProcesses();
    }
}
