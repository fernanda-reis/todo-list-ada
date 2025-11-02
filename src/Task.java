import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean completed;
    public static int count = 1;

    public Task(String title, String description, LocalDate deadline) {
        this.id = count++;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "["+id+"] " + "Title = " + title + " | Completed? " + completed + " | Deadline = " + deadline;
    }
}
