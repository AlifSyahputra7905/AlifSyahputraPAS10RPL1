package com.example.alifsyahputrapas10rpl1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    Integer image;
    ImageView ing;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        bundle = getIntent().getExtras();

        ing = (ImageView)findViewById(R.id.ImageView);
        if  (bundle !=null) {
            image = bundle.getInt("gambar");
        }
        ing.setImageResource(image);

    }
}