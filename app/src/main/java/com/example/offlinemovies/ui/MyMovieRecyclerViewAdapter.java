package com.example.offlinemovies.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.offlinemovies.data.local.entity.MovieEntity;
import com.example.offlinemovies.data.remote.ApiConstants;
import com.example.offlinemovies.databinding.FragmentItemBinding;

import java.util.List;

public class MyMovieRecyclerViewAdapter extends RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder> {

    private final List<MovieEntity> mValues;
    Context ctx;

    public MyMovieRecyclerViewAdapter(Context context, List<MovieEntity> items) {
        mValues = items;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Glide.with(ctx)
                .load(ApiConstants.IMAGE_API_PREFIX + holder.mItem.getPosterPath())
                .into(holder.imageViewCover);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageViewCover;
        public MovieEntity mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            imageViewCover = binding.imageViewCover;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}