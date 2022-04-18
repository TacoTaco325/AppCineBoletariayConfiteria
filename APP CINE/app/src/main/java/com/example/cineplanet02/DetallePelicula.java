package com.example.cineplanet02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetallePelicula extends AppCompatActivity implements View.OnClickListener {

    YouTubePlayerView ytp;
    TextView lbltitulo, lblDetalles, lblsinopsis;
    Button btn3pm, btn6pm, btn9pm;
    String ID, Titulo, Clasificacion, Genero, Duracion, Estreno, Sinopsis,Image, VideoID, hora;
    Spinner spn;
    ArrayList<String> lstSedes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        Bundle extra = this.getIntent().getExtras();
        ID = extra.getString("id");
        Titulo = extra.getString("titulo");
        Clasificacion = extra.getString("clasificacion");
        Genero = extra.getString("genero");
        Duracion = extra.getString("duracion");
        Estreno = extra.getString("estreno");
        Sinopsis = extra.getString("sinopsis");
        Image = extra.getString("image");
        VideoID = extra.getString("videoid");

        lbltitulo = findViewById(R.id.txtTituloDetalle);
        lblsinopsis = findViewById(R.id.txtSinopsisDetalle);
        lblDetalles = findViewById(R.id.txtDetalles);
        btn3pm = findViewById(R.id.btn3);
        btn6pm = findViewById(R.id.btn6);
        btn9pm = findViewById(R.id.btn9);
        spn = findViewById(R.id.spnSedes);
        ytp = findViewById(R.id.youtube_player_view);

        btn3pm.setOnClickListener(this);
        btn6pm.setOnClickListener(this);
        btn9pm.setOnClickListener(this);

        ytp.setEnableAutomaticInitialization(false);
        getLifecycle().addObserver(ytp);

        ytp.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                youTubePlayer.loadVideo(VideoID, 0);
                youTubePlayer.pause();
            }
        });

        lbltitulo.setText(Titulo);
        lblsinopsis.setText(Sinopsis);
        lblDetalles.setText("Clasificación: "+Clasificacion+"                                Genero: "+Genero+"\n" +
                            "Duración:      "+Duracion+"                                     Estreno: "+Estreno);

        lstSedes.add("Seleccione su Cine Favorito");
        ListarSede();




        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                btn3pm.setVisibility(View.INVISIBLE);
                btn6pm.setVisibility(View.INVISIBLE);
                btn9pm.setVisibility(View.INVISIBLE);
                if (!spn.getSelectedItem().toString().equals("Seleccione su Cine Favorito")){
                    ListarHorarios();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void ListarSede(){
        String url = "http://192.168.100.21/CinePlanet/API/Sede.php?idpelicula="+ID+"";


        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray funcion = response.getJSONArray("funcion");
                    for (int i = 0 ; i < funcion.length() ; i++){
                        JSONObject index = funcion.getJSONObject(i);
                        String sede = index.getString("sede");
                        lstSedes.add(sede);
                    }
                    spn.setAdapter(new ArrayAdapter<String>(DetallePelicula.this, android.R.layout.simple_spinner_dropdown_item, lstSedes));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                spn.setAdapter(new ArrayAdapter<String>(DetallePelicula.this, android.R.layout.simple_spinner_dropdown_item, lstSedes));
            }
        });

        Volley.newRequestQueue(this).add(get);
    }

    public void ListarHorarios(){
        String url = "http://192.168.100.21/CinePlanet/API/Funcion.php?sede="+spn.getSelectedItem().toString()+"&id="+ID+"";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray funcion = response.getJSONArray("funcion");
                    for (int i = 0 ; i < funcion.length() ; i++){
                        JSONObject index = funcion.getJSONObject(i);
                        String hora = index.getString("hora");
                        switch (hora){
                            case "15:00":
                                btn3pm.setVisibility(View.VISIBLE);
                                break;
                            case "18:00":
                                btn6pm.setVisibility(View.VISIBLE);
                                break;
                            case "21:00":
                                btn9pm.setVisibility(View.VISIBLE);
                                break;
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



    @Override
    public void onClick(View view) {



        switch (view.getId()){
            case R.id.btn3:
                hora = btn3pm.getText().toString();
                break;
            case R.id.btn6:
                hora = btn6pm.getText().toString();
                break;
            case R.id.btn9:
                hora = btn9pm.getText().toString();
                break;
        }

        String url = "http://192.168.100.21/CinePlanet/API/Sala.php?hora="+hora+"&idpel="+ID+"";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray funcion = response.getJSONArray("funcion");
                    for (int i = 0 ; i<funcion.length() ; i++){
                        JSONObject index = funcion.getJSONObject(i);
                        String idfuncion = index.getString("idfuncion");
                        String sala = index.getString("sala");

                        Intent intent = new Intent(DetallePelicula.this, butaca.class);
                        intent.putExtra("ID",ID);
                        intent.putExtra("titulo",Titulo);
                        intent.putExtra("genero",Genero);
                        intent.putExtra("clasificacion",Clasificacion);
                        intent.putExtra("duracion",Duracion);
                        intent.putExtra("sede", spn.getSelectedItem().toString());
                        intent.putExtra("hora",hora);
                        intent.putExtra("idfuncion",idfuncion);
                        intent.putExtra("sala",sala);
                        startActivity(intent);
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



        /*switch (view.getId()){
            case R.id.btn3:
                hora = btn3pm.getText().toString();
                sala();
                System.out.println(idfuncion+" "+sala);
                break;
            case R.id.btn6:
                hora = btn6pm.getText().toString();
                sala();
                System.out.println(idfuncion+" "+sala);
                break;
            case R.id.btn9:
                hora = btn9pm.getText().toString();
                sala();
                System.out.println(idfuncion+" "+sala);
                break;
        }*/

    }
}