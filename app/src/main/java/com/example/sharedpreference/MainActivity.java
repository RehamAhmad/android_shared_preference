package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   EditText nameEt;
   TextView nameTv;
   Button saveBtn;
   Button showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEt = findViewById(R.id.name_et);
        nameTv = findViewById(R.id.name_tv);
        saveBtn = findViewById(R.id.save_btn);
        showBtn = findViewById(R.id.show_btn);


        final SharedPreferences sharedPref = this.getSharedPreferences("pref", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                editor.putString("person_name",name);
                editor.commit();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = sharedPref.getString("person_name","Error getting data from SP");
                nameTv.setText(name);

            }
        });

    }
}