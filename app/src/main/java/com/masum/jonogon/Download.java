package com.masum.jonogon;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Download extends AppCompatActivity {
    LinearLayout b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        b1 = findViewById(R.id.birthid);
        b2 = findViewById(R.id.nid);

        //done its work the download button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String currentid = user.getUid();
                DocumentReference reference;
                FirebaseFirestore firestore = FirebaseFirestore.getInstance();

                reference = firestore.collection("Registration").document(currentid);
                reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.getResult().exists()){
                            DocumentSnapshot dataSnapshot = task.getResult();

                            String Varify = task.getResult().getString("varify");
                            int intVarify = Integer.parseInt(Varify);
                            System.out.println("IntValue of Varify:"+intVarify);
                            if (intVarify==1){
                                Intent intent=new Intent(Download.this,birthcard.class);
                                startActivity(intent);
                            }else {
                                new AlertDialog.Builder(v.getContext())
                                        .setTitle("Sorry")
                                        .setMessage("Your Certificate is on process")

                                        .setNegativeButton("Back", null)
                                        .show();
                                //Toast.makeText(Download.this, "Your Certificate is on process", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            new AlertDialog.Builder(v.getContext())
                                    .setTitle("Download")
                                    .setMessage("Please Register First")

                                    .setNegativeButton("Back", null)
                                    .show();
                            //this will show popup text to REgister first


                        }
                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //nid download conditions

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String currentid = user.getUid();
                DocumentReference reference;
                FirebaseFirestore firestore = FirebaseFirestore.getInstance();

                reference = firestore.collection("Registration").document(currentid);
                reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.getResult().exists()){
                            DocumentSnapshot dataSnapshot = task.getResult();
                            //birth date fetching

                            String DOB = task.getResult().getString("predob");
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                            Date birthdate = new Date();
                            try {
                                birthdate = formatter.parse(DOB);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }



                            Calendar dob = Calendar.getInstance();
                            dob.setTime(birthdate);
                            Calendar today = Calendar.getInstance();
                            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

                            System.out.println("your Age is :"+age);

//                            if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
//                                age--;
//                            } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
//                                    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
//                                age--;
//                            }
                            if (age >= 18) {
                                Intent intent = new Intent(Download.this, nid_Card.class);
                                startActivity(intent);
                            }


                            else {
                                new AlertDialog.Builder(Download.this)
                                        .setTitle("Sorry")
                                        .setMessage("You must be at least 18 years old to proceed.")

                                        .setNegativeButton("Back", null)
                                        .show();
                            }
                        }
                        else {
                            new AlertDialog.Builder(Download.this)
                                    .setTitle("NID")
                                    .setMessage("Please Register First")

                                    .setNegativeButton("Back", null)
                                    .show();
                        }
                    }
                });





            }
        });

    }
}


//    private void getnid() {
//
//        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
//        String currentid=user.getUid();
//        DocumentReference reference;
//        FirebaseFirestore firestore=FirebaseFirestore.getInstance();
//
//        reference=firestore.collection("Registration").document(currentid);
//        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//
//                if (task.getResult().exists()){
//                    DocumentSnapshot dataSnapshot=task.getResult();
//                    String Dob=task.getResult().getString("predob");
//
//                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyy", Locale.getDefault());
//                    try {
//                        Date dob = (Date) dateFormat.parse(Dob);
//                        int age = getAge(Date.valueOf(Dob));
//                        if (age < 18) {
//                            Toast.makeText(Download.this, "Your Below Age to get your NID", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Intent intent = new Intent(Download.this, nid_Card.class);
//                            startActivity(intent);
//                        }
//                    }catch (Exception e){
//                        Toast.makeText(Download.this, "Error ", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//            }
//
//
//        });
//    }
//
//    private int getAge(Date dob) {
//    Calendar today=Calendar.getInstance();
//    Calendar birthdate=Calendar.getInstance();
//    int age=today.get(Calendar.YEAR)-birthdate.get(Calendar.YEAR);
//    if (today.get(Calendar.DAY_OF_YEAR)<birthdate.get(Calendar.DAY_OF_YEAR))
//
//    {
//        age--;
//    }
//    return age;
//    }



