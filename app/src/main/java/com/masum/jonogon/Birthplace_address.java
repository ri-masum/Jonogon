package com.masum.jonogon;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Birthplace_address extends AppCompatActivity {
    Spinner district,upazila,ward,union;//for database and spinner
    Button submit;
    EditText home,village,postoffice,postalcode;//for database

    //new add hocce eikane so kaj na korle soraia dibo
    ArrayList<String > Barisal,Chattogram,Dhaka,Kulna,Mymensingh,Rajshahi,Rangpur,Sylhet;

    ArrayList<String >arrayList_district;
    ArrayAdapter<String >arrayAdapter_district;
    ArrayAdapter<String >arrayAdapter_upazila;
    ArrayList<String >arrayList_upazila;





    String[] ward1={"1","2","3","4","5","6","7","8","9"};//these are the items
   String[] union1={"Joychandi","Prithim pasha","Baramchal","Bhukshimal","Bhatera","Kulaura"};//these are the items



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


        api();



//        //district
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,district1);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        district.setAdapter(adapter);//district

//        //upazila
//        ArrayAdapter<String> adapter1=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,Sylhet);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        upazila.setAdapter(adapter1);//upazila
//        //upazila2
//        ArrayAdapter<String> adapter1_1=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,Sylhet);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        upazila.setAdapter(adapter1_1);//upazila

        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    arrayAdapter_upazila=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Barisal);


                } else if (position==1) {
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Chattogram);



                }
                else if (position==2) {
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Dhaka);



                } else if (position==3) {
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Kulna);



                } else if (position==4) {
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Mymensingh);



                } else if (position==5) {
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Rajshahi);



                } else if (position==6) {
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Rangpur);



                }
                else if (position==7){
                    arrayAdapter_upazila =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Sylhet);


                }
                upazila.setAdapter(arrayAdapter_upazila);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ward
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,ward1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ward.setAdapter(adapter2);//ward

        //union
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(Birthplace_address.this, android.R.layout.simple_list_item_1,union1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        union.setAdapter(adapter3);//union


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
                else if(PostalCode.length()<=3){
                    postalcode.setError("postalcode contain 5 digit");
                    postalcode.requestFocus();

                }
                else if(PostOffice.length()<4){

                    postoffice.setError("postoffice invalid");
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

    private void api()  {
        //spinner value update one try to fix the issues
        arrayList_district= new ArrayList<> ();
        arrayList_district.add("Barisal");
        arrayList_district.add("Chattogram");
        arrayList_district.add("Dhaka");
        arrayList_district.add("Khulna");
        arrayList_district.add("Mymensingh");
        arrayList_district.add("Rajshahi");
        arrayList_district.add("Rangpur");
        arrayList_district.add("Sylhet");
        arrayAdapter_district=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList_district);


        district.setAdapter(arrayAdapter_district);

        //barisal upazila
        Barisal=new ArrayList<>();
        Barisal.add("Bhandaria");
        Barisal.add("Kawkhali");
        Barisal.add("Mathbaria");
        Barisal.add("Nazirpur");
        Barisal.add("Nesarabad");
        Barisal.add("Pirojpur Sadar");
        Barisal.add("Indurkani");

        //Chattogram upazila

        Chattogram=new ArrayList<>();
        Chattogram.add("Anwara");
        Chattogram.add("Banshkhali");
        Chattogram.add("Boalkhali");
        Chattogram.add("Chandanaish");
        Chattogram.add("Fatikchhari");
        Chattogram.add("Hathazari");
        Chattogram.add("Karnaphuli");
        Chattogram.add("Lohagara");

        //Dhaka upazila
        Dhaka=new ArrayList<>();
        Dhaka.add("Dhaka");
        Dhaka.add("Keraniganj");
        Dhaka.add("Nababganj");
        Dhaka.add("Dohar");
        Dhaka.add("Savar");
        Dhaka.add("Dhamrai");

        //kulna upazila

        Kulna=new ArrayList<>();
        Kulna.add("Bagherhat");
        Kulna.add("Sathkhira");
        Kulna.add("Jessore");
        Kulna.add("Magura");
        Kulna.add("Jhenaidah");
        Kulna.add("Narail");
        Kulna.add("Kushtia");
        Kulna.add("Chuadanga");
        Kulna.add("Meherpur");

        //Mymensing upazila

        Mymensingh=new ArrayList<>();
        Mymensingh.add("Mymensingh Sadar ");
        Mymensingh.add("Muktagachha");
        Mymensingh.add("Valuka");
        Mymensingh.add("Haluaghat");
        Mymensingh.add("Gouripur");
        Mymensingh.add("Dhobaura");

        //Rajshahi upazila
        Rajshahi=new ArrayList<>();
        Rajshahi.add("Bagmara");
        Rajshahi.add("Paba ");
        Rajshahi.add("Charghat");
        Rajshahi.add("Durgapur");
        Rajshahi.add("Godagari");
        Rajshahi.add("Mohanpur");

        //Rangpur upazila
        Rangpur=new ArrayList<>();
        Rangpur.add("Pirganj");
        Rangpur.add("Rangpur");
        Rangpur.add("Mithapukur");
        Rangpur.add("Kaunia");
        Rangpur.add("Gangachhara");
        Rangpur.add("Rangpur Sadar");



        //sylhet upazila
        Sylhet=new ArrayList<>();
        Sylhet.add("sylhet");
        Sylhet.add("Barlekha");
        Sylhet.add("Juri");
        Sylhet.add("Kamalganj");
        Sylhet.add("Kulaura");
        Sylhet.add("Moulvibazer_Sadar");
        Sylhet.add("Rajnagar");
        Sylhet.add("sreemangal");




    }
}