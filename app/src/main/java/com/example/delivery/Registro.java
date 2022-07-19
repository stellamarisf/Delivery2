package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.delivery.bd.conexionSQLiteHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    public EditText campoNombre;
    public EditText campoMail;
    public EditText campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
            campoNombre = (EditText) findViewById(R.id.editTextNombre);
            campoMail = (EditText) findViewById(R.id.editTextMail);
            campoPassword = (EditText) findViewById(R.id.editTextPassword);
        }
    }
        public void registro (View view){

            conexionSQLiteHelper conec = new conexionSQLiteHelper(getBaseContext());
            SQLiteDatabase BaseDeDatos = conec.getWritableDatabase();

            String nombre = campoNombre.getText().toString();
            String mail = campoMail.getText().toString();
            String password = campoPassword.getText().toString();

            if (!nombre.isEmpty() && !mail.isEmpty() && !password.isEmpty()) {
                if (!validarMail(mail) || password.trim().length() < 4) {
                    Toast.makeText(this, "Mail no valido o contraseña menor a 4 caracteres", Toast.LENGTH_SHORT).show();
                } else if ((!mail.isEmpty()) || (!password.isEmpty())) {
                    Cursor fila = BaseDeDatos.rawQuery
                            ("Select mail, password from usuarios where mail ='" + mail + "' and password = '" + password + "'", null);

                    if (fila.moveToFirst()) {
                        campoMail.setText( fila.getString( 0 ) );
                        campoPassword.setText(fila.getString(1));
                        Toast.makeText(this, "Usuario ya creado!", Toast.LENGTH_SHORT).show();
                    } else {

                        ContentValues insertar = new ContentValues();
                        insertar.put("mail", mail);
                        insertar.put("nombre", nombre);
                        insertar.put("password", password);
                        BaseDeDatos.insert("usuarios", null, insertar);
                        BaseDeDatos.close();
                        campoNombre.setText("");
                        campoMail.setText("");
                        campoPassword.setText("");

                        Toast.makeText(this, "Hola!!!", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(Registro.this, Menu_Opc.class);
                        startActivity(intent);
                    }
                }
            } else {
                Toast.makeText(this, "Completar todos los campos.", Toast.LENGTH_LONG).show();
            }
        }

        //validacion de mail
        public static boolean validarMail (String email){
            String expresiones = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expresiones, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            int id = item.getItemId();
            if (item.getItemId() == android.R.id.home) {
                finish();
            }
            return super.onOptionsItemSelected(item);
        }
    }