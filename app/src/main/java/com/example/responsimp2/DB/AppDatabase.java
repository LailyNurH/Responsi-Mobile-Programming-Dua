package com.example.responsimp2.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.responsimp2.MatKulDao;
import com.example.responsimp2.model.MataKuliah;

@Database(entities = {MataKuliah.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public  abstract MatKulDao userDao();
}
