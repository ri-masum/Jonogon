package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration_3 extends AppCompatActivity {
    EditText parmanentaddr,presentaddr,number;
    FirebaseDatabase firebasedatabase;

    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration3);
        parmanentaddr=findViewById(R.id.permanent_address);
        presentaddr=findViewById(R.id.present_address);
        number=findViewById(R.id.number);
        submit=findViewById(R.id.submit);
//        final FirebaseDatabase[] firebasedatabase = new FirebaseDatabase[1];

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String praddr=parmanentaddr.getText().toString();
                String preaddr=presentaddr.getText().toString();
                String Number=number.getText().toString();
                if (isEmpty(praddr)){
                    parmanentaddr.setError("Enter parmanent address");
                    parmanentaddr.requestFocus();
                }
                else if (isEmpty(preaddr)){
                    presentaddr.setError("enter present address");

                    presentaddr.requestFocus();

                }
                else if (isEmpty((CharSequence) Number))

                {
                    number.setError("Enter Number");
                    number.requestFocus();
                }
                else
                {
//
                    String Name = getIntent().getExtras().getString("Name","Name");
                    String Mname = getIntent().getExtras().getString("MName","MName");
                    String Fathername = getIntent().getExtras().getString("FName","FName");
                    String Mothernation = getIntent().getExtras().getString("Mnation","Mnation");
                    String Fathernation = getIntent().getExtras().getString("Fnation","Fnation");
                    String DOB = getIntent().getExtras().getString("DOB","DOB");
                    String Gender = getIntent().getExtras().getString("Gender","Gender");
                    String Place_of_Birth = getIntent().getExtras().getString("Place_of_Birth","Place_of_Birth");



                    //priting the values



                    System.out.println("name:"+Name);
                    System.out.println("Mname:"+Mname);
                    System.out.println("FName:"+Fathername);
                    System.out.println("Mnation:"+Mothernation);
                    System.out.println("FNation:"+Fathernation);
                    System.out.println("DOb:"+DOB);
                    System.out.println("Gender:"+Gender);
                    System.out.println("birthplace:"+Place_of_Birth);

                    firebasedatabase =FirebaseDatabase.getInstance();


                    DatabaseReference root= firebasedatabase.getReference("Registration");

                    userHelper1 helper=new userHelper1(Name,Mname,Mothernation,Fathername,Fathernation,DOB,Gender,Place_of_Birth,praddr,preaddr,Number);
                    root.child(Name).setValue(helper);

//
//


                Toast.makeText(Registration_3.this," Your Information Has been submitted to Our database.  ", Toast.LENGTH_LONG).show();
                Toast.makeText(Registration_3.this,"  we will let you know soon when you can downlaod your Birth Card\n  ", Toast.LENGTH_LONG).show();

                }


            }
        });

    }
}