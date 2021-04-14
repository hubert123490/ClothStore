package com.hfad.clothstore.hardcoded;

import com.hfad.clothstore.R;

import java.util.ArrayList;

public class Cloth {
    private String name;
    private int imageResourceId;
    private String gender;
    private String type;
    public static ArrayList<Cloth> cartItems = new ArrayList<>();
    public static ArrayList<Cloth> favoritesItems = new ArrayList<>();
    public static final Cloth[] clothes = {
            new Cloth("T shirt", R.drawable.t_shirt, "shirt", "male"),
            new Cloth("Top", R.drawable.top_woman, "top",  "female"),
            new Cloth("T-shirt", R.drawable.jeans, "shirt",  "female"),
            new Cloth("Top", R.drawable.shirt, "shirt",  "male"),
            new Cloth("Dress", R.drawable.jeans, "jeans", "female"),
            new Cloth("Shirt", R.drawable.shirt, "shirt", "children"),
            new Cloth("Jeans", R.drawable.jeans, "jeans","children"),
            new Cloth("Jacket", R.drawable.jacket, "jacket", "female"),
            new Cloth("Shirt", R.drawable.shirt, "shirt", "male")
    };

    private Cloth(String name, int imageResourceId, String type, String gender) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.type = type;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }
}
