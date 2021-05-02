package com.hfad.clothstore.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.clothstore.CartDetailActivity;
import com.hfad.clothstore.R;
import com.hfad.clothstore.adapters.CaptionedImagesAdapter;
import com.hfad.clothstore.hardcoded.Cloth;

public class CartFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

}