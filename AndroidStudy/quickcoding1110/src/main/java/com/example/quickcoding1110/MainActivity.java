package com.example.quickcoding1110;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String numbers = new String();
    String inputText = new String();
    List listA = new ArrayList();
    List listB = new ArrayList();
    public void inputButtonClicked(View view){
        EditText editT = (EditText)findViewById(R.id.editText);
        inputText = editT.getText().toString();
        try{
            int a = Integer.parseInt(inputText);
            listA.add(a);
        }catch (NumberFormatException nfe){
            listB.add(inputText);
        }
        ((EditText) findViewById(R.id.editText)).setText("");
    }
    public void finishButtonClicked(View view){

        String IntView = new String();
        for(Object object : listA) {
            String element =  object.toString();
            IntView+=element;
            IntView+=" ";
        }
        String StrView = new String();
        for(Object object : listB) {
            String element = (String) object;
            StrView+=element;
            StrView+=" ";
        }
        ((TextView) findViewById(R.id.StringView)).setText(StrView);
        ((TextView) findViewById(R.id.IntegerView)).setText(IntView);
        listA.clear();
        listB.clear();
    }
}
