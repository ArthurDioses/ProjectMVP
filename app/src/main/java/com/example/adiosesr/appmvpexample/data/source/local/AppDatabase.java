package com.example.adiosesr.appmvpexample.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.adiosesr.appmvpexample.model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract TaskDAO taskDAO();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Tasks.db")
                    .build();
        }
        return INSTANCE;
    }
}
