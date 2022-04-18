package com.example.empleadocine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    EditText usu, cont;
    Button btn;
    Empleado objEmp = new Empleado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usu = findViewById(R.id.txtusu);
        cont = findViewById(R.id.txtcont);
        btn = findViewById(R.id.btnLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }
    public void login(){
        String url = "http://192.168.100.21/CinePlanet/API/Login.php?usu="+usu.getText()+"&cont="+cont.getText()+"";

        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray empleado = response.getJSONArray("empleado");
                    for (int i = 0 ; i < empleado.length() ; i++){
                        JSONObject index = empleado.getJSONObject(i);
                        objEmp.idEmp = index.getInt("id");
                        objEmp.Nombre = index.getString("nombre");
                        objEmp.Apellido = index.getString("apellido");
                        objEmp.Dni = index.getString("dni");
                        objEmp.Edad = index.getString("edad");
                        objEmp.idSede = index.getInt("idSede");
                        objEmp.Sede = index.getString("Sede");
                        objEmp.idCargo = index.getInt("idcargo");
                        objEmp.Cargo = index.getString("cargo");
                    }
                    Toast.makeText(Login.this, "Bienvenido "+objEmp.Nombre+"", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "USUARIO Y/O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(get);
    }
}