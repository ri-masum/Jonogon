package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registation_1 extends AppCompatActivity {
    Button b1;
    EditText fullname,mname,fname;
    TextView mnation,fnation;
    ProgressBar progressBar;

    FirebaseDatabase firebasedatabase;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation1);
        fullname=findViewById(R.id.fullname);
        mname=findViewById(R.id.mfullname);
        fname=findViewById(R.id.fname);
        mnation=findViewById(R.id.mnationalty);
        fnation =findViewById(R.id.fnationality);

        progressBar=findViewById(R.id.progress);
        b1=findViewById(R.id.next1);
        progressBar.setVisibility(View.INVISIBLE );

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=fullname.getText().toString();
                String Mname=mname.getText().toString();
                String Fathername=fname.getText().toString();
                String Mothernation=mnation.getText().toString();
                String Fathernation=fnation.getText().toString();
                if (isEmpty(Name)){
                    fullname.setError("Enter full name :");
                    fullname.requestFocus();
                }
                else if(isEmpty(Mname)){
                    mname.setError("enter Mother's name");
                    mname.requestFocus();

                }
//                else if(isEmpty((CharSequence) Fathernation)){
//                    fnation.setError("enter father's name");
//                    fnation.requestFocus();
//
//                }
                else  if (isEmpty(Fathername)){
                    fname.setError("Enter father name");
                    fname.requestFocus();

                }
//                else if (isEmpty(Mothernation)){
//
//                    mnation.setError("Enter mother NAtion");
//                    mnation.requestFocus();
//
//                }
                else {

//                    firebasedatabase=FirebaseDatabase.getInstance();
//                    DatabaseReference root=firebasedatabase.getReference("Registration");
//                    userHelper helper=new userHelper(Name,Mname,Fathername,Mothernation,Fathernation);
//                    root.child(Name).setValue(helper);

                    Intent intent= new Intent(Registation_1.this,Registation_2.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("MName",Mname);
                    intent.putExtra("FName",Fathername);
                    intent.putExtra("Mnation",Mothernation);
                    intent.putExtra("Fnation",Fathernation);

                    System.out.println("name1:"+Name);
                    System.out.println("mname1:"+Mname);
                    System.out.println("fname1:"+Fathername);
                    System.out.println("Mnation1:"+Mothernation);
                    System.out.println("Fnation1:"+Fathernation);

                    startActivity(intent);
//                    Toast.makeText(Registation_1.this," Your Information Has been submitted to Our database.  ", Toast.LENGTH_LONG).show();

//                    progressBar.setVisibility(View.GONE);
              }
        }

        });
    }
}