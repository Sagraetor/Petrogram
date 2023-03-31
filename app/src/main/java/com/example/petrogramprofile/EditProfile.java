package com.example.petrogramprofile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {

    private EditText textUsername1, textEmail1, textPassword1, textPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_main);

        //declare to save value of edit text into text value
        Button btnSave = findViewById(R.id.buttonSave);
        textUsername1 = findViewById(R.id.textUsername1);
        textEmail1 = findViewById(R.id.textEmail1);
        textPassword1 = findViewById(R.id.textPassword1);
        textPassword2 = findViewById(R.id.textPassword2);

        btnSave.setOnClickListener(v -> {
            String username = textUsername1.getText().toString();
            String email = textEmail1.getText().toString();
            String password = textPassword1.getText().toString();
            String confirmpassword = textPassword2.getText().toString();

            if(confirmpassword == password){
                Intent intent = new Intent();
                intent.putExtra("USERNAME", username);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);

                setResult(RESULT_OK, intent);
                finish();
            } else {
                //show error if confirm password does not match with password
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error");
                builder.setMessage("Confirm Password does not match with Password");
                builder.show();
            }

        });
    }
}