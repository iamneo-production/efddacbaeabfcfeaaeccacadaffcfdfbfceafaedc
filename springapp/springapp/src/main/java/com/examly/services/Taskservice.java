package com.examly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.model.Task;
import com.examly.repository.Taskrepository;

@Service
public class Taskservice{

    @Autowired
    private Taskrepository repo;
	
	public List<Task> listAll() {
        return repo.findAll();
    }
     
    public void save(Task task) {
        repo.save(task);
    }
     
    public Task get(long id) {
        return repo.findById(id).get();
    } 

    public void delete(long id) {
        repo.deleteById(id);
    }
}

