package com.example.importsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText mname;
    public Button mquery_button;
    public TextView result_adress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mname = findViewById(R.id.name);
        mquery_button = findViewById(R.id.query_button);
        result_adress = findViewById(R.id.resulted);

        mquery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();
                String n= mname.getText().toString();
                if(n.isEmpty()) {

                    Toast.makeText(MainActivity.this, "No Data entered", Toast.LENGTH_SHORT).show();
                }
                else {
                    String adress = databaseAccess.getAdress(n);


                    result_adress.setText(adress);
                    databaseAccess.close();
                }
            }
        });
    }
}