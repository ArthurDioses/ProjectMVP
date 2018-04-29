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

    @Query("SELECT * FROM task WHERE idTask Like:idTask")
    Task filterByidTask(int idTask);

    @Insert
    void insertTask(Task task);

    @Query("UPDATE task SET status=:status WHERE idTask=:idTask")
    void updateStatus(int idTask, String status);

    @Query("DELETE FROM task WHERE idTask LIKE:task")
    void deleteTask(int task);

    @Query("UPDATE task SET title=:title, descTask=:descTask,dateEnd=:dateEnd, typeTask=:typeTask, priority=:priority WHERE idTask=:idTask")
    void updateTask(int idTask, String title, String descTask, String dateEnd, String typeTask, String priority);
}