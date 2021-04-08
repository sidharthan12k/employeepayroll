package com.example.employeepayroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class paydetails extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
Boolean flag =false;
DatabaseReference dbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paydetails);
        //basic
        //da - 6 month once
        //hra - house rent fixed
        //ma medical fixed
        // others like handicapt
        // gpf general provident fund
        // spf special "
        //fbf family benifit fund

        if(flag==true){

        }else{
            pay();
        }
    }
    public void pay(){
        e1 = (EditText)findViewById(R.id.editTextTextPersonName);
        e2 = (EditText)findViewById(R.id.editTextTextPersonName2);
        e3 = (EditText)findViewById(R.id.editTextTextPersonName3);
        e4 = (EditText)findViewById(R.id.editTextTextPersonName4);
        e5 = (EditText)findViewById(R.id.editTextTextPersonName5);
        e6 = (EditText)findViewById(R.id.editTextTextPersonName6);
        e7 = (EditText)findViewById(R.id.editTextTextPersonName7);
        e8 = (EditText)findViewById(R.id.editTextTextPersonName8);
        e9 = (EditText)findViewById(R.id.editTextTextPersonName9);
        e1.setTextIsSelectable(false);
        e2.setTextIsSelectable(false);
        e3.setTextIsSelectable(false);
        e4.setTextIsSelectable(false);
        e5.setTextIsSelectable(false);
        e6.setTextIsSelectable(false);
        e7.setTextIsSelectable(false);
        e8.setTextIsSelectable(false);
        e9.setTextIsSelectable(false);
        String usr = null;
        dbr = FirebaseDatabase.getInstance().getReference().child("userdetails").child(usr);
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue().toString();  
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void close(View view) {
        finish();
        System.exit(0);
    }
}