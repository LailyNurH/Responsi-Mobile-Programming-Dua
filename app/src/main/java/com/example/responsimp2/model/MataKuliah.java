package com.example.responsimp2.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MataKuliah {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name="namamatakuliah")
    String namamatakuliah;
    @ColumnInfo(name = "semester")
    String semester;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNamamatakuliah() {
        return namamatakuliah;
    }
    public void setNamamatakuliah(String matakuliah) {
        this.namamatakuliah = matakuliah;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }

}