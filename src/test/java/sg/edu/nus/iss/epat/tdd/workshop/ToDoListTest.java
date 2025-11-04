package sg.edu.nus.iss.epat.tdd.workshop;

import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList todo;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        todo = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        todo = null;
    }

    @Test
    public void testAddTask() {
        // fail("Not implemented yet");
        // Test 1: Add a new task and verify it exists
        Task task1 = new Task("Write report");
        todo.addTask(task1);
        assertNotNull(todo.getTask("Write report"));
        assertEquals("Write report", todo.getTask("Write report").getDescription());

        // Test 2: Add a duplicate (should overwrite)
        Task duplicateTask = new Task("Write report");
        todo.addTask(duplicateTask);
        assertEquals("Write report", todo.getTask("Write report").getDescription());

        // Test 3: Add multiple tasks
        Task task2 = new Task("Email team");
        todo.addTask(task2);
        assertNotNull(todo.getTask("Email team"));
        assertEquals(2, todo.getAllTasks().size());
    }

    @Test
    public void testGetStatus() {
        // fail("Not implemented yet");
        Task t1 = new Task("Task1");
        todo.addTask(t1);
        assertFalse(todo.getStatus("Task1"));

        todo.completeTask("Task1");
        assertTrue(todo.getStatus("Task1"));
    }

    @Test
    public void testRemoveTask() {
        // fail("Not implemented yet");
        Task task = new Task("Schedule meeting");
        todo.addTask(task);

        // Test removal
        Task removed = todo.removeTask("Schedule meeting");
        assertEquals(task, removed);

        // Test that the task is gone
        assertNull(todo.getTask("Schedule meeting"));
        assertEquals(0, todo.getAllTasks().size());

        // Test removing a non-existent task
        assertNull(todo.removeTask("No such task"));
    }

    @Test
    public void testGetCompletedTasks() {
        // fail("Not implemented yet");
        Task t1 = new Task("Task1");
        Task t2 = new Task("Task2");
        todo.addTask(t1);
        todo.addTask(t2);

        // Complete one task
        todo.completeTask("Task1");

        Collection<Task> completed = todo.getCompletedTasks();
        assertEquals(1, completed.size());
        assertTrue(completed.iterator().next().isComplete());
    }
}