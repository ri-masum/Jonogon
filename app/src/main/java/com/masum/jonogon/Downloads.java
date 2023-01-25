package com.masum.jonogon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Downloads extends AppCompatActivity {
    LinearLayout layout1,layout2;

    ImageView birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);

        layout1=findViewById(R.id.bcard_download);
        layout2=findViewById(R.id.NID_download);

        birth=findViewById(R.id.birthdown);
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

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Downloads.this,nid.class);
                startActivity(intent);
            }
        });

    }
}