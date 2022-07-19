package com.example.delivery.nous;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.delivery.DiaHorario;
import com.example.delivery.MainActivity;
import com.example.delivery.R;

public class Calendar extends AppCompatActivity {
    EditText titulo;
    Button crearEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        titulo= (EditText) findViewById(R.id.editNombreEvento);
        crearEvento= (Button)findViewById( R.id.buttonCrearEvento );


        crearEvento.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!titulo.getText().toString().isEmpty() ) {
                    Intent intent= new Intent(Intent.ACTION_INSERT);
                    intent.setData( CalendarContract.Events.CONTENT_URI );
                    intent.putExtra( CalendarContract.Events.TITLE,titulo.getText().toString());
                    intent.putExtra( CalendarContract.Events.ALL_DAY, "true" );
               //     intent.putExtra( Intent.EXTRA_EMAIL,"" );

                    if(intent.resolveActivity( getPackageManager() )!=null){
                        startActivity(intent );
                    }else {
                        Toast.makeText( Calendar.this, "Esta app no soporta esta acción",Toast.LENGTH_SHORT ).show();
                    }
                } /*else {
                    Toast.makeText( Calendar.this, "Complete los campos para continuar",Toast.LENGTH_SHORT ).show();
                }*/
            }
        } );

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
            Intent intent = new Intent(Calendar.this, DiaHorario.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(Calendar.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
