package com.example.aws.amanda;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aws.amanda.DataContext.Dao.CategoriasCuentasDao;
import com.example.aws.amanda.DataContext.Entities.CategoriasCuentas;
import com.example.aws.amanda.DataContext.ViewModel.CategoriasCuentasViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CategoriasCuentasViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewModel = ViewModelProviders.of(this).get(CategoriasCuentasViewModel.class);
        viewModel.getAll().observe(this, new Observer<List<CategoriasCuentas>>() {
            @Override
            public void onChanged(@Nullable List<CategoriasCuentas> categoriasCuentas) {

                // todas las categorias seran retornadas en categoriasCuentas
               if(categoriasCuentas.size() != 0){
                   String categoria =  categoriasCuentas.get(0).getName();
               }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            viewModel.insert(new CategoriasCuentas("Prueba"));


                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
