package com.hfad.clothstore.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.clothstore.FavoritesDetailActivity;
import com.hfad.clothstore.R;
import com.hfad.clothstore.adapters.CaptionedImagesAdapter;
import com.hfad.clothstore.hardcoded.Cloth;


public class FavoritesFragment extends Fragment {
    CaptionedImagesAdapter adapter;
    RecyclerView clothRecycler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        clothRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_home, container, false);

        String[] clothNames = new String[Cloth.favoritesItems.size()];
        for (int i = 0; i < clothNames.length; i++) {
            clothNames[i] = Cloth.favoritesItems.get(i).getName();
        }

        int[] clothImages = new int[Cloth.favoritesItems.size()];
        for (int i = 0; i < clothImages.length; i++) {
            clothImages[i] = Cloth.favoritesItems.get(i).getImageResourceId();
        }

        adapter = new CaptionedImagesAdapter(clothNames, clothImages);
        clothRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        clothRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), FavoritesDetailActivity.class);
                intent.putExtra(FavoritesDetailActivity.EXTRA_CLOTH_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return clothRecycler;
    }

    @Override
    public void onResume() {
        super.onResume();
        String[] clothNames = new String[Cloth.favoritesItems.size()];
        for (int i = 0; i < clothNames.length; i++) {
            clothNames[i] = Cloth.favoritesItems.get(i).getName();
        }

        int[] clothImages = new int[Cloth.favoritesItems.size()];
        for (int i = 0; i < clothImages.length; i++) {
            clothImages[i] = Cloth.favoritesItems.get(i).getImageResourceId();
        }

        adapter = new CaptionedImagesAdapter(clothNames, clothImages);
        clothRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        clothRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), FavoritesDetailActivity.class);
                intent.putExtra(FavoritesDetailActivity.EXTRA_CLOTH_ID, position);
                getActivity().startActivity(intent);
            }
        });
    }
}