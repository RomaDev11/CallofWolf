package com.whats.webWolf;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedpreffSave {
    public static String saredSaveInfo(Context coxMinWolf, String strMinWolf){
        SharedPreferences spMinWolf = PreferenceManager.getDefaultSharedPreferences(coxMinWolf);
        if(strMinWolf != null){
            SharedPreferences.Editor editMinWolf = spMinWolf.edit();
            editMinWolf.putString("save", strMinWolf);
            editMinWolf.apply();
            return strMinWolf;
        }else{
            return spMinWolf.getString("save", null);
        }
    }
}
