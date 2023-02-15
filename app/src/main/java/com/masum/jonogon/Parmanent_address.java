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

public class Parmanent_address extends AppCompatActivity {
    Spinner district, upazila, ward, union;
    Button submit;
    EditText parhome, parvillage, parpostoffice, parpostalcode;//for database par=parmanent


    String[] district1 = {"Dhaka", "Moulvibazer", "Chattogram", "Sylhet", "Kulna", "Faridpur", "Cumilla"};
    String[] ward1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] union1 = {"Joychandi", "Prithim pasha", "Baramchal", "Bhukshimal", "Bhatera", "Kulaura"};

    String[] upazila1 = {"Barlekha", "Juri", "Kamalganj", "Kulaura", "Moulvibazer_Sadar", "Rajnagar", "Srimangal"};

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
        //district
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, district1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district.setAdapter(adapter);//district

        //upazila
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, upazila1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upazila.setAdapter(adapter1);//upazila

        //ward
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, ward1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ward.setAdapter(adapter2);//ward

        //union
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(Parmanent_address.this, android.R.layout.simple_list_item_1, union1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        union.setAdapter(adapter3);//union

        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
//                Toast.makeText(Parmanent_address.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
//                Toast.makeText(Parmanent_address.this, value, Toast.LENGTH_SHORT).show();
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
                else if(isEmpty(PARPostalCode)){
                    parpostalcode.setError("Select Your postalcode");
                    parpostalcode.requestFocus();

                }
                else if(isEmpty(PARPostOffice)){
                    parpostoffice.setError("Select Your Postoffice");
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
}
