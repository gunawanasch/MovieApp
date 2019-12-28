package com.jetpack.movie.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.movie.R;
import com.jetpack.movie.model.TVShowViewModel;
import com.jetpack.movie.model.ViewModelFactory;

public class TVShowFragment extends Fragment {
    private ProgressBar pb;
    private RecyclerView rv;

    public TVShowFragment() {}

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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if (activity != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance();
            TVShowViewModel viewModel = ViewModelProviders.of((FragmentActivity) activity, factory).get(TVShowViewModel.class);
            TVShowAdapter adapter = new TVShowAdapter(activity);
            viewModel.getTVShow().observe(this, data -> {
                adapter.setList(data);
                adapter.notifyDataSetChanged();
            });
            pb.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
            rv.setLayoutManager(gridLayoutManager);
            rv.setAdapter(adapter);
        }
    }
}
