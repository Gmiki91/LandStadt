package com.example.landstadt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class GameActivity extends Activity{
    private EditText orszag;
    private EditText varos;
    private EditText fiu;
    private EditText lany;
    private char letter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        letter = getIntent().getExtras().getChar("letter");
        orszag = findViewById(R.id.editOrszag);
        varos = findViewById(R.id.editVaros);
//        fiu = findViewById(R.id.editFiu);
//        lany = findViewById(R.id.editLany);
        System.out.println(letter);
//        if (Character.toUpperCase(orszag.getText().charAt(0)) == letter) {
    }



}
