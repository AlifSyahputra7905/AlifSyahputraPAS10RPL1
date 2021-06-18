package com.example.alifsyahputrapas10rpl1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class Adapter extends  RecyclerView.Adapter<Adapter.ViewHolder> {
    private Callback callback;
    private ArrayList<Data> listdata;
    interface Callback{
        void onClick(int position);
    }
    public Adapter(ArrayList<Data> data, Callback callback) {
        this.listdata = data;
        this.callback = callback;
    }
    public Adapter (ArrayList<Data>listdata){
        this.listdata = listdata;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.potoprofil, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Data Datalist = listdata.get(position);
        holder.nama.setText(Datalist.getNama());
        holder.pesan.setText(Datalist.getPesan());
        holder.gambar.setImageResource(Datalist.getGambar());
    }

    @Override
    public int getItemCount() { return (listdata != null) ? listdata.size() :0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView  pesan;
        TextView nama;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.Image);
            pesan = itemView.findViewById(R.id.textpesan);
            nama = itemView.findViewById(R.id.textnama);
            cardView = itemView.findViewById(R.id.Cardview);
            gambar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }

            });
        }
    }


}
