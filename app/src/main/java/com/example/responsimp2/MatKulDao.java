package com.example.responsimp2;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.responsimp2.model.MataKuliah;

import java.util.List;

@Dao
public interface MatKulDao {

    @Query("SELECT * FROM matakuliah")
    List<MataKuliah> getAll();

    //Example Custum Query
    @Query("SELECT * FROM matakuliah WHERE namamatakuliah LIKE : namamatakuliah")
    MataKuliah findByName(String nama);

    @Insert
    void insertAll(MataKuliah... mataKuliah);

    @Delete
    public void deleteUsers(MataKuliah... users);

    @Query("SELECT * FROM matakuliah WHERE id LIKE :mahasiswaId LIMIT 1")
    MataKuliah findById(int mahasiswaId);

    @Update
    void update(MataKuliah mahasiswa);

    @Insert
    void insertData(MataKuliah mataKuliah);

    @Delete
    void delete(MataKuliah mataKuliah);
}

