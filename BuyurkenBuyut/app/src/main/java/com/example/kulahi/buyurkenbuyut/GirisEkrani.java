package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GirisEkrani extends AppCompatActivity {

    EditText ISIM;
    EditText SOYISIM;
    EditText SIFRE;
    Button DEVAM;

    String isim;
    String soyisim;
    String sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
        changeFonts();
    }


    public void onClickGirisEkrani(View view)
    {
        try {
            DBHandler db = new DBHandler(this);
            Kisi databaseKisi = db.getKisi(0);
            isim = ((EditText) findViewById(R.id.hint_GİRİS_AD)).getText().toString();
            soyisim = ((EditText) findViewById(R.id.hint_GİRİS_SOYAD)).getText().toString();
            sifre = ((EditText) findViewById(R.id.hint_GİRİS_SIFRE)).getText().toString();

            if ((isim.isEmpty()) || (soyisim.isEmpty()) || (sifre.isEmpty())) {
                Toast.makeText(getApplicationContext(), "Bos alanları doldurunuz", Toast.LENGTH_LONG)
                        .show();
            } else if ((isim.equals(databaseKisi.getIsim())) && (soyisim.equals(databaseKisi.getSoyisim()))
                    && (sifre.equals(databaseKisi.getSifre()))) {
                Intent intent = new Intent(getApplicationContext(), AnaMenuEkrani.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Girmis olduğunuz bilgiler yanlis", Toast.LENGTH_LONG)
                        .show();
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void changeFonts()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");
        ISIM = (EditText)findViewById(R.id.hint_GİRİS_AD);
        SOYISIM = (EditText)findViewById(R.id.hint_GİRİS_SOYAD);
        SIFRE = (EditText)findViewById(R.id.hint_GİRİS_SIFRE);
        DEVAM = (Button)findViewById(R.id.GİRİS_GİRİSBUTTON);

        ISIM.setHint("İSİM");
        ISIM.setTypeface(typeface);

        SOYISIM.setHint("SOYİSİM");
        SOYISIM.setTypeface(typeface);

        SIFRE.setHint("ŞİFRE");
        SIFRE.setTypeface(typeface);

        DEVAM.setHint("DEVAM");
        DEVAM.setTypeface(typeface);
    }
}
