package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Stars extends AppCompatActivity {
    Button btnIrCam,btnCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        RatingBar mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView mRatingScale = (TextView) findViewById(R.id.tvRatingScale);
        EditText mFeedback = (EditText) findViewById(R.id.etFeedback);

        btnIrCam=(Button)findViewById(R.id.btnIrCam);
        btnIrCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Stars.this, Camara.class);
                startActivity(intent);

            }
        });
        btnCalendario=(Button)findViewById(R.id.btnCalendario);
        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Stars.this, Calendar.class);
                startActivity(intent);

            }
        });

        Button mSendFeedback = (Button) findViewById(R.id.btnSubmit);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Mala");
                        break;
                    case 2:
                        mRatingScale.setText("Necesita mejorar");
                        break;
                    case 3:
                        mRatingScale.setText("Buena");
                        break;
                    case 4:
                        mRatingScale.setText("Genial");
                        break;
                    case 5:
                        mRatingScale.setText("Asombroso.Me encanta");
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });
        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFeedback.getText().toString().isEmpty()) {
                    Toast.makeText(Stars.this, "Por favor complete el cuadro de comentario", Toast.LENGTH_LONG).show();
                } else {
                    mFeedback.setText("");
                    mRatingBar.setRating(0);
                    Toast.makeText(Stars.this, "Gracias por compartir tus comentarios", Toast.LENGTH_SHORT).show();
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