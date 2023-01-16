package com.masum.jonogon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Mother_Father_Info extends AppCompatActivity {
    Spinner spinner1,spinner2;
    Button submit;
    EditText fathername,fathernid,fatherbirthid,mothername,mothernid,motherbirthid,phone;



    String[] country={"Bangladesh","India","America","China","other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_father_info);

        submit=findViewById(R.id.mf_submit);
        fathername=findViewById(R.id.father_name);
        fathernid=findViewById(R.id.father_nid);
        fatherbirthid=findViewById(R.id.father_birthid);
        mothername=findViewById(R.id.mother_name);
        mothernid=findViewById(R.id.mother_nid);
        motherbirthid=findViewById(R.id.mother_birthid);
        phone=findViewById(R.id.guardian_number);


        spinner1=findViewById(R.id.father_nation);//using for show country list
        spinner2=findViewById(R.id.mother_nation);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Mother_Father_Info.this, android.R.layout.simple_list_item_1,country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//this is spinner1 and it will show father country list
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(Mother_Father_Info.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//this is spinner1 and it will show mother country list
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(Mother_Father_Info.this,value,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String FatherName=fathername.getText().toString();
                String FatherNID=fathernid.getText().toString();
                String FatherBirthID=fatherbirthid.getText().toString();
                String FatherNation=spinner1.getSelectedItem().toString();
                String MotherName=mothername.getText().toString();
                String MotherNID=mothernid.getText().toString();
                String MotherBirthID=motherbirthid.getText().toString();
                String MotherNation=spinner2.getSelectedItem().toString();
                String Number=phone.getText().toString();


                String District=getIntent().getExtras().getString("Baby_District","Baby_District");
                String Upazila=getIntent().getExtras().getString("Baby_Upazila","Baby_Upazila");
                String Ward=getIntent().getExtras().getString("Baby_Ward","Baby_Ward");
                String Union=getIntent().getExtras().getString("Baby_Union","Baby_Union");
                String Home=getIntent().getExtras().getString("Baby_Homet","Baby_Home");
                String Village=getIntent().getExtras().getString("Baby_Village","Baby_Village");
                String PostOffice=getIntent().getExtras().getString("Baby_Postoffice","Baby_Postoffice");
                String PostalCode=getIntent().getExtras().getString("Baby_Postalcode","Baby_Postalcode");



                Intent intent= new Intent(Mother_Father_Info.this,Parmanent_address.class);
                intent.putExtra("Baby_District",District);
                intent.putExtra("Baby_Upazila",Upazila);
                intent.putExtra("Baby_Ward",Ward);
                intent.putExtra("Baby_Union",Union);
                intent.putExtra("Baby_Home",Home);
                intent.putExtra("Baby_Village",Village);
                intent.putExtra("Baby_Postoffice",PostOffice);
                intent.putExtra("Baby_Postalcode",PostalCode);
                intent.putExtra("Baby_FatherName",FatherName);
                intent.putExtra("Baby_FatherNID",FatherNID);
                intent.putExtra("Baby_FatherBirthID",FatherBirthID);
                intent.putExtra("Baby_FatherNation",FatherNation);
                intent.putExtra("Baby_MotherName",MotherName);
                intent.putExtra("Baby_MotherNID",MotherNID);
                intent.putExtra("Baby_MotherBirthID",MotherBirthID);
                intent.putExtra("Baby_MotherNation",MotherNation);
                intent.putExtra("Baby_GuridanNumber",Number);



                startActivity(intent);
            }
        });
    }
}