package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button bot1,bot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot1=(Button) findViewById(R.id.btnRegistrar);
        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Registro.class);
                startActivity(i);

            }
        });
        bot2=(Button)findViewById(R.id.btnLogin);
        bot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Login.class);
                startActivity(i);

            }
        });
    }


}