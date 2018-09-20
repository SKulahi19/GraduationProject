package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BitkiTuruSec extends AppCompatActivity {

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitki_turu_sec);
        db = new DBHandler(this);

    }

    public void onClickBitkiTuruSec(View view)
    {
        if(view.getId() ==  R.id.maydanoz)
        {
            db.bitkiTuruGuncelle("maydanoz");
            Intent intent = new Intent(this,BiktiIsimKoy.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.cilek)
        {
            db.bitkiTuruGuncelle("cilek");
            Intent intent = new Intent(this,BiktiIsimKoy.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.sarimsak)
        {
            db.bitkiTuruGuncelle("sarimsak");
            Intent intent = new Intent(this,BiktiIsimKoy.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.havuc)
        {
            db.bitkiTuruGuncelle("havuc");
            Intent intent = new Intent(this,BiktiIsimKoy.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.fasulye)
        {
            db.bitkiTuruGuncelle("fasulye");
            Intent intent = new Intent(this,BiktiIsimKoy.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.feslegen)
        {

            db.bitkiTuruGuncelle("feslegen");
            Intent intent = new Intent(this,BiktiIsimKoy.class);
            startActivity(intent);
        }

    }
}
