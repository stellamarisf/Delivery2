package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu_Opc extends AppCompatActivity {

    private View btnCamara;
    Button btnPedido,btnCarta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opc);
        if(getSupportActionBar()!=null) {

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        }

        btnCarta=(Button) findViewById(R.id.btnCarta);
        btnCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu_Opc.this, WebView.class);
                startActivity( intent );
            }
        });
        btnPedido=(Button) findViewById(R.id.btnPedido);
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu_Opc.this,Pedidos.class);
                startActivity( intent );
            }
        });

        btnCamara=findViewById(R.id.imageCamara);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Menu_Opc.this,Camara.class);
                startActivity( intent );
            }
        });
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
            Intent intent = new Intent(Menu_Opc.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(Menu_Opc.this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}