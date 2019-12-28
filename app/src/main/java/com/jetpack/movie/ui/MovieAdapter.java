package com.jetpack.movie.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jetpack.movie.R;
import com.jetpack.movie.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final Activity activity;
    private List<MovieModel> listMovie = new ArrayList<>();

    MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieModel> getListMovie() {
        return listMovie;
    }

    void setList(List<MovieModel> list) {
        if (list == null) return;
        this.listMovie.clear();
        this.listMovie.addAll(list);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getListMovie().get(position).getName());
        holder.tvRating.setText(String.valueOf(getListMovie().get(position).getRating()));
        holder.tvLanguage.setText("Language : " + getListMovie().get(position).getLanguage());
        holder.tvReleaseDate.setText("Release date : " + getListMovie().get(position).getReleaseDate());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra(DetailActivity.ID_DATA, getListMovie().get(position).getMovieId());
            intent.putExtra(DetailActivity.TAB_PAGE, "0");
            activity.startActivity(intent);
        });

        Glide.with(holder.itemView.getContext())
                .load(getListMovie().get(position).getPoster())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvRating, tvLanguage, tvReleaseDate;
        final ImageView ivPoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvLanguage = itemView.findViewById(R.id.tvLanguage);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }
    }
}
