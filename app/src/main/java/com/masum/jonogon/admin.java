package com.masum.jonogon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class admin extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> userArrayList;
    myadapter myadapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
//        getSupportFragmentManager().beginTransaction().replace(R.id.admin,new recfragment()).commit();

        ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data");
        progressDialog.show();



recyclerView=findViewById(R.id.recview);
//recyclerView.setHasFixedSize(true);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            db=FirebaseFirestore.getInstance();
            userArrayList=new ArrayList<model>();
            myadapter= new myadapter(admin.this,userArrayList);
            recyclerView.setAdapter(myadapter);
            EvenChangeListener();
        }




    }

    private void EvenChangeListener() {

        db.collection("Registration")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error!= null){

                    if (progressDialog.isShowing())
                        progressDialog.dismiss();

                    Log.e("Firestore error",error.getMessage());
                    return;
                }

                for (DocumentChange dc: value.getDocumentChanges()){
                    if (dc.getType()== DocumentChange.Type.ADDED){
                        userArrayList.add(dc.getDocument().toObject(model.class));
                    }

                }
                myadapter.notifyDataSetChanged();
                if (progressDialog.isShowing())
                    progressDialog.dismiss();


            }
        });
    }
}