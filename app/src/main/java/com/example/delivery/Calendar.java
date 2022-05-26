package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calendar extends AppCompatActivity {
    EditText titulo;
    EditText locacion;
    EditText descripcion;
    Button crearEvento,cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        titulo= (EditText) findViewById(R.id.editNombreEvento);
        locacion=(EditText) findViewById( R.id.editTextlocacion );
        descripcion=(EditText) findViewById( R.id.editTextDescripcion );
        crearEvento= (Button)findViewById( R.id.buttonCrearEvento );
        cerrar=(Button)findViewById(R.id.btncerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });

        crearEvento.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!titulo.getText().toString().isEmpty() && !locacion.getText().toString().isEmpty() && !descripcion.getText().toString().isEmpty()) {
                    Intent intent= new Intent(Intent.ACTION_INSERT);
                    intent.setData( CalendarContract.Events.CONTENT_URI );
                    intent.putExtra( CalendarContract.Events.TITLE,titulo.getText().toString());
                    intent.putExtra( CalendarContract.Events.EVENT_LOCATION,locacion.getText().toString());
                    intent.putExtra( CalendarContract.Events.DESCRIPTION,descripcion.getText().toString());
                    intent.putExtra( CalendarContract.Events.ALL_DAY, "true" );
               //     intent.putExtra( Intent.EXTRA_EMAIL,"" );

                    if(intent.resolveActivity( getPackageManager() )!=null){
                        startActivity(intent );
                    }else {
                        Toast.makeText( Calendar.this, "Esta app no soporta esta acción",Toast.LENGTH_SHORT ).show();
                    }
                } else {
                    Toast.makeText( Calendar.this, "Complete los campos para continuar",Toast.LENGTH_SHORT ).show();
                }
            }
        } );
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
