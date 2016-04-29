package com.example.sunghuncom.hw2_0411_homeworklist2;

/**  mobile programming homework #1_C
 //  package name : hw_1_c_0327
 //  If the user pushes any“operation”buttons[+,-,*,/,=],
 //  the result should be calculated using the “input” edit-box
 //  and the current “result” value, and displayed on the result box
 //  Created by Kwak sunghun on 2016. 3. 27.
 //  Copyright © 2016년 Kwak sunghun. All rights reserved.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.example.sunghuncom.hw2_0411_homeworklist.R;

public class MiniCalculator extends AppCompatActivity implements View.OnClickListener {

    public double result;
    public double v1=0,v2=0,v3;
    public boolean add=false,sub=false,div=false,mul=false,clear=false,ans=false;
    public boolean op =false;
    public double temp,temp2;
    String tempc="",tempc2;

    public Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    public EditText textCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_calculator);

        btn1 = (Button) findViewById(R.id.seven);
        btn2 = (Button) findViewById(R.id.eight);
        btn3 = (Button) findViewById(R.id.nine);

        btn5 = (Button) findViewById(R.id.four);
        btn6 = (Button) findViewById(R.id.five);
        btn7 = (Button) findViewById(R.id.six);

        btn9 = (Button) findViewById(R.id.one);
        btn10 = (Button) findViewById(R.id.two);
        btn11 = (Button) findViewById(R.id.three);

        btn13 = (Button) findViewById(R.id.zero);

        btn4 = (Button) findViewById(R.id.divide);
        btn8 = (Button) findViewById(R.id.multi);
        btn12 = (Button) findViewById(R.id.minus);
        btn14 = (Button) findViewById(R.id.clear);
        btn15 = (Button) findViewById(R.id.equal);
        btn16 = (Button) findViewById(R.id.plus);

        textCalcul = (EditText) findViewById(R.id.textView);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);

        textCalcul.setOnTouchListener(new OnTouchListener() {

            //hide keyboard
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });

    }

    public void onClick(View v) {

        //if pressed button is number call number method
        if (v.getId() == btn1.getId() ||
                v.getId() == btn2.getId() ||
                v.getId() == btn3.getId() ||
                v.getId() == btn5.getId() ||
                v.getId() == btn6.getId() ||
                v.getId() == btn7.getId() ||
                v.getId() == btn9.getId() ||
                v.getId() == btn10.getId() ||
                v.getId() == btn11.getId() ||
                v.getId() == btn13.getId())
            number(v);
        else if (v.getId() == btn4.getId() ||
                v.getId() == btn8.getId() ||
                v.getId() == btn12.getId() ||
                v.getId() == btn14.getId() ||
                v.getId() == btn15.getId() ||
                v.getId() == btn16.getId())
            operator(v);



    }
    public void hideVirtualKeyboard() {
        Context context = getApplicationContext(); ((InputMethodManager)
                context .getSystemService(Activity.INPUT_METHOD_SERVICE)) .toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
    }
    /*
    //set EditText box to number and keep that into temp variable
    input : view
    output: none
    */
    public void number(View view) {
        if (view.getId()==btn1.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"7");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("7");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn2.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"8");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("8");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn3.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"9");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("9");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn5.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"4");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("4");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn6.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"5");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("5");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn7.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"6");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("6");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn9.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"1");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("1");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn10.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"2");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("2");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn11.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"3");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("3");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
        if (view.getId()==btn13.getId()){
            if(op==false){
                textCalcul.setText(textCalcul.getText()+"0");
                temp=Double.parseDouble(textCalcul.getText().toString());
            }
            else{
                textCalcul.setText("0");
                temp=Double.parseDouble(textCalcul.getText().toString());
                op=false;
            }
        }
    }

    /*if pressed button is operator operate the number and set the edittext box into result
     */
    public void operator(View view) {
        op=true;
        //add button
        if (view.getId() == btn16.getId()) {
            if(tempc=="+")
                temp2 = temp2 + temp;
            else if(tempc=="-")
                temp2 = temp2 - temp;
            else if(tempc=="*")
                temp2 = temp2 * temp;
            else if(tempc=="/")
                temp2 = temp2 / temp;
            else
                temp2 = temp;
            textCalcul.setText(temp2+"");
            tempc = "+";
            temp = 0;
        }
        //substract button
        else if (view.getId() == btn12.getId())
        {
            if(tempc=="+")
                temp2 = temp2 + temp;
            else if(tempc=="-")
                temp2 = temp2 - temp;
            else if(tempc=="*")
                temp2 = temp2 * temp;
            else if(tempc=="/")
                temp2 = temp2 / temp;
            else
                temp2 = temp;
            textCalcul.setText(temp2+"");
            tempc = "-";
            temp = 0;
        }
        //divide button
        else if (view.getId() == btn4.getId())
        {
            try{
                if(tempc=="+")
                    temp2 = temp2 + temp;
                else if(tempc=="-")
                    temp2 = temp2 - temp;
                else if(tempc=="*")
                    temp2 = temp2 * temp;
                else if(tempc=="/")
                    temp2 = temp2 / temp;
                else
                    temp2 = temp;

                textCalcul.setText(temp2+"");
                tempc = "/";
                temp = 0;
            }catch( DivideByZeroException e){
                textCalcul.setText("you Can divide by zero");
            }

        }

        //add button
        else if (view.getId() == btn8.getId()) {
            if(tempc=="+")
                temp2 = temp2 + temp;
            else if(tempc=="-")
                temp2 = temp2 - temp;
            else if(tempc=="*")
                temp2 = temp2 * temp;
            else if(tempc=="/")
                temp2 = temp2 / temp;
            else
                temp2 = temp;
            textCalcul.setText(temp2+"");
            tempc = "*";
            temp = 0;
        }

        //This button show result value
        else if (view.getId() == btn15.getId()) {
            try{
                if(tempc=="+")
                    temp2 = temp2 + temp;
                else if(tempc=="-")
                    temp2 = temp2 - temp;
                else if(tempc=="*")
                    temp2 = temp2 * temp;
                else if(tempc=="/")
                    temp2 = temp2 / temp;
                textCalcul.setText(temp2+"");

                Intent myLocalIntent = getIntent();
                Bundle myBundle = myLocalIntent.getExtras();
                myBundle.putDouble("vresult",temp2); //
                // attach updated bumble to invoking intent
                myLocalIntent.putExtras(myBundle);
                // return sending an OK signal to calling activity
                setResult(Activity.RESULT_OK, myLocalIntent);

                tempc = "";
                temp = temp2;
            }catch( DivideByZeroException e){
                textCalcul.setText("you Can divide by zero");
            }
            finish();
        }
        //clear the all result and variable
        else if (view.getId() == btn14.getId()) {
            textCalcul.setText(0+"");
            tempc = "";
            temp = 0;
            temp2 = 0;
        }
    }
}


