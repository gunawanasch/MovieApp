package com.jetpack.movie.utils;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskIOThreadExecutor implements Executor {
    private final Executor diskIO;

    DiskIOThreadExecutor() {
        diskIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(@NonNull Runnable command) {
        diskIO.execute(command);
    }
}
