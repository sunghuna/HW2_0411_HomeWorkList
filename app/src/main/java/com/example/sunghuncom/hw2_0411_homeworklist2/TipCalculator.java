package com.example.sunghuncom.hw2_0411_homeworklist2;

/**  mobile programming homework
 //  package name : hw_2_0411
 //  this program will show tip and total amount
 //  When the user pushes the ‘Calculate’ button, App should provide the tip and total amount.
 //  Created by Kwak sunghun on 2016. 4. 11.
 //  Copyright © 2016년 Kwak sunghun. All rights reserved.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.Display;
import android.graphics.Point;

import com.example.sunghuncom.hw2_0411_homeworklist.R;

public class TipCalculator extends AppCompatActivity implements View.OnClickListener {

    EditText amount;
    RadioButton ten;
    RadioButton fifteen;
    RadioButton twenty;
    RadioButton otherRadio;
    Button calcul;
    EditText other;

    double myMoney=0.0;
    double myTip=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;


        if(height>width)
            setContentView(R.layout.tip_calculator);
        else
            setContentView(R.layout.tip_calculator);

        amount = (EditText) findViewById(R.id.editText);

        ten = (RadioButton) findViewById(R.id.radioButton);
        fifteen = (RadioButton) findViewById(R.id.radioButton2);
        twenty = (RadioButton) findViewById(R.id.radioButton3);
        otherRadio = (RadioButton) findViewById(R.id.radioButton4);
        other = (EditText) findViewById(R.id.otherTip);

        calcul = (Button) findViewById(R.id.button);
        calcul.setOnClickListener(this);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        double tip;
        if (ten.isChecked()) {
            tip =  0.1;
        } else if (fifteen.isChecked()) {
            tip =  0.15;
        } else if (twenty.isChecked()) {
            tip =  0.2;
        } else if (otherRadio.isChecked()){
            if(other.getText().toString().compareTo("")!=0)
                tip = Double.parseDouble(other.getText().toString())/100;
            else
                tip = -1;
        } else{
            tip = -1;
        }

        outState.putDouble("money", Double.parseDouble(amount.getText().toString()));
        outState.putDouble("tempTip", tip);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        myTip = savedInstanceState.getDouble("tempTip");
        amount.setText(savedInstanceState.getDouble("money")+"");

    }

    public void onClick(View v) {
        double tip=0;
        double money=0;
        double totalAmount =0;
        if (v.getId() == calcul.getId()) {
            if(amount.getText().toString().compareTo("")!=0)
                money = Double.parseDouble(amount.getText().toString());
            else
                money = -1;

            if (ten.isChecked()) {
                tip =  0.1;
            } else if (fifteen.isChecked()) {
                tip =  0.15;
            } else if (twenty.isChecked()) {
                tip =  0.2;
            } else if (otherRadio.isChecked()){
                if(other.getText().toString().compareTo("")!=0)
                    tip = Double.parseDouble(other.getText().toString())/100;
                else
                    tip = -1;
            } else{
                tip = -1;
            }
        }

        if(money<=0 && tip==-1)
            Toast.makeText(this,"Error : Enter amount of money and tip!",Toast.LENGTH_LONG).show();
        else if(money<=0)
            Toast.makeText(this,"Error : Enter amount of money !",Toast.LENGTH_LONG).show();
        else if(tip==-1)
            Toast.makeText(this,"Error : Enter tip!",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Total amount : "+ (money+ money*tip) +"\ntip : " + tip*money, Toast.LENGTH_LONG).show();
    }
}
