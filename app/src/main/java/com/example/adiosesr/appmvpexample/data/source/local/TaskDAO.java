package com.example.adiosesr.appmvpexample.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.adiosesr.appmvpexample.model.Task;

import java.util.List;

@Dao
public interface TaskDAO {
    @Query("SELECT * FROM task")
    List<Task> getTasks();

    @Query("SELECT * FROM task WHERE status LIKE:status")
    List<Task> filterByStatus(String status);

    @Insert
    void insertTask(Task task);

}
