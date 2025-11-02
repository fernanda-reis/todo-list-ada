import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        boolean executing = true;
        List<Task> tasks = new ArrayList<>();

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

            try {
                int option = sc.nextInt();
                sc.nextLine();
                System.out.println("Chosen option: " + option);

                //switch expression - java 14+
                executing = switch (option) {
                    case 1 -> {
                        System.out.println();
                        System.out.println("Enter the title: ");
                        String title = sc.nextLine();

                        System.out.println("Enter the description: ");
                        String description = sc.nextLine();

                        System.out.println("Enter the deadline (yyyy-MM-dd): ");
                        LocalDate deadline = LocalDate.parse(sc.nextLine());

                        Task newTask = new Task(title, description, deadline);
                        tasks.add(newTask);

                        System.out.println("Task created: " + newTask.getTitle());
                        yield true;
                    }
                    case 2 -> {
                        System.out.println();
                        System.out.println("== Pending Tasks: ==");

                        for (Task task : tasks) {
                            if (!task.getCompleted()) {
                                System.out.println(task);
                            }
                        }
                        yield true;
                    }
                    case 3 -> {
                        System.out.println();
                        System.out.println("Enter the title:");
                        String searchTitle = sc.nextLine();
                        System.out.println();

                        List<Task> filteredTasks = tasks.stream().filter(task -> task.getTitle()
                                        .toLowerCase()
                                        .contains(searchTitle.toLowerCase()))
                                        .toList();

                        System.out.println("Related tasks:");
                        for (Task task : filteredTasks) {
                            System.out.println(task.toString());
                        }
                        yield true;
                    }
                    case 4 -> {
                        System.out.println();
                        System.out.println("Enter task ID to set as completed:");
                        int idTask = sc.nextInt();

                        Task taskToComplete = tasks.stream().filter(task -> task.getId() == idTask).toList().getFirst();
                        if (taskToComplete.getCompleted()) {
                            System.out.println("The task is already completed!");
                        } else {
                            taskToComplete.setCompleted(true);
                            System.out.println("Congratulations! You completed the task! ❤");
                        }

                        yield true;
                    }
                    case 5 -> {
                        System.out.println();
                        System.out.println("Enter task ID to remove:");
                        int idTask = sc.nextInt();

                        Task taskToRemove = tasks.stream().filter(task -> task.getId() == idTask).toList().getFirst();
                        tasks.remove(taskToRemove);

                        System.out.println("The task was removed successfully!");
                        yield true;
                    }
                    case 0 -> false;
                    default -> {
                        System.out.println("Invalid option!");
                        yield true;
                    }
                };
            } catch (Exception e) {
                System.out.println("Oops, something went wrong! Try again.");
            }

        }
    }
}
