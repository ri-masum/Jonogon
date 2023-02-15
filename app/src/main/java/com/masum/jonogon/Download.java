package com.masum.jonogon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

public class Download extends AppCompatActivity {
    LinearLayout b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        b1=findViewById(R.id.birthid);
        b2=findViewById(R.id.nid);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getnid();
                Intent intent=new Intent(Download.this,birthcard.class);
                startActivity(intent);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Download.this,nid_Card.class);
                startActivity(intent);


            }
        });
        //calling dateof birth

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
}
/**
private DatePickerDialog.OnDateSetListener dateSetListener =new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String formet=new SimpleDateFormat("dd MMM YYYY").format(c.getTime());
        String date=formet;
    }
};

    int calculateAge(long date){
        Calendar dob=Calendar.getInstance();
        dob.setTimeInMillis(date);
        Calendar today= Calendar.getInstance();
        int age=today.get(Calendar.YEAR)-dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_MONTH)<dob.get(Calendar.DAY_OF_MONTH))
        {
            age--;
        }
        return age;
    }

    }
*/


