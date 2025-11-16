import java.util.ArrayList;

public class TaskManager {
    
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task t){
        tasks.add(t);
    }

    public void removeTask(int id){
        Task t = findTask(id);
        tasks.remove(t);
    }

    public void markCompleted(int id){
        Task t = findTask(id);
        t.markCompleted();
    }

    public ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public ArrayList<Task> getPendingTasks(){
        ArrayList<Task> pending = new ArrayList<>();
        for(Task t : tasks){
            if(!t.isCompleted()){
                pending.add(t);
            }
        }
    return pending;
    }

    public ArrayList<Task> getTasksByPriority(Priority p){
        ArrayList<Task> result = new ArrayList<>();
        for(Task t : tasks){
            if(t.getPriority() == p){
                result.add(t);
            }
        }
        return result;
    }

    public ArrayList<Task> searchTask(String keyword){
        ArrayList<Task> result = new ArrayList<>();
        for(Task t: tasks){
            if(t.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                result.add(t);
            }
        }
        return result;
    }

    private Task findTask(int id){
        for(Task t : tasks){
            if(t.getID()==id){
                return t;
            }
        }
        throw new RuntimeException("Task not found");
    }
}
