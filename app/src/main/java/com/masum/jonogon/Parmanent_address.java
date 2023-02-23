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

import java.util.ArrayList;

public class Parmanent_address extends AppCompatActivity {
    Spinner district, upazila, ward, union;
    Button submit;
    EditText parhome, parvillage, parpostoffice, parpostalcode;//for database par=parmanent
    ArrayList<String > Barisal,Chattogram,Dhaka,Kulna,Mymensingh,Rajshahi,Rangpur,Sylhet;

    ArrayList<String >arrayList_district;
    ArrayAdapter<String >arrayAdapter_district;
    ArrayAdapter<String >arrayAdapter_upazila;
    ArrayList<String >arrayList_upazila;



    String[] ward1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] union1 = {"Joychandi", "Prithim pasha", "Baramchal", "Bhukshimal", "Bhatera", "Kulaura"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parmanent_address);
        submit = findViewById(R.id.parmanent_submit);
        parhome = findViewById(R.id.parmanent_home);
        parvillage = findViewById(R.id.parmanent_village);
        parpostoffice = findViewById(R.id.parmanent_postoffice);
        parpostalcode = findViewById(R.id.parmanent_postalcode);

        district = findViewById(R.id.parmanent_district);

        upazila = findViewById(R.id.parmanent_upazila);
        ward = findViewById(R.id.parmanent_ward_no);
        union = findViewById(R.id.parmanent_union);
        //new add hocce eikane so kaj na korle soraia dibo

        api();

//        //district
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, district1);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        district.setAdapter(adapter);//district

//        //upazila
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, upazila1);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        upazila.setAdapter(adapter1);//upazila

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
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, ward1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ward.setAdapter(adapter2);//ward

        //union
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, union1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        union.setAdapter(adapter3);//union

        upazila.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                Toast.makeText(Parmanent_address.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                Toast.makeText(Parmanent_address.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        union.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(Parmanent_address.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String PARDistrict = district.getSelectedItem().toString();//PAR=Parmanent
                String PARUpazila = upazila.getSelectedItem().toString();
                String PARWard = ward.getSelectedItem().toString();
                String PARUnion = union.getSelectedItem().toString();//spinner value selected

                String PARHome = parhome.getText().toString();//edittext value
                String PARVillage = parvillage.getText().toString();//edittext value
                String PARPostOffice = parpostoffice.getText().toString();//edittext value
                String PARPostalCode = parpostalcode.getText().toString();//edittext value


                String District = getIntent().getExtras().getString("Baby_District", "Baby_District");
                String Upazila = getIntent().getExtras().getString("Baby_Upazila", "Baby_Upazila");
                String Ward = getIntent().getExtras().getString("Baby_Ward", "Baby_Ward");
                String Union = getIntent().getExtras().getString("Baby_Union", "Baby_Union");
                String Home = getIntent().getExtras().getString("Baby_Homet", "Baby_Home");
                String Village = getIntent().getExtras().getString("Baby_Village", "Baby_Village");
                String PostOffice = getIntent().getExtras().getString("Baby_Postoffice", "Baby_Postoffice");
                String PostalCode = getIntent().getExtras().getString("Baby_Postalcode", "Baby_Postalcode");
                String FatherName = getIntent().getExtras().getString("Baby_FatherName", "Baby_FatherName");
                String FatherNID = getIntent().getExtras().getString("Baby_FatherNID", "Baby_FatherNID");
                String FatherBirthID = getIntent().getExtras().getString("Baby_FatherBirthID", "Baby_FatherBirthID");
                String FatherNation = getIntent().getExtras().getString("Baby_FatherNation", "Baby_FatherNation");
                String MotherName = getIntent().getExtras().getString("Baby_MotherName", "Baby_MotherName");
                String MotherNID = getIntent().getExtras().getString("Baby_MotherNID", "Baby_MotherNID");
                String MotherBirthID = getIntent().getExtras().getString("Baby_MotherBirthID", "Baby_MotherBirthID");
                String MotherNation = getIntent().getExtras().getString("Baby_MotherNation", "Baby_MotherNation");
                String Number = getIntent().getExtras().getString("Baby_GuridanNumber", "Baby_GuridanNumber");


                if(isEmpty(PARHome)){
                    parhome.setError("Home can't empty");
                    parhome.requestFocus();
                }
                else if(isEmpty(PARVillage)){
                    parvillage.setError("Select Your Village");
                    parvillage.requestFocus();

                }
                else if(PostalCode.length()<=3){
                    parpostalcode.setError("postalcode contain 5 digit");
                    parpostalcode.requestFocus();

                }
                else if(PostOffice.length()<4){

                    parpostoffice.setError("postoffice invalid");
                    parpostoffice.requestFocus();

                }else{
                Intent intent = new Intent(Parmanent_address.this, Present_address.class);
                //birthplace declaration
                intent.putExtra("Baby_District", District);
                intent.putExtra("Baby_Upazila", Upazila);
                intent.putExtra("Baby_Ward", Ward);
                intent.putExtra("Baby_Union", Union);
                intent.putExtra("Baby_Home", Home);
                intent.putExtra("Baby_Village", Village);
                intent.putExtra("Baby_Postoffice", PostOffice);
                intent.putExtra("Baby_Postalcode", PostalCode);
                //mother and father info declaration
                intent.putExtra("Baby_FatherName", FatherName);
                intent.putExtra("Baby_FatherNID", FatherNID);
                intent.putExtra("Baby_FatherBirthID", FatherBirthID);
                intent.putExtra("Baby_FatherNation", FatherNation);
                intent.putExtra("Baby_MotherName", MotherName);
                intent.putExtra("Baby_MotherNID", MotherNID);
                intent.putExtra("Baby_MotherBirthID", MotherBirthID);
                intent.putExtra("Baby_MotherNation", MotherNation);
                intent.putExtra("Baby_GuridanNumber", Number);
//parmanent address declearation
                intent.putExtra("Baby_PARDistrict", PARDistrict);
                intent.putExtra("Baby_PARUpazila", PARUpazila);
                intent.putExtra("Baby_PARWard", PARWard);
                intent.putExtra("Baby_PARUnion", PARUnion);
                intent.putExtra("Baby_PARHome", PARHome);
                intent.putExtra("Baby_PARVillage", PARVillage);
                intent.putExtra("Baby_PARPostOffice", PARPostOffice);
                intent.putExtra("Baby_PARPostalCode", PARPostalCode);
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
