package com.jetpack.movie.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.movie.R;
import com.jetpack.movie.model.FavoriteTVShowViewModel;
import com.jetpack.movie.model.ViewModelFactory;

public class FavoriteTVShowFragment extends Fragment {
    private ProgressBar pb;
    private RecyclerView rv;

    public FavoriteTVShowFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pb = view.findViewById(R.id.pb);
        rv = view.findViewById(R.id.rv);
        pb.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if (activity != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
            FavoriteTVShowViewModel viewModel = ViewModelProviders.of((FragmentActivity) activity, factory).get(FavoriteTVShowViewModel.class);
            FavoriteTVShowAdapter adapter = new FavoriteTVShowAdapter();
            viewModel.getFavoriteTVShowAsPaged().observe(this, result -> {
                if (result != null) {
                    switch (result.status) {
                        case LOADING:
                            pb.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            pb.setVisibility(View.GONE);
                            adapter.submitList(result.data);
                            adapter.notifyDataSetChanged();
                            rv.setVisibility(View.VISIBLE);
                            rv.setAdapter(adapter);
                            adapter.setOnItemClickListener(id -> {
                                viewModel.deleteFavoriteTVShow(id);
                                adapter.notifyDataSetChanged();
                            });
                            break;
                        case ERROR:
                            pb.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }
    }

}
