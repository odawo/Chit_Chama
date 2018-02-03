package com.example.vanessa.mychama;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyChamas extends AppCompatActivity {

//    private SearchAdapter searchAdapter;

    RecyclerView recyclerView;

    ListView listView;
    ArrayAdapter<String> searchchamaAdapter; //adapter
    public  final static  String CHAMA_CHOICE = "CHAMA_CHOICE";
    public static final int REQUEST_RESPONSE = 1; //chnge from pub fin to fin only

    //implement searchview and recyclerview
    //finish up on the alert dialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_chamas);

        listView = findViewById(R.id.list);

        ArrayList<String> arrayDisease = new ArrayList<>();

        //change the array to pull that data from database into listview
//        for now create array string for adapter in th strings.xml
        arrayDisease.addAll(Arrays.asList(getResources().getStringArray(R.array.array_chamas_from_strings_change_later)));
        searchchamaAdapter = new ArrayAdapter<>(MyChamas.this, android.R.layout.simple_list_item_1, arrayDisease);
        listView.setAdapter(searchchamaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemchoice = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), itemchoice + " selected", Toast.LENGTH_SHORT).show();

//                Bundle bundle = new Bundle();
//                bundle.putString(CHAMA_CHOICE, searchchamaAdapter.getItem(position).toString());
////                joinChamaDialog2(bundle, REQUEST_RESPONSE);
//
//                Intent intent = new Intent(getBaseContext(), joinChamaDialog2());
//                intent.putExtra(CHAMA_CHOICE, searchchamaAdapter.getItem(position));
//                startActivityForResult(intent, REQUEST_RESPONSE);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a new chama", Snackbar.LENGTH_LONG).show();
                newChamaDialog();
            }
        });
    }

//    save the dialog data to the database

    private void joiChamaDialog2(){}

    private void joinChamaDialog2(Bundle bundle, final int requestResponse) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.join_chama, null);
        builder.setView(view);

        TextView chamaname = findViewById(R.id.choice);
        Spinner spinnerrole = findViewById(R.id.role);

//        spinner start
        List<String> roles = new ArrayList<String>();
        roles.add("Vice");
        roles.add("Treasurer");
        roles.add("Secretary");
        roles.add("Member");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roles);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerrole.setAdapter(arrayAdapter);

        spinnerrole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
//                pass data to home page

//                String itemchoice = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(), itemchoice + " selected", Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(getBaseContext(), Home.class);
//                intent.putExtra("choice", CHAMA_CHOICE);
//                intent.putExtra(CHAMA_CHOICE, arrayAdapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); //end of spinner

        builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                save to db..
//                pass to home - chama grp section
//                startActivityForResult(getIntent(), requestResponse);
                startActivity(new Intent(MyChamas.this,Home.class ));
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void newChamaDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.add_chama, null);
        builder.setView(view);

        EditText name = findViewById(R.id.name);
        EditText date = findViewById(R.id.date);
        final Spinner type = findViewById(R.id.type);

//        list in spinner
        List<String> chamatype = new ArrayList<String>();
        chamatype.add("welfare");
        chamatype.add("sacco");
        chamatype.add("self-help");

        /**
         * SPINNER START
         * **/

//        adapter for spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chamatype);
//        adapter design
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        attach adapter to spinner
        type.setAdapter(arrayAdapter);

//        on selecting spinner item(chama type)
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String itemchoice = type.getItemAtPosition(position).toString();
                String itemchoice = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), itemchoice + " selected", Toast.LENGTH_SHORT).show();
                joinChamaDialog();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "choose a chama type", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * SPINNER END
         * **/


        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                save data to db

                startActivity(new Intent(MyChamas.this, Home.class));
                finish();
            }
        });

        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(MyChamas.this, MyChamas.class));
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void joinChamaDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.join_chama, null);
        builder.setView(view);

        TextView chamaname = findViewById(R.id.choice);
        Spinner spinnerrole = findViewById(R.id.role);

//        spinner start
        List<String> roles = new ArrayList<String>();
        roles.add("Vice");
        roles.add("Treasurer");
        roles.add("Secretary");
        roles.add("Member");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roles);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerrole.setAdapter(arrayAdapter);

        spinnerrole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                pass data to home page

                String itemchoice = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), itemchoice + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); //end of spinner

        builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                save to db..
//                pass to home - chama grp section
                startActivity(new Intent(MyChamas.this,Home.class ));
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
