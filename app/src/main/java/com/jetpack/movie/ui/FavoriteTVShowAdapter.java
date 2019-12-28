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
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.utils.ConvertDate;

import java.io.Serializable;

public class FavoriteTVShowAdapter extends PagedListAdapter<FavoriteTVShowModel, FavoriteTVShowAdapter.FavoriteTVShowViewHolder> {
    private OnItemClickListener listener;

    protected FavoriteTVShowAdapter() {
        super(FAVORITE_TV_SHOW_DIFF_CALLBACK);
    }

    public interface OnItemClickListener {
        void onDeleteClick(String id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteTVShowViewHolder holder, int position) {
        final FavoriteTVShowModel tvShow = getItem(position);
        if (tvShow != null) {
            holder.tvTitle.setText(tvShow.getName());
            holder.tvRating.setText(String.valueOf(tvShow.getRating()));
            holder.tvReleaseDate.setText("Release Date : " + new ConvertDate().newFormatDate((tvShow.getReleaseDate())));
            holder.itemView.setOnClickListener(v -> {
                Context context = holder.itemView.getContext();
                Bundle b = new Bundle();
                b.putSerializable(DetailActivity.OBJECT, (Serializable) new TVShowModel(tvShow.getTvId(), tvShow.getPoster(), tvShow.getName(), tvShow.getReleaseDate(), tvShow.getLanguage(), tvShow.getRating(), tvShow.getOverview()));
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtras(b);
                intent.putExtra(DetailActivity.TAB_PAGE, "1");
                context.startActivity(intent);
            });

            Glide.with(holder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500/"+tvShow.getPoster())
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
                                    listener.onDeleteClick(tvShow.getTvId());
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

    private static DiffUtil.ItemCallback<FavoriteTVShowModel> FAVORITE_TV_SHOW_DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteTVShowModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteTVShowModel oldItem, @NonNull FavoriteTVShowModel newItem) {
                    return oldItem.getTvId().equals(newItem.getTvId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteTVShowModel oldItem, @NonNull FavoriteTVShowModel newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public FavoriteTVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tv_show, parent, false);
        return new FavoriteTVShowViewHolder(view);
    }

    class FavoriteTVShowViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvRating, tvReleaseDate;
        final ImageView ivPoster;
        final RelativeLayout rlMore;

        FavoriteTVShowViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvRating = view.findViewById(R.id.tvRating);
            tvReleaseDate = view.findViewById(R.id.tvReleaseDate);
            ivPoster = view.findViewById(R.id.ivPoster);
            rlMore = itemView.findViewById(R.id.rlMore);
        }
    }
}