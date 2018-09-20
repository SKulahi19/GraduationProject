package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class T6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t6);
    }

    public void onClickT6(View view)
    {
        if(view.getId() == R.id.buttonT6)
        {
            Intent intent = new Intent(this,AnaMenuEkrani.class);
            startActivity(intent);
        }
    }
}
