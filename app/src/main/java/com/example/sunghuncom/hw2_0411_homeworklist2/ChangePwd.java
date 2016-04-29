package com.example.sunghuncom.hw2_0411_homeworklist2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunghuncom.hw2_0411_homeworklist.R;

/*
 this activity will used when user want to change the pass word
 */
public class ChangePwd extends AppCompatActivity implements View.OnClickListener {
    Button btnOk,btnCancel;
    EditText passText;
    SharedPreferences sh_pref;
    SharedPreferences.Editor toEdit;
    String newPW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pwd);

        passText= (EditText)findViewById(R.id.passwordText);
        btnOk=(Button)findViewById(R.id.okay);
        btnOk.setOnClickListener(this);
        btnCancel=(Button)findViewById(R.id.cancel);
        btnCancel.setOnClickListener(this);

    }

    public void sharedPreferences (){
        sh_pref = getSharedPreferences("LogIn", MODE_PRIVATE);
        toEdit = sh_pref.edit();
        toEdit.putString("password", passText.getText().toString());
        toEdit.commit();
    }


    public void onClick(View v){

        //when user enter okay button check the length of new password and encrytion and change
        if(v.getId()==btnOk.getId()) {
            String a;
            a=passText.getText().toString();

            //encryption using MD5 tools
            MD5 encrypt = new MD5();
            a = encrypt.cryptWithMD5(a);

            if(a.length()==4) {
                //change the password
                sharedPreferences();
                Toast.makeText(this, "Password Changed", Toast.LENGTH_LONG).show();
                finish();
            }
            else
                Toast.makeText(this,"Pass word must shorter than 4",Toast.LENGTH_LONG).show();
        }
        //password changed canceled
        if(v.getId()==btnCancel.getId()) {
            Toast.makeText(this, "Password changing is canceled", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}