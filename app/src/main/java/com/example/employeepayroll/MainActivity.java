package com.example.employeepayroll;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

DatabaseReference databaseReference;
FirebaseDatabase firebaseDatabase;
Bundle extra;
Boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("usrdetails");
        ///Intent i = getIntent();
        String str = null;
        if(savedInstanceState == null){
            extra = getIntent().getExtras();
            if(extra == null ){
                str = null;
            }else{
                str = extra.getString("addusr");
                addusr();
            }
        }

    }

    public void sign(View view) {
        EditText e1 = findViewById(R.id.edittext);
        EditText e2 = findViewById(R.id.edittext1);
        String usr = e1.getText().toString();
        String pass = e2.getText().toString();
        if(flag==true){
            databaseReference = firebaseDatabase.getInstance().getReference("userdetails").child(usr);
            databaseReference.setValue(pass);
        }else{
            if(usr.equals("admin")){
                Toast.makeText(getApplicationContext(),"first if",Toast.LENGTH_LONG).show();
                    if(pass.equals("admin")){
                        Toast.makeText(getApplicationContext(),"second if ",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this,adminpanel.class);
                        startActivity(i);
                    }
            }
            else{
                databaseReference = firebaseDatabase.getInstance().getReference().child(usr);
                String st = (String) databaseReference.get().getResult().getValue();
                //databaseReference.setValue("usr");
                //databaseReference.setValue(pass);
                Toast.makeText(getApplicationContext(),st,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"elsepart",Toast.LENGTH_LONG).show();

            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText e1 = findViewById(R.id.edittext);
        EditText e2 = findViewById(R.id.edittext1);
        e1.setText("");
        e2.setText("");

    }

    public  void addusr(){



        TextView t1 = findViewById(R.id.textView2);
        t1.setText("add employee");
        flag=true;

    }

    }