package com.example.responsimp2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsimp2.CRUD.CrudRoomApp;
import com.example.responsimp2.MatKulDao;
import com.example.responsimp2.R;
import com.example.responsimp2.model.MataKuliah;

public class TambahMatakuliahActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String TAG_DATA_INTENT = "data_matkul";
    private EditText etnamamatkul, etSemester;
    private Button btnsave;
    private MatKulDao dao;
    private MataKuliah mataKuliah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_matakuliah);
        dao = CrudRoomApp.getInstance().getDataBase().userDao();

        if (getIntent() != null) {
            int id = getIntent().getIntExtra(TAG_DATA_INTENT, 0);
            mataKuliah = dao.findById(id);
        }
        if (mataKuliah == null) {
           mataKuliah = new MataKuliah();


           etnamamatkul= findViewById(R.id.etmatakuliah);
           etSemester= findViewById(R.id.etSemester);
           btnsave= findViewById(R.id.btn_save);

           btnsave.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (view.getId()) {
            case R.id.btn_tambah:
                addOrUpdate();
                if (mahasiswa.getId() == 0) {
                    dao.insertData(mahasiswa);
                } else {
                    dao.update(mahasiswa);
                }

                Toast.makeText(this, btnTambah.getText().toString(), Toast.LENGTH_SHORT).show();
                finish();
                break;
    }
}