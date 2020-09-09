package com.example.actividad2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText x1, y1, x2, y2;
    Button pendiente, punto_medio, cuadrante;
    Random aleatorio = new Random();
    int aleatorio1 = aleatorio.nextInt(50);
    int aleatorio2 = aleatorio.nextInt(50);
    int aleatorio3 = aleatorio.nextInt(50);
    int aleatorio4 = aleatorio.nextInt(50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x2 = findViewById(R.id.edt_valorx2);
        x1 = findViewById(R.id.edt_valorx1);
        y1 = findViewById(R.id.edt_valory1);
        y2 = findViewById(R.id.edt_valory2);

        pendiente = findViewById(R.id.btn_pendiente);
        punto_medio = findViewById(R.id.btn_punto_medio);
        cuadrante = findViewById(R.id.btn_cuadrante);
        pendiente.setOnClickListener(this);
        punto_medio.setOnClickListener(this);
        cuadrante.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_opciones, m);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.Aleatorio) {
            x1.setText(String.valueOf(aleatorio1));
            x2.setText(String.valueOf(aleatorio2));
            y1.setText(String.valueOf(aleatorio3));
            y2.setText(String.valueOf(aleatorio4));
        }

        if (id == R.id.Distancia) {

            double Valor_x1 = Double.parseDouble(x1.getText().toString());
            double Valor_x2 = Double.parseDouble(x2.getText().toString());
            double Valor_y1 = Double.parseDouble(y1.getText().toString());
            double Valor_y2 = Double.parseDouble(y2.getText().toString());

            double Distancia = Math.hypot(Valor_x1 - Valor_x2, Valor_y1 - Valor_y2);

            Toast.makeText(getApplicationContext(), "La Distancia es: " + Distancia, Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onClick(View view) {
        double Valor_x1 = Double.parseDouble(x1.getText().toString());
        double Valor_x2 = Double.parseDouble(x2.getText().toString());
        double Valor_y1 = Double.parseDouble(y1.getText().toString());
        double Valor_y2 = Double.parseDouble(y2.getText().toString());

        switch (view.getId()) {
            case R.id.btn_pendiente:
                if (TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||
                        TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Ingrese los Valores", Toast.LENGTH_LONG).show();
                } else {
                    double pendiente = ((Valor_y2 - Valor_y1) / (Valor_x2 - Valor_x1));
                    Toast.makeText(getApplicationContext(), "Valor Pendiente: " + pendiente, Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_punto_medio:
                if (TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||
                        TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Ingrese los Valores", Toast.LENGTH_LONG).show();
                } else {
                    double punto1 = ((Valor_x2 + Valor_x1) / 2);
                    double punto2 = ((Valor_y2 + Valor_y1) / 2);
                    Toast.makeText(getApplicationContext(), "Valor Punto Medio:" + "(" + punto1 + " ," + punto2 + ")", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_cuadrante:
                if (TextUtils.isEmpty(x1.getText().toString()) || TextUtils.isEmpty(x2.getText().toString()) ||
                        TextUtils.isEmpty(y1.getText().toString()) || TextUtils.isEmpty(y2.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Ingrese los Valores", Toast.LENGTH_LONG).show();

                }
                if (Valor_x1 > 0 && Valor_y1 > 0) {
                    Toast.makeText(getApplicationContext(), "Esta en el primer cuadrante" + "(" + Valor_x1 + " ," + Valor_y1 + ")", Toast.LENGTH_LONG).show();
                } else {
                    if (Valor_x2 < 0 && Valor_y2 < 0) {
                        Toast.makeText(getApplicationContext(), "esta en el tercer cuadrante" + "(" + Valor_x2 + " ," + Valor_y2 + ")", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}


