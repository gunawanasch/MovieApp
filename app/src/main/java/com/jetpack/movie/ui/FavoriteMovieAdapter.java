package com.jetpack.movie.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jetpack.movie.R;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.utils.ConvertDate;

import java.io.Serializable;

public class FavoriteMovieAdapter extends PagedListAdapter<FavoriteMovieModel, FavoriteMovieAdapter.FavoriteMovieViewHolder> {
    private OnItemClickListener listener;

    protected FavoriteMovieAdapter() {
        super(FAVORITE_MOVIE_DIFF_CALLBACK);
    }

    public interface OnItemClickListener {
        void onDeleteClick(String id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteMovieViewHolder holder, int position) {
        final FavoriteMovieModel movie = getItem(position);
        if (movie != null) {
            holder.tvTitle.setText(movie.getName());
            holder.tvRating.setText(String.valueOf(movie.getRating()));
            holder.tvLanguage.setText("Language : " + movie.getLanguage());
            holder.tvReleaseDate.setText("Release date : " + new ConvertDate().newFormatDate(movie.getReleaseDate()));
            holder.itemView.setOnClickListener(v -> {
                Context context = holder.itemView.getContext();
                Bundle b = new Bundle();
                b.putSerializable(DetailActivity.OBJECT, (Serializable) new MovieModel(movie.getMovieId(), movie.getPoster(), movie.getName(), movie.getReleaseDate(), movie.getLanguage(), movie.getRating(), movie.getOverview()));
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtras(b);
                intent.putExtra(DetailActivity.TAB_PAGE, "0");
                context.startActivity(intent);
            });

            Glide.with(holder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500/"+movie.getPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                    .into(holder.ivPoster);

            holder.rlMore.setOnClickListener(v -> {
                if(listener != null) {
                    if(position != RecyclerView.NO_POSITION) {
                        final Context context = holder.rlMore.getContext();
                        PopupMenu popup = new PopupMenu(context, holder.rlMore);
                        popup.inflate(R.menu.option_menu);
                        popup.setOnMenuItemClickListener(item -> {
                            switch (item.getItemId()) {
                                case R.id.action_delete:
                                    listener.onDeleteClick(movie.getMovieId());
                                    return true;
                                default:
                                    return false;
                            }
                        });
                        popup.show();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public FavoriteMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie, parent, false);
        return new FavoriteMovieViewHolder(view);
    }

    private static DiffUtil.ItemCallback<FavoriteMovieModel> FAVORITE_MOVIE_DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteMovieModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteMovieModel oldItem, @NonNull FavoriteMovieModel newItem) {
                    return oldItem.getMovieId().equals(newItem.getMovieId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteMovieModel oldItem, @NonNull FavoriteMovieModel newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class FavoriteMovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvRating, tvLanguage, tvReleaseDate;
        final ImageView ivPoster;
        final RelativeLayout rlMore;

        FavoriteMovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvLanguage = itemView.findViewById(R.id.tvLanguage);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            rlMore = itemView.findViewById(R.id.rlMore);
        }
    }
}
