package com.example.sustainability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class RewardActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView reward1,reward2,reward3;
    private ImageButton btnhome;
    private ImageButton btnreport;
    private ImageButton btnreward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        reward1 = (CardView) findViewById(R.id.reward1);
        reward2 = (CardView) findViewById(R.id.reward2);
        reward3 = (CardView) findViewById(R.id.reward3);

        reward1.setOnClickListener(this);
        reward2.setOnClickListener(this);
        reward3.setOnClickListener(this);
        btnhome=(ImageButton) findViewById(R.id.home_btn);
        btnreward=(ImageButton) findViewById(R.id.rewards_btn);
        btnreport=(ImageButton) findViewById(R.id.report_btn);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RewardActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        btnreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RewardActivity.this,ReportActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(RewardActivity.this,"Copied",Toast.LENGTH_SHORT).show();
    }
}