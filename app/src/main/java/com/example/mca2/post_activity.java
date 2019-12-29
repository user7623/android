package com.example.mca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mca2.Models.Comment;
import com.example.mca2.Models.Post;
import com.example.mca2.Service.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class post_activity extends AppCompatActivity {

    List<Post> postovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_activity);

        final EditText user = (EditText) findViewById(R.id.username_name);
        final EditText descrip = (EditText) findViewById(R.id.description);
        final ImageView postImage = (ImageView) findViewById(R.id.new_post_image);
        Button postiraj = (Button)findViewById(R.id.postiraj);

        postiraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Post postModelRequest = new Post(user.toString(), 0);
                postModelRequest.setPhoto(postImage.toString());
                postModelRequest.setDescription(descrip.toString());

                PostService.initalizeRetrofit();

                Call<Post> getPostsModel = PostService._postService.createPost(postModelRequest);

                getPostsModel.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Post postModelResponse = response.body();

                        if(!response.isSuccessful()){
                            user.setText("Code: " + response.code());
                            return;
                        }
                        Post Post = response.body();
                            String uName = Post.getUserName();
                            int uLikes = Post.getLikes();
                            String uPhoto = Post.getPhoto();
                            String uId = Post.getId();
                            String uProfilePicture = Post.getProfilePicture();
                            List<Comment> uComments = Post.getComments();

                            Post pomosen = new Post(uName, uLikes);
                            pomosen.setId(uId);
                            pomosen.setProfilePicture(uProfilePicture);
                            pomosen.setComments(uComments);
                            pomosen.setPhoto(uPhoto);

                            postovi.add(pomosen);


                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        user.setText(t.getMessage());
                    }
                });

            }
        });
        Intent vratiVoMain = new Intent(post_activity.this, MainActivity.class);
        startActivity(vratiVoMain);
    }
}
