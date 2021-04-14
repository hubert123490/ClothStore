package com.hfad.clothstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.clothstore.fragments.CartFragment;
import com.hfad.clothstore.hardcoded.Cloth;

public class CartDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CLOTH_ID = "clothId";
    private int clothGlobalId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int clothId = (Integer)getIntent().getExtras().get(EXTRA_CLOTH_ID);
        clothGlobalId = clothId;
        String clothName = Cloth.cartItems.get(clothId).getName();
        TextView textView = findViewById(R.id.cloth_text);
        textView.setText(clothName);

        int clothImage = Cloth.cartItems.get(clothId).getImageResourceId();
        ImageView imageView = findViewById(R.id.cloth_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, clothImage));
        imageView.setContentDescription(clothName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void onDeleteFromCart(View view) {
            Cloth.cartItems.remove(clothGlobalId);
            finish();
    }
}