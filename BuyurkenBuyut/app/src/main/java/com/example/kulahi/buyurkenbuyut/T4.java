package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class T4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t4);
    }

    public void onClickT4(View view)
    {
        if(view.getId() == R.id.buttonT4)
        {
            Intent intent = new Intent(this,T5.class);
            startActivity(intent);
        }
    }
}
