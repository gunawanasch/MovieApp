package com.jetpack.movie.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.movie.R;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.MovieViewModel;

import java.util.List;

public class MovieFragment extends Fragment {
    private RecyclerView rv;
    private MovieAdapter adapter;
    private MovieViewModel viewModel;
    private List<MovieModel> listMovie;

    public MovieFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
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
            viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
            listMovie = viewModel.getMovie();
            adapter = new MovieAdapter(getActivity());
            adapter.setList(listMovie);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            rv.setHasFixedSize(true);
            rv.setAdapter(adapter);
        }
    }
}
