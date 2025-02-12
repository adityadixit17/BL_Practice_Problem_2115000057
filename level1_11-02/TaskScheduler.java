class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class CircularLinkedList {
    Task head = null;
    void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }
    void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }
    void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Task temp = head;
            for (int i = 1; i < position; i++) {
                if (temp.next == head) break;
                temp = temp.next;
            }
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }
    void removeTaskById(int taskId) {
        if (head == null) return;
        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev != null) {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                } else {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    last.next = temp.next;
                    head = temp.next;
                }
		System.out.println("Data of " + taskId + " has been deleted.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    void viewCurrentTask() {
	if (head != null) {
	    System.out.println("Task ID: " + head.taskId + ", Task Name: " + head.taskName + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
        }
    }
    void moveToNextTask() {
        if (head != null) {
            head = head.next;
            viewCurrentTask();
        }
    }
    void displayAllTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList tasks = new CircularLinkedList();
        tasks.addTaskAtEnd(1, "Task 1", 3, "2025-02-12");
        tasks.addTaskAtEnd(2, "Task 2", 1, "2025-02-14");
        tasks.addTaskAtBeginning(0, "Task 0", 2, "2025-02-11");
        tasks.addTaskAtPosition(1, 3, "Task 3", 3, "2025-02-13");
        tasks.displayAllTasks();
        tasks.removeTaskById(2);
        tasks.displayAllTasks();
        tasks.viewCurrentTask();
        tasks.moveToNextTask();
        tasks.moveToNextTask();
        tasks.searchTaskByPriority(3);
    }
}
