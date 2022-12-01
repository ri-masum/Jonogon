package com.masum.jonogon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Downloads extends AppCompatActivity {
    LinearLayout layout1,layout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);

        layout1=findViewById(R.id.bcard_download);
        layout2=findViewById(R.id.NID_download);

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your Birth card can be downloaded when its ready",Toast.LENGTH_SHORT).show();


            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your NID can be downloaded when its ready",Toast.LENGTH_SHORT).show();

            }
        });


    }
}