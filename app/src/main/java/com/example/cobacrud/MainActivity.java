package com.example.cobacrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextAddress;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi dari view
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        // setting listener ke button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }

    // method menambahkan mahasiswa (CREATE)
    private void addMahasiswa() {
        final String name = editTextName.getText().toString().trim();
        final String address = editTextAddress.getText().toString().trim();

        class AddMahasiswa extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Menambahkan...",
                        "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {

                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_MHS_NAMA,name);
                params.put(Konfigurasi.KEY_MHS_ALAMAT,address);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);

                return res;
            }
        }
        AddMahasiswa am = new AddMahasiswa();
        am.execute();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonAdd) {

            if (editTextName.getText().toString().isEmpty() ||
                    editTextAddress.getText().toString().isEmpty()) {

                Toast.makeText(getApplicationContext(), "Error! Silahkan masukkan inputan!",
                        Toast.LENGTH_SHORT).show();

            } else {
                addMahasiswa();
            }

        }

        if (v == buttonView) {
            startActivity(new Intent(this, TampilSemuaMahasiswa.class));
        }
    }
}
