package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class KayitEkrani extends AppCompatActivity {

    EditText AD;
    EditText SOYAD;
    EditText SIFRE;
    EditText SIFRETEKRAR;
    Button DEVAM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);
        changeFonts();

    }

    public void onClickKayitEkrani(View view)
    {
        String ad = ((EditText)findViewById(R.id.hint_AD)).getText().toString();
        String soyad = ((EditText)findViewById(R.id.hint_SOYAD)).getText().toString();
        String sifre = ((EditText)findViewById(R.id.hint_SIFRE)).getText().toString();
        String sifreTekrar = ((EditText)findViewById(R.id.hint_sifreTekrari)).getText().toString();

            if((ad.isEmpty()) ||(soyad.isEmpty()) || (sifre.isEmpty()) || (sifreTekrar.isEmpty()))
            {
                Toast.makeText(getApplicationContext(),"Bos alanlari doldurunuz",Toast.LENGTH_SHORT)
                        .show();
            }

            else if(!sifre.equalsIgnoreCase(sifreTekrar))
            {
                Toast.makeText(getApplicationContext(),"Sifre ve Sifre Tekrariniz ayni değil"
                        ,Toast.LENGTH_SHORT).show();
            }
            else
            {
                DBHandler db = new DBHandler(this);
                Kisi kisi = new Kisi(0,ad,soyad,sifre,null,null,null,null,null,"1");
                db.kisiEkle(kisi);
                Intent intent = new Intent(getApplicationContext(),BitkiTuruSec.class);
                startActivity(intent);
            }
    }

    public void changeFonts()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");
        AD = (EditText)findViewById(R.id.hint_AD);
        SOYAD = (EditText)findViewById(R.id.hint_SOYAD);
        DEVAM = (Button)findViewById(R.id.devam_KayitEkrani);
        SIFRE = (EditText)findViewById(R.id.hint_SIFRE);
        SIFRETEKRAR = (EditText)findViewById(R.id.hint_sifreTekrari);

        AD.setHint("ADINIZ");
        AD.setTypeface(typeface);

        SOYAD.setHint("SOYADINIZ");
        SOYAD.setTypeface(typeface);

        DEVAM.setText("DEVAM");
        DEVAM.setTypeface(typeface);

        SIFRE.setHint("ŞİFRENİZ");
        SIFRETEKRAR.setHint("ŞİFRE TEKRARI");

        SIFRE.setTypeface(typeface);
        SIFRETEKRAR.setTypeface(typeface);
    }

}
