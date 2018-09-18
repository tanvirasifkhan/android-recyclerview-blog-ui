package com.example.asifkhan.androidrecyclerviewblog.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.asifkhan.androidrecyclerviewblog.R;
import com.example.asifkhan.androidrecyclerviewblog.models.Blog;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.DataHolder> {
    private ArrayList<Blog> blogs;
    private Context context;
    private static int CROSS_FADE_DURATION=1000;

    public BlogAdapter(ArrayList<Blog> blogs, Context context) {
        this.blogs = blogs;
        this.context = context;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_blog_layout,parent,false);
        return new DataHolder(view,context,blogs);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        Blog blog=blogs.get(position);
        holder.title.setText(blog.getTitle());
        holder.author.setText("by : "+blog.getAuthor());
        holder.likes.setText(String.valueOf(blog.getLikes()));
        holder.comments.setText(String.valueOf(blog.getComments()));
        holder.shares.setText(String.valueOf(blog.getShares()));
        Glide.with(context).load(blog.getPhoto()).crossFade(CROSS_FADE_DURATION).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.blog_photo);
    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }

    class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView blog_photo;
        TextView title,author,likes,comments,shares;
        Context context;
        ArrayList<Blog> blogs;
        public DataHolder(View itemView,Context context,ArrayList<Blog> blogs) {
            super(itemView);
            this.context=context;
            this.blogs=blogs;
            itemView.setOnClickListener(this);
            blog_photo=(ImageView)itemView.findViewById(R.id.blog_photo);
            title=(TextView)itemView.findViewById(R.id.blog_title);
            author=(TextView)itemView.findViewById(R.id.blog_author);
            likes=(TextView)itemView.findViewById(R.id.likes);
            comments=(TextView)itemView.findViewById(R.id.comments);
            shares=(TextView)itemView.findViewById(R.id.shares);
        }

        @Override
        public void onClick(View view) {
            Blog blog=this.blogs.get(getAdapterPosition());
            Toast.makeText(context,blog.getTitle() , Toast.LENGTH_SHORT).show();
        }
    }
}
