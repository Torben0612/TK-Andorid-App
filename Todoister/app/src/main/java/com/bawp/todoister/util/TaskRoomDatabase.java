package com.bawp.todoister.util;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.bawp.todoister.model.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.Context;

public abstract class TaskRoomDatabase extends RoomDatabase  {

    public static final String DATASE_NAME = "todoister_database";
    public static final int NUMBER_OF_THREADS = 4;
    private static volatile TaskRoomDatabase INSTANCE;
    public static final ExecutorService databaseWriterExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    databaseWriterExecutor.execute(() ->{
                        //invoke, dao, and write
                    });
                }
            };


    public static TaskRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null){
            synchronized (TaskRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContex(),
                            TaskRoomDatabase.class, DATASE_NAME)
                                    .addCallback(sRoomDatabaseCallback)
                                    .build();

                }
            }
        }

        return INSTANCE;
    }
    public abstract TaskDao taskDao();
}
