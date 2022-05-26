package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Pedidos extends AppCompatActivity {
    RadioButton dom;
    CheckBox op1,op2,op3,op4,op5,op6,op7,op8;
    Button bcancelar,bcalcular,bDiaHor;
    TextView ttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        dom=findViewById(R.id.rbEntDom);
        op1=findViewById(R.id.checkSanw);
        op2=findViewById(R.id.checkOmel);
        op3=findViewById(R.id.checkPanq);
        op4=findViewById(R.id.checkWaff);
        op5=findViewById(R.id.checkCafe);
        op6=findViewById(R.id.checkJugos);
        op7=findViewById(R.id.checkBTe);
        op8=findViewById(R.id.checkLic);
        ttotal=findViewById(R.id.txtTotPag);
        bDiaHor=(Button)findViewById(R.id.bDiaHor);
        bDiaHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pedidos.this, DiaHorario.class);
                startActivity(i);

            }
        });
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(item.getItemId()==android.R.id.home){

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    }