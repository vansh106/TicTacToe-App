package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Winner extends AppCompatActivity {
    TextView textView5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        setContentView(R.layout.activity_winner);
        textView5=findViewById(R.id.textView5);
        String winner=b.getString("winner");
        textView5.setText(winner);

    }
    public void return1(View view){
        Intent intent = new Intent(this,home.class);
        startActivity(intent);
    }

}