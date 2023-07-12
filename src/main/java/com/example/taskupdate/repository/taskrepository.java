package com.example.taskupdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskupdate.model.Task;

@Repository
public interface taskrepository extends JpaRepository<Task,Long>{
    
}
