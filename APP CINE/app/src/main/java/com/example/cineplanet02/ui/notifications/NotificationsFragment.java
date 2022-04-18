package com.example.cineplanet02.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cineplanet02.R;
import com.example.cineplanet02.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;
    Spinner spn;
    EditText txt;
    Button btn;
    ArrayList<String> lstAsunto = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lstAsunto.add("Seleccione un Asunto");
        lstAsunto.add("Error al comprar");
        lstAsunto.add("Problema al realizar compra");
        lstAsunto.add("Otro...");


        spn = root.findViewById(R.id.spnAsunto);
        txt = root.findViewById(R.id.txtDes);
        btn = root.findViewById(R.id.btnEnviarSpt);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_estilo, lstAsunto);
        spn.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!spn.getSelectedItem().equals("Seleccione un Asunto")){
                    String correo = "1cineplanet2@gmail.com";


                    Intent intent=new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{correo});
                    intent.putExtra(Intent.EXTRA_SUBJECT,spn.getSelectedItem().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,txt.getText().toString());
                    startActivity(intent);

                    txt.setText("");

                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}