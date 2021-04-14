package com.hfad.clothstore.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.hfad.clothstore.ClothDetailActivity;
import com.hfad.clothstore.SearchResult;
import com.hfad.clothstore.hardcoded.Cloth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchFragmentWomen extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HashSet<String> names = new HashSet<String>();

        for (Cloth item: Cloth.clothes
             ) {
            if(item.getGender().equals("female")){
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
        intent.putExtra(SearchResult.EXTRA_CLOTH_GENDER, "female");
        startActivity(intent);
    }
}
