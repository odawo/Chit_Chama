package com.example.vanessa.mychama;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Loans extends AppCompatActivity {

    TextView newloan, arrears, requests;
    public static String a, dt, rsn, rt, rtnc;
    public final int REQUEST_RESPONSE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loans);

        newloan = findViewById(R.id.newloan);
        arrears = findViewById(R.id.arrears);
        requests = findViewById(R.id.requests);

        newloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newLoanDialog();
            }
        });

/**
 *
 * drop down for arrears..  with  a table and all the needed data.
 * using arrears..
 * do it real quick
 * */

        requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loans.this, LoanRequests.class));
            }
        });

    }

    private void newLoanDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.loan_application, null);
        builder.setView(view);

        /*
        * incomplete dialog.. check MyChamas page too
        *
        * **/


        final EditText amount = findViewById(R.id.amount);
        EditText date = findViewById(R.id.date);
        EditText reason = findViewById(R.id.reason);
        TextView rate = findViewById(R.id.rate);
        TextView returncash = findViewById(R.id.returncash);

        builder.setPositiveButton("apply", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(Loans.this, LoanRequests.class);
                intent.putExtra("amount", a);
                intent.putExtra("date", dt);
                intent.putExtra("reason", rsn);
                intent.putExtra("returncash", rtnc);
                startActivityForResult(intent, REQUEST_RESPONSE);
//                pass to loan requests recycler view
//                continue with the data passing code
//                fdbbgbdg
//                bdbrt
            }
        });

        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Loans.this, Loans.class));
            }
        });

        AlertDialog dialog = builder.create();
        builder.show();
    }
}
