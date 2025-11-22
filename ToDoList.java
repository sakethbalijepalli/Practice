import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ToDoList {

    public static String userChoice(int choice, ArrayList<String> taskNames, ArrayList<Date> taskDeadlines, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print("Enter task name: ");
                String taskName = scanner.nextLine();
                System.out.print("Enter deadline in the format (DD-MM-YYYY): ");
                String date = scanner.nextLine();
                addTask(taskNames, taskDeadlines, taskName, date);
                break;
            case 2:
                System.out.print("Enter the task to be deleted: ");
                String task = scanner.nextLine();
                int taskNumber = Integer.parseInt(task);
                deleteTask(taskNames, taskDeadlines, taskNumber);
                break;
            case 3:
                displayTasks(taskNames, taskDeadlines);
                break;
            case 4:
                return "Exiting application. Goodbye!";
            default:
                return "Invalid choice!";

        }


        return null;
    }


    public static Date validateDate(String deadline) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(deadline);
            return date;
        } catch (Exception e) {
            System.out.println("Invalid date format! Please enter the deadline in DD-MM-YYYY format.\n");
            return null;
        }
    }

    public static void deleteTask(ArrayList<String> taskNames, ArrayList<Date> taskDeadlines, int taskNumber) {
        taskNames.remove(taskNumber - 1);
        taskDeadlines.remove(taskNumber - 1);
        System.out.println("Task with " + taskNumber + " number deleted successfully");
    }

    public static void addTask(ArrayList<String> taskNames, ArrayList<Date> taskDeadlines, String taskName, String deadline) {
        Date deadlineDate = validateDate(deadline);
        if (deadlineDate != null) {
            taskNames.add(taskName);
            taskDeadlines.add(deadlineDate);
            System.out.println("Task added successfully!\n");
        }

        System.out.println("Task " + taskName + " - " + deadline + " added successfully");
    }

    public static void displayTasks(ArrayList<String> taskNames, ArrayList<Date> taskDeadlines) {
        System.out.println("Let's display the tasks");
        if (taskNames.isEmpty()) {
            System.out.println("No tasks available.\n");
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\nYour Tasks:");

        for (int i = 0; i < taskNames.size(); i++) {
            String formattedDeadline = dateFormat.format(taskDeadlines.get(i));
            System.out.println((i + 1) + ". " + taskNames.get(i) + " - Deadline: " + formattedDeadline);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<Date> taskDeadlines = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            System.out.println("Choose one operation:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            String value = userChoice(choice, taskNames, taskDeadlines, scanner);

            if ("Exiting application. Goodbye!".equals(value)) {
                System.out.println(value);
                break;
            }
        }

        scanner.close();
    }
}