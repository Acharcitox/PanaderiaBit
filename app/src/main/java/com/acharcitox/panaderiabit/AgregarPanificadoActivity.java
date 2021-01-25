package com.acharcitox.panaderiabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarPanificadoActivity extends AppCompatActivity {
    public static final String EXTRA_MSG = "com.acharcitox.panaderiabit.MSG_GUARDAR";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_panificado);

        editText = findViewById(R.id.textViewIngresarNombre);

        final Button btnAgregar = findViewById(R.id.btnGuardar);
        btnAgregar.setOnClickListener(view -> {
                Intent respueta = new Intent();
                if (TextUtils.isEmpty(editText.getText())) {
                    setResult(RESULT_CANCELED, respueta);
                } else {
                    String panificado = editText.getText().toString();
                    respueta.putExtra(EXTRA_MSG, panificado);
                    AgregarPanificadoActivity.this.setResult(RESULT_OK, respueta);
                }
                finish();
        });
    }
}