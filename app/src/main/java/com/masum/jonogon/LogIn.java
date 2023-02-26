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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {

    TextView supbutton,login;
    EditText email,pass;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    FirebaseFirestore firebaseFirestore;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        supbutton= findViewById(R.id.signupbutton);



        login=findViewById(R.id.login);
        email=findViewById(R.id.lemail);
        pass=findViewById(R.id.lpassword);

        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog= new ProgressDialog(this);
        supbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                String password=pass.getText().toString();

                //admin
                String admin_email="^(?=^[A-Za-z0-9._%+-]+@)(?=.*admin\\.com$).+";
                Pattern adminp=Pattern.compile(admin_email);
                Matcher adminm=adminp.matcher(Email);

                //user
                String user_email="^(?=^[A-Za-z0-9._%+-]+@)(?=.*gmail\\.com$).+";
                Pattern userp=Pattern.compile(user_email);
                Matcher userm=userp.matcher(Email);


                if(isEmpty(Email)){
                    email.setError("Email can't empty");
                    pass.requestFocus();
                }

                else if(isEmpty(password)){
                    pass.setError("password can't empty");
                    pass.requestFocus();
                }
              else{
                  if (adminm.matches()){

                      firebaseAuth.signInWithEmailAndPassword(Email,password)
                              .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                  @Override
                                  public void onSuccess(AuthResult authResult) {

                                      Intent intent=new Intent(LogIn.this,admin.class);
                                      startActivity(intent);
                                      finish();


                                      Toast.makeText(LogIn.this," LogIn Successfull", Toast.LENGTH_SHORT).show();
                                      progressDialog.cancel();


                                  }
                              })
                              .addOnFailureListener(new OnFailureListener() {
                                  @Override
                                  public void onFailure(@NonNull Exception e) {
                                      Toast.makeText(LogIn.this," LogIn Failed", Toast.LENGTH_LONG).show();


                                      progressDialog.cancel();





                                  }
                              });

                  }
                  else if (userm.matches()){
                      firebaseAuth.signInWithEmailAndPassword(Email,password)
                              .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                  @Override
                                  public void onSuccess(AuthResult authResult) {

                                      Intent intent=new Intent(LogIn.this,Home.class);
                                      startActivity(intent);
                                      finish();


                                      Toast.makeText(LogIn.this," LogIn Successfull", Toast.LENGTH_SHORT).show();
                                      progressDialog.cancel();


                                  }
                              })
                              .addOnFailureListener(new OnFailureListener() {
                                  @Override
                                  public void onFailure(@NonNull Exception e) {
                                      Toast.makeText(LogIn.this," LogIn Failed", Toast.LENGTH_LONG).show();


                                      progressDialog.cancel();





                                  }
                              });



                    }




                }



            }
        });


    }
}