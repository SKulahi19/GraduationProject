package com.example.kulahi.buyurkenbuyut;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class GunSonu extends AppCompatActivity {


    public static int gun;
    EditText gunSonu;
    ImageView isi;
    ImageView sicaklik;
    ImageView nem;
    double isiD,sicaklikD,nemD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun_sonu);
        changeFonts();
        generateBars();
    }

    public void changeFonts()
    {
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");
        gunSonu = (EditText)findViewById(R.id.gun_sonu);
        gunSonu.setText(gun+".Gün");
        gunSonu.setTypeface(typeface);
    }

    public void generateBars()
    {
        isi = (ImageView) findViewById(R.id.isi_Image);
        sicaklik = (ImageView) findViewById(R.id.sicaklik_Image);
        nem = (ImageView) findViewById(R.id.nem_Image);
        int count = 0;

        while(count < BitkiDurumuEkrani.gunOrtalamalari.size())
        {

            if(count == 0)
            {
                isiD = BitkiDurumuEkrani.gunOrtalamalari.get(0).getIsiOrtalama();//1-4
                nemD = BitkiDurumuEkrani.gunOrtalamalari.get(0).getNemOrtalama();//1-10
                sicaklikD = BitkiDurumuEkrani.gunOrtalamalari.get(0).getSicaklikOrtalama();//1-5

                if(isiD <2.0 && isiD > 1.5)
                {
                    isi.setBackgroundResource(R.drawable.sari);
                }

                else if(isiD <1.5)
                {
                    isi.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(0).setKirmizi(1);
                }
                else if(isiD>2.0)
                {
                    isi.setBackgroundResource(R.drawable.yesil);
                }

                if(sicaklikD <2.0 && sicaklikD > 1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.sari);
                }

                else if(sicaklikD <1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(0).setKirmizi(1);
                }

                else if(sicaklikD>2.0)
                {
                    sicaklik.setBackgroundResource(R.drawable.yesil);
                }

                if(nemD <2.0 && nemD > 1.5)
                {
                    nem.setBackgroundResource(R.drawable.sari);
                }

                else if(nemD < 1.5)
                {
                    nem.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(0).setKirmizi(1);
                }

                else if(nemD>2.0)
                {
                    nem.setBackgroundResource(R.drawable.yesil);
                }


            }


            else if(count == 1)
            {
                isiD = BitkiDurumuEkrani.gunOrtalamalari.get(1).getIsiOrtalama();//1-4
                nemD = BitkiDurumuEkrani.gunOrtalamalari.get(1).getNemOrtalama();//1-10
                sicaklikD = BitkiDurumuEkrani.gunOrtalamalari.get(1).getSicaklikOrtalama();//1-5

                if(isiD <2.0 && isiD > 1.5)
                {
                    isi.setBackgroundResource(R.drawable.sari);
                }

                else if(isiD <1.5)
                {
                    isi.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(1).setKirmizi(1);
                }
                else if(isiD>2.0)
                {
                    isi.setBackgroundResource(R.drawable.yesil);
                }

                if(sicaklikD <2.0 && sicaklikD > 1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.sari);
                }

                else if(sicaklikD <1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(1).setKirmizi(1);
                }

                else if(sicaklikD>2.0)
                {
                    sicaklik.setBackgroundResource(R.drawable.yesil);
                }

                if(nemD <2.0 && nemD > 1.5)
                {
                    nem.setBackgroundResource(R.drawable.sari);
                }

                else if(nemD < 1.5)
                {
                    nem.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(1).setKirmizi(1);
                }

                else if(nemD>2.0)
                {
                    nem.setBackgroundResource(R.drawable.yesil);
                }



            }

            else if(count == 2)
            {
                isiD = BitkiDurumuEkrani.gunOrtalamalari.get(2).getIsiOrtalama();//1-4
                nemD = BitkiDurumuEkrani.gunOrtalamalari.get(2).getNemOrtalama();//1-10
                sicaklikD = BitkiDurumuEkrani.gunOrtalamalari.get(2).getSicaklikOrtalama();//1-5

                if(isiD <2.0 && isiD > 1.5)
                {
                    isi.setBackgroundResource(R.drawable.sari);
                }

                else if(isiD <1.5)
                {
                    isi.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(2).setKirmizi(1);
                }
                else if(isiD>2.0)
                {
                    isi.setBackgroundResource(R.drawable.yesil);
                }

                if(sicaklikD <2.0 && sicaklikD > 1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.sari);
                }

                else if(sicaklikD <1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(2).setKirmizi(1);
                }

                else if(sicaklikD>2.0)
                {
                    sicaklik.setBackgroundResource(R.drawable.yesil);
                }

                if(nemD <2.0 && nemD > 1.5)
                {
                    nem.setBackgroundResource(R.drawable.sari);
                }

                else if(nemD < 1.5)
                {
                    nem.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(2).setKirmizi(1);
                }

                else if(nemD>2.0)
                {
                    nem.setBackgroundResource(R.drawable.yesil);
                }

            }

            else if(count == 3)
            {
                isiD = BitkiDurumuEkrani.gunOrtalamalari.get(3).getIsiOrtalama();//1-4
                nemD = BitkiDurumuEkrani.gunOrtalamalari.get(3).getNemOrtalama();//1-10
                sicaklikD = BitkiDurumuEkrani.gunOrtalamalari.get(3).getSicaklikOrtalama();//1-5

                if(isiD <2.0 && isiD > 1.5)
                {
                    isi.setBackgroundResource(R.drawable.sari);
                }

                else if(isiD <1.5)
                {
                    isi.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(3).setKirmizi(1);
                }
                else if(isiD>2.0)
                {
                    isi.setBackgroundResource(R.drawable.yesil);
                }

                if(sicaklikD <2.0 && sicaklikD > 1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.sari);
                }

                else if(sicaklikD <1.5)
                {
                    sicaklik.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(3).setKirmizi(1);
                }

                else if(sicaklikD>2.0)
                {
                    sicaklik.setBackgroundResource(R.drawable.yesil);
                }

                if(nemD <2.0 && nemD > 1.5)
                {
                    nem.setBackgroundResource(R.drawable.sari);
                }

                else if(nemD < 1.5)
                {
                    nem.setBackgroundResource(R.drawable.kirmizi);
                    BitkiDurumuEkrani.gunOrtalamalari.get(3).setKirmizi(1);
                }

                else if(nemD>2.0)
                {
                    nem.setBackgroundResource(R.drawable.yesil);
                }
            }
            count ++;
        }

        }
    }


