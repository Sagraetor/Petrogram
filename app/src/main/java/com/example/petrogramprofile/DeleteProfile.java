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
        //display confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Profile");
        builder.setMessage("Are you sure you want to delete your profile?");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            //if user choose yes, go to delete profile function
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteProfile();
            }
        });
        //if user choose no, close confirmation dialog
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void deleteProfile() {
        // remove the user's profile information from the database
        // navigate back to the previous activity (login page)
        ((Activity)context).onBackPressed();
    }
}
