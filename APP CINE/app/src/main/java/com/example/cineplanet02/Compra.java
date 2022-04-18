package com.example.cineplanet02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Compra extends AppCompatActivity {

    ImageView qr;
    TextView txttitulo, txtclasi, txtgene, txtsede, txtdura, txtfecha, txthora, txtsala, txtTotal;
    Button btn;
    ListView lstBUTACAS, lstProducto;
    String ID,Titulo, Genero, Clasificacion, Duracion, Sede, Fecha, Hora, IdFuncion, Sala, confi, idboleta;
    float totbut, totpro;
    ArrayList<String> lstbutaca = new ArrayList<>();
    ArrayList<String> arrayListproducto = new ArrayList<>();
    ArrayList<String> lstpro = new ArrayList<>();
    ArrayList<Integer> lstcant = new ArrayList<>();
    ArrayList<String> lstnompro = new ArrayList<>();
    ArrayList<String> lstprecio = new ArrayList<>();
    String file_name;
    File new_file;
    String correo = "1cineplanet2@gmail.com";
    String contraseña = "1cineplanet";
    Session session;
    int opcion = 0 ;
    float total = 0;
    int k = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

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

        confi = extra.getString("confi");

        txttitulo = findViewById(R.id.txtPelicula);
        txtclasi = findViewById(R.id.txtClasificacion);
        txtgene = findViewById(R.id.txtGenero);
        txtsede = findViewById(R.id.txtSede);
        txtdura = findViewById(R.id.txtDuracion);
        txtfecha = findViewById(R.id.txtFecha);
        txthora = findViewById(R.id.txtHora);
        txtsala = findViewById(R.id.txtSala);
        txtTotal = findViewById(R.id.txtTotal);
        qr = findViewById(R.id.imgQR);
        btn = findViewById(R.id.btnCompra);
        lstBUTACAS = findViewById(R.id.lstButaca);
        lstProducto = findViewById(R.id.lstProductos);

        if (confi.equals("1")){
            lstpro = extra.getStringArrayList("lstproid");
            lstcant = extra.getIntegerArrayList("lstcantpro");
            lstnompro = extra.getStringArrayList("lstnompro");
            lstprecio = extra.getStringArrayList("lstprepro");
            for (int i = 0; i < lstpro.size(); i++) {
                arrayListproducto.add(lstnompro.get(i) + "  CANT: " + lstcant.get(i).toString() + " PRECIO: " + lstprecio.get(i));
                totpro += Float.parseFloat(lstprecio.get(i));
                System.out.println(totpro);
            }
            ArrayAdapter<String> adpPro = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayListproducto);
            lstProducto.setAdapter(adpPro);
        }

        total = totbut + totpro;
        txttitulo.setText(Titulo);
        txtclasi.setText(Clasificacion);
        txtgene.setText(Genero);
        txtsede.setText(Sede);
        txtdura.setText(Duracion);
        txtfecha.setText(Fecha);
        txthora.setText(Hora);
        txtsala.setText(Sala);
        txtTotal.setText("TOTAL: S/."+total);
        btn.setText("COMPRAR");

        ArrayAdapter<String> adpbutaca = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lstbutaca);
        lstBUTACAS.setAdapter(adpbutaca);

        if (opcion == 0){
            qr.setVisibility(View.INVISIBLE);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) btn.getLayoutParams();
            params.topMargin=1500;
            btn.setLayoutParams(params);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (k == 0){
                    dialog();
                }else{
                    Intent intent = new Intent(Compra.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    public void dialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(Compra.this);
        dialog.setTitle("Correo");

        final EditText weightInput = new EditText(Compra.this);
        weightInput.setInputType(InputType.TYPE_CLASS_TEXT);
        weightInput.setHint("Ingrese su correo");
        dialog.setView(weightInput);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!weightInput.getText().toString().equals("")){
                    compra(weightInput.getText().toString());
                }else {
                    Toast.makeText(Compra.this,"Ingrese un correo",Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialog.create().show();
    }

    public void correo(String cor){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Properties properties =  new Properties();
        properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.auth","true");

        try {

            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo,contraseña);
                }
            });

            if (session != null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("CINEPLANET: Compra Realizada Exitosamente");
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cor));

                Multipart _multipart = new MimeMultipart();

                BodyPart Descripcion = new MimeBodyPart();
                BodyPart IMAGEN = new MimeBodyPart();

                Descripcion.setContent("Muestre este codigo al ingresar a la sala","text/html");

                FileDataSource source = new FileDataSource(file_name);
                IMAGEN.setDataHandler(new DataHandler(source));
                IMAGEN.setFileName(file_name);
                _multipart.addBodyPart(IMAGEN);
                _multipart.addBodyPart(Descripcion);
                message.setContent(_multipart);
                Transport.send(message);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void compra(String correoc){
        if (k == 0) {
            MultiFormatWriter mtf = new MultiFormatWriter();
            String hb = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
            float total = totbut + totpro;
            String url = "http://192.168.100.21/CinePlanet/API/RegistroBoleta.php?fecha="+Fecha+"&hora="+hb+"&total="+total+"&idfun="+IdFuncion+"&correo="+correoc+"";
            JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray boleta = response.getJSONArray("boleta");
                        for (int i = 0 ; i < boleta.length() ; i++){
                            JSONObject index = boleta.getJSONObject(i);
                            idboleta = index.getString("id");
                            for (int b = 0 ; b < lstbutaca.size() ; b++){
                                String urlbut = "http://192.168.100.21/CinePlanet/API/RegistroButaca.php?cod="+lstbutaca.get(b)+"&idf="+IdFuncion+"&idb="+idboleta+"";
                                JsonObjectRequest getbut = new JsonObjectRequest(Request.Method.GET, urlbut, null, new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                });
                                Volley.newRequestQueue(Compra.this).add(getbut);
                            }
                            if (confi.equals("1")){
                                for (int p = 0 ; p < lstpro.size() ; p++){
                                    String urlpro = "http://192.168.100.21/CinePlanet/API/RegistroDetalleProducto.php?idpro="+lstpro.get(p)+"&cant="+lstcant.get(p)+"&costo="+lstprecio.get(p)+"&idb="+idboleta+"";
                                    JsonObjectRequest getpro = new JsonObjectRequest(Request.Method.GET, urlpro, null, new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {

                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    });
                                    Volley.newRequestQueue(Compra.this).add(getpro);
                                }
                            }
                            BitMatrix bm = mtf.encode(idboleta, BarcodeFormat.QR_CODE,500,500);
                            BarcodeEncoder be = new BarcodeEncoder();
                            Bitmap bitmap = be.createBitmap(bm);
                            FileOutputStream fileOutputStream = null;
                            File file = getDisc();
                            if (!file.exists() && !file.mkdirs()){
                                Toast.makeText(Compra.this,"no", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
                            String date = simpleDateFormat.format(new Date());
                            String name = "Img"+date+".jpg";
                            file_name = file.getAbsolutePath()+"/"+name;
                            new_file = new File(file_name);
                            try {
                                fileOutputStream = new FileOutputStream(new_file);
                                bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            refreshGalery(new_file);

                            correo(correoc);

                            qr.setImageBitmap(bitmap);
                            qr.setVisibility(View.VISIBLE);
                            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) btn.getLayoutParams();
                            params.topMargin=1800 ;
                            btn.setLayoutParams(params);
                            btn.setText("Regresar a la Cartelera");

                            new_file.delete();



                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error);
                }
            });
            Volley.newRequestQueue(Compra.this).add(get);
            k = 1;
        }else {
            Intent intent = new Intent(Compra.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void refreshGalery(File file) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }


    private File getDisc(){
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File(file, "imagedemo");
    }



}