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

import java.util.Calendar;
import java.util.Date;

public class birthcard extends AppCompatActivity {
    TextView registerno,dayofregister,birthid,name,dob,sex,birthplace,parmanetaddr,fname,fnid,fbirthid,fnation,mname,mnid,mbirthid,mnation;
    DatabaseReference reference;
    EditText entername;
    Button B;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthcard);
        registerno=findViewById(R.id.registerno);
        dayofregister=findViewById(R.id.dateofreg);
        birthid=findViewById(R.id.brnumber);
        name=findViewById(R.id.birthname);
        dob=findViewById(R.id.birthdob);
        sex=findViewById(R.id.sex);
        birthplace=findViewById(R.id.placeofbirth);
        parmanetaddr=findViewById(R.id.parmanentaddress);
        fname=findViewById(R.id.fathername);
        fnid=findViewById(R.id.fathernid);
        fbirthid=findViewById(R.id.fbirthid);
        fnation=findViewById(R.id.fnationality);
        mname=findViewById(R.id.mothersname);
        mnid=findViewById(R.id.mothernid);
        mbirthid=findViewById(R.id.mbirthid);
        mnation=findViewById(R.id.mnationality);
        entername=findViewById(R.id.entername);
        B=findViewById(R.id.print2);
       B.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               //if username is match the further process will be held
               String username = entername.getText().toString();
               if (!username.isEmpty()) {
                   readData(username);
               } else {
                   Toast.makeText(birthcard.this, "did not fetch", Toast.LENGTH_SHORT).show();
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

                        Toast.makeText(birthcard.this,"successfully get the  name",Toast.LENGTH_SHORT).show();

                        DataSnapshot dataSnapshot=task.getResult();

                        //current date show
                        Date date= Calendar.getInstance().getTime();
                        dayofregister.setText(date.toString());

                        //value fetch from database
                        String Name=String.valueOf(dataSnapshot.child("prename").getValue());
                        String fatherName=String.valueOf(dataSnapshot.child("fatherName").getValue());
                        String motherName=String.valueOf(dataSnapshot.child("motherName").getValue());
                        String Dob=String.valueOf(dataSnapshot.child("predob").getValue());
                        String Sex=String.valueOf(dataSnapshot.child("pregender").getValue());
                        String BirthPlace=String.valueOf(dataSnapshot.child("district").getValue());
                        String ParmanentAddr=String.valueOf(dataSnapshot.child("pardistrict").getValue());
                        String Fnid=String.valueOf(dataSnapshot.child("fatherNID").getValue());
                        String Fbirthid=String.valueOf(dataSnapshot.child("fatherBirthID").getValue());
                        String Fnation=String.valueOf(dataSnapshot.child("fatherNation").getValue());
                        String Mnid=String.valueOf(dataSnapshot.child("motherNID").getValue());
                        String Mbirthid=String.valueOf(dataSnapshot.child("motherBirthID").getValue());
                        String Mnation=String.valueOf(dataSnapshot.child("motherNation").getValue());

                        //    TextView registerno,dayofregister,birthid,name,dob,sex,birthplace,parmanetaddr,fname,fnid,fbirthid,fnation,mname,mnid,mbirthid,mnation;

                        name.setText(Name);
                        fname.setText(fatherName);
                        mname.setText(motherName);
                        dob.setText(Dob);
                        sex.setText(Sex);
                        birthplace.setText(BirthPlace);
                        parmanetaddr.setText(ParmanentAddr);
                        fnid.setText(Fnid);
                        fbirthid.setText(Fbirthid);
                        fnation.setText(Fnation);
                        mnid.setText(Mnid);
                        mbirthid.setText(Mbirthid);
                        mnation.setText(Mnation);


                        //to if the data is fetching or not
                        System.out.println("Name: "+Name);
                        System.out.println("FName: "+fatherName);
                        System.out.println("MName: "+motherName);
                        System.out.println("DOB: "+Dob);

                    }else {
                        Toast.makeText(birthcard.this,"username not found",Toast.LENGTH_SHORT).show();


                    }

                }else {
                    Toast.makeText(birthcard.this,"failed to read",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}