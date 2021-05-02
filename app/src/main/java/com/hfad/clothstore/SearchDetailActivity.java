package com.hfad.clothstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.clothstore.hardcoded.Cloth;

import java.util.ArrayList;

public class SearchDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CLOTH_ID = "clothId";
    public static final String EXTRA_CLOTH = "clothReceived";
    private int clothGlobalId;
    private Cloth clothReceived;
    private ArrayList<Cloth> clothesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int clothId = (Integer)getIntent().getExtras().get(EXTRA_CLOTH_ID);
        clothReceived = (Cloth)getIntent().getExtras().get(EXTRA_CLOTH);
        clothGlobalId = clothId;
        String clothName = clothReceived.getName();
        TextView textView = findViewById(R.id.cloth_text);
        textView.setText(clothName);

        int clothImage = clothReceived.getImageResourceId();
        ImageView imageView = findViewById(R.id.cloth_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, clothImage));
        imageView.setContentDescription(clothName);


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void onCartClicked(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm adding to cart")
                .setMessage("Do you really want to add this item to your cart?")
                .setPositiveButton(R.string.alert_dialog_confirm, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(SearchDetailActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
                        Cloth.cartItems.add(clothReceived);
                    }})
                .setNegativeButton(R.string.alert_dialog_decline, null).show();
    }

    public void onFavoritesClicked(View view) {
        Cloth.favoritesItems.add(clothReceived);
    }
}