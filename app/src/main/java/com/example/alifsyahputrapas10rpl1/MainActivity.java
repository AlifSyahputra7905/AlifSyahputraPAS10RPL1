package com.example.alifsyahputrapas10rpl1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Data> data;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recicel);
        recyclerView.setHasFixedSize(true);
        addData();
        adapter = new Adapter(data, new Adapter.Callback() {
            @Override
            public void onClick(int position) {
                Data Operator = data.get(position);
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Intent move = new Intent(getApplicationContext(), detail.class);
                move.putExtra("gambar", Operator.getGambar());
                move.putExtra("nama", Operator.getNama());
                move.putExtra("pesan", Operator.getPesan());
                startActivity(move);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addData() {
        data = new ArrayList<>();
        data.add(new Data("BabyLaa", "Sayang Apa Kabar?", R.drawable.babyla));
        data.add(new Data("Alice", "Pagii Syaangkuu", R.drawable.pp1));
        data.add(new Data("Lea", "Nanti Mau Jalan Jam berapa bby?", R.drawable.lea));
        data.add(new Data("Jeha", "Lagi ngapain bby?", R.drawable.jeha));
        data.add(new Data("Lidiawati", "Bby lagi di rumah??", R.drawable.notnot));
        
        
        
        tampilandata();
    }

    private void tampilandata() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url= "";
        JSONObject jsonObject = new JSONObject();
        final String requestBody = jsonObject.toString();
        StringRequest StringRequest = new StringRequest();
        Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response){
            try {
                JSONObject jo = new JSONObject(response.toString());

            }catch (JSONException e){
                e.printStackTrace();
            }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorReponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Gagal Ambil Rest API" + error, Toast.LENGTH_SHORT).show();
            }
        };
    }
}