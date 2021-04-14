package com.hfad.clothstore.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hfad.clothstore.SearchResult;
import com.hfad.clothstore.hardcoded.Cloth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class SearchFragmentChildren extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HashSet<String> names = new HashSet<String>();

        for (Cloth item: Cloth.clothes
        ) {
            if(item.getGender().equals("children")){
                names.add(item.getType());
            }
        }

        ArrayList<String> finalNames = new ArrayList<String>(names);
        Collections.sort(finalNames);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1, finalNames
        );
        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        String type = getListView().getItemAtPosition(position).toString();
        Intent intent = new Intent(getActivity(), SearchResult.class);
        intent.putExtra(SearchResult.EXTRA_CLOTH_TYPE, type);
        intent.putExtra(SearchResult.EXTRA_CLOTH_GENDER, "children");
        startActivity(intent);
    }
}