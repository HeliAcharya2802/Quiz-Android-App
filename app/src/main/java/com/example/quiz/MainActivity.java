package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button blockchain = (Button)findViewById(R.id.blcokchian);
        Button data = (Button)findViewById(R.id.dataanalytics);
        Button nft = (Button)findViewById(R.id.nft);
        Button stock = (Button)findViewById(R.id.stock);


        blockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this,Blockchain.class);
                startActivity(a);
                System.exit(0);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity.this,DataAnalytics.class);
                startActivity(b);
                System.exit(0);
            }
        });

        nft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity.this,NFT.class);
                startActivity(c);
                System.exit(0);
            }
        });

        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(MainActivity.this,StockMarket.class);
                startActivity(d);
                System.exit(0);
            }
        });
    }
}