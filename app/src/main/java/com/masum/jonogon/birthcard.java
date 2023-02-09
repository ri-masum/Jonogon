package com.masum.jonogon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;

public class birthcard extends AppCompatActivity {
    TextView registerno,dayofregister,birthid,name,dob,sex,birthplace,parmanetaddr,fname,fnid,fbirthid,fnation,mname,mnid,mbirthid,mnation;
    DatabaseReference reference;
    EditText entername;
    Button B;

    ProgressDialog progressDialog;


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
        progressDialog= new ProgressDialog(this);



//
        getdata();






    }

    private void getdata() {

        progressDialog.show();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String currentid=user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore=FirebaseFirestore.getInstance();

        reference=firestore.collection("Registration").document(currentid);
        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()){
                        DocumentSnapshot dataSnapshot=task.getResult();

                        //current date show
                        Date date= Calendar.getInstance().getTime();
                        dayofregister.setText(date.toString());

                        String Name=task.getResult().getString("prename");
                        String fatherName=task.getResult().getString("fatherName");
                        String motherName=task.getResult().getString("motherName");
                        String Dob=task.getResult().getString("predob");
                        String Sex=task.getResult().getString("pregender");
                        String  BirthPlace=task.getResult().getString("district");
                        String ParmanentAddr=task.getResult().getString("pardistrict");
                        String Fnid=task.getResult().getString("fatherNID");
                        String Fbirthid=task.getResult().getString("fatherBirthID");
                        String Fnation=task.getResult().getString("fatherNation");
                        String Mnid=task.getResult().getString("motherNID");
                        String Mbirthid=task.getResult().getString("motherBirthID");
                        String Mnation=task.getResult().getString("motherNation");
                        String BirthID=task.getResult().getString("birthId");


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
                        //br random number
                        birthid.setText(BirthID);

                        progressDialog.cancel();
                      //  birthid.setText(Integer.toString(val));
//
//
//                        //to if the data is fetching or not
//                        System.out.println("Name: "+Name);
//                        System.out.println("FName: "+fatherName);
//                        System.out.println("MName: "+motherName);
//                        System.out.println("DOB: "+Dob);
//



                }else {
                    Toast.makeText(birthcard.this,"failed to fetch",Toast.LENGTH_SHORT).show();
                }


            }
        });









    }

//do not need this code but if needed in future then i will use it so lets stay them over here



//    private void readData(String username) {
//        reference= FirebaseDatabase.getInstance().getReference("Registration");
//        reference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//
//
//                if (task.isSuccessful()){
//
//                    if (task.getResult().exists()){
//                        //random numebr genarate
//                        //random numnber genarate
//
//                        Random random= new Random();
//                        int val=random.nextInt(999999999)+20;
//                        System.out.println("random :"+val);
//
//                        Toast.makeText(birthcard.this,"successfully get the  name",Toast.LENGTH_SHORT).show();
//
//                        DataSnapshot dataSnapshot=task.getResult();
//
//                        //current date show
//                        Date date= Calendar.getInstance().getTime();
//                        dayofregister.setText(date.toString());
//
//
//
//                        //value fetch from database
//                        String Name=String.valueOf(dataSnapshot.child("prename").getValue());
//                        String fatherName=String.valueOf(dataSnapshot.child("fatherName").getValue());
//                        String motherName=String.valueOf(dataSnapshot.child("motherName").getValue());
//                        String Dob=String.valueOf(dataSnapshot.child("predob").getValue());
//                        String Sex=String.valueOf(dataSnapshot.child("pregender").getValue());
//                        String BirthPlace=String.valueOf(dataSnapshot.child("district").getValue());
//                        String ParmanentAddr=String.valueOf(dataSnapshot.child("pardistrict").getValue());
//                        String Fnid=String.valueOf(dataSnapshot.child("fatherNID").getValue());
//                        String Fbirthid=String.valueOf(dataSnapshot.child("fatherBirthID").getValue());
//                        String Fnation=String.valueOf(dataSnapshot.child("fatherNation").getValue());
//                        String Mnid=String.valueOf(dataSnapshot.child("motherNID").getValue());
//                        String Mbirthid=String.valueOf(dataSnapshot.child("motherBirthID").getValue());
//                        String Mnation=String.valueOf(dataSnapshot.child("motherNation").getValue());
//                        String BirthID=String.valueOf(dataSnapshot.child("birthId").getValue());
//
//                        //    TextView registerno,dayofregister,birthid,name,dob,sex,birthplace,parmanetaddr,fname,fnid,fbirthid,fnation,mname,mnid,mbirthid,mnation;
//
//                        name.setText(Name);
//                        fname.setText(fatherName);
//                        mname.setText(motherName);
//                        dob.setText(Dob);
//                        sex.setText(Sex);
//                        birthplace.setText(BirthPlace);
//                        parmanetaddr.setText(ParmanentAddr);
//                        fnid.setText(Fnid);
//                        fbirthid.setText(Fbirthid);
//                        fnation.setText(Fnation);
//                        mnid.setText(Mnid);
//                        mbirthid.setText(Mbirthid);
//                        mnation.setText(Mnation);
//                        //br random number
//                        birthid.setText(BirthID);
//
//                      //  birthid.setText(Integer.toString(val));
//
//
//                        //to if the data is fetching or not
//                        System.out.println("Name: "+Name);
//                        System.out.println("FName: "+fatherName);
//                        System.out.println("MName: "+motherName);
//                        System.out.println("DOB: "+Dob);
//
//                    }else {
//                        Toast.makeText(birthcard.this,"username not found",Toast.LENGTH_SHORT).show();
//
//
//                    }
//
//                }else {
//                    Toast.makeText(birthcard.this,"failed to read",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });

//    }
}