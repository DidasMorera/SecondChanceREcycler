package com.pdm.secondchancerecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static ArrayList<Aluno> alunoList;
    EditText name, tele, mora, idad, sex;
    Button ad;
    HoldAndAdaptALunos holdAndAdaptALunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alunoList = new ArrayList<>();
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.ed_nomeAl);
        tele = findViewById(R.id.ed_telefone);
        mora = findViewById(R.id.ed_morada);
        idad = findViewById(R.id.ed_idades);
        sex = findViewById(R.id.ed_sexos);
        ad = findViewById(R.id.btn_env);
        recyclerView = findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DBHandler handler = new DBHandler(MainActivity.this);

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName="", usertele="", userMorada = "", userIdade = "", userSexo = "";
                if(name.getText()!= null){
                    userName = name.getText().toString();
                }
                if(userName.equals("")){
                    Toast.makeText(MainActivity.this, "Insira o seu nome", Toast.LENGTH_LONG).show();
                    return;
                }
                if(tele.getText()!= null){
                    usertele = tele.getText().toString();
                }
                if(usertele.equals("")){
                    Toast.makeText(MainActivity.this, "Insira o seu numero", Toast.LENGTH_LONG).show();
                    return;
                }

                if(mora.getText()!= null){
                    userMorada = mora.getText().toString();
                }
                if(userMorada.equals("")){
                    Toast.makeText(MainActivity.this, "Insira a sua morada", Toast.LENGTH_LONG).show();
                    return;
                }

                if(idad.getText()!= null){
                    userIdade = idad.getText().toString();
                }
                if(userIdade.equals("")){
                    Toast.makeText(MainActivity.this, "Insira a sua idade", Toast.LENGTH_LONG).show();
                    return;
                }

                if(sex.getText()!= null){
                    userSexo = sex.getText().toString();
                }
                if(userSexo.equals("")){
                    Toast.makeText(MainActivity.this, "Insira o seu sexo", Toast.LENGTH_LONG).show();
                    return;
                }

                handler.gravarAluno(userName, usertele, userMorada, userIdade, userSexo);


                addALuno(userName, usertele, userMorada, userIdade, userSexo);
            }
        });


    }

    public void addALuno(String userName, String userTele, String userMorada, String userIdade, String userSexo){

        Aluno obj = new Aluno();
        obj.setNome(userName);
        obj.setTelefone(userTele);
        obj.setMorada(userMorada);
        obj.setIdade(userIdade);
        obj.setSexo(userSexo);

        alunoList.add(obj);

        holdAndAdaptALunos = new HoldAndAdaptALunos(alunoList, this);
        recyclerView.setAdapter(holdAndAdaptALunos);
    }
}