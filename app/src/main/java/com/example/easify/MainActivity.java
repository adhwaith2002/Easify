package com.example.easify;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    TextView signin,signup,serviceproviderregister;
    EditText email,password;
    Button loginbtn;
    DBHelper DB;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView google;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        serviceproviderregister = findViewById(R.id.serviceproviderregister);
        loginbtn = findViewById(R.id.loginbtn);
        DB =new DBHelper(this);
        signup = findViewById(R.id.signup);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                    Toast.makeText(MainActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkemailpassword1 = DB.checkemailpassword1(email1,password1);
                    Boolean checkemailpassword2 = DB.checkemailpassword2(email1,password1);
                    Boolean checkemailpassword3 = DB.checkemailpassword3(email1,password1);
                    Boolean checkemailpassword4 = DB.checkemailpassword4(email1,password1);
                    Boolean checkemailpassword5 = DB.checkemailpassword5(email1,password1);
                    Boolean checkemailpassword6 = DB.checkemailpassword6(email1,password1);
                    Boolean checkemailpassword7 = DB.checkemailpassword7(email1,password1);
                    Boolean checkemailpassword8 = DB.checkemailpassword8(email1,password1);
                    Boolean checkemailpassword9 = DB.checkemailpassword9(email1,password1);
                    Boolean checkemailpassword10 = DB.checkemailpassword10(email1,password1);
                    Boolean checkemailpassword11 = DB.checkemailpassword11(email1,password1);
                    if(checkemailpassword1 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,userdashboard.class);
                        intent.putExtra("key_email",email1);
                        startActivity(intent);
                    }
                    else if(checkemailpassword2 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","plumber");
                        startActivity(intent);
                    }
                    else if(checkemailpassword3 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","painter");
                        startActivity(intent);
                    }
                    else if(checkemailpassword4 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","carmechanic");
                        startActivity(intent);
                    }
                    else if(checkemailpassword5 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","electrician");
                        startActivity(intent);
                    }
                    else if(checkemailpassword6 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","housecleaner");
                        startActivity(intent);
                    }
                    else if(checkemailpassword7 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","appliancerepair");
                        startActivity(intent);
                    }
                    else if(checkemailpassword8 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","treecutter");
                        startActivity(intent);
                    }
                    else if(checkemailpassword9 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","gardener");
                        startActivity(intent);
                    }
                    else if(checkemailpassword10 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","cook");
                        startActivity(intent);
                    }
                    else if(checkemailpassword11 == true){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,serviceproviderdashboard.class);
                        intent.putExtra("key_email",email1);
                        intent.putExtra("key_table","driver");
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,register.class);
                startActivity(intent);
            }
        });

        serviceproviderregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,serviceproviderregister.class);
                startActivity(intent);
            }
        });

        google = findViewById(R.id.google);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

}





