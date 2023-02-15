package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import kotlin.random.URandomKt;

public class Present_address extends AppCompatActivity {
     long idCounter = 2012020100;

    Present_address idNumber;

    Spinner district,upazila,ward,union,gender;
    EditText prehome,previllage,prepostoffice,prepostalcode,name;
    Button submit;
    FirebaseDatabase firebaseDatabase;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    TextView dob;
    ProgressDialog progressDialog;

    int year,month,day;
    //to make the registation buttion disable




    String[] district1={"Dhaka","Moulvibazer","Chattogram","Sylhet","Kulna","Faridpur","Cumilla"};
    String[] gender1={"Male","Female","Other"};
    String[] ward1={"1","2","3","4","5","6","7","8","9"};
    String[] union1={"Joychandi","Prithim pasha","Baramchal","Bhukshimal","Bhatera","Kulaura"};

    String[] upazila1={"Barlekha","Juri","Kamalganj","Kulaura","Moulvibazer_Sadar","Rajnagar","Srimangal"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_address);
        prehome=findViewById(R.id.present_home);
        previllage=findViewById(R.id.present_village);
        prepostoffice=findViewById(R.id.present_postoffice);
        prepostalcode=findViewById(R.id.present_postalcode);
        submit=findViewById(R.id.present_submit);

        district=findViewById(R.id.present_district);
        upazila=findViewById(R.id.present_upazila);
        ward=findViewById(R.id.present_ward_no);
        union=findViewById(R.id.present_union);
        gender=findViewById(R.id.gender);
        dob=findViewById(R.id.dob);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        //don wanna use this anymore so remve korte hobe as soon as

        //idCounter =idCounter++;

        name=findViewById(R.id.Baby_name);
        final Calendar calendar=Calendar.getInstance();//called Calendar
        dob.setOnClickListener(new View.OnClickListener() {// dob=date of birth
            @Override
            public void onClick(View v) {
                //here i add calender for pick date of birth

                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog= new DatePickerDialog(Present_address.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob.setText(dayOfMonth+"-"+(month+1)+"-"+year);

                    }
                },year,month,day);
                datePickerDialog.show();//this  line is for show the dialog box of calender



            }
        });

        //gender
        ArrayAdapter<String> adapter0=new ArrayAdapter<>(Present_address.this, android.R.layout.simple_list_item_1,gender1);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter0);//gender

        //district
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Present_address.this, android.R.layout.simple_list_item_1,district1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district.setAdapter(adapter);//district

        //upazila
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(Present_address.this, android.R.layout.simple_list_item_1,upazila1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upazila.setAdapter(adapter1);//upazila

        //ward
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(Present_address.this, android.R.layout.simple_list_item_1,ward1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ward.setAdapter(adapter2);//ward

        //union
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(Present_address.this, android.R.layout.simple_list_item_1,union1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        union.setAdapter(adapter3);//union

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(Present_address.this,value,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Present_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        upazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Present_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Present_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        union.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Present_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //birthplace address

                //trying to make conditions

                int value=0;
              String  varify= String.valueOf(value);
//nid number given
//
////trying to make nid numebr

///// Reference to the database
//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                String PREName=name.getText().toString();
                String PREDOB=dob.getText().toString();
                String PREGender=gender.getSelectedItem().toString();//PAR=Parmanent
                String PREDistrict = district.getSelectedItem().toString();
                String PREUpazila = upazila.getSelectedItem().toString();
                String PREWard = ward.getSelectedItem().toString();
                String PREUnion = union.getSelectedItem().toString();//spinner value selected

                String PREHome=prehome.getText().toString();//edittext value
                String PREVillage=previllage.getText().toString();//edittext value
                String PREPostOffice=prepostoffice.getText().toString();//edittext value
                String PREPostalCode=prepostalcode.getText().toString();//edittext value
                firebaseAuth= FirebaseAuth.getInstance();
                firebaseFirestore= FirebaseFirestore.getInstance();


                //have to code for must input the values in the box




                //upper

                String District=getIntent().getExtras().getString("Baby_District","Baby_District");
                String Upazila=getIntent().getExtras().getString("Baby_Upazila","Baby_Upazila");
                String Ward=getIntent().getExtras().getString("Baby_Ward","Baby_Ward");
                String Union=getIntent().getExtras().getString("Baby_Union","Baby_Union");
                String Home=getIntent().getExtras().getString("Baby_Homet","Baby_Home");
                String Village=getIntent().getExtras().getString("Baby_Village","Baby_Village");
                String PostOffice=getIntent().getExtras().getString("Baby_Postoffice","Baby_Postoffice");
                String PostalCode=getIntent().getExtras().getString("Baby_Postalcode","Baby_Postalcode");
                //mother father info
                String FatherName=getIntent().getExtras().getString("Baby_FatherName","Baby_FatherName");
                String FatherNID=getIntent().getExtras().getString("Baby_FatherNID","Baby_FatherNID");
                String FatherBirthID=getIntent().getExtras().getString("Baby_FatherBirthID","Baby_FatherBirthID");
                String FatherNation=getIntent().getExtras().getString("Baby_FatherNation","Baby_FatherNation");
                String MotherName=getIntent().getExtras().getString("Baby_MotherName","Baby_MotherName");
                String MotherNID=getIntent().getExtras().getString("Baby_MotherNID","Baby_MotherNID");
                String MotherBirthID=getIntent().getExtras().getString("Baby_MotherBirthID","Baby_MotherBirthID");
                String MotherNation=getIntent().getExtras().getString("Baby_MotherNation","Baby_MotherNation");
                String Number=getIntent().getExtras().getString("Baby_GuridanNumber","Baby_GuridanNumber");

                //parmanent address
                String PARDistrict=getIntent().getExtras().getString("Baby_PARDistrict","Baby_PARDistrict");
                String PARUpazila=getIntent().getExtras().getString("Baby_PARUpazila","Baby_PARUpazila");
                String PARWard=getIntent().getExtras().getString("Baby_PARWard","Baby_PARWard");
                String PARUnion=getIntent().getExtras().getString("Baby_PARUnion","Baby_PARUnion");
                String PARHome=getIntent().getExtras().getString("Baby_PARHome","Baby_PARHome");
                String PARVillage=getIntent().getExtras().getString("Baby_PARVillage","Baby_PARVillage");
                String PARPostOffice=getIntent().getExtras().getString("Baby_PARPostOffice","Baby_PARPostOffice");
                String PARPostalCode=getIntent().getExtras().getString("Baby_PARPostalcode","Baby_PARPostalcode");




                //next day work will be process from here so lets take some rest


                //Database worksss
                if(isEmpty(PREName)){
                    name.setError("Name can't empty");
                    name.requestFocus();
                }
                else if(isEmpty(PREDOB)){
                    dob.setError("Select Your BirthDate");
                    dob.requestFocus();

                }
                else if(isEmpty(PREHome)){
                    prehome.setError("Select Your BirthDate");
                    prehome.requestFocus();

                }
                else if(isEmpty(PREVillage)){
                    previllage.setError("Select Your BirthDate");
                    previllage.requestFocus();

                }
                else if(isEmpty(PREPostOffice)){
                    prepostoffice.setError("Select Your BirthDate");
                    prepostoffice.requestFocus();

                }
                else if(isEmpty(PREPostalCode)){
                    prepostalcode.setError("Select Your BirthDate");
                    prepostalcode.requestFocus();

                }


                else{
                    //random numebr genarate
                    //random numnber genarate for birth id

                    Random random= new Random();
                    int val=random.nextInt(999999999)+20;
                    String birthId=String.valueOf(val);
                  System.out.println("random :"+val);



                  //random number for nid
                    Random random1= new Random();
                    int val1=random1.nextInt(999999999)+20;
                    String nID=String.valueOf(val1);
                    System.out.println("Nid number :"+nID);






                    firebaseDatabase=FirebaseDatabase.getInstance();

                //DatabaseReference root=firebaseDatabase.getReference("Registration");
                    firebaseFirestore=FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("Registration").document(FirebaseAuth.getInstance().getUid()).set(new

                            all_data(
                            //baby info PREsent
                            PREName,PREDOB,PREGender,PREDistrict,PREUpazila,PREUnion,PREWard,PREHome,PREVillage,PREPostalCode,PREPostOffice,
                            //Father & mother info
                            FatherName,FatherNID,FatherBirthID,FatherNation,
                            MotherName,MotherNID,MotherBirthID,MotherNation,
                            Number,
                            //parmanent address data
                            PARDistrict,PARUpazila,PARWard,PARUnion,PARHome,PARVillage,PARPostOffice,PARPostalCode,

                            //
                            District,Upazila,Ward,Union,Home,Village,PostOffice,PostalCode,varify,nID,birthId

                    ));







                Intent intent= new Intent(Present_address.this,Home.class);
                //birthplace declaration
                    intent.putExtra("key","submit");

                    //birthid sending donee yeeeeeeeeeee
                    intent.putExtra("BirthID",birthId);
                    System.out.println("birthid = "+birthId);

                    intent.putExtra("nID",nID);
//                    System.out.println("NID="+nID);

                    intent.putExtra("Baby_District",District);
                intent.putExtra("Baby_Upazila",Upazila);
                intent.putExtra("Baby_Ward",Ward);
                intent.putExtra("Baby_Union",Union);
                intent.putExtra("Baby_Home",Home);
                intent.putExtra("Baby_Village",Village);
                intent.putExtra("Baby_Postoffice",PostOffice);
                intent.putExtra("Baby_Postalcode",PostalCode);
                //mother and father info declaration
                intent.putExtra("Baby_FatherName",FatherName);
                intent.putExtra("Baby_FatherNID",FatherNID);
                intent.putExtra("Baby_FatherBirthID",FatherBirthID);
                intent.putExtra("Baby_FatherNation",FatherNation);
                intent.putExtra("Baby_MotherName",MotherName);
                intent.putExtra("Baby_MotherNID",MotherNID);
                intent.putExtra("Baby_MotherBirthID",MotherBirthID);
                intent.putExtra("Baby_MotherNation",MotherNation);
                intent.putExtra("Baby_GuridanNumber",Number);
//parmanent address declearation
                intent.putExtra("Baby_PARDistrict",PARDistrict);
                intent.putExtra("Baby_PARUpazila",PARUpazila);
                intent.putExtra("Baby_PARWard",PARWard);
                intent.putExtra("Baby_PARUnion",PARUnion);
                intent.putExtra("Baby_PARHome",PARHome);
                intent.putExtra("Baby_PARVillage",PARVillage);
                intent.putExtra("Baby_PARPostOffice",PARPostOffice);
                intent.putExtra("Baby_PARPostalCode",PARPostalCode);
                //present address declearation
                intent.putExtra("Baby_PREDistrict",PREDistrict);
                intent.putExtra("Baby_PREUpazila",PREUpazila);
                intent.putExtra("Baby_PREWard",PREWard);
                intent.putExtra("Baby_PREUnion",PREUnion);
                intent.putExtra("Baby_PREHome",PREHome);
                intent.putExtra("Baby_PREVillage",PREVillage);
                intent.putExtra("Baby_PREPostOffice",PREPostOffice);
                intent.putExtra("Baby_PREPostalCode",PREPostalCode);
                intent.putExtra("Baby_PREName",PREName);
                intent.putExtra("Baby_PREDOB",PREDOB);
                intent.putExtra("Baby_PREGender",PREGender);



                startActivity(intent);
                Toast.makeText(Present_address.this,"Successfully Registerd",Toast.LENGTH_SHORT).show();
                finish();

            }}

        });
    }
}