package com.example.kulahi.buyurkenbuyut;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Takvim extends AppCompatActivity {

    Button bir,iki,uc,dort;
    double isi,sicaklik,nem,ortalama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takvim);
        bir = (Button) findViewById(R.id.gunBir);
        iki = (Button)findViewById(R.id.gunIki);
        uc = (Button)findViewById(R.id.gunUc);
        dort = (Button)findViewById(R.id.gunDort);
        changeButtonColors();

    }

    public void onClickTakvim(View view)
    {
        if((view.getId() == R.id.gunBir) && (BitkiDurumuEkrani.gunOrtalamalari.get(0) != null))
        {
            GunSonu.gun = 1;
            Intent intent = new Intent(this,GunSonu.class);
            startActivity(intent);
        }

        else if((view.getId() == R.id.gunIki) && (BitkiDurumuEkrani.gunOrtalamalari.get(1) != null))
        {
            GunSonu.gun = 2;
            Intent intent = new Intent(this,GunSonu.class);
            startActivity(intent);
        }

        else if((view.getId() == R.id.gunUc) && (BitkiDurumuEkrani.gunOrtalamalari.get(2) != null))
        {
            GunSonu.gun = 3;
            Intent intent = new Intent(this,GunSonu.class);
            startActivity(intent);
        }

        else if((view.getId() == R.id.gunDort) && (BitkiDurumuEkrani.gunOrtalamalari.get(3) != null))
        {
            Intent intent = new Intent(this,GunSonu.class);
            GunSonu.gun = 4;
            startActivity(intent);
        }

    }

    public void changeButtonColors()
    {
        int count  = 0;

        while(count < BitkiDurumuEkrani.gunOrtalamalari.size())
        {

                sicaklik = BitkiDurumuEkrani.gunOrtalamalari.get(count).getSicaklikOrtalama();
                isi = BitkiDurumuEkrani.gunOrtalamalari.get(count).getIsiOrtalama();
                nem = BitkiDurumuEkrani.gunOrtalamalari.get(count).getNemOrtalama();
                ortalama = (sicaklik+isi+nem)/3;

            if(count == 0)
            {
                if(ortalama > 2)
                {
                    bir.setBackgroundColor(getResources().getColor(R.color.green));
                    bir.setText("1");
                }
                else if(ortalama > 1 && ortalama < 2)
                {
                    bir.setBackgroundColor(getResources().getColor(R.color.orange));
                    bir.setText("1");
                }
                else
                {
                    bir.setBackgroundColor(getResources().getColor(R.color.red));
                    bir.setText("1");
                }
            }

            else if (count == 1)
            {
                if(ortalama > 2)
                {
                    iki.setBackgroundColor(getResources().getColor(R.color.green));
                    iki.setText("2");
                }
                else if(ortalama > 1 && ortalama < 2)
                {
                    iki.setBackgroundColor(getResources().getColor(R.color.orange));
                    iki.setText("2");
                }
                else
                {
                    iki.setBackgroundColor(getResources().getColor(R.color.red));
                    iki.setText("2");
                }
            }

            else if(count == 2)
            {
                if(ortalama > 2)
                {
                    uc.setBackgroundColor(getResources().getColor(R.color.green));
                    uc.setText("3");
                }
                else if(ortalama > 1 && ortalama < 2)
                {
                    uc.setBackgroundColor(getResources().getColor(R.color.orange));
                    uc.setText("3");
                }
                else
                {
                    uc.setBackgroundColor(getResources().getColor(R.color.red));
                    uc.setText("3");
                }
            }

            else if(count == 3)
            {
                if(ortalama > 2)
                {
                    dort.setBackgroundColor(getResources().getColor(R.color.green));
                    dort.setText("4");
                }
                else if(ortalama > 1 && ortalama < 2)
                {
                    dort.setBackgroundColor(getResources().getColor(R.color.orange));
                    dort.setText("4");
                }
                else
                {
                    dort.setBackgroundColor(getResources().getColor(R.color.red));
                    dort.setText("4");
                }
            }

            count ++;
        }

    }
    }


