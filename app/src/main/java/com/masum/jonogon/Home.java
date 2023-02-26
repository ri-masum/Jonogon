package com.masum.jonogon;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class Home extends AppCompatActivity {
    LinearLayout b1,b2,b3,b4;
   // String data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//
//        data="yes";
//         data = getIntent().getExtras().getString("key","defaultKey");
//        System.out.println("data="+data);
//
//        if (data=="submit"){
//            b1.setVisibility(View.INVISIBLE);
//           // System.out.println("submit value="+d);
//        }


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        b1=findViewById(R.id.registation);
        b2=findViewById(R.id.status);
        b3=findViewById(R.id.download);
        b4=findViewById(R.id.info);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this function is make to disable the registration button
                //hold command/control key  and click on the function it will take you to the disable function
                disablebutton();


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

                Intent intent=new Intent(Home.this,Download.class);
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

    private void disablebutton() {

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String currentid=user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore=FirebaseFirestore.getInstance();

        reference=firestore.collection("Registration").document(currentid);

        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()){
                    //b1.setVisibility(View.INVISIBLE);
                    //to disable the button we have use this set enabled thing
                    b1.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Your already registerd",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(),"opening Registation",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Home.this,Birthplace_address.class);
                    startActivity(intent);

                }


            }
        });



    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Quit")
                .setMessage("Are you sure you want to exit the app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); //now yes a click korle direct ber hoye jabe app teke
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}