package com.example.taskupdate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table
@Entity
public class Task{
     @Id 
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String taskname;
    private String projectname; 
    private String status;
    @NumberFormat(style=NumberFormat.Style.PERCENT)
    private Float percentagecompleted;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private String notes;
    
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProjectname() {
        return projectname;
    }
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
    public String getTaskname() {
        return taskname;
    }
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Float getPercentagecompleted() {
        return percentagecompleted;
    }
    public void setPercentagecompleted(Float percentagecompleted) {
        this.percentagecompleted = percentagecompleted;
    }
    public String getNotes() {
        return notes;
    }
     public void setNotes(String notes) {
        this.notes = notes;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}