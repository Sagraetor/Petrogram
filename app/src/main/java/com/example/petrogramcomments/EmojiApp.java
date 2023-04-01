package com.example.petrogramcomments;

import android.app.Application;

import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;

public class EmojiApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //install emoji manager
        EmojiManager.install(new GoogleEmojiProvider());
    }
}
