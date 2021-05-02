package com.hfad.clothstore.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.clothstore.ClothDetailActivity;
import com.hfad.clothstore.R;
import com.hfad.clothstore.adapters.CaptionedImagesAdapter;
import com.hfad.clothstore.hardcoded.Cloth;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        RecyclerView clothRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_home, container, false);

        String[] clothNames = new String[Cloth.clothes.length];
        for (int i = 0; i < clothNames.length; i++){
            clothNames[i] = Cloth.clothes[i].getName();
        }

        int[] clothImages = new int[Cloth.clothes.length];
        for (int i = 0; i < clothImages.length; i++){
            clothImages[i] = Cloth.clothes[i].getImageResourceId();
        }

        double[] clothPrices = new double[Cloth.clothes.length];
        for (int i = 0; i < clothImages.length; i++){
            clothPrices[i] = Cloth.clothes[i].getPrice();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(clothNames, clothImages, clothPrices);
        clothRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        clothRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ClothDetailActivity.class);
                intent.putExtra(ClothDetailActivity.EXTRA_CLOTH_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return clothRecycler;
    }
}