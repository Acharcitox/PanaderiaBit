package com.acharcitox.panaderiabit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.acharcitox.panaderiabit.entities.Panificado;
import com.acharcitox.panaderiabit.models.PanificadoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PanificadoViewModel panificadoViewModel;
    public static final int NEW_PANIFICADO_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPanificados);
        final PanificadoListAdapter adapter = new PanificadoListAdapter(new PanificadoListAdapter.PanificadoDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        panificadoViewModel = new ViewModelProvider(this, new PanificadoFactory(getApplication())).get(PanificadoViewModel.class);

        panificadoViewModel.getPanificados().observe(this, panificados ->  {
                adapter.submitList(panificados);
        });

        FloatingActionButton fab = findViewById(R.id.btnAgregar);
        fab.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, AgregarPanificadoActivity.class);

                startActivityForResult(intent, NEW_PANIFICADO_REQ_CODE);
        });

        }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PANIFICADO_REQ_CODE && resultCode == RESULT_OK) {
            Panificado panificado = new Panificado();
            panificado.setNombre(data.getStringExtra(AgregarPanificadoActivity.EXTRA_MSG));
            panificadoViewModel.insert(panificado);
        } else {
            Toast.makeText(getApplicationContext(), R.string.no_guardado, Toast.LENGTH_LONG).show();
        }
    }
}
