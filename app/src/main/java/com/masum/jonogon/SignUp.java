package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {
    EditText regname,regemail,regpass;
    Button signup;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regname=findViewById(R.id.name);
        regemail=findViewById(R.id.email);
        regpass=findViewById(R.id.password);
        signup=findViewById(R.id.join);
        progressDialog= new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore= FirebaseFirestore.getInstance();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname=regname.getText().toString();
                String email=regemail.getText().toString().trim();
                String password=regpass.getText().toString();
                firebaseAuth= FirebaseAuth.getInstance();
                firebaseFirestore= FirebaseFirestore.getInstance();

                if(isEmpty(fullname)){
                    regname.setError("Name can't empty");
                    regname.requestFocus();
                }

                else if(isEmpty(email)){
                    regemail.setError("email can't empty");
                    regemail.requestFocus();
                }

                else if(isEmpty(password)){
                    regpass.setError("password cab't empty");
                    regpass.requestFocus();
                }
                else
                {

                    progressDialog.show();

                    firebaseAuth.createUserWithEmailAndPassword(email ,password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    progressDialog.cancel();



                                    firebaseFirestore.collection("NewUser").document(FirebaseAuth.getInstance().getUid())
                                            .set(new UserModel(fullname,email,password));
                                    Toast.makeText(SignUp.this,"Registation Successfull", Toast.LENGTH_LONG).show();

                                    Intent intent=new Intent(SignUp.this,LogIn.class);
                                    startActivity(intent);
                                    finish();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.cancel();

                                    Toast.makeText(SignUp.this,"Registation Failed", Toast.LENGTH_LONG).show();

                                }
                            });



                }


            }
        });



    }
}