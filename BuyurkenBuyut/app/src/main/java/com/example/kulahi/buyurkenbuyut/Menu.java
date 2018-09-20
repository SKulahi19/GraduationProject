package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ana_menu);
    }

    public void onClickMenu(View view)
    {
        if(view.getId() == R.id.menuSosyal)
        {
            Intent intent = new Intent(this,Sosyal.class);
            startActivity(intent);
        }

        else if(view.getId() == R.id.menuAyarlar)
        {
            Intent intent = new Intent(this,Ayarlar.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.menuMarket)
        {
            Intent intent = new Intent(this,Market.class);
            startActivity(intent);
        }
    }
}
