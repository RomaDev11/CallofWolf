package com.whats.webWolf;

import static com.whats.webWolf.StringMethods.codWolf;
import static com.whats.webWolf.StringMethods.subSubstringWolf;
import static com.whats.webWolf.VariablsWolf.*;

import androidx.annotation.Nullable;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.whats.R;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetInfo {
    public static void getIngoFromGGWolf(){
        Request requestWolf;
        Call callWolf;
        OkHttpClient okHttpClientWolf = new OkHttpClient();

        requestWolf = new Request.Builder()
                .get()
                .url(codWolf("jvvru://rcuvgdkp.eqo/tcy/kCYBt3sE", 2))
                .build();
        callWolf = okHttpClientWolf.newCall(requestWolf);
        callWolf.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                assert response.body() != null;
                DATA_FROM_GIST_WOLF = response.body().string().split("::");
            }
        });
    }
    public static void getInitOllWolf(){
        MAPS_APPS_WOLF[3] = "";
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
        AppLinkData.fetchDeferredAppLinkData(CON_CONTEXXT_WOLF, new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkDataWolf) {
                if (appLinkDataWolf == null) {
                    appLinkDataWolf = AppLinkData.createFromActivity(CON_ACTIVITY_WOLF);
                }
                if (appLinkDataWolf != null) {
                    int indexWolf = (Objects.requireNonNull(appLinkDataWolf.getTargetUri()).toString()).indexOf("://") + 3;
                    MAPS_APPS_WOLF[0] = (Objects.requireNonNull(appLinkDataWolf.getTargetUri()).toString()).substring(indexWolf);
                    MAPS_APPS_WOLF[3] = subSubstringWolf( MAPS_APPS_WOLF[0].split("_"));
                }
            }
        });
        try {
            ID_WOLF = AdvertisingIdClient.getAdvertisingIdInfo(CON_CONTEXXT_WOLF).getId();
        } catch (Exception exception) {
        }
        com.onesignal.OneSignal.setLogLevel(com.onesignal.OneSignal.LOG_LEVEL.VERBOSE, com.onesignal.OneSignal.LOG_LEVEL.NONE);
        com.onesignal.OneSignal.initWithContext(CON_CONTEXXT_WOLF);
        com.onesignal.OneSignal.setAppId(CON_CONTEXXT_WOLF.getString(R.string.onesignal_id));
        com.onesignal.OneSignal.setExternalUserId(ID_WOLF);
        AppsFlyerConversionListener appsFlyerConversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> mapWolf) {
                ST_APPS_WOLF = Objects.requireNonNull(mapWolf.get(codWolf("ch_uvcvwu", 2))).toString();
                if (ST_APPS_WOLF.equals(codWolf("Qticpke", 2)) && MAPS_APPS_WOLF[0] == null) {
                    MAPS_APPS_WOLF[1] = codWolf("qticpke", 2);
                }
                String[] mapsStrDecCrazy = {"ecorckip", "ogfkc_uqwteg", "ch_ejcppgn", ""};
                if (ST_APPS_WOLF.equals(codWolf("Pqp-qticpke", 2))) {
                    for (int i = 0; i < MAPS_APPS_WOLF.length; i++) {
                        try {
                            if (i == MAPS_APPS_WOLF.length - 1)
                                MAPS_APPS_WOLF[i] = subSubstringWolf(MAPS_APPS_WOLF[0].split("_"));
                            else
                                MAPS_APPS_WOLF[i] = Objects.requireNonNull(mapWolf.get(codWolf(mapsStrDecCrazy[i], 2))).toString();
                        } catch (Exception e) {
                        }
                    }
                }
            }

            @Override
            public void onConversionDataFail(String s) {
                ST_APPS_WOLF = "error";
                new TimerWolf(15000, 1000);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        };
        ID_LAST_APS_WOLF = AppsFlyerLib.getInstance().getAppsFlyerUID(CON_CONTEXXT_WOLF);
        AppsFlyerLib.getInstance().init(CON_CONTEXXT_WOLF.getString(R.string.appsfluer_id), appsFlyerConversionListener, CON_CONTEXXT_WOLF);
        AppsFlyerLib.getInstance().start(CON_CONTEXXT_WOLF);
    }
}
