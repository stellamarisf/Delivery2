package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2, e3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.pass);
        e3 = (EditText) findViewById(R.id.Cpass);

        b1 = (Button) findViewById(R.id.registrar);
        b2 = (Button) findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Login.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "complete los campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean chKemail = db.chkemail(s1);
                        if (chKemail == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email ya existe", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(item.getItemId()==android.R.id.home){

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}