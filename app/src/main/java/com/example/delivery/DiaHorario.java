package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class DiaHorario extends AppCompatActivity  {
    private View btnstar;
    private View btncalendar;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_horario);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        }


        titulo= (TextView) findViewById(R.id.editNombreEvento);
        btncalendar=findViewById(R.id.imageCalendar);
        btncalendar.setOnClickListener(new View.OnClickListener() {
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
                        Toast.makeText( DiaHorario.this, "Esta app no soporta esta acción",Toast.LENGTH_SHORT ).show();
                    }
                }
            }
        } );

        btnstar=findViewById(R.id.imageStar);
        btnstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DiaHorario.this, Stars.class);
                startActivity(intent);

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
            Intent intent = new Intent(DiaHorario.this,Pedidos.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(DiaHorario.this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}