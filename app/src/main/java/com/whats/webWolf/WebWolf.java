package com.whats.webWolf;

import static com.whats.webWolf.SharedpreffSave.saredSaveInfo;
import static com.whats.webWolf.StartWolf.startGameWolf;
import static com.whats.webWolf.StringMethods.codWolf;
import static com.whats.webWolf.VariablsWolf.CON_CONTEXXT_WOLF;
import static com.whats.webWolf.VariablsWolf.CON_OFFER_WOLF;
import static com.whats.webWolf.VariablsWolf.UPLOAD_WOLF;
import static com.whats.webWolf.VariablsWolf.WEB_VIEW_WOLF;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.whats.R;


public class WebWolf extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_wolf, container, false);
        WEB_VIEW_WOLF = view.findViewById(R.id.webView);
        setVebViewCrWolf();
        Log.i("MyLog", saredSaveInfo(CON_CONTEXXT_WOLF, null));
        WEB_VIEW_WOLF.loadUrl(saredSaveInfo(CON_CONTEXXT_WOLF, null));

        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setVebViewCrWolf() {
        WEB_VIEW_WOLF.getSettings().setJavaScriptEnabled(true);
        WEB_VIEW_WOLF.getSettings().setAllowContentAccess(true);
        WEB_VIEW_WOLF.getSettings().setDomStorageEnabled(true);
        WEB_VIEW_WOLF.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WEB_VIEW_WOLF.getSettings().setSupportMultipleWindows(false);
        WEB_VIEW_WOLF.getSettings().setBuiltInZoomControls(true);
        WEB_VIEW_WOLF.getSettings().setUseWideViewPort(true);
        WEB_VIEW_WOLF.getSettings().setAppCacheEnabled(true);
        WEB_VIEW_WOLF.getSettings().setDisplayZoomControls(false);
        WEB_VIEW_WOLF.getSettings().setAllowFileAccess(true);
        WEB_VIEW_WOLF.getSettings().setLightTouchEnabled(true);
        WEB_VIEW_WOLF.clearCache(false);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(WEB_VIEW_WOLF, true);
        WEB_VIEW_WOLF.setWebViewClient(new seeetWebView());
        WEB_VIEW_WOLF.setWebChromeClient(new ShroomeClientStart());
    }
    public static class seeetWebView extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String urlPWolf, Bitmap favicon) {
            if (urlPWolf.contains(codWolf("error=appafAs3f", 2)) ||
                    urlPWolf.contains(codWolf("fkucdngf.jvon", 2))) {
                startGameWolf();
            }
        }
    }
    public static class ShroomeClientStart extends WebChromeClient {
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallbackWolf, FileChooserParams fileChooserParamsWolf) {
            if (UPLOAD_WOLF != null) {
                UPLOAD_WOLF.onReceiveValue(null);
                UPLOAD_WOLF = null;
            }

            UPLOAD_WOLF = filePathCallbackWolf;

            Intent intentScopely = fileChooserParamsWolf.createIntent();
            try {
                CON_OFFER_WOLF.startActivityForResult(intentScopely, 100);
            } catch (ActivityNotFoundException e) {
                UPLOAD_WOLF = null;
                return false;
            }
            return true;
        }
    }
}