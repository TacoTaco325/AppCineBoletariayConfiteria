package com.example.empleadocine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String idb;
    TextView txtTitulo, txtFecha, txtHora, txtSala, txtSede, txtopcion;
    Button btnScaner, btnAceptar;
    ListView lstDatos;
    Empleado objEmp = new Empleado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtFuncion);
        txtSala = findViewById(R.id.txtSala);
        txtSede = findViewById(R.id.txtSede);
        txtopcion = findViewById(R.id.txtbutpro);
        btnScaner = findViewById(R.id.btnEscanear);
        btnAceptar = findViewById(R.id.btnConfirmar);
        lstDatos = findViewById(R.id.lst);

        if (objEmp.idCargo==1){
            txtopcion.setText("BUTACAS:");
        }else {
            txtopcion.setText("PRODUCTOS:");
        }


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmar();
            }
        });

        btnScaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(MainActivity.this).initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        idb = result.getContents();

        btnAceptar.setEnabled(true);
        Boleta();


    }

    public void mostrar(){
        txtTitulo.setVisibility(View.VISIBLE);
        txtFecha.setVisibility(View.VISIBLE);
        txtHora.setVisibility(View.VISIBLE);
        txtSala.setVisibility(View.VISIBLE);
        txtSede.setVisibility(View.VISIBLE);
    }

    public  void Boleta(){
        mostrar();
        String url = "http://192.168.100.21/CinePlanet/API/DatosBoleta.php?idb="+idb+"";

        JsonObjectRequest getBoleta = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray boleta = response.getJSONArray("boleta");
                    for (int i = 0 ; i < boleta.length() ; i++){
                        JSONObject index = boleta.getJSONObject(i);
                        int idse = index.getInt("idSede");
                        int qrb = index.getInt("qrboleteria");
                        int qrc = index.getInt("qrconfiteria");
                        if (objEmp.idCargo==1){
                            if (qrb == 1){
                                btnAceptar.setEnabled(false);
                            }
                        }else {
                            if (qrc == 1){
                                btnAceptar.setEnabled(false);
                            }
                        }

                        if (idse == objEmp.idSede){
                            String titulo = index.getString("nombre");
                            txtTitulo.setText(titulo);
                            String fecha = index.getString("fecha");
                            txtFecha.setText(fecha);
                            String hora = index.getString("hora");
                            txtHora.setText(hora);
                            String sala = index.getString("sala");
                            txtSala.setText(sala);
                            String sede = index.getString("Sede");
                            txtSede.setText(sede);

                            if ( objEmp.idCargo == 1){
                                butacas();
                            }else {
                                productos();
                            }
                        }else {
                            Toast.makeText(MainActivity.this,"SEDE INCORRECTA", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ID NO ENCONTRADA",Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(getBoleta);
    }

    public void butacas(){
        String url = "http://192.168.100.21/CinePlanet/API/DatosButacas.php?idb="+idb+"";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    ArrayList<String> lst = new ArrayList<>();
                    JSONArray butaca = response.getJSONArray("butaca");
                    for (int i = 0 ; i < butaca.length() ; i++){
                        JSONObject index = butaca.getJSONObject(i);
                        lst.add(index.getString("codbutaca"));
                    }
                    ArrayAdapter<String> adp = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,lst);
                    lstDatos.setAdapter(adp);
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

    public void productos(){
        String url = "http://192.168.100.21/CinePlanet/API/DatosProductos.php?idb="+idb+"";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    ArrayList<String> lst = new ArrayList<>();
                    JSONArray producto = response.getJSONArray("producto");
                    for (int i = 0 ; i < producto.length() ; i++){
                        JSONObject index = producto.getJSONObject(i);
                        lst.add(index.getString("nombre")+" CANT: "+index.getString("cantidad"));
                    }
                    ArrayAdapter<String> adp = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,lst);
                    lstDatos.setAdapter(adp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "popo",Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(get);
    }

    public void confirmar(){
        String url = "http://192.168.100.21/CinePlanet/API/ConfirmarBoleta.php?ide="+objEmp.idEmp+"&idb="+idb+"&cargo="+objEmp.idCargo+"";

        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray boleta = response.getJSONArray("boleta");
                    for (int i = 0 ; i < boleta.length() ; i++){
                        JSONObject index = boleta.getJSONObject(i);
                        Toast.makeText(MainActivity.this, index.getString("mensaje"),Toast.LENGTH_SHORT).show();
                    }
                    btnAceptar.setEnabled(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error al Confirmar",Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(get);
    }
}