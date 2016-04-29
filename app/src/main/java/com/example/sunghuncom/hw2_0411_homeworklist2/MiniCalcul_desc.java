package com.example.sunghuncom.hw2_0411_homeworklist2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sunghuncom.hw2_0411_homeworklist.R;
/*
this functio will show the description of mani calculator
and if user click the butto start the maini calculotr activity
 */
public class MiniCalcul_desc extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minicalcul_desc);

        btn=(Button)findViewById(R.id.miniCalculbtn);
        btn.setOnClickListener(this);
    }
    public void onClick(View v){
        Intent myIntent = new Intent(this, MiniCalculator.class); // create a container to ship data
        Bundle myData = new Bundle();
        myIntent.putExtras(myData);


        if(v.getId()==btn.getId())
            startActivityForResult(myIntent, 444);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if ((requestCode == 444 ) && (resultCode == Activity.RESULT_OK)){
                Bundle myResults = data.getExtras();
                Double vresult = myResults.getDouble("vresult");
                finish();
                Toast.makeText(this, "Result of Mini Calculator : " + vresult, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
    }//onActivityResult

}