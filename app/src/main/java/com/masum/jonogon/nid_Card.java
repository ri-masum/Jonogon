package com.masum.jonogon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class nid_Card extends AppCompatActivity {
    TextView name,fname,mname,dob,nid;

    Button B;
    DatabaseReference reference;
    ProgressDialog progressDialog;
    LinearLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nid_card);
        name=findViewById(R.id.nidname);
        fname=findViewById(R.id.nidfname);
        mname=findViewById(R.id.nidmname);
        dob=findViewById(R.id.niddob);
        nid=findViewById(R.id.nidnum);
        progressDialog= new ProgressDialog(this);
        B=findViewById(R.id.downloadnid);
        layout=findViewById(R.id.niddownlaod);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage();
            }

        });



        getnid();





    }

    private void saveImage() {

        layout.setDrawingCacheEnabled(true);
        layout.buildDrawingCache();
        layout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap=layout.getDrawingCache();
        save(bitmap);
    }

    private void save(Bitmap bitmap) {
        Random random1= new Random();
        int val1=random1.nextInt(999)+20;
        String  root= Environment.getExternalStorageDirectory().getAbsolutePath();
        File file= new File(root+"/Download");
        String fileName= val1+"download.jpg";
        File myfile=new File(file,fileName);

        try {
            FileOutputStream fileOutputStream=new FileOutputStream(myfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Saveed your document successfully", Toast.LENGTH_SHORT).show();
            layout.setDrawingCacheEnabled(false);
        }catch (Exception e){
            Toast.makeText(this, "Error: "+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }




    private void getnid() {
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

                    String Name=task.getResult().getString("prename");
                    String fatherName=task.getResult().getString("fatherName");
                    String motherName=task.getResult().getString("motherName");
                    String Dob=task.getResult().getString("predob");
                    String NID=task.getResult().getString("nID");



                    progressDialog.cancel();


                    name.setText(Name);
                    fname.setText(fatherName);
                    mname.setText(motherName);
                    dob.setText(Dob);
                    //nid.setText(Integer.toString(val));
                    nid.setText(NID);





                }else {
                    Toast.makeText(nid_Card.this," Failed to fetch data", Toast.LENGTH_LONG).show();
                    progressDialog.cancel();
                }




            }
        });

    }
}