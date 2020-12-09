package com.example.sustainability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {
    float pointsDistribution[] = {38.7f, 10.2f, 28.3f, 22.8f};
    String companies[] = {"Tesla", "Adidas", "Apple", "Amazon"};
    int companyScores[] = { 94, 85, 91, 73};
    int monthly[] = {2678,3958,4215,1379,2579};
    String months[] = {"Aug","Sep","Oct","Nov","Dec"};
    private ImageButton btnhome;
    private ImageButton btnreport;
    private ImageButton btnreward;
    private ImageButton btnreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        //getActionBar().hide();
        setUpPieChart();
        setUpBarChart();

        btnhome=(ImageButton) findViewById(R.id.home_btn);
        btnreward=(ImageButton) findViewById(R.id.rewards_btn);
        btnreport=(ImageButton) findViewById(R.id.report_btn);
        btnreco = (ImageButton) findViewById(R.id.recommendation_btn);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ReportActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        btnreward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ReportActivity.this,RewardActivity.class);
                startActivity(i);
            }
        });
        btnreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ReportActivity.this,MainActivity3.class);
                startActivity(i);
            }
        });

    }



    public class MyPieDataSet extends PieDataSet {
        int infoArray[];
        public MyPieDataSet(List<PieEntry> yVals, String label, int array[]) {
            super(yVals, label);
            this.infoArray = array;
        }

        @Override
        public int getColor(int index) {
            if(infoArray[index] >= 90) // less than 95 green
                return mColors.get(0);
            else if(infoArray[index] >= 80 && infoArray[index] <90) // less than 100 orange
                return mColors.get(1);
            else // greater or equal than 100 red
                return mColors.get(2);
        }
    }
    private void setUpPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i =0; i< companies.length;i++){
            pieEntries.add(new PieEntry(pointsDistribution[i], companies[i]));

        }
        MyPieDataSet dataSet = new MyPieDataSet(pieEntries, "Points distribution",companyScores);
        dataSet.setColors(ContextCompat.getColor(getApplicationContext() ,R.color.green1),ContextCompat.getColor(getApplicationContext(),R.color.green2),ContextCompat.getColor(getApplicationContext(),R.color.green3));
        PieData data = new PieData(dataSet);
        PieChart chart = (PieChart) findViewById(R.id.pie);
        chart.setData(data);
        chart.setEntryLabelColor(Color.BLACK);

        chart.animateY(1500);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);


        chart.invalidate();
    }
    public class MyBarDataSet extends BarDataSet {

        public MyBarDataSet(List<BarEntry> yVals, String label) {
            super(yVals, label);
        }

        @Override
        public int getColor(int index) {
            if(getEntryForIndex(index).getY()>= 3900) // less than 95 green
                return mColors.get(0);
            else if(getEntryForIndex(index).getY() >= 3000 && getEntryForIndex(index).getY() <3900) // less than 100 orange
                return mColors.get(1);
            else if(getEntryForIndex(index).getY()>2000 && getEntryForIndex(index).getY()<3000)// greater or equal than 100 red
                return mColors.get(2);
            else
                return mColors.get(3);
        }
    }
    private void setUpBarChart(){
        List<BarEntry> barEntries = new ArrayList<>();
        for(int i=0;i<monthly.length;i++){
            barEntries.add(new BarEntry(i,monthly[i]));
        }


        MyBarDataSet dataSet = new MyBarDataSet(barEntries,"Month");
        dataSet.setColors(ContextCompat.getColor(getApplicationContext() ,R.color.bargreen),ContextCompat.getColor(getApplicationContext(),R.color.green2),ContextCompat.getColor(getApplicationContext(),R.color.yellow1),ContextCompat.getColor(getApplicationContext() ,R.color.red1));
        ArrayList<String> dates = new ArrayList<>();
        for(int i=0;i<months.length;i++)
        {
            dates.add(months[i]);
        }
        BarData data = new BarData(dataSet);
        BarChart chart = (BarChart) findViewById(R.id.bar);
        chart.setData(data);
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(dates));
        chart.animateY(1500);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setAxisMinimum(0f);
        chart.getAxisRight().setAxisMinimum(0f);

        chart.getAxisLeft().setAxisMaximum(5000f);
        chart.getAxisRight().setAxisMaximum(5000f);

        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setFitBars(true);

        chart.invalidate();



    }
}