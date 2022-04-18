package com.example.cineplanet02.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cineplanet02.Compra;
import com.example.cineplanet02.Pelicula;
import com.example.cineplanet02.PeliculaAdaptador;
import com.example.cineplanet02.Producto;
import com.example.cineplanet02.ProductoAdaptador;
import com.example.cineplanet02.R;
import com.example.cineplanet02.butaca;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ListaProducto extends AppCompatActivity {

    Button btn;
    RecyclerView rclC;
    ProductoAdaptador proAdaptador;
    ArrayList<Producto> lstProducto;
    String ID,Titulo, Genero, Clasificacion, Duracion, Sede, Fecha, Hora, IdFuncion, Sala;
    float totbut;
    ArrayList<String> lstbutaca = new ArrayList<>();
    String[] _prodsComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);

        Bundle extra = this.getIntent().getExtras();
        ID = extra.getString("ID");
        Titulo = extra.getString("titulo");
        Clasificacion = extra.getString("clasificacion");
        Genero = extra.getString("genero");
        Sede = extra.getString("sede");
        Duracion = extra.getString("duracion");
        Fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Hora = extra.getString("hora");
        Sala = extra.getString("sala");
        lstbutaca = extra.getStringArrayList("lstbutaca");
        IdFuncion = extra.getString("idfuncion");
        totbut = extra.getFloat("totbut");

        rclC = findViewById(R.id.rclPro);
        btn = findViewById(R.id.btncontinuar);

        rclC.setHasFixedSize(true);
        rclC.setLayoutManager(new LinearLayoutManager(this));
        lstProducto = new ArrayList<>();




        ListarProducto();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //System.out.println((((ProductoAdaptador)rclC.getAdapter())._prodsComp.keySet()));
                Intent intent = new Intent(ListaProducto.this, Compra.class);
                intent.putExtra("ID", ID);
                intent.putExtra("titulo", Titulo);
                intent.putExtra("clasificacion", Clasificacion);
                intent.putExtra("genero", Genero);
                intent.putExtra("sede", Sede);
                intent.putExtra("duracion", Duracion);
                intent.putExtra("hora", Hora);
                intent.putExtra("sala", Sala);
                intent.putExtra("lstbutaca", lstbutaca);
                intent.putExtra("idfuncion", IdFuncion);
                intent.putExtra("totbut",totbut);
                intent.putExtra("confi", "1");

                ArrayList<String> idpro = new ArrayList<String>(((ProductoAdaptador) rclC.getAdapter())._prodsComp.keySet());
                ArrayList<String> NomPro = new ArrayList<String>(((ProductoAdaptador) rclC.getAdapter())._prodsNom.keySet());
                ArrayList<String> precio = new ArrayList<String>(((ProductoAdaptador) rclC.getAdapter())._prodsNom.values());
                ArrayList<Integer> Cantidad = new ArrayList<Integer>(((ProductoAdaptador) rclC.getAdapter())._prodsComp.values());

                System.out.println((((ProductoAdaptador)rclC.getAdapter())._prodsComp));
                System.out.println((((ProductoAdaptador)rclC.getAdapter())._prodsNom));

                intent.putExtra("lstproid", idpro);
                intent.putExtra("lstnompro", NomPro);
                intent.putExtra("lstprepro", precio);
                intent.putExtra("lstcantpro", Cantidad);

                if (idpro.size()>0) {
                    startActivity(intent);
                }else {
                    Toast.makeText(ListaProducto.this,"seleccione un producto",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void ListarProducto(){
        String url = "http://192.168.100.21/CinePlanet/API/Producto.php";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("gato", response.toString());
                try {
                    JSONArray producto = response.getJSONArray("producto");
                    for (int i = 0 ; i < producto.length() ; i++){
                        JSONObject index = producto.getJSONObject(i);
                        String id = index . getString("idpro");
                        String nombre = index.getString("nombre");
                        String stock = index.getString("stock");
                        String categoria = index.getString("idcat");
                        String precio = index.getString("precio");
                        String img = index.getString("img");
                        lstProducto.add(new Producto(id,nombre,stock,categoria,precio,img));
                        proAdaptador = new ProductoAdaptador(ListaProducto.this,lstProducto);
                        rclC.setAdapter(proAdaptador);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("gato", error.toString());
            }
        });

        Volley.newRequestQueue(this).add(get);
    }
}