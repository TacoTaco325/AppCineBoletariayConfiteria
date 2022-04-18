package com.example.cineplanet02.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cineplanet02.DetallePelicula;
import com.example.cineplanet02.Pelicula;
import com.example.cineplanet02.PeliculaAdaptador;
import com.example.cineplanet02.R;
import com.example.cineplanet02.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements PeliculaAdaptador.OnItemClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    RecyclerView rclC;
    PeliculaAdaptador plAdaptador;
    ArrayList<Pelicula> lstPelicula;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rclC =root.findViewById(R.id.rclCartelera);
        rclC.setHasFixedSize(true);
        rclC.setLayoutManager(new LinearLayoutManager(getContext()));
        lstPelicula = new ArrayList<>();

        listar();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void listar(){
        String url = "http://192.168.100.21/CinePlanet/API/Pelicula.php";

        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray cartelera = response.getJSONArray("cartelera");
                    for(int i = 0; i < cartelera.length() ; i++){
                        JSONObject index = cartelera.getJSONObject(i);
                        String id = index.getString("id");
                        String titulo = index.getString("nombre");
                        String genero = index.getString("genero");
                        String clasi = index.getString("clasificacion");
                        String dura = index.getString("duracion");
                        String imagen = index.getString("img");
                        String estreno = index.getString("estreno");
                        String sinopsis = index.getString("sinopsis");
                        String trailer = index.getString("trailer");
                        String[] asd =trailer.split("v=");
                        String idvideo = asd[1];

                        lstPelicula.add(new Pelicula(id,titulo,genero,clasi,dura,imagen,idvideo,estreno, sinopsis));
                        plAdaptador = new PeliculaAdaptador(getContext(),lstPelicula);
                        rclC.setAdapter(plAdaptador);
                        plAdaptador.setOnItemClickListener(HomeFragment.this);
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

        Volley.newRequestQueue(getContext()).add(get);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetallePelicula.class);
        Pelicula pel = lstPelicula.get(position);

        intent.putExtra("id",pel.getId());
        intent.putExtra("titulo",pel.getTitulo());
        intent.putExtra("genero",pel.getGenero());
        intent.putExtra("clasificacion",pel.getClasi());
        intent.putExtra("duracion",pel.getDuracion());
        intent.putExtra("sinopsis",pel.getSinopsis());
        intent.putExtra("estreno",pel.getEstreno());
        intent.putExtra("image", pel.getImageurl());
        intent.putExtra("videoid",pel.getVideoid());
        startActivity(intent);
    }
}