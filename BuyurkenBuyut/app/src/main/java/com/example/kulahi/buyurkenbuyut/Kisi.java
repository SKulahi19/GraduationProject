package com.example.kulahi.buyurkenbuyut;


public class Kisi {


    private int id;
    private String isim;
    private String soyisim;
    private String sifre;
    private String bitkiAdi;
    private String bitkiTuru;
    private String sicaklik;
    private String nem;
    private String isi;
    private String tarih;
    private String ortalamaIsi;
    private String ortalamaNem;
    private String ortalamaSicaklik;

    public String getOrtalamaIsi() {
        return ortalamaIsi;
    }

    public void setOrtalamaIsi(String ortalamaIsi) {
        this.ortalamaIsi = ortalamaIsi;
    }

    public String getOrtalamaNem() {
        return ortalamaNem;
    }

    public void setOrtalamaNem(String ortalamaNem) {
        this.ortalamaNem = ortalamaNem;
    }

    public String getOrtalamaSicaklik() {
        return ortalamaSicaklik;
    }

    public void setOrtalamaSicaklik(String ortalamaSicaklik) {
        this.ortalamaSicaklik = ortalamaSicaklik;
    }



    public Kisi (int id,String isim,String soyisim,String sifre,String bitkiAdi,String bitkiTuru,
                String sicaklik,String nem,String isi,String tarih)
    {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.sifre = sifre;
        this.bitkiAdi = bitkiAdi;
        this.bitkiTuru = bitkiTuru;
        this.sicaklik = sicaklik;
        this.nem = nem;
        this.isi = isi;
        this.tarih = tarih;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getBitkiAdi() {
        return bitkiAdi;
    }

    public void setBitkiAdi(String bitkiAdi) {
        this.bitkiAdi = bitkiAdi;
    }

    public String getBitkiTuru() {
        return bitkiTuru;
    }

    public void setBitkiTuru(String bitkiTuru) {
        this.bitkiTuru = bitkiTuru;
    }

    public String getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(String sicaklik) {
        this.sicaklik = sicaklik;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }


}
