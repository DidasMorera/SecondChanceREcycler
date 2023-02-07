package com.pdm.secondchancerecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pdm.secondchancerecycler.databinding.ActivityResultadosBinding;


public class Resultados extends AppCompatActivity {

     ActivityResultadosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_resultados);
      binding = ActivityResultadosBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Bundle bundle = getIntent().getExtras();


        if(!bundle.isEmpty()){
            String nome = bundle.getString("nome");
            String telefone = bundle.getString("telefone");
            String morada = bundle.getString("morada");
            String idade = bundle.getString("idade");
            String sexo = bundle.getString("sexo");

            binding.txtNom.setText(nome);
            binding.txtTel.setText(telefone);
            binding.txtMorr.setText(morada);
            binding.txtIdadd.setText(idade);
            binding.txtSexooo.setText(sexo);

        }
    }
}