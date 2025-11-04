package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      if (task == null || task.getDescription() == null) {
         return; // Optionally throw exception for better error handling
      }
      tasks.put(task.getDescription(), task);
   }

   public void completeTask(String description) {
      // Add code here
      Task task = tasks.get(description);
      if (task != null) {
         task.setComplete(true);
      }
   }

   public boolean getStatus(String description) {
      // Add code here
      // return false;
      Task task = tasks.get(description);
      return task != null && task.isComplete();
   }

   public Task getTask(String description) {
      // Add code here
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      // Add code here
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      // Add code here
      // return null;
      ArrayList<Task> completed = new ArrayList<>();
      for (Task t : tasks.values()) {
         if (t.isComplete()) {
               completed.add(t);
         }
      }
      return completed;
   }
}
