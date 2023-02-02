package com.masum.jonogon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;

public class nid extends AppCompatActivity {

    TextView name,fname,mname,dob,nid;
    EditText name1;
    Button B;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nid);
        name=findViewById(R.id.nidname);
        fname=findViewById(R.id.nidfname);
        mname=findViewById(R.id.nidmname);
        dob=findViewById(R.id.niddob);
        name1=findViewById(R.id.inputname);
        B=findViewById(R.id.print1);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name1.getText().toString();
                if (!username.isEmpty()) {
                    readData(username);
                } else {
                    Toast.makeText(nid.this, "did not fetch", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void readData(String username) {
        reference= FirebaseDatabase.getInstance().getReference("Registration");
        reference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {


                if (task.isSuccessful()){

                    if (task.getResult().exists()){

                        Toast.makeText(nid.this,"successfully get the  name",Toast.LENGTH_SHORT).show();

                        DataSnapshot dataSnapshot=task.getResult();
                        String Name=String.valueOf(dataSnapshot.child("prename").getValue());
                        String fatherName=String.valueOf(dataSnapshot.child("fatherName").getValue());
                        String motherName=String.valueOf(dataSnapshot.child("motherName").getValue());
                        String Dob=String.valueOf(dataSnapshot.child("predob").getValue());

                        name.setText(Name);
                        fname.setText(fatherName);
                        mname.setText(motherName);
                        dob.setText(Dob);

                        //to if the data is fetching or not
//                        System.out.println("Name: "+Name);
//                        System.out.println("FName: "+fatherName);
//                        System.out.println("MName: "+motherName);
//                        System.out.println("DOB: "+Dob);

                    }else {
                        Toast.makeText(nid.this,"username not found",Toast.LENGTH_SHORT).show();


                    }

                }else {
                    Toast.makeText(nid.this,"failed to read",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
//nid number uniq and birth id also
//next week work
