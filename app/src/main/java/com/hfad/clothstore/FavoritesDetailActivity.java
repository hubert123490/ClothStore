package com.hfad.clothstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.clothstore.hardcoded.Cloth;

public class FavoritesDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CLOTH_ID = "clothId";
    private int clothGlobalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int clothId = (Integer)getIntent().getExtras().get(EXTRA_CLOTH_ID);
        clothGlobalId = clothId;
        String clothName = Cloth.favoritesItems.get(clothId).getName();
        TextView textView = findViewById(R.id.cloth_text);
        textView.setText(clothName);

        int clothImage = Cloth.favoritesItems.get(clothId).getImageResourceId();
        ImageView imageView = findViewById(R.id.cloth_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, clothImage));
        imageView.setContentDescription(clothName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void onDeleteFromFavorites(View view) {
        Cloth.favoritesItems.remove(clothGlobalId);
        finish();
    }
}