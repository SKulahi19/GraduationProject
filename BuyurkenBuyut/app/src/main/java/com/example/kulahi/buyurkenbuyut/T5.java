package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class T5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t5);
    }

    public void onClickT5(View view)
    {
        if(view.getId() == R.id.buttonT5)
        {
            Intent intent = new Intent(this,T6.class);
            startActivity(intent);
        }
    }
}
