package com.examly.springapp.service;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List < Todo > getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional < Todo > getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        taskRepository.save(new Todo(name, desc, targetDate, isDone));
    }

    @Override
    public void deleteTask(long id) {
        Optional < Task > task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        }
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
