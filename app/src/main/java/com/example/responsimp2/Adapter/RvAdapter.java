package com.example.responsimp2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.responsimp2.CRUD.CrudRoomApp;
import com.example.responsimp2.Common.DataListListener;
import com.example.responsimp2.R;
import com.example.responsimp2.UI.TambahMatakuliahActivity;
import com.example.responsimp2.model.MataKuliah;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{


    private List<MataKuliah> dataList = new ArrayList<>();
    private DataListListener listener;

    public void setData(List<MataKuliah> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            MataKuliah data = dataList.get(i);
            int position = findPosition(data);
            if (position == -1) {
                this.dataList.add(data);
                notifyItemInserted(this.dataList.size() - 1);
            } else {
                this.dataList.remove(position);
                this.dataList.add(position, data);
                notifyItemChanged(position);
            }
        }
    }

    private int findPosition(MataKuliah data) {
        int position = -1;

        if (!this.dataList.isEmpty()) {
            for (int i = 0; i < dataList.size(); i++) {
                if (this.dataList.get(i).getId() == data.getId()) {
                    position = i;
                }
            }
        }

        return position;
    }

    public void removeData(MataKuliah data) {
        if (this.dataList.isEmpty()) {
            return;
        }

        for (int i = 0; i < dataList.size(); i++) {
            if (this.dataList.get(i).getId() == data.getId()) {
                this.dataList.remove(i);
                notifyItemRemoved(i);
            }
        }
    }

    public void setRemoveListener(DataListListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matkul, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(dataList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RequestOptions requestOptions;
        private TextView tvNama, tvNim;
        private ImageView imageView;
        private Button btnHapus;
        private Mahasiswa data;
        private DataListListener listener;

        ViewHolder(@NonNull View itemView) {
            super(itemView);



            tvNim = itemView.findViewById(R.id.tv_nim);
            btnHapus = itemView.findViewById(R.id.btn_hapus);
            imageView = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
            btnHapus.setOnClickListener(this);
        }



    }

}
