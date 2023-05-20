package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class serviceproviderregister extends AppCompatActivity {

   String selectedservice;
    DBHelper DB;
    EditText serviceproviderusername,serviceprovideremail,serviceproviderpassword,serviceprovidermobile,serviceprovideraddress,serviceprovidercity;
    Spinner serviceSpinner;
    Button serviceproviderregisternbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_serviceproviderregister);
        serviceSpinner = findViewById(R.id.serviceSpinner);
        serviceproviderusername = findViewById(R.id.serviceproviderusername);
        serviceprovideremail = findViewById(R.id.serviceprovideremail);
        serviceproviderpassword = findViewById(R.id.serviceproviderpassword);
        serviceprovidermobile = findViewById(R.id.serviceprovidermobile);
        serviceprovideraddress = findViewById(R.id.serviceprovideraddress);
        serviceprovidercity = findViewById(R.id.serviceprovidercity);
        serviceproviderregisternbtn = findViewById(R.id.serviceproviderregisternbtn);

        DB = new DBHelper(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.service_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceSpinner.setAdapter(adapter);

        serviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedservice = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        serviceproviderregisternbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serviceproviderusername1 = serviceproviderusername.getText().toString();
                String serviceprovideremail1 = serviceprovideremail.getText().toString();
                String serviceproviderpassword1 = serviceproviderpassword.getText().toString();
                String serviceprovidermobile1 = serviceprovidermobile.getText().toString();
                String serviceprovideraddress1 = serviceprovideraddress.getText().toString();
                String serviceprovidercity1 = serviceprovidercity.getText().toString();

                if(TextUtils.isEmpty(serviceproviderusername1) || TextUtils.isEmpty(serviceprovideremail1) || TextUtils.isEmpty(serviceproviderpassword1) || TextUtils.isEmpty(serviceprovidermobile1) || TextUtils.isEmpty(serviceprovideraddress1) || TextUtils.isEmpty(serviceprovidercity1) || TextUtils.isEmpty(selectedservice))
                    Toast.makeText(serviceproviderregister.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                else {
                    if(selectedservice.equals("Plumber")){
                        Boolean checkuser = DB.checkplumberemail(serviceprovideremail1);
                    if (checkuser == false) {
                        Boolean insert = DB.insertPlumberData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                        if (insert == true) {
                            Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(serviceproviderregister.this, "Plumber Already exists with same email", Toast.LENGTH_SHORT).show();
                    }
                }
                    else if(selectedservice.equals("Painting")){
                        Boolean checkuser = DB.checkpainteremail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertPainterData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Painter Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }

                   else if(selectedservice.equals("Car mechanic")){
                        Boolean checkuser = DB.checkcarmechanicemail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertCarmechanicData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Car mechanic Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("Electrician")){
                        Boolean checkuser = DB.checkelectricianmail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertElectricianData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Electrician Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("House cleaning")){
                        Boolean checkuser = DB.checkcleanermail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertHousecleaningData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "House cleaner Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("Appliance")){
                        Boolean checkuser = DB.checkappliancerepairmail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertAppliancerepairData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Appliance repair Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("Tree cutting")){
                        Boolean checkuser = DB.checktreecuttermail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertTreecutterData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Tree cutter Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("Gardening")){
                        Boolean checkuser = DB.checkgardenermail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertGardeningData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Gardener Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("Cook")){
                        Boolean checkuser = DB.checkcookmail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertCookData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Cook Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(selectedservice.equals("Driver")){
                        Boolean checkuser = DB.checkdrivermail(serviceprovideremail1);
                        if (checkuser == false) {
                            Boolean insert = DB.insertDriverData(serviceproviderusername1, serviceprovideremail1, serviceproviderpassword1, serviceprovidermobile1, serviceprovideraddress1, serviceprovidercity1);
                            if (insert == true) {
                                Toast.makeText(serviceproviderregister.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(serviceproviderregister.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(serviceproviderregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(serviceproviderregister.this, "Driver Already exists with same email", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}