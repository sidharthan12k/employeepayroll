package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminpanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);
    }

    public void addusr(View view) {
        Intent i = new Intent(adminpanel.this,MainActivity.class);
        String str = "true";
        i.putExtra("addusr",str);
        startActivity(i);
    }

    public void editusr(View view) {
        Intent i = new Intent(adminpanel.this,paydetails.class);
        String str = "true";
        i.putExtra("addusr",str);
        startActivity(i);
    }

    public void viewusr(View view) {
        Intent i = new Intent(adminpanel.this,userinfo.class);
        String str = "true";
        i.putExtra("addusr",str);
        startActivity(i);
    }
}