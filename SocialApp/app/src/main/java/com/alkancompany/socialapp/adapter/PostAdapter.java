package com.alkancompany.socialapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alkancompany.socialapp.databinding.RecyclerRowBinding;
import com.alkancompany.socialapp.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder>{


    private ArrayList<Post>PostArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        PostArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.recyclerRowBinding.recyclerviewUserEmailText.setText(PostArrayList.get(position).email);
        holder.recyclerRowBinding.recyclerviewCommentText.setText(PostArrayList.get(position).comment);
        Picasso.get().load(PostArrayList.get(position).downloadUrl).into(holder.recyclerRowBinding.recyclerviewImageView);

    }

    @Override
    public int getItemCount() {
        return PostArrayList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;

        public PostHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}
