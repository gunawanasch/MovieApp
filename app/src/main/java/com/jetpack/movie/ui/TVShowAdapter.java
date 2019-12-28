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
import com.jetpack.movie.model.TVShowModel;

import java.util.ArrayList;
import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowHolder> {
    private final Activity activity;
    private List<TVShowModel> listTVShow = new ArrayList<>();

    TVShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TVShowModel> getListTVShow() {
        return listTVShow;
    }

    void setList(List<TVShowModel> list) {
        if (list == null) return;
        this.listTVShow.clear();
        this.listTVShow.addAll(list);
    }

    @NonNull
    @Override
    public TVShowAdapter.TVShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tv_show, parent, false);
        return new TVShowAdapter.TVShowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TVShowAdapter.TVShowHolder holder, int position) {
        holder.tvTitle.setText(getListTVShow().get(position).getName());
        holder.tvRating.setText(String.valueOf(getListTVShow().get(position).getRating()));
        holder.tvReleaseDate.setText("Release Date : " + String.valueOf(getListTVShow().get(position).getReleaseDate()));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra(DetailActivity.ID_DATA, getListTVShow().get(position).getTvId());
            intent.putExtra(DetailActivity.TAB_PAGE, "1");
            activity.startActivity(intent);
        });

        Glide.with(holder.itemView.getContext())
                .load(getListTVShow().get(position).getPoster())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return getListTVShow().size();
    }

    class TVShowHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvRating, tvReleaseDate;
        final ImageView ivPoster;

        TVShowHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvRating = view.findViewById(R.id.tvRating);
            tvReleaseDate = view.findViewById(R.id.tvReleaseDate);
            ivPoster = view.findViewById(R.id.ivPoster);
        }
    }
}
