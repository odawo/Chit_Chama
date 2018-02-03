package com.example.vanessa.mychama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Accounts extends AppCompatActivity {

    ImageButton profileimg;
    TextView individual, group, acc, statement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        profileimg = findViewById(R.id.profbtn);
        individual = findViewById(R.id.individual);
        group = findViewById(R.id.group);
        acc = findViewById(R.id.acc);
        statement = findViewById(R.id.statement);

        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Accounts.this, Profile.class));
            }
        });

    }
}
