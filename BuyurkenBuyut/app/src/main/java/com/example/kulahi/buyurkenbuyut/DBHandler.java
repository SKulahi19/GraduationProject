package com.example.kulahi.buyurkenbuyut;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "peopleInfo";
    private static final String TABLE_NAME = "peopleAndPlant";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ISIM = "isim";
    private static final String COLUMN_SOYISIM = "soyisim";
    private static final String COLUMN_SIFRE = "sifre";
    private static final String COLUMN_BITKIADI = "bitkiAdi";
    private static final String COLUMN_BIKTITURU = "bitkiTuru";
    private static final String COLUMN_SICAKLIK = "sicaklik";
    private static final String COLUMN_NEM = "nem";
    private static final String COLUMN_ISI = "isi";
    private static final String COLUMN_TARIH = "tarih";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_ISIM + " TEXT, " +
                COLUMN_SOYISIM + " TEXT, " +
                COLUMN_SIFRE + " TEXT, " +
                COLUMN_BITKIADI + " TEXT, " +
                COLUMN_BIKTITURU + " TEXT, " +
                COLUMN_SICAKLIK + " TEXT, " +
                COLUMN_ISI + " TEXT, " +
                COLUMN_TARIH + " TEXT, " +
                COLUMN_NEM + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void kisiEkle(Kisi kisi) {

        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, kisi.getId());
            values.put(COLUMN_ISIM, kisi.getIsim());
            values.put(COLUMN_SOYISIM, kisi.getSoyisim());
            values.put(COLUMN_SIFRE, kisi.getSifre());
            values.put(COLUMN_BITKIADI, kisi.getBitkiAdi());
            values.put(COLUMN_BIKTITURU, kisi.getBitkiTuru());
            values.put(COLUMN_SICAKLIK, kisi.getSicaklik());
            values.put(COLUMN_NEM, kisi.getNem());
            values.put(COLUMN_ISI, kisi.getIsi());
            values.put(COLUMN_TARIH, kisi.getTarih());
            db.insert(TABLE_NAME, null, values);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Kisi getKisi(int id) {

        Kisi kisi = null;
        try
        {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID,
                            COLUMN_ISIM, COLUMN_SOYISIM, COLUMN_SIFRE, COLUMN_BITKIADI, COLUMN_BIKTITURU
                            , COLUMN_SICAKLIK, COLUMN_NEM, COLUMN_ISI, COLUMN_TARIH}, COLUMN_ID + "=?",
                    new String[]{String.valueOf(id)}, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();

            kisi = new Kisi(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
                    , cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8)
                    , cursor.getString(9));

            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kisi;
    }

    public void nemGuncelle(String nem)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put(COLUMN_NEM,nem);
            db.update(TABLE_NAME,data,COLUMN_ID + "= 0",null);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void isiGuncelle(String isi)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put(COLUMN_ISI,isi);
            db.update(TABLE_NAME,data,COLUMN_ID + "= 0",null);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void gunGuncelle(String gun)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put(COLUMN_TARIH,gun);
            db.update(TABLE_NAME,data,COLUMN_ID + "= 0",null);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sicaklikGuncelle(String sicaklik)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put(COLUMN_SICAKLIK,sicaklik);
            db.update(TABLE_NAME,data,COLUMN_ID + "= 0",null);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void bitkiTuruGuncelle(String bitkiTuru)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put(COLUMN_BIKTITURU,bitkiTuru);
            db.update(TABLE_NAME,data,COLUMN_ID + "= 0",null);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void bitkiIsmiGuncelle(String bitkiAdi)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues data = new ContentValues();
            data.put(COLUMN_BITKIADI,bitkiAdi);
            db.update(TABLE_NAME,data,COLUMN_ID + "= 0",null);
            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void kayitSil()
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_NAME,COLUMN_ID + "= 0",null);

            db.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
