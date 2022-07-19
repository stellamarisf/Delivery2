package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    private android.webkit.WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        if(getSupportActionBar()!=null) {

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        }

        webView = (android.webkit.WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://drive.google.com/file/d/1SctLuY6ELCULOn6FEEeWBd375Zb34XIh/view?usp=sharing");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    @Override
    public void onBackPressed(){
        if (webView.canGoBack()){
            webView.canGoBack();
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id= item.getItemId();
        if (id==R.id.atrás) {
            Intent intent = new Intent(WebView.this,Menu_Opc.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(WebView.this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }

