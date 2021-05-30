package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Bundle b=getIntent().getExtras();
//        String key = b.getString("option");
    }

    public void click(View view) {
        Button selected=(Button)view;

        int cell=0;
        switch (selected.getId()){

            case R.id.bu1:
                cell=1;
                break;
            case R.id.bu2:
                cell=2;
                break;
            case R.id.bu3:
                cell=3;
                break;
            case R.id.bu4:
                cell=4;
                break;
            case R.id.bu5:
                cell=5;
                break;
            case R.id.bu6:
                cell=6;
                break;
            case R.id.bu7:
                cell=7;
                break;
            case R.id.bu8:
                cell=8;
                break;
            case R.id.bu9:
                cell=9;
                break;
        }
        playgame(cell,selected);
    }
    int curr_player=1;
    ArrayList<Integer> player1=new ArrayList<Integer>();
    ArrayList<Integer> player2=new ArrayList<Integer>();

    void playgame(int cell,Button button){
        Bundle b=getIntent().getExtras();
        int key = b.getInt("option");

        Log.d("player",String.valueOf(cell));
        Log.d("Button Text",button.getText().toString());
        if(curr_player==1){
            button.setBackgroundColor(Color.GREEN);
            button.setText("X");
            player1.add(cell);
            curr_player=2;
            if(key==1){
            autoplay();
            }


        }
        else{
            button.setBackgroundColor(Color.RED);
            button.setText("O");

//            button.setTextColor();
            player2.add(cell);
            curr_player=1;
        }
        button.setEnabled(false); // a button cannot be clicked after this.
        check();
    }

    void check(){
        int winner=-1;
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1;
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2;
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1;
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2;
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1;
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2;
        }
        //.....
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1;
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2;
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1;
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2;
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1;
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2;
        }
        //...
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1;
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2;
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1;
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2;
        }

        if(winner!=-1) {
            if (winner == 1) {
//                Toast.makeText(this, "player 1", Toast.LENGTH_SHORT).show();
                String winner1 = "Player 1 Won";
                Intent intent = new Intent(this, Winner.class);
                intent.putExtra("winner", winner1);
                startActivity(intent);

            }
            else if (winner == 2) {
//                Toast.makeText(this,"Player 2 is winner!",Toast.LENGTH_LONG).show();
                String winner2 = "Player 2 Won";
//                Toast.makeText(this, "player 2", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Winner.class);
                intent2.putExtra("winner", winner2);
                startActivity(intent2);
            }
//            winner =0;

//            if(player1.size() + player2.size()==9) {
//                String noone = "Its a Tie!";
//                Intent intent3 = new Intent(this, Winner.class);
//                intent3.putExtra("winner", noone);
//                startActivity(intent3);
//
//            }
        }
        if(player1.size() + player2.size()==9) {
            String noone = "Its a Tie!";
            Intent intent3 = new Intent(this, Winner.class);
            intent3.putExtra("winner", noone);
            startActivity(intent3);

        }
    }

    void autoplay(){
        ArrayList<Integer> emptycells=new ArrayList<Integer>();
        for(int i=1;i<10;i++){
            if(!(player1.contains(i) || player2.contains(i))){
                emptycells.add(i);
            }
        }

        Random r= new Random();
        int rindex = r.nextInt(emptycells.size());
        int cell=emptycells.get(rindex);
        Button selected;
        switch (cell){

            case 1:
                selected=(Button) findViewById(R.id.bu1);
                break;
            case 2:
                selected=(Button) findViewById(R.id.bu2);
                break;
            case 3:
                selected=(Button) findViewById(R.id.bu3);
                break;
            case 4:
                selected=(Button) findViewById(R.id.bu4);
                break;
            case 5:
                selected=(Button) findViewById(R.id.bu5);
                break;
            case 6:
                selected=(Button) findViewById(R.id.bu6);
                break;
            case 7:
                selected=(Button) findViewById(R.id.bu7);
                break;
            case 8:
                selected=(Button) findViewById(R.id.bu8);
                break;
            case 9:
                selected=(Button) findViewById(R.id.bu9);
                break;
            default:
                selected=(Button) findViewById(R.id.bu1);
                break;
        }
        playgame(cell,selected);

    }
}