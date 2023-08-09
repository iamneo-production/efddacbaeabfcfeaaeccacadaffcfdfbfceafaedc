package com.examly.springapp.service;

@Service
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List < Task > getTaskByTaskHolderName(String taskHolderName) {
        return taskRepository.findByTaskHolderName(taskHolderName);
    }

    @Override
    public Optional < Task > getTaskByTaskId(long taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    @Override
    public void chagngeStatus(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void addTask(String taskHolderName, Date taskDate, String taskName,String taskStatus ) 
    {
        taskRepository.save(new Task(taskHolderName, taskDate, taskName, taskStatus));
    }

    @Override
    public void deleteTask(long taskId) 
    {
        Optional < Task > task = taskRepository.findByTaskId(taskId);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        }
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
