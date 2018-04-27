package com.example.adiosesr.appmvpexample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "task")
public class Task  {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTask")
    private int idTask;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "descTask")
    private String descTask;

    @ColumnInfo(name = "dateEnd")
    private String dateEnd;

    @ColumnInfo(name = "typeTask")
    private String typeTask;

    @ColumnInfo(name = "priority")
    private String priority;

    @ColumnInfo(name = "status")
    private String status;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescTask() {
        return descTask;
    }

    public void setDescTask(String descTask) {
        this.descTask = descTask;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}