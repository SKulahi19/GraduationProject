package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BiktiIsimKoy extends AppCompatActivity {

    String bitkiIsim;
    EditText bitkiTuru;
    EditText bitkiISIM;
    Button devam;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bikti_isim_koy);
        changeFonts();

    }

    public void onClickBitkiIsimKoy(View view)
    {
        try
        {
            if (view.getId() == R.id.devamButonBitkiIsimKoy){
                bitkiIsim = ((EditText)findViewById(R.id.bitkiIsimKoy)).getText().toString();
                db = new DBHandler(this);
                db.bitkiIsmiGuncelle(bitkiIsim);
                Intent intent = new Intent(this, T1.class);
                startActivity(intent);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String bitkiTuru() {
        String ret = null;
        db = new DBHandler(this);
        if (db.getKisi(0).getBitkiTuru().equalsIgnoreCase("sarimsak")) {
            ret = "Sarımsağına";
        } else if (db.getKisi(0).getBitkiTuru().equalsIgnoreCase("maydanoz")) {
            ret = "Maydanozuna";
        } else if (db.getKisi(0).getBitkiTuru().equalsIgnoreCase("feslegen")) {
            ret = "Fesleğenine";
        } else if (db.getKisi(0).getBitkiTuru().equalsIgnoreCase("havuc")) {
            ret = "Havucuna";
        } else if (db.getKisi(0).getBitkiTuru().equalsIgnoreCase("fasulye")) {
            ret = "Fasülyene";
        } else if (db.getKisi(0).getBitkiTuru().equalsIgnoreCase("cilek")) {
            ret = "Çileğine";
        }

                    return ret;
    }
    public void changeFonts()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");
        db = new DBHandler(this);
        bitkiTuru = ((EditText)findViewById(R.id.bitkiTuru_BitkiIsimKoy));
        devam = (Button)findViewById(R.id.devamButonBitkiIsimKoy);

        bitkiTuru.setText(bitkiTuru());
        bitkiTuru.setTypeface(typeface);

        bitkiISIM = (EditText)findViewById(R.id.bitkiIsimKoy);
        bitkiISIM.setHint("Bitkiye İsim Koy");
        bitkiISIM.setTypeface(typeface);

        devam.setText("DEVAM");
        devam.setTypeface(typeface);

    }
}

