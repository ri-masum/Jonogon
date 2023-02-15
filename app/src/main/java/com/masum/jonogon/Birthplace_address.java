package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

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

public class Birthplace_address extends AppCompatActivity {
    Spinner district,upazila,ward,union;//for database and spinner
    Button submit;
    EditText home,village,postoffice,postalcode;//for database

    String[] district1={"Dhaka","Moulvibazer","Chattogram","Sylhet","Kulna","Faridpur","Cumilla"};//these are the items
    String[] ward1={"1","2","3","4","5","6","7","8","9"};//these are the items
    String[] union1={"Joychandi","Prithim pasha","Baramchal","Bhukshimal","Bhatera","Kulaura"};//these are the items

    String[] upazila1={"Barlekha","Juri","Kamalganj","Kulaura","Moulvibazer_Sadar","Rajnagar","Srimangal"};//these are the items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthplace_address);

        submit=findViewById(R.id.birthplace_submit);
        home=findViewById(R.id.birthplace_home);
        village=findViewById(R.id.birthplace_village);
        postoffice=findViewById(R.id.birthplace_postoffice);
        postalcode=findViewById(R.id.birthplace_postalcode);


        district=findViewById(R.id.baby_district);//declearation
        upazila=findViewById(R.id.baby_upazila);
        ward=findViewById(R.id.birthplace_ward_no);
        union=findViewById(R.id.birthplace_union);

        //district
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,district1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district.setAdapter(adapter);//district

        //upazila
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,upazila1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upazila.setAdapter(adapter1);//upazila

        //ward
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,ward1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ward.setAdapter(adapter2);//ward

        //union
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,union1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        union.setAdapter(adapter3);//union

        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Birthplace_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        upazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Birthplace_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Birthplace_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        union.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
//                Toast.makeText(Birthplace_address.this,value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });//spinner works done

        //button work for goinging next page
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //spinner value store korte ektu differnt key use korte hoy

                String District = district.getSelectedItem().toString();
                String Upazila = upazila.getSelectedItem().toString();
                String Ward = ward.getSelectedItem().toString();
                String Union = union.getSelectedItem().toString();//spinner value selected

                String Home=home.getText().toString();//edittext value
                String Village=village.getText().toString();//edittext value
                String PostOffice=postoffice.getText().toString();//edittext value
                String PostalCode=postalcode.getText().toString();//edittext value





                if(isEmpty(Home)){
                    home.setError("Enter Home address");
                    home.requestFocus();
                }

                else if(isEmpty(Village)){
                    village.setError("village");
                    village.requestFocus();

                }
                else if(isEmpty(PostalCode)){
                    postalcode.setError("postalcode");
                    postalcode.requestFocus();

                }
                else if(isEmpty(PostOffice)){
                    postoffice.setError("postoffice");
                    postoffice.requestFocus();

                }
                else{

                Intent intent= new Intent(Birthplace_address.this,Mother_Father_Info.class);
                intent.putExtra("Baby_District",District);
                intent.putExtra("Baby_Upazila",Upazila);
                intent.putExtra("Baby_Ward",Ward);
                intent.putExtra("Baby_Union",Union);
                intent.putExtra("Baby_Home",Home);
                intent.putExtra("Baby_Village",Village);
                intent.putExtra("Baby_Postoffice",PostOffice);
                intent.putExtra("Baby_Postalcode",PostalCode);



                startActivity(intent);

            }}
        });



    }
}