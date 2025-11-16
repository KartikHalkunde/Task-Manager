import java.util.Scanner;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();

        while(true) { 
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Completed");
            System.out.println("4. List All Tasks");
            System.out.println("5. List Pending Tasks");
            System.out.println("6. List Tasks by Priority");
            System.out.println("7. Search Task");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            int choice  = sc.nextInt();
            sc.nextLine();

            try{
                switch(choice){
                    case 1 -> {  // Add task
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        System.out.println("Deadline(YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(sc.nextLine());
                        System.out.println("Priority(LOW/MID/HIGH): ");
                        Priority pr = Priority.valueOf(sc.nextLine().toUpperCase());
                        
                        Task t = new Task(title, desc, date, pr);
                        tm.addTask(t);
                        System.out.println("Task Added Succesfully!");
                    }
                    case 2 -> { // Remove task
                        System.out.println("Enter Task ID: ");
                        int removeID = sc.nextInt();
                        tm.removeTask(removeID);
                        System.out.println("Task Removed!");
                    }
                    case 3 -> {  // Mark Completed
                        System.out.println("Enter Task ID: ");
                        int completedID = sc.nextInt();
                        tm.markCompleted(completedID);
                        System.out.println("Task marked Completed!");
                    }
                    case 4 -> { // List All Tasks
                        System.out.println("All Tasks: ");
                        for(Task task : tm.getAllTasks()){
                            System.out.println(task);
                        }
                    }
                    case 5 -> {  // List Pending Task
                        System.out.println("Pending Tasks: ");
                        for(Task task : tm.getPendingTasks())
                        System.out.println(task);
                    }
                    case 6 -> {  // List Task By Priority
                        System.out.println("Enter Priority(LOW/MID/HIGH): ");
                        Priority filterPr = Priority.valueOf(sc.nextLine().toUpperCase());

                        System.out.println("Tasks with " + filterPr + " priority : ");
                        for(Task task : tm.getTasksByPriority(filterPr)){
                            System.out.println(task);
                        }
                    }
                    case 7 -> { //Search Task
                        System.out.println("Enter keyword: ");
                        String keyword = sc.nextLine();

                        System.out.println("\nSearch Results: ");
                        for(Task task : tm.searchTask(keyword)){
                            System.out.println(task);
                        }
                    }
                    case 8 -> { // Exit
                        System.out.println("Thankyou!");
                        sc.close();
                        return;
                    }
                    default -> { System.out.println("Invalid Choice"); } 
                }
            }
            catch(Exception e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }
}
