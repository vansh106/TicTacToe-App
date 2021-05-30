package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Bundle b1=getIntent();
    }

    public void multi(View view){
        int key=1;
        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("option",key);
        startActivity(intent);
    }
    public void multip(View view){
        int key=0;
        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("option",key);
        startActivity(intent);
    }
}