package com.example.sunghuncom.hw2_0411_homeworklist2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sunghuncom.hw2_0411_homeworklist.R;

public class TipCalcul_desc extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipcalcul_desc);

        btn=(Button)findViewById(R.id.tipCalculbtn);
        btn.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==btn.getId())
            startActivity(new Intent(this, TipCalculator.class));
    }
}