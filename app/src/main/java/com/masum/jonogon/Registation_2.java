package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Registation_2 extends AppCompatActivity {
    Button b1;//b1=next
    TextView dob;
    RadioButton gender;
    EditText birth_place;
    int year,month,day;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation2);

        gender=findViewById(R.id.female);
        b1=findViewById(R.id.next2);
        birth_place=findViewById(R.id.birthplace);
        dob=findViewById(R.id.dob);
        final Calendar calendar=Calendar.getInstance();//called Calendar

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DOB=dob.getText().toString();
                String Gender=gender.getText().toString();
                String Place_of_biryh=birth_place.getText().toString();

                if (isEmpty(DOB)){
                    dob.setError("Select date of birth");
                    dob.requestFocus();
                }
                else if (isEmpty(Gender)){
                    gender.setError("SElect Gender");
                    gender.requestFocus();
                }
                else if (isEmpty(Place_of_biryh)){
                    birth_place.setError("select birthplace");
                    birth_place.requestFocus();
                }
                else
                {
//
//

//
                    String Name = getIntent().getExtras().getString("Name","Name");
                    String Mname = getIntent().getExtras().getString("MName","MName");
                    String Fathername = getIntent().getExtras().getString("FName","FName");
                    String Mothernation = getIntent().getExtras().getString("Mnation","Mnation");
                    String Fathernation = getIntent().getExtras().getString("Fnation","Fnation");

                    Intent intent=new Intent(Registation_2.this,Registration_3.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("MName",Mname);
                    intent.putExtra("FName",Fathername);
                    intent.putExtra("Mnation",Mothernation);
                    intent.putExtra("Fnation",Fathernation);
                    intent.putExtra("DOB",DOB);
                    intent.putExtra("Gender",Gender);
                    intent.putExtra("Place_of_Birth",Place_of_biryh);


                    
                    System.out.println("DOB:"+DOB);
                    System.out.println("gender:"+Gender);
                    System.out.println("DOB:"+Place_of_biryh);


                    System.out.println("name2:"+Name);
                    System.out.println("Mname2:"+Mname);
                    System.out.println("FName2:"+Fathername);
                    System.out.println("Mnation2:"+Mothernation);
                    System.out.println("FNation2:"+Fathernation);

                    startActivity(intent);
                }

            }
        });
        dob.setOnClickListener(new View.OnClickListener() {// dob=date of birth
            @Override
            public void onClick(View v) {
                //here i add calender for pick date of birth

                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(Registation_2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                },year,month,day);
                datePickerDialog.show();//this  line is for show the dialog box of calender



            }
        });

    }
}