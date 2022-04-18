package com.example.cineplanet02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeliculaAdaptador extends RecyclerView.Adapter<PeliculaAdaptador.ViewHolder> {

    private Context mContext;
    private ArrayList<Pelicula> mPeliculaList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    public PeliculaAdaptador(Context context, ArrayList<Pelicula> PeliculaList){
        mContext = context;
        mPeliculaList = PeliculaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pelicula,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula = mPeliculaList.get(position);
        String id = pelicula.getId();
        String imgurl = pelicula.getImageurl();
        String titulo = pelicula.getTitulo();
        String gene = pelicula.getGenero();
        String clasi = pelicula.getClasi();
        String dura = pelicula.getDuracion();


        holder.txtid.setText(""+id);
        holder.txttitulo.setText(titulo);
        holder.txtgene.setText("Genero: "+gene);
        holder.txtclasi.setText("Clasificacion: "+clasi);
        holder.txtdura.setText("Duracion: "+dura);
        Picasso.with(mContext).load(imgurl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mPeliculaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView txtid;
        public TextView txttitulo;
        public TextView txtgene;
        public TextView txtclasi;
        public TextView txtdura;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgPelicula);
            txtid = itemView.findViewById(R.id.txtIDCARTELERA);
            txttitulo = itemView.findViewById(R.id.txtTituloCartelera);
            txtgene = itemView.findViewById(R.id.txtGeneCartelera);
            txtclasi = itemView.findViewById(R.id.txtClasiCartelera);
            txtdura = itemView.findViewById(R.id.txtDuraCartelera);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener !=null){
                        int position =getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
