package com.example.ravi.dairy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Button etstart=(Button) findViewById(R.id.startsbtn);

        etstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent=new Intent(Main2Activity.this,MainActivity.class);
                Main2Activity.this.startActivity(startIntent);
            }
        });

    }
}
