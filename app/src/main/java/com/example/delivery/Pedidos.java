package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pedidos extends AppCompatActivity  {
    RadioButton dom;
    TextView EditFecha,EditHora;
    CheckBox op1, op2, op3, op4, op5, op6, op7, op8;
    Button btnPagar_calendar;
    TextView ttotal;
    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        }
        EditFecha = (TextView) findViewById(R.id.EditFecha);
        EditFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int anio = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Pedidos.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dia, int mes, int anio) {
                        EditFecha.setText(dia + "/" + (mes+1) + "/" + anio);
                    }
                },anio,mes,dia);
                //dpd.getDatePicker().setMaxDate(new Date().getTime());
                dpd.getDatePicker().setMinDate(c.getTimeInMillis());
                dpd.show();
            }
        });
        EditHora = (TextView) findViewById(R.id.EditHora);
        EditHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               c = Calendar.getInstance();
                int hora = c.get(Calendar.HOUR_OF_DAY);
                int minuto = c.get(Calendar.MINUTE);
                 TimePickerDialog timePickerDialog=new TimePickerDialog(Pedidos.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
                    }
                },hora,minuto,false);
                 timePickerDialog.show();
            }
        });
        dom = findViewById(R.id.rbEntDom);
        op1 = findViewById(R.id.checkSanw);
        op2 = findViewById(R.id.checkOmel);
        op3 = findViewById(R.id.checkPanq);
        op4 = findViewById(R.id.checkWaff);
        op5 = findViewById(R.id.checkCafe);
        op6 = findViewById(R.id.checkJugos);
        op7 = findViewById(R.id.checkBTe);
        op8 = findViewById(R.id.checkLic);
        ttotal = findViewById(R.id.txtTotPag);
        btnPagar_calendar = (Button) findViewById(R.id.btnPagar_calendar);
        btnPagar_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pedidos.this, DiaHorario.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.atrás) {
            Intent intent = new Intent(Pedidos.this, Menu_Opc.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.salir) {
            Intent intent = new Intent(Pedidos.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void calcular(View v) {
        Double total = 0.0;
        if (dom.isChecked())
            total = total + 100;

        if (op1.isChecked())
            total = total + 240;

        if (op2.isChecked())
            total = total + 150;

        if (op3.isChecked())
            total = total + 240;

        if (op4.isChecked())
            total = total + 150;

        if (op5.isChecked())
            total = total + 450;

        if (op6.isChecked())
            total = total + 600;

        if (op7.isChecked())
            total = total + 200;
        if (op7.isChecked())
            total=total+200;

        if (op8.isChecked())
            total=total+500;

        ttotal.setText("Total :"+ total);
    }
    public void cancelar(View v){
        dom.setChecked(false);
        op1.setChecked(false);
        op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);
        op7.setChecked(false);
        op8.setChecked(false);

        ttotal.setText("Total=0");

    }

    }