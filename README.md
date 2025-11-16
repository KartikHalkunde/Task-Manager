# Task Manager

A simple command-line task management application built with Java to Manage your tasks with priorities, deadlines, and completion tracking.

## Features

- ✅ Add tasks with title, description, deadline, and priority
- 🗑️ Remove tasks by ID
- ✔️ Mark tasks as completed
- 🔍 Search tasks by keyword
- 📊 Filter tasks by priority (HIGH, MEDIUM, LOW)
- 📋 View all tasks or only pending tasks
- 📅 Deadline tracking using Java's LocalDate

## Project Structure

```
Task-Manager/
├── src/
│   ├── Task.java          # Task model with properties and methods
│   ├── TaskManager.java   # Core task management logic
│   ├── Priority.java      # Enum for task priorities
│   └── Main.java          # Application entry point
└── README.md
```

## Classes Overview

### Task
- Represents a single task with:
  - Unique auto-incrementing ID
  - Title, description, deadline, priority
  - Completion status
- Immutable properties (except completion status)

### TaskManager
- Manages a collection of tasks
- Key methods:
  - `addTask(Task)` - Add new task
  - `removeTask(int id)` - Remove task by ID
  - `markCompleted(int id)` - Mark task as done
  - `getAllTasks()` - Get all tasks
  - `getPendingTasks()` - Get incomplete tasks
  - `getTasksByPriority(Priority)` - Filter by priority
  - `searchTask(String)` - Search by title keyword

### Priority (Enum)
- `HIGH` - Urgent tasks
- `MEDIUM` - Normal priority
- `LOW` - Can wait

## Requirements

- Java 8 or higher (uses `java.time.LocalDate`)
- No external dependencies

## Usage Example

```java
TaskManager manager = new TaskManager();

// Add tasks
manager.addTask(new Task(
    "Complete project", 
    "Finish the task manager app",
    LocalDate.of(2025, 11, 20),
    Priority.HIGH
));

// View all tasks
for (Task t : manager.getAllTasks()) {
    System.out.println(t);
}

// Mark task as completed
manager.markCompleted(1);

// Search tasks
ArrayList<Task> found = manager.searchTask("project");
```

## Compilation & Execution

```bash
# Compile
cd src
javac *.java

# Run
java Main
```

## Future Enhancements

- [ ] Persistent storage (file/database)
- [ ] Edit existing tasks
- [ ] Sort tasks by deadline/priority
- [ ] Overdue task detection
- [ ] Task categories/tags
- [ ] GUI interface

## Author

Kartik Halkunde

## License

This project is open source and available for educational purposes.