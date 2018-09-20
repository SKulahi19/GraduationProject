package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Market extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }

    public void onClickMarket(View view)
    {
        if(view.getId() == R.id.market_feslegenID)
        {
            Intent intent = new Intent(this,SepeteEkle.class);
            startActivity(intent);
        }
    }
}
