package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BitkiDurumuEkrani extends AppCompatActivity {


    TextView bitkiIsmi;
    TextView bitkiTuru;
    TextView sicaklik;
    TextView nem;
    TextView isi;
    Button takvimeGit;
    double sicaklikOrtalama = 0, isiOrtalama = 0, nemOrtalama = 0,count = 0;
    protected static ArrayList<Ortalama> gunOrtalamalari =new ArrayList<Ortalama>();

    EditText BITKI_ISMI,BITKI_TURU,SICAKLIK,NEM,ISI;
    DBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitki_durumu_ekrani);

        changeFonts0();
        getData();
        changeFonts();
    }

    public  void onClickBitkiDurumuEkrani(View view)
    {
        if(view.getId() == R.id.takvimeGit)
        {
            Ortalama ortalama = new Ortalama(nemOrtalama/count,isiOrtalama/count,sicaklikOrtalama/count,0);
            gunOrtalamalari.add(ortalama);
            nemOrtalama = 0;
            isiOrtalama = 0;
            sicaklikOrtalama = 0;
            count = 0;
            Intent intent = new Intent(this,Takvim.class);
            startActivity(intent);
        }
    }

    void getData()
    {
        Timer timerAsync = new Timer();
        db = new DBHandler(this);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        changeNumberFonts();
                        sicaklik.setText(""+Integer.parseInt(db.getKisi(0).getSicaklik()));
                        nem.setText(""+Integer.parseInt(db.getKisi(0).getNem()));
                        isi.setText(""+Integer.parseInt(db.getKisi(0).getIsi()));

                        sicaklikOrtalama += Double.parseDouble(db.getKisi(0).getSicaklik());
                        nemOrtalama += Double.parseDouble(db.getKisi(0).getNem());
                        isiOrtalama += Double.parseDouble(db.getKisi(0).getIsi());
                        count++;
                    }
                });
            }
        };
        timerAsync.schedule(timerTask,0,250);
    }

    public void changeFonts()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");
        BITKI_ISMI = (EditText)findViewById(R.id.bitkiIsmi_Edittext);
        BITKI_TURU = (EditText)findViewById(R.id.bitkiTuru_Edittext);
        SICAKLIK = (EditText)findViewById(R.id.sicalik_Edittext);
        ISI = (EditText)findViewById(R.id.isi_Edittext);
        NEM = (EditText)findViewById(R.id.nem_Edittext);
        takvimeGit = (Button)findViewById(R.id.takvimeGit);

        BITKI_ISMI.setText("Bitki İsmi");
        BITKI_ISMI.setTypeface(typeface);

        BITKI_TURU.setText("Bitki Turu");
        BITKI_TURU.setTypeface(typeface);

        SICAKLIK.setText("Sıcaklık");
        SICAKLIK.setTypeface(typeface);

        ISI.setText("Isı");
        ISI.setTypeface(typeface);

        NEM.setText("Nem");
        NEM.setTypeface(typeface);

        takvimeGit.setText("Takvim");
        takvimeGit.setTypeface(typeface);
    }

    public void changeNumberFonts()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");

        nem = ((TextView) findViewById(R.id.nem_BitkiDurumu));
        isi = ((TextView) findViewById(R.id.isi_BitkiDurumu));
        sicaklik = ((TextView) findViewById(R.id.sicaklik_BitkiDurumu));

        nem.setTypeface(typeface);
        isi.setTypeface(typeface);
        sicaklik.setTypeface(typeface);

    }

    public void changeFonts0()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");
        db = new DBHandler(this);
        bitkiIsmi = (TextView)findViewById(R.id.bitkiAdi_BitkiDurumu);
        bitkiTuru = (TextView)findViewById(R.id.bitkiTuru_BitkiDurumu);

        bitkiIsmi.setText(db.getKisi(0).getBitkiAdi());
        bitkiTuru.setText(db.getKisi(0).getBitkiTuru());


        bitkiIsmi.setTypeface(typeface);
        bitkiTuru.setTypeface(typeface);

    }


}
