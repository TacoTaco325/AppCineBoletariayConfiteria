package com.example.cineplanet02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cineplanet02.ui.ListaProducto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class butaca extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout container;
    ArrayList<String> lstButaca = new ArrayList<>();
    String ID, Titulo, Genero, Clasificacion, Duracion, Sede, Hora, idfuncion, sala;
    TextView num;
    Button btn;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butaca);

        Bundle extra = this.getIntent().getExtras();
        ID = extra.getString("ID");
        Titulo = extra.getString("titulo");
        Genero = extra.getString("genero");
        Clasificacion = extra.getString("clasificacion");
        Duracion = extra.getString("duracion");
        Sede = extra.getString("sede");
        Hora = extra.getString("hora");
        sala = extra.getString("sala");
        idfuncion = extra.getString("idfuncion");
        System.out.println(idfuncion+" "+sala);

        container = findViewById(R.id.ly);
        num = findViewById(R.id.txtbutaselect);
        btn = findViewById(R.id.btnEleccion);

        num.setText("" + 0);

        for (int i = 0; i < container.getChildCount(); i++) {
            if (container.getChildAt(i) instanceof ToggleButton) {
                /*((ToggleButton) container.getChildAt(i)).setTextOff("A" + i);
                ((ToggleButton) container.getChildAt(i)).setTextOn("A" + i);*/
                container.getChildAt(i).setOnClickListener(this);
            }
        }

        reservar();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float totbut = n * 15;
                if (n != 0) {
                    new AlertDialog.Builder(butaca.this)
                            .setMessage("SELECCIONE")
                            .setCancelable(true)
                            .setPositiveButton("REALIZAR COMPRA", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(butaca.this, Compra.class);
                                    intent.putExtra("ID", ID);
                                    intent.putExtra("titulo", Titulo);
                                    intent.putExtra("clasificacion", Clasificacion);
                                    intent.putExtra("genero", Genero);
                                    intent.putExtra("sede", Sede);
                                    intent.putExtra("duracion", Duracion);
                                    intent.putExtra("hora", Hora);
                                    intent.putExtra("sala", sala);
                                    intent.putExtra("lstbutaca", lstButaca);
                                    intent.putExtra("idfuncion", idfuncion);
                                    intent.putExtra("totbut",totbut);
                                    intent.putExtra("confi", "0");
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("IR A CONFITERIA", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(butaca.this, ListaProducto.class);
                                    intent.putExtra("ID", ID);
                                    intent.putExtra("titulo", Titulo);
                                    intent.putExtra("clasificacion", Clasificacion);
                                    intent.putExtra("genero", Genero);
                                    intent.putExtra("sede", Sede);
                                    intent.putExtra("duracion", Duracion);
                                    intent.putExtra("hora", Hora);
                                    intent.putExtra("sala", sala);
                                    intent.putExtra("lstbutaca", lstButaca);
                                    intent.putExtra("idfuncion", idfuncion);
                                    intent.putExtra("totbut",totbut);
                                    startActivity(intent);
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                } else {
                    Toast.makeText(butaca.this, "No hay butacas Seleccionadas", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onClick(View view) {
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            view.setBackgroundColor(Color.rgb(177, 38, 80));
            n++;
            num.setText("" + n);
            lstButaca.add(((ToggleButton) view).getTextOn().toString());
        } else {
            view.setBackgroundColor(Color.rgb(39, 144, 193));
            n--;
            num.setText("" + n);
            lstButaca.remove(((ToggleButton) view).getTextOn().toString());
        }
    }

    public void reservar() {
        String url = "http://192.168.100.21/CinePlanet/API/Reservacion.php?id="+idfuncion+"";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("gato", response.toString());
                try {
                    JSONArray reservacion = response.getJSONArray("reservacion");
                    for (int i = 0; i < reservacion.length(); i++) {
                        JSONObject index = reservacion.getJSONObject(i);
                        idfuncion = index.getString("idfuncion");
                        sala = index.getString("sala");
                        String codbutaca = index.getString("codbutaca");
                        for (int j = 0; j < container.getChildCount(); j++) {
                            if (container.getChildAt(j) instanceof ToggleButton) {
                                if (((ToggleButton) container.getChildAt(j)).getTextOff().equals(codbutaca)) {
                                    container.getChildAt(j).setEnabled(false);
                                    container.getChildAt(j).setBackgroundColor(Color.rgb(195, 195, 195));
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        Volley.newRequestQueue(this).add(get);
    }
}