package com.example.petrogramcomments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
// import emoji library
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {
    // initialize variables
    ImageView emoji, send;
    EditText comment;
    LinearLayout cmtSections;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variable
        emoji = findViewById(R.id.em1);
        send = findViewById(R.id.send);
        comment = findViewById(R.id.leavecomment);
        cmtSections = findViewById(R.id.cmtSection);

        // initialize emoji popup
        EmojiPopup popup = EmojiPopup.Builder.fromRootView(
                findViewById(R.id.root_view)
        ).build(comment);

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.toggle();
            } // toggle between text and emoji
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inflate emoji text view layout
                EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater
                        .from(v.getContext())
                        .inflate(R.layout.emoji_text_view, cmtSections, false);
                emojiTextView.setText(comment.getText().toString());

                cmtSections.addView(emojiTextView);
                comment.getText().clear();
            }
        });
    }
}