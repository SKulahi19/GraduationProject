package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnaGirisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_giris_ekrani);
    }

    public void onClickAnaGirisEkrani(View view)
    {
        if(view.getId() == R.id.giris)
        {
            Intent intent = new Intent(getApplicationContext(),GirisEkrani.class);
            startActivity(intent);
        }

        else if(view.getId() == R.id.kaydol)
        {
            Intent intent = new Intent(getApplicationContext(),KayitEkrani.class);
            startActivity(intent);
        }

        else if(view.getId() == R.id.kayitSil)
        {
            DBHandler db  = new DBHandler(this);
            db.kayitSil();


        }
    }
}
