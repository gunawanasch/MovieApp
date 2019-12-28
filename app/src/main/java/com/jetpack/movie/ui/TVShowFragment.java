package com.jetpack.movie.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.movie.R;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.model.TVShowViewModel;

import java.util.List;

public class TVShowFragment extends Fragment {
    private RecyclerView rv;
    private TVShowAdapter adapter;
    private TVShowViewModel viewModel;
    private List<TVShowModel> listTVShow;

    public TVShowFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(this).get(TVShowViewModel.class);
            listTVShow = viewModel.getTVShow();
            adapter = new TVShowAdapter(getActivity());
            adapter.setList(listTVShow);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
            rv.setLayoutManager(gridLayoutManager);
            rv.setAdapter(adapter);
        }
    }
}
