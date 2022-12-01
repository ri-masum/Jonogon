package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registation_1 extends AppCompatActivity {
    Button b1;
    EditText fullname,mname,fname,mnation,fnation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation1);
        b1=findViewById(R.id.next1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String Name=fullname.getText().toString();
//                String Mname=mname.getText().toString();
//                String Fname=fname.getText().toString();
//                String Mnation=mnation.getText().toString();
//                String Fnation=fnation.getText().toString();

                    Intent intent= new Intent(Registation_1.this,Registation_2.class);
                    startActivity(intent);
                }

        });
    }
}