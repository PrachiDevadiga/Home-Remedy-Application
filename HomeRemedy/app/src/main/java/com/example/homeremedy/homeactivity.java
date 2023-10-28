package com.example.homeremedy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class homeactivity extends AppCompatActivity {
    CardView card1, card2, card3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        //getSupportActionBar().setTitle("Home Activity");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card1 = (CardView) findViewById(R.id.myrem);
        card2 = (CardView) findViewById(R.id.homerem);
        card3 =(CardView) findViewById(R.id.ques);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MyRemedy.class);
                startActivity(i);
                finish();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),homerem.class);
                startActivity(i);
                finish();
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),quesfeed.class);
                startActivity(i);
                finish();
            }
        });
    }


}

