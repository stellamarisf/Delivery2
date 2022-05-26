package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class DiaHorario extends AppCompatActivity implements View.OnClickListener {
    Button btnIrCalen,btnCali,btnShare,btnSalir;
    EditText txtFecha,txtHora,EditFecha,EditHora,txtShare;
    private int dia,mes,anio,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_horario);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        txtShare=(EditText)findViewById(R.id.txtShare);
        btnShare=(Button)findViewById(R.id.btnShare);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        EditFecha=(EditText) findViewById(R.id.EditFecha);
        EditHora=(EditText) findViewById(R.id.EditHora);
        txtFecha=(EditText) findViewById(R.id.txtFecha);
        txtHora=(EditText) findViewById(R.id.txtHora);
        btnCali=(Button)findViewById(R.id.btnCali);
        btnIrCalen=(Button)findViewById(R.id.btnIrCalen);
        EditFecha.setOnClickListener(this);
        EditHora.setOnClickListener(this);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent= new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody="your body here";
                String shareSub="your Subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent,"Share using"));
            }
        });
        btnCali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DiaHorario.this, Stars.class);
                startActivity(intent);
            }
        });
        btnIrCalen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DiaHorario.this, Calendar.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v==EditFecha){
            final Calendar c=Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            anio=c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    txtFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

                }
            },anio,mes,dia);
            datePickerDialog.show();
        }if (v==EditHora){
            final Calendar c=Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    txtHora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
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