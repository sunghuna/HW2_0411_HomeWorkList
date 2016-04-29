package com.example.sunghuncom.hw2_0411_homeworklist2;

/**
 * Created by SunghunCom on 16. 4. 12..
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.Toast;
import android.content.Intent;
import android.text.TextWatcher;
import android.text.Editable;

import com.example.sunghuncom.hw2_0411_homeworklist.R;


public class LogIn extends AppCompatActivity{
    EditText pw;
    SharedPreferences sh_pref;
    Toast a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //It shows this sentence when user inputs wrong password
        a = Toast.makeText(this, "Wrong password!", Toast.LENGTH_LONG);

        //It is used to get password from shared preferences
        sh_pref = getSharedPreferences("LogIn",0);
        pw = (EditText)findViewById(R.id.passinput);

        //when 4-th digit is filled by user the program will check the password and go to next activity automatically
        pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                //when user enter 4 digit password
                if (s.toString().length() == 4) {
                    String check = sh_pref.getString("password", "-1");
                    String compare;

                    //when user is first come, compare password with '0000'
                    if (check.equals("-1")) {
                        if (s.toString().equals("0000")) {
                            startActivity(new Intent(LogIn.this, MainActivity.class));
                        } else
                            a.show();
                    }

                    //when prefecnce file is exist, compare the password with existed password
                    else{
                        if(s.toString().equals(check))
                          startActivity(new Intent(LogIn.this, MainActivity.class));
                        else
                            a.show();
                    }

                }
            }
        });
    }
}
