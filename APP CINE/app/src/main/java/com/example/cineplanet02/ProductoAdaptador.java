package com.example.cineplanet02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ProductoAdaptador extends RecyclerView.Adapter<ProductoAdaptador.ViewHolder> {

    private Context mContext;
    private ArrayList<Producto> mProductoList;
    public Map<String,Integer> _prodsComp;
    public Map<String,String> _prodsNom;



    public ProductoAdaptador(Context context, ArrayList<Producto> ProductoList){
        mContext = context;
        mProductoList = ProductoList;
        _prodsComp=new HashMap<String,Integer>();
        _prodsNom=new HashMap<String,String>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.iteam_producto,parent,false);
        ProductoAdaptador.ViewHolder viewHolder = new ProductoAdaptador.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = mProductoList.get(position);
        holder.idProd = producto.getId();
        holder.nombre = producto.getNombre();
        holder.precio = producto.getPrecio();
        String stock = producto.getStock();
        String idcat = producto.getIdcat();
        String img = producto.getImg();


        holder.txttitulo.setText(holder.nombre);
        holder.txtPrecio.setText("s/ "+holder.precio);
        holder.txtCantidad.setText("0");
        Picasso.with(mContext).load(img).fit().centerInside().into(holder.mImageView);

        holder.btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cantidad++;
                holder.totpro = holder.cantidad * Float.parseFloat(holder.precio);
                holder.txtCantidad.setText(""+holder.cantidad);
                _prodsComp.put(holder.idProd,holder.cantidad);
                _prodsNom.put(holder.nombre,""+holder.totpro);
            }
        });
        holder.btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.cantidad != 0) {
                    holder.cantidad--;
                    holder.totpro = holder.cantidad * Float.parseFloat(holder.precio);
                    holder.txtCantidad.setText(""+holder.cantidad);
                    _prodsComp.put(holder.idProd,holder.cantidad);
                    _prodsNom.put(holder.nombre,""+holder.totpro);
                }
                if(holder.cantidad==0){
                    _prodsComp.remove(holder.idProd);
                    _prodsNom.remove(holder.nombre);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mProductoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView txttitulo;
        public TextView txtPrecio;
        public TextView txtCantidad;
        public Button btnMas;
        public Button btnMenos;
        public int cantidad=0;
        public float totpro;
        public String idProd, nombre, precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgProducto);
            txttitulo = itemView.findViewById(R.id.txtProductoLista);
            txtPrecio = itemView.findViewById(R.id.txtPrecioLista);
            txtCantidad = itemView.findViewById(R.id.txtCantidadLista);
            btnMenos = itemView.findViewById(R.id.btnRestar);
            btnMas = itemView.findViewById(R.id.btnSumar);

        }
    }
}
