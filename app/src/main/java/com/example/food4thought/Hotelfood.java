package com.example.food4thought;

public class Hotelfood {

    String chapati,dal,sabji,latitude,longitude;

    public Hotelfood() {
    }

    public Hotelfood(String chapati, String dal, String sabji, String latitude, String longitude) {
        this.chapati = chapati;
        this.dal = dal;
        this.sabji = sabji;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getChapati() {
        return chapati;
    }

    public void setChapati(String chapati) {
        this.chapati = chapati;
    }

    public String getDal() {
        return dal;
    }

    public void setDal(String dal) {
        this.dal = dal;
    }

    public String getSabji() {
        return sabji;
    }

    public void setSabji(String sabji) {
        this.sabji = sabji;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
