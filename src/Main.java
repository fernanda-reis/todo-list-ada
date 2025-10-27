import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean executing = true;
        System.out.println("Todo List");

        while (executing) {
            System.out.println("======== menu ========");
            System.out.println("1 - Create task");
            System.out.println("2 - List pending tasks");
            System.out.println("3 - Get task by title");
            System.out.println("4 - Set task as completed");
            System.out.println("5 - Remove a task");
            System.out.println("0 - Terminate");
            System.out.println();

            System.out.println("Choose an option: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();

            System.out.println("Chosen option: " + option);

            //switch expression - java 14+
            executing = switch (option) {
                case 1 -> {
                    System.out.println("Enter the title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter the description: ");
                    String description = sc.nextLine();

                    System.out.println("Enter the deadline (yyyy-MM-dd): ");
                    LocalDate deadline = LocalDate.parse(sc.nextLine());

                    Task newTask = new Task(title, description, deadline);
                    System.out.println("Task created: " + newTask.getTitle());
                    yield true;
                }
                case 2 -> {
                    System.out.println("List pending tasks");
                    yield true;
                }
                case 3 -> {
                    System.out.println("Get task by title");
                    yield true;
                }
                case 4 -> {
                    System.out.println("Set task as completed");
                    yield true;
                }
                case 5 -> {
                    System.out.println("Remove a task");
                    yield true;
                }
                case 0 -> false;
                default -> {
                    System.out.println("Invalid option!");
                    yield true;
                }
            };
        }
    }
}
