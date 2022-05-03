package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Interface.PhotosDAO;
import dataBase.appDataBase;
import Beans.Photos;
import Interface.PlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText txtCod;
    TextView txtTexto;
    Button btnConsultar, btnAlmacenar,btnListar;
    Photos photo;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCod=findViewById(R.id.txtCod);
        txtTexto=findViewById(R.id.txtContenido);
        btnListar=findViewById(R.id.btnMostrar);
        btnAlmacenar=findViewById(R.id.btnAlmacenar);
        btnConsultar=findViewById(R.id.btnConsultar);

        appDataBase db=appDataBase.getInstance(this.getApplicationContext());
        PhotosDAO dao=db.photosDAO();

        btnAlmacenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.insert(photo);
                txtCod.setText(null);
                txtTexto.setText(null);
                txtCod.requestFocus();
                Toast.makeText(getApplicationContext(),
                        "Usuario Almacenado", Toast.LENGTH_SHORT).show();
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=Integer.parseInt(txtCod.getText().toString());
                getPhotos();
            }
        });
    }
    private void getPhotos(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceHolderApi placeholder=retrofit.create(PlaceHolderApi.class);

        Call<Photos> inter=placeholder.getPhoto(id);

        inter.enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {

                if(!response.isSuccessful()){
                    txtTexto.setText("Codigo de error: "+response.code());
                }
                photo=response.body();
                String texto="";
                texto+="Id: "+photo.getId()+"\n";
                texto+="Title: "+photo.getTitle()+"\n";
                txtTexto.setText(texto);

            }

            @Override
            public void onFailure(Call<Photos> call, Throwable t) {

            }
        });
    }
}