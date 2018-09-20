package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class T2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2);
    }

    public void onClickT2(View view)
    {
        if(view.getId() == R.id.buttonT2)
        {
            Intent intent = new Intent(this,T3.class);
            startActivity(intent);
        }
    }
}
