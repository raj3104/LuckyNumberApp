package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    String user,se;
    int randomgens=0;
    Button sharebtn;
    Button goback;
    TextView num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharebtn=findViewById(R.id.share);
        goback=findViewById(R.id.button);
        num=findViewById(R.id.res);
        Intent i=getIntent();
        String user=i.getStringExtra("name");
        randomgens=randomgen();
        num.setText(""+randomgens);

        num.getText().toString();

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareData(""+user,randomgens);
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent id=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(id);
            }
        });

    }

    public int randomgen(){
        Random rand=new Random();
        int upper=1000;
        int randomgens=rand.nextInt(upper);
        return randomgens;}
    public void shareData(String user,int randomgens){
        Intent is=new Intent(Intent.ACTION_SEND);
        is.setType("text/plain");
        is.putExtra(Intent.EXTRA_SUBJECT,user+" got lucky today!");
        is.putExtra(Intent.EXTRA_TEXT,"The lucky number is "+randomgens+"!");
        startActivity(Intent.createChooser(is,"Choose a platform"));


    }
}