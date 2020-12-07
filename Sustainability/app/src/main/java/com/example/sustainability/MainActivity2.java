package com.example.sustainability;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private TextView username;

    private float[] yData = {25f,66f, 44f};
    private String[] xData = {"Neutral ", "Sustainable", "Negative"};
    private PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Home");
        username = (TextView) findViewById(R.id.welcomehome);
        String user_email = getIntent().getStringExtra("username");
        username.setText("Hi " + user_email + "!");
            chart=(PieChart)findViewById(R.id.chart);
        setup_piechart();
    }

    private void setup_piechart() {

        List<PieEntry> list=new ArrayList<>();

        for(int i=0;i<3;i++)
        {
            list.add(new PieEntry(yData[i],xData[i]));
        }

        PieDataSet dataSet=new PieDataSet(list,"types of expenses");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data=new PieData(dataSet);

        chart.setData(data);
        data.setValueTextSize(15f);
        chart.setHoleRadius(25f);
        chart.setTransparentCircleAlpha(0);
        chart.animateY(1800);
        chart.invalidate();
        Legend l=chart.getLegend();
        l.setEnabled(false);
        chart. getDescription(). setEnabled(false);
    }
}