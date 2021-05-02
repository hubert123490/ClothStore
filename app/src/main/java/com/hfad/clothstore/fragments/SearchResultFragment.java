package com.hfad.clothstore.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.clothstore.ClothDetailActivity;
import com.hfad.clothstore.R;
import com.hfad.clothstore.SearchDetailActivity;
import com.hfad.clothstore.SearchResult;
import com.hfad.clothstore.adapters.CaptionedImagesAdapter;
import com.hfad.clothstore.hardcoded.Cloth;

import java.util.ArrayList;


public class SearchResultFragment extends Fragment {
    private ArrayList<Cloth> clothes;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        RecyclerView clothRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_search_result, container, false);
        clothes = new ArrayList<Cloth>();

        SearchResult activity = (SearchResult) getActivity();
        String type = activity.getType();
        String gender = activity.getGender();

        for (Cloth item: Cloth.clothes
        ) {
            if(item.getGender().equals(gender) && item.getType().equals(type)){
                clothes.add(item);
            }
        }


        String[] clothNames = new String[clothes.size()];
        for (int i = 0; i < clothNames.length; i++){
            clothNames[i] = clothes.get(i).getName();
        }

        int[] clothImages = new int[clothes.size()];
        for (int i = 0; i < clothImages.length; i++){
            clothImages[i] = clothes.get(i).getImageResourceId();
        }

        double[] clothPrices = new double[Cloth.cartItems.size()];
        for (int i = 0; i < clothImages.length; i++){
            clothPrices[i] = Cloth.cartItems.get(i).getPrice();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(clothNames, clothImages, clothPrices);
        clothRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        clothRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SearchDetailActivity.class);
                intent.putExtra(SearchDetailActivity.EXTRA_CLOTH_ID, position);
                intent.putExtra(SearchDetailActivity.EXTRA_CLOTH, clothes.get(position));
                getActivity().startActivity(intent);
            }
        });
        return clothRecycler;
    }
}