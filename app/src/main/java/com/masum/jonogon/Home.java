package com.masum.jonogon;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    LinearLayout b1,b2,b3,b4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        b1=findViewById(R.id.registation);
        b2=findViewById(R.id.status);
        b3=findViewById(R.id.download);
        b4=findViewById(R.id.info);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"opening Registation",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Home.this,Registation_1.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"opening Status",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Home.this,Status.class);
                startActivity(intent);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"opening Download",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Home.this,Downloads.class);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"opening About Us",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Home.this,Info.class);
                startActivity(intent);
            }
        });

    }
}