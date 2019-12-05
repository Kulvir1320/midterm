package com.example.a764928_kulvir_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;



public class Main2Activity extends AppCompatActivity {
    EditText dialyRent;
    TextView tagname;
    CheckBox checkBox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dialyRent = findViewById(R.id.dialyRent1);
        tagname = findViewById(R.id.tagName1);
        checkBox1 = findViewById(R.id.check21);


        Intent intent = getIntent();
//
        ArrayList<String> details = (ArrayList<String>) intent.getSerializableExtra("detail");
        dialyRent.setText(String.valueOf(details.get(0)));
        checkBox1.setText(String.valueOf(details.get(1)));

    }
}
