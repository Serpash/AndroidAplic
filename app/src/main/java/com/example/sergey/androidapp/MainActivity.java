package com.example.sergey.androidapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) findViewById(R.id.isPasswordValid);
        email = (EditText) findViewById(R.id.isEmailCorrect);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Registr(View view) {
        if (!email.getText().toString().matches("(\\w|\\d)+@gmail") || password.length() < 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error")
                    .setMessage("Email need to consist of " + " @gmail " + " characters  and password min 3 simbols")
                    .setCancelable(false)
                    .setNegativeButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            Intent intent = new Intent(this, secondActivity.class);
            startActivity(intent);
        }


    }
}

