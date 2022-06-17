package com.whats;

import static com.whats.webWolf.VariablsWolf.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CON_OFFER_WOLF = this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (UPLOAD_WOLF == null)
                return;
            UPLOAD_WOLF.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, data));
            UPLOAD_WOLF = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (WEB_VIEW_WOLF.isFocusable() && WEB_VIEW_WOLF.canGoBack())
            WEB_VIEW_WOLF.goBack();
    }
}