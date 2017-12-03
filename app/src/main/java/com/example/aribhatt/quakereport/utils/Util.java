package com.example.aribhatt.quakereport.utils;

import android.graphics.Color;

import java.util.Date;

/**
 * Created by aribhatt on 03/12/17.
 */

public class Util {

    public static int getColorCode(double mag){
        if(mag < 2.6){
            return Color.parseColor("#00838F");
        }else if(mag < 5.5){
            return Color.parseColor("#558B2F");
        }else if(mag < 6.1){
            return Color.parseColor("#9E9D24");
        }else if(mag < 7){
            return Color.parseColor("#F9A825");
        }else if(mag < 8){
            return Color.parseColor("#EF6C00");
        }
        return Color.parseColor("#B71C1C");
    }

    public static String getDateString(long mili){
        Date d = new Date(mili);
        return d.toString();
    }
}
