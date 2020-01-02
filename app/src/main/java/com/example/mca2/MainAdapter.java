package com.example.mca2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mca2.Models.ViewHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mca2.Models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<Post> listOfPosts;
    private int post;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.post, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder viewHolder, int position) {

        Post post = mPost.get(position);

        TextView name = viewHolder.name;
        name.setText(post.getUserName());
        TextView numberLikes = viewHolder.numberLikes;
        numberLikes.setText(post.getLikes());
        ImageView postImage = viewHolder.postImage;
        Picasso.get().load(viewHolder.postImage.toString()).into(postImage);/*najednostaven nacin so
        TextView descr = viewHolder.description;                           Picasso(da kako slikarot)
                                                                            */


    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView numberLikes;
        public ImageView postImage;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_name);
            numberLikes = (TextView) itemView.findViewById(R.id.name_likes);
            postImage = (ImageView) itemView.findViewById(R.id.post_image);
            description = (TextView) itemView.findViewById(R.id.text_view_1_name_description);
        }
    }
    private List<Post> mPost;
    public MainAdapter(@NonNull List<Post> posts){
        mPost = posts;
    }

}

