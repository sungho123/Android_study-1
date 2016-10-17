package com.example.quickcoing01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    CaCul caculation = new CaCul();
    String numbers = new String();

    public void miniClicked(View view) {
        EditText editT = (EditText)findViewById(R.id.editText);
        //numbers=String.valueOf(((TextView)findViewById(R.id.myValue)).getText());
        numbers = editT.getText().toString();
        ((TextView) findViewById(R.id.result)).setText(caculation.minimum(numbers));
    }

    public void averClicked(View view) {
        EditText editT = (EditText)findViewById(R.id.editText);
        numbers = editT.getText().toString();
        //numbers = String.valueOf(((TextView)findViewById(R.id.myValue)).getText());
        ((TextView) findViewById(R.id.result)).setText(caculation.average(numbers));
    }
}
