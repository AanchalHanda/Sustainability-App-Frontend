package com.example.sustainability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity3 extends AppCompatActivity {

    private ImageButton btnhome;
    private ImageButton btnreport;
    private ImageButton btnreward;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnhome=(ImageButton) findViewById(R.id.home_btn);
        btnreward=(ImageButton) findViewById(R.id.rewards_btn);
        btnreport=(ImageButton) findViewById(R.id.report_btn);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(i);
            }
        });
        btnreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity3.this,ReportActivity.class);
                startActivity(i);
            }
        });
        btnreward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity3.this,RewardActivity.class);
                startActivity(i);
            }
        });
    }
}