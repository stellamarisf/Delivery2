package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Stars extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        RatingBar mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView mRatingScale = (TextView) findViewById(R.id.tvRatingScale);
        EditText mFeedback = (EditText) findViewById(R.id.etFeedback);



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
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id= item.getItemId();
        if (id==R.id.atrás) {
            Intent intent = new Intent(Stars.this,DiaHorario.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.salir) {
            Intent intent = new Intent(Stars.this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}