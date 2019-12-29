package com.example.mca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mca2.Models.Post;

import java.lang.reflect.Field;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView userName = (TextView) findViewById(R.id.details_heading_text_user_name);
        TextView detailsText = (TextView) findViewById(R.id.details_text);
        Button backBtn = (Button) findViewById(R.id.back_button);

        Bundle extras = getIntent().getExtras();
        int postId = extras.getInt("postId");

        String postID = postId + "";
        //getResources().getIdentifier(postID, Post, )

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
