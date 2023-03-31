package com.example.petrogramprofile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int EDIT_PROFILE_REQUEST_CODE = 1;

    private TextView textUsername, textEmail, textPassword;
    private DeleteProfile deleteProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEdit = findViewById(R.id.buttonEdit);
        Button btnDel = findViewById(R.id.buttonDelete);
        textUsername = findViewById(R.id.textUsername);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);

        deleteProfile = new DeleteProfile(this);

        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditProfile.class);
            startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);
        });

        btnDel.setOnClickListener(v -> {
            deleteProfile.showConfirmationDialog();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK) {
            String username = data.getStringExtra("USERNAME");
            textUsername.setText(username);

            String email = data.getStringExtra("EMAIL");
            textEmail.setText(email);

            String password = data.getStringExtra("PASSWORD");
            textPassword.setText(password);
        }
    }
}