import java.time.LocalDate;

public class Task{
    
    private static int idCounter = 1;

    private final int id;
    private final String title;
    private final String description;
    private final LocalDate deadline;
    private final Priority priority;
    private boolean completed;

    public Task(String title, String description, LocalDate deadline, Priority priority) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = false;
    }

    public int getID(){ return id; }
    public String getTitle(){ return title; }
    public String getDescription(){ return description; }
    public LocalDate getDeadline(){ return deadline; }
    public Priority getPriority(){ return priority; }
    public boolean isCompleted(){ return completed; }
    
    public void markCompleted(){
        this.completed = true;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " | " + priority +
               " | Due: " + deadline +
               " | " + (completed ? "✔ Completed" : "⏳ Pending");
    }
}