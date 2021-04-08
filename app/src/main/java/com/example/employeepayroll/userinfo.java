package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userinfo extends AppCompatActivity {
TextView T1 = (TextView)findViewById(R.id.textView10);
TextView T2 = (TextView)findViewById(R.id.textView11);
TextView T3 = (TextView)findViewById(R.id.textView12);
    Bundle extra;
TextView T4 = (TextView)findViewById(R.id.textView13);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        String str = null;
        if(savedInstanceState == null){
            extra = getIntent().getExtras();
            if(extra == null ){
                str = null;
            }else{
                str = extra.getString("addusr");
                updatedetails();
            }
        }
    }
public void updatedetails(){
    Button b1 = (Button)findViewById(R.id.button7);
    b1.setText("update details");
}
    public void logout(View view) {
        Intent i = new Intent(userinfo.this,MainActivity.class);
        startActivity(i);
    }

    public void paydetails(View view) {
        Intent i = new Intent(userinfo.this,paydetails.class);
        startActivity(i);
    }
}