package com.example.mca2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mca2.Models.Comment;

import java.util.List;

public class CommentActivity extends AppCompatActivity {

    List<Comment> komentari;
    RecyclerView commentRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentRV = (RecyclerView) findViewById(R.id.comments_list);
        CommentAdapter commentAdapter = new CommentAdapter(komentari);
        commentRV.setAdapter(commentAdapter);
        commentRV.setLayoutManager(new LinearLayoutManager(this));
    }
}
