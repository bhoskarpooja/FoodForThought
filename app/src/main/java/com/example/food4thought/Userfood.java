package com.example.food4thought;

public class Userfood {
    String Hotelname,chapati,dal,sabji,latitude,longitude,time,status;

    public Userfood() {
    }

    public Userfood(String hotelname, String chapati, String dal, String sabji, String latitude, String longitude, String time, String status) {
        Hotelname = hotelname;
        this.chapati = chapati;
        this.dal = dal;
        this.sabji = sabji;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.status = status;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String hotelname) {
        Hotelname = hotelname;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
