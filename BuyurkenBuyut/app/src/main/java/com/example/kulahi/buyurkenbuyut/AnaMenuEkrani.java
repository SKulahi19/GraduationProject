package com.example.kulahi.buyurkenbuyut;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnaMenuEkrani extends AppCompatActivity {// saksi.setBackgroundResource(R.drawable.usume_durumu);

    Button bitki;
    Button veriAl;
    DBHandler db;
    int  notification_counter = 0 ;
    static long count = 0;
    TextView günBilgisi,bitkiAdi;
    ImageView konusmaBalonu;
    boolean checkDatabase = true;


    @Override//bitkiAdi_AnaMenuEkrani  Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Bauhaus_.ttf");
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu_ekrani);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/KGTRUECOLORS_0.ttf");



        bitki = (Button) findViewById(R.id.saksi);
        bitkiAdi = (TextView)findViewById(R.id.bitkiAdi_AnaMenuEkrani);
        günBilgisi =(TextView)findViewById(R.id.günBilgisi);
        konusmaBalonu = (ImageView)findViewById(R.id.konusmaBalonu);
        konusmaBalonu.setVisibility(View.INVISIBLE);
        db = new DBHandler(this);
        günBilgisi.setText(db.getKisi(0).getTarih()+".Gün");
        bitkiAdi.setText(db.getKisi(0).getBitkiAdi());
        bitkiAdi.setTypeface(typeface);
        günBilgisi.setTypeface(typeface);
        checkDatabase();
    }

    public void günAtla(TextView günBilgisi)
    {
         db = new DBHandler(this);
         String gün = günBilgisi.getText().toString();
         int kacinciGun = Integer.parseInt(gün.substring(0,gün.indexOf(".")));
         kacinciGun++;
         db.gunGuncelle(Integer.toString(kacinciGun));
         günBilgisi.setText(db.getKisi(0).getTarih()+".Gün");
        Intent intent = new Intent(this,BitkiDurumuEkrani.class);
        startActivity(intent);
    }


    public void onClickAnaMenuEkrani(View view)
    {
        if(R.id.saksi == view.getId())
        {
            if(konusmaBalonu.getVisibility() == View.INVISIBLE)
                konusmaBalonu.setVisibility(View.VISIBLE);
            else
                konusmaBalonu.setVisibility(View.INVISIBLE);
        }



        else if(R.id.günAtla == view.getId())
        {
            günBilgisi = (TextView)findViewById(R.id.günBilgisi);
            günAtla(günBilgisi);
            Intent intent = new Intent(this,BitkiDurumuEkrani.class);
            startActivity(intent);

        }

        else if(R.id.ayarlar_AnaMenuEkrani == view.getId())
        {
            Intent intent = new Intent(this,Menu.class);
            startActivity(intent);
        }
    }

    public void checkDatabase()
    {
      if(checkDatabase == true)
      {
          Timer timerAsync = new Timer();
          TimerTask timerTask = new TimerTask() {
              @Override
              public void run() {
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run()
                      {

                          randomGenerate();
                          if(Integer.parseInt(db.getKisi(0).getNem())<3)
                          {
                             // bildirimGonder("Nem","Bitki susadi");
                              bitki.setBackgroundResource(R.drawable.usume_durumu);
                              konusmaBalonu.setBackgroundResource(R.drawable.konusma2);
                          }

                          else if(Integer.parseInt(db.getKisi(0).getSicaklik())<1)
                          {
                              //bildirimGonder("Sicaklik","Bitki usuyor");
                              konusmaBalonu.setBackgroundResource(R.drawable.konusma4);
                              bitki.setBackgroundResource(R.drawable.usume_durumu);
                          }
                          else
                          {
                              konusmaBalonu.setBackgroundResource(R.drawable.konusma1);
                              bitki.setBackgroundResource(R.drawable.saksi);
                          }

                          if(BitkiDurumuEkrani.gunOrtalamalari.size() == 4)
                          {
                                 int kirmizi = 0;
                              for(int i = 0; i < BitkiDurumuEkrani.gunOrtalamalari.size();i++)
                              {
                                  if(BitkiDurumuEkrani.gunOrtalamalari.get(i).getKirmizi() == 1)
                                      kirmizi++;
                              }

                              if(kirmizi >= 3)
                              {
                                  //bildirimGonder("Bitki Durumu","Bitki hasat edilemez");
                                  bitki.setBackgroundResource(R.drawable.hasat_edilememe);
                              }
                          }
                      }
                  });
              }
          };
          timerAsync.schedule(timerTask,0,1000);
      }
    }

    public void changeValue(String nem,String sicaklik,String isi)
    {
        db = new DBHandler(this);
        db.nemGuncelle(nem);
        db.sicaklikGuncelle(sicaklik);
        db.isiGuncelle(isi);
    }
    public void bildirimGonder( String title, String text)
    {
        if(title.equalsIgnoreCase("Nem"))
        {
            Intent intent = new Intent(this,AnaMenuEkrani.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.su)
                            .setContentTitle(title)
                            .setContentText(text)
                            .setDefaults(Notification.DEFAULT_SOUND)
                            .setContentIntent(pendingIntent);
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


            mNotifyMgr.notify(++notification_counter, mBuilder.build());
        }
        else if(title.equalsIgnoreCase("Sicaklik"))
        {
            Intent intent = new Intent(this,AnaMenuEkrani.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.sicaklik)
                            .setContentTitle(title)
                            .setContentText(text)
                            .setDefaults(Notification.DEFAULT_SOUND)
                            .setContentIntent(pendingIntent);
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mNotifyMgr.notify(++notification_counter, mBuilder.build());
        }
        else if(title.equalsIgnoreCase("Bitki Durumu"))
        {
            Intent intent = new Intent(this,AnaMenuEkrani.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.uzgun)
                            .setContentTitle(title)
                            .setContentText(text)
                            .setDefaults(Notification.DEFAULT_SOUND)
                            .setContentIntent(pendingIntent);
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mNotifyMgr.notify(++notification_counter, mBuilder.build());
        }
    }

    public void randomGenerate()
    {
        Random randomNumForMoisture = new Random();
        Random randomNumForTempeture = new Random();
        Random randomNumForIsı = new Random();


        int randomIntForMoisture = randomNumForMoisture.nextInt(1);
        int randomIntForTempeture = randomNumForTempeture.nextInt(1);
        int randomIntForIsı = randomNumForIsı.nextInt(1);
        String nem = Integer.toString(randomIntForMoisture);
        String sicaklik = Integer.toString(randomIntForTempeture);
        String isi = Integer.toBinaryString(randomIntForIsı);
        changeValue(nem,sicaklik,isi);
    }


}


