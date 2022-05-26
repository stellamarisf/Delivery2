package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        db=new DatabaseHelper(this);
        e1=(EditText) findViewById(R.id.txtemail);
        e2=(EditText) findViewById(R.id.txtPassw);
        b1=(Button) findViewById(R.id.botIngresar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean chkmailpass=db.emailPassword(email,password);
                if (chkmailpass==true){
                    Intent i=new Intent(getApplicationContext(),Pedidos.class);
                    startActivity(i);
                    //Toast.makeText(getApplicationContext(),"Login exitoso",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Error email y pass",Toast.LENGTH_SHORT).show();
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