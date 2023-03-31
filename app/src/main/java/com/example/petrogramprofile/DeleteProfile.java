package com.example.petrogramprofile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteProfile {
    private Context context;

    public DeleteProfile(Context context) {
        this.context = context;
    }

    protected void showConfirmationDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Profile");
        builder.setMessage("Are you sure you want to delete your profile?");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteProfile();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void deleteProfile() {
        // remove the user's profile information from wherever it is stored
        // navigate back to the previous activity (login page)
        ((Activity)context).onBackPressed();
    }
}