package com.sncf.entretienproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * @author omar_bennouna
 */

public class MainWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        setTitle(getIntent().getStringExtra("TITLE"));
        final WebView webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(getIntent().getStringExtra("URL"));
    }
}
