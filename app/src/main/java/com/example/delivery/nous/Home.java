package com.example.delivery.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.delivery.DiaHorario;
import com.example.delivery.MainActivity;
import com.example.delivery.Pedidos;
import com.example.delivery.R;
import com.example.delivery.Stars;

public class Home extends AppCompatActivity {
   Button btnSig,btnPagar;
    private View btnstar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnPagar=findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this, QrPagoActivity.class);
                startActivity(intent);

            }
        });

       btnSig=findViewById(R.id.btnSig);
       btnSig.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Home.this, DiaHorario.class);
               startActivity(intent);

           }
       });

        btnstar=findViewById(R.id.imageStar);
        btnstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this, Stars.class);
                startActivity(intent);

            }
        });
        if(getSupportActionBar()!=null) {

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
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
            Intent intent = new Intent(Home.this, Pedidos.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}