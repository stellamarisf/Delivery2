package com.example.delivery.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.delivery.MainActivity;
import com.example.delivery.Pedidos;
import com.example.delivery.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QrPagoActivity extends AppCompatActivity {

    TextView tvMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_pago);
        this.tvMostrar=findViewById(R.id.tvMostrar);

    }

    public void onclick(View view){
        if (view.getId()==R.id.btnPago){
            new IntentIntegrator(this).initiateScan();
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
            Intent intent = new Intent(QrPagoActivity.this, Pedidos.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(QrPagoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onActivityResult(int requestCode, int resultCode,@NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        String datos= result.getContents();
        tvMostrar.setText(datos);

    }
    }


