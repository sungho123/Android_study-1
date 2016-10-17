package com.example.quickcoding02;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Random number = new Random();
    String inputText = new String();
    int i = 0;
    int max = 200;
    int min = 1;
    int ans = 0;

    public void biggerClicked(View view) {
        min = ans;
        Random numB = new Random();
        ans = numB.nextInt(max-min)+min+1;
        ((TextView) findViewById(R.id.result)).setText("Your Number is "+ans);
        i++;
    }

    public void smallerClicked(View view) {
        max = ans;
        Random numS = new Random();
        ans = numS.nextInt(max-min)+min+1;
        ((TextView) findViewById(R.id.result)).setText("Your Number is "+ans);
        i++;
    }

    public void sendClicked(View view) {
        EditText editT = (EditText)findViewById(R.id.editText);
        max = 200;
        min = 1;
        ans = number.nextInt(max+1)+min;
        i=0;
        ((TextView) findViewById(R.id.result)).setText("Your Number is "+ans);
        inputText = editT.getText().toString();

    }
    public void bingoClicked(View view) {
        ((TextView) findViewById(R.id.result)).setText("Bingo! ("+i+") : " + ans);
    }
}
