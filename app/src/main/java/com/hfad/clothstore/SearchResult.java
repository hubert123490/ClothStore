package com.hfad.clothstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.hfad.clothstore.fragments.SearchResultFragment;

public class SearchResult extends AppCompatActivity {
    public static final String EXTRA_CLOTH_TYPE = "clothType";
    public static final String EXTRA_CLOTH_GENDER = "clothGender";
    private String type;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        type = intent.getStringExtra(EXTRA_CLOTH_TYPE);
        gender = intent.getStringExtra(EXTRA_CLOTH_GENDER);

        setContentView(R.layout.activity_search_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}