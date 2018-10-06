package vn.org.quan.hong.nguyen.myalarmclock;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity
public class Alarm {

    @NonNull
    public String getAlarmId() {
        return alarmId;
    }

    @PrimaryKey
    @NonNull
    private String alarmId;

    @ColumnInfo
    private int hour;
    @ColumnInfo
    private int minute;
    @ColumnInfo
    private String sHour;
    @ColumnInfo
    private String sMinute;
    @ColumnInfo
    private String amOrPm;


    public Alarm(int hour, int minute) {

        this.hour = hour;
        this.minute = minute;

        if(hour >=0 && minute >=0){
         if(hour >=12){
          amOrPm = "Pm";
          sHour = String.valueOf(hour - 12);
         } else {
             amOrPm = "Am";
             sHour = String.valueOf(hour);
         }

         if (minute <10){
             sMinute = "0"+ minute;
         } else {
             sMinute = String.valueOf(minute);
         }

         if (Integer.valueOf(sHour) <10) {
             sHour = "0" + sHour;
         }
        }

        alarmId = sHour+sMinute+amOrPm;
    }

    public String getAmOrPm() {
        return amOrPm;
    }

    public int getHour() {

        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        if(hour >12){
            amOrPm = "Pm";
            sHour = String.valueOf(hour - 12);
        } else {
            amOrPm = "Am";
            sHour = String.valueOf(hour);
        }

        if (Integer.valueOf(sHour) <10) {
            sHour = "0" + sHour;
        }

        alarmId = sHour+sMinute+amOrPm;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        if (minute <10){
            sMinute = "0"+ minute;
        } else {
            sMinute = String.valueOf(minute);
        }

        alarmId = sHour+sMinute+amOrPm;
    }

    public void setAlarmId(@NonNull String alarmId) {
        this.alarmId = alarmId;
    }

    public void setAmOrPm(String amOrPm) {
        this.amOrPm = amOrPm;
    }

    public String getSHour() {

        return sHour;
    }

    public String getSMinute() {

        return sMinute;
    }

    public void setSHour(String sHour) {
        this.sHour = sHour;
    }

    public void setSMinute(String sMinute) {
        this.sMinute = sMinute;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", sHour='" + sHour + '\'' +
                ", sMinute='" + sMinute + '\'' +
                ", amOrPm='" + amOrPm + '\'' +
                '}';
    }

}
