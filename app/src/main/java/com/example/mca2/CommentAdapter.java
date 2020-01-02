package com.example.mca2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mca2.Models.Comment;
import com.example.mca2.Models.Post;
import com.example.mca2.Models.commentViewHolder; //nz zs ne raboti -.-
import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.commentViewHolder>{

    private Context context;

    @NonNull
    @Override
    public CommentAdapter.commentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View commentView = inflater.inflate(R.layout.comment, parent, false);
        commentViewHolder commentviewHolder = new commentViewHolder(commentView);

        return commentviewHolder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.commentViewHolder commentviewHolder, int position) {

        Comment comment = mComment.get(position);
        TextView userName = commentviewHolder.userName;
        userName.setText(comment.getUserName());
        TextView commenttext = commentviewHolder.commenttext;
        commenttext.setText(comment.getComment());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class commentViewHolder extends RecyclerView.ViewHolder{

        public TextView userName;
        public TextView commenttext;

        public commentViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.comment_username);
            commenttext = (TextView) itemView.findViewById(R.id.comment_comment);
        }
    }

    private List<Comment> mComment;
    public CommentAdapter(@NonNull List<Comment> comments){
        mComment = comments;
    }
}
