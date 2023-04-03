package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomepageActivity extends AppCompatActivity {

    Button add;
    Button remove;
    TextView gossip;
    TextView food;
    TextView ride;
    TextView events;
    TextView movie;
    TextView books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        add = findViewById(R.id.addTopic);
        remove = findViewById(R.id.minusTopic);
        gossip = findViewById(R.id.gossip);
        food = findViewById(R.id.food);
        ride = findViewById(R.id.ride);
        events = findViewById(R.id.events);
        movie = findViewById(R.id.movie);
        books = findViewById(R.id.books);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomepageActivity.this, "TOPIC REMOVED!", Toast.LENGTH_SHORT).show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomepageActivity.this, "TOPIC ADDED!", Toast.LENGTH_SHORT).show();
            }
        });

        gossip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });

        ride.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });

        movie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });

        books.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });

    }
}