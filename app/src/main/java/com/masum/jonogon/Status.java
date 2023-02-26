package com.masum.jonogon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Status extends AppCompatActivity {

    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        textView=findViewById(R.id.status);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentid = user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        reference = firestore.collection("Registration").document(currentid);
        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                DocumentSnapshot dataSnapshot = task.getResult();

                String Varify = task.getResult().getString("varify");
                if (task.getResult().exists()){
                    int intVarify = Integer.parseInt(Varify);
                    if (intVarify==1){


                        textView.setText("You Can download Your certificate now ");

                    }
                    else if (intVarify==0){
                        textView.setText("Processing");
                    }


                }else {
                    textView.setText("You Haven't Registered yet ");

                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }
}