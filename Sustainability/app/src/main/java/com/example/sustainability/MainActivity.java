package com.example.sustainability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity<set> extends AppCompatActivity {

    private EditText emailcheck,passwordcheck;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         emailcheck=(EditText) findViewById(R.id.email);
        passwordcheck=(EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailcheck.getText().toString().equals("abc@gmail.com") && passwordcheck.getText().toString().equals("abc"))
                {
                    Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"login failed",Toast.LENGTH_SHORT).show();
                }
                String emailtext=emailcheck.getText().toString();
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("username",emailtext);
                startActivity(i);


            }
        });

    }
}