package com.example.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView mtv;
Button t_button,c_button;
int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtv=(TextView)findViewById(R.id.txtview);
        t_button=(Button)findViewById(R.id.t_button);
        c_button=(Button)findViewById(R.id.c_button);
        if(savedInstanceState!=null && savedInstanceState.containsKey("key_name")){
            k=savedInstanceState.getInt("key_name");
            mtv.setText(String.valueOf(k));
        }
        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome to Android App Development", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Count:"+k,Toast.LENGTH_SHORT).show();
            }
        });
        c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k++;
                mtv.setText(String.valueOf(k));
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key_name",k);
    }
}