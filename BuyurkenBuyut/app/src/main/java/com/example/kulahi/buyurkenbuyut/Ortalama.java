package com.example.kulahi.buyurkenbuyut;

/**
 * Created by Külahi on 23.04.2017.
 */

public class Ortalama {

    private  double nemOrtalama;
    private  double isiOrtalama;
    private  double sicaklikOrtalama;
    private  int kirmizi;

    public int getKirmizi() {
        return kirmizi;
    }

    public void setKirmizi(int kirmizi) {
        this.kirmizi = kirmizi;
    }

    public Ortalama(double nemOrtalama, double isiOrtalama, double sicaklikOrtalama, int kirmizi)
    {
        this.nemOrtalama = nemOrtalama;
        this.sicaklikOrtalama = sicaklikOrtalama;
        this.isiOrtalama = isiOrtalama;
        this.kirmizi = kirmizi;
    }

    public double getNemOrtalama() {
        return nemOrtalama;
    }

    public void setNemOrtalama(double nemOrtalama) {
        this.nemOrtalama = nemOrtalama;
    }

    public double getIsiOrtalama() {
        return isiOrtalama;
    }

    public void setIsiOrtalama(double isiOrtalama) {
        this.isiOrtalama = isiOrtalama;
    }

    public double getSicaklikOrtalama() {
        return sicaklikOrtalama;
    }

    public void setSicaklikOrtalama(double sicaklikOrtalama) {
        this.sicaklikOrtalama = sicaklikOrtalama;
    }


}
