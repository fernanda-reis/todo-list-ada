import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean completed;

    public Task(String title, String description, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline(){
        return deadline;
    }

    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                '}';
    }
}
