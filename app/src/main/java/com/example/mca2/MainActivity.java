package com.example.mca2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mca2.Models.Comment;
import com.example.mca2.Models.Post;
import com.example.mca2.Models.User;
import com.example.mca2.Service.IGetService;
import com.example.mca2.Service.IPostService;
import com.example.mca2.Service.PostService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private IGetService IGetService;
    RecyclerView mRecyclerView;
    MainAdapter mAdapter;
    User user;
    Post post;
    ArrayList<Post> listOfPosts;
    List<Post> postovi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_view_list);
        MainAdapter adapter = new MainAdapter(postovi);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TextView naslovNaPost = (TextView) findViewById(R.id.name_name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://5ddfd7adbb46ce001434bca8.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        IGetService = retrofit.create(IGetService.class);

        Call<List<Post>> call = IGetService.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    naslovNaPost.setText("Code: " + response.code());
                    return;
                }
                List<Post> Postovi = response.body();
                for(Post post : Postovi){
                    String uName = post.getUserName();
                    int uLikes = post.getLikes();
                    String uPhoto = post.getPhoto();
                    String uId = post.getId();
                    String uProfilePicture = post.getProfilePicture();
                    List<Comment> uComments = post.getComments();

                    Post pomosen = new Post(uName, uLikes);
                    pomosen.setId(uId);
                    pomosen.setProfilePicture(uProfilePicture);
                    pomosen.setComments(uComments);
                    pomosen.setPhoto(uPhoto);

                    postovi.add(pomosen);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                naslovNaPost.setText(t.getMessage());
            }
        });

        Button commentBtn = (Button) findViewById(R.id.button_comment_name);
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getComments();
            }
        });

        Button postBtn = (Button) findViewById(R.id.post_button);
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dodadiPostIntent = new Intent(MainActivity.this , post_activity.class);
                startActivity(dodadiPostIntent);

            }
        });

        final ImageView postImage = (ImageView) findViewById(R.id.post_image);
        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postId = postImage.getId();
                Intent detailsIntent = new Intent(MainActivity.this, DetailsActivity.class);
                detailsIntent.putExtra("postId", postId);
                startActivity(detailsIntent);
            }
        });

    }
    private void getComments()
    {
        final TextView naslovNaPost = (TextView) findViewById(R.id.name_name);
        Call<List<Comment>> call = IGetService.getComments();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()){
                    naslovNaPost.setText("Code: " + response.code());
                    return;
                }
                List<Comment> comments = response.body();
                for(Comment comment : comments){
                    String content = "";
                    content += "ID: " + comment.getId() + "/n";
                    content += "Comment: " + comment.getComment() + "/n";
                    content += "User Name: " + comment.getUserName() + "/n/n";

                    naslovNaPost.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });


    }
}
