package com.nerds.clout.gen.chexmate.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.nerds.clout.gen.chexmate.R;

public class TeaFragment extends Fragment {

    private RecyclerView teaRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean isLoading = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tea, container, false);
        initializeViews(view);
        setupTeaFeed();
        return view;
    }

    private void initializeViews(View view) {
        // Initialize RecyclerView
        teaRecyclerView = view.findViewById(R.id.teaRecyclerView);
        teaRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        teaRecyclerView.setHasFixedSize(true);

        // Initialize SwipeRefreshLayout
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this::refreshTea);
        swipeRefreshLayout.setColorSchemeResources(R.color.ghibli_primary);
    }

    private void setupTeaFeed() {
        // TODO: Initialize and set adapter
        // For now, we'll just show a toast
        Toast.makeText(requireContext(), "Loading tea feed...", Toast.LENGTH_SHORT).show();
    }

    private void refreshTea() {
        if (isLoading) {
            swipeRefreshLayout.setRefreshing(false);
            return;
        }

        isLoading = true;
        // TODO: Implement refresh logic
        // For now, simulate a delay
        teaRecyclerView.postDelayed(() -> {
            isLoading = false;
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(requireContext(), "Feed refreshed!", Toast.LENGTH_SHORT).show();
        }, 1500);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up any pending callbacks
        if (teaRecyclerView != null) {
            teaRecyclerView.removeCallbacks(null);
        }
    }
} 